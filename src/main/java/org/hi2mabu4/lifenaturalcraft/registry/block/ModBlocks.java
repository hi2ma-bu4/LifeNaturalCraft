package org.hi2mabu4.lifenaturalcraft.registry.block;

import org.hi2mabu4.lifenaturalcraft.Lifenaturalcraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        Lifenaturalcraft.MODID);

        public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore",
                        () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                                        .mapColor(MapColor.STONE).strength(3.0f, 6.0f)));
        public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
                        () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                                        .mapColor(MapColor.COLOR_RED).strength(1.5f, 6.0f)));

}
