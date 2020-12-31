//package corgiaoc.aloneandtogether.client.entity.models;// Made with Blockbench 3.7.4
//
//
//import com.google.common.collect.ImmutableList;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.vertex.IVertexBuilder;
//import corgiaoc.aloneandtogether.common.entity.BogFlyEntity;
//import net.minecraft.client.renderer.entity.model.AgeableModel;
//import net.minecraft.client.renderer.model.ModelRenderer;
//import net.minecraft.util.math.MathHelper;
//
//public class BogFlyModel<T extends BogFlyEntity> extends AgeableModel<T> {
//        private final ModelRenderer leftLegs;
//        private final ModelRenderer rightLegs;
//        private final ModelRenderer body;
//        private final ModelRenderer proboscis;
//        private final ModelRenderer rightWing;
//        private final ModelRenderer leftWing;
//        private float bodyPitch;
//
//        public BogFlyModel() {
//            super();
//            textureWidth = 64;
//            textureHeight = 64;
//
//            leftLegs = new ModelRenderer(this);
//            leftLegs.setRotationPoint(2.5F, 22.0F, 3.0F);
//            leftLegs.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, true);
//            leftLegs.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 2.0F, 0.0F, 0.0F, true);
//            leftLegs.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 2.0F, 0.0F, 0.0F, true);
//
//            rightLegs = new ModelRenderer(this);
//            rightLegs.setRotationPoint(2.5F, 22.0F, 3.0F);
//            rightLegs.setTextureOffset(0, 0).addBox(-5.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
//            rightLegs.setTextureOffset(0, 0).addBox(-5.5F, 0.0F, -3.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
//            rightLegs.setTextureOffset(0, 0).addBox(-5.5F, 0.0F, -6.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
//
//            body = new ModelRenderer(this);
//            body.setRotationPoint(0.0F, 24.0F, 0.0F);
//            body.setTextureOffset(0, 0).addBox(-3.5F, -9.0F, -5.0F, 7.0F, 7.0F, 10.0F, 0.0F, false);
//            body.setTextureOffset(0, 2).addBox(1.5F, -8.0F, -8.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);
//            body.setTextureOffset(0, 2).addBox(-1.5F, -8.0F, -8.0F, 0.0F, 2.0F, 3.0F, 0.0F, true);
//            body.setTextureOffset(24, 0).addBox(1.5F, -7.0F, -6.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
//            body.setTextureOffset(24, 0).addBox(-4.5F, -7.0F, -6.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);
//
//            proboscis = new ModelRenderer(this);
//            proboscis.setRotationPoint(0.0F, -3.5F, -5.0F);
//            body.addChild(proboscis);
//            setRotationAngle(proboscis, 0.3054F, 0.0F, 0.0F);
//            proboscis.setTextureOffset(24, 5).addBox(0.0F, -0.5F, -3.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);
//
//            rightWing = new ModelRenderer(this);
//            rightWing.setRotationPoint(-2.0F, -9.0F, -3.0F);
//            body.addChild(rightWing);
//            setRotationAngle(rightWing, 0.0F, 1.0472F, 0.0F);
//            rightWing.setTextureOffset(14, 17).addBox(-7.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, 0.0F, true);
//
//            leftWing = new ModelRenderer(this);
//            leftWing.setRotationPoint(2.0F, -9.0F, -3.0F);
//            body.addChild(leftWing);
//            setRotationAngle(leftWing, 0.0F, -1.0472F, 0.0F);
//            leftWing.setTextureOffset(14, 17).addBox(0.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, 0.0F, false);
//        }
//
//        @Override
//        public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//            this.rightWing.rotateAngleX = 0.0F;
//            this.body.rotateAngleX = 0.0F;
//            this.body.rotationPointY = 19.0F;
//            boolean flag = entity.isOnGround() && entity.getMotion().lengthSquared() < 1.0E-7D;
//            if (flag) {
//                this.rightWing.rotateAngleY = -0.2618F;
//                this.rightWing.rotateAngleZ = 0.0F;
//                this.leftWing.rotateAngleX = 0.0F;
//                this.leftWing.rotateAngleY = 0.2618F;
//                this.leftWing.rotateAngleZ = 0.0F;
//                this.leftLegs.rotateAngleX = 0.0F;
//                this.rightLegs.rotateAngleX = 0.0F;
//            } else {
//                this.rightWing.rotateAngleY = 0.0F;
//                this.rightWing.rotateAngleZ = MathHelper.cos(ageInTicks * 2.1F) * (float)Math.PI * 0.15F;
//                this.leftWing.rotateAngleX = this.rightWing.rotateAngleX;
//                this.leftWing.rotateAngleY = this.rightWing.rotateAngleY;
//                this.leftWing.rotateAngleZ = -this.rightWing.rotateAngleZ;
//                this.leftLegs.rotateAngleX = ((float)Math.PI / 4F);
//                this.rightLegs.rotateAngleX = ((float)Math.PI / 4F);
//                this.body.rotateAngleX = 0.0F;
//                this.body.rotateAngleY = 0.0F;
//                this.body.rotateAngleZ = 0.0F;
//            }
//        }
//
//        @Override
//        public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//            leftLegs.render(matrixStack, buffer, packedLight, packedOverlay);
//            rightLegs.render(matrixStack, buffer, packedLight, packedOverlay);
//            body.render(matrixStack, buffer, packedLight, packedOverlay);
//        }
//
//        @Override
//        protected Iterable<ModelRenderer> getHeadParts() {
//            return ImmutableList.of();
//        }
//
//        @Override
//        protected Iterable<ModelRenderer> getBodyParts() {
//			return ImmutableList.of(this.body);
//        }
//
//        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//            modelRenderer.rotateAngleX = x;
//            modelRenderer.rotateAngleY = y;
//            modelRenderer.rotateAngleZ = z;
//        }
//}