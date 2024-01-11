/*
 * Copyright 2024 RealYusufIsmail.
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
package io.github.realyusufismail.temporalsmith.datagen.loot

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import java.util.*
import java.util.stream.Collectors
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block

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
        add(
            BlockInit.ENDERITE_ORE.get(),
            createOreDrop(BlockInit.ENDERITE_ORE.get(), ItemInit.RAW_ENDERITE.get()))
        add(
            BlockInit.IMPERIUM_ORE.get(),
            createOreDrop(BlockInit.IMPERIUM_ORE.get(), ItemInit.RAW_IMPERIUM.get()))

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
        add(
            BlockInit.DEEPSLATE_IMPERIUM_ORE.get(),
            createOreDrop(BlockInit.DEEPSLATE_IMPERIUM_ORE.get(), ItemInit.RAW_IMPERIUM.get()))

        // blocks
        dropSelf(BlockInit.RUBY_BLOCK.get())
        dropSelf(BlockInit.RAINBOW_BLOCK.get())
        dropSelf(BlockInit.SAPPHIRE_BLOCK.get())
        dropSelf(BlockInit.GRAPHITE_BLOCK.get())
        dropSelf(BlockInit.AQUMARINE_BLOCK.get())
        dropSelf(BlockInit.ENDERITE_BLOCK.get())
        dropSelf(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get())
        dropSelf(BlockInit.CUSTOM_TOOL_CRAFTING_TABLE.get())
        dropSelf(BlockInit.INGOT_FUSION_TOLL_ENHANCER.get())
        dropSelf(BlockInit.ENDERITE_LOG.get())
        dropSelf(BlockInit.ENDERITE_PLANKS.get())
        dropSelf(BlockInit.ENDERITE_SAPLING.get())
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return BuiltInRegistries.BLOCK.stream()
            .filter { entry: Block ->
                Optional.ofNullable(BuiltInRegistries.BLOCK.getKey(entry))
                    .filter { key: ResourceLocation -> key.namespace == MOD_ID }
                    .isPresent
            }
            .filter { entry: Block -> entry != BlockInit.ENDERITE_PORTAL_FRAME.get() }
            .collect(Collectors.toSet())
    }
}
