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
package io.github.realyusufismail.armourandtoolsmod.datagen.loot

import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import java.util.*
import java.util.stream.Collectors
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.ForgeRegistries

class ModBlockLootTables : BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags()) {
    override fun generate() {
        // normal ores
        add(
            BlockInit.RUBY_ORE.get(),
            createOreDrop(BlockInit.RUBY_ORE.get(), ItemInit.RAW_RUBY.get()))
        add(
            BlockInit.RAINBOW_ORE.get(),
            createOreDrop(BlockInit.RAINBOW_ORE.get(), ItemInit.RAW_RAINBOW.get()))
        add(
            BlockInit.SAPPHIRE_ORE.get(),
            createOreDrop(BlockInit.SAPPHIRE_ORE.get(), ItemInit.RAW_SAPPHIRE.get()))
        add(
            BlockInit.GRAPHITE_ORE.get(),
            createOreDrop(BlockInit.GRAPHITE_ORE.get(), ItemInit.RAW_GRAPHITE.get()))
        add(
            BlockInit.AQUMARINE_ORE.get(),
            createOreDrop(BlockInit.AQUMARINE_ORE.get(), ItemInit.RAW_AQUMARINE.get()))

        // deepslate ores
        add(
            BlockInit.DEEPSLATE_RUBY_ORE.get(),
            createOreDrop(BlockInit.DEEPSLATE_RUBY_ORE.get(), ItemInit.RAW_RUBY.get()))
        add(
            BlockInit.DEEPSLATE_RAINBOW_ORE.get(),
            createOreDrop(BlockInit.DEEPSLATE_RAINBOW_ORE.get(), ItemInit.RAW_RAINBOW.get()))
        add(
            BlockInit.DEEPSLATE_SAPPHIRE_ORE.get(),
            createOreDrop(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get(), ItemInit.RAW_SAPPHIRE.get()))
        add(
            BlockInit.DEEPSLATE_GRAPHITE_ORE.get(),
            createOreDrop(BlockInit.DEEPSLATE_GRAPHITE_ORE.get(), ItemInit.RAW_GRAPHITE.get()))
        add(
            BlockInit.DEEPSLATE_AQUMARINE_ORE.get(),
            createOreDrop(BlockInit.DEEPSLATE_AQUMARINE_ORE.get(), ItemInit.RAW_AQUMARINE.get()))

        // blocks
        dropSelf(BlockInit.RUBY_BLOCK.get())
        dropSelf(BlockInit.RAINBOW_BLOCK.get())
        dropSelf(BlockInit.SAPPHIRE_BLOCK.get())
        dropSelf(BlockInit.GRAPHITE_BLOCK.get())
        dropSelf(BlockInit.AQUMARINE_BLOCK.get())
        dropSelf(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get())
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return ForgeRegistries.BLOCKS.values
            .stream()
            .filter { entry: Block? ->
                Optional.ofNullable(ForgeRegistries.BLOCKS.getKey(entry))
                    .filter { key: ResourceLocation -> key.namespace == MOD_ID }
                    .isPresent
            }
            .collect(Collectors.toSet())
    }
}
