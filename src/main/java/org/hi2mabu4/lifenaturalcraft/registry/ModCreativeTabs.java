package org.hi2mabu4.lifenaturalcraft.registry;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;
import org.hi2mabu4.lifenaturalcraft.registry.item.ModItems;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
                        .create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, Lifenaturalcraft.MODID);

        public static final RegistryObject<CreativeModeTab> TAB_LNC = CREATIVE_MODE_TABS.register(
                        "lifenaturalcraft_tab",
                        () -> CreativeModeTab.builder()
                                        .withTabsBefore(CreativeModeTabs.NATURAL_BLOCKS)
                                        .title(Component.translatable(
                                                        "tab." + Lifenaturalcraft.MODID + ".creative_tab"))
                                        .icon(() -> ModItems.RUBY.get().getDefaultInstance())
                                        .displayItems((parameters, output) -> {
                                                output.accept(ModItems.RUBY.get());
                                                output.accept(ModItems.RUBY_ORE_ITEM.get());
                                                output.accept(ModItems.RUBY_BLOCK_ITEM.get());
                                        })
                                        .build());
}
