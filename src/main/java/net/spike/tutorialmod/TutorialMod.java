package net.spike.tutorialmod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.spike.tutorialmod.block.ModBlocks;
import net.spike.tutorialmod.item.ModCreativeModTabs;
import net.spike.tutorialmod.item.ModItems;

@Mod(TutorialMod.MODID)
public class TutorialMod {
    public static final String MODID = "tutorialmod";

    public TutorialMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Registra as abas criativas
        ModCreativeModTabs.register(modEventBus);

        // Registra os itens
        ModItems.register(modEventBus);

        // Registra os blocks
        ModBlocks.register(modEventBus);

        // Configurações comuns
        modEventBus.addListener(this::commonSetup);

        // Configurações do cliente
        modEventBus.addListener(ClientModEvents::onClientSetup);

        // Registra eventos do Forge
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Configurações iniciais comuns
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Configurações específicas do cliente
        }
    }
}