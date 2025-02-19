package org.hi2mabu4.lifenaturalcraft;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = Lifenaturalcraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
        private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

        // 無限水源を許可しない
        private static final ForgeConfigSpec.BooleanValue IS_FINITE_WATER = BUILDER
                        .comment("Do not allow infinite water sources").define("isFiniteWater", true);

        private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER.comment("A magic number")
                        .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

        public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
                        .comment("What you want the introduction message to be for the magic number")
                        .define("magicNumberIntroduction", "The magic number is... ");

        // a list of strings that are treated as resource locations for items
        private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
                        .comment("A list of items to log on common setup.")
                        .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

        static final ForgeConfigSpec SPEC = BUILDER.build();

        public static boolean isFiniteWater;
        public static int magicNumber;
        public static String magicNumberIntroduction;
        public static Set<Item> items;

        private static boolean validateItemName(final Object obj) {
                return obj instanceof final String itemName
                                && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
        }

        @SubscribeEvent
        static void onLoad(final ModConfigEvent event) {
                isFiniteWater = IS_FINITE_WATER.get();
                magicNumber = MAGIC_NUMBER.get();
                magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

                // convert the list of strings into a set of items
                items = ITEM_STRINGS.get().stream()
                                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                                .collect(Collectors.toSet());
        }
}
