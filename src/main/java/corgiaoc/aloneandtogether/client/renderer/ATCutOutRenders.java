package corgiaoc.aloneandtogether.client.renderer;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Arrays;

public class ATCutOutRenders {

    public static void renderCutOuts(){
        Block[] blocks = {
                ATBlocks.SPECTRAL_LOG.getBlock(),
                ATBlocks.SPECTRAL_LEAVES.getBlock(),
                ATBlocks.SPECTRAL_VINES.getBlock(),
                ATBlocks.SPECTRAL_VINES_PLANT.getBlock(),
                ATBlocks.GLOWTAILS.getBlock(),
                ATBlocks.MYCENA_STEM.getBlock(),
                ATBlocks.BLUE_MYCENA.getBlock(),
                ATBlocks.RED_MYCENA.getBlock(),
                ATBlocks.YELLOW_MYCENA.getBlock(),
                ATBlocks.GREEN_MYCENA.getBlock(),
                ATBlocks.VOID_FERN.getBlock(),
                ATBlocks.ABYSSAL_GROWTH.getBlock()
        };
        Arrays.stream(blocks).forEach((block) -> RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped()));

        //Doors & Trapdoors
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_TRAP_DOOR.getBlock(), RenderType.getTranslucent());
    }
}
