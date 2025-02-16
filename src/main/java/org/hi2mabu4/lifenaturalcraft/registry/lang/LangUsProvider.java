package org.hi2mabu4.lifenaturalcraft.registry.lang;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;
import org.hi2mabu4.lifenaturalcraft.registry.item.ModItems;

import net.minecraft.data.PackOutput;

public class LangUsProvider extends ModLanguageProvider {
    public LangUsProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("tab." + Lifenaturalcraft.MODID + ".creative_tab", "Life Natural Craft");
        this.add(ModItems.RUBY.get(), "Ruby");
        this.add(ModItems.RUBY_ORE_ITEM.get(), "Ruby Ore");
        this.add(ModItems.RUBY_BLOCK_ITEM.get(), "Ruby Block");
    }
}
