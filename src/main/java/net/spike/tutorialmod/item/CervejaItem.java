package net.spike.tutorialmod.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CervejaItem extends Item {

    public CervejaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide) {
            // Aplica os efeitos de náusea e fraqueza por 15 segundos (300 ticks)
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0)); // Náusea
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 0));  // Fraqueza

            // Reproduz o som de beber uma poção
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                    SoundEvents.GENERIC_DRINK, SoundSource.NEUTRAL, 0.5F, 1.0F);

            // Dropa uma garrafa de vidro no local da entidade
            entity.spawnAtLocation(new ItemStack(Items.GLASS_BOTTLE));
        }

        return super.finishUsingItem(stack, world, entity);
    }
}