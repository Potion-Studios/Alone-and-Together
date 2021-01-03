package corgiaoc.aloneandtogether.common.world.feature;

import com.mojang.serialization.Codec;
import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.Tags;

import java.util.Random;

public class NoisySphere extends Feature<NoisySphereConfig> {

    public static int stopSpamInt = 0;
    protected static FastNoise fastNoise;
    protected long seed;

    public NoisySphere(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed());

        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(position.down(2 + random.nextInt(10)));
        BlockPos.Mutable mutable2 = new BlockPos.Mutable().setPos(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int xRadius = config.getRandomXRadius(random);
        int yRadius = config.getRandomYRadius(random);
        int zRadius = config.getRandomZRadius(random);


        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {

            for (int x = -xRadius; x <= xRadius; x++) {
                for (int y = -yRadius; y <= yRadius; y++) {
                    for (int z = -zRadius; z <= zRadius; z++) {

                        mutable2.setPos(mutable).move(x, y, z);

                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow(xRadius, 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        if (equationResult >= 1 + 0.7 * fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ()))
                            continue;


                        BlockState blockState = world.getBlockState(mutable2);
                        if (this.canBlockPlaceHere(blockState))
                            world.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), 3);
                    }
                }
            }

            xRadius = (int) (xRadius / config.getRadiusDivisorPerStack());
            yRadius = (int) (yRadius / config.getRadiusDivisorPerStack());
            zRadius = (int) (zRadius / config.getRadiusDivisorPerStack());
        }
        return true;
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            fastNoise.SetFrequency(0.09f);
            this.seed = seed;
        }
    }

    private boolean canBlockPlaceHere(BlockState state) {
        return state.isAir() || state.getMaterial() == Material.EARTH || state.getMaterial() == Material.PLANTS ||
                state.getMaterial() == Material.TALL_PLANTS || state.getMaterial() == Material.LEAVES ||
                state.getMaterial() == Material.SAND || state.getMaterial() == Material.BAMBOO || state.getMaterial() == Material.CACTUS
                || state.getMaterial() == Material.WATER || state.getMaterial() == Material.LAVA || state.isIn(Tags.Blocks.DIRT);
    }
}