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

import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.Container
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.player.StackedContents
import net.minecraft.world.inventory.*
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.level.block.entity.BlockEntity

/**
 * @see net.minecraft.stats.RecipeBookSettings
 * @see FurnaceMenu
 */
class IngotFusionTollEnhancerMenu(
    pContainerId: Int,
    private val blockEntity: BlockEntity,
    private val data: ContainerData,
    pInventory: Inventory
) : RecipeBookMenu<Container>(MenuTypeInit.INGOT_FUSION_TOLL_ENHANCER_MENU.get(), pContainerId) {

    constructor(
        pContainerId: Int,
        inventory: Inventory,
        data: FriendlyByteBuf
    ) : this(
        pContainerId,
        inventory.player.level().getBlockEntity(data.readBlockPos())
            ?: throw IllegalStateException("Block is null"),
        SimpleContainerData(2),
        inventory)

    /**
     * Handle when the stack in slot `index` is shift-clicked. Normally this moves the stack between
     * the player inventory and the other inventory(s).
     */
    override fun quickMoveStack(pPlayer: Player, pIndex: Int): ItemStack {
        TODO("Not yet implemented")
    }

    /** Determines whether supplied player can use this container */
    override fun stillValid(pPlayer: Player): Boolean {
        TODO("Not yet implemented")
    }

    override fun fillCraftSlotsStackedContents(pItemHelper: StackedContents) {
        TODO("Not yet implemented")
    }

    override fun clearCraftingContent() {
        TODO("Not yet implemented")
    }

    override fun getResultSlotIndex(): Int {
        TODO("Not yet implemented")
    }

    override fun getGridWidth(): Int {
        TODO("Not yet implemented")
    }

    override fun getGridHeight(): Int {
        TODO("Not yet implemented")
    }

    override fun getSize(): Int {
        TODO("Not yet implemented")
    }

    override fun getRecipeBookType(): RecipeBookType {
        TODO("Not yet implemented")
    }

    override fun shouldMoveToInventory(pSlotIndex: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun recipeMatches(pRecipe: Recipe<in Container>): Boolean {
        TODO("Not yet implemented")
    }
}
