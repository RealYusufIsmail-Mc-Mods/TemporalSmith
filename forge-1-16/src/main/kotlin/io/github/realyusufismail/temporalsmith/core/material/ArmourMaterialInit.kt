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

import java.util.function.Supplier
import net.minecraft.inventory.EquipmentSlotType
import net.minecraft.item.IArmorMaterial
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.SoundEvent
import net.minecraft.util.SoundEvents

enum class ArmourMaterialInit(
    private val oreName: String,
    private val durabilityMultiplier: Int,
    private val armorVal: IntArray,
    private val equipSound: SoundEvent,
    private val toghness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Supplier<Ingredient>,
) : IArmorMaterial {
    RUBY(
        "ruby",
        8,
        intArrayOf(2, 5, 6, 2),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.0f,
        0.0f,
        Supplier {
            Ingredient.of(io.github.realyusufismail.temporalsmith.core.init.ItemInit.RUBY.get())
        }) {},
    SAPPHIRE(
        "sapphire",
        9,
        intArrayOf(3, 6, 7, 3),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.1f,
        0.1f,
        Supplier {
            Ingredient.of(io.github.realyusufismail.temporalsmith.core.init.ItemInit.SAPPHIRE.get())
        }),
    GRAPHITE(
        "graphite",
        10,
        intArrayOf(3, 6, 8, 3),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.1f,
        0.1f,
        Supplier {
            Ingredient.of(io.github.realyusufismail.temporalsmith.core.init.ItemInit.GRAPHITE.get())
        }),
    AQUMARINE(
        "aqumarine",
        12,
        intArrayOf(4, 7, 9, 4),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.3f,
        0.3f,
        Supplier {
            Ingredient.of(
                io.github.realyusufismail.temporalsmith.core.init.ItemInit.AQUMARINE.get())
        }),
    RAINBOW(
        "rainbow",
        100,
        intArrayOf(5, 8, 10, 5),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.4f,
        0.4f,
        Supplier {
            Ingredient.of(io.github.realyusufismail.temporalsmith.core.init.ItemInit.RAINBOW.get())
        }),
    ENDERITE(
        "enderite",
        50,
        intArrayOf(5, 8, 10, 5),
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.4f,
        0.4f,
        Supplier {
            Ingredient.of(io.github.realyusufismail.temporalsmith.core.init.ItemInit.ENDERITE.get())
        });

    override fun getDurabilityForSlot(p0: EquipmentSlotType): Int {
        return durabilityMultiplier * armorVal[p0.index]
    }

    override fun getDefenseForSlot(p0: EquipmentSlotType): Int {
        return armorVal[p0.index]
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
