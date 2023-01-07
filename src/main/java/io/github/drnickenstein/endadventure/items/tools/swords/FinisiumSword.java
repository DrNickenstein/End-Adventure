package io.github.drnickenstein.endadventure.items.tools.swords;

import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class FinisiumSword extends SwordItem {
	
	public FinisiumSword(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
		
		super(tier, attackDamage, attackSpeed, properties);
		
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity p_43279_, LivingEntity target) {

		super.hurtEnemy(stack, p_43279_, target);
		
		CompoundTag compoundTag = stack.getTagElement("swordStage");
		int hits = compoundTag.getInt("hits");
		int stage = compoundTag.getInt("stage");
		
		stack.getTagElement("swordStage").putInt("hits", hits + 1);
		
		if(stage < 5) {
		
			updateSwordStage(stack, hits + 1, stage);
			
		}
		
		return true;
	}
	
	private void updateSwordStage(ItemStack stack, int hits, int stage) {
		
		if(hits % 10 == 0) {
			
			stack.getTagElement("swordStage").putInt("stage", stage + 1);
			
		}
		
	}
	
	/*private void updateSwordDamage(ItemStack stack, int stage) {
		
			//stack.addAttributeModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 25.0D, AttributeModifier.Operation.ADDITION), EquipmentSlot.MAINHAND);	
	}*/
	
	@Override
	public void appendHoverText(ItemStack stack, Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {

		//try {
		
			tooltip.add(Component.literal("Sword Stage: " + stack.getOrCreateTagElement("swordStage").getInt("stage")));
			tooltip.add(Component.literal("Hits given: " + stack.getOrCreateTagElement("swordStage").getInt("hits")));
			
			System.out.println("TAGS CREATED");
		
		/*} catch(Exception e) {
			
			tooltip.add(Component.literal("Sword Stage: " + 0));
			tooltip.add(Component.literal("Hits given: " + 0));
			
		}*/
		
		super.appendHoverText(stack, p_41422_, tooltip, p_41424_);
	}
	
	
}
