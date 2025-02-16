package org.hi2mabu4.lifenaturalcraft.registry.block;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Lifenaturalcraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.RUBY_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.RUBY_BLOCK.get());
    }
}
