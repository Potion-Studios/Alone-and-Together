package corgiaoc.aloneandtogether.common.block;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
public class ATFernBlock extends BushBlock implements IFlammableBlock {
    private static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public ATFernBlock() {
        this(Properties.from(Blocks.GRASS).notSolid());
    }

    public ATFernBlock(Properties properties) {
        super(properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return super.isValidGround(state, worldIn, pos) ||
                        state.isIn(ATBlocks.OVERGROWN_VOIDSTONE) ||
                        state.isIn(BlockTags.NYLIUM) ||
                        state.isIn(Blocks.MYCELIUM);
    }

    @ParametersAreNonnullByDefault
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XYZ;
    }

    @Override
    public int[] getFlammability() {
        return new int[] {60, 100};
    }
}

