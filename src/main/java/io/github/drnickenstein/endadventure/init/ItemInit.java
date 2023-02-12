package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.items.consumables.EndiriumMetalSyringe;
import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import io.github.drnickenstein.endadventure.items.wearables.FilteredMask;
import io.github.drnickenstein.endadventure.util.EndAdventureTiers;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndAdventure.MODID);
	
	
	
	public static final RegistryObject<Item> FINISIUM_SHARD = ITEMS.register("finisium_shard", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MASK_FILTER = ITEMS.register("mask_filter", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> FUNGAL_SAMPLE = ITEMS.register("bioluminescent_fungus_sample", () -> new Item(new Item.Properties()));
	
	
	//Swords
	
	public static final RegistryObject<FinisiumSword> FINISIUM_SWORD = ITEMS.register("finisium_sword", () -> new FinisiumSword(EndAdventureTiers.FINISIUM, 5, -2.4F, new Item.Properties()));
	
	
	//Consumables
	
	public static final RegistryObject<Item> METAL_SYRINGE = ITEMS.register("metal_syringe", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ENDIRIUM_METAL_SYRINGE = ITEMS.register("endirium_metal_syringe", () -> new EndiriumMetalSyringe(new Item.Properties().stacksTo(1)));
	
	
	//Wearables
	
	public static final RegistryObject<Item> FILTERED_MASK = ITEMS.register("filtered_mask", () -> new FilteredMask(new Item.Properties().stacksTo(1)));
	
}
