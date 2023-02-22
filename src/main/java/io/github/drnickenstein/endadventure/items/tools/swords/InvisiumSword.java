package io.github.drnickenstein.endadventure.items.tools.swords;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class InvisiumSword extends SwordItem {

    public InvisiumSword(Tier tier, int attackDamage, float attackSpeed, Properties properties) {

        super(tier, attackDamage, attackSpeed, properties);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack sword = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);

        if(pUsedHand == InteractionHand.MAIN_HAND && sword.getOrCreateTagElement("isPowered").getBoolean("powered")) {

            pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, true));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200,1, false, true));

            pPlayer.getCooldowns().addCooldown(this, 600);
            sword.getOrCreateTagElement("isPowered").putBoolean("powered", false);

        } else {

            return InteractionResultHolder.fail(pPlayer.getOffhandItem());

        }

        return super.use(pLevel, pPlayer, pUsedHand);

    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if(pEntity instanceof Player) {

            Player player = (Player)pEntity;

            if(!player.getCooldowns().isOnCooldown(this)) {

                pStack.getOrCreateTagElement("isPowered").putBoolean("powered", true);

            }

        }

    }

    public float getPoweredStatus(ItemStack stack) {

        if(stack.getOrCreateTagElement("isPowered").getBoolean("powered")) {

            return 1.0f;

        }

        return 0.0f;

    }

}
