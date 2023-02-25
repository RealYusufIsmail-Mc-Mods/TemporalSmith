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
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Items.*
import net.minecraft.world.item.crafting.Ingredient
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

enum class ArmourMaterialInit(
    private val oreName: String,
    private val durabilityMultiplier: Int,
    private val armorVal: IntArray,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toghness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Supplier<Ingredient>,
) : ArmorMaterial {
    AMETHYST(
        "amethyst",
        11,
        intArrayOf(4, 7, 9, 4),
        15,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.2f,
        0.2f,
        Supplier { Ingredient.of(AMETHYST_SHARD) }),
    RUBY(
        "ruby",
        8,
        intArrayOf(2, 5, 6, 2),
        10,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.0f,
        0.0f,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    SAPPHIRE(
        "sapphire",
        9,
        intArrayOf(3, 6, 7, 3),
        12,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.1f,
        0.1f,
        Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    GRAPHITE(
        "graphite",
        10,
        intArrayOf(3, 6, 8, 3),
        14,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.1f,
        0.1f,
        Supplier { Ingredient.of(ItemInit.GRAPHITE.get()) }),
    AQUMARINE(
        "aqumarine",
        12,
        intArrayOf(4, 7, 9, 4),
        16,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.3f,
        0.3f,
        Supplier { Ingredient.of(ItemInit.AQUMARINE.get()) }),
    RAINBOW(
        "rainbow",
        100,
        intArrayOf(5, 8, 10, 5),
        100,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        0.4f,
        0.4f,
        Supplier { Ingredient.of(ItemInit.RAINBOW.get()) });

    override fun getDurabilityForSlot(slot: EquipmentSlot): Int {
        return armorVal[slot.index]
    }

    override fun getDefenseForSlot(slot: EquipmentSlot): Int {
        return armorVal[slot.index]
    }

    override fun getEnchantmentValue(): Int {
        return enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

    @OnlyIn(Dist.CLIENT)
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
