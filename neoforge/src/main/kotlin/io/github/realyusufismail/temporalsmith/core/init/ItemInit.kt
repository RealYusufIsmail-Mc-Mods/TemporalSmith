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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.core.armour.*
import io.github.realyusufismail.temporalsmith.core.material.ArmourMaterialInit
import io.github.realyusufismail.temporalsmith.core.material.CustomShieldMaterial
import io.github.realyusufismail.temporalsmith.core.material.CustomToolMaterial
import io.github.realyusufismail.temporalsmith.items.CustomSwordItem
import io.github.realyusufismail.temporalsmith.items.hammer.HammerItem
import io.github.realyusufismail.temporalsmith.items.hammer.Mjolnir
import io.github.realyusufismail.temporalsmith.items.hammer.StormBreaker
import io.github.realyusufismail.temporalsmith.items.hammer.util.HammerLevel
import io.github.realyusufismail.temporalsmith.items.shield.ModShieldItem
import io.github.realyusufismail.temporalsmith.items.sword.EnderiteSword
import io.github.realyusufismail.temporalsmith.items.trident.AqumarineTridentItem
import net.minecraft.world.item.*
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

object ItemInit {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(MOD_ID)
    val SMELT_ABLE_ITEM: MutableMap<DeferredItem<Item>, DeferredItem<Item>> = mutableMapOf()

    // ore ingots
    val RUBY: DeferredItem<Item> = ITEMS.register("ruby") { -> Item(Item.Properties()) }
    val SAPPHIRE: DeferredItem<Item> = ITEMS.register("sapphire") { -> Item(Item.Properties()) }
    val GRAPHITE: DeferredItem<Item> = ITEMS.register("graphite") { -> Item(Item.Properties()) }
    val AQUMARINE: DeferredItem<Item> = ITEMS.register("aqumarine") { -> Item(Item.Properties()) }
    val RAINBOW: DeferredItem<Item> = ITEMS.register("rainbow") { -> Item(Item.Properties()) }
    val ENDERITE: DeferredItem<Item> = ITEMS.register("enderite") { -> Item(Item.Properties()) }
    val IMPERIUM: DeferredItem<Item> = ITEMS.register("imperium") { -> Item(Item.Properties()) }

    // raw ores
    val RAW_RUBY: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("raw_ruby", RUBY) { Item(Item.Properties()) }
    val RAW_SAPPHIRE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("raw_sapphire", SAPPHIRE) { Item(Item.Properties()) }
    val RAW_GRAPHITE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("raw_graphite", GRAPHITE) { Item(Item.Properties()) }
    val RAW_AQUMARINE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("raw_aqumarine", AQUMARINE) { Item(Item.Properties()) }
    val RAW_RAINBOW: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("raw_rainbow", RAINBOW) { Item(Item.Properties()) }
    val RAW_ENDERITE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("raw_enderite", ENDERITE) { Item(Item.Properties()) }
    val RAW_IMPERIUM: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("raw_imperium", IMPERIUM) { Item(Item.Properties()) }

    // armour
    val AMETHYST_HELMET: DeferredItem<Item> =
        ITEMS.register("amethyst_helmet") { ->
            AmethystArmour(ArmourMaterialInit.AMETHYST, ArmorItem.Type.HELMET, Item.Properties())
        }

