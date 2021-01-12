package corgiaoc.aloneandtogether.common.dimension.abyss.block;

import corgiaoc.aloneandtogether.common.block.ATFernBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class AbyssalGrowthBlock extends ATFernBlock {
    private static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);

    public AbyssalGrowthBlock() {
        super(Properties.from(Blocks.GRASS).notSolid().setLightLevel((state) -> 8));
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Nonnull
    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
