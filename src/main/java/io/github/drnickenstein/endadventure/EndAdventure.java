package io.github.drnickenstein.endadventure;

import io.github.drnickenstein.endadventure.init.BlockInit;
import io.github.drnickenstein.endadventure.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EndAdventure.MODID)
public class EndAdventure {

	public static final String MODID = "endadventure";
	
	public EndAdventure() {
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
	}
}
