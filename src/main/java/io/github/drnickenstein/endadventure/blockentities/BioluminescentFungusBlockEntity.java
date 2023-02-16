package io.github.drnickenstein.endadventure.blockentities;

import io.github.drnickenstein.endadventure.init.BlockEntityInit;
import io.github.drnickenstein.endadventure.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class BioluminescentFungusBlockEntity extends BlockEntity {

	public BioluminescentFungusBlockEntity(BlockPos pos, BlockState state) {
		
		super(BlockEntityInit.BIOLUMINESCENT_FUNGUS.get(), pos, state);

	}
	
    public void tick() {
		
		Level level = this.level;
		BlockPos pos = this.getBlockPos();
		BlockState state = this.getBlockState();
		AABB boundingBox = new AABB(this.getBlockPos()).inflate(5.0D);

		if(!(level.getEntitiesOfClass(Player.class, boundingBox).isEmpty())) {

			level.setBlock(pos, BlockInit.BIOLUMINESCENT_FUNGUS_LIT.get().defaultBlockState(), 2);

		} else if(state == BlockInit.BIOLUMINESCENT_FUNGUS_LIT.get().defaultBlockState()) {

			level.setBlock(pos, BlockInit.BIOLUMINESCENT_FUNGUS_UNLIT.get().defaultBlockState(), 2);

		}
    	
    }

}
