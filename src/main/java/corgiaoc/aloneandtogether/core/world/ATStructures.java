package corgiaoc.aloneandtogether.core.world;


import corgiaoc.aloneandtogether.common.world.feature.config.NoisySphereConfig;
import corgiaoc.aloneandtogether.common.world.structure.LargeMeteoriteStructure;
import corgiaoc.aloneandtogether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;

import java.util.ArrayList;
import java.util.List;

public class ATStructures {

    public static List<Structure<?>> structures = new ArrayList<>();

    public static final Structure<NoisySphereConfig> LARGE_METEORITE = WorldGenRegistrationHelper.createStructure("large_meteorite", new LargeMeteoriteStructure(NoisySphereConfig.CODEC), 15, 30, 1934845, GenerationStage.Decoration.RAW_GENERATION);

    public static void init() {
    }

    /********Pieces********/

    public static final IStructurePieceType METEORITE_PIECE = WorldGenRegistrationHelper.createStructurePiece("meteorite_piece", (structurePieceTypeIn, componentTypeIn) -> new LargeMeteoriteStructure.MeteoritePiece(componentTypeIn));
}
