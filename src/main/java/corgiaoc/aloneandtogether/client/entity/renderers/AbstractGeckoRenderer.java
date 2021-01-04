package corgiaoc.aloneandtogether.client.entity.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import corgiaoc.aloneandtogether.client.entity.models.GeckoModel;
import corgiaoc.aloneandtogether.common.entity.GeckoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class AbstractGeckoRenderer <T extends GeckoEntity, M extends GeckoModel<T>> extends MobRenderer<T, M> {
    private final float scale;

    public AbstractGeckoRenderer(EntityRendererManager renderManagerIn, M p_i50975_2_, float scaleIn) {
        super(renderManagerIn, p_i50975_2_, 0.75F);
        this.scale = scaleIn;
    }

    protected void preRenderCallback(T entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(this.scale, this.scale, this.scale);
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    @Nullable
    public ResourceLocation getEntityTexture(T entity) {
        return null;
    }
}
