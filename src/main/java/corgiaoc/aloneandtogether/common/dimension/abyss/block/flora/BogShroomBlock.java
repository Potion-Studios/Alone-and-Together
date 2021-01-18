package corgiaoc.aloneandtogether.common.dimension.abyss.block.flora;

import corgiaoc.aloneandtogether.common.block.ATFernBlock;
import corgiaoc.aloneandtogether.common.dimension.abyss.entity.GeckoEntity;
import corgiaoc.aloneandtogether.common.dimension.abyss.entity.PyreFlyEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.potion.Potions;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.state.properties.BlockStateProperties.AGE_0_3;

@SuppressWarnings("deprecation")
public class BogShroomBlock extends ATFernBlock {

    public BogShroomBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState().with(AGE_0_3, 0));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@Nonnull BlockItemUseContext context) {
        return getDefaultState().with(AGE_0_3, context.getWorld().rand.nextInt(3));
    }

    @ParametersAreNonnullByDefault
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        int age = state.get(AGE_0_3);
        if (age > 0 && !nativeEntity(entity) && world.rand.nextInt(100 / age) == 0) world.destroyBlock(pos, false);
    }

    private boolean nativeEntity(Entity entity) {
        return entity instanceof GeckoEntity || entity instanceof PyreFlyEntity;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moving) {
        int age = getAge(state);

        if (newState.getBlock() != this && !world.isRemote) {
            AreaEffectCloudEntity effect = new AreaEffectCloudEntity(world, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);

            effect.setDuration(20 * age);
            effect.setRadius(0.3F * age);
            effect.setPotion(Potions.POISON);

            world.addEntity(effect);
        }
        super.onReplaced(state, world, pos, newState, moving);
    }

    @Override
    public @Nonnull OffsetType getOffsetType() {
        return OffsetType.NONE;
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE_0_3);
    }

    private static int getAge(@Nonnull BlockState state) {
        return state.get(AGE_0_3);
    }
}
