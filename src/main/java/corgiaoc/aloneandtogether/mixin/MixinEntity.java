package corgiaoc.aloneandtogether.mixin;

import corgiaoc.aloneandtogether.common.dimension.stellaris.world.util.StellarisDimensionGravityModifier;
import corgiaoc.aloneandtogether.core.ATDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinEntity {

    @Shadow private Vector3d motion;

    @Shadow public World world;

    @Shadow private AxisAlignedBB boundingBox;

    @Inject(method = "setMotion(Lnet/minecraft/util/math/vector/Vector3d;)V", at = @At("HEAD"), cancellable = true)
    private void stellarisGravity(Vector3d motionIn, CallbackInfo ci) {
        if (this.world.getDimensionKey() == ATDimensions.STELLARIS_WORLD_KEY) {
            ci.cancel();

            this.motion = StellarisDimensionGravityModifier.modifyGravityFallSpeed(motionIn, (Entity)(Object) this);
        }
    }
}