    val AMETHYST_CHESTPLATE: DeferredItem<Item> =
        ITEMS.register("amethyst_chestplate") { ->
            AmethystArmour(
                ArmourMaterialInit.AMETHYST, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val AMETHYST_LEGGINGS: DeferredItem<Item> =
        ITEMS.register("amethyst_leggings") { ->
            AmethystArmour(ArmourMaterialInit.AMETHYST, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val AMETHYST_BOOTS: DeferredItem<Item> =
        ITEMS.register("amethyst_boots") { ->
            AmethystArmour(ArmourMaterialInit.AMETHYST, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val RUBY_HELMET: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_helmet", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.HELMET, Item.Properties())
        }

    val RUBY_CHESTPLATE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_chestplate", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val RUBY_LEGGINGS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_leggings", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val RUBY_BOOTS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_boots", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val SAPPHIRE_HELMET: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_helmet", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.HELMET, Item.Properties())
        }

    val SAPPHIRE_CHESTPLATE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_chestplate", SAPPHIRE) {
            SapphireArmour(
                ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val SAPPHIRE_LEGGINGS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_leggings", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val SAPPHIRE_BOOTS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_boots", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val GRAPHITE_HELMET: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("graphite_helmet", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, ArmorItem.Type.HELMET, Item.Properties())
        }

    val GRAPHITE_CHESTPLATE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("graphite_chestplate", GRAPHITE) {
            GraphiteArmour(
                ArmourMaterialInit.GRAPHITE, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val GRAPHITE_LEGGINGS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("graphite_leggings", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val GRAPHITE_BOOTS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("graphite_boots", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val AQUMARINE_HELMET: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("aqumarine_helmet", AQUMARINE) {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, ArmorItem.Type.HELMET, Item.Properties())
        }

    val AQUMARINE_CHESTPLATE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("aqumarine_chestplate", AQUMARINE) {
            AqumarineArmour(
                ArmourMaterialInit.AQUMARINE, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val AQUMARINE_LEGGINGS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("aqumarine_leggings", AQUMARINE) {
            AqumarineArmour(
                ArmourMaterialInit.AQUMARINE, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val AQUMARINE_BOOTS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("aqumarine_boots", AQUMARINE) {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val RAINBOW_HELMET: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("rainbow_helmet", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.HELMET, Item.Properties())
        }

    val RAINBOW_CHESTPLATE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("rainbow_chestplate", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val RAINBOW_LEGGINGS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("rainbow_leggings", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val RAINBOW_BOOTS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("rainbow_boots", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, ArmorItem.Type.BOOTS, Item.Properties())
        }

    val ENDERITE_HELMET: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_helmet", ENDERITE) {
            EnderiteArmour(ArmourMaterialInit.ENDERITE, ArmorItem.Type.HELMET, Item.Properties())
        }

    val ENDERITE_CHESTPLATE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_chestplate", ENDERITE) {
            EnderiteArmour(
                ArmourMaterialInit.ENDERITE, ArmorItem.Type.CHESTPLATE, Item.Properties())
        }

    val ENDERITE_LEGGINGS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_leggings", ENDERITE) {
            EnderiteArmour(ArmourMaterialInit.ENDERITE, ArmorItem.Type.LEGGINGS, Item.Properties())
        }

    val ENDERITE_BOOTS: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_boots", ENDERITE) {
            EnderiteArmour(ArmourMaterialInit.ENDERITE, ArmorItem.Type.BOOTS, Item.Properties())
        }

    // Swords
    val RUBY_SWORD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_sword", RUBY) {
            CustomSwordItem(CustomToolMaterial.RUBY_SWORD, 8, -2.6f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_SWORD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_sword", ENDERITE, ::EnderiteSword)

    val AMETHYST_SWORD: DeferredItem<Item> =
        ITEMS.register("amethyst_sword") { ->
            CustomSwordItem(
                CustomToolMaterial.AMETHYST_SWORD, 8, -2.5f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_SWORD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_sword", SAPPHIRE) {
            CustomSwordItem(
                CustomToolMaterial.SAPPHIRE_SWORD, 9, -2.6f, Item.Properties().stacksTo(1))
        }

    val IMPERIUM_SWORD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("imperium_sword", IMPERIUM) {
            CustomSwordItem(
                CustomToolMaterial.IMPERIUM_SWORD, 10, -2.7f, Item.Properties().stacksTo(1))
        }

    // Pickaxes
    val RUBY_PICKAXE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_pickaxe", RUBY) {
            PickaxeItem(CustomToolMaterial.RUBY_PICKAXE, 5, -2.8f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_PICKAXE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_pickaxe", ENDERITE) {
            PickaxeItem(
                CustomToolMaterial.ENDERITE_PICKAXE, 6, -2.7f, Item.Properties().stacksTo(1))
        }

    val AMETHYST_PICKAXE: DeferredItem<Item> =
        ITEMS.register("amethyst_pickaxe") { ->
            PickaxeItem(
                CustomToolMaterial.AMETHYST_PICKAXE, 5, -2.7f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_PICKAXE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_pickaxe", SAPPHIRE) {
            PickaxeItem(
                CustomToolMaterial.SAPPHIRE_PICKAXE, 6, -2.8f, Item.Properties().stacksTo(1))
        }

    val IMPERIUM_PICKAXE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("imperium_pickaxe", IMPERIUM) {
            PickaxeItem(
                CustomToolMaterial.IMPERIUM_PICKAXE, 7, -2.9f, Item.Properties().stacksTo(1))
        }

    val MAGMA_STRIKE_PICKAXE: DeferredItem<Item> =
        ITEMS.register("magma_strike_pickaxe") { ->
            PickaxeItem(
                CustomToolMaterial.MAGMA_STRIKE_PICKAXE, 9, -3.0f, Item.Properties().stacksTo(1))
        }

    // Axes
    val RUBY_AXE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_axe", RUBY) {
            AxeItem(CustomToolMaterial.RUBY_AXE, 8F, -2.6f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_AXE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_axe", ENDERITE) {
            AxeItem(CustomToolMaterial.ENDERITE_AXE, 9F, -2.5f, Item.Properties().stacksTo(1))
        }

    val AMETHYST_AXE: DeferredItem<Item> =
        ITEMS.register("amethyst_axe") { ->
            AxeItem(CustomToolMaterial.AMETHYST_AXE, 7.5F, -2.5f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_AXE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_axe", SAPPHIRE) {
            AxeItem(CustomToolMaterial.SAPPHIRE_AXE, 8.5F, -2.6f, Item.Properties().stacksTo(1))
        }

    // Shovels
    val RUBY_SHOVEL: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_shovel", RUBY) {
            ShovelItem(CustomToolMaterial.RUBY_SHOVEL, 3.5F, -3.0f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_SHOVEL: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_shovel", ENDERITE) {
            ShovelItem(
                CustomToolMaterial.ENDERITE_SHOVEL, 4.5F, -3.0f, Item.Properties().stacksTo(1))
        }

    val AMETHYST_SHOVEL: DeferredItem<Item> =
        ITEMS.register("amethyst_shovel") { ->
            ShovelItem(
                CustomToolMaterial.AMETHYST_SHOVEL, 3.5F, -3.0f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_SHOVEL: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_shovel", SAPPHIRE) {
            ShovelItem(
                CustomToolMaterial.SAPPHIRE_SHOVEL, 4.5F, -3.5f, Item.Properties().stacksTo(1))
        }

    // Hoes
    val RUBY_HOE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_hoe", RUBY) {
            HoeItem(CustomToolMaterial.RUBY_HOE, 1, -3.1f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_HOE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("enderite_hoe", ENDERITE) {
            HoeItem(CustomToolMaterial.ENDERITE_HOE, 2, -3.0f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_HOE: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_hoe", SAPPHIRE) {
            HoeItem(CustomToolMaterial.SAPPHIRE_HOE, 2, -3.1f, Item.Properties().stacksTo(1))
        }

    // Hammers

    val DRAGON_DESTROYER: DeferredItem<Item> =
        ITEMS.register("dragon_destroyer") { ->
            HammerItem(CustomToolMaterial.DRAGON_DESTROYER, -3.6f, 10F, HammerLevel.LEGENDARY)
        }

    val MJOLNIR: DeferredItem<Item> = ITEMS.register("mjolnir") { -> Mjolnir() }

    val STORMBREAKER: DeferredItem<Item> = ITEMS.register("stormbreaker") { -> StormBreaker() }

    // Tridents
    val AQUMARINE_TRIDENT: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("aqumarine_trident", AQUMARINE) { AqumarineTridentItem() }

    // Shields
    val RUBY_SHIELD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("ruby_shield", RUBY) {
            ModShieldItem(410, CustomShieldMaterial.RUBY_SHIELD)
        }

    val SAPPHIRE_SHIELD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("sapphire_shield", SAPPHIRE) {
            ModShieldItem(420, CustomShieldMaterial.SAPPHIRE_SHIELD)
        }

    val GRAPHITE_SHIELD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("graphite_shield", GRAPHITE) {
            ModShieldItem(400, CustomShieldMaterial.GRAPHITE_SHIELD)
        }

    val AQUMARINE_SHIELD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("aqumarine_shield", AQUMARINE) {
            ModShieldItem(450, CustomShieldMaterial.AQUMARINE_SHIELD)
        }

    val RAINBOW_SHIELD: DeferredItem<Item> =
        ITEMS.registerSmeltableObject("rainbow_shield", RAINBOW) {
            ModShieldItem(430, CustomShieldMaterial.RAINBOW_SHIELD)
        }

    private fun DeferredRegister.Items.registerSmeltableObject(
        name: String,
        associatedOreIngot: DeferredItem<Item>,
        supplier: () -> Item
    ): DeferredItem<Item> {
        val registryObject = this.register(name, supplier)

        SMELT_ABLE_ITEM[registryObject] = associatedOreIngot
        // note that this anonymous class inherits three types
        return registryObject
    }
}
