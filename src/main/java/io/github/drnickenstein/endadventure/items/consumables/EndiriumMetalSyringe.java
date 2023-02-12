package io.github.drnickenstein.endadventure.items.consumables;

import java.util.List;
import java.util.function.Consumer;

import io.github.drnickenstein.endadventure.init.ItemInit;
import io.github.drnickenstein.endadventure.init.SoundInit;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class EndiriumMetalSyringe extends Item {

	public EndiriumMetalSyringe(Properties pProperties) {
		
		super(pProperties);

	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

		if(!pLevel.isClientSide) {
			
			pLivingEntity.removeEffect(MobEffects.POISON);
			pLivingEntity.removeEffect(MobEffects.CONFUSION);
			
		}
		
		return new ItemStack(ItemInit.METAL_SYRINGE.get());
		
	}
	
	@Override
	public int getUseDuration(ItemStack pStack) {

		return 32;
		
	}
	
	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {

		return UseAnim.CUSTOM;
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

		pLevel.playSound(null, pPlayer.blockPosition(), SoundInit.SYRINGE_INJECTION.get(), SoundSource.MASTER);
		return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
		
	}
	
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

		pTooltipComponents.add(Component.translatable("tooltip.metal_syringe.endirium"));
		
		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
		
	}
	
	IClientItemExtensions extensions = new IClientItemExtensions() {
		
		public boolean applyForgeHandTransform(com.mojang.blaze3d.vertex.PoseStack poseStack, net.minecraft.client.player.LocalPlayer player, net.minecraft.world.entity.HumanoidArm arm, ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess) {
			
			System.out.println("method called");
			
			int i = arm == HumanoidArm.RIGHT ? 1 : -1;
			poseStack.translate(i * 0.5, -0.5, -0.5);
			if(player.isUsingItem()) {
				
				System.out.println("Animation performed");
				poseStack.translate(0.01, 0.01, 0.01);
				
			}
			
			return true;
			
		}
		
	};
	
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(extensions);
		System.out.println("initializeClient called");
		
	}
	
}
