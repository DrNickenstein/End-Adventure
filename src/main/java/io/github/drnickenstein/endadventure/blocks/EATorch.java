package io.github.drnickenstein.endadventure.blocks;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.init.ParticleTypeInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class EATorch extends TorchBlock {

    public EATorch(ParticleOptions particles) {

        super(Properties.copy(Blocks.TORCH), particles);

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource rand) {

        double d0 = (double) pos.getX() + rand.nextDouble() * 0.5D + 0.2D;
        double d1 = (double) pos.getY() + rand.nextDouble() * 0.7D + 0.2D;
        double d2 = (double) pos.getZ() + rand.nextDouble() * 0.5D + 0.2D;

        if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(EndAdventure.MODID, "finisium_torch"))) {

            world.addParticle(ParticleTypeInit.FINISIUM_FLAMES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);

        }

    }

}
