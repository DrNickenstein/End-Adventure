package io.github.drnickenstein.endadventure;

import io.github.drnickenstein.endadventure.events.EndAdventureEventListener;
import io.github.drnickenstein.endadventure.init.BlockInit;
import io.github.drnickenstein.endadventure.init.ItemInit;
import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import io.github.drnickenstein.endadventure.networking.EndadventureMessages;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EndAdventure.MODID)
public class EndAdventure {

	public static final String MODID = "endadventure";
	
	public EndAdventure() {
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		MinecraftForge.EVENT_BUS.register(new EndAdventureEventListener());	
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);
	}
	
	public void commonSetup(final FMLCommonSetupEvent event) {
		
		EndadventureMessages.register();
		
	}
	
	public void clientSetup(final FMLClientSetupEvent event) {
		
		event.enqueueWork(() -> 
		{
			
			ItemProperties.register(ItemInit.FINISIUM_SWORD.get(), new ResourceLocation(MODID, "currentstage"), (stack, world, living, id) -> {
				
				if(stack.getItem() instanceof FinisiumSword) {
					
					return ((FinisiumSword)stack.getItem()).getStageAsFloat(stack);
					
				}
				
		        return 0.0F;
		        
		      });
			
		});
		
	}
	
}
