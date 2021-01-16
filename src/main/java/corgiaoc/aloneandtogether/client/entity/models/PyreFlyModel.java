package corgiaoc.aloneandtogether.client.entity.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import corgiaoc.aloneandtogether.common.dimension.abyss.entity.PyreFlyEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class PyreFlyModel<T extends PyreFlyEntity> extends AgeableModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer wings;
    private final ModelRenderer wingLeftBack_r1;
    private final ModelRenderer wingLeftFront_r1;
    private final ModelRenderer wingRightBack_r1;
    private final ModelRenderer wingRightFront_r1;

    public PyreFlyModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -7.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 5).addBox(-0.5F, -1.5F, -5.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 24.0F, 0.0F);
        tail.setTextureOffset(0, 18).addBox(0.0F, -1.4F, -1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        wings = new ModelRenderer(this);
        wings.setRotationPoint(0.0F, 24.0F, 0.0F);


        wingLeftBack_r1 = new ModelRenderer(this);
        wingLeftBack_r1.setRotationPoint(1.0F, -1.0F, -2.0F);
        wings.addChild(wingLeftBack_r1);
        setRotationAngle(wingLeftBack_r1, 0.0F, -0.1309F, 0.0F);
        wingLeftBack_r1.setTextureOffset(48, 10).addBox(0.0F, 0.0F, -1.0F, 6.0F, 0.0F, 2.0F, 0.0F, false);

        wingLeftFront_r1 = new ModelRenderer(this);
        wingLeftFront_r1.setRotationPoint(1.0F, -1.0F, -4.0F);
        wings.addChild(wingLeftFront_r1);
        setRotationAngle(wingLeftFront_r1, 0.0F, 0.0436F, 0.0F);
        wingLeftFront_r1.setTextureOffset(48, 8).addBox(0.0F, 0.0F, -1.0F, 6.0F, 0.0F, 2.0F, 0.0F, false);

        wingRightBack_r1 = new ModelRenderer(this);
        wingRightBack_r1.setRotationPoint(0.0F, -1.0F, -2.0F);
        wings.addChild(wingRightBack_r1);
        setRotationAngle(wingRightBack_r1, 0.0F, 0.1309F, 0.0F);
        wingRightBack_r1.setTextureOffset(48, 6).addBox(-6.0F, 0.0F, -1.0F, 6.0F, 0.0F, 2.0F, 0.0F, false);

        wingRightFront_r1 = new ModelRenderer(this);
        wingRightFront_r1.setRotationPoint(0.0F, -1.0F, -4.0F);
        wings.addChild(wingRightFront_r1);
        setRotationAngle(wingRightFront_r1, 0.0F, -0.0436F, 0.0F);
        wingRightFront_r1.setTextureOffset(48, 4).addBox(-6.0F, 0.0F, -1.0F, 6.0F, 0.0F, 2.0F, 0.0F, false);
    }


    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return null;
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return null;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.wingRightFront_r1.rotateAngleX = 0.0F;
        boolean flag = entityIn.isOnGround() && entityIn.getMotion().lengthSquared() < 1.0E-7D;
        if (flag) {
            this.wingRightFront_r1.rotateAngleY = -0.2618F;
            this.wingRightFront_r1.rotateAngleZ = 0.0F;
            this.wingLeftFront_r1.rotateAngleX = 0.0F;
            this.wingLeftFront_r1.rotateAngleY = 0.2618F;
            this.wingLeftFront_r1.rotateAngleZ = 0.0F;
        } else {
            float f = ageInTicks * 2.1F;
            this.wingRightFront_r1.rotateAngleY = 0.0F;
            this.wingRightFront_r1.rotateAngleZ = MathHelper.cos(f) * (float)Math.PI * 0.15F;
            this.wingRightBack_r1.rotateAngleY = 0.0F;
            this.wingRightBack_r1.rotateAngleZ = MathHelper.cos(f) * (float)Math.PI * 0.15F;
            this.wingLeftFront_r1.rotateAngleX = this.wingRightFront_r1.rotateAngleX;
            this.wingLeftFront_r1.rotateAngleY = this.wingRightFront_r1.rotateAngleY;
            this.wingLeftFront_r1.rotateAngleZ = -this.wingRightFront_r1.rotateAngleZ;
            this.wingLeftBack_r1.rotateAngleX = this.wingRightBack_r1.rotateAngleX;
            this.wingLeftBack_r1.rotateAngleY = this.wingRightBack_r1.rotateAngleY;
            this.wingLeftBack_r1.rotateAngleZ = -this.wingRightBack_r1.rotateAngleZ;
        }

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        wings.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
