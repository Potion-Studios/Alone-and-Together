package corgiaoc.aloneandtogether.common.dimension.abyss.block.flora;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.state.properties.BlockStateProperties.WATERLOGGED;

public class GlowTailsBlock extends DoublePlantBlock implements IWaterLoggable, ILiquidContainer {

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

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
        return this.getDefaultState().with(WATERLOGGED, fluidstate.isTagged(FluidTags.WATER) && fluidstate.getLevel() == 8);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return super.isValidGround(state, worldIn, pos) ||
                state.isIn(ATBlocks.OVERGROWN_VOIDSTONE) || state.isIn(ATBlocks.ORVIUM_GRASS) || state.isIn(ATBlocks.PHERN_MOSS) || state.isIn(ATBlocks.RITHLIUM) ||
                state.isIn(BlockTags.NYLIUM) ||
                state.isIn(Blocks.MYCELIUM);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (stateIn.get(WATERLOGGED)) {
                worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
            }
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
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
    @Override
    public @Nonnull
    Fluid pickupFluid(IWorld world, BlockPos pos, BlockState state) {
        if (hasFluid(state)) {
            world.setBlockState(pos, state.with(WATERLOGGED, false), 3);
            return world.getFluidState(pos).getFluid();
        }
        return Fluids.EMPTY;
    }

    private static boolean isFluidValid(Fluid fluid) {
        return fluid == Fluids.WATER || fluid == Fluids.LAVA;
    }

    public FluidState getFluidState(BlockState state) {
        if (hasFluid(state)) {
            return Fluids.WATER.getStillFluidState(false);
        }else {
            return Fluids.EMPTY.getDefaultState();
        }
    }


    private static boolean hasFluid(@Nonnull BlockState state) {
        return state.get(WATERLOGGED);
    }
}