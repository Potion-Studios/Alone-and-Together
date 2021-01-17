package corgiaoc.aloneandtogether.client.renderer;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

import java.util.Arrays;

public class ATCutOutRenders {

    public static void renderCutOuts(){
        Block[] blocks = {
                ATBlocks.SPECTRAL_LOG.getBlock(),
                ATBlocks.SPECTRAL_LEAVES.getBlock(),
                ATBlocks.SPECTRAL_VINES.getBlock(),
                ATBlocks.SPECTRAL_VINES_PLANT.getBlock(),
                ATBlocks.GLOWTAILS.getBlock(),
                ATBlocks.VOID_FERN.getBlock(),
                ATBlocks.ABYSSAL_GROWTH.getBlock(),
                ATBlocks.ABYSSAL_WALL_GROWTH.getBlock(),
                ATBlocks.BOG_SHROOM.getBlock(),
                ATBlocks.VOID_GRASS.getBlock(),
                ATBlocks.RHYLAGLASS.getBlock(),
                ATBlocks.BOG_BELL_BULBS.getBlock(),
                ATBlocks.TALL_BELL_BULBS.getBlock(),
                ATBlocks.ORVIUM_FEATHER.getBlock()
        };
        Arrays.stream(blocks).forEach((block) -> RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped()));

        RenderTypeLookup.setRenderLayer(ATBlocks.RED_MYCENA.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ATBlocks.YELLOW_MYCENA.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ATBlocks.BLUE_MYCENA.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ATBlocks.GREEN_MYCENA.getBlock(), RenderType.getTranslucent());


        //Doors & Trapdoors
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_TRAP_DOOR.getBlock(), RenderType.getTranslucent());
    }
}
