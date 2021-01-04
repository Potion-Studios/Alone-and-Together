package corgiaoc.aloneandtogether.common.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum SkinTypes {
        NONE(0),
        DOTS(1),
        STRIPES(2),
        BLACK_TAIL(3),
        RED_EYES(4);

private static final SkinTypes[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(SkinTypes::getId)).toArray((p_234249_0_) -> {
        return new SkinTypes[p_234249_0_];
        });
private final int id;

private SkinTypes(int id) {
        this.id = id;
        }

public int getId() {
        return this.id;
        }

public static SkinTypes func_234248_a_(int e) {
        return VALUES[e % VALUES.length];
        }
        }
