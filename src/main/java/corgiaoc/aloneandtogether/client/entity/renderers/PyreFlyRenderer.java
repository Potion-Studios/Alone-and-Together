package corgiaoc.aloneandtogether.client.entity.renderers;

import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.client.entity.models.PyreFlyModel;
import corgiaoc.aloneandtogether.common.dimension.abyss.entity.PyreFlyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class PyreFlyRenderer<T extends PyreFlyEntity> extends AbstractRenderer<T, PyreFlyModel<T>> {


    private static final ResourceLocation PYRE_FLY_TEXTURES = new ResourceLocation(AloneAndTogether.MOD_ID,"textures/entity/pyre_fly.png");

    public PyreFlyRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PyreFlyModel<>(), 1.0F);

    }

    @Override
    public ResourceLocation getEntityTexture(PyreFlyEntity entity) {
        return PYRE_FLY_TEXTURES;
    }
}

