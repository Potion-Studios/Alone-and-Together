package corgiaoc.aloneandtogether.common.dimension.abyss.properties;

import corgiaoc.aloneandtogether.client.gui.ATWorkBenchContainer;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ATCraftingTableBlock extends CraftingTableBlock {
    private static final ITextComponent GUI_TITLE = new TranslationTextComponent("container.crafting");

    public ATCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, entity) -> new ATWorkBenchContainer(id, inventory, IWorldPosCallable.of(worldIn, pos), this), GUI_TITLE);
    }
}