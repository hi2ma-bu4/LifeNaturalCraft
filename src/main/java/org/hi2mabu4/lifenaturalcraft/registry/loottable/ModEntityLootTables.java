package org.hi2mabu4.lifenaturalcraft.registry.loottable;

import java.util.stream.Stream;

import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;

public class ModEntityLootTables extends EntityLootSubProvider {

    ModEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        // 空を返却
        return Stream.empty();
    }

    @Override
    public void generate() {
        // this.add(MyEntities.EXAMPLE_ENTITY.get(), LootTable.lootTable());
    }
}
