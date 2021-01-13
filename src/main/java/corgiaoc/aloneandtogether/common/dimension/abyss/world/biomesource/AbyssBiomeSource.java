package corgiaoc.aloneandtogether.common.dimension.abyss.world.biomesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.aloneandtogether.common.dimension.abyss.world.AbyssBiomeBase;
import corgiaoc.aloneandtogether.common.world.layer.ATEdgeLayer;
import corgiaoc.aloneandtogether.common.world.layer.ATHillsLayer;
import corgiaoc.aloneandtogether.common.world.layer.DatapackLayer;
import corgiaoc.aloneandtogether.common.world.layer.WeightedMasterLayer;
import corgiaoc.aloneandtogether.util.BiomeUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.LongFunction;

@SuppressWarnings("deprecation")
public class AbyssBiomeSource extends BiomeProvider {
    public static final Codec<AbyssBiomeSource> CODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((biomeSource) -> biomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((biomeSource) -> biomeSource.seed)).apply(instance, instance.stable(AbyssBiomeSource::new)));

    public static final WeightedList<ResourceLocation> ABYSS_BIOMES = new WeightedList<>();
    public static final Map<ResourceLocation, WeightedList<ResourceLocation>> ABYSS_BIOME_TO_SUB_BIOME = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> ABYSS_BIOME_TO_EDGE = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> ABYSS_BIOME_TO_BEACH = new HashMap<>();

    private final Registry<Biome> biomeRegistry;
    private final long seed;

    protected AbyssBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(BiomeUtils.fillBiomeSourceList(biomeRegistry, "abyss"));
        fillAbyssBiomeSource(WorldGenRegistries.BIOME);
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new AbyssBiomeSource(this.biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return stackAbyssLayers(this.biomeRegistry, this.seed).sample(biomeRegistry, x, z);
    }

    public static DatapackLayer stackAbyssLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> layer = new WeightedMasterLayer(biomeRegistry, ABYSS_BIOMES).apply(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= 4; endBiomeSize++) {
            layer = ZoomLayer.NORMAL.apply(randomProvider.apply(49596L + endBiomeSize), layer);
        }

        layer = new ATHillsLayer(biomeRegistry, ABYSS_BIOME_TO_SUB_BIOME, 3).apply(randomProvider.apply(2848586786L), layer, layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(495949586L), layer);
        layer = ZoomLayer.FUZZY.apply(randomProvider.apply(34885L), layer);
        layer = new ATEdgeLayer(biomeRegistry, ABYSS_BIOME_TO_EDGE).apply(randomProvider.apply(2848586786L), layer);
        layer = ZoomLayer.FUZZY.apply(randomProvider.apply(395885L), layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(28475786L), layer);
        return new DatapackLayer(layer, "Abyss");
    }



    //TODO: USE DATAPACK REGISTRIES AND CONFIG DATA
    public static void fillAbyssBiomeSource(Registry<Biome> biomeRegistry) {
        clearData(); //Clear before filling these lists again, prevents duplicate entries and preserving old entries.
        for (AbyssBiomeBase abyssBiomeBase : AbyssBiomeBase.UNREGISTERED_ABYSS_BIOME_CACHE) {
            ABYSS_BIOMES.func_226313_a_(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getWeight());
            if (abyssBiomeBase.getHills() != null)
                ABYSS_BIOME_TO_SUB_BIOME.put(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getHills());
            if (abyssBiomeBase.getEdge() != null)
                ABYSS_BIOME_TO_EDGE.put(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getEdge());
            if (abyssBiomeBase.getBeach() != null)
                ABYSS_BIOME_TO_BEACH.put(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getBeach());
        }
    }

    private static void clearData() {
        ABYSS_BIOMES.field_220658_a.clear();
        ABYSS_BIOME_TO_SUB_BIOME.clear();
        ABYSS_BIOME_TO_EDGE.clear();
        ABYSS_BIOME_TO_BEACH.clear();
    }
}