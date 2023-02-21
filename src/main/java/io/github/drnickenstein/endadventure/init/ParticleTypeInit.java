package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.particles.ParticleToxicSpores;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleTypeInit {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, EndAdventure.MODID);


    public static final RegistryObject<SimpleParticleType> TOXIC_SPORES = PARTICLE_TYPES.register("toxic_spores", () -> new SimpleParticleType(false));


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {

        ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;
        particleEngine.register(ParticleTypeInit.TOXIC_SPORES.get(), ParticleToxicSpores.Provider::new);

    }

}
