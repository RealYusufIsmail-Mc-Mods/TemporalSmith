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
package io.github.realyusufismail.armourandtoolsmod.core.material

import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import java.util.function.Supplier
import net.minecraft.world.item.Tier
import net.minecraft.world.item.crafting.Ingredient

enum class CustomToolMaterial(
    harvestLevel: Int,
    maxUses: Int,
    efficiency: Float,
    attackDamage: Float,
    enchantability: Int,
    repairMaterial: Supplier<Ingredient?>
) : Tier {
    RUBY_SWORD(3, 2000, 8.0f, 3.0f, 10, Supplier { Ingredient.of(ItemInit.RUBY.get()) });

    private val harvestLevel = 0
    private val maxUses = 0
    private val efficiency = 0f
    private val attackDamage = 0f
    private val enchantability = 0
    private val repairMaterial: Ingredient? = null
    override fun getUses(): Int {
        return maxUses
    }

    override fun getSpeed(): Float {
        return efficiency
    }

    override fun getAttackDamageBonus(): Float {
        return attackDamage
    }

    override fun getLevel(): Int {
        return harvestLevel
    }

    override fun getEnchantmentValue(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient? {
        return repairMaterial
    }
}
