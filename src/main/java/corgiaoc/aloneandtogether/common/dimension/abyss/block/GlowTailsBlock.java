package corgiaoc.aloneandtogether.common.dimension.abyss.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.state.properties.BlockStateProperties.WATERLOGGED;

public class GlowTailsBlock extends DoublePlantBlock implements IWaterLoggable {

    public GlowTailsBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState()
                .with(HALF, DoubleBlockHalf.LOWER)
                .with(WATERLOGGED, false)
        );
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF, WATERLOGGED);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean canContainFluid(IBlockReader reader, BlockPos pos, BlockState state, Fluid fluid) {
        return !hasFluid(state) && isFluidValid(fluid);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean receiveFluid(IWorld world, BlockPos pos, BlockState state, FluidState fluidState) {
        Fluid fluid = fluidState.getFluid();
        if (!hasFluid(state) && isFluidValid(fluid)) {
            if (!world.isRemote()) {
                world.setBlockState(pos, state.with(WATERLOGGED, true), 3);
                world.getPendingFluidTicks().scheduleTick(pos, fluid, fluid.getTickRate(world));
            }
            return true;
        }
        return false;
    }

    @ParametersAreNonnullByDefault
    @Nonnull
    @Override
    public Fluid pickupFluid(IWorld world, BlockPos pos, BlockState state) {
        if (hasFluid(state)) {
            world.setBlockState(pos, state.with(WATERLOGGED, false), 3);
            return world.getFluidState(pos).getFluid();
        }
        return Fluids.EMPTY;
    }

    private static boolean isFluidValid(Fluid fluid) {
        return fluid == Fluids.WATER || fluid == Fluids.LAVA;
    }

    private static boolean hasFluid(@Nonnull BlockState state) {
        return state.get(WATERLOGGED);
    }
}
