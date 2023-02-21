package io.github.drnickenstein.endadventure.mobeffects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FungusPoisoningEffect extends MobEffect {

    public FungusPoisoningEffect() {

        super(MobEffectCategory.HARMFUL, 8853070);

    }

    //As there is no cure for the poison other than the Endirium Syringe, the returned list is empty.
    //The effect is healed with the specific method implemented in the EndiriumMetalSyringe class.
    @Override
    public List<ItemStack> getCurativeItems() {

        return new ArrayList<ItemStack>();

    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        pLivingEntity.hurt(new DamageSource("fungusPoisoning"), 1.0F);

    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {

        int j = 20 >> pAmplifier;
        if(j > 0) {

            return pDuration % j == 0;

        } else {

            return true;

        }

    }
}
