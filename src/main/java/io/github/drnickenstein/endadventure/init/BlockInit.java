package io.github.drnickenstein.endadventure.init;

import java.util.function.Supplier;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.blocks.BioluminescentFungus;
import io.github.drnickenstein.endadventure.blocks.ToxicFungus;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndAdventure.MODID);
	
	
	public static final RegistryObject<Block> FINISIUM_ORE = register("finisium_ore", () -> new Block(BlockBehaviour.Properties
																								.of(Material.STONE)
																								.requiresCorrectToolForDrops()
																								.strength(3.5F, 9.0F)), new Item.Properties());
	
	
	//Echoing forest blocks
	
	public static final RegistryObject<Block> BIOLUMINESCENT_FUNGUS_UNLIT = register("bioluminescent_fungus_unlit", () -> new BioluminescentFungus(BlockBehaviour.Properties
																								.of(Material.GRASS)
																								.sound(SoundType.FUNGUS)), new Item.Properties());
	
	public static final RegistryObject<Block> BIOLUMINESCENT_FUNGUS_LIT = register("bioluminescent_fungus_lit", () -> new BioluminescentFungus(BlockBehaviour.Properties
																								.of(Material.GRASS)
																								.sound(SoundType.FUNGUS)
																								.lightLevel((p_187431_) -> {
																								      return 10;
																								   })), new Item.Properties());

	public static final RegistryObject<Block> TOXIC_FUNGUS = register("toxic_fungus", () -> new ToxicFungus(BlockBehaviour.Properties
																				.of(Material.GRASS)
																				.sound(SoundType.FUNGUS)), new Item.Properties());
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
		
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
		return block;
		
	}
	
}
