package io.github.drnickenstein.endadventure.blocks;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.init.ParticleTypeInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class EAWallTorch extends WallTorchBlock {

    public EAWallTorch(ParticleOptions particles) {

        super(Properties.copy(Blocks.WALL_TORCH), particles);

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource rand) {
        Direction direction = state.getValue(FACING);
        double dx = (double)pos.getX() + 0.5D;
        double dy = (double)pos.getY() + 0.7D;
        double dz = (double)pos.getZ() + 0.5D;
        double d0 = 0.22D;
        double d1 = 0.27D;
        Direction opposite = direction.getOpposite();
        if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(EndAdventure.MODID, "wall_finisium_torch"))) {

            world.addParticle(ParticleTypeInit.FINISIUM_FLAMES.get(), dx + d1 * (double) opposite.getStepX(), dy + d0, dz + d1 * (double) opposite.getStepZ(), 0.0D, 0.0D, 0.0D);

        }
    }

}
