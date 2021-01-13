package corgiaoc.aloneandtogether.common.world.layer;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class ATEdgeLayer implements ICastleTransformer {

    private final Int2IntOpenHashMap biomeToEdgeMap;
    private final Int2IntOpenHashMap biomeToBeachMap;
    private final IntSet oceans;

    public ATEdgeLayer(Registry<Biome> biomeRegistry, Map<ResourceLocation, ResourceLocation> biomeToEdgeMap) {
        this(biomeRegistry, biomeToEdgeMap, null, null);
    }

    public ATEdgeLayer(Registry<Biome> biomeRegistry, Map<ResourceLocation, ResourceLocation> biomeToEdgeMap, @Nullable Map<ResourceLocation, ResourceLocation> biomeToBeachMap, @Nullable Set<ResourceLocation> oceans) {
        this.biomeToEdgeMap = new Int2IntOpenHashMap();
        this.biomeToBeachMap = new Int2IntOpenHashMap();
        this.oceans = oceans != null ? new IntOpenHashSet(oceans.stream().map(biomeRegistry::getOptional).map(Optional::get).map(biomeRegistry::getId).collect(Collectors.toSet())) : null;

        if (!biomeToEdgeMap.isEmpty()) {
            biomeToEdgeMap.forEach((biome, edgeBiome) -> {
                int biomeId = biomeRegistry.getId(biomeRegistry.getOptional(biome).orElseThrow(RuntimeException::new));
                int biomeEdgeID = biomeRegistry.getId(biomeRegistry.getOptional(edgeBiome).orElseThrow(RuntimeException::new));
                this.biomeToEdgeMap.put(biomeId, biomeEdgeID);
            });
        }

        if (biomeToBeachMap != null) {
            biomeToBeachMap.forEach((biome, beachBiome) -> {
                int biomeId = biomeRegistry.getId(biomeRegistry.getOptional(biome).orElseThrow(RuntimeException::new));
                int biomeBeachID = biomeRegistry.getId(biomeRegistry.getOptional(beachBiome).orElseThrow(RuntimeException::new));
                this.biomeToBeachMap.put(biomeId, biomeBeachID);
            });
        }

    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public int apply(INoiseRandom context, int n, int w, int s, int e, int centre) {
        final int[] ArrayNESW = {n, w, s, e};

        for (int idx : ArrayNESW) {
            if (biomeToEdgeMap.containsKey(idx) && idx != centre) {
                return biomeToEdgeMap.get(centre);
            }

            if (biomeToBeachMap != null) {
                if (biomeToBeachMap.containsKey(idx)) {
                    if (oceans.contains(idx)) {
                        return biomeToBeachMap.get(centre);
                    }
                }
            }
        }
        return centre;
    }
}