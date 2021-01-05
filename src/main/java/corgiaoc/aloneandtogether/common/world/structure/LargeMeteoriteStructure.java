package corgiaoc.aloneandtogether.common.world.structure;

import com.mojang.serialization.Codec;
import corgiaoc.aloneandtogether.AloneAndTogether;
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
            this.seed = seed;
        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistry, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoisySphereConfig config) {
            setSeed(seed, config.getNoiseFrequency());
            int xCoord = chunkX * 16;
            int zCoord = chunkZ * 16;


            BlockPos startPos = new BlockPos(xCoord, 64, zCoord);
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            AloneAndTogether.LOGGER.info("Start pos: " + startPos.getCoordinatesAsString());

            int xRadius = config.getRandomXRadius(random);
            int yRadius = config.getRandomYRadius(random);
            int zRadius = config.getRandomZRadius(random);

            int xComponentMove = (xRadius / 16) + 1;
            int yComponentMove = (yRadius / 16) + 1;
            int zComponentMove = (zRadius / 16) + 1;

            this.bounds.minX = startPos.getX() - xRadius;
            this.bounds.minY = startPos.getY() - yRadius;
            this.bounds.minZ = startPos.getZ() - zRadius;

            this.bounds.maxX = startPos.getX() + xRadius;
            this.bounds.maxY = startPos.getY() + yRadius;
            this.bounds.maxZ = startPos.getZ() + zRadius;

            for (int x = -xComponentMove; x <= xComponentMove; x++) {
                for (int z = -zComponentMove; z <= zComponentMove; z++) {
                    for (int y = -yComponentMove; y <= yComponentMove; y++) {
                        mutable.setPos(startPos.getX() + (x * 16), startPos.getY() + (y * 16), startPos.getZ() + (z * 16));
                        this.components.add(new MeteoritePiece(new MeteoriteDataHelper(x * 16, y * 16, z * 16, xRadius, yRadius, zRadius), config, mutable.toImmutable()));

                    }
                }
            }
            this.recalculateStructureSize();
        }


        public void setSeed(long seed, double noiseFrequency) {
            if (this.seed != seed || fastNoise == null) {
                fastNoise = new FastNoise((int) seed);
                fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
                fastNoise.SetFrequency(0.045F);
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

            boolean isHighestIteration = currentRadiusData.getYCurrentRadius() + 16 > yRadius;


            for (int x = 0; x < 16; x++) {
                int[][] topY = new int[17][17];
                for (int z = 0; z < 16; z++) {
                    for (int y = 0; y < 16; y++) {
                        int currentXRadius = currentRadiusData.getXCurrentRadius() + x;
                        int currentYRadius = currentRadiusData.getYCurrentRadius() + y;
                        int currentZRadius = currentRadiusData.getZCurrentRadius() + z;


                        if (currentXRadius >= xRadius || currentYRadius >= yRadius || currentZRadius >= zRadius)
                            continue;

                        mutable2.setPos(mutable).move(x, y, z);

                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(currentXRadius, 2) / Math.pow(xRadius, 2) + Math.pow(currentYRadius, 2) / Math.pow(yRadius, 2) + Math.pow(currentZRadius, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.95 * Start.fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        if (equationResult >= threshold)
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

        private final int xCurrentRadius;
        private final int yCurrentRadius;
        private final int zCurrentRadius;

        private final int xRadius;
        private final int yRadius;
        private final int zRadius;

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

        public int getYCurrentRadius() {
            return yCurrentRadius;
        }

        public int getZCurrentRadius() {
            return zCurrentRadius;
        }

        public int getXRadius() {
            return xRadius;
        }

        public int getYRadius() {
            return yRadius;
        }

        public int getZRadius() {
            return zRadius;
        }
    }
}