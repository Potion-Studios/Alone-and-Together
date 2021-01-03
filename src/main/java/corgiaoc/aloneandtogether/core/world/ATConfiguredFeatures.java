package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.world.decorator.config.CountExtraRandomYConfig;
import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import static corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper.*;

public class ATConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> STELLARIS_METEORITE = createConfiguredFeature("blacstone_meteorite", ATFeatures.METEORITE.withConfiguration(new NoisySphereConfig.Builder().setMinXRadius(10).setMaxXRadius(15).setMinYRadius(5).setMaxYRadius(8).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.BLACKSTONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.BLACK_CONCRETE.getDefaultState(), 5).addWeightedBlockstate(Blocks.GILDED_BLACKSTONE.getDefaultState(), 2)).build()).withPlacement(ATDecorators.COUNT_EXTRA_RANDOM_Y.configure(new CountExtraRandomYConfig(0, 0.05F, 1))));
}
