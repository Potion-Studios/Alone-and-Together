package corgiaoc.aloneandtogether.common.dimension.abyss.world.biomesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Collections;

public class AbyssBiomeSource extends BiomeProvider {
    public static final Codec<AbyssBiomeSource> CODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((biomeSource) -> biomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((biomeSource) -> biomeSource.seed)).apply(instance, instance.stable(AbyssBiomeSource::new)));

    private final Registry<Biome> biomeRegistry;
    private final long seed;

    protected AbyssBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(Collections.singletonList(biomeRegistry.getOptional(Biomes.THE_VOID.getLocation()).get()));
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
        return biomeRegistry.getOptional(Biomes.THE_VOID.getLocation()).get();
    }
}