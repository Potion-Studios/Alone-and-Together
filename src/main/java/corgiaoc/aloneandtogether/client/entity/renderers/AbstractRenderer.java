package corgiaoc.aloneandtogether.client.entity.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.entity.MobEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public abstract class AbstractRenderer<T extends MobEntity, M extends AgeableModel<T>> extends MobRenderer<T, M> {
    private final float scale;

    public AbstractRenderer(EntityRendererManager manager, M model, float scale) {
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
