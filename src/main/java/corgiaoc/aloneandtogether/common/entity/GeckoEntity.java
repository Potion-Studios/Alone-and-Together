package corgiaoc.aloneandtogether.common.entity;


import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;


public class GeckoEntity extends AnimalEntity {
    private static final DataParameter<Byte> SKIN_COLOR = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.BYTE);

    public GeckoEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    public static SkinColors getRandomGeckoColor(Random random) {
        int i = random.nextInt(35);
        if (i < 5) {
            return SkinColors.BLACK;
        } else if (i < 10) {
            return SkinColors.BROWN;
        } else if (i < 15) {
            return SkinColors.CREAMY;
        } else if (i < 20) {
            return SkinColors.GRAY;
        } else if (i < 25) {
            return SkinColors.ORANGE;
        } else if (i < 30) {
            return SkinColors.WHITE;
        } else {
            return SkinColors.GREEN;
        }
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.APPLE), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }
    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setSkinColor(getRandomGeckoColor(worldIn.getRandom()));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public SkinColors getSkinColor() {
        return SkinColors.byId(this.dataManager.get(SKIN_COLOR) & 15);
    }
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F).createMutableAttribute(Attributes.FOLLOW_RANGE, 48.0D);
    }

    /**
     * Sets the wool color of this sheep
     */
    public void setSkinColor(SkinColors color) {
        byte b0 = this.dataManager.get(SKIN_COLOR);
        this.dataManager.set(SKIN_COLOR, (byte)(b0 & 240 | color.getId() & 15));
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SKIN_COLOR, (byte)0);
    }
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte("Color", (byte)this.getSkinColor().getId());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setSkinColor(SkinColors.byId(compound.getByte("Color")));
    }
}
