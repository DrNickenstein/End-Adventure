package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.blocks.*;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndAdventure.MODID);
	public static final DeferredRegister<Item> SPECIAL_BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndAdventure.MODID);
	

	//Invisium

	public static final RegistryObject<Block> INVISIUM_ORE = register("invisium_ore", () -> new InvisiumOre(BlockBehaviour.Properties
																								.of(Material.STONE)
																								.requiresCorrectToolForDrops()
																								.strength(3.5f, 9.0f)), new Item.Properties());

	public static final RegistryObject<Block> HIDDEN_INVISIUM_ORE = BLOCKS.register("hidden_invisium_ore", () -> new InvisiumOre(BlockBehaviour.Properties
																								.of(Material.STONE)
																								.requiresCorrectToolForDrops()
																								.strength(3.0f, 9.0f)));


	//Finisium

	public static final RegistryObject<Block> FINISIUM_ORE = register("finisium_ore", () -> new Block(BlockBehaviour.Properties
																								.of(Material.STONE)
																								.requiresCorrectToolForDrops()
																								.strength(3.5F, 9.0F)), new Item.Properties());

	public static final RegistryObject<Block> WALL_FINISIUM_TORCH = BLOCKS.register("wall_finisium_torch", () -> new EAWallTorch(ParticleTypes.FLAME));

	public static final RegistryObject<Block> FINISIUM_TORCH = BLOCKS.register("finisium_torch", () -> new EATorch(ParticleTypes.FLAME));

	public static final RegistryObject<Item> FINISIUM_TORCH_ITEM = SPECIAL_BLOCK_ITEMS.register("finisium_torch", () -> new StandingAndWallBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(EndAdventure.MODID, "finisium_torch")),
																																							 ForgeRegistries.BLOCKS.getValue(new ResourceLocation(EndAdventure.MODID, "wall_finisium_torch")), new Item.Properties(), Direction.DOWN));

	
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
