package corgiaoc.aloneandtogether.client.renderer.dimension;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import corgiaoc.aloneandtogether.AloneAndTogether;
import corgiaoc.aloneandtogether.client.renderer.dimension.util.SkyRendererUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class StellarisDimensionRenderer extends DimensionRenderInfo {

    public StellarisDimensionRenderer() {
        super(Float.NaN, false, FogType.NONE, false, true);
    }

    @Override
    public Vector3d func_230494_a_(Vector3d vec3D, float p_230494_2_) {
        return Vector3d.ZERO;
    }

    @Override
    public boolean func_230493_a_(int p_230493_1_, int p_230493_2_) {
        return false;
    }

    @Nullable
    @Override
    public ISkyRenderHandler getSkyRenderHandler() {
        return new StellarisSkyRenderer();
    }

    public static class StellarisSkyRenderer implements ISkyRenderHandler {

        public static final ResourceLocation PLANET = new ResourceLocation(AloneAndTogether.MOD_ID, "textures/environment/stellaris/planet.png");

        private final VertexFormat skyVertexFormat = DefaultVertexFormats.POSITION;

        private VertexBuffer starVertexBuffer;

        public StellarisSkyRenderer() {
            generateStarData(15000);
        }

        private void generateStarData(int numberOfStars) {
            BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();

            if (this.starVertexBuffer != null) {
                this.starVertexBuffer.close();
                starVertexBuffer = null;
            }

            this.starVertexBuffer = new VertexBuffer(skyVertexFormat);
            uploadStarData(bufferBuilder, numberOfStars);
            bufferBuilder.finishDrawing();
            this.starVertexBuffer.upload(bufferBuilder);
        }

        @Override
        public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {
            RenderSystem.disableAlphaTest();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.depthMask(false);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();

//            renderSimpleSkyBox(ABYSS_SKY, matrixStack, mc, tessellator, bufferbuilder, new Color(65, 65, 65, 255));

            matrixStack.push();
            matrixStack.rotate(Vector3f.XP.rotation(mc.world.func_242415_f(partialTicks) * 10)); //Make stars move slowly overtime
            renderStarData(starVertexBuffer, matrixStack, skyVertexFormat);
            matrixStack.pop();

            matrixStack.push();
            SkyRendererUtils.renderSimpleObject(PLANET, Vector3f.XP.rotation(90), 0, 100, matrixStack, mc, tessellator, bufferbuilder);
            matrixStack.pop();

            RenderSystem.depthMask(true);
            RenderSystem.enableTexture();
            RenderSystem.disableBlend();
            RenderSystem.enableAlphaTest();
        }

        private static void renderStarData(VertexBuffer starVBO, MatrixStack matrixStack, VertexFormat vertexFormat) {
            float brightness = 255.0F;
            RenderSystem.color4f(brightness, brightness, brightness, brightness);
            starVBO.bindBuffer();
            vertexFormat.setupBufferState(0L);
            starVBO.draw(matrixStack.getLast().getMatrix(), 7);
            VertexBuffer.unbindBuffer();
            vertexFormat.clearBufferState();
//            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//            RenderSystem.disableBlend();
//            RenderSystem.enableAlphaTest();
//            RenderSystem.enableFog();
        }

        private static void uploadStarData(BufferBuilder bufferBuilder, int numberOfStars) {
            Random random = new Random(10842L);
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION);

            for(int i = 0; i < numberOfStars; ++i) {
                double d0 = random.nextFloat() * 2.0F - 1.0F;
                double d1 = random.nextFloat() * 2.0F - 1.0F;
                double d2 = random.nextFloat() * 2.0F - 1.0F;
                double d3 = 0.15F + random.nextFloat() * 0.1F;
                double d4 = d0 * d0 + d1 * d1 + d2 * d2;
                if (d4 < 1.0D && d4 > 0.01D) {
                    d4 = 1.0D / Math.sqrt(d4);
                    d0 = d0 * d4;
                    d1 = d1 * d4;
                    d2 = d2 * d4;
                    double d5 = d0 * 100.0D;
                    double d6 = d1 * 100.0D;
                    double d7 = d2 * 100.0D;
                    double d8 = Math.atan2(d0, d2);
                    double d9 = Math.sin(d8);
                    double d10 = Math.cos(d8);
                    double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                    double d12 = Math.sin(d11);
                    double d13 = Math.cos(d11);
                    double d14 = random.nextDouble() * Math.PI * 2.0D;
                    double d15 = Math.sin(d14);
                    double d16 = Math.cos(d14);

                    for(int j = 0; j < 4; ++j) {
                        double d18 = (double)((j & 2) - 1) * d3;
                        double d19 = (double)((j + 1 & 2) - 1) * d3;
                        double d21 = d18 * d16 - d19 * d15;
                        double d22 = d19 * d16 + d18 * d15;
                        double d23 = d21 * d12 + 0.0D * d13;
                        double d24 = 0.0D * d12 - d21 * d13;
                        double d25 = d24 * d9 - d22 * d10;
                        double d26 = d22 * d9 + d24 * d10;
                        bufferBuilder.pos(d5 + d25, d6 + d23, d7 + d26).endVertex();
                    }
                }
            }
        }
    }
}
