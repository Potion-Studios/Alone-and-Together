package corgiaoc.aloneandtogether.common.dimension.stellaris.world.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

public class StellarisDimensionGravityModifier {
    public static final float Y_MOTION_MULTIPLIER = 0.95F;
    public static final float JUMP_HEIGHT_MODIFIER = 3.5F;

    
    public static Vector3d modifyGravityFallSpeed(Vector3d motion, Entity entity) {
        if (entity instanceof PlayerEntity) {
            if(((PlayerEntity) entity).isCreative())
                return motion;
        }

        double modifiedYMotion = motion.y * Y_MOTION_MULTIPLIER;
        return new Vector3d(motion.x, modifiedYMotion, motion.z);
    }


    public static void modifyJumpFactor(LivingEntity entity, float upwardsMotion) {
        float jumpHeight = upwardsMotion * JUMP_HEIGHT_MODIFIER;
        if (entity.isPotionActive(Effects.JUMP_BOOST)) {
            jumpHeight += 0.1F * (float)(entity.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1);
        }

        Vector3d motion = entity.getMotion();
        entity.setMotion(motion.x, jumpHeight, motion.z);
        if (entity.isSprinting()) {
            float f1 = entity.rotationYaw * ((float)Math.PI / 180F);
            entity.setMotion(entity.getMotion().add(-MathHelper.sin(f1) * 0.2F, 0.0D, MathHelper.cos(f1) * 0.2F));
        }
    }
}
