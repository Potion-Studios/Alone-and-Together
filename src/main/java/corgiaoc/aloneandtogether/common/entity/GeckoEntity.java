package corgiaoc.aloneandtogether.common.entity;


import corgiaoc.aloneandtogether.common.dimension.abyss.entity.BogFlyEntity;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class GeckoEntity extends AnimalEntity {
    private static final DataParameter<Byte> SKIN_COLOR = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.BYTE);

    public GeckoEntity(EntityType<? extends GeckoEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 2.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5F)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 48.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    // Initialise Gecko

    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(SKIN_COLOR, (byte)0);
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
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BogFlyEntity.class, false));
    }

    @ParametersAreNonnullByDefault
    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        setSkinColor(getRandomGeckoColor(rand));

        if (spawnDataIn == null) spawnDataIn = new AgeableEntity.AgeableData(1.0F);

        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public static SkinColors getRandomGeckoColor(Random random) {
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
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.APPLE;
    }

    @ParametersAreNonnullByDefault
    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity baby) {
        @Nullable GeckoEntity child = ATEntities.GECKO.create(world);

        if (child != null) child.setSkinColor(getRandomGeckoColor(child.rand));

        return child;
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)getAttributeValue(Attributes.ATTACK_DAMAGE)));

        if (flag) applyEnchantments(this, entityIn);

        return flag;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void applyEntityCollision(Entity entityIn) {
        if (entityIn == this) super.applyEntityCollision(entityIn);
    }

    @Override
    public boolean isOnLadder() {
        return true;
    }

    // Write to Nbt

    @ParametersAreNonnullByDefault
    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte("Color", (byte)this.getSkinColor().getId());
    }

    public SkinColors getSkinColor() {
        return SkinColors.byId(dataManager.get(SKIN_COLOR) & 15);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setSkinColor(SkinColors.byId(compound.getByte("Color")));
    }

    public void setSkinColor(SkinColors color) {
        byte b = this.dataManager.get(SKIN_COLOR);
        this.dataManager.set(SKIN_COLOR, (byte)(b & 240 | color.getId() & 15));
    }

    // End write to nbt

    public enum SkinColors {
        WHITE(0),
        BLUE(1),
        GREEN(2),
        BROWN(3),
        BLACK(4),
        RED(5),
        ORANGE(6);

        private static final SkinColors[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(SkinColors::getId)).toArray(SkinColors[]::new);
        private final int id;

        SkinColors(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static SkinColors byId(int id) {
            return VALUES[id >= VALUES.length ? 0 : id];
        }
    }
}