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
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class GeckoEntity extends AnimalEntity {
    private static final DataParameter<Byte> SKIN_COLOR = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.BYTE);

    public GeckoEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);

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

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.APPLE;
    }

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

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity baby) {
        GeckoEntity geckoEntity = ATEntities.GECKO.create(world);
        geckoEntity.setSkinColor(getRandomGeckoColor(world.getRandom()));
        return geckoEntity;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 2.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5F).createMutableAttribute(Attributes.FOLLOW_RANGE, 48.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setSkinColor(getRandomGeckoColor(worldIn.getRandom()));
        if (spawnDataIn == null) {
            spawnDataIn = new AgeableEntity.AgeableData(1.0f);
        }
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @Override
    public void applyEntityCollision(Entity entityIn) {
        if (entityIn == this)
            super.applyEntityCollision(entityIn);
    }

    public SkinColors getSkinColor() {
        return SkinColors.byId(this.dataManager.get(SKIN_COLOR) & 15);
    }

    public boolean isOnLadder() {
        if (this.collidedHorizontally) {
        }
        return true;
    }

    public void setSkinColor(SkinColors color) {
        byte b0 = this.dataManager.get(SKIN_COLOR);
        this.dataManager.set(SKIN_COLOR, (byte) (b0 & 240 | color.getId() & 15));
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SKIN_COLOR, (byte) 0);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte("Color", (byte) this.getSkinColor().getId());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setSkinColor(SkinColors.byId(compound.getByte("Color")));
    }


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

        public static SkinColors byId(int colorId) {
            if (colorId < 0 || colorId >= VALUES.length) {
                colorId = 0;
            }

            return VALUES[colorId];
        }

        public int getId() {
            return this.id;
        }
    }

    public enum SkinTypes {
        NONE(0),
        DOTS(1),
        STRIPES(2),
        BLACK_TAIL(3),
        RED_EYES(4);

        private final int id;

        SkinTypes(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

    }
}