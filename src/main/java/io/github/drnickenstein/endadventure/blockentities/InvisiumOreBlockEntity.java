package io.github.drnickenstein.endadventure.blockentities;

import io.github.drnickenstein.endadventure.blocks.InvisiumOre;
import io.github.drnickenstein.endadventure.init.BlockEntityInit;
import io.github.drnickenstein.endadventure.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.stream.Stream;

public class InvisiumOreBlockEntity extends BlockEntity {

    public InvisiumOreBlockEntity(BlockPos pos, BlockState state) {

        super(BlockEntityInit.INVISIUM_ORE.get(), pos, state);

    }

    public void tick() {

        Level level = this.level;
        AABB boundingBox = new AABB(this.getBlockPos()).inflate(15D);

        Stream<BlockState> blocks = level.getBlockStates(boundingBox);
        List<Player> players = level.getEntitiesOfClass(Player.class, boundingBox);

        long finisiumTorchesInAABB = blocks
                .filter(blockState -> blockState.getBlock() == BlockInit.FINISIUM_TORCH.get() || blockState.getBlock() == BlockInit.WALL_FINISIUM_TORCH.get())
                .count();


        if(finisiumTorchesInAABB > 0) {

            level.setBlock(this.getBlockPos(), BlockInit.INVISIUM_ORE.get().defaultBlockState(), 2);
            return;

        }

        if(!players.isEmpty()) {

            for(Player player : players) {

                Item mainHandItem = player.getMainHandItem().getItem();
                Item offHandItem = player.getOffhandItem().getItem();

                Item finisiumTorch = BlockInit.FINISIUM_TORCH_ITEM.get();

                if(mainHandItem == finisiumTorch || offHandItem == finisiumTorch ) {

                    level.setBlock(this.getBlockPos(), BlockInit.INVISIUM_ORE.get().defaultBlockState(), 2);
                    return;

                }

            }

        }

        level.setBlock(this.getBlockPos(), BlockInit.HIDDEN_INVISIUM_ORE.get().defaultBlockState(), 2);

    }

}
