package corgiaoc.aloneandtogether.client.entity.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import corgiaoc.aloneandtogether.client.entity.models.GeckoModel;
import corgiaoc.aloneandtogether.common.dimension.abyss.entity.GeckoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

public abstract class AbstractGeckoRenderer<T extends GeckoEntity, M extends GeckoModel<T>> extends MobRenderer<T, M> {
    private final float scale;

    public AbstractGeckoRenderer(EntityRendererManager manager, M model, float scale) {
        super(manager, model, 0.25F);
        this.scale = scale;
    }

    @ParametersAreNonnullByDefault
    @Override
    protected void preRenderCallback(T entity, MatrixStack matrices, float tickTime) {
        if(entity.isChild()) matrices.scale(scale - 0.5F, scale - 0.2F, scale - 0.4F);

        matrices.scale(scale, scale, scale);
        super.preRenderCallback(entity, matrices, tickTime);
    }
}
