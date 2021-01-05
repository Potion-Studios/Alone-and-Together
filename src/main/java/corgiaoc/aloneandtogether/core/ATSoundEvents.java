package corgiaoc.aloneandtogether.core;

import corgiaoc.aloneandtogether.AloneAndTogether;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;
import java.util.List;

public class ATSoundEvents {
    public static List<SoundEvent> soundEvents = new ArrayList<>();




    public static void init() {

    }

    public static SoundEvent createSound(String id, SoundEvent event) {
//        Registry.register(Registry.SOUND_EVENT, new ResourceLocation(AloneAndTogether.MOD_ID, id), event);
        event.setRegistryName(new ResourceLocation(AloneAndTogether.MOD_ID, id));
        soundEvents.add(event);
        return event;
    }


}
