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
package io.github.realyusufismail.armourandtoolsmod.items.hammer

import io.github.realyusufismail.armourandtoolsmod.client.ArmourAndToolsModTridentItemRendererProvider
import io.github.realyusufismail.armourandtoolsmod.common.entity.ArmourToolsModTridentEntity
import io.github.realyusufismail.armourandtoolsmod.common.entity.MjolnirEntity
import io.github.realyusufismail.armourandtoolsmod.core.init.MobEffectsInit
import io.github.realyusufismail.armourandtoolsmod.core.material.CustomToolMaterial
import io.github.realyusufismail.armourandtoolsmod.items.trident.ArmourToolsModTridentItem
import java.util.function.Consumer
import net.minecraft.world.Containers
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Tier
import net.minecraft.world.level.Level
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions

open class Mjolnir(
    tier: Tier = CustomToolMaterial.MJOLNIR,
    val properties: Properties = Properties().stacksTo(1),
    pAttackSpeedModifier: Float = 15.0f,
    pAttackDamageModifier: Float = -3f
) : ArmourToolsModTridentItem(tier, properties, pAttackSpeedModifier, pAttackDamageModifier) {
    override fun onUseTick(
        pLevel: Level,
        pLivingEntity: LivingEntity,
        pStack: ItemStack,
        pRemainingUseDuration: Int
    ) {
        val currentPotionEffect = pLivingEntity.activeEffectsMap

        // check if has the worthy potion effect
        val hasWorthyEffect = currentPotionEffect.containsKey(MobEffectsInit.WORTHY_EFFECT.get())
        if (!hasWorthyEffect) {
            Containers.dropItemStack(
                pLevel, pLivingEntity.x, pLivingEntity.y, pLivingEntity.z, pStack)
        }
    }

    override fun inventoryTick(
        pStack: ItemStack,
        pLevel: Level,
        pEntity: Entity,
        pSlotId: Int,
        pIsSelected: Boolean
    ) {
        if (pEntity is Player) {
            pEntity.abilities.mayfly = true
            pEntity.abilities.flyingSpeed = 0.06f
            pEntity.abilities.invulnerable = true
        }
    }

    override fun getThrownEntity(
        world: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ): ArmourToolsModTridentEntity {
        return MjolnirEntity(world, thrower, stack)
    }

    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(ArmourAndToolsModTridentItemRendererProvider.mjolnir())
    }
}
