package org.hi2mabu4.lifenaturalcraft.datagen;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Lifenaturalcraft.MODID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture("ruby", mcLoc(folder + "/generated"), "layer0",
                new ResourceLocation(Lifenaturalcraft.MODID, folder + "/" + "ruby"));
    }
}
