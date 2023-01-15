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
package io.github.realyusufismail.armourandtoolsmod.core.init

import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.core.armour.*
import io.github.realyusufismail.armourandtoolsmod.core.material.ArmourMaterialInit
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

object ItemInit {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID)

    // ore ingots
    val RUBY: ObjectHolderDelegate<Item> = ITEMS.registerObject("ruby") { Item(Item.Properties()) }
    val SAPPHIRE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("sapphire") { Item(Item.Properties()) }
    val GRAPHITE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("graphite") { Item(Item.Properties()) }
    val AQUMARINE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("aqumarine") { Item(Item.Properties()) }
    val RAINBOW: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("rainbow") { Item(Item.Properties()) }

    // raw ores
    val RAW_RUBY: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("raw_ruby") { Item(Item.Properties()) }
    val RAW_SAPPHIRE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("raw_sapphire") { Item(Item.Properties()) }
    val RAW_GRAPHITE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("raw_graphite") { Item(Item.Properties()) }
    val RAW_AQUMARINE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("raw_aqumarine") { Item(Item.Properties()) }
    val RAW_RAINBOW: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("raw_rainbow") { Item(Item.Properties()) }

    // armour
    val AMETHYST_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_helmet") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.HEAD, Item.Properties())
        }

    val AMETHYST_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_chestplate") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.CHEST, Item.Properties())
        }

    val AMETHYST_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_leggings") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.LEGS, Item.Properties())
        }

    val AMETHYST_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_boots") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.FEET, Item.Properties())
        }

    val RUBY_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("ruby_helmet") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.HEAD, Item.Properties())
        }

    val RUBY_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("ruby_chestplate") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.CHEST, Item.Properties())
        }

    val RUBY_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("ruby_leggings") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.LEGS, Item.Properties())
        }

    val RUBY_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("ruby_boots") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.FEET, Item.Properties())
        }

    val SAPPHIRE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("sapphire_helmet") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.HEAD, Item.Properties())
        }

    val SAPPHIRE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("sapphire_chestplate") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.CHEST, Item.Properties())
        }
    val SAPPHIRE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("sapphire_leggings") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.LEGS, Item.Properties())
        }

    val SAPPHIRE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("sapphire_boots") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.FEET, Item.Properties())
        }
    val GRAPHITE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("graphite_helmet") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.HEAD, Item.Properties())
        }

    val GRAPHITE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("graphite_chestplate") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.CHEST, Item.Properties())
        }

    val GRAPHITE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("graphite_leggings") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.LEGS, Item.Properties())
        }

    val GRAPHITE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("graphite_boots") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.FEET, Item.Properties())
        }

    val AQUMARINE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("aqumarine_helmet") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.HEAD, Item.Properties())
        }

    val AQUMARINE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("aqumarine_chestplate") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.CHEST, Item.Properties())
        }

    val AQUMARINE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("aqumarine_leggings") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.LEGS, Item.Properties())
        }

    val AQUMARINE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("aqumarine_boots") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.FEET, Item.Properties())
        }

    val RAINBOW_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("rainbow_helmet") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.HEAD, Item.Properties())
        }

    val RAINBOW_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("rainbow_chestplate") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.CHEST, Item.Properties())
        }

    val RAINBOW_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("rainbow_leggings") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.LEGS, Item.Properties())
        }

    val RAINBOW_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("rainbow_boots") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.FEET, Item.Properties())
        }

    // TODO: Add tools and weapons including tridents. Maybe custom shields?
}
