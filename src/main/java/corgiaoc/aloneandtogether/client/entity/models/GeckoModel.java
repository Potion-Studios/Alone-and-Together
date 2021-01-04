package corgiaoc.aloneandtogether.client.entity.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import corgiaoc.aloneandtogether.common.entity.GeckoEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GeckoModel<T extends GeckoEntity> extends AgeableModel<T> {
    private final ModelRenderer Head;
    private final ModelRenderer Snout;
    private final ModelRenderer Tail;
    private final ModelRenderer Legs;
    private final ModelRenderer bb_main;

    public GeckoModel() {
        textureWidth = 32;
        textureHeight = 32;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 22.0F, -3.0F);
        Head.setTextureOffset(18, 27).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        Head.setTextureOffset(10, 25).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 4).addBox(-2.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Head.setTextureOffset(0, 4).addBox(1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Snout = new ModelRenderer(this);
        Snout.setRotationPoint(0.0F, 0.0F, 0.0F);
        Head.addChild(Snout);
        Snout.setTextureOffset(7, 1).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        Snout.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        Tail = new ModelRenderer(this);
        Tail.setRotationPoint(0.0F, 24.0F, 0.0F);
        Tail.setTextureOffset(14, 28).addBox(-1.0F, -2.0F, 3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        Tail.setTextureOffset(6, 9).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        Tail.setTextureOffset(6, 29).addBox(-0.5F, -2.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        Legs = new ModelRenderer(this);
        Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
        Legs.setTextureOffset(28, 23).addBox(-2.5F, -3.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        Legs.setTextureOffset(24, 23).addBox(-2.5F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Legs.setTextureOffset(28, 23).addBox(1.5F, -3.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        Legs.setTextureOffset(24, 23).addBox(1.5F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Legs.setTextureOffset(28, 23).addBox(-2.5F, -3.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        Legs.setTextureOffset(24, 23).addBox(-2.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Legs.setTextureOffset(28, 23).addBox(1.5F, -3.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        Legs.setTextureOffset(24, 23).addBox(1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(16, 1).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        Tail.render(matrixStack, buffer, packedLight, packedOverlay);
        Legs.render(matrixStack, buffer, packedLight, packedOverlay);
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return null;
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return null;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

