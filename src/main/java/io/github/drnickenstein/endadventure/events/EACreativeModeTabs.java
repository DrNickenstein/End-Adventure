package io.github.drnickenstein.endadventure.events;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.RegistryObject;

public class EACreativeModeTabs {
	
	public static CreativeModeTab MISC_EA_TAB;
	public static CreativeModeTab EA_SWORDS_TAB;
	
	public static void registerTabs(final CreativeModeTabEvent.Register e) {

		MISC_EA_TAB = register(e, new ResourceLocation(EndAdventure.MODID, "misc"));
		EA_SWORDS_TAB = registerSwordsTab(e, new ResourceLocation(EndAdventure.MODID, "swords"));
		
	}
	
	private static CreativeModeTab register(CreativeModeTabEvent.Register e, ResourceLocation resourceLocation) {

		return e.registerCreativeModeTab(resourceLocation, builder -> builder
				.icon(() -> ItemInit.FINISIUM_SHARD.get().getDefaultInstance())
				.title(Component.literal("End Adventure Misc"))
				.displayItems((featureFlagSet, displayedItems, hasPermissions) -> {
					
					for(final RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
						
						displayedItems.accept(item.get());
						
					}
					
				}				
		));
		
	}
	
	private static CreativeModeTab registerSwordsTab(CreativeModeTabEvent.Register e, ResourceLocation resourceLocation) {

		return e.registerCreativeModeTab(resourceLocation, builder -> builder
				.icon(() -> ItemInit.FINISIUM_SWORD.get().getDefaultInstance())
				.title(Component.literal("End Adventure Swords"))
				.displayItems((featureFlagSet, displayedItems, hasPermissions) -> {
					
					for(final RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
						
						if(item.get() instanceof SwordItem) {
							
							displayedItems.accept(item.get());
						
						}
						
					}
					
				}				
		));
		
	}

	
}
