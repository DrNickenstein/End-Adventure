package io.github.drnickenstein.endadventure.events;

import io.github.drnickenstein.endadventure.items.tools.swords.FinisiumSword;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EndAdventureEventListener {

	
	//Fired when nothing is hit
	
	@SubscribeEvent
	public void miss(LeftClickEmpty event) {
		
		Item item = event.getItemStack().getItem();
		
		if(item instanceof FinisiumSword) {
			
			FinisiumSword finisiumSword = (FinisiumSword)item;
			ItemStack stack = event.getItemStack();
			stack.getOrCreateTagElement("swordStage").putInt("hits", 0);
			
			finisiumSword.updateSwordStage(stack, 0, 0);
			
		}
		
	}
	
	
	//Fired when a block is hit
	
	@SubscribeEvent
	public void hitBlock(LeftClickBlock event) {
		
		Item item = event.getItemStack().getItem();
		
		if(item instanceof FinisiumSword) {
			
			FinisiumSword finisiumSword = (FinisiumSword)item;
			ItemStack stack = event.getItemStack();
			stack.getOrCreateTagElement("swordStage").putInt("hits", 0);

			finisiumSword.updateSwordStage(stack, 0, 0);
			
		}
		
	}
	
}
