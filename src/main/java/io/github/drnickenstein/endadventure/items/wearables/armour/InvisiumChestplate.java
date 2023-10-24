package io.github.drnickenstein.endadventure.items.wearables.armour;

import io.github.drnickenstein.endadventure.init.ItemInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InvisiumChestplate extends ArmorItem {

    public InvisiumChestplate(ArmorMaterial material, EquipmentSlot slot, Properties properties) {

        super(material, slot, properties);

    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        Player player;

        if(pEntity instanceof Player) {

            player = (Player)pEntity;

        } else {

            return;

        }

        if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.INVISIUM_HELMET.get() &&
           player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.INVISIUM_CHESTPLATE.get() &&
           player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.INVISIUM_LEGGINGS.get() &&
           player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.INVISIUM_BOOTS.get()) {

            AABB boundingBox = new AABB(player.blockPosition()).inflate(20.0D);

            List<LivingEntity> entitiesInAABB = pLevel.getEntitiesOfClass(LivingEntity.class, boundingBox);

            for(LivingEntity entity : entitiesInAABB) {

                if(entity != player) {

                    entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0, false, false));

                }

            }

        }

    }
}
