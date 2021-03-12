package corgiaoc.aloneandtogether.core.world;

import com.google.common.collect.ImmutableList;
import corgiaoc.aloneandtogether.common.world.decorator.config.CountExtraRandomYConfig;
import corgiaoc.aloneandtogether.common.world.feature.config.ATTreeConfig;
import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import static corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper.createConfiguredFeature;

public class ATConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> DUMMY_TREE = createConfiguredFeature("dummy_tree", ATFeatures.NBT_STRUCTURE.withConfiguration(new NoFeatureConfig()).withPlacement(ATDecorators.COUNT_EXTRA_RANDOM_Y.configure(new CountExtraRandomYConfig(100000, 0.05F, 1))));

    public static final ConfiguredFeature<?, ?> STELLARIS_METEORITE = createConfiguredFeature("meteorite", ATFeatures.METEORITE.withConfiguration(new NoisySphereConfig.Builder().setMinXRadius(20).setMaxXRadius(30).setMinYRadius(10).setMaxYRadius(16).setMinZRadius(14).setMaxZRadius(20).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.BLACKSTONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.BLACK_CONCRETE.getDefaultState(), 5).addWeightedBlockstate(Blocks.GILDED_BLACKSTONE.getDefaultState(), 2).addWeightedBlockstate(Blocks.GRAY_CONCRETE.getDefaultState(), 10)).setTopBlock(Blocks.GRAY_CONCRETE_POWDER).build()).withPlacement(ATDecorators.COUNT_EXTRA_RANDOM_Y.configure(new CountExtraRandomYConfig(0, 0.05F, 1))));
    public static final ConfiguredFeature<?, ?> VOID_FERN = createConfiguredFeature("void_fern_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().addWeightedBlockstate(ATBlocks.VOID_FERN.getDefaultState(), 10), new SimpleBlockPlacer())).tries(24).build()));
    public static final ConfiguredFeature<?, ?> BOG_BELL_BULBS = createConfiguredFeature("bog_bell_bulbs", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().addWeightedBlockstate(ATBlocks.BOG_BELL_BULBS.getDefaultState(), 10), new SimpleBlockPlacer())).tries(24).build()));
    public static final ConfiguredFeature<?, ?> TALL_BELL_BULBS = createConfiguredFeature("tall_bell_bulbs", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ATBlocks.TALL_BELL_BULBS.getDefaultState()), new DoublePlantBlockPlacer())).tries(24).build()));
    public static final ConfiguredFeature<?, ?> GLOWTAILS = createConfiguredFeature("glowtails", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ATBlocks.GLOWTAILS.getDefaultState()), new DoublePlantBlockPlacer())).tries(24).requiresWater().build()));
    public static final ConfiguredFeature<?, ?> ABYSSAL_GROWTH = createConfiguredFeature("abyssal_growth_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().addWeightedBlockstate(ATBlocks.ABYSSAL_GROWTH.getDefaultState(), 10), new SimpleBlockPlacer())).tries(24).build()));
    public static final ConfiguredFeature<?, ?> VOID_GRASS = createConfiguredFeature("void_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().addWeightedBlockstate(ATBlocks.VOID_GRASS.getDefaultState(), 10), new SimpleBlockPlacer())).tries(24).build()));
    public static final ConfiguredFeature<?, ?> ORVIUM_FEATHER = createConfiguredFeature("orvium_feather_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().addWeightedBlockstate(ATBlocks.ORVIUM_FEATHER.getDefaultState(), 10), new SimpleBlockPlacer())).tries(24).build()));

    //public static final ConfiguredFeature<?, ?> SPECTRAL_VINES = createConfiguredFeature("spectral_vines", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(ATBlocks.SPECTRAL_VINES.getDefaultState(), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(ATBlocks.SPECTRAL_LEAVES.getDefaultState(), ATBlocks.SPECTRAL_LOG.getDefaultState()))).range(256).square().func_242731_b(128));

    public static final ConfiguredFeature<?, ?> RANDOM_VOID_PLANT = createConfiguredFeature("rs_void_plant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            VOID_FERN.withChance(0.5F)),
            VOID_GRASS)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(5));

    /************************Tree Features************************/

//    public static final ConfiguredFeature<?, ?> TALL_SPECTRAL_TREE1 = createConfiguredFeature("tall_spectral_tree_1", ATFeatures.TALL_SPECTRAL_TREE_1.withConfiguration(new ATTreeConfig.Builder().setLeavesBlock(ATBlocks.SPECTRAL_LEAVES).setTrunkBlock(ATBlocks.SPECTRAL_LOG).setWhitelist(ImmutableList.of(ATBlocks.OVERGROWN_VOIDSTONE)).build()));
//    public static final ConfiguredFeature<?, ?> TALL_SPECTRAL_TREE2 = createConfiguredFeature("tall_spectral_tree_2", ATFeatures.TALL_SPECTRAL_TREE_2.withConfiguration(new ATTreeConfig.Builder().setLeavesBlock(ATBlocks.SPECTRAL_LEAVES).setTrunkBlock(ATBlocks.SPECTRAL_LOG).setWhitelist(ImmutableList.of(ATBlocks.OVERGROWN_VOIDSTONE)).build()));
//    public static final ConfiguredFeature<?, ?> TALL_SPECTRAL_TREE3 = createConfiguredFeature("tall_spectral_tree_3", ATFeatures.TALL_SPECTRAL_TREE_3.withConfiguration(new ATTreeConfig.Builder().setLeavesBlock(ATBlocks.SPECTRAL_LEAVES).setTrunkBlock(ATBlocks.SPECTRAL_LOG).setWhitelist(ImmutableList.of(ATBlocks.OVERGROWN_VOIDSTONE)).build()));
//    public static final ConfiguredFeature<?, ?> SPECTRAL_TREE1 = createConfiguredFeature("spectral_tree", ATFeatures.SPECTRAL_TREE_1.withConfiguration(new ATTreeConfig.Builder().setLeavesBlock(ATBlocks.SPECTRAL_LEAVES).setTrunkBlock(ATBlocks.SPECTRAL_LOG).setWhitelist(ImmutableList.of(ATBlocks.OVERGROWN_VOIDSTONE)).build()));

    /************************Tree Random Selector Features************************/


    //public static final ConfiguredFeature<?, ?> ABYSS_BOG_TREES = createConfiguredFeature("abyss_bog_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
//            TALL_SPECTRAL_TREE1.withChance(0.3F),
//            TALL_SPECTRAL_TREE2.withChance(0.3F),
//            TALL_SPECTRAL_TREE3.withChance(0.3F)),
//            SPECTRAL_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
//            new AtSurfaceWithExtraConfig(0, 0.65F, 1))));
}

