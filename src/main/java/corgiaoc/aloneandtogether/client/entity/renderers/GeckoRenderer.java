package corgiaoc.aloneandtogether.client.entity.renderers;

import com.google.common.collect.Maps;
import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.client.entity.models.GeckoModel;
import corgiaoc.aloneandtogether.common.entity.GeckoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

import javax.annotation.Nullable;
import java.util.Map;

public final class GeckoRenderer extends AbstractGeckoRenderer<GeckoEntity, GeckoModel<GeckoEntity>> {


    private static final Map<GeckoEntity.SkinColors, ResourceLocation> GECKO_TEXTURE = Util.make(Maps.newEnumMap(GeckoEntity.SkinColors.class), (textureMap) -> {
        textureMap.put(GeckoEntity.SkinColors.BLUE, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/blue_gecko.png"));
        textureMap.put(GeckoEntity.SkinColors.WHITE, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/white_gecko.png"));
        textureMap.put(GeckoEntity.SkinColors.GREEN, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/green_gecko.png"));
        textureMap.put(GeckoEntity.SkinColors.BROWN, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/brown_gecko.png"));
        textureMap.put(GeckoEntity.SkinColors.BLACK, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/black_gecko.png"));
        textureMap.put(GeckoEntity.SkinColors.RED, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/red_gecko.png"));
        textureMap.put(GeckoEntity.SkinColors.ORANGE, new ResourceLocation(AloneAndTogether.MOD_ID, "textures/entity/gecko/orange_gecko.png"));
    });

    public GeckoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GeckoModel<>(), 1.0F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GeckoEntity entity) {
        return GECKO_TEXTURE.get(entity.getSkinColor());
    }

}