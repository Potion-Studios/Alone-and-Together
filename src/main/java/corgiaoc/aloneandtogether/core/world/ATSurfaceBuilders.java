package corgiaoc.aloneandtogether.core.world;

import corgiaoc.aloneandtogether.common.dimension.stellaris.world.surfacebuilder.StellarisSB;
import corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.ArrayList;
import java.util.List;

public class ATSurfaceBuilders {
    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<SurfaceBuilderConfig> STELLARIS = WorldGenRegistrationHelper.createSurfaceBuilder("stellaris" ,new StellarisSB(SurfaceBuilderConfig.field_237203_a_));

    public static void init() {
    }
}
