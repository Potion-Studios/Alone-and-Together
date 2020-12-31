package corgiaoc.aloneandtogether.client.renderer.dimension;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nullable;

public class AbyssDimensionRenderer extends DimensionRenderInfo {

    public AbyssDimensionRenderer() {
        super(Float.NaN, true, DimensionRenderInfo.FogType.NONE, false, true);
    }

    @Override
    public Vector3d func_230494_a_(Vector3d vec3D, float p_230494_2_) {
        return vec3D;
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

        @Override
        public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {

        }
    }
}
