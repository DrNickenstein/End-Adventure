package io.github.drnickenstein.endadventure.items.tools.swords;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class FinisiumSword extends SwordItem {

	private int hits;
	private int swordStage;
	
	public FinisiumSword(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
		super(tier, attackDamage, attackSpeed, properties);
		
		swordStage = 0;
		hits = 0;
		
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity p_43279_, LivingEntity target) {

		super.hurtEnemy(stack, p_43279_, target);
		hits++;
		
		if(hits % 10 == 0 && swordStage < 5) {
		
			updateSwordStage(stack, hits);
			
		}
		
		return true;
	}
	
	private void updateSwordStage(ItemStack stack, int hits) {
		
		swordStage++;
		updateSwordDamage(stack, swordStage);
		
	}
	
	private void updateSwordDamage(ItemStack stack, int stage) {
		
		if(swordStage > 0) {
		
			stack.addAttributeModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 25.0D, AttributeModifier.Operation.ADDITION), EquipmentSlot.MAINHAND);	
			
			System.out.println("Added 25.0 damage.");
			
		}
	}
	
	@Override
	public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {

		tooltip.add(Component.literal("Sword Stage: " + swordStage));
		tooltip.add(Component.literal("Hits given: " + hits));
		
		super.appendHoverText(p_41421_, p_41422_, tooltip, p_41424_);
	}
	
}
