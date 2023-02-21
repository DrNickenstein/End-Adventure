package io.github.drnickenstein.endadventure.blocks;

import io.github.drnickenstein.endadventure.blockentities.InvisiumOreBlockEntity;
import io.github.drnickenstein.endadventure.blockentities.ToxicFungusBlockEntity;
import io.github.drnickenstein.endadventure.init.BlockEntityInit;
import io.github.drnickenstein.endadventure.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class InvisiumOre extends Block implements EntityBlock {

    public InvisiumOre(BlockBehaviour.Properties properties) {

        super(properties);

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {

        return BlockEntityInit.INVISIUM_ORE.get().create(pPos, pState);

    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {

        return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {

            if(blockEntity instanceof InvisiumOreBlockEntity invisiumOre) {

                invisiumOre.tick();

            }

        };

    }
}
