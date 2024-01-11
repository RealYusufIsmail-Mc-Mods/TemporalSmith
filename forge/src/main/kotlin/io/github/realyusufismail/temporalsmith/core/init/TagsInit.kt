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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object TagsInit {

    object BlockTagsInit {
        val ORES_RUBY: TagKey<Block> =
            ResourceLocation.tryParse("forge:ores/ruby_ores")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val ORES_RAINBOW: TagKey<Block> =
            ResourceLocation.tryParse("forge:ores/rainbow_ores")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val ORES_SAPPHIRE: TagKey<Block> =
            ResourceLocation.tryParse("forge:ores/sapphire_ores")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val ORES_GRAPHITE: TagKey<Block> =
            ResourceLocation.tryParse("forge:ores/graphite_ores")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val ORES_AQUMARINE: TagKey<Block> =
            ResourceLocation.tryParse("forge:ores/aqumarine_ores")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val ORES_ENDERITE: TagKey<Block> =
            ResourceLocation.tryParse("forge:ores/enderite_ores")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val ORES_IMPERIUM: TagKey<Block> =
            ResourceLocation.tryParse("forge:ores/imperium_ores")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        // deepslate ores
        val DEEPSLATE_ORES_RUBY: TagKey<Block> =
            ResourceLocation.tryParse("forge:deepslate_ores/ruby_ores")?.let {
                BlockTags.create(it)
            }
                ?: throw Exception("Failed to create tag")

        val DEEPSLATE_ORES_RAINBOW: TagKey<Block> =
            ResourceLocation.tryParse("forge:deepslate_ores/rainbow_ores")?.let {
                BlockTags.create(it)
            }
                ?: throw Exception("Failed to create tag")

        val DEEPSLATE_ORES_SAPPHIRE: TagKey<Block> =
            ResourceLocation.tryParse("forge:deepslate_ores/sapphire_ores")?.let {
                BlockTags.create(it)
            }
                ?: throw Exception("Failed to create tag")

        val DEEPSLATE_ORES_GRAPHITE: TagKey<Block> =
            ResourceLocation.tryParse("forge:deepslate_ores/graphite_ores")?.let {
                BlockTags.create(it)
            }
                ?: throw Exception("Failed to create tag")

        val DEEPSLATE_ORES_AQUMARINE: TagKey<Block> =
            ResourceLocation.tryParse("forge:deepslate_ores/aqumarine_ores")?.let {
                BlockTags.create(it)
            }
                ?: throw Exception("Failed to create tag")

        val DEEPSLATE_ORES_IMPERIUM: TagKey<Block> =
            ResourceLocation.tryParse("forge:deepslate_ores/imperium_ores")?.let {
                BlockTags.create(it)
            }
                ?: throw Exception("Failed to create tag")

        // storage blocks
        val STORAGE_RUBY =
            ResourceLocation.tryParse("forge:storage_blocks/ruby")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val STORAGE_RAINBOW =
            ResourceLocation.tryParse("forge:storage_blocks/rainbow")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val STORAGE_SAPPHIRE =
            ResourceLocation.tryParse("forge:storage_blocks/sapphire")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val STORAGE_GRAPHITE =
            ResourceLocation.tryParse("forge:storage_blocks/graphite")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        val STORAGE_AQUMARINE =
            ResourceLocation.tryParse("forge:storage_blocks/aqumarine")?.let {
                BlockTags.create(it)
            }
                ?: throw Exception("Failed to create tag")

        val STORAGE_ENDERITE =
            ResourceLocation.tryParse("forge:storage_blocks/enderite")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")

        // other
        @JvmField
        val PORTAL_MAKER_BLOCKS =
            ResourceLocation.tryParse("$MOD_ID:portal_maker_blocks")?.let { BlockTags.create(it) }
                ?: throw Exception("Failed to create tag")
    }

    object ItemTagsInit {
        val ORES_RUBY: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ores/ruby_ores")
                    ?: throw Exception("Failed to create tag"))

        val ORES_RAINBOW: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ores/rainbow_ores")
                    ?: throw Exception("Failed to create tag"))

        val ORES_SAPPHIRE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ores/sapphire_ores")
                    ?: throw Exception("Failed to create tag"))

        val ORES_GRAPHITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ores/graphite_ores")
                    ?: throw Exception("Failed to create tag"))

        val ORES_AQUMARINE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ores/aqumarine_ores")
                    ?: throw Exception("Failed to create tag"))

        val ORES_ENDERITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ores/enderite_ores")
                    ?: throw Exception("Failed to create tag"))

        val ORES_IMPERIUM: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ores/imperium_ores")
                    ?: throw Exception("Failed to create tag"))

        // deepslate ores
        val DEEPSLATE_ORES_RUBY: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:deepslate_ores/ruby_ores")
                    ?: throw Exception("Failed to create tag"))

        val DEEPSLATE_ORES_RAINBOW: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:deepslate_ores/rainbow_ores")
                    ?: throw Exception("Failed to create tag"))

        val DEEPSLATE_ORES_SAPPHIRE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:deepslate_ores/sapphire_ores")
                    ?: throw Exception("Failed to create tag"))

        val DEEPSLATE_ORES_GRAPHITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:deepslate_ores/graphite_ores")
                    ?: throw Exception("Failed to create tag"))

        val DEEPSLATE_ORES_AQUMARINE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:deepslate_ores/aqumarine_ores")
                    ?: throw Exception("Failed to create tag"))

        val DEEPSLATE_ORES_IMPERIUM: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:deepslate_ores/imperium_ores")
                    ?: throw Exception("Failed to create tag"))

        val PORTAL_FRAME_BLOCKS: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("$MOD_ID:portal_frame_blocks")
                    ?: throw Exception("Failed to create tag"))

        // storage blocks
        val STORAGE_RUBY: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:storage_blocks/ruby")
                    ?: throw Exception("Failed to create tag"))

        val STORAGE_RAINBOW: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:storage_blocks/rainbow")
                    ?: throw Exception("Failed to create tag"))

        val STORAGE_SAPPHIRE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:storage_blocks/sapphire")
                    ?: throw Exception("Failed to create tag"))

        val STORAGE_GRAPHITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:storage_blocks/graphite")
                    ?: throw Exception("Failed to create tag"))

        val STORAGE_AQUMARINE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:storage_blocks/aqumarine")
                    ?: throw Exception("Failed to create tag"))

        val STORAGE_ENDERITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:storage_blocks/enderite")
                    ?: throw Exception("Failed to create tag"))

        // ore ingots
        val INGOTS_RUBY: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ingots/ruby")
                    ?: throw Exception("Failed to create tag"))

        val INGOTS_RAINBOW: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ingots/rainbow")
                    ?: throw Exception("Failed to create tag"))

        val INGOTS_SAPPHIRE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ingots/sapphire")
                    ?: throw Exception("Failed to create tag"))

        val INGOTS_GRAPHITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ingots/graphite")
                    ?: throw Exception("Failed to create tag"))

        val INGOTS_AQUMARINE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ingots/aqumarine")
                    ?: throw Exception("Failed to create tag"))

        val INGOTS_ENDERITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ingots/enderite")
                    ?: throw Exception("Failed to create tag"))

        val INGOTS_IMPERIUM: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:ingots/imperium")
                    ?: throw Exception("Failed to create tag"))

        // raw ore scraps
        val RAW_RUBY: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:scraps/ruby")
                    ?: throw Exception("Failed to create tag"))

        val RAW_RAINBOW: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:scraps/rainbow")
                    ?: throw Exception("Failed to create tag"))

        val RAW_SAPPHIRE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:scraps/sapphire")
                    ?: throw Exception("Failed to create tag"))

        val RAW_GRAPHITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:scraps/graphite")
                    ?: throw Exception("Failed to create tag"))

        val RAW_AQUMARINE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:scraps/aqumarine")
                    ?: throw Exception("Failed to create tag"))

        val RAW_ENDERITE: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:scraps/enderite")
                    ?: throw Exception("Failed to create tag"))

        val RAW_IMPERIUM: TagKey<Item> =
            ItemTags.create(
                ResourceLocation.tryParse("forge:scraps/imperium")
                    ?: throw Exception("Failed to create tag"))
    }
}
