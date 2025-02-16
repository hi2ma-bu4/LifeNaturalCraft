package org.hi2mabu4.lifenaturalcraft.registry.loottable;

import java.util.Collections;
import java.util.List;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output) {
        super(output, Collections.emptySet(), List.of(
                new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ModEntityLootTables::new, LootContextParamSets.ENTITY)));
    }

}
