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
import net.minecraftforge.registries.RegistryObject

object ItemInit {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID)

    // ore ingots
    val AMETHYST: RegistryObject<Item> = ITEMS.register("amethyst") { Item(Item.Properties()) }
    val RUBY: RegistryObject<Item> = ITEMS.register("ruby") { Item(Item.Properties()) }
    val SAPPHIRE: RegistryObject<Item> = ITEMS.register("sapphire") { Item(Item.Properties()) }
    val GRAPHITE: RegistryObject<Item> = ITEMS.register("graphite") { Item(Item.Properties()) }
    val AQUMARINE: RegistryObject<Item> = ITEMS.register("aqumarine") { Item(Item.Properties()) }
    val RAINBOW: RegistryObject<Item> = ITEMS.register("rainbow") { Item(Item.Properties()) }

    // armour
    val AMETHYST_HELMET: RegistryObject<Item> =
        ITEMS.register("amethyst_helmet") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.HEAD, Item.Properties())
        }

    val AMETHYST_CHESTPLATE: RegistryObject<Item> =
        ITEMS.register("amethyst_chestplate") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.CHEST, Item.Properties())
        }

    val AMETHYST_LEGGINGS: RegistryObject<Item> =
        ITEMS.register("amethyst_leggings") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.LEGS, Item.Properties())
        }

    val AMETHYST_BOOTS: RegistryObject<Item> =
        ITEMS.register("amethyst_boots") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.FEET, Item.Properties())
        }

    val RUBY_HELMET: RegistryObject<Item> =
        ITEMS.register("ruby_helmet") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.HEAD, Item.Properties())
        }

    val RUBY_CHESTPLATE: RegistryObject<Item> =
        ITEMS.register("ruby_chestplate") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.CHEST, Item.Properties())
        }

    val RUBY_LEGGINGS: RegistryObject<Item> =
        ITEMS.register("ruby_leggings") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.LEGS, Item.Properties())
        }

    val RUBY_BOOTS: RegistryObject<Item> =
        ITEMS.register("ruby_boots") {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlot.FEET, Item.Properties())
        }

    val SAPPHIRE_HELMET: RegistryObject<Item> =
        ITEMS.register("sapphire_helmet") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.HEAD, Item.Properties())
        }

    val SAPPHIRE_CHESTPLATE: RegistryObject<Item> =
        ITEMS.register("sapphire_chestplate") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.CHEST, Item.Properties())
        }
    val SAPPHIRE_LEGGINGS: RegistryObject<Item> =
        ITEMS.register("sapphire_leggings") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.LEGS, Item.Properties())
        }

    val SAPPHIRE_BOOTS: RegistryObject<Item> =
        ITEMS.register("sapphire_boots") {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.FEET, Item.Properties())
        }
    val GRAPHITE_HELMET: RegistryObject<Item> =
        ITEMS.register("graphite_helmet") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.HEAD, Item.Properties())
        }

    val GRAPHITE_CHESTPLATE: RegistryObject<Item> =
        ITEMS.register("graphite_chestplate") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.CHEST, Item.Properties())
        }

    val GRAPHITE_LEGGINGS: RegistryObject<Item> =
        ITEMS.register("graphite_leggings") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.LEGS, Item.Properties())
        }

    val GRAPHITE_BOOTS: RegistryObject<Item> =
        ITEMS.register("graphite_boots") {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.FEET, Item.Properties())
        }

    val AQUMARINE_HELMET: RegistryObject<Item> =
        ITEMS.register("aqumarine_helmet") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.HEAD, Item.Properties())
        }

    val AQUMARINE_CHESTPLATE: RegistryObject<Item> =
        ITEMS.register("aqumarine_chestplate") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.CHEST, Item.Properties())
        }

    val AQUMARINE_LEGGINGS: RegistryObject<Item> =
        ITEMS.register("aqumarine_leggings") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.LEGS, Item.Properties())
        }

    val AQUMARINE_BOOTS: RegistryObject<Item> =
        ITEMS.register("aqumarine_boots") {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.FEET, Item.Properties())
        }

    val RAINBOW_HELMET: RegistryObject<Item> =
        ITEMS.register("rainbow_helmet") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.HEAD, Item.Properties())
        }

    val RAINBOW_CHESTPLATE: RegistryObject<Item> =
        ITEMS.register("rainbow_chestplate") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.CHEST, Item.Properties())
        }

    val RAINBOW_LEGGINGS: RegistryObject<Item> =
        ITEMS.register("rainbow_leggings") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.LEGS, Item.Properties())
        }

    val RAINBOW_BOOTS: RegistryObject<Item> =
        ITEMS.register("rainbow_boots") {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlot.FEET, Item.Properties())
        }
}
