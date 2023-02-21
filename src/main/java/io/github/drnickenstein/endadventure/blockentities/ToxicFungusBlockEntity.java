package io.github.drnickenstein.endadventure.blockentities;

import io.github.drnickenstein.endadventure.init.BlockEntityInit;
import io.github.drnickenstein.endadventure.init.EntityTypeInit;
import io.github.drnickenstein.endadventure.init.MobEffectInit;
import io.github.drnickenstein.endadventure.items.wearables.FilteredMask;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.List;

public class ToxicFungusBlockEntity extends BlockEntity {

    public ToxicFungusBlockEntity(BlockPos pos, BlockState state) {

        super(BlockEntityInit.TOXIC_FUNGUS.get(), pos, state);

    }

    public void tick() {

        Level level = this.level;
        AABB boundingBox = new AABB(this.getBlockPos()).inflate(10.0D);

        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, boundingBox);
        Collection<RegistryObject<EntityType<?>>> endAdventureEntities = EntityTypeInit.ENTITY_TYPES.getEntries();


        if(!entities.isEmpty()) {

            for(int i = 0; i < entities.size(); i++) {

                LivingEntity entity = entities.get(i);

                if (!(endAdventureEntities.contains(entity)) && !(entity instanceof Player)) {

                    entity.addEffect(new MobEffectInstance(MobEffectInit.FUNGUS_POISONING.get()));

                }

                if(entity instanceof Player) {

                    Player player = (Player)entity;

                    if(!(player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof FilteredMask)) {

                        player.addEffect(new MobEffectInstance(MobEffectInit.FUNGUS_POISONING.get(), 72000));
                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400));

                    }

                }

            }

        }

    }

}
