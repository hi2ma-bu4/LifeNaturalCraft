package org.hi2mabu4.lifenaturalcraft.registry;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        Lifenaturalcraft.MODID);

        public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
                        () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
        public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore",
                        () -> new BlockItem(ModBlocks.RUBY_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",
                        () -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties()));
}
