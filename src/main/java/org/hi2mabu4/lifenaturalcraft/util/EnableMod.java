package org.hi2mabu4.lifenaturalcraft.util;

import net.minecraftforge.fml.ModList;

public class EnableMod {

    protected static ModList modList;

    public static void init() {
        modList = ModList.get();
    }

    public static boolean isLoaded(String modId) {
        return modList.isLoaded(modId);
    }
}
