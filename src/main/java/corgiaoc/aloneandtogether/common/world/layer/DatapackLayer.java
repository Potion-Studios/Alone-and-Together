package corgiaoc.aloneandtogether.common.world.layer;

import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;

public class DatapackLayer {

    private final LazyArea lazyArea;
    private final String dimensionName;

    public DatapackLayer(IAreaFactory<LazyArea> lazyAreaFactoryIn, String dimensionName) {
        this.lazyArea = lazyAreaFactoryIn.make();
        this.dimensionName = dimensionName;
    }

    static int stopLoggerSpam = 0;

    public Biome sample(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.getValue(x, z);
        Biome biome = registry.getByValue(biomeID);
        if (biome == null) {
            if (SharedConstants.developmentMode) {
                throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpam <= 50) {
                    AloneAndTogether.LOGGER.warn("Alone & Together: \"" + dimensionName + "\" Layer: Unknown biome id: " + biomeID + " at X: " + x + "Z: " + z);
                    stopLoggerSpam++;
                }
                return registry.getValueForKey(BiomeRegistry.getKeyFromID(0)); //Default to ocean if an error is encountered.
            }
        } else {
            return biome;
        }
    }
}