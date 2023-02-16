package io.github.drnickenstein.endadventure.init;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.mobeffects.FungusPoisoningEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobEffectInit {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EndAdventure.MODID);


    public static final RegistryObject<MobEffect> FUNGUS_POISONING = MOB_EFFECTS.register("fungus_poisoning", () -> new FungusPoisoningEffect());

}
