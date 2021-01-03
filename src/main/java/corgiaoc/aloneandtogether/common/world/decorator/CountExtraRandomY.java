package corgiaoc.aloneandtogether.common.world.decorator;

import com.mojang.serialization.Codec;
import corgiaoc.aloneandtogether.common.world.decorator.config.CountExtraRandomYConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountExtraRandomY extends Placement<CountExtraRandomYConfig> {

    public CountExtraRandomY(Codec<CountExtraRandomYConfig> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(WorldDecoratingHelper decoratorContext, Random random, CountExtraRandomYConfig config, BlockPos pos) {
        int count = config.count;
        if (random.nextFloat() < config.extraChance) {
            count += config.extraCount;
        }

        int minHeight = config.minY == -1 ? 20 : config.minY;

        int maxHeight = config.maxY == -1 ? decoratorContext.field_242889_a.getHeight() - 20 : config.maxY;

        return IntStream.range(0, count).mapToObj((streamedInt) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            int y = random.nextInt(maxHeight - (minHeight / 2)) + minHeight;
            return new BlockPos(x, y, z);
        });
    }
}