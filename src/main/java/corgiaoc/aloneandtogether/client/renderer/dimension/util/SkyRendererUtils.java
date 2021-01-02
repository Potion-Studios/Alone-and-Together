package corgiaoc.aloneandtogether.client.renderer.dimension.util;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

import java.awt.*;

public class SkyRendererUtils {

    /**
     * DO NOT PUSH AND POP MATRIX STACKS BEFORE AND AFTER THE USAGE OF THIS METHOD
     */
    public static void renderSimpleSkyBox(ResourceLocation skyTexture, MatrixStack matrixStack, Minecraft mc, Tessellator tessellator, BufferBuilder bufferbuilder, Color color) {
        mc.textureManager.bindTexture(skyTexture);

        for (int i = 0; i < 6; ++i) {
            matrixStack.push();
            if (i == 1) {
                matrixStack.rotate(Vector3f.XP.rotationDegrees(90.0F));
            }

            if (i == 2) {
                matrixStack.rotate(Vector3f.XP.rotationDegrees(-90.0F));
            }

            if (i == 3) {
                matrixStack.rotate(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(90.0F));
            }

            if (i == 5) {
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(-90.0F));
            }

            Matrix4f matrix4f = matrixStack.getLast().getMatrix();
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);

            //In .tex(u, v), any number larger than 1 in either u or v will repeat the texture across that axis while making  until the set amount of texture repetitions is reached.
            //UV coordinates is the position of vertex on texture, meaning they control how the texture will be mapped on quad
            bufferbuilder.pos(matrix4f, -100.0F/*Up and Down texture size*/, -100.0F/*Size of the texture or Distance from the player*/, -100.0F/*Left to right texture size*/).tex(0.0F/*Horizontal Axis*/, 0.0F/*Vertical Axis*/).color(45, 45, 45, 255).endVertex();
            bufferbuilder.pos(matrix4f, -100.0F, -100.0F, 100.0F).tex(0.0F, 16.0F).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            bufferbuilder.pos(matrix4f, 100.0F, -100.0F, 100.0F).tex(16.0F, 16.0F).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            bufferbuilder.pos(matrix4f, 100.0F, -100.0F, -100.0F).tex(16.0F, 0.0F).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            tessellator.draw();
            matrixStack.pop();
        }
    }

    /**
     * Requires a push prior to the usage and a push after the usage.
     */
    public static void renderSimpleObject(ResourceLocation objectTexturePath, Quaternion rotation, float rotationTime, float size, MatrixStack matrixStack, Minecraft mc, Tessellator tessellator, BufferBuilder bufferbuilder) {
        mc.textureManager.bindTexture(objectTexturePath);
        matrixStack.rotate(rotation);
        SkyRendererUtils.rotateTextureAroundOrigin(matrixStack, rotationTime);

        Matrix4f matrix4f = matrixStack.getLast().getMatrix();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);

        bufferbuilder.pos(matrix4f, -100.0F/*Up and Down texture size*/, -size/*Size of the texture or Distance from the player*/, -100.0F/*Left to right texture size*/).tex(0.0F/*Horizontal Axis*/, 0.0F/*Vertical Axis*/).color(255, 45, 45, 155).endVertex();
        bufferbuilder.pos(matrix4f, -100.0F, -size, 100.0F).tex(0.0F, 1.0F).color(100, 100, 100, 255).endVertex();
        bufferbuilder.pos(matrix4f, 100.0F, -size, 100.0F).tex(1.0F, 1.0F).color(100, 100, 100, 255).endVertex();
        bufferbuilder.pos(matrix4f, 100.0F, -size, -100.0F).tex(1.0F, 0.0F).color(100, 100, 100, 255).endVertex();
        tessellator.draw();
    }


    public static void rotateTextureAroundOrigin(MatrixStack matrixStack, float rotationAngle) {
        matrixStack.rotate(new Quaternion(0, rotationAngle, 0, true));
    }
}
