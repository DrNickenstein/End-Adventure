package io.github.drnickenstein.endadventure.blocks;

import io.github.drnickenstein.endadventure.blockentities.BioluminescentFungusBlockEntity;
import io.github.drnickenstein.endadventure.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BioluminescentFungus extends Block implements EntityBlock {

	public BioluminescentFungus(Properties properties) {
		
		super(properties);

	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {

		return BlockEntityInit.BIOLUMINESCENT_FUNGUS.get().create(pos, state);
		
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		
		return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {
			
			if(blockEntity instanceof BioluminescentFungusBlockEntity bioluminescentFungus) {
				
				bioluminescentFungus.tick();
				
			}
			
		};
		
	}

}
