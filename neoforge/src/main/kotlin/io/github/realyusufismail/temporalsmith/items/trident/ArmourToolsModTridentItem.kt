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
package io.github.realyusufismail.temporalsmith.items.trident

import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import io.github.realyusufismail.temporalsmith.common.entity.ModTridentEntity
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.stats.Stats
import net.minecraft.util.Mth
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.MoverType
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.AbstractArrow
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Tier
import net.minecraft.world.item.TridentItem
import net.minecraft.world.item.UseAnim
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.Vec3

/** @see TridentItem */
abstract class ArmourToolsModTridentItem(
    tier: Tier,
    properties: Properties = Properties().stacksTo(1),
    pAttackDamageModifier: Float,
    pAttackSpeedModifier: Float,
) : TridentItem(properties.defaultDurability(tier.uses)) {
    private var attributeModifiers: Multimap<Attribute, AttributeModifier> = ImmutableMultimap.of()
    private val attackDamage: Float

    init {
        val builder = ImmutableMultimap.builder<Attribute, AttributeModifier>()
        attackDamage = pAttackDamageModifier + tier.attackDamageBonus

        builder.put(
            Attributes.ATTACK_DAMAGE,
            AttributeModifier(
                BASE_ATTACK_DAMAGE_UUID,
                "Tool modifier",
                attackDamage.toDouble(),
                AttributeModifier.Operation.ADDITION))
        builder.put(
            Attributes.ATTACK_SPEED,
            AttributeModifier(
                BASE_ATTACK_SPEED_UUID,
                "Tool modifier",
                pAttackSpeedModifier.toDouble(),
                AttributeModifier.Operation.ADDITION))
        this.attributeModifiers = builder.build()
    }

    protected abstract fun getThrownEntity(
        world: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ): ModTridentEntity

    /** Returns the action that specifies what animation to play when the item is being used. */
    override fun getUseAnimation(pStack: ItemStack): UseAnim {
        return UseAnim.SPEAR
    }

    /** How long it takes to use or consume an item */
    override fun getUseDuration(pStack: ItemStack): Int {
        return 72000
    }

    /** Called when the player stops using an Item (stops holding the right mouse button). */
    override fun releaseUsing(
        pStack: ItemStack,
        pLevel: Level,
        pEntityLiving: LivingEntity,
        pTimeLeft: Int
    ) {
        if (pEntityLiving is Player) {
            val i = getUseDuration(pStack) - pTimeLeft
            if (i >= 10) {
                val j = EnchantmentHelper.getRiptide(pStack)
                if (j <= 0 || pEntityLiving.isInWaterOrRain()) {
                    if (!pLevel.isClientSide) {
                        pStack.hurtAndBreak(1, pEntityLiving) { p_43388_: Player ->
                            p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand())
                        }
                        if (j == 0) {
                            val thrownTrident = getThrownEntity(pLevel, pEntityLiving, pStack)
                            thrownTrident.shootFromRotation(
                                pEntityLiving,
                                pEntityLiving.xRot,
                                pEntityLiving.yRot,
                                0.0f,
                                2.5f + j.toFloat() * 0.5f,
                                1.0f)
                            if (pEntityLiving.abilities.instabuild) {
                                thrownTrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY
                            }
                            pLevel.addFreshEntity(thrownTrident)
                            pLevel.playSound(
                                null,
                                thrownTrident,
                                SoundEvents.TRIDENT_THROW,
                                SoundSource.PLAYERS,
                                1.0f,
                                1.0f)
                            if (!pEntityLiving.abilities.instabuild) {
                                pEntityLiving.inventory.removeItem(pStack)
                            }
                        }
                    }
                    pEntityLiving.awardStat(Stats.ITEM_USED[this])
                    if (j > 0) {
                        val f7 = pEntityLiving.yRot
                        val f = pEntityLiving.xRot
                        var f1 =
                            -Mth.sin(f7 * (Math.PI.toFloat() / 180f)) *
                                Mth.cos(f * (Math.PI.toFloat() / 180f))
                        var f2 = -Mth.sin(f * (Math.PI.toFloat() / 180f))
                        var f3 =
                            Mth.cos(f7 * (Math.PI.toFloat() / 180f)) *
                                Mth.cos(f * (Math.PI.toFloat() / 180f))
                        val f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3)
                        val f5 = 3.0f * ((1.0f + j.toFloat()) / 4.0f)
                        f1 *= f5 / f4
                        f2 *= f5 / f4
                        f3 *= f5 / f4
                        pEntityLiving.push(f1.toDouble(), f2.toDouble(), f3.toDouble())
                        pEntityLiving.startAutoSpinAttack(20)
                        if (pEntityLiving.onGround()) {
                            val f6 = 1.1999999f
                            pEntityLiving.move(MoverType.SELF, Vec3(0.0, f6.toDouble(), 0.0))
                        }
                        val soundEvent: SoundEvent =
                            if (j >= 3) {
                                SoundEvents.TRIDENT_RIPTIDE_3
                            } else if (j == 2) {
                                SoundEvents.TRIDENT_RIPTIDE_2
                            } else {
                                SoundEvents.TRIDENT_RIPTIDE_1
                            }
                        pLevel.playSound(
                            null, pEntityLiving, soundEvent, SoundSource.PLAYERS, 1.0f, 1.0f)
                    }
                }
            }
        }
    }

    override fun use(
        p_43405_: Level,
        p_43406_: Player,
        p_43407_: InteractionHand
    ): InteractionResultHolder<ItemStack> {
        val itemstack = p_43406_.getItemInHand(p_43407_)
        return if (itemstack.damageValue >= itemstack.maxDamage - 1) {
            InteractionResultHolder.fail(itemstack)
        } else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !p_43406_.isInWaterOrRain) {
            InteractionResultHolder.fail(itemstack)
        } else {
            p_43406_.startUsingItem(p_43407_)
            InteractionResultHolder.consume(itemstack)
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
        pStack.hurtAndBreak(1, pAttacker) { p_43414_: LivingEntity ->
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND)
        }
        return true
    }

    /**
     * Called when a [net.minecraft.world.level.block.Block] is destroyed using this Item. Return
     * `true` to trigger the "Use Item" statistic.
     */
    override fun mineBlock(
        pStack: ItemStack,
        pLevel: Level,
        pState: BlockState,
        pPos: BlockPos,
        pEntityLiving: LivingEntity
    ): Boolean {
        if (pState.getDestroySpeed(pLevel, pPos).toDouble() != 0.0) {
            pStack.hurtAndBreak(2, pEntityLiving) { p_43385_: LivingEntity ->
                p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND)
            }
        }
        return true
    }

    /** Gets a map of item attribute modifiers, used by ItemSword to increase hit damage. */
    @Deprecated("Deprecated in Java")
    override fun getDefaultAttributeModifiers(
        pEquipmentSlot: EquipmentSlot
    ): Multimap<Attribute, AttributeModifier> {
        return if (pEquipmentSlot == EquipmentSlot.MAINHAND) attributeModifiers
        else super.getDefaultAttributeModifiers(pEquipmentSlot)
    }

    /** Return the enchantability factor of the item, most of the time is based on material. */
    @Deprecated("Deprecated in Java", ReplaceWith("1"))
    override fun getEnchantmentValue(): Int {
        return 1
    }
}
