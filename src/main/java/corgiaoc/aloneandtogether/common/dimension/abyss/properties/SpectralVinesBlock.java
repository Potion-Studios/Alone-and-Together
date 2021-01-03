package corgiaoc.aloneandtogether.common.dimension.abyss.properties;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;

import java.util.Random;

public class SpectralVinesBlock extends AbstractTopPlantBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public SpectralVinesBlock(AbstractBlock.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    /**
     * Used to determine how much to grow the plant when using bonemeal. Kelp always returns 1, where as the nether vines
     * return a random value at least 1.
     */
    protected int getGrowthAmount(Random rand) {
        return PlantBlockHelper.getGrowthAmount(rand);
    }

    protected Block getBodyPlantBlock() {
        return ATBlocks.SPECTRAL_VINES;
    }


    protected boolean canGrowIn(BlockState state) {
        return PlantBlockHelper.isAir(state);
    }


}
