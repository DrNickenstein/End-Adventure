package io.github.drnickenstein.endadventure.blocks;

import io.github.drnickenstein.endadventure.blockentities.ToxicFungusBlockEntity;
import io.github.drnickenstein.endadventure.init.BlockEntityInit;
import io.github.drnickenstein.endadventure.init.ParticleTypeInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ToxicFungus extends Block implements EntityBlock {

    public ToxicFungus(BlockBehaviour.Properties properties) {

        super(properties);

    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {

        int i = pPos.getX();
        int j = pPos.getY();
        int k = pPos.getZ();

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 30; ++l) {
            blockpos$mutableblockpos.set(i + Mth.nextInt(pRandom, -10, 10), j - pRandom.nextInt(10), k + Mth.nextInt(pRandom, -10, 10));
            BlockState blockstate = pLevel.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(pLevel, blockpos$mutableblockpos)) {
                pLevel.addParticle(ParticleTypeInit.TOXIC_SPORES.get(), (double) blockpos$mutableblockpos.getX() + pRandom.nextDouble(), (double) blockpos$mutableblockpos.getY() + pRandom.nextDouble(), (double) blockpos$mutableblockpos.getZ() + pRandom.nextDouble(), 0.0D, 0.0D, 0.0D);
            }

        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {

        return BlockEntityInit.TOXIC_FUNGUS.get().create(pos, state);

    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {

        return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {

            if(blockEntity instanceof ToxicFungusBlockEntity toxicFungus) {

                toxicFungus.tick();

            }

        };

    }

}
