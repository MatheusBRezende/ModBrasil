package net.spike.brasilrl.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.spike.brasilrl.TutorialMod;
import net.spike.brasilrl.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    // Aba criativa do mod
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("brasilrl",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DINHEIRO_1.get())) // Ícone da aba
                    .title(Component.translatable("BRASILRL")) // Título da aba
                    .displayItems((itemDisplayParameters, output) -> {
                        // Adiciona todos os itens do mod à aba
                        output.accept(ModItems.CERVEJA.get());
                        output.accept(ModItems.DINHEIRO_1.get());
                        output.accept(ModItems.DINHEIRO_2.get());
                        output.accept(ModItems.DINHEIRO_5.get());
                        output.accept(ModItems.DINHEIRO_10.get());
                        output.accept(ModItems.DINHEIRO_20.get());
                        output.accept(ModItems.DINHEIRO_50.get());
                        output.accept(ModItems.DINHEIRO_100.get());
                        output.accept(ModItems.REFRIGERANTE.get());

                        output.accept(ModBlocks.AZULEJO_BRASIL.get());
                    })
                    .build());

    // Registra a aba criativa
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}