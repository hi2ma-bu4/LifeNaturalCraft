package org.hi2mabu4.lifenaturalcraft;

import org.hi2mabu4.lifenaturalcraft.datagen.ModBlockModelProvider;
import org.hi2mabu4.lifenaturalcraft.datagen.ModItemModelProvider;
import org.hi2mabu4.lifenaturalcraft.datagen.lang.LangJpProvider;
import org.hi2mabu4.lifenaturalcraft.datagen.lang.LangUsProvider;
import org.hi2mabu4.lifenaturalcraft.registry.ModBlockTagsProvider;
import org.hi2mabu4.lifenaturalcraft.registry.ModBlocks;
import org.hi2mabu4.lifenaturalcraft.registry.ModCreativeTabs;
import org.hi2mabu4.lifenaturalcraft.registry.ModItemTagsProvider;
import org.hi2mabu4.lifenaturalcraft.registry.ModItems;
import org.hi2mabu4.lifenaturalcraft.registry.ModRecipeProvider;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// 神資料
// https://docs.minecraftforge.net/en/1.20.x/
// https://www.tntmodders.com/tutorial/#1194
// https://defeatedcrow.jp/modwiki/IGNIS%E5%88%B6%E4%BD%9C%E8%A8%98%E9%8C%B2

@Mod(Lifenaturalcraft.MODID)
public class Lifenaturalcraft {
    public static final String MODID = "lifenaturalcraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Lifenaturalcraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::registerProviders);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void registerProviders(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, fileHelper));
        gen.addProvider(event.includeClient(), new ModBlockModelProvider(packOutput, fileHelper));
        gen.addProvider(event.includeClient(), new LangUsProvider(gen.getPackOutput()));
        gen.addProvider(event.includeClient(), new LangJpProvider(gen.getPackOutput()));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(gen.getPackOutput()));

        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(packOutput, event.getLookupProvider(),
                fileHelper);
        gen.addProvider(event.includeServer(), blockTagsProvider);
        gen.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, event.getLookupProvider(),
                blockTagsProvider.contentsGetter(), fileHelper));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
