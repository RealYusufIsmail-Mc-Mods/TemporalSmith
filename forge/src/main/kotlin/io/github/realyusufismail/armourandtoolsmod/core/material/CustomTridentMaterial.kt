/*
 * Copyright 2023 RealYusufIsmail.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
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

enum class CustomTridentMaterial(
    harvestLevel: Int,
    maxUses: Int,
    enchantability: Int,
    repairMaterial: Supplier<Ingredient>
) : Tier {
    AQUMARINE_TRIDENT(0, 500, 2, Supplier { Ingredient.of(ItemInit.AQUMARINE.get()) });

    private val harvestLevel = 0
    private val maxUses = 0
    private val enchantability = 0
    private val repairMaterial: Ingredient? = null
    override fun getUses(): Int {
        return maxUses
    }

    /**
     * The speed which is 4 + this value. 4 is the speed of the fist.
     *
     * @return value is set to 0 as the main speed is set in the item class
     */
    override fun getSpeed(): Float {
        return 0f
    }

    /** @return This is set to 0 as the main attack damage is set in the item class */
    override fun getAttackDamageBonus(): Float {
        return 0f
    }

    @Deprecated("Deprecated in Java")
    override fun getLevel(): Int {
        return harvestLevel
    }

    override fun getEnchantmentValue(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairMaterial ?: Ingredient.EMPTY
    }
}
