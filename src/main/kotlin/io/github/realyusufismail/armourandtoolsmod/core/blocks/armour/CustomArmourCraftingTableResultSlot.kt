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
package io.github.realyusufismail.armourandtoolsmod.core.blocks.armour

import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit
import net.minecraft.world.Container
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.RecipeHolder
import net.minecraft.world.inventory.Slot
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.ForgeHooks
import net.minecraftforge.event.ForgeEventFactory

/** @see net.minecraft.world.inventory.ResultSlot */
class CustomArmourCraftingTableResultSlot(
    private val player: Player,
    private val craftSlots: CustomArmourCraftingTableContainer,
    container: Container,
    slot: Int,
    xPosition: Int,
    yPosition: Int
) : Slot(container, slot, xPosition, yPosition) {
    private var removeCount = 0

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as
     * furnace fuel.
     */
    override fun mayPlace(pStack: ItemStack): Boolean {
        return false
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg.
     * Returns the new stack.
     */
    override fun remove(pAmount: Int): ItemStack {
        if (hasItem()) {
            this.removeCount += pAmount.coerceAtMost(this.item.count)
        }
        return super.remove(pAmount)
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     * Typically increases an internal count then calls onCrafting(item).
     */
    override fun onQuickCraft(pStack: ItemStack, pAmount: Int) {
        this.removeCount += pAmount
        checkTakeAchievements(pStack)
    }

    override fun onSwapCraft(pNumItemsCrafted: Int) {
        this.removeCount += pNumItemsCrafted
    }

    /** the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. */
    override fun checkTakeAchievements(pStack: ItemStack) {
        if (this.removeCount > 0) {
            pStack.onCraftedBy(this.player.level, this.player, this.removeCount)
            ForgeEventFactory.firePlayerCraftingEvent(this.player, pStack, this.craftSlots)
        }
        if (container is RecipeHolder) {
            (container as RecipeHolder).awardUsedRecipes(this.player)
        }
        this.removeCount = 0
    }

    override fun onTake(pPlayer: Player, pStack: ItemStack) {
        checkTakeAchievements(pStack)
        ForgeHooks.setCraftingPlayer(pPlayer)
        val nonnulllist =
            pPlayer.level.recipeManager.getRemainingItemsFor(
                RecipeTypeInit.ARMOUR_CRAFTING.get(), this.craftSlots, pPlayer.level)
        ForgeHooks.setCraftingPlayer(null)
        for (i in nonnulllist.indices) {
            var itemstack: ItemStack = this.craftSlots.getItem(i)
            val itemstack1 = nonnulllist[i]
            if (!itemstack.isEmpty) {
                this.craftSlots.removeItem(i, 1)
                itemstack = this.craftSlots.getItem(i)
            }
            if (!itemstack1.isEmpty) {
                if (itemstack.isEmpty) {
                    this.craftSlots.setItem(i, itemstack1)
                } else if (ItemStack.isSame(itemstack, itemstack1) &&
                    ItemStack.tagMatches(itemstack, itemstack1)) {
                    itemstack1.grow(itemstack.count)
                    this.craftSlots.setItem(i, itemstack1)
                } else if (!this.player.inventory.add(itemstack1)) {
                    this.player.drop(itemstack1, false)
                }
            }
        }
    }
}
