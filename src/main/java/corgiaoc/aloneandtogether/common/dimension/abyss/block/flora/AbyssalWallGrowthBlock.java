package corgiaoc.aloneandtogether.common.dimension.abyss.block.flora;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.state.properties.BlockStateProperties.HORIZONTAL_FACING;
// y
public class AbyssalWallGrowthBlock extends AbyssalGrowthBlock {

    public AbyssalWallGrowthBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@Nonnull BlockItemUseContext context) {
        return getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader reader, BlockPos pos) {
        BlockPos behind = pos.offset(state.get(HORIZONTAL_FACING).getOpposite());
        return isValidGround(reader.getBlockState(behind), reader, behind);
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(HORIZONTAL_FACING);
    }
}
