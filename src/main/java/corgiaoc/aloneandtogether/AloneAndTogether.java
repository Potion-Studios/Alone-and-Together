package corgiaoc.aloneandtogether;

import corgiaoc.aloneandtogether.common.dimension.ATDimensions;
import corgiaoc.aloneandtogether.common.dimension.abyss.world.feature.blockplacer.ATBlockPlacerTypes;
import corgiaoc.aloneandtogether.core.ATBlocks;
import corgiaoc.aloneandtogether.core.ATEntities;
import corgiaoc.aloneandtogether.core.ATItems;
import corgiaoc.aloneandtogether.core.world.*;
import corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

@Mod(AloneAndTogether.MOD_ID)
public class AloneAndTogether {

    public static final String MOD_ID = "aloneandtogether";

    public static final Logger LOGGER = LogManager.getLogger();

    public AloneAndTogether() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(new ForgeEvents());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ATDimensions.registerBiomeSources();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ATDimensions.registerDimensionRenderers();
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ATRegistries {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            LOGGER.debug("Alone & Together: Registering blocks...");
            ATBlocks.init();
            ATBlocks.blocks.forEach(block -> event.getRegistry().register(block));
            ATBlocks.blocks = null;
            LOGGER.info("Alone & Together: Blocks registered!");
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            LOGGER.debug("Alone & Together: Registering items...");
            ATItems.init();
            ATItems.items.forEach(item -> event.getRegistry().register(item));
            ATItems.items = null;
            LOGGER.info("Alone & Together: Items registered!");
        }

        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
            LOGGER.debug("Alone & Together: Registering entities...");
            ATEntities.init();
            ATEntities.entities.forEach(entityType -> event.getRegistry().register(entityType));
            ATEntities.entities = null;
            LOGGER.info("Alone & Together: Entities registered!");
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ATWorldGenRegistries {

        @SubscribeEvent
        public static void registerBiomes(RegistryEvent.Register<Biome> event) {
            LOGGER.debug("Alone & Together: Registering biomes...");
            ATBiomes.init();
            ATBiomes.biomes.sort(Comparator.comparingInt(WorldGenRegistrationHelper.PreserveBiomeOrder::getOrderPosition));
            ATBiomes.biomes.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
            ATBiomes.biomes = null;
            LOGGER.info("Alone & Together: Biomes registered!");
        }

        @SubscribeEvent
        public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
            LOGGER.debug("Alone & Together: Registering decorators...");
            ATDecorators.init();
            ATDecorators.decorators.forEach(decorator -> event.getRegistry().register(decorator));
            ATDecorators.decorators = null;
            LOGGER.info("Alone & Together: Decorators registered!");
        }

        @SubscribeEvent
        public static void registerStructures(RegistryEvent.Register<Structure<?>> event) {
            LOGGER.debug("Alone & Together: Registering structures...");
            ATStructures.init();
//            BYGStructures.structures.forEach(structure -> event.getRegistry().register(structure));
//            Structure.STRUCTURE_DECORATION_STAGE_MAP.forEach(((structure, decoration) -> System.out.println(Registry.STRUCTURE_FEATURE.getKey(structure).toString())));
            LOGGER.info("Alone & Together: Structures registered!");
        }

        @SubscribeEvent
        public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
            LOGGER.debug("Alone & Together: Registering features...");
            ATFeatures.init();
            ATFeatures.features.forEach(feature -> event.getRegistry().register(feature));
            ATFeatures.features = null;
            LOGGER.info("Alone & Together: Features registered!");
        }

        @SubscribeEvent
        public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
            LOGGER.debug("Alone & Together: Registering surface builders...");
            ATSurfaceBuilders.init();
            ATSurfaceBuilders.surfaceBuilders.forEach(surfaceBuilder -> event.getRegistry().register(surfaceBuilder));
            ATSurfaceBuilders.surfaceBuilders = null;
            LOGGER.info("Alone & Together: Surface builders Registered!");
        }


        @SubscribeEvent
        public static void registerBlockPlacerType(RegistryEvent.Register<BlockPlacerType<?>> event) {
            LOGGER.debug("Alone & Together: Registering block placer types...");
            ATBlockPlacerTypes.init();
            ATBlockPlacerTypes.types.forEach(type -> event.getRegistry().register(type));
            ATBlockPlacerTypes.types = null;
            LOGGER.info("Alone & Together: Registering block placer types!");
        }
    }

    public static class ForgeEvents {
//        @SubscribeEvent
//        public void commandRegisterEvent(FMLServerStartingEvent event) {
//            LOGGER.debug("Alone & Together: \"Server Starting\" Event Starting...");
//            LOGGER.info("Alone & Together: \"Server Starting\" Event Complete!");
//        }

//        @SubscribeEvent
//        public void addDimensionalSpacing(final WorldEvent.Load event) {
//            LOGGER.debug("Alone & Together: \"World Load\" Event Starting...");
//            if(event.getWorld() instanceof ServerWorld){
//                ServerWorld serverWorld = (ServerWorld)event.getWorld();
//
//                // Prevent spawning our structure in Vanilla's superflat world as
//                // people seem to want their superflat worlds free of modded structures.
//                // Also that vanilla superflat is really tricky and buggy to work with in my experience.
//                if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
//                        serverWorld.getDimensionKey().equals(World.OVERWORLD)){
//                    return;
//                }
//
//                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
//                tempMap.put(BYGStructures.VOLCANO_STRUCTURE, DimensionStructuresSettings.field_236191_b_.get(BYGStructures.VOLCANO_STRUCTURE));
//                serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
//            }
//            LOGGER.info("Alone & Together: \"World Load\" Event Complete!");
//        }
    }
}
