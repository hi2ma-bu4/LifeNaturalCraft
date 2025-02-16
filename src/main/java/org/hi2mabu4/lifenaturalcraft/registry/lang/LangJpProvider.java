package org.hi2mabu4.lifenaturalcraft.registry.lang;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;
import org.hi2mabu4.lifenaturalcraft.registry.item.ModItems;

import net.minecraft.data.PackOutput;

public class LangJpProvider extends ModLanguageProvider {
    public LangJpProvider(PackOutput output) {
        super(output, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        this.add("tab." + Lifenaturalcraft.MODID + ".creative_tab", "Life Natural Craft");
        this.add(ModItems.RUBY.get(), "ルビー");
        this.add(ModItems.RUBY_ORE_ITEM.get(), "ルビー鉱石");
        this.add(ModItems.RUBY_BLOCK_ITEM.get(), "ルビーブロック");
    }
}
