package net.spike.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spike.tutorialmod.TutorialMod;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MODID);

    public static final RegistryObject<Item> CERVEJA = ITEMS.register("cerveja",
            () -> new CervejaItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(2) // Quantidade de fome recuperada
                            .saturationMod(0.6f) // Nível de saturação
                            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 0.5f) // Efeito de náusea
                            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 300, 0), 0.5f) // Efeito de fraqueza
                            .alwaysEat() // Permite que o item seja consumido mesmo com a barra de fome cheia
                            .build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> DINHEIRO_1 = ITEMS.register("dinheiro_1",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_2 = ITEMS.register("dinheiro_2",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_5 = ITEMS.register("dinheiro_5",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_10 = ITEMS.register("dinheiro_10",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_20 = ITEMS.register("dinheiro_20",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_50 = ITEMS.register("dinheiro_50",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_100 = ITEMS.register("dinheiro_100",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_200 = ITEMS.register("dinheiro_200",
            () -> new Item(new Item.Properties()));
}