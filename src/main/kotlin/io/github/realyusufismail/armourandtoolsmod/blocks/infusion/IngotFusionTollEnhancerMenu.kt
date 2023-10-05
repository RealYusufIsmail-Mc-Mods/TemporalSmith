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
package io.github.realyusufismail.armourandtoolsmod.blocks.infusion

import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerBlockEntity.NUMBER_OF_SLOTS
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots.InfusionFuelSlot
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots.OutputSlotItemHandler
import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeBookTypesInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.Container
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.player.StackedContents
import net.minecraft.world.inventory.*
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity
import net.minecraftforge.common.ForgeHooks
import net.minecraftforge.common.capabilities.ForgeCapabilities
import net.minecraftforge.items.SlotItemHandler

/**
 * @see net.minecraft.stats.RecipeBookSettings
 * @see FurnaceMenu
 */
class IngotFusionTollEnhancerMenu(
    pContainerId: Int,
    private val blockEntity: BaseContainerBlockEntity,
    private val data: ContainerData,
    pInventory: Inventory
) : RecipeBookMenu<Container>(MenuTypeInit.INGOT_FUSION_TOLL_ENHANCER_MENU.get(), pContainerId) {
    private val recipeType =
        RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.registryObject.orElseThrow {
            IllegalStateException("Recipe type is null")
        }
    private val recipeBook = RecipeBookTypesInit.INGOT_FUSION
    private val level: Level

    constructor(
        pContainerId: Int,
        inventory: Inventory,
        data: FriendlyByteBuf
    ) : this(pContainerId, getBlockEntity(inventory, data), SimpleContainerData(4), inventory)

    init {
        level = pInventory.player.level() ?: throw IllegalStateException("Level is null")

        checkContainerSize(blockEntity, NUMBER_OF_SLOTS)
        checkContainerDataCount(data, 4)

        addPlayerInventory(pInventory)
        addPlayerHotbar(pInventory)

        blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent { it ->
            // slots to place ingredients
            addSlot(SlotItemHandler(it, 0, 16, 40))
            addSlot(SlotItemHandler(it, 1, 43, 40))
            addSlot(SlotItemHandler(it, 2, 70, 40))

            // slot to place fuel
            addSlot(InfusionFuelSlot(it, this))

            // slot to place result
            addSlot(OutputSlotItemHandler(it))
        }
    }

    /**
     * Handle when the stack in slot `index` is shift-clicked. Normally this moves the stack between
     * the player inventory and the other inventory(s).
     */
    override fun quickMoveStack(pPlayer: Player, index: Int): ItemStack {
        var itemstack = ItemStack.EMPTY
        val slot = slots[index]
        if (slot.hasItem()) {
            val stack1 = slot.item
            itemstack = stack1.copy()
            if (index < NUMBER_OF_SLOTS &&
                !moveItemStackTo(stack1, NUMBER_OF_SLOTS, slots.size, true)) {
                return ItemStack.EMPTY
            }
            if (!moveItemStackTo(stack1, 0, NUMBER_OF_SLOTS, false)) {
                return ItemStack.EMPTY
            }
            if (stack1.isEmpty) {
                slot.set(ItemStack.EMPTY)
            } else {
                slot.setChanged()
            }
        }
        return itemstack
    }

    /** Determines whether supplied player can use this container */
    override fun stillValid(pPlayer: Player): Boolean {
        return blockEntity.stillValid(pPlayer)
    }

    override fun fillCraftSlotsStackedContents(pItemHelper: StackedContents) {
        if (this.blockEntity is StackedContentsCompatible) {
            (this.blockEntity as StackedContentsCompatible).fillStackedContents(pItemHelper)
        }
    }

    override fun clearCraftingContent() {

        // Ingredient slots
        this.getSlot(0).set(ItemStack.EMPTY)
        this.getSlot(1).set(ItemStack.EMPTY)
        this.getSlot(2).set(ItemStack.EMPTY)

        // Fuel slot
        this.getSlot(3).set(ItemStack.EMPTY)

        // Output slot
        this.getSlot(4).set(ItemStack.EMPTY)
    }

    override fun getResultSlotIndex(): Int {
        return 4
    }

    override fun getGridWidth(): Int {
        return 1
    }

    override fun getGridHeight(): Int {
        return 1
    }

    override fun getSize(): Int {
        return NUMBER_OF_SLOTS
    }

    override fun getRecipeBookType(): RecipeBookType {
        return recipeBook
    }

    override fun shouldMoveToInventory(pSlotIndex: Int): Boolean {
        return pSlotIndex != this.resultSlotIndex
    }

    override fun recipeMatches(pRecipe: Recipe<in Container>): Boolean {
        return pRecipe.matches(this.blockEntity, this.level)
    }

    private fun addPlayerInventory(playerInventory: Inventory) {
        for (row in 0..2) {
            for (col in 0..8) {
                addSlot(
                    Slot(
                        playerInventory,
                        col + row * 9 + 9,
                        8 + col * 18,
                        166 - (4 - row) * 18 - 10 + 13))
            }
        }
    }

    private fun addPlayerHotbar(playerInventory: Inventory) {
        for (col in 0..8) {
            addSlot(Slot(playerInventory, col, 8 + col * 18, 142 + 13))
        }
    }

    fun isFuel(pStack: ItemStack): Boolean {
        return ForgeHooks.getBurnTime(pStack, recipeType) > 0
    }

    fun getLitProgress(): Int {
        var i = data[1]
        if (i == 0) {
            i = 200
        }
        return data[0] * 13 / i
    }

    fun isLit(): Boolean {
        return data[0] > 0
    }

    companion object {
        fun getBlockEntity(inventory: Inventory, data: FriendlyByteBuf): BaseContainerBlockEntity {
            val blockEntity = inventory.player.level().getBlockEntity(data.readBlockPos())
            if (blockEntity is BaseContainerBlockEntity) {
                return blockEntity
            } else {
                throw IllegalStateException("Block entity is not correct")
            }
        }
    }
}
