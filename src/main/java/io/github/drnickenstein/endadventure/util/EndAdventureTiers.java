package io.github.drnickenstein.endadventure.util;

import java.util.function.Supplier;

import io.github.drnickenstein.endadventure.init.ItemInit;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum EndAdventureTiers implements Tier {
	
	FINISIUM(5, 3000, 10.0f, 6.0f, 15, () -> (Ingredient.of(ItemInit.FINISIUM_SHARD.get()))),
	INVISIUM(6, 3000, 12.0f, 8.0f, 15, () -> (Ingredient.of(ItemInit.INVISIUM_GEM.get())));
	
	private final int level;
	private final int durability;
	private final float speed;
	private final float attackDamageBonus;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;
	
	private EndAdventureTiers(int level, int durability, float speed, float attackDamageBonus, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		
		this.level = level;
		this.durability = durability;
		this.speed = speed;
		this.attackDamageBonus = attackDamageBonus;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
		
	}

	@Override
	public int getUses() {

		return durability;
	}

	@Override
	public float getSpeed() {

		return speed;
	}

	@Override
	public float getAttackDamageBonus() {

		return attackDamageBonus;
	}

	@Override
	public int getLevel() {

		return level;
	}

	@Override
	public int getEnchantmentValue() {

		return enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {

		return repairIngredient.get();
	}

}
