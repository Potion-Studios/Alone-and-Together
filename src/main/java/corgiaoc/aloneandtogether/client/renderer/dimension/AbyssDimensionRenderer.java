package corgiaoc.aloneandtogether.client.renderer.dimension;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nullable;
import java.awt.*;

import static corgiaoc.aloneandtogether.client.renderer.dimension.util.SkyRendererUtils.*;

public class AbyssDimensionRenderer extends DimensionRenderInfo {

    public AbyssDimensionRenderer() {
        super(Float.NaN, true, DimensionRenderInfo.FogType.NONE, false, true);
    }

    @Override
    public Vector3d func_230494_a_(Vector3d vec3D, float p_230494_2_) {
        return Vector3d.ZERO;
    }

    @Override
    public boolean func_230493_a_(int p_230493_1_, int p_230493_2_) {
        return true;
    }

    @Nullable
    @Override
    public ISkyRenderHandler getSkyRenderHandler() {
        return new AbyssSkyRenderer();
    }

    public static class AbyssSkyRenderer implements ISkyRenderHandler {

        public static final ResourceLocation ABYSS_SKY = new ResourceLocation(AloneAndTogether.MOD_ID, "textures/environment/abyss_sky.png");
        public static final ResourceLocation ABYSS_GALAXY = new ResourceLocation(AloneAndTogether.MOD_ID, "textures/environment/abyss_galaxy.png");

        @Override
        public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {
            RenderSystem.disableAlphaTest();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.depthMask(false);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();

            renderSimpleSkyBox(ABYSS_SKY, matrixStack, mc, tessellator, bufferbuilder, new Color(100, 100, 100, 255));

            RenderSystem.depthMask(true);
            RenderSystem.enableTexture();
            RenderSystem.disableBlend();
            RenderSystem.enableAlphaTest();
        }
    }
}
