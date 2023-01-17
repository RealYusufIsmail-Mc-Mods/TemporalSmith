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

    // ores
    val RUBY_ORE = register("ruby_ore", Blocks.IRON_ORE)
    val RAINBOW_ORE = register("rainbow_ore", Blocks.DIAMOND_ORE)
    val SAPPHIRE_ORE = register("sapphire_ore", Blocks.GOLD_ORE)
    val GRAPHITE_ORE = register("graphite_ore", Blocks.DIAMOND_ORE)
    val AQUMARINE_ORE = register("aqumarine_ore", Blocks.DIAMOND_ORE)

    // deepslate ores
    val DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore", Blocks.DEEPSLATE_IRON_ORE)
    val DEEPSLATE_RAINBOW_ORE = register("deepslate_rainbow_ore", Blocks.DEEPSLATE_DIAMOND_ORE)
    val DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", Blocks.DEEPSLATE_GOLD_ORE)
    val DEEPSLATE_GRAPHITE_ORE = register("deepslate_graphite_ore", Blocks.DEEPSLATE_DIAMOND_ORE)
    val DEEPSLATE_AQUMARINE_ORE = register("deepslate_aqumarine_ore", Blocks.DEEPSLATE_DIAMOND_ORE)

    // blocks
    val RUBY_BLOCK = register("ruby_block", Blocks.IRON_BLOCK)
    val RAINBOW_BLOCK = register("rainbow_block", Blocks.DIAMOND_BLOCK)
    val SAPPHIRE_BLOCK = register("sapphire_block", Blocks.GOLD_BLOCK)
    val GRAPHITE_BLOCK = register("graphite_block", Blocks.DIAMOND_BLOCK)
    val AQUMARINE_BLOCK = register("aqumarine_block", Blocks.DIAMOND_BLOCK)

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

    private fun register(name: String, existingBlock: Block): ObjectHolderDelegate<Block> {
        return register(name) { GeneralBlock(BlockBehaviour.Properties.copy(existingBlock)) }
    }
}
