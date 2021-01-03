package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.block.Block;
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

    public static final Item ABYSS_TELEPORTER = createItem(new BlockItem(ATBlocks.ABYSS_TELEPORTER, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ABYSS_TELEPORTER));
    public static final Item STELLARIS_TELEPORTER = createItem(new BlockItem(ATBlocks.STELLARIS_TELEPORTER, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.STELLARIS_TELEPORTER));

    //spectral wood
    public static final Item SPECTRAL_LOG = createItem(new BlockItem(ATBlocks.SPECTRAL_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_LOG));
    public static final Item SPECTRAL_PLANKS = createItem(new BlockItem(ATBlocks.SPECTRAL_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_PLANKS));
    public static final Item CARVED_SPECTRAL_PLANKS = createItem(new BlockItem(ATBlocks.CARVED_SPECTRAL_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CARVED_SPECTRAL_PLANKS));
    public static final Item SPECTRAL_FENCE = createItem(new BlockItem(ATBlocks.SPECTRAL_FENCE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_FENCE));
    public static final Item SPECTRAL_WOOD = createItem(new BlockItem(ATBlocks.SPECTRAL_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_WOOD));
    public static final Item SPECTRAL_WOOD_WALL = createItem(new BlockItem(ATBlocks.SPECTRAL_WOOD_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_WOOD_WALL));
    public static final Item SPECTRAL_FENCE_GATE = createItem(new BlockItem(ATBlocks.SPECTRAL_FENCE_GATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_FENCE_GATE));
    public static final Item SPECTRAL_SLAB = createItem(new BlockItem(ATBlocks.SPECTRAL_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_SLAB));
    public static final Item SPECTRAL_PRESSURE_PLATE = createItem(new BlockItem(ATBlocks.SPECTRAL_PRESSURE_PLATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_PRESSURE_PLATE));
    public static final Item SPECTRAL_STAIRS = createItem(new BlockItem(ATBlocks.SPECTRAL_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_STAIRS));
    public static final Item SPECTRAL_TRAP_DOOR = createItem(new BlockItem(ATBlocks.SPECTRAL_TRAP_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_TRAP_DOOR));
    public static final Item SPECTRAL_CRAFTING_TABLE = createItem(new BlockItem(ATBlocks.SPECTRAL_CRAFTING_TABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_CRAFTING_TABLE));
    public static final Item SPECTRAL_BUTTON = createItem(new BlockItem(ATBlocks.SPECTRAL_BUTTON, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_BUTTON));
    public static final Item SPECTRAL_BOOKSHELF = createItem(new BlockItem(ATBlocks.SPECTRAL_BOOKSHELF, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_BOOKSHELF));
    public static final Item SPECTRAL_DOOR = createItem(new BlockItem(ATBlocks.SPECTRAL_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_DOOR));
    public static final Item SPECTRAL_STRIPPED_WOOD = createItem(new BlockItem(ATBlocks.SPECTRAL_STRIPPED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_STRIPPED_WOOD));
    public static final Item SPECTRAL_STRIPPED_LOG = createItem(new BlockItem(ATBlocks.SPECTRAL_STRIPPED_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_STRIPPED_LOG));

    //golden birch
    public static final Item GOLDEN_BIRCH_LOG = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_LOG));
    public static final Item GOLDEN_BIRCH_PLANKS = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_PLANKS));
    public static final Item CARVED_GOLDEN_BIRCH_PLANKS = createItem(new BlockItem(ATBlocks.CARVED_GOLDEN_BIRCH_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CARVED_GOLDEN_BIRCH_PLANKS));
    public static final Item GOLDEN_BIRCH_FENCE = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_FENCE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_FENCE));
    public static final Item GOLDEN_BIRCH_WOOD = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_WOOD));
    public static final Item GOLDEN_BIRCH_WOOD_WALL = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_WOOD_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_WOOD_WALL));
    public static final Item GOLDEN_BIRCH_FENCE_GATE = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_FENCE_GATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_FENCE_GATE));
    public static final Item GOLDEN_BIRCH_SLAB = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_SLAB));
    public static final Item GOLDEN_BIRCH_PRESSURE_PLATE = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_PRESSURE_PLATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_PRESSURE_PLATE));
    public static final Item GOLDEN_BIRCH_STAIRS = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_STAIRS));
    public static final Item GOLDEN_BIRCH_TRAP_DOOR = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_TRAP_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_TRAP_DOOR));
    public static final Item GOLDEN_BIRCH_CRAFTING_TABLE = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_CRAFTING_TABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_CRAFTING_TABLE));
    public static final Item GOLDEN_BIRCH_BUTTON = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_BUTTON, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_BUTTON));
    public static final Item GOLDEN_BIRCH_BOOKSHELF = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_BOOKSHELF, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_BOOKSHELF));
    public static final Item GOLDEN_BIRCH_DOOR = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_DOOR));
    public static final Item GOLDEN_BIRCH_STRIPPED_WOOD = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_STRIPPED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_STRIPPED_WOOD));
    public static final Item GOLDEN_BIRCH_STRIPPED_LOG = createItem(new BlockItem(ATBlocks.GOLDEN_BIRCH_STRIPPED_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GOLDEN_BIRCH_STRIPPED_LOG));

    //glowstone
    public static final Item BOG_LILLY_CRYSTAL = createItem(new BlockItem(ATBlocks.BOG_LILLY_CRYSTAL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.BOG_LILLY_CRYSTAL));

    //mycena
    public static final Item BLUE_MYCENA = createItem(new BlockItem(ATBlocks.BLUE_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.BLUE_MYCENA));
    public static final Item GREEN_MYCENA = createItem(new BlockItem(ATBlocks.GREEN_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GREEN_MYCENA));
    public static final Item RED_MYCENA = createItem(new BlockItem(ATBlocks.RED_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RED_MYCENA));
    public static final Item YELLOW_MYCENA = createItem(new BlockItem(ATBlocks.YELLOW_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.YELLOW_MYCENA));
    public static final Item MYCENA_STEM = createItem(new BlockItem(ATBlocks.MYCENA_STEM, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.MYCENA_STEM));

    //grass
    public static final Item ASTRAL_GRASS_BLOCK = createItem(new BlockItem(ATBlocks.ASTRAL_GRASS_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ASTRAL_GRASS_BLOCK));
    public static final Item ORANGE_ASTRAL_GRASS_BLOCK = createItem(new BlockItem(ATBlocks.ORANGE_ASTRAL_GRASS_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORANGE_ASTRAL_GRASS_BLOCK));

    //leaves
    public static final Item SPECTRAL_LEAVES = createItem(new BlockItem(ATBlocks.SPECTRAL_LEAVES, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_LEAVES));

    //dirt
    public static final Item CORRUPT_DIRT = createItem(new BlockItem(ATBlocks.CORRUPT_DIRT, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CORRUPT_DIRT));
    public static final Item ASTRAL_DIRT = createItem(new BlockItem(ATBlocks.ASTRAL_DIRT, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ASTRAL_DIRT));

    //plants
    public static final Item VOID_GRASS = createItem(new BlockItem(ATBlocks.VOID_GRASS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOID_GRASS));
    public static final Item VOID_FERN = createItem(new BlockItem(ATBlocks.VOID_FERN, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOID_FERN));
    public static final Item GLOWTAIL = createItem(new BlockItem(ATBlocks.GLOWTAIL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GLOWTAIL));
    public static final Item SPECTRAL_VINES = createItem(new BlockItem(ATBlocks.SPECTRAL_VINES, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_VINES));
    public static final Item SPECTRAL_VINES_GLOWING = createItem(new BlockItem(ATBlocks.SPECTRAL_VINES_GLOWING, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_VINES_GLOWING));
    public static final Item SPECTRAL_VINES_PLANT = createItem(new BlockItem(ATBlocks.SPECTRAL_VINES_PLANT, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_VINES_PLANT));

    //stone
    public static final Item VOIDSTONE = createItem(new BlockItem(ATBlocks.VOIDSTONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE));
    public static final Item VOIDSTONE_BRICK = createItem(new BlockItem(ATBlocks.VOIDSTONE_BRICK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_BRICK));
    public static final Item VOIDSTONE_BRICK_STAIRS = createItem(new BlockItem(ATBlocks.VOIDSTONE_BRICK_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_BRICK_STAIRS));
    public static final Item VOIDSTONE_BRICK_WALL = createItem(new BlockItem(ATBlocks.VOIDSTONE_BRICK_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_BRICK_WALL));
    public static final Item VOIDSTONE_STAIRS = createItem(new BlockItem(ATBlocks.VOIDSTONE_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_STAIRS));
    public static final Item VOIDSTONE_WALL = createItem(new BlockItem(ATBlocks.VOIDSTONE_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_WALL));
    public static final Item DECADASTONE = createItem(new BlockItem(ATBlocks.DECADASTONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASTONE));
    public static final Item OVERGROWN_VOIDSTONE = createItem(new BlockItem(ATBlocks.OVERGROWN_VOIDSTONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.OVERGROWN_VOIDSTONE));
    public static final Item DECADASITE = createItem(new BlockItem(ATBlocks.DECADASITE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASITE));


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