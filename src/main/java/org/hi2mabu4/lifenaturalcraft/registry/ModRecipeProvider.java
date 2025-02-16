package org.hi2mabu4.lifenaturalcraft.registry;

import javax.annotation.Nonnull;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@Nonnull RecipeOutput consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.RUBY.get(), 9)
                .requires(ModItems.RUBY_BLOCK_ITEM.get())
                .group(Lifenaturalcraft.MODID)
                .unlockedBy("has_ruby_block", has(ModItems.RUBY_BLOCK_ITEM.get()))
                .save(consumer, new ResourceLocation(Lifenaturalcraft.MODID, "ruby"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK.get(), 1)
                .define('#', ModItems.RUBY.get())
                .pattern("###").pattern("###").pattern("###")
                .group(Lifenaturalcraft.MODID)
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer, new ResourceLocation(Lifenaturalcraft.MODID, "ruby_block"));
    }
}
