package org.hi2mabu4.lifenaturalcraft.registry.loottable;

import java.util.Collections;

import org.hi2mabu4.lifenaturalcraft.registry.block.ModBlocks;
import org.hi2mabu4.lifenaturalcraft.registry.item.ModItems;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

    ModBlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    public void generate() {
        this.add(ModBlocks.RUBY_ORE.get(), this.createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
    }
}
