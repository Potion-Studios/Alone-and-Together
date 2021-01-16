package corgiaoc.aloneandtogether.common.dimension.abyss.block;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

public class SpectralVinesPlantBlock extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SpectralVinesPlantBlock(AbstractBlock.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);

    }

    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock)ATBlocks.SPECTRAL_VINES;
    }
}

