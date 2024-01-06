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

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.blocks.*
import io.github.realyusufismail.temporalsmith.blocks.lit.RainbowLitBlock
import io.github.realyusufismail.temporalsmith.blocks.lit.RubyLitBlock
import io.github.realyusufismail.temporalsmith.worldgen.ModConfiguredFeatures
import java.util.*
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SaplingBlock
import net.minecraft.world.level.block.grower.TreeGrower
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

object BlockInit {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(MOD_ID)

    val ORE_BLOCKS: MutableMap<DeferredBlock<Block>, DeferredItem<Item>> = mutableMapOf()

    val SMELT_ABLE_BLOCKS: MutableMap<DeferredBlock<Block>, DeferredItem<Item>> = mutableMapOf()

    val MINABLE_STONE_PICKAXE_BLOCKS: MutableList<DeferredBlock<Block>> = mutableListOf()

    val MINABLE_IRON_PICKAXE_BLOCKS: MutableList<DeferredBlock<Block>> = mutableListOf()

    val MINABLE_GOLD_PICKAXE_BLOCKS: MutableList<DeferredBlock<Block>> = mutableListOf()

    val MINABLE_DIAMOND_PICKAXE_BLOCKS: MutableList<DeferredBlock<Block>> = mutableListOf()

    val MINABLE_NETHERITE_PICKAXE_BLOCKS: MutableList<DeferredBlock<Block>> = mutableListOf()

