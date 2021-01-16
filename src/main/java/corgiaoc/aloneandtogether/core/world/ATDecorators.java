package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.world.decorator.CountExtraRandomY;
import corgiaoc.aloneandtogether.common.world.decorator.config.CountExtraRandomYConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
import java.util.List;

import static corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper.createDecorator;

public class ATDecorators {

    public static List<Placement<?>> decorators = new ArrayList<>();

    public static final Placement<CountExtraRandomYConfig> COUNT_EXTRA_RANDOM_Y = createDecorator("count_extra_random_y", new CountExtraRandomY(CountExtraRandomYConfig.CODEC));

    public static void init() {
    }
}
