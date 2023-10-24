package io.github.drnickenstein.endadventure.util;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum EndAdventureArmorMaterials implements ArmorMaterial {

    INVISIUM("invisium", 30, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, -1f, () -> Ingredient.of(ItemInit.INVISIUM_GEM.get()));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private EndAdventureArmorMaterials(String materialName, int durability, int[] protections, int enchantability, SoundEvent equipSound, float materialToughness, float knockbackResistanceCoefficient, Supplier<Ingredient> ingredient) {

        this.name = materialName;
        this.durabilityMultiplier = durability;
        this.slotProtections = protections;
        this.enchantmentValue = enchantability;
        this.sound = equipSound;
        this.toughness = materialToughness;
        this.knockbackResistance = knockbackResistanceCoefficient;
        this.repairIngredient = ingredient;

    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    public int getEnchantmentValue() {

        return this.enchantmentValue;

    }

    public SoundEvent getEquipSound() {

        return this.sound;

    }

    public Ingredient getRepairIngredient() {

        return this.repairIngredient.get();

    }

    public String getName() {

        return EndAdventure.MODID + ":" + this.name;

    }

    public float getToughness() {

        return this.toughness;

    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {

        return this.knockbackResistance;

    }

}
