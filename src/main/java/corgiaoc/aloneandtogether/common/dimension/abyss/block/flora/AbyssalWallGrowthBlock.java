package corgiaoc.aloneandtogether.common.dimension.abyss.block.flora;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.state.properties.BlockStateProperties.HORIZONTAL_FACING;
import static net.minecraft.state.properties.BlockStateProperties.LIT;

public class AbyssalWallGrowthBlock extends AbyssalGrowthBlock {
    private static final VoxelShape[] SHAPES = {
            makeCuboidShape( 0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D),
            makeCuboidShape( 0.0D, 0.0D,  0.0D,  2.0D, 16.0D, 16.0D),
            makeCuboidShape( 0.0D, 0.0D,  0.0D, 16.0D, 16.0D,  2.0D),
            makeCuboidShape(14.0D, 0.0D,  0.0D, 16.0D, 16.0D, 16.0D)
    };

    public AbyssalWallGrowthBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState().with(LIT, false).with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @ParametersAreNonnullByDefault
    @Override
    public @Nonnull VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        switch (getFacing(state)) {
            case NORTH: return SHAPES[0];
            case EAST:  return SHAPES[1];
            case SOUTH: return SHAPES[2];
            default:    return SHAPES[3];
        }
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@Nonnull BlockItemUseContext context) {
        return getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader reader, BlockPos pos) {
        BlockPos behind = pos.offset(getFacing(state).getOpposite());
        return isValidGround(reader.getBlockState(behind), reader, behind);
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT, HORIZONTAL_FACING);
    }

    private static @Nonnull Direction getFacing(@Nonnull BlockState state) {
        return state.get(HORIZONTAL_FACING);
    }
}
