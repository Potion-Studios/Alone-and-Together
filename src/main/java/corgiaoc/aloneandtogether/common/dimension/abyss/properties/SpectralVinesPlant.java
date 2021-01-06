package corgiaoc.aloneandtogether.common.dimension.abyss.properties;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;

import java.util.Random;

public class SpectralVinesPlant extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SpectralVinesPlant(AbstractBlock.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);

    }

    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock)ATBlocks.SPECTRAL_VINES;
    }
}

