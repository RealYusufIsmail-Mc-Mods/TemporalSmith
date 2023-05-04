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
import io.github.realyusufismail.armourandtoolsmod.core.material.CustomToolMaterial
import net.minecraft.world.item.*
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

object ItemInit {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID)
    val SMELT_ABLE_ITEM: MutableMap<ObjectHolderDelegate<Item>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

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
        ITEMS.registerSmeltableObject("raw_ruby", RUBY) { Item(Item.Properties()) }
    val RAW_SAPPHIRE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_sapphire", SAPPHIRE) { Item(Item.Properties()) }
    val RAW_GRAPHITE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_graphite", GRAPHITE) { Item(Item.Properties()) }
    val RAW_AQUMARINE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_aqumarine", AQUMARINE) { Item(Item.Properties()) }
    val RAW_RAINBOW: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_rainbow", RAINBOW) { Item(Item.Properties()) }

    // armour
    val AMETHYST_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_helmet") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, ArmorItem.Type.HELMET, Item.Properties())
        }

    val AMETHYST_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_chestplate") {
            AmethystArmour(
                ArmourMaterialInit.AMETHYST, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val AMETHYST_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_leggings") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val AMETHYST_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("amethyst_boots") {
            AmethystArmour(ArmourMaterialInit.AMETHYST, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val RUBY_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_helmet", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.HELMET, Item.Properties())
        }

    val RUBY_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_chestplate", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val RUBY_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_leggings", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val RUBY_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_boots", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val SAPPHIRE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_helmet", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.HELMET, Item.Properties())
        }

    val SAPPHIRE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_chestplate", SAPPHIRE) {
            SapphireArmour(
                ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val SAPPHIRE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_leggings", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val SAPPHIRE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_boots", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val GRAPHITE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_helmet", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, ArmorItem.Type.HELMET, Item.Properties())
        }

    val GRAPHITE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_chestplate", GRAPHITE) {
            GraphiteArmour(
                ArmourMaterialInit.GRAPHITE, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val GRAPHITE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_leggings", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val GRAPHITE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_boots", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val AQUMARINE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_helmet", AQUMARINE) {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, ArmorItem.Type.HELMET, Item.Properties())
        }

    val AQUMARINE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_chestplate", AQUMARINE) {
            AqumarineArmour(
                ArmourMaterialInit.AQUMARINE, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val AQUMARINE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_leggings", AQUMARINE) {
            AqumarineArmour(
                ArmourMaterialInit.AQUMARINE, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val AQUMARINE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_boots", AQUMARINE) {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val RAINBOW_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_helmet", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.HELMET, Item.Properties())
        }

    val RAINBOW_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_chestplate", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val RAINBOW_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_leggings", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val RAINBOW_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_boots", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.BOOTS, Item.Properties())
        }

    // TODO: Add tools and weapons including tridents. Maybe custom shields?

    // Swords
    val RUBY_SWORD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_sword", RUBY) {
            SwordItem(
                CustomToolMaterial.RUBY_SWORD, 0, 7f, Item.Properties().stacksTo(1).durability(600))
        }

    // Pickaxes
    val RUBY_PICKAXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_pickaxe", RUBY) {
            PickaxeItem(
                CustomToolMaterial.RUBY_PICKAXE,
                0,
                4f,
                Item.Properties().stacksTo(1).durability(800))
        }

    // Axes
    val RUBY_AXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_axe", RUBY) {
            AxeItem(
                CustomToolMaterial.RUBY_AXE, 0F, 8f, Item.Properties().stacksTo(1).durability(600))
        }

    // Shovels
    val RUBY_SHOVEL: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_shovel", RUBY) {
            ShovelItem(
                CustomToolMaterial.RUBY_SHOVEL,
                0F,
                3f,
                Item.Properties().stacksTo(1).durability(600))
        }

    // Hoes
    val RUBY_HOE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_hoe", RUBY) {
            HoeItem(
                CustomToolMaterial.RUBY_HOE, 0, 3f, Item.Properties().stacksTo(1).durability(600))
        }

    // Tridents
    val AQUMARINE_TRIDENT: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_trident", AQUMARINE) {
            TridentItem(Item.Properties().stacksTo(1).durability(600))
        }

    // Shields
    val RUBY_SHIELD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_shield", RUBY) {
            ShieldItem(Item.Properties().stacksTo(1).durability(600))
        }

    val SAPPHIRE_SHIELD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_shield", SAPPHIRE) {
            ShieldItem(Item.Properties().stacksTo(1).durability(600))
        }

    val GRAPHITE_SHIELD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_shield", GRAPHITE) {
            ShieldItem(Item.Properties().stacksTo(1).durability(600))
        }

    val AQUMARINE_SHIELD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_shield", AQUMARINE) {
            ShieldItem(Item.Properties().stacksTo(1).durability(600))
        }

    val RAINBOW_SHIELD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_shield", RAINBOW) {
            ShieldItem(Item.Properties().stacksTo(1).durability(600))
        }

    private fun DeferredRegister<Item>.registerSmeltableObject(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        supplier: () -> Item,
    ): ObjectHolderDelegate<Item> {
        val registryObject = this.register(name, supplier)

        val o = ObjectHolderDelegate(registryObject)

        SMELT_ABLE_ITEM[o] = associatedOreIngot
        // note that this anonymous class inherits three types
        return o
    }
}
