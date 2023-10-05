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
package io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots

import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerBlockEntity
import kotlin.math.min
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.ForgeEventFactory
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.SlotItemHandler

class OutputSlotItemHandler(itemHandler: IItemHandler, val player: Player) :
    SlotItemHandler(itemHandler, 4, 138, 40) {
    private var removeCount: Int? = null

    override fun mayPlace(stack: ItemStack): Boolean {
        return false
    }

    override fun remove(pAmount: Int): ItemStack {
        if (hasItem()) {
            this.removeCount = min(pAmount, this.item.count)
        }
        return super.remove(pAmount)
    }

    override fun onTake(pPlayer: Player, pStack: ItemStack) {
        checkTakeAchievements(pStack)
        super.onTake(pPlayer, pStack)
    }

    /** @param pStack the output - ie, iron ingots, and pickaxes, not ore and wood. */
    override fun checkTakeAchievements(pStack: ItemStack) {
        pStack.onCraftedBy(this.player.level(), this.player, removeCount ?: 0)
        val player: Player = this.player
        if (player is ServerPlayer) {
            val container = container
            (container as? IngotFusionTollEnhancerBlockEntity)?.awardUsedRecipesAndPopExperience(
                player)
        }
        removeCount = 0
        ForgeEventFactory.firePlayerSmeltedEvent(player, pStack)
    }
}
