package io.github.drnickenstein.endadventure.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.drnickenstein.endadventure.items.consumables.Syringe;
import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import io.github.drnickenstein.endadventure.networking.EndAdventureMessages;
import io.github.drnickenstein.endadventure.networking.packets.FinisiumSwordC2SPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EndAdventureEventListener {

	//Fired when nothing is hit ONLY ON THE CLIENT
	@SubscribeEvent
	public void miss(LeftClickEmpty event) {
		
			EndAdventureMessages.sendToServer(new FinisiumSwordC2SPacket());

	}

	
	//Fired when a block is hit
	@SubscribeEvent
	public void hitBlock(LeftClickBlock event) {
		
		Level level = event.getLevel();
		
		if(!level.isClientSide()) {
		
		Item item = event.getItemStack().getItem();
		
			if(item instanceof FinisiumSword) {
			
				FinisiumSword finisiumSword = (FinisiumSword)item;
				ItemStack stack = event.getItemStack();
				stack.getOrCreateTagElement("swordStage").putInt("hits", 0);

				finisiumSword.updateSwordStage(stack, 0, 0, event.getEntity());
			
			}
		
		}
		
	}


	//Fired when a hand (arm) is rendered
	@SubscribeEvent
	public void renderInjectedArm(RenderHandEvent event) {

		InteractionHand hand = event.getHand();
		Minecraft minecraft = Minecraft.getInstance();
		AbstractClientPlayer player = minecraft.player;
		Item mainHandItem = minecraft.player.getMainHandItem().getItem();
		ItemStack offHandStack = event.getItemStack();
		PlayerRenderer renderer = (PlayerRenderer)minecraft.getEntityRenderDispatcher().getRenderer(player);
		PoseStack poseStack = event.getPoseStack();

		if(hand == InteractionHand.OFF_HAND) {

			if(offHandStack.isEmpty() && mainHandItem instanceof Syringe) {

				event.setCanceled(true);

				poseStack.pushPose();
				poseStack.translate(-0.62D, -0.45D,-0.3D);
				poseStack.mulPose(Axis.XN.rotation(20));
				poseStack.mulPose(Axis.ZP.rotation(0.3f));
				poseStack.mulPose(Axis.YP.rotation(1.2f));
				renderer.renderLeftHand(poseStack, event.getMultiBufferSource(), event.getPackedLight(), player);
				poseStack.popPose();

			}

		}

	}

}
