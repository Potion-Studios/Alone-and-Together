package corgiaoc.aloneandtogether.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ATItemGroups {

    private ATItemGroups() {
    }

    public static final ItemGroup FLORA = new ItemGroup("aat.flora") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ATItems.VOID_FERN);
        }
    };
}
