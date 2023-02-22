package io.github.drnickenstein.endadventure.events;

import io.github.drnickenstein.endadventure.init.ParticleTypeInit;
import io.github.drnickenstein.endadventure.particles.ParticleFinisiumFlames;
import io.github.drnickenstein.endadventure.particles.ParticleToxicSpores;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EAParticleFactories {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {

        Minecraft.getInstance().particleEngine.register(ParticleTypeInit.TOXIC_SPORES.get(), ParticleToxicSpores.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleTypeInit.FINISIUM_FLAMES.get(), ParticleFinisiumFlames.Provider::new);

    }

}
