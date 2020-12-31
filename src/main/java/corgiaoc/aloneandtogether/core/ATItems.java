package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ATItems {
    public static List<Item> items = new ArrayList<>();

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
//            Registry.register(Registry.ITEM, id, item);
            item.setRegistryName(id); //Forge
            items.add(item);
            return item;
        } else {
            return null;
        }
    }

    public static Item createItem(Item item, String id) {
//        Registry.register(Registry.ITEM, new ResourceLocation(BYG.MOD_ID, id), item);
        item.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        items.add(item);
        return item;
    }

    public static void init() {
    }
}