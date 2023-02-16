package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.blockentities.BioluminescentFungusBlockEntity;
import io.github.drnickenstein.endadventure.blockentities.ToxicFungusBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EndAdventure.MODID);
	
	public static final RegistryObject<BlockEntityType<BioluminescentFungusBlockEntity>> BIOLUMINESCENT_FUNGUS = BLOCK_ENTITIES
			                                                                             .register("bioluminescent_fungus", () -> BlockEntityType.Builder.of(BioluminescentFungusBlockEntity::new, 
			                                                                            BlockInit.BIOLUMINESCENT_FUNGUS_LIT.get(),
			                                                                            BlockInit.BIOLUMINESCENT_FUNGUS_UNLIT.get()).build(null));

	public static final RegistryObject<BlockEntityType<ToxicFungusBlockEntity>> TOXIC_FUNGUS = BLOCK_ENTITIES
																				.register("toxic_fungus", () -> BlockEntityType.Builder.of(ToxicFungusBlockEntity::new,
																				BlockInit.TOXIC_FUNGUS.get()).build(null));
	
}
