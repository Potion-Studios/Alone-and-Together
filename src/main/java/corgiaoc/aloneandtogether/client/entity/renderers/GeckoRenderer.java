package corgiaoc.aloneandtogether.client.entity.renderers;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.client.entity.models.GeckoModel;
import corgiaoc.aloneandtogether.common.entity.GeckoEntity;
import corgiaoc.aloneandtogether.common.entity.SkinColors;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HorseMarkingsLayer;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

import javax.annotation.Nullable;
import java.util.Map;

public final class GeckoRenderer extends AbstractGeckoRenderer<GeckoEntity, GeckoModel<GeckoEntity>> {
    private static final Map<SkinColors, ResourceLocation> getTexture = Util.make(Maps.newEnumMap(SkinColors.class), (p_239384_0_) -> {
     p_239384_0_.put(SkinColors.WHITE, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/white_gecko.png"));
      p_239384_0_.put(SkinColors.BLUE, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/blue_gecko.png"));
      p_239384_0_.put(SkinColors.GREEN, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/green_gecko.png"));
      p_239384_0_.put(SkinColors.BROWN, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/brown_gecko.png"));
      p_239384_0_.put(SkinColors.BLACK, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/black_gecko.png"));
      p_239384_0_.put(SkinColors.RED, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/red_gecko.png"));
      p_239384_0_.put(SkinColors.ORANGE, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/orange_gecko.png"));
});

    public GeckoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GeckoModel<>(0.0F), 1.1F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GeckoEntity entity) {
        return getTexture.get(entity.getSkinColor());
    }

}
