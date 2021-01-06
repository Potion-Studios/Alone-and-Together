package corgiaoc.aloneandtogether.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TreeParserUtils {


    public static final String FILE_BLUEPRINT = "import com.mojang.serialization.Codec;\n" +
            "import corgiaoc.aloneandtogether.common.world.feature.config.ATTreeConfig;\n" +
            "import corgiaoc.aloneandtogether.common.world.feature.tree.util.ATAbstractTreeFeature;\n" +
            "import net.minecraft.util.math.BlockPos;\n" +
            "import net.minecraft.util.math.MutableBoundingBox;\n" +
            "import net.minecraft.world.ISeedReader;\n" +
            "\n" +
            "import java.util.Random;\n" +
            "import java.util.Set;\n" +
            "\n" +
            "public class EmptyTree extends ATAbstractTreeFeature<ATTreeConfig> {\n" +
            "\n" +
            "    public EmptyTree(Codec<ATTreeConfig> configIn) {\n" +
            "        super(configIn);\n" +
            "    }\n" +
            "\n" +
            "    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, ATTreeConfig config) {\n" +
            "\n" +
            "        int randTreeHeight = rth/*config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight())*/;\n" +
            "        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);\n" +
            "\n" +
            "        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {\n" +
            "            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {\n" +
            "                return false;\n" +
            "            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {\n" +
            "                return false;\n" +
            "            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {\n" +
            "                return false;\n" +
            "            } else {\n" +
            "            filler" +
            "data\n" +
            "            }\n" +
            "        }\n" +
            "        return true;\n" +
            "    }\n" +
            "}";


    public static void processTreeNBTData(IServerWorld world, BlockPos featureStartPos, List<Pair<BlockPos, CompoundNBT>> list2) {
        translateTreeNBTData(world, featureStartPos, list2, 37, true);
    }

    public static void translateTreeNBTData(IServerWorld world, BlockPos featureStartPos, List<Pair<BlockPos, CompoundNBT>> list2, int treeHeight, boolean useRandTreeHeight) {
        List<String> treeLeaveList = new ArrayList<>();
        List<String> trunkLogList = new ArrayList<>();
        List<String> treeBranchList = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        StringBuilder trunkFillerBuilder = new StringBuilder();

        trunkFillerBuilder.append("buildTrunkBase(pos, changedBlocks, worldIn, config, rand, boundsIn, ");
        list2.forEach(o -> {
            int featureX = o.getFirst().getX();
            int featureY = o.getFirst().getY();
            int featureZ = o.getFirst().getZ();

            BlockPos pos = new BlockPos(featureX, featureY, featureZ);
            BlockState state = world.getBlockState(o.getFirst());


            boolean trunk1x1 = pos.getX() == 0 && pos.getZ() == 0;
            boolean trunk2x2 =  pos.getX() == 0 && pos.getZ() == 1 || pos.getX() == 0 && pos.getZ() == -1 || pos.getX() == 1 && pos.getZ() == 0 || pos.getX() == -1 && pos.getZ() == 0;
            boolean trunkCross = pos.getX() == 0 && pos.getZ() == 0 || pos.getX() == 1 && pos.getZ() == 0 || pos.getX() == -1 && pos.getZ() == 0 || pos.getX() == 0 && pos.getZ() == 1 || pos.getX() == 0 && pos.getZ() == -1;


            Block blockCheck = state.getBlock();
            int nbtY = featureY - 100;

            String modifiedY = String.valueOf(nbtY);

            if (useRandTreeHeight) {
                if (treeHeight > nbtY)
                    modifiedY = "randTreeHeight - " + (treeHeight - nbtY);
                else if (treeHeight < nbtY)
                    modifiedY = "randTreeHeight + " + Math.abs(nbtY - treeHeight);
                else
                    modifiedY = "randTreeHeight";
            }


            if (blockCheck.getRegistryName().toString().contains("log")) {
                if (nbtY == 0)
                    trunkFillerBuilder.append("mainmutable.setPos(pos).move(").append(featureX).append(", ").append(0).append(", ").append(featureZ).append(").toImmutable(), ");


                if (trunk1x1){
                    trunkLogList.add("\t\t\t\tplaceTrunk(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(" + featureX + ", " + nbtY + ", " + featureZ + "), boundsIn);\n");
                } else {
                    treeBranchList.add("\t\t\t\tplaceBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(" + featureX + ", " + modifiedY + ", " + featureZ + "), boundsIn);\n");
                }
            }

            if (state.hasProperty(LeavesBlock.DISTANCE) && state.get(LeavesBlock.DISTANCE) <= 6) {
                if (blockCheck.getRegistryName().toString().contains("leaves")) {
                    treeLeaveList.add("\t\t\t\tplaceLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(" + featureX + ", " + modifiedY + ", " + featureZ + "), boundsIn);\n");
                }
            }
        });

        trunkFillerBuilder.append(");");


        trunkLogList.forEach(builder::append);
        treeBranchList.forEach(builder::append);
        treeLeaveList.forEach(builder::append);

        generateTreeFile(builder.toString(), trunkFillerBuilder.toString().replace(", );", ");"), "SpectralTree1", true, featureStartPos.getY() - 100, 48, treeHeight);
    }

    static String cachePrevious = "";

    private static void generateTreeFile(String fileData, String fillerData, String treeName, boolean processAsJavaFile, int featureY, int nbtYsize, int treeHeight) {
        String output = FILE_BLUEPRINT;
        output = output.replace("data", fileData + "\n data2");
        output = output.replace("EmptyTree", treeName);
        output = output.replace("rth", String.valueOf(treeHeight));
        output = output.replace("filler", "\t" + fillerData);

        if (featureY == nbtYsize)
            output = cachePrevious.replace("data2", fileData);

        if (processAsJavaFile) {
            try {
                Path file = FMLPaths.CONFIGDIR.get().resolve(treeName + ".java");
                Files.createDirectories(file.getParent());
                Files.write(file, output.getBytes());
                cachePrevious = output;
            } catch (IOException e) {

            }
        } else {
            try {
                Path file = FMLPaths.CONFIGDIR.get().resolve("tree_output.txt");
                Files.createDirectories(file.getParent());
                Files.write(file, fileData.getBytes());
            } catch (IOException e) {

            }
        }
    }


}
