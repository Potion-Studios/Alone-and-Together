package corgiaoc.aloneandtogether.common.dimension.abyss.block;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;


import java.util.Random;

public class SpectralVinesBlock extends AbstractTopPlantBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public SpectralVinesBlock(AbstractBlock.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, 0));
    }

    /**
     * Used to determine how much to grow the plant when using bonemeal. Kelp always returns 1, where as the nether vines
     * return a random value at least 1.
     */
    protected int getGrowthAmount(Random rand) {
        return PlantBlockHelper.getGrowthAmount(rand);
    }

    protected Block getBodyPlantBlock() {
        return ATBlocks.SPECTRAL_VINES_PLANT;
    }


    protected boolean canGrowIn(BlockState state) {
        return PlantBlockHelper.isAir(state);
    }

//    @OnlyIn(Dist.CLIENT)
//    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
//        VoxelShape lvt_5_1_ = this.getShape(stateIn, worldIn, pos, ISelectionContext.dummy());
//        Vector3d lvt_6_1_ = lvt_5_1_.getBoundingBox().getCenter();
//        double lvt_7_1_ = (double) pos.getX() + lvt_6_1_.x;
//        double lvt_9_1_ = (double) pos.getZ() + lvt_6_1_.z;
//
//        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
//            if (rand.nextBoolean()) {
//                worldIn.addParticle(ParticleTypes.END_ROD, lvt_7_1_ + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), lvt_9_1_ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
//            }
//        }
//
//    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.offset(this.growthDirection.getOpposite());
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (!this.canGrowOn(block)) {
            return false;
        } else {
            return block == this.getTopPlantBlock() || block == this.getBodyPlantBlock() || block == ATBlocks.SPECTRAL_LEAVES || blockstate.isSolidSide(worldIn, blockpos, this.growthDirection);
        }
    }
}
