package corgiaoc.aloneandtogether.common.world.feature.tree.util;

import com.mojang.serialization.Codec;
import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.block.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class NBTStructure extends Feature<NoFeatureConfig> {

    public NBTStructure(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        pos = new BlockPos(pos.getX(), 100, pos.getZ());

        if (pos.getX() == -8 && pos.getZ() == -9 && pos.getY() == 100) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 100; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlockState(block, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }

            TemplateManager templatemanager = world.getWorld().getStructureTemplateManager();
            Template template = templatemanager.getTemplate(new ResourceLocation(AloneAndTogether.MOD_ID, "features/trees/tall_spectral_tree3"));
//            Template template2 = templatemanager.getTemplate(new ResourceLocation(AloneAndTogether.MOD_ID, "features/trees/tall_spectral_tree3_piece_2"));

            if (template == null /*|| template2 == null*/) {
                AloneAndTogether.LOGGER.warn("NBT does not exist!");
                return false;
            }

            PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk(null);
            template.func_237144_a_(world, pos, placementsettings, rand);
//            template2.func_237144_a_(world, pos.up(48), placementsettings, rand);
            return true;
        }
        return false;
    }
}