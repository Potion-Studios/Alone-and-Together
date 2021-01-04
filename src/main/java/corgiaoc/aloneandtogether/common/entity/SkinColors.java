package corgiaoc.aloneandtogether.common.entity;

import net.minecraft.item.DyeColor;

import java.util.Arrays;
import java.util.Comparator;

public enum SkinColors{
    WHITE(0),
    CREAMY(1),
    GREEN(2),
    BROWN(3),
    BLACK(4),
    GRAY(5),
    ORANGE(6);

    private static final SkinColors[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(SkinColors::getId)).toArray((p_234255_0_) -> {
        return new SkinColors[p_234255_0_];
    });
    private final int id;

    private SkinColors(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SkinColors byId(int colorId) {
        if (colorId < 0 || colorId >= VALUES.length) {
            colorId = 0;
        }

        return VALUES[colorId];
    }
}
