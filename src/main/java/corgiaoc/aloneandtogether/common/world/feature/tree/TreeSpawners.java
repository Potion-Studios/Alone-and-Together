package corgiaoc.aloneandtogether.common.world.feature.tree;

import corgiaoc.aloneandtogether.common.world.feature.config.ATTreeConfig;
import corgiaoc.aloneandtogether.common.world.feature.tree.util.HugeTreeSpawner;
import corgiaoc.aloneandtogether.core.world.ATConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class TreeSpawners {
    public static class SpectralTree extends HugeTreeSpawner {
        @Override
        @Nullable
        public ConfiguredFeature<ATTreeConfig, ?> getBigTreeFeature(Random random) {
            return (ConfiguredFeature<ATTreeConfig, ?>) ATConfiguredFeatures.TALL_SPECTRAL_TREE1;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<ATTreeConfig, ?> getTreeFeature(Random random) {
            return (ConfiguredFeature<ATTreeConfig, ?>) ATConfiguredFeatures.SPECTRAL_TREE1;
        }
    }
}
