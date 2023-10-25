package io.github.drnickenstein.endadventure.items.wearables;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FilteredMask extends Item implements Wearable {

	public FilteredMask(Properties properties) {
		
		super(properties);
		
	}

	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {

		return true;
		
	}
	
	@Override
	public SoundEvent getEquipSound() {

		return SoundEvents.ARMOR_EQUIP_LEATHER;
	}
	
   public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
	      ItemStack itemstack = pPlayer.getItemInHand(pHand);
	      ItemStack itemstack1 = pPlayer.getItemBySlot(EquipmentSlot.HEAD);
	      if (itemstack1.isEmpty()) {
	         pPlayer.setItemSlot(EquipmentSlot.HEAD, itemstack.copy());

	         itemstack.setCount(0);
	         return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
	      } else {
	         return InteractionResultHolder.fail(itemstack);
	      }
	   }


	@Override
	public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

		Component useDescription = Component.translatable("tooltip.filtered_mask.protection");

		pTooltipComponents.add(Component.literal(useDescription.getString()));

		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
	}
}
