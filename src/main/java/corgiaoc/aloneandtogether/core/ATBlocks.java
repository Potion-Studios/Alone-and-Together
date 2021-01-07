package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.common.dimension.ATDimensions;
import corgiaoc.aloneandtogether.common.dimension.abyss.properties.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class ATBlocks {

    public static List<Block> blocks = new ArrayList<>();

    public static final Block ABYSS_TELEPORTER = createTeleporterBlock("abyss_teleporter", ATDimensions.ABYSS_WORLD_KEY);
    public static final Block STELLARIS_TELEPORTER = createTeleporterBlock("stellaris_teleporter", ATDimensions.STELLARIS_WORLD_KEY);


    //spectral wood
    public static final Block SPECTRAL_LOG = createLog("spectral_log");
    public static final Block SPECTRAL_PLANKS = createPlanks("spectral_planks");
    public static final Block CARVED_SPECTRAL_PLANKS = createPlanks("carved_spectral_planks");
    public static final Block SPECTRAL_FENCE = createFence("spectral_fence");
    public static final Block SPECTRAL_WOOD = createWood("spectral_wood");
    public static final Block SPECTRAL_WOOD_WALL = createWoodWall("spectral_wood_wall");
    public static final Block SPECTRAL_FENCE_GATE = createFenceGate("spectral_fence_gate");
    public static final Block SPECTRAL_SLAB = createWoodSlab("spectral_slab");
    public static final Block SPECTRAL_PRESSURE_PLATE = createWoodPressurePlate("spectral_pressure_plate");
    public static final Block SPECTRAL_STAIRS = createWoodStairs("spectral_stairs");
    public static final Block SPECTRAL_TRAP_DOOR = createTrapDoor("spectral_trapdoor");
    public static final Block SPECTRAL_CRAFTING_TABLE = createCraftingTable("spectral_crafting_table");
    public static final Block SPECTRAL_BUTTON = createWoodButton("spectral_button");
    public static final Block SPECTRAL_BOOKSHELF = createBookshelf("spectral_bookshelf");
    public static final Block SPECTRAL_DOOR = createDoor("spectral_door");
    public static final Block SPECTRAL_STRIPPED_WOOD = createStrippedLog("spectral_stripped_wood");
    public static final Block SPECTRAL_STRIPPED_LOG = createStrippedLog("spectral_stripped_log");

    //golden wood
    public static final Block GOLDEN_BIRCH_LOG = createLog("golden_birch_log");
    public static final Block GOLDEN_BIRCH_PLANKS = createPlanks("golden_birch_planks");
    public static final Block CARVED_GOLDEN_BIRCH_PLANKS = createPlanks("carved_golden_birch_planks");
    public static final Block GOLDEN_BIRCH_FENCE = createFence("golden_birch_fence");
    public static final Block GOLDEN_BIRCH_WOOD = createWood("golden_birch_wood");
    public static final Block GOLDEN_BIRCH_WOOD_WALL = createWoodWall("golden_birch_wood_wall");
    public static final Block GOLDEN_BIRCH_FENCE_GATE = createFenceGate("golden_birch_fence_gate");
    public static final Block GOLDEN_BIRCH_SLAB = createWoodSlab("golden_birch_slab");
    public static final Block GOLDEN_BIRCH_PRESSURE_PLATE = createWoodPressurePlate("golden_birch_pressure_plate");
    public static final Block GOLDEN_BIRCH_STAIRS = createWoodStairs("golden_birch_stairs");
    public static final Block GOLDEN_BIRCH_TRAP_DOOR = createTrapDoor("golden_birch_trapdoor");
    public static final Block GOLDEN_BIRCH_CRAFTING_TABLE = createCraftingTable("golden_birch_crafting_table");
    public static final Block GOLDEN_BIRCH_BUTTON = createWoodButton("golden_birch_button");
    public static final Block GOLDEN_BIRCH_BOOKSHELF = createBookshelf("golden_birch_bookshelf");
    public static final Block GOLDEN_BIRCH_DOOR = createDoor("golden_birch_door");
    public static final Block GOLDEN_BIRCH_STRIPPED_WOOD = createStrippedLog("golden_birch_strip_wood");
    public static final Block GOLDEN_BIRCH_STRIPPED_LOG = createStrippedLog("golden_birch_strip_log");

    //cosmic wood
    public static final Block COSMIC_LOG = createLog("cosmic_log");
    public static final Block COSMIC_PLANKS = createPlanks("cosmic_planks");
    public static final Block CARVED_COSMIC_PLANKS = createPlanks("carved_cosmic_planks");
    public static final Block COSMIC_FENCE = createFence("cosmic_fence");
    public static final Block COSMIC_WOOD = createWood("cosmic_wood");
    public static final Block COSMIC_WOOD_WALL = createWoodWall("cosmic_wood_wall");
    public static final Block COSMIC_FENCE_GATE = createFenceGate("cosmic_fence_gate");
    public static final Block COSMIC_SLAB = createWoodSlab("cosmic_slab");
    public static final Block COSMIC_PRESSURE_PLATE = createWoodPressurePlate("cosmic_pressure_plate");
    public static final Block COSMIC_STAIRS = createWoodStairs("cosmic_stairs");
    public static final Block COSMIC_TRAP_DOOR = createTrapDoor("cosmic_trapdoor");
    public static final Block COSMIC_CRAFTING_TABLE = createCraftingTable("cosmic_crafting_table");
    public static final Block COSMIC_BUTTON = createWoodButton("cosmic_button");
    public static final Block COSMIC_BOOKSHELF = createBookshelf("cosmic_bookshelf");
    public static final Block COSMIC_DOOR = createDoor("cosmic_door");
    public static final Block COSMIC_STRIPPED_WOOD = createStrippedLog("cosmic_stripped_wood");
    public static final Block COSMIC_STRIPPED_LOG = createStrippedLog("cosmic_stripped_log");

    //orvium wood
    public static final Block ORVIUM_LOG = createLog("orvium_log");
    public static final Block ORVIUM_PLANKS = createPlanks("orvium_planks");
    public static final Block CARVED_ORVIUM_PLANKS = createPlanks("carved_orvium_planks");
    public static final Block ORVIUM_FENCE = createFence("orvium_fence");
    public static final Block ORVIUM_WOOD = createWood("orvium_wood");
    public static final Block ORVIUM_WOOD_WALL = createWoodWall("orvium_wood_wall");
    public static final Block ORVIUM_FENCE_GATE = createFenceGate("orvium_fence_gate");
    public static final Block ORVIUM_SLAB = createWoodSlab("orvium_slab");
    public static final Block ORVIUM_PRESSURE_PLATE = createWoodPressurePlate("orvium_pressure_plate");
    public static final Block ORVIUM_STAIRS = createWoodStairs("orvium_stairs");
    public static final Block ORVIUM_TRAP_DOOR = createTrapDoor("orvium_trapdoor");
    public static final Block ORVIUM_CRAFTING_TABLE = createCraftingTable("orvium_crafting_table");
    public static final Block ORVIUM_BUTTON = createWoodButton("orvium_button");
    public static final Block ORVIUM_BOOKSHELF = createBookshelf("orvium_bookshelf");
    public static final Block ORVIUM_DOOR = createDoor("orvium_door");
    public static final Block ORVIUM_STRIPPED_WOOD = createStrippedLog("orvium_stripped_wood");
    public static final Block ORVIUM_STRIPPED_LOG = createStrippedLog("orvium_stripped_log");
    
    //nightrio wood
    public static final Block NIGHTRIO_LOG = createLog("nightrio_log");
    public static final Block NIGHTRIO_PLANKS = createPlanks("nightrio_planks");
    public static final Block CARVED_NIGHTRIO_PLANKS = createPlanks("carved_nightrio_planks");
    public static final Block NIGHTRIO_FENCE = createFence("nightrio_fence");
    public static final Block NIGHTRIO_WOOD = createWood("nightrio_wood");
    public static final Block NIGHTRIO_WOOD_WALL = createWoodWall("nightrio_wood_wall");
    public static final Block NIGHTRIO_FENCE_GATE = createFenceGate("nightrio_fence_gate");
    public static final Block NIGHTRIO_SLAB = createWoodSlab("nightrio_slab");
    public static final Block NIGHTRIO_PRESSURE_PLATE = createWoodPressurePlate("nightrio_pressure_plate");
    public static final Block NIGHTRIO_STAIRS = createWoodStairs("nightrio_stairs");
    public static final Block NIGHTRIO_TRAP_DOOR = createTrapDoor("nightrio_trapdoor");
    public static final Block NIGHTRIO_CRAFTING_TABLE = createCraftingTable("nightrio_crafting_table");
    public static final Block NIGHTRIO_BUTTON = createWoodButton("nightrio_button");
    public static final Block NIGHTRIO_BOOKSHELF = createBookshelf("nightrio_bookshelf");
    public static final Block NIGHTRIO_DOOR = createDoor("nightrio_door");
    public static final Block NIGHTRIO_STRIPPED_WOOD = createStrippedLog("nightrio_stripped_wood");
    public static final Block NIGHTRIO_STRIPPED_LOG = createStrippedLog("nightrio_stripped_log");


    //glowstone
    public static final Block BOG_LILLY_CRYSTAL = createGlowBlock("bog_lilly_crystal");

    //mycena
    public static final Block BLUE_MYCENA = createMycenaBlock("blue_mycena");
    public static final Block GREEN_MYCENA = createMycenaBlock("green_mycena");
    public static final Block RED_MYCENA = createMycenaBlock("red_mycena");
    public static final Block YELLOW_MYCENA = createMycenaBlock("yellow_mycena");
    public static final Block MYCENA_STEM = createMycenaBlock("mycena_stem");

    //overgrown stone
    public static final Block OVERGROWN_VOIDSTONE = createOvergrownStone("overgrown_voidstone");

    //grass blocks
    public static final Block ASTRAL_GRASS_BLOCK = createGrassBlock("astral_grass_block");
    public static final Block ORANGE_ASTRAL_GRASS_BLOCK = createGrassBlock("orange_astral_grass_block");

    //stone
    public static final Block VOIDSTONE = createStoneBlock("voidstone");
    public static final Block VOIDSTONE_BRICK = createStoneBlock("voidstone_brick");
    public static final Block MOSSY_VOIDSTONE_BRICK = createStoneBlock("mossy_voidstone_brick");
    public static final Block CRACKED_VOIDSTONE_BRICK = createStoneBlock("cracked_voidstone_brick");
    public static final Block CHISELED_VOIDSTONE_BRICK = createStoneBlock("chiseled_voidstone_brick");
    public static final Block VOIDSTONE_BRICK_WALL = createStoneWall("voidstone_brick_wall");
    public static final Block VOIDSTONE_WALL = createStoneWall("voidstone_wall");
    public static final Block VOIDSTONE_BRICK_STAIRS = createStoneStairs("voidstone_brick_stairs");
    public static final Block VOIDSTONE_STAIRS = createStoneStairs("voidstone_stairs");
    public static final Block DECADASTONE = createStonePillar("decadastone");
    public static final Block DECADASITE = createStoneBlock("decadasite");

    //leaves
    public static final Block SPECTRAL_LEAVES = createLeafBlock("spectral_leaves");
    public static final Block ORVIUM_LEAVES = createLeafBlock("orvium_leaves");

    //plants
    public static final Block VOID_GRASS = createPlantBlock("void_grass");
    public static final Block GLOWTAILS = createGlowTallPlant("glowtails");
    public static final Block SPECTRAL_VINES_PLANT = createVinePlant("spectral_vines_plant");
    public static final Block SPECTRAL_VINES = createVineGlowBlock("spectral_vines");

    //dirt
    public static final Block ASTRAL_DIRT = createDirtBlock("astral_dirt");

    static Block createFence(String id) {
        Block createBlock = new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createFenceGate(String id) {
        Block createBlock = new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createWoodSlab(String id) {
        Block createBlock = new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createPlantBlock(String id) {
        Block createBlock = new TallGrassBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createWoodPressurePlate(String id) {
        Block createBlock = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createWoodStairs(String id) {
        Block createBlock = new StairsBlock(Registry.BLOCK.getOrDefault(new ResourceLocation(AloneAndTogether.MOD_ID, id.replace("_stairs", "planks"))).getDefaultState(), AbstractBlock.Properties.from(Blocks.OAK_PLANKS).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createStoneStairs(String id) {
        Block createBlock = new StairsBlock(Registry.BLOCK.getOrDefault(new ResourceLocation(AloneAndTogether.MOD_ID, id.replace("_stairs", "stone"))).getDefaultState(), AbstractBlock.Properties.from(Blocks.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createTrapDoor(String id) {
        Block createBlock = new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f).notSolid());
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createCraftingTable(String id) {
        Block createBlock = new ATCraftingTableBlock(AbstractBlock.Properties.from(Blocks.CRAFTING_TABLE));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createWoodButton(String id) {
        Block createBlock = new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).sound(SoundType.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createBookshelf(String id) {
        Block createBlock = new BookshelfBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createDoor(String id) {
        Block createBlock = new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f).notSolid());
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createPlanks(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 3.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createWood(String id) {
        Block createBlock = new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createStrippedLog(String id) {
        Block createBlock = new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createLog(String id) {
        Block createBlock = new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(AloneAndTogether.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createWoodWall(String id) {
        Block createBlock = new WallBlock(AbstractBlock.Properties.from(SPECTRAL_WOOD));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createStoneWall(String id) {
        Block createBlock = new WallBlock(AbstractBlock.Properties.from(VOIDSTONE));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createTeleporterBlock(String id, RegistryKey<World> worldRegistryKey) {
        Block createBlock = new DimensionTeleporterBlock(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(2.0f, 6.0f).harvestTool(ToolType.PICKAXE).setRequiresTool(), worldRegistryKey);
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }
    static Block createGlowBlock(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(2.0f, 2.5f).notSolid().setLightLevel((state) -> { return 11; }));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }
    static Block createGlowTallPlant(String id) {
        Block createBlock = new GlowTailsBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT).setLightLevel((state) -> { return 2; }));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createMycenaBlock(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.create(Material.CLAY).sound(SoundType.SHROOMLIGHT).hardnessAndResistance(1.0f).setLightLevel((state) -> 11));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }
    static Block createVinePlant(String id) {
        Block createBlock = new SpectralVinesPlant(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.CYAN).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.NETHER_VINE));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;

    }
    static Block createVineGlowBlock(String id) {
        Block createBlock = new SpectralVinesBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.CYAN).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.NETHER_VINE).setLightLevel((state) -> 12));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }
    static Block createGrassBlock(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.PLANT).hardnessAndResistance(0.5f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createDirtBlock(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createStoneBlock(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(1.5F, 6.0F));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createOvergrownStone(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.NYLIUM).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createStonePillar(String id) {
        Block createBlock = new RotatedPillarBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().sound(SoundType.BASALT).hardnessAndResistance(1.5F, 6.0F));
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }

    static Block createLeafBlock(String id) {
        Block createBlock = new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid());
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }


    public static void init() {
    }
}
