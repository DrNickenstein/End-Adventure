package io.github.drnickenstein.endadventure;

import io.github.drnickenstein.endadventure.events.EACreativeModeTabs;
import io.github.drnickenstein.endadventure.events.EAParticleFactories;
import io.github.drnickenstein.endadventure.events.EndAdventureEventListener;
import io.github.drnickenstein.endadventure.init.*;
import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import io.github.drnickenstein.endadventure.networking.EndAdventureMessages;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.RenderTypeHelper;
import net.minecraftforge.client.model.renderable.ITextureRenderTypeLookup;
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
		BlockInit.SPECIAL_BLOCK_ITEMS.register(bus);
		BlockEntityInit.BLOCK_ENTITIES.register(bus);
		SoundInit.SOUNDS.register(bus);
		EntityTypeInit.ENTITY_TYPES.register(bus);
		MobEffectInit.MOB_EFFECTS.register(bus);
		ParticleTypeInit.PARTICLE_TYPES.register(bus);

		MinecraftForge.EVENT_BUS.register(new EndAdventureEventListener());

		bus.addListener(EAParticleFactories::registerParticleProviders);
		bus.addListener(EACreativeModeTabs::registerTabs);
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);
	}
	
	public void commonSetup(final FMLCommonSetupEvent event) {
		
		EndAdventureMessages.register();
		
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
