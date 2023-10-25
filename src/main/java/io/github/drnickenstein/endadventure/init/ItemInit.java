package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.items.consumables.EndiriumMetalSyringe;
import io.github.drnickenstein.endadventure.items.misc.EmptySyringe;
import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import io.github.drnickenstein.endadventure.items.tools.swords.InvisiumSword;
import io.github.drnickenstein.endadventure.items.wearables.FilteredMask;
import io.github.drnickenstein.endadventure.items.wearables.armour.InvisiumChestplate;
import io.github.drnickenstein.endadventure.util.EndAdventureArmorMaterials;
import io.github.drnickenstein.endadventure.util.EndAdventureTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndAdventure.MODID);
	
	Collection<RegistryObject<Item>> endAdventureItems;
	
	public static final RegistryObject<Item> FINISIUM_SHARD = ITEMS.register("finisium_shard", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INVISIUM_GEM = ITEMS.register("invisium_gem", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MASK_FILTER = ITEMS.register("mask_filter", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BIOLUMINESCENT_FUNGUS_SAMPLE = ITEMS.register("bioluminescent_fungus_sample", () -> new Item(new Item.Properties()));
	
	
	//Swords
	
	public static final RegistryObject<Item> FINISIUM_SWORD = ITEMS.register("finisium_sword", () -> new FinisiumSword(EndAdventureTiers.FINISIUM, 5, -2.4f, new Item.Properties()));
	public static final RegistryObject<Item> INVISIUM_SWORD = ITEMS.register("invisium_sword", () -> new InvisiumSword(EndAdventureTiers.INVISIUM, 5, -2.4f, new Item.Properties()));


	//Armour

	public static final RegistryObject<Item> INVISIUM_HELMET = ITEMS.register("invisium_helmet", () -> new ArmorItem(EndAdventureArmorMaterials.INVISIUM, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> INVISIUM_CHESTPLATE = ITEMS.register("invisium_chestplate", () -> new InvisiumChestplate(EndAdventureArmorMaterials.INVISIUM, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> INVISIUM_LEGGINGS = ITEMS.register("invisium_leggings", () -> new ArmorItem(EndAdventureArmorMaterials.INVISIUM, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<Item> INVISIUM_BOOTS = ITEMS.register("invisium_boots", () -> new ArmorItem(EndAdventureArmorMaterials.INVISIUM, EquipmentSlot.FEET, new Item.Properties()));

	//Consumables
	
	public static final RegistryObject<Item> METAL_SYRINGE = ITEMS.register("metal_syringe", () -> new EmptySyringe(new Item.Properties()));
	public static final RegistryObject<Item> ENDIRIUM_METAL_SYRINGE = ITEMS.register("endirium_metal_syringe", () -> new EndiriumMetalSyringe(new Item.Properties().stacksTo(1)));
	
	
	//Wearables
	
	public static final RegistryObject<Item> FILTERED_MASK = ITEMS.register("filtered_mask", () -> new FilteredMask(new Item.Properties().stacksTo(1)));

	public void setEndAdventureItems() {

		this.endAdventureItems = ITEMS.getEntries();

	}

	public Collection<RegistryObject<Item>> getEndAdventureItems() {

		setEndAdventureItems();
		return endAdventureItems;

	}
}
