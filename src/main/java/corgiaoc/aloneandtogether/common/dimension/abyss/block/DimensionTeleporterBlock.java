package corgiaoc.aloneandtogether.common.dimension.abyss.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

@SuppressWarnings("deprecation")
public class DimensionTeleporterBlock extends Block {
    private final RegistryKey<World> worldKey;

    public DimensionTeleporterBlock(Properties properties, RegistryKey<World> worldKey) {
        super(properties);
        this.worldKey = worldKey;
    }


    @SuppressWarnings({"ConstantConditions", "NullableProblems"})
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            ServerWorld world = worldIn.getServer().getWorld(worldKey);
            if (world != null) {
                sendPlayerToDimension((ServerPlayerEntity) player, world, new Vector3d(player.getPosX(), player.getPosY(), player.getPosZ()));
                player.sendStatusMessage(new TranslationTextComponent("aloneandtogether.teleport.success"), true);
                return ActionResultType.SUCCESS;
            }
            else {
                player.sendStatusMessage(new TranslationTextComponent("aloneandtogether.teleport.failed"), true);
                return ActionResultType.FAIL;
            }
        }

        return ActionResultType.PASS;
    }


    public static void sendPlayerToDimension(ServerPlayerEntity serverPlayer, ServerWorld targetWorld, Vector3d targetVec) {
        // ensure destination chunk is loaded before we put the player in it
        targetWorld.getChunk(new BlockPos(targetVec));
        serverPlayer.teleport(targetWorld, targetVec.getX(), targetWorld.getHeight(Heightmap.Type.MOTION_BLOCKING, (int) targetVec.getX(), (int) targetVec.getZ()), targetVec.getZ(), serverPlayer.rotationYaw, serverPlayer.rotationPitch);
    }
}
