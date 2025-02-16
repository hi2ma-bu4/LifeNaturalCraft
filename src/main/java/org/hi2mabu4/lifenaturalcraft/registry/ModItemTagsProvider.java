package org.hi2mabu4.lifenaturalcraft.registry;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public static final TagKey<Item> IT_GEMS_RUBY = ItemTags.create(new ResourceLocation("forge", "gems/ruby"));
    public static final TagKey<Item> IT_ORES_RUBY = ItemTags.create(new ResourceLocation("forge", "ores/ruby"));
    public static final TagKey<Item> IT_BLOCKS_RUBY = ItemTags.create(new ResourceLocation("forge", "blocks/ruby"));

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, future, Lifenaturalcraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(IT_GEMS_RUBY).add(ModItems.RUBY.get());
        this.tag(IT_ORES_RUBY).add(ModItems.RUBY_ORE_ITEM.get());
        this.tag(IT_BLOCKS_RUBY).add(ModItems.RUBY_BLOCK_ITEM.get());
    }
}
