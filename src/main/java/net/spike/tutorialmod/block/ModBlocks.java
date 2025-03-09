package net.spike.tutorialmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spike.tutorialmod.TutorialMod;
import net.spike.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MODID);

    // Registro do bloco de cerveja
    public static final RegistryObject<Block> CERVEJA_BLOCK = registerBlock("cerveja_block",
            () -> new CervejaBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
                    .strength(0.5f)
                    .sound(SoundType.GLASS)
                    .noOcclusion()
            ));
    // Método para registrar blocos e seus itens correspondentes
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Método para registrar o item do bloco
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Método para registrar todos os blocos no evento do mod
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}