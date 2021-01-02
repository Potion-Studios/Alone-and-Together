package corgiaoc.aloneandtogether.common.dimension.abyss.world;

import corgiaoc.aloneandtogether.common.ATBiomeBase;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

import java.util.HashSet;
import java.util.Set;

public abstract class AbyssBiomeBase extends ATBiomeBase {

    public static final Set<AbyssBiomeBase> UNREGISTERED_ABYSS_BIOME_CACHE = new HashSet<>();

    public AbyssBiomeBase(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        super(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        UNREGISTERED_ABYSS_BIOME_CACHE.add(this);
    }

    public AbyssBiomeBase(Biome.Builder builder) {
        super(builder);
        UNREGISTERED_ABYSS_BIOME_CACHE.add(this);
    }

    public AbyssBiomeBase(Biome biome) {
        super(biome);
        UNREGISTERED_ABYSS_BIOME_CACHE.add(this);
    }
}
