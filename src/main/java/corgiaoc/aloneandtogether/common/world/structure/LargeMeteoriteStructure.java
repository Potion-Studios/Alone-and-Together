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

            int xRadius = config.getRandomXRadius(random);
            int yRadius = config.getRandomYRadius(random);
            int zRadius = config.getRandomZRadius(random);

            int xCurrentRadius = -xRadius;
            int yCurrentRadius = -yRadius;
            int zCurrentRadius = -zRadius;

            MeteoriteDataHelper meteoriteDataHelper = new MeteoriteDataHelper(xCurrentRadius, yCurrentRadius, zCurrentRadius, xRadius, yRadius, zRadius);

            int xComponentMove = (xRadius / 16) + 1;
            int yComponentMove = (yRadius / 16) + 1;
            int zComponentMove = (yRadius / 16) + 1;
            this.getBoundingBox().minY = 128; //Set the start Y

            int idx = -1;
            for (int x = -xComponentMove; x < xComponentMove; x++) {
                for (int z = -zComponentMove; z < zComponentMove; z++) {
                    for (int y = -yComponentMove; y < yComponentMove; y++) {
                        meteoriteDataHelper.setXCurrentRadius(meteoriteDataHelper.getXCurrentRadius() + 16);
                        meteoriteDataHelper.setYCurrentRadius(meteoriteDataHelper.getYCurrentRadius() + 16);
                        meteoriteDataHelper.setZCurrentRadius(meteoriteDataHelper.getZCurrentRadius() + 16);
                        this.components.add(new MeteoritePiece(meteoriteDataHelper, config));
                        idx++;
                        if (idx > 0) {
                            StructurePiece structurePiece = this.components.get(idx);
                            structurePiece.offset(x + 16, y + 16, z + 16);
                        }
                    }
                }
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

        private MeteoriteDataHelper currentRadiusData;
        private NoisySphereConfig config;

        public MeteoritePiece(MeteoriteDataHelper currentRadiusData, NoisySphereConfig config) {
            super(ATStructures.METEORITE_PIECE, 0);
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
            BlockPos.Mutable mutable = new BlockPos.Mutable(this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ);
            BlockPos.Mutable mutable2 = new BlockPos.Mutable().setPos(mutable);

            int xRange = currentRadiusData.getXCurrentRadius();
            int yRange = currentRadiusData.getYCurrentRadius();
            int zRange = currentRadiusData.getZCurrentRadius();

            int xRadius = currentRadiusData.getXRadius();
            int yRadius = currentRadiusData.getYRadius();
            int zRadius = currentRadiusData.getZRadius();

            boolean isHighestIteration = yRange + 16 > yRadius;


            for (int x = xRange; x <= xRange + 16; x++) {
                int[][] topY = new int[xRange * 2 + 1][zRange * 2 + 1];
                for (int z = -zRange; z <= zRange + 16; z++) {
                    for (int y = -yRange; y <= yRange + 16; y++) {
                        mutable2.setPos(mutable).move(x, y, z);

                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow(xRadius, 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        if (equationResult >= 1 + 0.7 * Start.fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ()))
                            continue;

                        world.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), 2);

                        if (isHighestIteration) {
                            if (topY[x + xRadius][z + zRadius] < mutable2.getY()) {
                                topY[x + xRadius][z + zRadius] = mutable2.getY();
                            }
                        }
                    }
                    if (isHighestIteration) {
                        BlockPos.Mutable tempMutable = new BlockPos.Mutable().setPos(mutable2);
                        tempMutable.setY(topY[x + xRadius][z + zRadius] + 1);
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