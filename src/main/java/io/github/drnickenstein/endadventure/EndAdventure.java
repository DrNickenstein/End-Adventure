package io.github.drnickenstein.endadventure;

import io.github.drnickenstein.endadventure.events.EndAdventureEventListener;
import io.github.drnickenstein.endadventure.init.BlockInit;
import io.github.drnickenstein.endadventure.init.ItemInit;
import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
	}
	
	public void clientSetup(final FMLClientSetupEvent event) {
		
		System.out.println("CALL");
		
		event.enqueueWork(() -> 
		{
			
			ItemProperties.register(ItemInit.FINISIUM_SWORD.get(), new ResourceLocation(MODID, "currentstage"), (stack, world, living, id) -> {
				
				if(stack.getItem() instanceof FinisiumSword) {
					
					return living != null ? ((FinisiumSword)stack.getItem()).getStageAsFloat(stack) : 0.0F;
					
				}
				
		        return 0.0F;
		      });
			
		});
		
	}
	
}
