package corgiaoc.aloneandtogether.client.renderer;

import corgiaoc.aloneandtogether.core.ATBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class CutOutRenders {

    public void renderCutOuts(FMLClientSetupEvent e){
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_LOG.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ATBlocks.SPECTRAL_LEAVES.getBlock(), RenderType.getCutoutMipped());
    }
}
