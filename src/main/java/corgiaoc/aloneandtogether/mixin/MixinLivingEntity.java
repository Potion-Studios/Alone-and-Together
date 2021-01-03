package corgiaoc.aloneandtogether.mixin;

import corgiaoc.aloneandtogether.common.dimension.ATDimensions;
import corgiaoc.aloneandtogether.common.dimension.stellaris.world.util.StellarisDimensionGravityModifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {


    @Shadow protected boolean isJumping;

    @Shadow protected abstract float getJumpUpwardsMotion();

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void modifyJumpFactor(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        World world = (entity).world;

        if (world.getDimensionKey() == ATDimensions.STELLARIS_WORLD_KEY) {
            if (entity instanceof PlayerEntity) {
                if (((PlayerEntity) entity).isCreative())
                    return;
            }

            ci.cancel();
            StellarisDimensionGravityModifier.modifyJumpFactor(entity, this.getJumpUpwardsMotion());

            this.isJumping = true;
            net.minecraftforge.common.ForgeHooks.onLivingJump(entity);
        }
    }

    @Inject(method = "calculateFallDamage", at = @At("HEAD"), cancellable = true)
    private void removeFallDamage(float distance, float damageMultiplier, CallbackInfoReturnable<Integer> cir) {
        World world = ((LivingEntity) (Object) this).world;
        if (world.getDimensionKey() == ATDimensions.STELLARIS_WORLD_KEY) {
            cir.setReturnValue(0);
        }
    }
}
