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
package io.github.realyusufismail.temporalsmith.blocks

import io.github.realyusufismail.temporalsmith.blocks.armour.CustomArmourCraftingTableMenu
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.stats.Stats
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.MenuProvider
import net.minecraft.world.SimpleMenuProvider
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.ContainerLevelAccess
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

/**
 * A crafting table to make custom armour.
 *
 * Recipe: one iron block, one crafting table and one stone.
 */
class CustomArmourCraftingTable :
    Block(Properties.of().strength(5.0f, 6.0f).sound(SoundType.METAL)) {
    private val containerDescription: Component =
        Component.translatable("container.custom_armour_crafting_table.description")

    @Deprecated("Deprecated in Java")
    override fun use(
        blockState: BlockState,
        level: Level,
        blockPos: BlockPos,
        player: Player,
        interactionHand: InteractionHand,
        blockHitResult: BlockHitResult,
    ): InteractionResult {
        return if (level.isClientSide) {
            InteractionResult.SUCCESS
        } else {
            player.openMenu(blockState.getMenuProvider(level, blockPos))
            player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE)
            InteractionResult.CONSUME
        }
    }

    @Deprecated("Deprecated in Java")
    override fun getMenuProvider(
        p_52240_: BlockState,
        p_52241_: Level,
        p_52242_: BlockPos,
    ): MenuProvider {
        return SimpleMenuProvider(
            { p_52229_: Int, p_52230_: Inventory, _: Player? ->
                CustomArmourCraftingTableMenu(
                    p_52229_, p_52230_, ContainerLevelAccess.create(p_52241_, p_52242_))
            },
            containerTitle)
    }

    override fun appendHoverText(
        pStack: ItemStack,
        pLevel: BlockGetter?,
        pTooltip: MutableList<Component>,
        pFlag: TooltipFlag
    ) {
        pTooltip.add(containerDescription)
    }

    companion object {
        val containerTitle: Component =
            Component.translatable("container.custom_armour_crafting_table")
    }
}
