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

import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.*
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraftforge.common.capabilities.ForgeCapabilities
import net.minecraftforge.items.SlotItemHandler

/** @see FurnaceMenu */
class IngotFusionTollEnhancerMenu(
    pContainerId: Int,
    private val inventory: Inventory,
    private val blockEntity: BlockEntity,
    private val data: ContainerData,
    private val player: Player = inventory.player,
) : AbstractContainerMenu(MenuTypeInit.INGOT_FUSION_TOLL_ENHANCER_MENU.get(), pContainerId) {
    private var level: Level = inventory.player.level()

    constructor(
        pContainerId: Int,
        inventory: Inventory,
        data: FriendlyByteBuf
    ) : this(
        pContainerId,
        inventory,
        inventory.player.level().getBlockEntity(data.readBlockPos())
            ?: throw IllegalStateException("Block is null"),
        SimpleContainerData(2))

    init {

        try {
            checkContainerSize(inventory, NUMBER_OF_SLOTS)

            addPlayerInventory(inventory)
            addPlayerHotbar(inventory)

            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent { it ->
                addSlot(SlotItemHandler(it, 0, 16, 40))
                addSlot(SlotItemHandler(it, 1, 43, 40))
                addSlot(SlotItemHandler(it, 2, 70, 40))

                addSlot(OutputSlotItemHandler(it))
            }

            addDataSlots(data)
        } catch (e: Exception) {
            throw NullPointerException("Container cannot be null")
        }
    }

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
        return stillValid(
            ContainerLevelAccess.create(level, blockEntity.blockPos),
            player,
            BlockInit.INGOT_FUSION_TOLL_ENHANCER.get())
    }

    fun getLitProgress(): Int {
        val process = data[0]
        val maxTick = data[1]
        return if (maxTick != 0 && process != 0) process * 24 / maxTick else 0
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
}
