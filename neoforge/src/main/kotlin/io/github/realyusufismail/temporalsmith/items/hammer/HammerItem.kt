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
package io.github.realyusufismail.temporalsmith.items.hammer

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import io.github.realyusufismail.temporalsmith.items.hammer.util.HammerLevel
import net.minecraft.core.BlockPos
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.*
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.common.ToolAction
import net.neoforged.neoforge.common.ToolActions

/** @see SwordItem */
open class HammerItem(
    tier: Tier,
    pAttackSpeedModifier: Float,
    pAttackDamageModifier: Float,
    private val hammerLevel: HammerLevel
) : TieredItem(tier, Item.Properties().stacksTo(1)), Vanishable {
    private val blocks: TagKey<Block> = BlockTags.MINEABLE_WITH_PICKAXE
    private val attackDamageBaseline: Float
    private val defaultModifiers: Multimap<Attribute, AttributeModifier>

    init {
        attackDamageBaseline = pAttackDamageModifier + tier.attackDamageBonus
        defaultModifiers = HashMultimap.create()
        defaultModifiers.put(
            Attributes.ATTACK_DAMAGE,
            AttributeModifier(
                BASE_ATTACK_DAMAGE_UUID,
                "Hammer modifier",
                attackDamageBaseline.toDouble(),
                AttributeModifier.Operation.ADDITION))
        defaultModifiers.put(
            Attributes.ATTACK_SPEED,
            AttributeModifier(
                BASE_ATTACK_SPEED_UUID,
                "Hammer modifier",
                pAttackSpeedModifier.toDouble(),
                AttributeModifier.Operation.ADDITION))
    }

    override fun canAttackBlock(
        pState: BlockState,
        pLevel: Level,
        pPos: BlockPos,
        pPlayer: Player
    ): Boolean {
        return !pPlayer.isCreative
    }

    override fun getDestroySpeed(pStack: ItemStack, pState: BlockState): Float {
        val hammerLevel = this.hammerLevel
        return getDestroySpeed(hammerLevel, pState)
    }

    private fun getDestroySpeed(hammerLevel: HammerLevel, pState: BlockState): Float {
        pState.block
        return if (pState.`is`(Blocks.COBWEB)) {
            15.0f
        } else {
            if (pState.`is`(BlockTags.WOOL)) {
                5.0f
            } else {
                var f = 1.0f
                if (hammerLevel.level >= 3) {
                    f *= 1.5f
                }
                f
            }
        }
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside
     * ev. They just raise the damage on the stack.
     */
    override fun hurtEnemy(
        pStack: ItemStack,
        pTarget: LivingEntity,
        pAttacker: LivingEntity
    ): Boolean {
        pStack.hurtAndBreak(1, pAttacker) { p_43296_: LivingEntity ->
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND)
        }
        return true
    }

    /** Check whether this Item can harvest the given Block */
    @Deprecated("Deprecated in Java", ReplaceWith("true"))
    override fun isCorrectToolForDrops(pBlock: BlockState): Boolean {
        return true
    }

    override fun canPerformAction(stack: ItemStack, toolAction: ToolAction): Boolean {
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) ||
            ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction)
    }
}
