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
import io.github.realyusufismail.armourandtoolsmod.core.blocks.lit.RainbowLitBlock
import io.github.realyusufismail.armourandtoolsmod.core.blocks.lit.RubyLitBlock
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

object BlockInit {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID)

    val ORE_BLOCKS: MutableMap<ObjectHolderDelegate<Block>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

    val SMELT_ABLE_BLOCKS: MutableMap<ObjectHolderDelegate<Block>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

    val MINABLE_STONE_PICKAXE_BLOCKS: MutableList<ObjectHolderDelegate<Block>> = mutableListOf()

    val MINABLE_IRON_PICKAXE_BLOCKS: MutableList<ObjectHolderDelegate<Block>> = mutableListOf()

    val MINABLE_GOLD_PICKAXE_BLOCKS: MutableList<ObjectHolderDelegate<Block>> = mutableListOf()

    val MINABLE_DIAMOND_PICKAXE_BLOCKS: MutableList<ObjectHolderDelegate<Block>> = mutableListOf()

    val MINABLE_NETHERITE_PICKAXE_BLOCKS: MutableList<ObjectHolderDelegate<Block>> = mutableListOf()

    // ores
    val RUBY_ORE =
        registerSpecialSmeltAbleBlock(
            "ruby_ore", ItemInit.RUBY, MinableBlockType.IRON_PICKAXE, ::RubyLitBlock)

    val RAINBOW_ORE =
        registerSpecialSmeltAbleBlock(
            "rainbow_ore", ItemInit.RAINBOW, MinableBlockType.DIAMOND_PICKAXE, ::RainbowLitBlock)

    val SAPPHIRE_ORE =
        registerSmeltAbleBlock(
            "sapphire_ore",
            ItemInit.SAPPHIRE,
            BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.GOLD_PICKAXE)

    val GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "graphite_ore",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "aqumarine_ore",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    // deepslate ores
    val DEEPSLATE_RUBY_ORE =
        registerSpecialSmeltAbleBlock(
            "deepslate_ruby_ore", ItemInit.RUBY, MinableBlockType.IRON_PICKAXE, ::RubyLitBlock)

    val DEEPSLATE_RAINBOW_ORE =
        registerSpecialSmeltAbleBlock(
            "deepslate_rainbow_ore",
            ItemInit.RAINBOW,
            MinableBlockType.DIAMOND_PICKAXE,
            ::RainbowLitBlock)

    val DEEPSLATE_SAPPHIRE_ORE =
        registerSmeltAbleBlock(
            "deepslate_sapphire_ore",
            ItemInit.SAPPHIRE,
            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.GOLD_PICKAXE)

    val DEEPSLATE_GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "deepslate_graphite_ore",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val DEEPSLATE_AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "deepslate_aqumarine_ore",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    // blocks
    val RUBY_BLOCK =
        registerOreBlock(
            "ruby_block",
            ItemInit.RUBY,
            BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops(),
            MinableBlockType.IRON_PICKAXE)
    val RAINBOW_BLOCK =
        registerOreBlock(
            "rainbow_block",
            ItemInit.RAINBOW,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val SAPPHIRE_BLOCK =
        registerOreBlock(
            "sapphire_block",
            ItemInit.SAPPHIRE,
            BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops(),
            MinableBlockType.GOLD_PICKAXE)
    val GRAPHITE_BLOCK =
        registerOreBlock(
            "graphite_block",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val AQUMARINE_BLOCK =
        registerOreBlock(
            "aqumarine_block",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    // custom crafting table
    val CUSTOM_ARMOUR_CRAFTING_TABLE =
        registerSpecial("custom_armour_crafting_table", ::CustomArmourCraftingTable)

    private fun <T : Block> registerSpecial(
        name: String,
        supplier: () -> T,
        minableTool: MinableBlockType = MinableBlockType.STONE_PICKAXE,
    ): ObjectHolderDelegate<T> {
        val blockReg = BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }
        checkTypeOfMinableBlock(blockReg as ObjectHolderDelegate<Block>, minableTool)
        return blockReg
    }

    private fun registerSpecialSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        minableTool: MinableBlockType,
        supplier: () -> Block
    ): ObjectHolderDelegate<Block> {

        val blockReg = BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot
        checkTypeOfMinableBlock(blockReg, minableTool)

        return blockReg
    }

    private fun registerOreBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        property: BlockBehaviour.Properties,
        minableTool: MinableBlockType
    ): ObjectHolderDelegate<Block> {

        val blockReg = BLOCKS.registerObject(name) { Block(property) }

        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        ORE_BLOCKS[blockReg] = associatedOreIngot
        checkTypeOfMinableBlock(blockReg, minableTool)

        return blockReg
    }

    private fun registerSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        property: BlockBehaviour.Properties,
        minableTool: MinableBlockType
    ): ObjectHolderDelegate<Block> {

        val blockReg = BLOCKS.registerObject(name) { Block(property) }
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot
        checkTypeOfMinableBlock(blockReg, minableTool)

        return blockReg
    }

    private fun checkTypeOfMinableBlock(
        block: ObjectHolderDelegate<Block>,
        type: MinableBlockType
    ) {
        when (type) {
            MinableBlockType.STONE_PICKAXE -> MINABLE_STONE_PICKAXE_BLOCKS.add(block)
            MinableBlockType.IRON_PICKAXE -> MINABLE_IRON_PICKAXE_BLOCKS.add(block)
            MinableBlockType.GOLD_PICKAXE -> MINABLE_GOLD_PICKAXE_BLOCKS.add(block)
            MinableBlockType.DIAMOND_PICKAXE -> MINABLE_DIAMOND_PICKAXE_BLOCKS.add(block)
            MinableBlockType.NETHERITE_PICKAXE -> MINABLE_NETHERITE_PICKAXE_BLOCKS.add(block)
        }
    }
}
