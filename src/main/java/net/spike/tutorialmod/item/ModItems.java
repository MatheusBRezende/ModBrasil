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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> DINHEIRO_1 = ITEMS.register("dinheiro1",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_2 = ITEMS.register("dinheiro2",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_5 = ITEMS.register("dinheiro5",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_10 = ITEMS.register("dinheiro10",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_20 = ITEMS.register("dinheiro20",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_50 = ITEMS.register("dinheiro50",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_100 = ITEMS.register("dinheiro100",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINHEIRO_200 = ITEMS.register("dinheiro200",
            () -> new Item(new Item.Properties()));
}