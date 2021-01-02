package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.dimension.abyss.world.biome.AbyssBog;
import corgiaoc.aloneandtogether.common.dimension.stellaris.world.biome.Stellaris;
import corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

import static corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper.createBiome;

public class ATBiomes {

    public static List<WorldGenRegistrationHelper.PreserveBiomeOrder> biomes = new ArrayList<>();

    public static final Biome ABYSS_BOG = createBiome("abyss.abyss_bog", new AbyssBog().getBiome(), 0);

    public static final Biome STELLARIS = createBiome("stellaris.stellaris", new Stellaris().getBiome(), 1);




    public static void init() {
    }
}
