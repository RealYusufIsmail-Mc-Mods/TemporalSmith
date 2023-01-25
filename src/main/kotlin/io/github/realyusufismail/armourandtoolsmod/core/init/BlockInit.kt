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
package io.github.realyusufismail.armourandtoolsmod.core.init

import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.core.blocks.CustomArmourCraftingTable
import io.github.realyusufismail.realyusufismailcore.core.init.GeneralBlock
import net.minecraft.world.item.*
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

object BlockInit {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID)

    val ORE_BLOCKS: MutableMap<ObjectHolderDelegate<GeneralBlock>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

    val SMELT_ABLE_BLOCKS:
        MutableMap<ObjectHolderDelegate<GeneralBlock>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

    // ores
    val RUBY_ORE = registerSmeltAbleBlock("ruby_ore", ItemInit.RUBY, Blocks.IRON_ORE)
    val RAINBOW_ORE = registerSmeltAbleBlock("rainbow_ore", ItemInit.RAINBOW, Blocks.DIAMOND_ORE)
    val SAPPHIRE_ORE = registerSmeltAbleBlock("sapphire_ore", ItemInit.SAPPHIRE, Blocks.GOLD_ORE)
    val GRAPHITE_ORE = registerSmeltAbleBlock("graphite_ore", ItemInit.GRAPHITE, Blocks.DIAMOND_ORE)
    val AQUMARINE_ORE =
        registerSmeltAbleBlock("aqumarine_ore", ItemInit.AQUMARINE, Blocks.DIAMOND_ORE)

    // deepslate ores
    val DEEPSLATE_RUBY_ORE =
        registerSmeltAbleBlock("deepslate_ruby_ore", ItemInit.RUBY, Blocks.DEEPSLATE_IRON_ORE)
    val DEEPSLATE_RAINBOW_ORE =
        registerSmeltAbleBlock(
            "deepslate_rainbow_ore", ItemInit.RAINBOW, Blocks.DEEPSLATE_DIAMOND_ORE)
    val DEEPSLATE_SAPPHIRE_ORE =
        registerSmeltAbleBlock(
            "deepslate_sapphire_ore", ItemInit.SAPPHIRE, Blocks.DEEPSLATE_GOLD_ORE)
    val DEEPSLATE_GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "deepslate_graphite_ore", ItemInit.GRAPHITE, Blocks.DEEPSLATE_DIAMOND_ORE)
    val DEEPSLATE_AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "deepslate_aqumarine_ore", ItemInit.AQUMARINE, Blocks.DEEPSLATE_DIAMOND_ORE)

    // blocks
    val RUBY_BLOCK = registerOreBlock("ruby_block", ItemInit.RUBY, Blocks.IRON_BLOCK)
    val RAINBOW_BLOCK = registerOreBlock("rainbow_block", ItemInit.RAINBOW, Blocks.DIAMOND_BLOCK)
    val SAPPHIRE_BLOCK = registerOreBlock("sapphire_block", ItemInit.SAPPHIRE, Blocks.GOLD_BLOCK)
    val GRAPHITE_BLOCK = registerOreBlock("graphite_block", ItemInit.GRAPHITE, Blocks.DIAMOND_BLOCK)
    val AQUMARINE_BLOCK =
        registerOreBlock("aqumarine_block", ItemInit.AQUMARINE, Blocks.DIAMOND_BLOCK)

    // custom crafting table
    val CUSTOM_ARMOUR_CRAFTING_TABLE =
        registerSpecial("custom_armour_crafting_table", ::CustomArmourCraftingTable)

    private fun <T : Block> registerSpecial(
        name: String,
        supplier: () -> T,
    ): ObjectHolderDelegate<T> {
        val blockReg = BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }
        return blockReg
    }

    private fun register(name: String, supplier: () -> Block): ObjectHolderDelegate<Block> {
        val blockReg = BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }
        return blockReg
    }

    private fun registerOreBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        existingBlock: Block
    ): ObjectHolderDelegate<GeneralBlock> {

        val blockReg =
            BLOCKS.registerObject(name) {
                GeneralBlock(BlockBehaviour.Properties.copy(existingBlock))
            }
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        ORE_BLOCKS[blockReg] = associatedOreIngot
        return blockReg
    }

    private fun registerSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        existingBlock: Block
    ): ObjectHolderDelegate<GeneralBlock> {

        val blockReg =
            BLOCKS.registerObject(name) {
                GeneralBlock(BlockBehaviour.Properties.copy(existingBlock))
            }
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot
        return blockReg
    }

    private fun register(name: String, existingBlock: Block): ObjectHolderDelegate<Block> {
        return register(name) { GeneralBlock(BlockBehaviour.Properties.copy(existingBlock)) }
    }
}
