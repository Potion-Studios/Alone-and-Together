package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.common.properties.ATCraftingTableBlock;
import corgiaoc.aloneandtogether.common.properties.BookshelfBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.List;

public class ATBlocks {

    public static List<Block> blocks = new ArrayList<>();


    public static final Block WITHERED_LOG = createLog("withered_log");
    public static final Block WITHERED_WOOD = createWood("withered_wood");
    public static final Block WITHERED_PLANKS = createPlanks("withered_planks");
    public static final Block WITHERED_FENCE = createFence("withered_fence");
    public static final Block WITHERED_WALL = createWoodWall("withered_wall");

    public static final Block WITHERED_FENCE_GATE = createFenceGate("withered_fence_gate");
    public static final Block WITHERED_SLAB = createWoodSlab("withered_slab");
    public static final Block WITHERED_PRESSURE_PLATE = createWoodPressurePlate("withered_pressure_plate");
    public static final Block WITHERED_STAIRS = createWoodStairs("withered_stairs");
    public static final Block WITHERED_TRAP_DOOR = createTrapDoor("withered_trap_door");
    public static final Block WITHERED_CRAFTING_TABLE = createCraftingTable("withered_crafting_table");
    public static final Block WITHERED_BUTTON = createWoodButton("withered_button");
    public static final Block WITHERED_BOOKSHELF = createBookshelf("withered_bookshelf");
    public static final Block WITHERED_DOOR = createDoor("withered_door");
    public static final Block WITHERED_STRIPPED_WOOD = createStrippedLog("withered_strip_wood");


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
        Block createBlock = new WallBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.STONE).hardnessAndResistance(2.0f, 6.0f).harvestTool(ToolType.AXE).setRequiresTool());
        //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        blocks.add(createBlock);
        return createBlock;
    }


    public static void init() {
    }
}
