package corgiaoc.aloneandtogether.common.dimension.layer;

import corgiaoc.aloneandtogether.util.BiomeUtils;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;

import javax.annotation.Nullable;
import java.util.Map;

public class ATHillsLayer implements IAreaTransformer2, IDimOffset1Transformer {

    private final Int2ObjectOpenHashMap<WeightedList<ResourceLocation>> hillMap;
    private final Registry<Biome> biomeRegistry;
    private final int hillReplacementChance;

    public ATHillsLayer(Registry<Biome> biomeRegistry, Map<ResourceLocation, WeightedList<ResourceLocation>> hillMap, int hillReplacementChance) {
        this.hillMap = new Int2ObjectOpenHashMap<>();
        hillMap.forEach((biome, weightedHills) -> {
            int biomeID = biomeRegistry.getId(biomeRegistry.getOptional(biome).orElseThrow(RuntimeException::new));
            this.hillMap.put(biomeID, weightedHills);
        });


        this.biomeRegistry = biomeRegistry;
        this.hillReplacementChance = hillReplacementChance;
    }


    @SuppressWarnings("ConstantConditions")
    public int apply(INoiseRandom rand, IArea area1, IArea area2, int x, int z) {
        int i = area1.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 1));

        if (hillMap.size() > 0) {
            if (rand.random(hillReplacementChance) == 0) {
                int l = i;
                if (hillMap.containsKey(i)) {
                    Biome hill = getHillBiomeValue(hillMap.get(i), rand);
                    if (hill != null) {
                        l = biomeRegistry.getId(hill);
                    }
                }
                return l;
            }
        }
        return i;
    }

    @Nullable
    private Biome getHillBiomeValue(WeightedList<ResourceLocation> biomeHolder, INoiseRandom layerRandom) {
        if (biomeHolder.field_220658_a.size() > 0) {
            return biomeRegistry.getOrDefault(BiomeUtils.getBiomeFromID(biomeHolder, layerRandom));
        }
        else {
            return null;
        }
    }
}