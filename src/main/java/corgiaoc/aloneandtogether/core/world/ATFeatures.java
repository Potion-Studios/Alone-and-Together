package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.world.feature.NoisySphere;
import corgiaoc.aloneandtogether.common.world.feature.config.ATTreeConfig;
import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.common.world.feature.tree.abyss.TallSpectralTree1;
import corgiaoc.aloneandtogether.common.world.feature.tree.abyss.TallSpectralTree2;
import corgiaoc.aloneandtogether.common.world.feature.tree.abyss.TallSpectralTree3;
import corgiaoc.aloneandtogether.common.world.feature.tree.util.ATAbstractTreeFeature;
import corgiaoc.aloneandtogether.common.world.feature.tree.util.NBTStructure;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.List;

import static corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper.*;

public class ATFeatures {

    public static List<Feature<?>> features = new ArrayList<>();

    public static final Feature<NoFeatureConfig> NBT_STRUCTURE = createFeature("dummy_tree", new NBTStructure(NoFeatureConfig.field_236558_a_));

    public static final Feature<NoisySphereConfig> METEORITE = createFeature("meteorite", new NoisySphere(NoisySphereConfig.CODEC.stable()));


    public static final ATAbstractTreeFeature<ATTreeConfig> TALL_SPECTRAL_TREE_1 = createFeature("tall_spectral_tree_1", new TallSpectralTree1(ATTreeConfig.CODEC.stable()));
    public static final ATAbstractTreeFeature<ATTreeConfig> TALL_SPECTRAL_TREE_2 = createFeature("tall_spectral_tree_2", new TallSpectralTree2(ATTreeConfig.CODEC.stable()));
    public static final ATAbstractTreeFeature<ATTreeConfig> TALL_SPECTRAL_TREE_3 = createFeature("tall_spectral_tree_3", new TallSpectralTree3(ATTreeConfig.CODEC.stable()));

    public static final ATAbstractTreeFeature<ATTreeConfig> SPECTRAL_TREE_1 = createFeature("spectral_tree_1", new TallSpectralTree3(ATTreeConfig.CODEC.stable()));


    public static void init() {
    }
}
