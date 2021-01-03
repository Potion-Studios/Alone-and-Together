package corgiaoc.aloneandtogether.common.dimension.stellaris.world.biome.util;

import corgiaoc.aloneandtogether.common.ATBiomeBase;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

import java.util.HashSet;
import java.util.Set;

public abstract class StellarisBiomeBase extends ATBiomeBase {

    public static final Set<StellarisBiomeBase> UNREGISTERED_STELLARIS_BIOME_CACHE = new HashSet<>();

    public StellarisBiomeBase(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        super(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        UNREGISTERED_STELLARIS_BIOME_CACHE.add(this);
    }

    public StellarisBiomeBase(Biome.Builder builder) {
        super(builder);
        UNREGISTERED_STELLARIS_BIOME_CACHE.add(this);
    }

    public StellarisBiomeBase(Biome biome) {
        super(biome);
        UNREGISTERED_STELLARIS_BIOME_CACHE.add(this);
    }
}
