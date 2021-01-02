package corgiaoc.aloneandtogether.util;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BiomeUtils {
    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = MathHelper.clamp(g, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }


    public static List<Biome> fillBiomeSourceList(Registry<Biome> biomeRegistry, String dimensionPrefix) {
        List<Biome> biomeList = new ArrayList<>();
        Set<Map.Entry<RegistryKey<Biome>, Biome>> entries = biomeRegistry.getEntries();
        for (Map.Entry<RegistryKey<Biome>, Biome> entry : entries) {
            Biome biome = entry.getValue();
            RegistryKey<Biome> entryKey = entry.getKey();
            ResourceLocation entryKeyLocation = entryKey.getLocation();

            if (entryKeyLocation.getPath().contains(dimensionPrefix.replace(".", "") + ".")) {
                biomeList.add(biome);
            }
        }
        return biomeList;
    }


    private static double target(INoiseRandom random, double weightTotal) {
        return (double) random.random(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }

    public static ResourceLocation getBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom layerNoise) {
        return pickBiomeFromID(biomeWeightedList, layerNoise);
    }

    public static ResourceLocation pickBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom rand) {
        double total = 0;

        for (WeightedList.Entry<ResourceLocation> biomeEntry : biomeWeightedList.field_220658_a)
            total = total + biomeEntry.field_220652_c;

        double randVal = target(rand, total);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= biomeWeightedList.field_220658_a.get(i).field_220652_c;
        }

        return biomeWeightedList.field_220658_a.get(i).func_220647_b();
    }
}
