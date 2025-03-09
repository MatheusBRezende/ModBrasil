package net.spike.tutorialmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Collections;
import java.util.List;

public class CervejaBlock extends Block {


    public static final IntegerProperty USOS = IntegerProperty.create("usos", 0, 10);

    public CervejaBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(USOS, 10));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(USOS); // Registra a propriedade USOS
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        // Retorna uma lista com uma garrafa de vidro
        return Collections.singletonList(new ItemStack(Items.GLASS_BOTTLE));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide && hand == InteractionHand.MAIN_HAND) {
            // Aplica os efeitos da cerveja ao jogador
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0)); // Efeito de confusão (Náusea)
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 0)); // Efeito de força
            world.playSound(null, pos, SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 1.0F, 1.0F);

            // Reduz a durabilidade do bloco
            int usosRestantes = state.getValue(USOS) - 1;
            if (usosRestantes > 0) {
                world.setBlock(pos, state.setValue(USOS, usosRestantes), 3); // Atualiza o estado do bloco
            } else {
                world.destroyBlock(pos, false); // Destrói o bloco quando os usos acabam
            }

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}