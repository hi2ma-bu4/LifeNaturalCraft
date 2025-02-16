package org.hi2mabu4.lifenaturalcraft.registry.block;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockStateProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Lifenaturalcraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlockWithItem(ModBlocks.RUBY_ORE.get(), this.cubeAll(ModBlocks.RUBY_ORE.get()));
        this.simpleBlockWithItem(ModBlocks.RUBY_BLOCK.get(), this.cubeAll(ModBlocks.RUBY_BLOCK.get()));
    }
}
