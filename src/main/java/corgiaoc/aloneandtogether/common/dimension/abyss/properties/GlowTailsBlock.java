package corgiaoc.aloneandtogether.common.dimension.abyss.properties;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.SeaGrassBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;

public class GlowTailsBlock extends DoublePlantBlock {

    public GlowTailsBlock(AbstractBlock.Properties properties) {
        super(properties);
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
        return fluidstate.isTagged(FluidTags.WATER) ? super.getStateForPlacement(context) : null;
    }
}
