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
package io.github.realyusufismail.armourandtoolsmod.blocks.fusion

import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockEntityTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit
import io.github.realyusufismail.armourandtoolsmod.recipe.fusion.IngotFusionTollEnhancerRecipe
import net.minecraft.core.BlockPos
import net.minecraft.core.NonNullList
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.ContainerData
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntityTicker
import net.minecraft.world.level.block.entity.FurnaceBlockEntity
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity
import net.minecraft.world.level.block.state.BlockState

const val NUMBER_OF_SLOTS = 4

/** @see FurnaceBlockEntity */
open class IngotFusionTollEnhancerBlockEntity(pPos: BlockPos, pBlockState: BlockState) :
    RandomizableContainerBlockEntity(
        BlockEntityTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), pPos, pBlockState),
    BlockEntityTicker<IngotFusionTollEnhancerBlockEntity> {
    private val maxTick = 200
    private var currentTick: Int = 0
    private var itemStack: NonNullList<ItemStack> =
        NonNullList.withSize(NUMBER_OF_SLOTS, ItemStack.EMPTY)

    val data: ContainerData =
        object : ContainerData {
            override fun get(pIndex: Int): Int {
                return when (pIndex) {
                    0 -> currentTick
                    1 -> maxTick
                    else ->
                        throw ArrayIndexOutOfBoundsException("ContainerData index out of bounds")
                }
            }

            override fun set(pIndex: Int, pValue: Int) {
                throw UnsupportedOperationException("ContainerData cannot be changed")
            }

            override fun getCount(): Int {
                return 2
            }
        }

    override fun tick(
        pLevel: Level,
        pPos: BlockPos,
        pState: BlockState,
        pBlockEntity: IngotFusionTollEnhancerBlockEntity
    ) {
        try {
            if (!level!!.isClientSide) {
                val input1 = items[0]
                val input2 = items[1]
                val input3 = items[2]
                if (empty(input1) && empty(input2) && empty(input3)) {
                    val recipe: IngotFusionTollEnhancerRecipe =
                        getRecipe() ?: throw NullPointerException("Recipe is null")
                    if (canProcessFromRecipe(recipe)) {
                        currentTick++
                        level!!.setBlock(
                            worldPosition,
                            level!!
                                .getBlockState(worldPosition)
                                .setValue<Boolean, Boolean>(
                                    IngotFusionTollEnhancer.LIT, java.lang.Boolean.TRUE),
                            3)
                        if (currentTick >= maxTick) {
                            processing(recipe)
                            currentTick = 0
                        }
                    } else {
                        level!!.setBlock(
                            worldPosition,
                            level!!
                                .getBlockState(worldPosition)
                                .setValue<Boolean, Boolean>(
                                    IngotFusionTollEnhancer.LIT, java.lang.Boolean.FALSE),
                            3)
                        currentTick = 0
                        setChanged()
                        return
                    }
                } else {
                    level!!.setBlock(
                        worldPosition,
                        level!!
                            .getBlockState(worldPosition)
                            .setValue<Boolean, Boolean>(
                                IngotFusionTollEnhancer.LIT, java.lang.Boolean.FALSE),
                        3)
                    currentTick = 0
                    setChanged()
                    return
                }
            }
            setChanged()
        } catch (e: NullPointerException) {
            throw NullPointerException("Tick failed")
        }
    }

    private fun processing(recipe: IngotFusionTollEnhancerRecipe) {
        if (canProcessFromRecipe(recipe)) {
            val input1 = items[0]
            val input2 = items[1]
            val input3 = items[2]
            val result: ItemStack = recipe.result
            val outputSlot = items[3]
            if (outputSlot.isEmpty) {
                items[3] = result.copy()
            } else if (outputSlot.item === result.item) {
                outputSlot.grow(1)
            }
            input1.shrink(1)
            input2.shrink(1)
            input3.shrink(1)
            setChanged()
        }
    }

    private fun canProcessFromRecipe(recipe: IngotFusionTollEnhancerRecipe): Boolean {
        return if (empty(items[0]) && empty(items[1]) && empty(items[2])) {
            val stack: ItemStack = recipe.result
            if (stack.isEmpty) {
                false
            } else {
                val resultSlot = items[3]
                if (resultSlot.isEmpty) {
                    true
                } else if (!ItemStack.isSameItem(resultSlot, stack)) {
                    false
                } else if (resultSlot.count + stack.count <= 64 &&
                    resultSlot.count + stack.count <= resultSlot.maxStackSize) {
                    true
                } else {
                    resultSlot.count + stack.count <= stack.maxStackSize
                }
            }
        } else false
    }

    fun encodeExtraData(buffer: FriendlyByteBuf) {
        buffer.writeByte(items.size)
        buffer.writeByte(data.count)
    }

    override fun setItems(p_199721_1_: NonNullList<ItemStack>) {
        itemStack = p_199721_1_
    }

    override fun getItems(): NonNullList<ItemStack> {
        return itemStack
    }

    override fun getContainerSize(): Int {
        return NUMBER_OF_SLOTS
    }

    /** Returns the stack in the given slot. */
    override fun getItem(pSlot: Int): ItemStack {
        return items[pSlot]
    }

    private fun empty(stack: ItemStack): Boolean {
        return !stack.isEmpty
    }

    override fun createMenu(pContainerId: Int, pInventory: Inventory): AbstractContainerMenu {
        return IngotFusionTollEnhancerMenu(pContainerId, pInventory, this, data)
    }

    override fun getDefaultName(): Component {
        return IngotFusionTollEnhancer.getContainerTitle()
    }

    private fun getRecipe(): IngotFusionTollEnhancerRecipe? {
        return if (items[0].isEmpty || items[1].isEmpty || items[2].isEmpty) {
            null
        } else {
            level!!
                .recipeManager
                .getRecipeFor(
                    RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(),
                    this,
                    this.level ?: throw NullPointerException("Level is null"))
                .orElse(null) as IngotFusionTollEnhancerRecipe?
        }
    }
}
