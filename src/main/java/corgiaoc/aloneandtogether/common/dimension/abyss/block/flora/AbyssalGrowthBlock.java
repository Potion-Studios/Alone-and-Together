package corgiaoc.aloneandtogether.common.dimension.abyss.block.flora;

import corgiaoc.aloneandtogether.common.block.ATFernBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.state.properties.BlockStateProperties.LIT;

//todo: add functionality
public class AbyssalGrowthBlock extends ATFernBlock {
    private static final VoxelShape SHAPE = makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);

    public AbyssalGrowthBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState().with(LIT, false));
    }

    @ParametersAreNonnullByDefault
    @Override
    public @Nonnull VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @ParametersAreNonnullByDefault
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader reader, BlockPos pos) {
        return super.isValidGround(state, reader, pos) || state.isIn(BlockTags.LOGS);
    }

    @Override
    public @Nonnull OffsetType getOffsetType() {
        return OffsetType.NONE;
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }


    public static boolean isLit(@Nonnull BlockState state) {
        return state.get(LIT);
    }
}
