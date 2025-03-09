package net.spike.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.spike.tutorialmod.TutorialMod;


public class ModCreativeModTabs{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder(). icon(()-> new ItemStack(ModItems.DINHEIRO_1.get()))

                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DINHEIRO_1.get());
                        output.accept(ModItems.DINHEIRO_2.get());
                        output.accept(ModItems.DINHEIRO_5.get());
                        output.accept(ModItems.DINHEIRO_10.get());
                        output.accept(ModItems.DINHEIRO_20.get());
                        output.accept(ModItems.DINHEIRO_50.get());
                        output.accept(ModItems.DINHEIRO_100.get());
                        output.accept(ModItems.DINHEIRO_200.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}