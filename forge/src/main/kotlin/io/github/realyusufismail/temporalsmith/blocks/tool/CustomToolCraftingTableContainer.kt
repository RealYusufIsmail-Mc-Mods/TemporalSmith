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
package io.github.realyusufismail.temporalsmith.blocks.tool

import net.minecraft.core.NonNullList
import net.minecraft.world.Container
import net.minecraft.world.ContainerHelper
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.player.StackedContents
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.StackedContentsCompatible
import net.minecraft.world.item.ItemStack

/** @see net.minecraft.world.inventory.CraftingContainer */
class CustomToolCraftingTableContainer(
    private var menu: AbstractContainerMenu,
    private var width: Int,
    private var height: Int
) : Container, StackedContentsCompatible {
    private var items: NonNullList<ItemStack> =
        NonNullList.withSize(width * height, ItemStack.EMPTY)

    /** Returns the number of slots in the inventory. */
    override fun getContainerSize(): Int {
        return items.size
    }

    override fun isEmpty(): Boolean {
        for (itemstack in items) {
            if (!itemstack.isEmpty) {
                return false
            }
        }
        return true
    }

    /** Returns the stack in the given slot. */
    override fun getItem(pIndex: Int): ItemStack {
        return if (pIndex >= this.containerSize) ItemStack.EMPTY else items[pIndex]
    }

    /** Removes a stack from the given slot and returns it. */
    override fun removeItemNoUpdate(pIndex: Int): ItemStack {
        return ContainerHelper.takeItem(items, pIndex)
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new
     * stack.
     */
    override fun removeItem(pIndex: Int, pCount: Int): ItemStack {
        val itemstack = ContainerHelper.removeItem(items, pIndex, pCount)
        if (!itemstack.isEmpty) {
            menu.slotsChanged(this)
        }
        return itemstack
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor
     * sections).
     */
    override fun setItem(pIndex: Int, pStack: ItemStack) {
        items[pIndex] = pStack
        menu.slotsChanged(this)
    }

    override fun setChanged() {
        menu.slotsChanged(this)
    }

    /** Don't rename this method to canInteractWith due to conflicts with Container */
    override fun stillValid(pPlayer: Player): Boolean {
        return true
    }

    override fun clearContent() {
        items.clear()
    }

    /** Returns the height of the crafting inventory. */
    fun getHeight(): Int {
        return height
    }

    /** Returns the width of the crafting inventory. */
    fun getWidth(): Int {
        return width
    }

    override fun fillStackedContents(pHelper: StackedContents) {
        for (itemstack in items) {
            pHelper.accountSimpleStack(itemstack)
        }
    }
}
