package io.github.drnickenstein.endadventure.items.consumables;

import java.util.List;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import io.github.drnickenstein.endadventure.init.ItemInit;
import io.github.drnickenstein.endadventure.init.SoundInit;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.HumanoidModel.ArmPose;
import net.minecraft.client.player.LocalPlayer;
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
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

		pLevel.playSound(null, pPlayer.blockPosition(), SoundInit.SYRINGE_INJECTION.get(), SoundSource.MASTER);
		return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
		
	}
	
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

		pTooltipComponents.add(Component.translatable("tooltip.metal_syringe.endirium"));
		
		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
		
	}
	
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
	    consumer.accept(new IClientItemExtensions() {
	    	
	        @Override
	        public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess) {
	        	
	           int i = arm == HumanoidArm.RIGHT ? 1 : -1;
	           poseStack.translate(i * 0.56F, -0.52F, -0.72F);
	            
	           if(arm == HumanoidArm.LEFT) {
	        	   
	        	   poseStack.translate(-0.2, -0.05, 0.1);
	        	   poseStack.mulPose(Axis.XP.rotationDegrees(-70));
	        	   
	        	   if(player.getUseItem() == itemInHand && player.isUsingItem()) {
	        		   
	        		   poseStack.translate(0.25, 0.15, 0);
	        		   poseStack.mulPose(Axis.YP.rotationDegrees(20));
	        		   
	        	   }
	        	   
	           }
	           
	           if(arm == HumanoidArm.RIGHT) {
		           
		            if (player.getUseItem() == itemInHand && player.isUsingItem()) {
	
		                poseStack.translate(-0.2, 0.15, 0.0);
		                poseStack.mulPose(Axis.YP.rotationDegrees(20));
		                
		            }
	            
	           }
	           
	           return true;
	            
	        }
	        
	        @Override
	        public @Nullable ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {

	        	final HumanoidModel.ArmPose INJECTING = HumanoidModel.ArmPose.create("inject", true, (model, entity, arm) -> {
	        		
	        		if(arm == HumanoidArm.RIGHT) {
	        			
		        		model.leftArm.xRot = -89.7f;
		        		model.leftArm.yRot = 44.2f;
		        		
		        		model.rightArm.xRot = -88.9f;
		        		model.rightArm.yRot = 43.5f;
	        			
	        		}
	        		
	        		if(arm == HumanoidArm.LEFT) {
	        			
	        			model.leftArm.xRot = -89.5f; //-88.9f;
	        			model.leftArm.yRot = -43.1f; //-43.5f;
	        			model.leftArm.zRot = -1f;
	        			
	        			model.rightArm.xRot = -89.7f;
	        			model.rightArm.yRot = -44.2f;
	        			
	        		}
	        		
	        	});
	        	
	        	if(entityLiving.getUseItem() == itemStack && entityLiving.isUsingItem()) {
	        		
	        		return INJECTING;
	        		
	        	}
	        	
	        	return ArmPose.EMPTY;
	        }
	        
	    });
	}
	
}
