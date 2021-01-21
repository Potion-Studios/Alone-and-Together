package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ATItems {
    public static List<Item> items = new ArrayList<>();

    public static final ItemGroup CREATIVE_TAB = new ItemGroup(AloneAndTogether.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ATItems.COSMIC_LOG);
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
    public static final Item GECKO_SPAWN_EGG = createItem(new SpawnEggItem(ATEntities.GECKO, 15423, 21331, (new Item.Properties().group(CREATIVE_TAB))),"gecko_spawn_egg");
    public static final Item PYRE_SPAWN_EGG = createItem(new SpawnEggItem(ATEntities.PYRE_FLY, 354223, 213301, (new Item.Properties().group(CREATIVE_TAB))),"pyre_fly_spawn_egg");
    public static final Item RISTALITH_CRYSTAL = createItem(new Item(new Item.Properties().group(CREATIVE_TAB)), "ristalith_crystal");

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

    //cosmic wood
    public static final Item COSMIC_LOG = createItem(new BlockItem(ATBlocks.COSMIC_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_LOG));
    public static final Item COSMIC_PLANKS = createItem(new BlockItem(ATBlocks.COSMIC_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_PLANKS));
    public static final Item CARVED_COSMIC_PLANKS = createItem(new BlockItem(ATBlocks.CARVED_COSMIC_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CARVED_COSMIC_PLANKS));
    public static final Item COSMIC_FENCE = createItem(new BlockItem(ATBlocks.COSMIC_FENCE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_FENCE));
    public static final Item COSMIC_WOOD = createItem(new BlockItem(ATBlocks.COSMIC_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_WOOD));
    public static final Item COSMIC_WOOD_WALL = createItem(new BlockItem(ATBlocks.COSMIC_WOOD_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_WOOD_WALL));
    public static final Item COSMIC_FENCE_GATE = createItem(new BlockItem(ATBlocks.COSMIC_FENCE_GATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_FENCE_GATE));
    public static final Item COSMIC_SLAB = createItem(new BlockItem(ATBlocks.COSMIC_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_SLAB));
    public static final Item COSMIC_PRESSURE_PLATE = createItem(new BlockItem(ATBlocks.COSMIC_PRESSURE_PLATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_PRESSURE_PLATE));
    public static final Item COSMIC_STAIRS = createItem(new BlockItem(ATBlocks.COSMIC_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_STAIRS));
    public static final Item COSMIC_TRAP_DOOR = createItem(new BlockItem(ATBlocks.COSMIC_TRAP_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_TRAP_DOOR));
    public static final Item COSMIC_CRAFTING_TABLE = createItem(new BlockItem(ATBlocks.COSMIC_CRAFTING_TABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_CRAFTING_TABLE));
    public static final Item COSMIC_BUTTON = createItem(new BlockItem(ATBlocks.COSMIC_BUTTON, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_BUTTON));
    public static final Item COSMIC_BOOKSHELF = createItem(new BlockItem(ATBlocks.COSMIC_BOOKSHELF, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_BOOKSHELF));
    public static final Item COSMIC_DOOR = createItem(new BlockItem(ATBlocks.COSMIC_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_DOOR));
    public static final Item COSMIC_STRIPPED_WOOD = createItem(new BlockItem(ATBlocks.COSMIC_STRIPPED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_STRIPPED_WOOD));
    public static final Item COSMIC_STRIPPED_LOG = createItem(new BlockItem(ATBlocks.COSMIC_STRIPPED_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.COSMIC_STRIPPED_LOG));
    
    //orvium wood
    public static final Item ORVIUM_LOG = createItem(new BlockItem(ATBlocks.ORVIUM_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_LOG));
    public static final Item ORVIUM_PLANKS = createItem(new BlockItem(ATBlocks.ORVIUM_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_PLANKS));
    public static final Item CARVED_ORVIUM_PLANKS = createItem(new BlockItem(ATBlocks.CARVED_ORVIUM_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CARVED_ORVIUM_PLANKS));
    public static final Item ORVIUM_FENCE = createItem(new BlockItem(ATBlocks.ORVIUM_FENCE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_FENCE));
    public static final Item ORVIUM_WOOD = createItem(new BlockItem(ATBlocks.ORVIUM_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_WOOD));
    public static final Item ORVIUM_WOOD_WALL = createItem(new BlockItem(ATBlocks.ORVIUM_WOOD_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_WOOD_WALL));
    public static final Item ORVIUM_FENCE_GATE = createItem(new BlockItem(ATBlocks.ORVIUM_FENCE_GATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_FENCE_GATE));
    public static final Item ORVIUM_SLAB = createItem(new BlockItem(ATBlocks.ORVIUM_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_SLAB));
    public static final Item ORVIUM_PRESSURE_PLATE = createItem(new BlockItem(ATBlocks.ORVIUM_PRESSURE_PLATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_PRESSURE_PLATE));
    public static final Item ORVIUM_STAIRS = createItem(new BlockItem(ATBlocks.ORVIUM_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_STAIRS));
    public static final Item ORVIUM_TRAP_DOOR = createItem(new BlockItem(ATBlocks.ORVIUM_TRAP_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_TRAP_DOOR));
    public static final Item ORVIUM_CRAFTING_TABLE = createItem(new BlockItem(ATBlocks.ORVIUM_CRAFTING_TABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_CRAFTING_TABLE));
    public static final Item ORVIUM_BUTTON = createItem(new BlockItem(ATBlocks.ORVIUM_BUTTON, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_BUTTON));
    public static final Item ORVIUM_BOOKSHELF = createItem(new BlockItem(ATBlocks.ORVIUM_BOOKSHELF, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_BOOKSHELF));
    public static final Item ORVIUM_DOOR = createItem(new BlockItem(ATBlocks.ORVIUM_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_DOOR));
    public static final Item ORVIUM_STRIPPED_WOOD = createItem(new BlockItem(ATBlocks.ORVIUM_STRIPPED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_STRIPPED_WOOD));
    public static final Item ORVIUM_STRIPPED_LOG = createItem(new BlockItem(ATBlocks.ORVIUM_STRIPPED_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORVIUM_STRIPPED_LOG));

    //nightrio wood
    public static final Item NIGHTRIO_LOG = createItem(new BlockItem(ATBlocks.NIGHTRIO_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_LOG));
    public static final Item NIGHTRIO_PLANKS = createItem(new BlockItem(ATBlocks.NIGHTRIO_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_PLANKS));
    public static final Item CARVED_NIGHTRIO_PLANKS = createItem(new BlockItem(ATBlocks.CARVED_NIGHTRIO_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CARVED_NIGHTRIO_PLANKS));
    public static final Item NIGHTRIO_FENCE = createItem(new BlockItem(ATBlocks.NIGHTRIO_FENCE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_FENCE));
    public static final Item NIGHTRIO_WOOD = createItem(new BlockItem(ATBlocks.NIGHTRIO_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_WOOD));
    public static final Item NIGHTRIO_WOOD_WALL = createItem(new BlockItem(ATBlocks.NIGHTRIO_WOOD_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_WOOD_WALL));
    public static final Item NIGHTRIO_FENCE_GATE = createItem(new BlockItem(ATBlocks.NIGHTRIO_FENCE_GATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_FENCE_GATE));
    public static final Item NIGHTRIO_SLAB = createItem(new BlockItem(ATBlocks.NIGHTRIO_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_SLAB));
    public static final Item NIGHTRIO_PRESSURE_PLATE = createItem(new BlockItem(ATBlocks.NIGHTRIO_PRESSURE_PLATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_PRESSURE_PLATE));
    public static final Item NIGHTRIO_STAIRS = createItem(new BlockItem(ATBlocks.NIGHTRIO_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_STAIRS));
    public static final Item NIGHTRIO_TRAP_DOOR = createItem(new BlockItem(ATBlocks.NIGHTRIO_TRAP_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_TRAP_DOOR));
    public static final Item NIGHTRIO_CRAFTING_TABLE = createItem(new BlockItem(ATBlocks.NIGHTRIO_CRAFTING_TABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_CRAFTING_TABLE));
    public static final Item NIGHTRIO_BUTTON = createItem(new BlockItem(ATBlocks.NIGHTRIO_BUTTON, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_BUTTON));
    public static final Item NIGHTRIO_BOOKSHELF = createItem(new BlockItem(ATBlocks.NIGHTRIO_BOOKSHELF, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_BOOKSHELF));
    public static final Item NIGHTRIO_DOOR = createItem(new BlockItem(ATBlocks.NIGHTRIO_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_DOOR));
    public static final Item NIGHTRIO_STRIPPED_WOOD = createItem(new BlockItem(ATBlocks.NIGHTRIO_STRIPPED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_STRIPPED_WOOD));
    public static final Item NIGHTRIO_STRIPPED_LOG = createItem(new BlockItem(ATBlocks.NIGHTRIO_STRIPPED_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.NIGHTRIO_STRIPPED_LOG));

    //glowstone
    public static final Item BOG_LILLY_CRYSTAL = createItem(new BlockItem(ATBlocks.BOG_LILLY_CRYSTAL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.BOG_LILLY_CRYSTAL));
    public static final Item RISTALITH_BLOCK = createItem(new BlockItem(ATBlocks.RISTALITH_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RISTALITH_BLOCK));

    //glass
    public static final Item RISTAGLASS = createItem(new BlockItem(ATBlocks.RISTAGLASS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RISTAGLASS));

    //mycena
    public static final Item BLUE_MYCENA = createItem(new BlockItem(ATBlocks.BLUE_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.BLUE_MYCENA));
    public static final Item GREEN_MYCENA = createItem(new BlockItem(ATBlocks.GREEN_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.GREEN_MYCENA));
    public static final Item RED_MYCENA = createItem(new BlockItem(ATBlocks.RED_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RED_MYCENA));
    public static final Item YELLOW_MYCENA = createItem(new BlockItem(ATBlocks.YELLOW_MYCENA, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.YELLOW_MYCENA));
    public static final Item MYCENA_STEM = createItem(new BlockItem(ATBlocks.MYCENA_STEM, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.MYCENA_STEM));

    //grass
    public static final Item ASTRAL_GRASS_BLOCK = createItem(new BlockItem(ATBlocks.ASTRAL_GRASS_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ASTRAL_GRASS_BLOCK));
    public static final Item ORANGE_ASTRAL_GRASS_BLOCK = createItem(new BlockItem(ATBlocks.ORANGE_ASTRAL_GRASS_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ORANGE_ASTRAL_GRASS_BLOCK));

    //ores
    public static final Item KROHNKITE_ORE = createItem(new BlockItem(ATBlocks.KROHNKITE_ORE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.KROHNKITE_ORE));
    public static final Item ABYSS_GLOWSTONE_ORE = createItem(new BlockItem(ATBlocks.ABYSS_GLOWSTONE_ORE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ABYSS_GLOWSTONE_ORE));
    public static final Item ALEXANDERITE_ORE = createItem(new BlockItem(ATBlocks.ALEXANDERITE_ORE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ALEXANDERITE_ORE));
    
    //gems
    public static final Item ALEXANDERITE_GEM = createItem(new Item(new Item.Properties().group(CREATIVE_TAB)), "alexanderite_gem");
    public static final Item KROHNKITE_GEM = createItem(new Item(new Item.Properties().group(CREATIVE_TAB)), "krohnkite_gem");
    
    //tuber
    public static final Item TUBER_FUNGAE_LOG = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_LOG));
    public static final Item TUBER_FUNGAE_PLANKS = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_PLANKS));
    public static final Item CARVED_TUBER_FUNGAE_PLANKS = createItem(new BlockItem(ATBlocks.CARVED_TUBER_FUNGAE_PLANKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CARVED_TUBER_FUNGAE_PLANKS));
    public static final Item TUBER_FUNGAE_FENCE = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_FENCE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_FENCE));
    public static final Item TUBER_FUNGAE_WOOD = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_WOOD));
    public static final Item TUBER_FUNGAE_WOOD_WALL = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_WOOD_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_WOOD_WALL));
    public static final Item TUBER_FUNGAE_FENCE_GATE = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_FENCE_GATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_FENCE_GATE));
    public static final Item TUBER_FUNGAE_SLAB = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_SLAB));
    public static final Item TUBER_FUNGAE_PRESSURE_PLATE = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_PRESSURE_PLATE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_PRESSURE_PLATE));
    public static final Item TUBER_FUNGAE_STAIRS = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_STAIRS));
    public static final Item TUBER_FUNGAE_TRAP_DOOR = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_TRAP_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_TRAP_DOOR));
    public static final Item TUBER_FUNGAE_CRAFTING_TABLE = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_CRAFTING_TABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_CRAFTING_TABLE));
    public static final Item TUBER_FUNGAE_BUTTON = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_BUTTON, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_BUTTON));
    public static final Item TUBER_FUNGAE_BOOKSHELF = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_BOOKSHELF, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_BOOKSHELF));
    public static final Item TUBER_FUNGAE_DOOR = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_DOOR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_DOOR));
    public static final Item TUBER_FUNGAE_STRIPPED_WOOD = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_STRIPPED_WOOD, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_STRIPPED_WOOD));
    public static final Item TUBER_FUNGAE_STRIPPED_LOG = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_STRIPPED_LOG, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_STRIPPED_LOG));
    public static final Item TUBER_FUNGAE_BLOCK = createItem(new BlockItem(ATBlocks.TUBER_FUNGAE_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.TUBER_FUNGAE_BLOCK));

    //dirt
    public static final Item ASTRAL_DIRT = createItem(new BlockItem(ATBlocks.ASTRAL_DIRT, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.ASTRAL_DIRT));

    //flora, for ordering see ATBlocks - flora
    public static final Item
            SPECTRAL_LEAVES = createBlockItem(ATBlocks.SPECTRAL_LEAVES, createFloraProperties()),
            ORVIUM_LEAVES   = createBlockItem(ATBlocks.ORVIUM_LEAVES,   createFloraProperties()),
            NIGHTRIO_LEAVES = createBlockItem(ATBlocks.NIGHTRIO_LEAVES, createFloraProperties()),
            ABYSSAL_GROWTH  = createItem(new WallOrFloorItem(ATBlocks.ABYSSAL_GROWTH, ATBlocks.ABYSSAL_WALL_GROWTH, createFloraProperties()), "abyssal_growth"),
            BOG_SHROOM      = createBlockItem(ATBlocks.BOG_SHROOM,      createFloraProperties()),
            VOID_GRASS      = createBlockItem(ATBlocks.VOID_GRASS,      createFloraProperties()),
            VOID_FERN       = createBlockItem(ATBlocks.VOID_FERN,       createFloraProperties()),
            GLOWTAILS       = createBlockItem(ATBlocks.GLOWTAILS,       createFloraProperties()),
            SPECTRAL_VINES  = createBlockItem(ATBlocks.SPECTRAL_VINES,  createFloraProperties()),
            BOG_BELL_BULBS  = createBlockItem(ATBlocks.BOG_BELL_BULBS,  createFloraProperties()),
            TALL_BELL_BULBS = createBlockItem(ATBlocks.TALL_BELL_BULBS, createFloraProperties()),
            ORVIUM_FEATHER  = createBlockItem(ATBlocks.ORVIUM_FEATHER,  createFloraProperties());

    private static @Nonnull Item.Properties createFloraProperties() {
        return new Item.Properties().group(ATItemGroups.FLORA);
    }

    //overgrown stone
    public static final Item OVERGROWN_VOIDSTONE = createItem(new BlockItem(ATBlocks.OVERGROWN_VOIDSTONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.OVERGROWN_VOIDSTONE));
    public static final Item PHERN_MOSS = createItem(new BlockItem(ATBlocks.PHERN_MOSS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.PHERN_MOSS));
    public static final Item RITHLIUM = createItem(new BlockItem(ATBlocks.RITHLIUM, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RITHLIUM));
    public static final Item ORVIUM_GRASS = createBlockItem(ATBlocks.ORVIUM_GRASS, new Item.Properties().group(CREATIVE_TAB));
    public static final Item BOLITHIAN_STONE = createBlockItem(ATBlocks.BOLITHIAN_STONE, new Item.Properties().group(CREATIVE_TAB));
    public static final Item POLISHED_BOLITHIAN_STONE = createBlockItem(ATBlocks.POLISHED_BOLITHIAN_STONE, new Item.Properties().group(CREATIVE_TAB));


    //stone
    public static final Item VOIDSTONE = createItem(new BlockItem(ATBlocks.VOIDSTONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE));
    public static final Item VOIDSTONE_BRICK = createItem(new BlockItem(ATBlocks.VOIDSTONE_BRICK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_BRICK));
    public static final Item MOSSY_VOIDSTONE_BRICK = createItem(new BlockItem(ATBlocks.MOSSY_VOIDSTONE_BRICK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.MOSSY_VOIDSTONE_BRICK));
    public static final Item CHISELED_VOIDSTONE_BRICK = createItem(new BlockItem(ATBlocks.CHISELED_VOIDSTONE_BRICK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CHISELED_VOIDSTONE_BRICK));
    public static final Item CRACKED_VOIDSTONE_BRICK = createItem(new BlockItem(ATBlocks.CRACKED_VOIDSTONE_BRICK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CRACKED_VOIDSTONE_BRICK));
    public static final Item VOIDSTONE_BRICK_STAIRS = createItem(new BlockItem(ATBlocks.VOIDSTONE_BRICK_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_BRICK_STAIRS));
    public static final Item VOIDSTONE_BRICK_SLAB = createItem(new BlockItem(ATBlocks.VOIDSTONE_BRICK_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_BRICK_SLAB));
    public static final Item VOIDSTONE_SLAB = createItem(new BlockItem(ATBlocks.VOIDSTONE_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_SLAB));
    public static final Item VOIDSTONE_BRICK_WALL = createItem(new BlockItem(ATBlocks.VOIDSTONE_BRICK_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_BRICK_WALL));
    public static final Item VOIDSTONE_STAIRS = createItem(new BlockItem(ATBlocks.VOIDSTONE_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_STAIRS));
    public static final Item VOIDSTONE_WALL = createItem(new BlockItem(ATBlocks.VOIDSTONE_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.VOIDSTONE_WALL));
    public static final Item DECADASTONE = createItem(new BlockItem(ATBlocks.DECADASTONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASTONE));
    public static final Item DECADASTONE_BRICK = createItem(new BlockItem(ATBlocks.DECADASTONE_BRICK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASTONE_BRICK));
    public static final Item DECADASTONE_BRICK_STAIRS = createItem(new BlockItem(ATBlocks.DECADASTONE_BRICK_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASTONE_BRICK_STAIRS));
    public static final Item DECADASTONE_BRICK_SLAB = createItem(new BlockItem(ATBlocks.DECADASTONE_BRICK_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASTONE_BRICK_SLAB));
    public static final Item DECADASTONE_BRICK_WALL = createItem(new BlockItem(ATBlocks.DECADASTONE_BRICK_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASTONE_BRICK_WALL));
    public static final Item CHISELED_DECADASTONE_BRICK = createItem(new BlockItem(ATBlocks.CHISELED_DECADASTONE_BRICK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CHISELED_DECADASTONE_BRICK));
    public static final Item DECADATABLE = createItem(new BlockItem(ATBlocks.DECADATABLE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADATABLE));
    public static final Item DECADASTONE_PILLAR = createItem(new BlockItem(ATBlocks.DECADASTONE_PILLAR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASTONE_PILLAR));
    public static final Item DECADASITE = createItem(new BlockItem(ATBlocks.DECADASITE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.DECADASITE));
    public static final Item METEOR_STONE = createItem(new BlockItem(ATBlocks.METEOR_STONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.METEOR_STONE));
    public static final Item METEOR_STONE_WALL = createItem(new BlockItem(ATBlocks.METEOR_STONE_WALL, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.METEOR_STONE_WALL));
    public static final Item METEOR_STONE_STAIRS = createItem(new BlockItem(ATBlocks.METEOR_STONE_STAIRS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.METEOR_STONE_STAIRS));
    public static final Item METEOR_STONE_SLAB = createItem(new BlockItem(ATBlocks.METEOR_STONE_SLAB, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.METEOR_STONE_SLAB));
    public static final Item SPACE_DEBRIS = createItem(new BlockItem(ATBlocks.SPACE_DEBRIS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPACE_DEBRIS));
    public static final Item RITHLIUM_PILLAR = createItem(new BlockItem(ATBlocks.RITHLIUM_PILLAR, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RITHLIUM_PILLAR));
    public static final Item RITHLIUM_BLOCK = createItem(new BlockItem(ATBlocks.RITHLIUM_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RITHLIUM_BLOCK));
    public static final Item RITHLIUM_BRICKS = createItem(new BlockItem(ATBlocks.RITHLIUM_BRICKS, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.RITHLIUM_BRICKS));
    public static final Item CHISELED_RITHLIUM_BLOCK = createItem(new BlockItem(ATBlocks.CHISELED_RITHLIUM_BLOCK, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.CHISELED_RITHLIUM_BLOCK));
    public static final Item SHADE_STONE = createBlockItem(ATBlocks.SHADE_STONE, new Item.Properties().group(CREATIVE_TAB));
    public static final Item HARDENED_RITH_STONE = createItem(new BlockItem(ATBlocks.HARDENED_RITH_STONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.HARDENED_RITH_STONE));
    public static final Item HARDENED_VOIDSTONE = createItem(new BlockItem(ATBlocks.HARDENED_VOIDSTONE, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.HARDENED_VOIDSTONE));

    //chests
    public static final Item SPECTRAL_CHEST = createItem(new BlockItem(ATBlocks.SPECTRAL_CHEST, new Item.Properties().group(CREATIVE_TAB)), Registry.BLOCK.getKey(ATBlocks.SPECTRAL_CHEST));

    public static Item createItem(Item item, String id) {
        return createItem(item, AloneAndTogether.createResource(id));
    }

    public static Item createBlockItem(Block block, Item.Properties props) {
        return createItem(new BlockItem(block, props), Registry.BLOCK.getKey(block));
    }

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
            item.setRegistryName(id);

            items.add(item);

            return item;
        } else return null;
    }

    public static void init() {
    }
}