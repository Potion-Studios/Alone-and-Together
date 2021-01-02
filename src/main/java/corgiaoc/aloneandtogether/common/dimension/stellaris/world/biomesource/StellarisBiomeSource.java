package corgiaoc.aloneandtogether.common.dimension.stellaris.world.biomesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.aloneandtogether.common.dimension.abyss.world.AbyssBiomeBase;
import corgiaoc.aloneandtogether.common.dimension.layer.ATEdgeLayer;
import corgiaoc.aloneandtogether.common.dimension.layer.ATHillsLayer;
import corgiaoc.aloneandtogether.common.dimension.layer.DatapackLayer;
import corgiaoc.aloneandtogether.common.dimension.layer.WeightedMasterLayer;
import corgiaoc.aloneandtogether.core.world.ATBiomes;
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
public class StellarisBiomeSource extends BiomeProvider {
    public static final Codec<StellarisBiomeSource> CODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((biomeSource) -> biomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((biomeSource) -> biomeSource.seed)).apply(instance, instance.stable(StellarisBiomeSource::new)));

    public static final WeightedList<ResourceLocation> STELLARIS_BIOMES = new WeightedList<>();
    public static final Map<ResourceLocation, WeightedList<ResourceLocation>> STELLARIS_BIOME_TO_SUB_BIOME = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> STELLARIS_BIOME_TO_EDGE = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> STELLARIS_BIOME_TO_BEACH = new HashMap<>();

    private final Registry<Biome> biomeRegistry;
    private final long seed;

    protected StellarisBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(BiomeUtils.fillBiomeSourceList(biomeRegistry, "abyss"));
        fillStellarisBiomeSource(WorldGenRegistries.BIOME);
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new StellarisBiomeSource(this.biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return this.biomeRegistry.getOrDefault(WorldGenRegistries.BIOME.getKey(ATBiomes.STELLARIS));
    }

    public static DatapackLayer stackStellarisLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> layer = new WeightedMasterLayer(biomeRegistry, STELLARIS_BIOMES).apply(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= 4; endBiomeSize++) {
            layer = ZoomLayer.NORMAL.apply(randomProvider.apply(49596L + endBiomeSize), layer);
        }

        layer = new ATHillsLayer(biomeRegistry, STELLARIS_BIOME_TO_SUB_BIOME, 3).apply(randomProvider.apply(2848586786L), layer, layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(495949586L), layer);
        layer = ZoomLayer.FUZZY.apply(randomProvider.apply(34885L), layer);
        layer = new ATEdgeLayer(biomeRegistry, STELLARIS_BIOME_TO_EDGE).apply(randomProvider.apply(2848586786L), layer);
        layer = ZoomLayer.FUZZY.apply(randomProvider.apply(395885L), layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(28475786L), layer);
        return new DatapackLayer(layer, "Stellaris");
    }



    //TODO: USE DATAPACK REGISTRIES AND CONFIG DATA
    public static void fillStellarisBiomeSource(Registry<Biome> biomeRegistry) {
        clearData(); //Clear before filling these lists again, prevents duplicate entries and preserving old entries.
        for (AbyssBiomeBase abyssBiomeBase : AbyssBiomeBase.UNREGISTERED_ABYSS_BIOME_CACHE) {
            STELLARIS_BIOMES.func_226313_a_(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getWeight());
            if (abyssBiomeBase.getHills() != null)
                STELLARIS_BIOME_TO_SUB_BIOME.put(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getHills());
            if (abyssBiomeBase.getEdge() != null)
                STELLARIS_BIOME_TO_EDGE.put(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getEdge());
            if (abyssBiomeBase.getBeach() != null)
                STELLARIS_BIOME_TO_BEACH.put(abyssBiomeBase.getID(biomeRegistry), abyssBiomeBase.getBeach());
        }
    }

    private static void clearData() {
        STELLARIS_BIOMES.field_220658_a.clear();
        STELLARIS_BIOME_TO_SUB_BIOME.clear();
        STELLARIS_BIOME_TO_EDGE.clear();
        STELLARIS_BIOME_TO_BEACH.clear();
    }
}