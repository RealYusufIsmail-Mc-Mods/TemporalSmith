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
package io.github.realyusufismail.temporalsmith.core.armour

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class AqumarineArmour(materialIn: ArmorMaterial, armourType: Type, builder: Properties) :
    ArmorItem(materialIn, armourType, builder) {

    override fun isFoil(stack: ItemStack): Boolean {
        return false
    }

    override fun onArmorTick(stack: ItemStack, world: Level, player: Player) {
        if (player.isInWater) {
            player.addEffect(MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20, 0, false, false))
            player.addEffect(MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0, false, false))
        }
    }
}
