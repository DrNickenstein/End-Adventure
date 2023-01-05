package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import io.github.drnickenstein.endadventure.util.EndAdventureTiers;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndAdventure.MODID);
	
	public static final RegistryObject<Item> FINISIUM_SHARD = ITEMS.register("finisium_shard", () -> new Item(new Item.Properties()));
	
	//Swords
	
	public static final RegistryObject<FinisiumSword> FINISIUM_SWORD = ITEMS.register("finisium_sword", () -> new FinisiumSword(EndAdventureTiers.FINISIUM, 5, -2.4F, new Item.Properties()));
	
}
