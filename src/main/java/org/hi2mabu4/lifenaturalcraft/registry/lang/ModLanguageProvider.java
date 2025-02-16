package org.hi2mabu4.lifenaturalcraft.registry.lang;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, Lifenaturalcraft.MODID, locale);
    }
}
