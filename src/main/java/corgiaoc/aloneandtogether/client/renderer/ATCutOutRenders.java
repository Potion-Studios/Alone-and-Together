package corgiaoc.aloneandtogether.client.renderer;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ATCutOutRenders {

    public static void renderCutOuts(){
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_LOG.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_LEAVES.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_VINES.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_VINES_PLANT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.GLOWTAILS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.MYCENA_STEM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.BLUE_MYCENA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.RED_MYCENA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.YELLOW_MYCENA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.GREEN_MYCENA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.VOID_FERN.getBlock(), RenderType.getCutoutMipped());


        //Doors & Trapdoors
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_TRAP_DOOR.getBlock(), RenderType.getTranslucent());
    }
}
