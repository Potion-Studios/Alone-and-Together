package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.common.dimension.abyss.entity.GeckoEntity;
import corgiaoc.aloneandtogether.common.dimension.abyss.entity.PyreFlyEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ATEntities {
    public static List<EntityType<?>> entities = new ArrayList<>();

    public static final EntityType<GeckoEntity> GECKO = createEntity("gecko", EntityType.Builder.create(GeckoEntity::new, EntityClassification.AMBIENT).size(0.4f,0.4f).build("gecko"));
    public static final EntityType<PyreFlyEntity> PYRE_FLY = createEntity("pyre_fly", EntityType.Builder.create(PyreFlyEntity::new, EntityClassification.AMBIENT).size(0.4f,0.25f).build("pyre_fly"));


    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
//        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(BYG.MOD_ID, id), entityType);
        entityType.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id)); //Forge
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
