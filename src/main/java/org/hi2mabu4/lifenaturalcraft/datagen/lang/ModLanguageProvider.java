package org.hi2mabu4.lifenaturalcraft.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;

public abstract class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, Lifenaturalcraft.MODID, locale);
    }
}
