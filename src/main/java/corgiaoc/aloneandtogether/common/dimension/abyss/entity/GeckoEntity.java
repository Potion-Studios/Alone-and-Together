package corgiaoc.aloneandtogether.common.dimension.abyss.entity;



import corgiaoc.aloneandtogether.core.ATEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class GeckoEntity extends AnimalEntity {
    private static final DataParameter<Integer> FLAGS = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.VARINT);

    public GeckoEntity(EntityType<? extends GeckoEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static @Nonnull
    AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 2.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33F)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    // Initialise Gecko

    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(FLAGS, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.APPLE), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(9, new LeapAtTargetGoal(this, 0.4f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PyreFlyEntity.class, false));
    }

    @ParametersAreNonnullByDefault
    @Override
    public @Nullable
    ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT tag) {
        setSkinColor(getRandomGeckoColor(rand));
        return super.onInitialSpawn(world, difficultyIn, reason, spawnData == null ? new AgeableEntity.AgeableData(1.0F) : spawnData, tag);
    }
    @ParametersAreNonnullByDefault
    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return super.canSpawn(worldIn, spawnReasonIn);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 12;
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return true;
    }

    public static SkinColors getRandomGeckoColor(@Nonnull Random random) {
        int i = random.nextInt(35);

        if (i < 5) {
            return SkinColors.BLACK;
        } else if (i < 10) {
            return SkinColors.BROWN;
        } else if (i < 15) {
            return SkinColors.RED;
        } else if (i < 20) {
            return SkinColors.BLUE;
        } else if (i < 25) {
            return SkinColors.ORANGE;
        } else if (i < 30) {
            return SkinColors.WHITE;
        } else {
            return SkinColors.GREEN;
        }
    }

    // End initialising

    @Override
    public void tick() {
        super.tick();
        setClimbing(!world.isRemote && collidedHorizontally);
    }

    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack) {
        return stack.getItem() == Items.APPLE;
    }

    @ParametersAreNonnullByDefault
    @Override
    public @Nullable
    AgeableEntity func_241840_a(ServerWorld world, AgeableEntity mate) {
        @Nullable GeckoEntity child = ATEntities.GECKO.create(world);

        if (child != null) child.setSkinColor(getRandomGeckoColor(child.rand));

        return child;
    }

    @Override
    public boolean attackEntityAsMob(@Nonnull Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) getAttributeValue(Attributes.ATTACK_DAMAGE)));

        if (flag) applyEnchantments(this, entityIn);

        return flag;
    }

    @Override
    public boolean isOnLadder() {
        return isClimbing();
    }

    // Write to Nbt

    @Override
    public void writeAdditional(@Nonnull CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Flag", getRawFlag());
    }

    @Override
    public void readAdditional(@Nonnull CompoundNBT compound) {
        super.readAdditional(compound);
        setRawFlag(compound.getInt("Flag"));
    }

    public SkinColors getSkinColor() {
        return SkinColors.byIndex((getRawFlag() >> 16) & Byte.MAX_VALUE);
    }

    public boolean isClimbing() {
        return ((getRawFlag() >> 8) & Byte.MAX_VALUE) > 0;
    }

    public void setSkinColor(@Nonnull SkinColors color) {
        setFlags(color, isClimbing());
    }

    public void setClimbing(boolean value) {
        setFlags(getSkinColor(), value);
    }

    public int getRawFlag() {
        return dataManager.get(FLAGS);
    }

    public void setFlags(@Nonnull SkinColors color, boolean climbing) {
        setRawFlag(
                (color.ordinal() & Byte.MAX_VALUE) << 16 |
                        (climbing ? 1 : 0) << 8
        );
    }

    public void setRawFlag(int flag) {
        dataManager.set(FLAGS, flag);
    }

    // End write to nbt

    public enum SkinColors {
        WHITE(),
        BLUE(),
        GREEN(),
        BROWN(),
        BLACK(),
        RED(),
        ORANGE();

        public static SkinColors byIndex(int index) {
            SkinColors[] colours = values();

            return colours[index >= colours.length ? 0 : index];
        }
    }
}