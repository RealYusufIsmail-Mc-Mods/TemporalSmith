/*
 * Copyright 2023 RealYusufIsmail.
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

import blocks.lit.RainbowLitBlock
import blocks.lit.RubyLitBlock
import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.temporalSmithItemGroup
import io.github.realyusufismail.temporalsmith.core.util.ObjectHolderDelegate
import io.github.realyusufismail.temporalsmith.core.util.registerObject
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object BlockInit {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID)

    val ORE_BLOCKS: MutableMap<ObjectHolderDelegate<Block>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

    val SMELT_ABLE_BLOCKS: MutableMap<ObjectHolderDelegate<Block>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

    val RUBY_ORE = registerSpecialSmeltAbleBlock("ruby_ore", ItemInit.RUBY, ::RubyLitBlock)

    val RAINBOW_ORE =
        registerSpecialSmeltAbleBlock("rainbow_ore", ItemInit.RAINBOW, ::RainbowLitBlock)

    val SAPPHIRE_ORE =
        registerSmeltAbleBlock(
            "sapphire_ore",
            ItemInit.SAPPHIRE,
            AbstractBlock.Properties.copy(Blocks.GOLD_ORE).requiresCorrectToolForDrops())

    val GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "graphite_ore",
            ItemInit.GRAPHITE,
            AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops())

    val AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "aqumarine_ore",
            ItemInit.AQUMARINE,
            AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops())

    val ENDERITE_ORE =
        registerSmeltAbleBlock(
            "enderite_ore",
            ItemInit.ENDERITE,
            AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops())

    val IMPERIUM_ORE =
        registerSmeltAbleBlock(
            "imperium_ore",
            ItemInit.IMPERIUM,
            AbstractBlock.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops())

    // blocks
    val RUBY_BLOCK =
        registerOreBlock(
            "ruby_block",
            ItemInit.RUBY,
            AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops())

    val RAINBOW_BLOCK =
        registerOreBlock(
            "rainbow_block",
            ItemInit.RAINBOW,
            AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops())

    val SAPPHIRE_BLOCK =
        registerOreBlock(
            "sapphire_block",
            ItemInit.SAPPHIRE,
            AbstractBlock.Properties.copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops())

    val GRAPHITE_BLOCK =
        registerOreBlock(
            "graphite_block",
            ItemInit.GRAPHITE,
            AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops())

    val AQUMARINE_BLOCK =
        registerOreBlock(
            "aqumarine_block",
            ItemInit.AQUMARINE,
            AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops())

    @JvmField
    val ENDERITE_BLOCK =
        registerOreBlock(
            "enderite_block",
            ItemInit.ENDERITE,
            AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops())

    private fun <T : Block> registerSpecial(
        name: String,
        supplier: () -> T,
    ): ObjectHolderDelegate<T> {
        val blockReg = BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) {
            BlockItem(blockReg.get(), Item.Properties().tab(temporalSmithItemGroup))
        }
        return blockReg
    }

    private fun registerSpecialSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        supplier: () -> Block
    ): ObjectHolderDelegate<Block> {

        val blockReg = BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) {
            BlockItem(blockReg.get(), Item.Properties().tab(temporalSmithItemGroup))
        }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot

        return blockReg
    }

    private fun registerOreBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        property: AbstractBlock.Properties,
    ): ObjectHolderDelegate<Block> {

        val blockReg = BLOCKS.registerObject(name) { Block(property) }

        ItemInit.ITEMS.registerObject(name) {
            BlockItem(blockReg.get(), Item.Properties().tab(temporalSmithItemGroup))
        }

        ORE_BLOCKS[blockReg] = associatedOreIngot

        return blockReg
    }

    private fun registerSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        property: AbstractBlock.Properties,
    ): ObjectHolderDelegate<Block> {

        val blockReg = BLOCKS.registerObject(name) { Block(property) }
        ItemInit.ITEMS.registerObject(name) {
            BlockItem(blockReg.get(), Item.Properties().tab(temporalSmithItemGroup))
        }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot

        return blockReg
    }
}
