package corgiaoc.aloneandtogether.client.entity.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import corgiaoc.aloneandtogether.client.entity.models.GeckoModel;
import corgiaoc.aloneandtogether.common.entity.GeckoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class AbstractGeckoRenderer<T extends GeckoEntity, M extends GeckoModel<T>> extends MobRenderer<T, M> {
    private final float SCALE;

    public AbstractGeckoRenderer(EntityRendererManager renderManagerIn, M model, float scaleIn) {
        super(renderManagerIn, model, 0.25F);
        this.SCALE = scaleIn;
    }

    protected void preRenderCallback(T entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(this.SCALE, this.SCALE, this.SCALE);
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    @Nullable
    public ResourceLocation getEntityTexture(T entity) {
        return null;
    }
}
