package corgiaoc.aloneandtogether.common.dimension.stellaris.world;

import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.client.renderer.dimension.StellarisDimensionRenderer;
import corgiaoc.aloneandtogether.client.renderer.dimension.AbyssDimensionRenderer;
import corgiaoc.aloneandtogether.common.dimension.abyss.world.biomesource.AbyssBiomeSource;
import corgiaoc.aloneandtogether.common.dimension.stellaris.world.biomesource.StellarisBiomeSource;
import corgiaoc.aloneandtogether.common.dimension.stellaris.world.chunkgenerator.StellarisChunkGenerator;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ATDimensions {
    public static final ResourceLocation ABYSS_ID = new ResourceLocation(AloneAndTogether.MOD_ID,  "abyss");
    public static final ResourceLocation STELLARIS_ID = new ResourceLocation(AloneAndTogether.MOD_ID,  "stellaris");

    public static final RegistryKey<World> ABYSS_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, ABYSS_ID);
    public static final RegistryKey<World> STELLARIS_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, STELLARIS_ID);

    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(AloneAndTogether.MOD_ID, "abyss"), AbyssBiomeSource.CODEC);
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(AloneAndTogether.MOD_ID, "stellaris"), StellarisBiomeSource.CODEC);
    }

    public static void registerChunkGenerators() {
        Registry.register(Registry.CHUNK_GENERATOR_CODEC, new ResourceLocation(AloneAndTogether.MOD_ID, "stellaris"), StellarisChunkGenerator.CODEC);
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerDimensionRenderers() {
        DimensionRenderInfo.field_239208_a_.put(ABYSS_ID, new AbyssDimensionRenderer());
        DimensionRenderInfo.field_239208_a_.put(STELLARIS_ID, new StellarisDimensionRenderer());
    }
}
