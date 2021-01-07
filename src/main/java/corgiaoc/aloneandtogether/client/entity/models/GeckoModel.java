package corgiaoc.aloneandtogether.client.entity.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import corgiaoc.aloneandtogether.common.entity.GeckoEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import java.util.function.Function;

public class GeckoModel<T extends GeckoEntity> extends AgeableModel<T> {
    private final ModelRenderer Head;
    private final ModelRenderer Snout;
    private final ModelRenderer Tail;
    private final ModelRenderer TailBack_r1;
    private final ModelRenderer Tail_r1;
    private final ModelRenderer legsBackRight;
    private final ModelRenderer legsFrontRight;
    private final ModelRenderer legsFrontLeft;
    private final ModelRenderer legsBackLeft;
    private final ModelRenderer bb_main;


    public GeckoModel() {
        textureWidth = 32;
        textureHeight = 32;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 22.0F, -3.0F);
        Head.setTextureOffset(18, 27).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        Head.setTextureOffset(10, 29).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 30).addBox(-2.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Head.setTextureOffset(0, 30).addBox(1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Snout = new ModelRenderer(this);
        Snout.setRotationPoint(0.0F, 0.0F, 0.0F);
        Head.addChild(Snout);
        Snout.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        Snout.setTextureOffset(0, 4).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        Tail = new ModelRenderer(this);
        Tail.setRotationPoint(0.0F, 24.0F, 0.0F);
        Tail.setTextureOffset(26, 5).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

        TailBack_r1 = new ModelRenderer(this);
        TailBack_r1.setRotationPoint(0.0F, -1.5F, 6.0F);
        Tail.addChild(TailBack_r1);
        setRotationAngle(TailBack_r1, -0.3142F, 0.0F, 0.0F);
        TailBack_r1.setTextureOffset(26, 7).addBox(-0.5F, -0.1F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        Tail_r1 = new ModelRenderer(this);
        Tail_r1.setRotationPoint(0.0F, -1.5F, 3.0F);
        Tail.addChild(Tail_r1);
        setRotationAngle(Tail_r1, -0.1309F, 0.0F, 0.0F);
        Tail_r1.setTextureOffset(22, 0).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        legsBackRight = new ModelRenderer(this);
        legsBackRight.setRotationPoint(-1.5F, 21.5F, 1.5F);
        legsBackRight.setTextureOffset(28, 12).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        legsBackRight.setTextureOffset(28, 10).addBox(-1.0F, 1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        legsFrontRight = new ModelRenderer(this);
        legsFrontRight.setRotationPoint(-1.5F, 21.5F, -2.5F);
        legsFrontRight.setTextureOffset(28, 12).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        legsFrontRight.setTextureOffset(28, 10).addBox(-1.0F, 1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        legsFrontLeft = new ModelRenderer(this);
        legsFrontLeft.setRotationPoint(1.5F, 21.5F, -2.5F);
        legsFrontLeft.setTextureOffset(28, 12).addBox(0.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        legsFrontLeft.setTextureOffset(28, 10).addBox(0.0F, 1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        legsBackLeft = new ModelRenderer(this);
        legsBackLeft.setRotationPoint(1.5F, 21.5F, 1.5F);
        legsBackLeft.setTextureOffset(28, 12).addBox(0.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        legsBackLeft.setTextureOffset(28, 10).addBox(0.0F, 1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 16).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
    }

    protected GeckoModel(Function<ResourceLocation, RenderType> p_i225942_1_, ModelRenderer head, ModelRenderer snout, ModelRenderer tail, ModelRenderer tailBack_r1, ModelRenderer tail_r1, ModelRenderer legsBackRight, ModelRenderer legsFrontRight, ModelRenderer legsFrontLeft, ModelRenderer legsBackLeft, ModelRenderer bb_main, boolean isChildHeadScaled, float childHeadOffsetY, float childHeadOffsetZ, float childHeadScale, float childBodyScale, float childBodyOffsetY) {
        super(p_i225942_1_, isChildHeadScaled, childBodyOffsetY, childBodyScale, childHeadOffsetY, childHeadOffsetZ, childHeadScale);
        Head = head;
        Snout = snout;
        Tail = tail;
        TailBack_r1 = tailBack_r1;
        Tail_r1 = tail_r1;
        this.legsBackRight = legsBackRight;
        this.legsFrontRight = legsFrontRight;
        this.legsFrontLeft = legsFrontLeft;
        this.legsBackLeft = legsBackLeft;
        this.bb_main = bb_main;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
        this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
        this.legsBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legsBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.legsFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.legsFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        Tail.render(matrixStack, buffer, packedLight, packedOverlay);
        legsBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legsBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legsFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legsFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }



    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }


    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return null;
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return null;
    }

}

