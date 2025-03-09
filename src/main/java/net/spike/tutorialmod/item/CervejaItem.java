package net.spike.tutorialmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CervejaItem extends Item {

    public CervejaItem(Properties properties) {
        super(properties.durability(10)); // Define a durabilidade do item (10 usos)
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        // Define a animação de beber
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        // Retorna o som de beber uma poção
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        // Retorna o som de beber uma poção (opcional, para garantir que o som de comer não seja reproduzido)
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        // Aplica os efeitos ao terminar de usar o item
        if (!world.isClientSide && entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0)); // Efeito de náusea
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 0)); // Efeito de fraqueza

            // Reduz a durabilidade do item
            if (!player.isCreative()) {
                stack.hurt(1, world.random, null); // Reduz a durabilidade em 1
            }

            // Se a durabilidade chegar a 0, retorna uma garrafa de vidro
            if (stack.getDamageValue() >= stack.getMaxDamage()) {
                ItemStack garrafa = new ItemStack(net.minecraft.world.item.Items.GLASS_BOTTLE);
                if (!player.getInventory().add(garrafa)) {
                    player.spawnAtLocation(garrafa, 0.5F); // Drope a garrafa se o inventário estiver cheio
                }
                return new ItemStack(net.minecraft.world.item.Items.GLASS_BOTTLE);
            }
        }

        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        // Define o tempo de uso do item (em ticks)
        return 32; // 1.6 segundos
    }
}