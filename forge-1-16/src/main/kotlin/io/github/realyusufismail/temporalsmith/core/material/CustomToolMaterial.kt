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
package io.github.realyusufismail.temporalsmith.core.material

import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import java.util.function.Supplier
import net.minecraft.item.IItemTier
import net.minecraft.item.crafting.Ingredient

enum class CustomToolMaterial(
    private val harvestLevel: Int,
    private val maxUses: Int,
    private val enchantability: Int,
    private val repairMaterial: Supplier<Ingredient>
) : IItemTier {
    RUBY_SWORD(3, 2000, 10, Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_PICKAXE(3, 2500, 10, Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_AXE(3, 2500, 10, Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_SHOVEL(3, 2500, 10, Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_HOE(3, 2500, 10, Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    ENDERITE_SWORD(4, 3000, 15, Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_PICKAXE(4, 3000, 15, Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_AXE(4, 3000, 15, Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_SHOVEL(4, 3000, 15, Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_HOE(4, 3000, 15, Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    SAPPHIRE_SWORD(5, 3000, 12, Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_PICKAXE(5, 3000, 12, Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_AXE(5, 3000, 12, Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_SHOVEL(5, 3000, 12, Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_HOE(5, 3000, 12, Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    IMPERIUM_SWORD(6, 4000, 20, Supplier { Ingredient.of(ItemInit.IMPERIUM.get()) }),
    IMPERIUM_PICKAXE(6, 4000, 20, Supplier { Ingredient.of(ItemInit.IMPERIUM.get()) }),
    MAGMA_STRIKE_PICKAXE(6, 8000, 20, Supplier { Ingredient.of(ItemInit.IMPERIUM.get()) }),
    DRAGON_DESTROYER(7, 10000, 25, Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    MJOLNIR(10, 50000, 0, Supplier { Ingredient.of(ItemInit.GRAPHITE.get()) }),
    STORMBREAKER(10, 50000, 0, Supplier { Ingredient.of(ItemInit.GRAPHITE.get()) }),
    AQUMARINE_TRIDENT(7, 30000, 5, Supplier { Ingredient.of(ItemInit.AQUMARINE.get()) });

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

    @Deprecated("Deprecated in Java", ReplaceWith("harvestLevel"))
    override fun getLevel(): Int {
        return harvestLevel
    }

    override fun getEnchantmentValue(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairMaterial.get()
    }
}
