package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.dimension.abyss.world.biome.*;
import corgiaoc.aloneandtogether.common.dimension.stellaris.world.biome.Stellaris;
import corgiaoc.aloneandtogether.common.world.DummyBiome;
import corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

import static corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper.createBiome;

public class ATBiomes {

    public static List<WorldGenRegistrationHelper.PreserveBiomeOrder> biomes = new ArrayList<>();

    public static final Biome ABYSS_BOG = createBiome("abyss.abyss_bog", new AbyssBog().getBiome(), 0);
    public static final Biome TUBERAL_MANGROVES = createBiome("abyss.tuberal_mangroves", new TuberalMangroves().getBiome(), 3);
    public static final Biome ORVIUM_TROPICS = createBiome("abyss.orvium_tropics", new OrviumTropics().getBiome(), 4);
    public static final Biome SCULKED_HIGHLANDS = createBiome("abyss.sculked_highlands", new SculkedHighlands().getBiome(), 5);
    public static final Biome OBILITH_FIELDS = createBiome("abyss.obilith_fields", new ObilithFields().getBiome(), 6);

    public static final Biome STELLARIS = createBiome("stellaris.stellaris", new Stellaris().getBiome(), 1);

    public static final Biome DUMMY = createBiome("dummy", new DummyBiome().getBiome(), 2);



    public static void init() {
    }
}
