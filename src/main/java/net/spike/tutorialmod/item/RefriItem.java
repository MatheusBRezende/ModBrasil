package net.spike.tutorialmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class RefriItem extends Item {

    private static final int MAX_DURABILITY = 3;

    public RefriItem(Properties properties) {
        // Define as propriedades do item para ser consumível, como uma poção ou comida
        super(properties.craftRemainder(net.minecraft.world.item.Items.GLASS_BOTTLE) // Define o item que sobra após o uso (garrafa de vidro)
                .stacksTo(16) // Define o tamanho máximo da pilha
                .durability(MAX_DURABILITY) // Define a durabilidade máxima
                .food(new FoodProperties.Builder()// Define propriedades de comida (necessário para o som e animação)
                        .nutrition(0) // Valor nutricional (0 para não restaurar fome)
                        .saturationMod(0) // Modificador de saturação
                        .alwaysEat() // Permite que o item seja consumido mesmo com a barra de fome cheia
                        .build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // Aplica o efeito de náusea e fraqueza ao consumir o item
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0));

        // Reduz a durabilidade do item
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (!player.getAbilities().instabuild) {
                if (stack.getDamageValue() < stack.getMaxDamage()) {
                    stack.setDamageValue(stack.getDamageValue() + 1); // Reduz a durabilidade
                } else {
                    stack.shrink(1); // Consome o item se a durabilidade chegar a zero
                }
                player.addItem(new ItemStack(net.minecraft.world.item.Items.GLASS_BOTTLE)); // Adiciona uma garrafa de vidro ao inventário
            }
        }

        return stack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        // Inicia a animação de beber
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        // Define a animação de beber
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        // Define o tempo de uso (em ticks)
        return 32; // 32 ticks = 1.6 segundos (mesmo tempo que uma poção)
    }

    @Override
    public SoundEvent getDrinkingSound() {
        // Define o som de beber
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        // Define o som de comer (usado para itens consumíveis)
        return SoundEvents.GENERIC_DRINK;
    }
}