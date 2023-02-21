package io.github.drnickenstein.endadventure.items.consumables;

import io.github.drnickenstein.endadventure.init.MobEffectInit;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EndiriumMetalSyringe extends Syringe {

    public EndiriumMetalSyringe(Properties properties) {

        super(properties);

    }

    @Override
    public void applySyringeEffects(ItemStack stack, Level level, LivingEntity livingEntity) {

        livingEntity.removeEffect(MobEffectInit.FUNGUS_POISONING.get());
        livingEntity.removeEffect(MobEffects.CONFUSION);

    }

    @Override
    public Component getSyringeDesc() {

        return Component.translatable("tooltip.metal_syringe.endirium");

    }
}
