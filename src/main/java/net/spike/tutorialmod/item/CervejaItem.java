package net.spike.tutorialmod.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CervejaItem extends Item {

    public CervejaItem(Properties properties) {
        // Define a durabilidade do item (10 usos)
        super(properties.durability(10));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide) {
            // Aplica os efeitos de náusea e fraqueza por 15 segundos (300 ticks)
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0)); // Náusea
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 0));  // Fraqueza

            // Reproduz o som de beber uma poção
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                    SoundEvents.GENERIC_DRINK, SoundSource.NEUTRAL, 0.5F, world.getRandom().nextFloat() * 0.1F + 0.9F);

            // Verifica se o item quebrou após o uso
            if (stack.hurt(1, world.getRandom(), null)) {
                // Se o item quebrou, adiciona uma garrafa de vidro ao inventário do jogador
                if (entity instanceof Player) {
                    Player player = (Player) entity;
                    player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
                }
                // Remove o item do inventário
                stack.shrink(1);
            }
        }

        return stack;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false; // Impede que o item seja reparado
    }
}