package corgiaoc.aloneandtogether.common.world.structure;

import com.mojang.serialization.Codec;
import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.core.world.ATStructures;
import corgiaoc.aloneandtogether.util.noise.fastnoise.FastNoise;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class LargeMeteoriteStructure extends Structure<NoisySphereConfig> {
    public LargeMeteoriteStructure(Codec<NoisySphereConfig> codec) {
        super(codec);
    }

    @Override
    public IStartFactory<NoisySphereConfig> getStartFactory() {
        return Start::new;
    }

    public static class Start extends StructureStart<NoisySphereConfig> {

        private final long seed;
        protected static FastNoise fastNoise;
        protected static Random random;


        public Start(Structure<NoisySphereConfig> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
            setSeed(seed);
            this.seed = seed;
        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistry, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoisySphereConfig config) {
            int xCoord = chunkX * 16;
            int zCoord = chunkZ * 16;


            BlockPos startPos = new BlockPos(xCoord, 64, zCoord);
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            int xRadius = config.getRandomXRadius(random);
            int yRadius = config.getRandomYRadius(random);
            int zRadius = config.getRandomZRadius(random);

            int xCurrentRadius = -xRadius;
            int yCurrentRadius = -yRadius;
            int zCurrentRadius = -zRadius;

            MeteoriteDataHelper meteoriteDataHelper = new MeteoriteDataHelper(xCurrentRadius, yCurrentRadius, zCurrentRadius, xRadius, yRadius, zRadius);

            int xComponentMove = (xRadius / 16) + 1;
            int yComponentMove = (yRadius / 16) + 1;
            int zComponentMove = (zRadius / 16) + 1;

            this.bounds.minX = startPos.getX() - xRadius;
            this.bounds.minY = startPos.getY() - yRadius;
            this.bounds.minZ = startPos.getZ() - zRadius;

            this.bounds.maxX = startPos.getX() + xRadius;
            this.bounds.maxY = startPos.getY() + yRadius;
            this.bounds.maxZ = startPos.getZ() + zRadius;

            int moveX = 0;
            for (int x = -xComponentMove; x < xComponentMove; x++) {
                meteoriteDataHelper.setXCurrentRadius(-xRadius + moveX);
                int moveZ = 0;
                for (int z = -zComponentMove; z < zComponentMove; z++) {
                    meteoriteDataHelper.setZCurrentRadius(-zRadius + moveZ);
                    int moveY = 0;
                    for (int y = -yComponentMove; y < yComponentMove; y++) {
                        mutable.setPos(startPos.getX() + moveX, startPos.getY() + moveY, startPos.getZ() + moveZ);
                        meteoriteDataHelper.setYCurrentRadius(-yRadius + moveY);
                        this.components.add(new MeteoritePiece(meteoriteDataHelper, config, mutable.toImmutable()));
                        moveY += 16;

                    }
                    moveZ += 16;
                }
                moveX += 16;
            }
            this.recalculateStructureSize();
        }


        public void setSeed(long seed) {
            if (this.seed != seed || fastNoise == null) {
                fastNoise = new FastNoise((int) seed);
                fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
                fastNoise.SetFrequency(0.09f);
                random = new Random(seed);
            }
        }
    }

    public static class MeteoritePiece extends StructurePiece {

        private BlockPos pos;
        private MeteoriteDataHelper currentRadiusData;
        private NoisySphereConfig config;

        public MeteoritePiece(MeteoriteDataHelper currentRadiusData, NoisySphereConfig config, BlockPos pos) {
            super(ATStructures.METEORITE_PIECE, 0);
            this.pos = pos;
            this.boundingBox = new MutableBoundingBox(pos, pos);
            this.currentRadiusData = currentRadiusData;
            this.config = config;
        }

        public MeteoritePiece(CompoundNBT nbt) {
            super(ATStructures.METEORITE_PIECE, nbt);
        }

        @Override
        protected void readAdditional(CompoundNBT tagCompound) {

        }

        @Override
        public boolean func_230383_a_(ISeedReader world, StructureManager structureManager, ChunkGenerator generator, Random random, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            if (pos == null)
                return false;

            BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);
            BlockPos.Mutable mutable2 = new BlockPos.Mutable().setPos(mutable);


            int xRadius = currentRadiusData.getXRadius();
            int yRadius = currentRadiusData.getYRadius();
            int zRadius = currentRadiusData.getZRadius();

            int xCurrentRadius = currentRadiusData.getXCurrentRadius() - xRadius;
            int yCurrentRadius = currentRadiusData.getYCurrentRadius() - yRadius;
            int zCurrentRadius = currentRadiusData.getZCurrentRadius() - zRadius;

            boolean isHighestIteration = yCurrentRadius + 16 > yRadius;


            for (int x = 0; x < 16; x++) {
                int[][] topY = new int[17][17];
                for (int z = 0; z < 16; z++) {
                    for (int y = 0; y < 16; y++) {
                        mutable2.setPos(mutable).move(x, y, z);

                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(xCurrentRadius + x, 2) / Math.pow(xRadius, 2) + Math.pow(yCurrentRadius + y, 2) / Math.pow(yRadius, 2) + Math.pow(zCurrentRadius + z, 2) / Math.pow(zRadius, 2);
                         if (equationResult >= 1 + 0.7 * Start.fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ()))
                            continue;

                        world.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), 2);


                        if (isHighestIteration) {
                            if (topY[x][z] < mutable2.getY()) {
                                topY[x][z] = mutable2.getY();
                            }
                        }
                    }
                    if (isHighestIteration) {
                        BlockPos.Mutable tempMutable = new BlockPos.Mutable().setPos(mutable2);
                        tempMutable.setY(topY[x][z] + 1);
                        if (tempMutable.getY() > mutable.getY() + -yRadius)
                            world.setBlockState(tempMutable, config.getTopBlockProvider().getBlockState(random, mutable2), 2);
                    }
                }
            }
            return true;
        }
    }

    public static class MeteoriteDataHelper {

        private int xCurrentRadius;
        private int yCurrentRadius;
        private int zCurrentRadius;

        private int xRadius;
        private int yRadius;
        private int zRadius;

        public MeteoriteDataHelper(int xCurrentRadius, int yCurrentRadius, int zCurrentRadius, int xRadius, int yRadius, int zRadius) {
            this.xCurrentRadius = xCurrentRadius;
            this.yCurrentRadius = yCurrentRadius;
            this.zCurrentRadius = zCurrentRadius;
            this.xRadius = xRadius;
            this.yRadius = yRadius;
            this.zRadius = zRadius;
        }

        public int getXCurrentRadius() {
            return xCurrentRadius;
        }

        public void setXCurrentRadius(int xCurrentRadius) {
            this.xCurrentRadius = xCurrentRadius;
        }

        public int getYCurrentRadius() {
            return yCurrentRadius;
        }

        public void setYCurrentRadius(int yCurrentRadius) {
            this.yCurrentRadius = yCurrentRadius;
        }

        public int getZCurrentRadius() {
            return zCurrentRadius;
        }

        public int getXRadius() {
            return xRadius;
        }

        public void setxRadius(int xRadius) {
            this.xRadius = xRadius;
        }

        public int getYRadius() {
            return yRadius;
        }

        public void setyRadius(int yRadius) {
            this.yRadius = yRadius;
        }

        public int getZRadius() {
            return zRadius;
        }

        public void setzRadius(int zRadius) {
            this.zRadius = zRadius;
        }

        public void setZCurrentRadius(int zCurrentRadius) {
            this.zCurrentRadius = zCurrentRadius;
        }
    }
}