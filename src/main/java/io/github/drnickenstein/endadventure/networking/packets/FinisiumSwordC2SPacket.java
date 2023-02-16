package io.github.drnickenstein.endadventure.networking.packets;

import java.util.function.Supplier;

import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

public class FinisiumSwordC2SPacket {
	
	public FinisiumSwordC2SPacket() {
		
		
		
	}
	
	public FinisiumSwordC2SPacket(FriendlyByteBuf buf) {
		
		
		
	}
	
	public void toBytes(FriendlyByteBuf buf) {
		
		
		
	}
	
	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		
		NetworkEvent.Context context = supplier.get();
		
		context.enqueueWork(() -> {

			ServerPlayer player = context.getSender();
			Item item = player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
			
				if(item instanceof FinisiumSword) {
				
					FinisiumSword finisiumSword = (FinisiumSword)item;
					ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
					stack.getOrCreateTagElement("swordStage").putInt("hits", 0);
				
					finisiumSword.updateSwordStage(stack, 0, 0, player);
				
				}
			
		});
		
		return true;
		
	}

}
