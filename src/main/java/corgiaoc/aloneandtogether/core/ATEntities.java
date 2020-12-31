package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ATEntities {

    public static List<EntityType<?>> entities = new ArrayList<>();


    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
//        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(BYG.MOD_ID, id), entityType);
        entityType.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
