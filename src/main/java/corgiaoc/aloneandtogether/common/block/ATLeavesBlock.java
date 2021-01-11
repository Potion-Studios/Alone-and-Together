package corgiaoc.aloneandtogether.common.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;

public class ATLeavesBlock extends LeavesBlock implements IFlammableBlock {

    public ATLeavesBlock() {
        this(Properties.from(Blocks.OAK_LEAVES).notSolid());
    }

    public ATLeavesBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int[] getFlammability() {
        return new int[] {30, 60};
    }
}