    val MINABLE_WOODEN_AXE_BLOCKS: MutableList<DeferredBlock<Block>> = mutableListOf()

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
            BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.GOLD_PICKAXE)

    val GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "graphite_ore",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "aqumarine_ore",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val ENDERITE_ORE =
        registerSmeltAbleBlock(
            "enderite_ore",
            ItemInit.ENDERITE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val IMPERIUM_ORE =
        registerSmeltAbleBlock(
            "imperium_ore",
            ItemInit.IMPERIUM,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).requiresCorrectToolForDrops(),
            MinableBlockType.IRON_PICKAXE)

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
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_GOLD_ORE)
                .requiresCorrectToolForDrops(),
            MinableBlockType.GOLD_PICKAXE)

    val DEEPSLATE_GRAPHITE_ORE =
        registerSmeltAbleBlock(
            "deepslate_graphite_ore",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val DEEPSLATE_AQUMARINE_ORE =
        registerSmeltAbleBlock(
            "deepslate_aqumarine_ore",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val DEEPSLATE_IMPERIUM_ORE =
        registerSmeltAbleBlock(
            "deepslate_imperium_ore",
            ItemInit.IMPERIUM,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                .requiresCorrectToolForDrops(),
            MinableBlockType.IRON_PICKAXE)

    // blocks
    val RUBY_BLOCK =
        registerOreBlock(
            "ruby_block",
            ItemInit.RUBY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops(),
            MinableBlockType.IRON_PICKAXE)

    val RAINBOW_BLOCK =
        registerOreBlock(
            "rainbow_block",
            ItemInit.RAINBOW,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val SAPPHIRE_BLOCK =
        registerOreBlock(
            "sapphire_block",
            ItemInit.SAPPHIRE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops(),
            MinableBlockType.GOLD_PICKAXE)

    val GRAPHITE_BLOCK =
        registerOreBlock(
            "graphite_block",
            ItemInit.GRAPHITE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    val AQUMARINE_BLOCK =
        registerOreBlock(
            "aqumarine_block",
            ItemInit.AQUMARINE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    @JvmField
    val ENDERITE_BLOCK =
        registerOreBlock(
            "enderite_block",
            ItemInit.ENDERITE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                .requiresCorrectToolForDrops(),
            MinableBlockType.DIAMOND_PICKAXE)

    // logs
    val ENDERITE_LOG = registerSpecial("enderite_log", ::EnderiteLog, MinableBlockType.WOODEN_AXE)

    // planks
    val ENDERITE_PLANKS =
        registerSpecial("enderite_planks", ::EnderitePlanks, MinableBlockType.WOODEN_AXE)

    // saplings
    val ENDERITE_SAPLING =
        registerSpecial(
            "enderite_sapling",
            {
                SaplingBlock(
                    TreeGrower(
                        "enderite_sapling",
                        0.1f,
                        Optional.empty<ResourceKey<ConfiguredFeature<*, *>>>(),
                        Optional.empty<ResourceKey<ConfiguredFeature<*, *>>>(),
                        Optional.of(ModConfiguredFeatures.ENDERITE_SAPLING),
                        Optional.empty<ResourceKey<ConfiguredFeature<*, *>>>(),
                        Optional.empty<ResourceKey<ConfiguredFeature<*, *>>>(),
                        Optional.empty<ResourceKey<ConfiguredFeature<*, *>>>()),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING))
            },
            MinableBlockType.WOODEN_AXE)

    // custom recipe tables
    val CUSTOM_ARMOUR_CRAFTING_TABLE =
        registerSpecial("custom_armour_crafting_table", ::CustomArmourCraftingTable)

    val CUSTOM_TOOL_CRAFTING_TABLE =
        registerSpecial("custom_tool_crafting_table", ::CustomToolCraftingTable)

    @JvmField
    val INGOT_FUSION_TOLL_ENHANCER =
        registerSpecial("ingot_fusion_toll_enhancer", ::IngotFusionTollEnhancer)

    @JvmField
    val ENDERITE_PORTAL_FRAME = registerSpecial("enderite_portal_frame", ::EnderitePortalFrame)

    private fun <T : Block> registerSpecial(
        name: String,
        supplier: () -> T,
        minableTool: MinableBlockType = MinableBlockType.STONE_PICKAXE,
    ): DeferredBlock<T> {
        val blockReg = BLOCKS.register(name, supplier)
        ItemInit.ITEMS.register(name) { -> BlockItem(blockReg.get(), Item.Properties()) }
        checkTypeOfMinableBlock(blockReg as DeferredBlock<Block>, minableTool)
        return blockReg
    }

    private fun registerSpecialSmeltAbleBlock(
        name: String,
        associatedOreIngot: DeferredItem<Item>,
        minableTool: MinableBlockType,
        supplier: () -> Block
    ): DeferredBlock<Block> {

        val blockReg = BLOCKS.register(name, supplier)
        ItemInit.ITEMS.register(name) { -> BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot
        checkTypeOfMinableBlock(blockReg, minableTool)

        return blockReg
    }

    private fun registerOreBlock(
        name: String,
        associatedOreIngot: DeferredItem<Item>,
        property: BlockBehaviour.Properties,
        minableTool: MinableBlockType
    ): DeferredBlock<Block> {

        val blockReg = BLOCKS.register(name) { -> Block(property) }

        ItemInit.ITEMS.register(name) { -> BlockItem(blockReg.get(), Item.Properties()) }

        ORE_BLOCKS[blockReg] = associatedOreIngot
        checkTypeOfMinableBlock(blockReg, minableTool)

        return blockReg
    }

    private fun registerSmeltAbleBlock(
        name: String,
        associatedOreIngot: DeferredItem<Item>,
        property: BlockBehaviour.Properties,
        minableTool: MinableBlockType
    ): DeferredBlock<Block> {

        val blockReg = BLOCKS.register(name) { -> Block(property) }
        ItemInit.ITEMS.register(name) { -> BlockItem(blockReg.get(), Item.Properties()) }

        SMELT_ABLE_BLOCKS[blockReg] = associatedOreIngot
        checkTypeOfMinableBlock(blockReg, minableTool)

        return blockReg
    }

    private fun checkTypeOfMinableBlock(block: DeferredBlock<Block>, type: MinableBlockType) {
        when (type) {
            MinableBlockType.STONE_PICKAXE -> MINABLE_STONE_PICKAXE_BLOCKS.add(block)
            MinableBlockType.IRON_PICKAXE -> MINABLE_IRON_PICKAXE_BLOCKS.add(block)
            MinableBlockType.GOLD_PICKAXE -> MINABLE_GOLD_PICKAXE_BLOCKS.add(block)
            MinableBlockType.DIAMOND_PICKAXE -> MINABLE_DIAMOND_PICKAXE_BLOCKS.add(block)
            MinableBlockType.NETHERITE_PICKAXE -> MINABLE_NETHERITE_PICKAXE_BLOCKS.add(block)
            MinableBlockType.WOODEN_AXE -> MINABLE_WOODEN_AXE_BLOCKS.add(block)
        }
    }
}
