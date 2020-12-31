package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class ATItems {

    public static List<Item> items = new ArrayList<>();

    public static final ItemGroup CREATIVE_TAB = new ItemGroup("aloneandtogether") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.CHAIN);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public boolean hasScrollbar() {
            return true;
        }

        @Override
        public ResourceLocation getBackgroundImage() {
            return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png");
        }
    };


    public static final Item WITHERED_LOG = createItem(new BlockItem(ATBlocks.WITHERED_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_LOG));
    public static final Item WITHERED_WOOD = createItem(new BlockItem(ATBlocks.WITHERED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_WOOD));
    public static final Item WITHERED_PLANKS = createItem(new BlockItem(ATBlocks.WITHERED_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_PLANKS));
    public static final Item WITHERED_FENCE = createItem(new BlockItem(ATBlocks.WITHERED_FENCE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_FENCE));
    public static final Item WITHERED_WALL = createItem(new BlockItem(ATBlocks.WITHERED_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_WALL));

    public static final Item WITHERED_FENCE_GATE = createItem(new BlockItem(ATBlocks.WITHERED_FENCE_GATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_FENCE_GATE));
    public static final Item WITHERED_SLAB = createItem(new BlockItem(ATBlocks.WITHERED_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_SLAB));
    public static final Item WITHERED_PRESSURE_PLATE = createItem(new BlockItem(ATBlocks.WITHERED_PRESSURE_PLATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_PRESSURE_PLATE));
    public static final Item WITHERED_STAIRS = createItem(new BlockItem(ATBlocks.WITHERED_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_STAIRS));
    public static final Item WITHERED_TRAP_DOOR = createItem(new BlockItem(ATBlocks.WITHERED_TRAP_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_TRAP_DOOR));
    public static final Item WITHERED_CRAFTING_TABLE = createItem(new BlockItem(ATBlocks.WITHERED_CRAFTING_TABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_CRAFTING_TABLE));
    public static final Item WITHERED_WOOD_BUTTON = createItem(new BlockItem(ATBlocks.WITHERED_BUTTON, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_BUTTON));
    public static final Item WITHERED_BOOKSHELF = createItem(new BlockItem(ATBlocks.WITHERED_BOOKSHELF, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_BOOKSHELF));
    public static final Item WITHERED_DOOR = createItem(new BlockItem(ATBlocks.WITHERED_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_DOOR));
    public static final Item WITHERED_STRIPPED_WOOD = createItem(new BlockItem(ATBlocks.WITHERED_STRIPPED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.WITHERED_STRIPPED_WOOD));



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