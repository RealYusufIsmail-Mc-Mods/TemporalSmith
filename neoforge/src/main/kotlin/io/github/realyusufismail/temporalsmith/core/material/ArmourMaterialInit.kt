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
package io.github.realyusufismail.temporalsmith.core.material

import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import java.util.function.Supplier
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Items.AMETHYST_SHARD
import net.minecraft.world.item.crafting.Ingredient

enum class ArmourMaterialInit(
    private val oreName: String,
    private val durabilityMultiplier: Int,
    private val armorVal: IntArray,
    private val equipSound: SoundEvent,
    private val toghness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Supplier<Ingredient>,
) : ArmorMaterial {
    AMETHYST(
        "amethyst",
        11,
        intArrayOf(4, 7, 9, 4),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.2f,
        0.2f,
        Supplier { Ingredient.of(AMETHYST_SHARD) }),
    RUBY(
        "ruby",
        8,
        intArrayOf(2, 5, 6, 2),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.0f,
        0.0f,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    SAPPHIRE(
        "sapphire",
        9,
        intArrayOf(3, 6, 7, 3),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.1f,
        0.1f,
        Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    GRAPHITE(
        "graphite",
        10,
        intArrayOf(3, 6, 8, 3),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.1f,
        0.1f,
        Supplier { Ingredient.of(ItemInit.GRAPHITE.get()) }),
    AQUMARINE(
        "aqumarine",
        12,
        intArrayOf(4, 7, 9, 4),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.3f,
        0.3f,
        Supplier { Ingredient.of(ItemInit.AQUMARINE.get()) }),
    RAINBOW(
        "rainbow",
        100,
        intArrayOf(5, 8, 10, 5),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.4f,
        0.4f,
        Supplier { Ingredient.of(ItemInit.RAINBOW.get()) }),
    ENDERITE(
        "enderite",
        50,
        intArrayOf(5, 8, 10, 5),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.4f,
        0.4f,
        Supplier { Ingredient.of(ItemInit.ENDERITE.get()) });

    override fun getDurabilityForType(type: ArmorItem.Type): Int {
        return durabilityMultiplier * armorVal[type.ordinal]
    }

    override fun getDefenseForType(type: ArmorItem.Type): Int {
        return armorVal[type.ordinal]
    }

    override fun getEnchantmentValue(): Int {
        return 7
    }

    override fun getEquipSound(): SoundEvent {
        return equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

    override fun getName(): String {
        return oreName
    }

    override fun getToughness(): Float {
        return toghness
    }

    override fun getKnockbackResistance(): Float {
        return knockbackResistance
    }
}
