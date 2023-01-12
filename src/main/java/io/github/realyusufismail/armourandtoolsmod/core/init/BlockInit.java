/*
 * Copyright 2022 RealYusufIsmail.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package io.github.realyusufismail.armourandtoolsmod.core.init;

import io.github.realyusufismail.realyusufismailcore.core.init.GeneralBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.MOD_ID;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    // ores
    public static final RegistryObject<GeneralBlock> RUBY_ORE =
            register("ruby_ore", Blocks.IRON_ORE);
    public static final RegistryObject<GeneralBlock> RAINBOW_ORE =
            register("rainbow_ore", Blocks.DIAMOND_ORE);
    public static final RegistryObject<GeneralBlock> SAPPHIRE_ORE =
            register("sapphire_ore", Blocks.GOLD_ORE);
    public static final RegistryObject<GeneralBlock> GRAPHITE_ORE =
            register("graphite_ore", Blocks.COAL_ORE);
    public static final RegistryObject<GeneralBlock> AQUMARINE_ORE =
            register("aqumarine_ore", Blocks.EMERALD_ORE);

    // deepslate ores
    public static final RegistryObject<GeneralBlock> DEEPSLATE_RUBY_ORE =
            register("deepslate_ruby_ore", Blocks.DEEPSLATE_IRON_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_RAINBOW_ORE =
            register("deepslate_rainbow_ore", Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_SAPPHIRE_ORE =
            register("deepslate_sapphire_ore", Blocks.DEEPSLATE_GOLD_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_GRAPHITE_ORE =
            register("deepslate_graphite_ore", Blocks.DEEPSLATE_COAL_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_AQUMARINE_ORE =
            register("deepslate_aqumarine_ore", Blocks.DEEPSLATE_EMERALD_ORE);

    // blocks
    public static final RegistryObject<GeneralBlock> RUBY_BLOCK =
            register("ruby_block", Blocks.IRON_BLOCK);
    public static final RegistryObject<GeneralBlock> RAINBOW_BLOCK =
            register("rainbow_block", Blocks.DIAMOND_BLOCK);
    public static final RegistryObject<GeneralBlock> SAPPHIRE_BLOCK =
            register("sapphire_block", Blocks.GOLD_BLOCK);
    public static final RegistryObject<GeneralBlock> GRAPHITE_BLOCK =
            register("graphite_block", Blocks.COAL_BLOCK);
    public static final RegistryObject<GeneralBlock> AQUMARINE_BLOCK =
            register("aqumarine_block", Blocks.EMERALD_BLOCK);

    private static RegistryObject<GeneralBlock> register(String name,
            Supplier<GeneralBlock> supplier) {
        RegistryObject<GeneralBlock> blockReg = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }

    private static RegistryObject<GeneralBlock> register(String name, Block existingBlock) {
        return register(name,
                () -> new GeneralBlock(BlockBehaviour.Properties.copy(existingBlock)));
    }
}
