package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.world.feature.NoisySphere;
import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.List;

public class ATFeatures {

    public static List<Feature<?>> features = new ArrayList<>();

    public static final Feature<NoisySphereConfig> METEORITE = WorldGenRegistrationHelper.createFeature("meteorite", new NoisySphere(NoisySphereConfig.CODEC.stable()));


    public static void init() {
    }
}
