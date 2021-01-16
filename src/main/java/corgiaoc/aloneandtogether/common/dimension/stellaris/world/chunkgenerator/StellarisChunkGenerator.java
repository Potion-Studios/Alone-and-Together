package corgiaoc.aloneandtogether.common.dimension.stellaris.world.chunkgenerator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.function.Supplier;

public class StellarisChunkGenerator extends ChunkGenerator {

    public static final Codec<StellarisChunkGenerator> CODEC = RecordCodecBuilder.create((recorder) -> {
        return recorder.group(BiomeProvider.CODEC.fieldOf("biome_source").forGetter((chunkGenerator) -> {
            return chunkGenerator.biomeProvider;
        }), Codec.LONG.fieldOf("seed").stable().forGetter((chunkGenerator) -> {
            return chunkGenerator.seed;
        }), DimensionSettings.field_236098_b_.fieldOf("settings").forGetter((chunkGenerator) -> {
            return chunkGenerator.structureSettings;
        })).apply(recorder, recorder.stable(StellarisChunkGenerator::new));
    });

    private final long seed;
    private final Supplier<DimensionSettings> structureSettings;


    public StellarisChunkGenerator(BiomeProvider biomeSource, long seed, Supplier<DimensionSettings> structureSettings) {
        super(biomeSource, structureSettings.get().getStructures());
        this.seed = seed;
        this.structureSettings = structureSettings;
    }

    @Override
    protected Codec<? extends ChunkGenerator> func_230347_a_() {
        return CODEC;
    }

    @Override
    public ChunkGenerator func_230349_a_(long seed) { //withSeed
        return new StellarisChunkGenerator(this.biomeProvider, seed, this.structureSettings);
    }

    @Override
    public void generateSurface(WorldGenRegion world, IChunk chunk) {
        ChunkPos chunkpos = chunk.getPos();
        int chunkX = chunkpos.x;
        int chunkZ = chunkpos.z;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        sharedseedrandom.setBaseChunkSeed(chunkX, chunkZ);
        int minX = chunkpos.getXStart();
        int minZ = chunkpos.getZStart();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int moveX = 0; moveX < 16; ++moveX) {
            for(int moveZ = 0; moveZ < 16; ++moveZ) {
                int blockX = minX + moveX;
                int blockZ = minZ + moveZ;
                int surfaceY = chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, moveX, moveZ) + 1;
                double noise = 1;
                world.getBiome(mutable.setPos(minX + moveX, surfaceY, minZ + moveZ)).buildSurface(sharedseedrandom, chunk, blockX, blockZ, surfaceY, noise, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), this.getSeaLevel(), world.getSeed());
            }
        }
    }

    @Override
    public void func_230352_b_(IWorld world, StructureManager structureManager, IChunk chunk) { //Populate Noise

    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmapType) {
        return 0;
    }

    @Override
    public IBlockReader func_230348_a_(int x, int z) { //getBaseColumn
        return null;
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }
}
