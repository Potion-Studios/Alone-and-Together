package corgiaoc.aloneandtogether.common.dimension.abyss.entity;

import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.core.ATEntities;
import corgiaoc.aloneandtogether.core.world.ATBiomes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = AloneAndTogether.MOD_ID)
public class ATEntitySpawning {
    public static void registerEntityWorldSpawns(BiomeLoadingEvent event, EntityType<?> entity, EntityClassification classification, Biome.Category...categories) {
        for (Biome.Category category : categories)
        if (category !=null) {
            event.getSpawns().withSpawner(classification, new MobSpawnInfo.Spawners(entity, 1000, 2, 6));
        }
    }

    @SubscribeEvent
    public static void createEntitySpawns(BiomeLoadingEvent event){
        registerEntityWorldSpawns(event, ATEntities.GECKO, EntityClassification.AMBIENT, Biome.Category.SWAMP);
        registerEntityWorldSpawns(event, ATEntities.PYRE_FLY, EntityClassification.AMBIENT, Biome.Category.SWAMP);

    }
}

