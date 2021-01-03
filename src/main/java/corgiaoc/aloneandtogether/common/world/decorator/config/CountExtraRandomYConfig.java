package corgiaoc.aloneandtogether.common.world.decorator.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.placement.IPlacementConfig;

public class CountExtraRandomYConfig implements IPlacementConfig {
   public static final Codec<CountExtraRandomYConfig> CODEC = RecordCodecBuilder.create((recorder) -> {
      return recorder.group(Codec.INT.fieldOf("count").forGetter((config) -> {
         return config.count;
      }), Codec.FLOAT.fieldOf("extra_chance").forGetter((config) -> {
         return config.extraChance;
      }), Codec.INT.fieldOf("extra_count").forGetter((config) -> {
         return config.extraCount;
      }), Codec.INT.fieldOf("minY").forGetter((config) -> {
         return config.minY;
      }), Codec.INT.fieldOf("maxY").forGetter((config) -> {
         return config.maxY;
      })).apply(recorder, CountExtraRandomYConfig::new);
   });
   public final int count;
   public final float extraChance;
   public final int extraCount;
   public final int minY;
   public final int maxY;

   public CountExtraRandomYConfig(int count, float extraChanceIn, int extraCountIn) {
      this(count, extraChanceIn, extraCountIn, 20, 215);
   }

   /**
    * @param minY When -1, the minY will return the (lowest world height + 20) available for the given dimension/world.
    * @param maxY When -1, the maxY will return the (highest world height - 20) available for the given dimension/world.
    */
   public CountExtraRandomYConfig(int count, float extraChanceIn, int extraCountIn, int minY, int maxY) {
      this.count = count;
      this.extraChance = extraChanceIn;
      this.extraCount = extraCountIn;
      this.minY = minY;
      this.maxY = maxY;
   }
}
