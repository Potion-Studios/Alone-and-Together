package corgiaoc.aloneandtogether.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.extensions.IForgeBlock;

/**
 * delete when porting to fabric, cause it has it's own way of implementing flammables!
 */
public interface IFlammableBlock extends IForgeBlock {
    @Override
    default int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return getFlammability()[0];
    }

    @Override
    default int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return getFlammability()[1];
    }

    int[] getFlammability();
}
