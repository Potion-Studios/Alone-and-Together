package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.world.decorator.config.CountExtraRandomYConfig;
import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import static corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper.*;

public class ATConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> STELLARIS_METEORITE = createConfiguredFeature("meteorite", ATFeatures.METEORITE.withConfiguration(new NoisySphereConfig.Builder().setMinXRadius(10).setMaxXRadius(15).setMinYRadius(5).setMaxYRadius(8).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.BLACKSTONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.BLACK_CONCRETE.getDefaultState(), 5).addWeightedBlockstate(Blocks.GILDED_BLACKSTONE.getDefaultState(), 2).addWeightedBlockstate(Blocks.GRAY_CONCRETE.getDefaultState(), 10)).setTopBlock(Blocks.GRAY_CONCRETE_POWDER).build()).withPlacement(ATDecorators.COUNT_EXTRA_RANDOM_Y.configure(new CountExtraRandomYConfig(0, 0.05F, 1))));
    public static final ConfiguredFeature<?, ?> VOID_GRASS = createConfiguredFeature("void_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().addWeightedBlockstate(ATBlocks.VOID_GRASS.getDefaultState(), 5).addWeightedBlockstate(ATBlocks.VOID_FERN.getDefaultState(), 5), new SimpleBlockPlacer())).tries(24).build()));
}

