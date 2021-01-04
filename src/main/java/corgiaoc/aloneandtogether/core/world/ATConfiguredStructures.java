package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.StructureFeature;

public class ATConfiguredStructures {

    public static final StructureFeature<?, ?> LARGE_METEORITE = WorldGenRegistrationHelper.createConfiguredStructureFeature("large_meteorite", ATStructures.LARGE_METEORITE.withConfiguration(new NoisySphereConfig.Builder().setMinXRadius(55).setMaxXRadius(85).setMinYRadius(15).setMaxYRadius(25).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.BLACKSTONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.BLACK_CONCRETE.getDefaultState(), 5).addWeightedBlockstate(Blocks.QUARTZ_BLOCK.getDefaultState(), 2).addWeightedBlockstate(Blocks.QUARTZ_BLOCK.getDefaultState(), 10)).setTopBlock(Blocks.QUARTZ_BLOCK).build()));

}
