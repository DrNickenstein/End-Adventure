package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EndAdventure.MODID);
	
	
	public static final RegistryObject<SoundEvent> FINISIUM_SWORD_STAGE_UPGRADE = SOUNDS.register("finisium_sword_stage_upgrade", 
																				  () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(EndAdventure.MODID, "finisium_sword_stage_upgrade")));

}
