package io.github.drnickenstein.endadventure.items.tools.swords;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
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
	public boolean hurtEnemy(ItemStack stack, LivingEntity entityTarget, LivingEntity entity) {

		super.hurtEnemy(stack, entityTarget, entity);

		if(!(entityTarget instanceof Animal) && !(entityTarget instanceof WaterAnimal)) {
		
			CompoundTag compoundTag = stack.getOrCreateTagElement("swordStage");
		
			int hits = compoundTag.getInt("hits");
			int stage = compoundTag.getInt("stage");
		
			stack.getTagElement("swordStage").putInt("hits", hits + 1);
		
			if(stage < 5) {
		
				updateSwordStage(stack, hits + 1, stage);
			
			}
		
		}
		
		return true;
	}
	
	public void updateSwordStage(ItemStack stack, int hits, int stage) {
		
		if(hits % 10 == 0) {
			
			System.out.println("Stage update");
			stack.getOrCreateTagElement("swordStage").putInt("stage", stage + 1);
			
		}
		
		if(hits == 0) {
			
			System.out.println("Stages reset");
			stack.getOrCreateTagElement("swordStage").putInt("stage", 0);
			
		}
		
	}
	
	private double calculateSwordDamage(ItemStack stack, int stage) {
		
		double modifier = (double)(getDamage() + stage * 10.0D);
		return modifier;
		
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		
		Multimap<Attribute, AttributeModifier> attributeModifiers = HashMultimap.create();
		
		if(slot == EquipmentSlot.MAINHAND) {
			
			attributeModifiers.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 
					calculateSwordDamage(stack, stack.getOrCreateTagElement("swordStage").getInt("stage")), AttributeModifier.Operation.ADDITION));
			
		}
		
		return attributeModifiers;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {

			tooltip.add(Component.literal("Sword Stage: " + stack.getOrCreateTagElement("swordStage").getInt("stage")));
			tooltip.add(Component.literal("Hits given: " + stack.getOrCreateTagElement("swordStage").getInt("hits")));
		
		super.appendHoverText(stack, p_41422_, tooltip, p_41424_);
	}
	
	public float getStageAsFloat(ItemStack stack) {
		
		if(stack.getItem() instanceof FinisiumSword) {
			
			return (float)stack.getOrCreateTagElement("swordStage").getInt("stage");
			
		}
		
		return 0.0F;
		
	}
	
	
}
