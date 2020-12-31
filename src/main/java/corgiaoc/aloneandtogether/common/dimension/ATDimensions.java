package corgiaoc.aloneandtogether.common.dimension;

import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.client.renderer.dimension.AbyssDimensionRenderer;
import corgiaoc.aloneandtogether.common.dimension.abyss.world.biomesource.AbyssBiomeSource;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ATDimensions {
    public static final ResourceLocation ABYSS_ID = new ResourceLocation(AloneAndTogether.MOD_ID,  "abyss");

    public static final RegistryKey<World> ABYSS_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ABYSS_ID);



    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(AloneAndTogether.MOD_ID, "abyss"), AbyssBiomeSource.CODEC);
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerDimensionRenderens() {
        DimensionRenderInfo.field_239208_a_.put(ABYSS_ID, new AbyssDimensionRenderer());
    }
}
