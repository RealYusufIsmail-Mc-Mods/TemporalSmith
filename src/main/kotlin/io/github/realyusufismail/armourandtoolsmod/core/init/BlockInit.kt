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
import io.github.realyusufismail.armourandtoolsmod.core.blocks.LITBlock
import io.github.realyusufismail.realyusufismailcore.core.init.GeneralBlock
import java.util.function.ToIntFunction
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.BlockStateProperties
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
    val RUBY_ORE = registerSpecialSmeltAbleBlock("ruby_ore", ItemInit.RUBY, ::LITBlock)
    val RAINBOW_ORE = registerSpecialSmeltAbleBlock("rainbow_ore", ItemInit.RAINBOW, ::LITBlock)
    val SAPPHIRE_ORE =
        registerSmeltAbleBlock(
            "sapphire_ore",
            ItemInit.SAPPHIRE,
            BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).requiresCorrectToolForDrops())
    val GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "graphite_ore",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops())
    val AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "aqumarine_ore",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops())

    // deepslate ores
    val DEEPSLATE_RUBY_ORE =
        registerSpecialSmeltAbleBlock("deepslate_ruby_ore", ItemInit.RUBY, ::LITBlock)

    val DEEPSLATE_RAINBOW_ORE =
        registerSpecialSmeltAbleBlock("deepslate_rainbow_ore", ItemInit.RAINBOW, ::LITBlock)
    val DEEPSLATE_SAPPHIRE_ORE =
        registerSmeltAbleBlock(
            "deepslate_sapphire_ore",
            ItemInit.SAPPHIRE,
            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops())
    val DEEPSLATE_GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "deepslate_graphite_ore",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                .requiresCorrectToolForDrops())
    val DEEPSLATE_AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "deepslate_aqumarine_ore",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                .requiresCorrectToolForDrops())

    // blocks
    val RUBY_BLOCK =
        registerOreBlock(
            "ruby_block",
            ItemInit.RUBY,
            BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops())
    val RAINBOW_BLOCK =
        registerOreBlock(
            "rainbow_block",
            ItemInit.RAINBOW,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops())
    val SAPPHIRE_BLOCK =
        registerOreBlock(
            "sapphire_block",
            ItemInit.SAPPHIRE,
            BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops())
    val GRAPHITE_BLOCK =
        registerOreBlock(
            "graphite_block",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops())
    val AQUMARINE_BLOCK =
        registerOreBlock(
            "aqumarine_block",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops())

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

    private fun <T : Block> registerSpecialSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        supplier: () -> T,
    ): ObjectHolderDelegate<T> {

        val blockReg = BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg as ObjectHolderDelegate<GeneralBlock>] = associatedOreIngot
        return blockReg
    }

    private fun registerOreBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        property: BlockBehaviour.Properties,
    ): ObjectHolderDelegate<GeneralBlock> {

        val blockReg = BLOCKS.registerObject(name) { GeneralBlock(property) }

        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        ORE_BLOCKS[blockReg] = associatedOreIngot
        return blockReg
    }

    private fun registerSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        block: GeneralBlock,
    ): ObjectHolderDelegate<GeneralBlock> {

        val blockReg = BLOCKS.registerObject(name) { block }
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot
        return blockReg
    }

    private fun registerSmeltAbleBlock(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        property: BlockBehaviour.Properties,
    ): ObjectHolderDelegate<GeneralBlock> {

        val blockReg = BLOCKS.registerObject(name) { GeneralBlock(property) }
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot
        return blockReg
    }

    fun litBlockEmission(pLightValue: Int): ToIntFunction<BlockState> {
        return ToIntFunction { p_50763_: BlockState ->
            if (p_50763_.getValue(BlockStateProperties.LIT)) pLightValue else 0
        }
    }
}
