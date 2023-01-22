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

import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeBookTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit
import java.util.*
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.Container
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.player.StackedContents
import net.minecraft.world.inventory.*
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.level.Level

class CustomArmourCraftingTableMenu(
    pContainerId: Int,
    private val inventory: Inventory,
    private val access: ContainerLevelAccess,
    private val player: Player = inventory.player
) :
    RecipeBookMenu<CustomArmourCraftingTableContainer>(
        MenuTypeInit.CustomArmourCraftingTableMenuType.get(), pContainerId) {
    private val craftSlots: CustomArmourCraftingTableContainer =
        CustomArmourCraftingTableContainer(this, 3, 3)
    private val resultSlots = ResultContainer()

    constructor(
        pContainerId: Int,
        inventory: Inventory
    ) : this(pContainerId, inventory, ContainerLevelAccess.NULL)

    init {
        addSlot(
            CustomArmourCraftingTableResultSlot(
                inventory.player, craftSlots, resultSlots, 0, 124, 35))

        for (i in 0..2) {
            for (j in 0..2) {
                addSlot(Slot(craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18))
            }
        }

        for (k in 0..2) {
            for (i1 in 0..8) {
                addSlot(Slot(inventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18))
            }
        }

        for (l in 0..8) {
            addSlot(Slot(inventory, l, 8 + l * 18, 142))
        }
    }

    protected fun slotChangedCraftingGrid(
        p_150547_: AbstractContainerMenu,
        p_150548_: Level,
        p_150549_: Player,
        p_150550_: CustomArmourCraftingTableContainer,
        p_150551_: ResultContainer,
    ) {
        if (!p_150548_.isClientSide) {
            val serverplayer = p_150549_ as ServerPlayer
            var itemstack = ItemStack.EMPTY
            val optional: Optional<CustomArmourCraftingTableRecipe> =
                p_150548_.server!!
                    .recipeManager
                    .getRecipeFor(
                        RecipeTypeInit.CustomArmourCraftingTableRecipeType.get(),
                        p_150550_,
                        p_150548_)
            if (optional.isPresent) {
                val craftingrecipe: CustomArmourCraftingTableRecipe = optional.get()
                if (p_150551_.setRecipeUsed(p_150548_, serverplayer, craftingrecipe)) {
                    itemstack = craftingrecipe.assemble(p_150550_)
                }
            }
            p_150551_.setItem(0, itemstack)
            p_150547_.setRemoteSlot(0, itemstack)
            serverplayer.connection.send(
                ClientboundContainerSetSlotPacket(
                    p_150547_.containerId, p_150547_.incrementStateId(), 0, itemstack))
        }
    }

    /** Callback for when the crafting matrix is changed. */
    override fun slotsChanged(pInventory: Container) {
        this.access.execute { p_39386_, p_39387_ ->
            slotChangedCraftingGrid(this, p_39386_, this.player, craftSlots, resultSlots)
        }
    }

    override fun fillCraftSlotsStackedContents(pItemHelper: StackedContents) {
        craftSlots.fillStackedContents(pItemHelper)
    }

    override fun clearCraftingContent() {
        craftSlots.clearContent()
        resultSlots.clearContent()
    }

    override fun recipeMatches(pRecipe: Recipe<in CustomArmourCraftingTableContainer>): Boolean {
        return pRecipe.matches(craftSlots, this.player.level)
    }

    /** Called when the container is closed. */
    override fun removed(pPlayer: Player) {
        super.removed(pPlayer)
        this.access.execute { p_39371_, p_39372_ -> clearContainer(pPlayer, craftSlots) }
    }

    /** Determines whether supplied player can use this container */
    override fun stillValid(pPlayer: Player): Boolean {
        return stillValid(this.access, pPlayer, BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get())
    }

    /**
     * Handle when the stack in slot `index` is shift-clicked. Normally this moves the stack between
     * the player inventory and the other inventory(s).
     */
    override fun quickMoveStack(pPlayer: Player, pIndex: Int): ItemStack {
        var itemstack = ItemStack.EMPTY
        val slot = slots[pIndex]
        if (slot.hasItem()) {
            val itemstack1 = slot.item
            itemstack = itemstack1.copy()
            if (pIndex == 0) {
                this.access.execute { p_39378_, p_39379_ ->
                    itemstack1.item.onCraftedBy(itemstack1, p_39378_, pPlayer)
                }
                if (!moveItemStackTo(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY
                }
                slot.onQuickCraft(itemstack1, itemstack)
            } else if (pIndex in 10..45) {
                if (!moveItemStackTo(itemstack1, 1, 10, false)) {
                    if (pIndex < 37) {
                        if (!moveItemStackTo(itemstack1, 37, 46, false)) {
                            return ItemStack.EMPTY
                        }
                    } else if (!moveItemStackTo(itemstack1, 10, 37, false)) {
                        return ItemStack.EMPTY
                    }
                }
            } else if (!moveItemStackTo(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY
            }
            if (itemstack1.isEmpty) {
                slot.set(ItemStack.EMPTY)
            } else {
                slot.setChanged()
            }
            if (itemstack1.count == itemstack.count) {
                return ItemStack.EMPTY
            }
            slot.onTake(pPlayer, itemstack1)
            if (pIndex == 0) {
                pPlayer.drop(itemstack1, false)
            }
        }
        return itemstack
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code.
     * The stack passed in is null for the initial slot that was double-clicked.
     */
    override fun canTakeItemForPickAll(pStack: ItemStack, pSlot: Slot): Boolean {
        return pSlot.container !== resultSlots && super.canTakeItemForPickAll(pStack, pSlot)
    }

    override fun getResultSlotIndex(): Int {
        return 0
    }

    override fun getGridWidth(): Int {
        return craftSlots.getWidth()
    }

    override fun getGridHeight(): Int {
        return craftSlots.getHeight()
    }

    override fun getSize(): Int {
        return 10
    }

    override fun getRecipeBookType(): RecipeBookType {
        return RecipeBookTypeInit.ARMOUR_CRAFTING
    }

    override fun shouldMoveToInventory(pSlotIndex: Int): Boolean {
        return pSlotIndex != this.resultSlotIndex
    }
}
