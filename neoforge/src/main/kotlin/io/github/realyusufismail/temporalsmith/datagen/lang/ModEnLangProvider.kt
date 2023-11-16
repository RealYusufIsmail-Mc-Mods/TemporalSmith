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
package io.github.realyusufismail.temporalsmith.datagen.lang

import io.github.realyusufismail.realyusufismailcore.data.support.lang.ModEnLangProviderSupport
import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.util.KeyBinding
import net.minecraft.data.DataGenerator
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.RegistryObject

class ModEnLangProvider(gen: DataGenerator) : ModEnLangProviderSupport(gen, MOD_ID, "en_us") {

    override fun addTranslations() {
        // ores
        addBlock(BlockInit.RUBY_ORE, "Ruby Ore")
        addBlock(BlockInit.SAPPHIRE_ORE, "Sapphire Ore")
        addBlock(BlockInit.GRAPHITE_ORE, "Graphite Ore")
        addBlock(BlockInit.RAINBOW_ORE, "Rainbow Ore")
        addBlock(BlockInit.AQUMARINE_ORE, "Aqumarine Ore")
        addBlock(BlockInit.ENDERITE_ORE, "Enderite Ore")
        addBlock(BlockInit.IMPERIUM_ORE, "Imperium Ore")

        // blocks
        addBlock(BlockInit.RUBY_BLOCK, "Ruby Block")
        addBlock(BlockInit.SAPPHIRE_BLOCK, "Sapphire Block")
        addBlock(BlockInit.GRAPHITE_BLOCK, "Graphite Block")
        addBlock(BlockInit.RAINBOW_BLOCK, "Rainbow Block")
        addBlock(BlockInit.AQUMARINE_BLOCK, "Aqumarine Block")
        addBlock(BlockInit.ENDERITE_BLOCK, "Enderite Block")

        // deepslate ores
        addBlock(BlockInit.DEEPSLATE_RUBY_ORE, "Deepslate Ruby Ore")
        addBlock(BlockInit.DEEPSLATE_SAPPHIRE_ORE, "Deepslate Sapphire Ore")
        addBlock(BlockInit.DEEPSLATE_GRAPHITE_ORE, "Deepslate Graphite Ore")
        addBlock(BlockInit.DEEPSLATE_RAINBOW_ORE, "Deepslate Rainbow Ore")
        addBlock(BlockInit.DEEPSLATE_AQUMARINE_ORE, "Deepslate Aqumarine Ore")
        addBlock(BlockInit.DEEPSLATE_IMPERIUM_ORE, "Deepslate Imperium Ore")

        // custom crafting tables
        addBlock(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE, "Custom Armour Crafting Table")
        addBlock(BlockInit.CUSTOM_TOOL_CRAFTING_TABLE, "Custom Tool Crafting Table")
        addBlock(BlockInit.INGOT_FUSION_TOLL_ENHANCER, "Ingot Fusion Toll Enhancer")

        // ore ingot
        addItem(ItemInit.RUBY, "Ruby")
        addItem(ItemInit.SAPPHIRE, "Sapphire")
        addItem(ItemInit.GRAPHITE, "Graphite")
        addItem(ItemInit.RAINBOW, "Rainbow Ingot")
        addItem(ItemInit.AQUMARINE, "Aqumarine")
        addItem(ItemInit.ENDERITE, "Enderite")
        addItem(ItemInit.IMPERIUM, "Imperium")

        // raw ores
        addItem(ItemInit.RAW_RUBY, "Raw Ruby")
        addItem(ItemInit.RAW_SAPPHIRE, "Raw Sapphire")
        addItem(ItemInit.RAW_GRAPHITE, "Raw Graphite")
        addItem(ItemInit.RAW_RAINBOW, "Raw Rainbow")
        addItem(ItemInit.RAW_AQUMARINE, "Raw Aqumarine")
        addItem(ItemInit.RAW_ENDERITE, "Raw Enderite")
        addItem(ItemInit.RAW_IMPERIUM, "Raw Imperium")

        // armor
        addItem(ItemInit.RUBY_HELMET, "Ruby Helmet")
        addItem(ItemInit.RUBY_CHESTPLATE, "Ruby Chestplate")
        addItem(ItemInit.RUBY_LEGGINGS, "Ruby Leggings")
        addItem(ItemInit.RUBY_BOOTS, "Ruby Boots")
        addItem(ItemInit.SAPPHIRE_HELMET, "Sapphire Helmet")
        addItem(ItemInit.SAPPHIRE_CHESTPLATE, "Sapphire Chestplate")
        addItem(ItemInit.SAPPHIRE_LEGGINGS, "Sapphire Leggings")
        addItem(ItemInit.SAPPHIRE_BOOTS, "Sapphire Boots")
        addItem(ItemInit.GRAPHITE_HELMET, "Graphite Helmet")
        addItem(ItemInit.GRAPHITE_CHESTPLATE, "Graphite Chestplate")
        addItem(ItemInit.GRAPHITE_LEGGINGS, "Graphite Leggings")
        addItem(ItemInit.GRAPHITE_BOOTS, "Graphite Boots")
        addItem(ItemInit.RAINBOW_HELMET, "Rainbow Helmet")
        addItem(ItemInit.RAINBOW_CHESTPLATE, "Rainbow Chestplate")
        addItem(ItemInit.RAINBOW_LEGGINGS, "Rainbow Leggings")
        addItem(ItemInit.RAINBOW_BOOTS, "Rainbow Boots")
        addItem(ItemInit.AQUMARINE_HELMET, "Aqumarine Helmet")
        addItem(ItemInit.AQUMARINE_CHESTPLATE, "Aqumarine Chestplate")
        addItem(ItemInit.AQUMARINE_LEGGINGS, "Aqumarine Leggings")
        addItem(ItemInit.AQUMARINE_BOOTS, "Aqumarine Boots")
        addItem(ItemInit.AMETHYST_HELMET, "Amethyst Helmet")
        addItem(ItemInit.AMETHYST_CHESTPLATE, "Amethyst Chestplate")
        addItem(ItemInit.AMETHYST_LEGGINGS, "Amethyst Leggings")
        addItem(ItemInit.AMETHYST_BOOTS, "Amethyst Boots")
        addItem(ItemInit.ENDERITE_HELMET, "Enderite Helmet")
        addItem(ItemInit.ENDERITE_CHESTPLATE, "Enderite Chestplate")
        addItem(ItemInit.ENDERITE_LEGGINGS, "Enderite Leggings")
        addItem(ItemInit.ENDERITE_BOOTS, "Enderite Boots")

        // Tools, Shields, etc.
        addItem(ItemInit.RUBY_SWORD, "Ruby Sword")
        addItem(ItemInit.RUBY_PICKAXE, "Ruby Pickaxe")
        addItem(ItemInit.RUBY_AXE, "Ruby Axe")
        addItem(ItemInit.RUBY_SHOVEL, "Ruby Shovel")
        addItem(ItemInit.RUBY_HOE, "Ruby Hoe")
        addItem(ItemInit.ENDERITE_SWORD, "Enderite Sword")
        addItem(ItemInit.ENDERITE_PICKAXE, "Enderite Pickaxe")
        addItem(ItemInit.ENDERITE_AXE, "Enderite Axe")
        addItem(ItemInit.ENDERITE_SHOVEL, "Enderite Shovel")
        addItem(ItemInit.ENDERITE_HOE, "Enderite Hoe")
        addItem(ItemInit.AMETHYST_SWORD, "Amethyst Sword")
        addItem(ItemInit.AMETHYST_PICKAXE, "Amethyst Pickaxe")
        addItem(ItemInit.AMETHYST_AXE, "Amethyst Axe")
        addItem(ItemInit.AMETHYST_SHOVEL, "Amethyst Shovel")
        addItem(ItemInit.SAPPHIRE_SWORD, "Sapphire Sword")
        addItem(ItemInit.SAPPHIRE_PICKAXE, "Sapphire Pickaxe")
        addItem(ItemInit.SAPPHIRE_AXE, "Sapphire Axe")
        addItem(ItemInit.SAPPHIRE_SHOVEL, "Sapphire Shovel")
        addItem(ItemInit.SAPPHIRE_HOE, "Sapphire Hoe")
        addItem(ItemInit.IMPERIUM_SWORD, "Imperium Sword")
        addItem(ItemInit.IMPERIUM_PICKAXE, "Imperium Pickaxe")
        addItem(ItemInit.MAGMA_STRIKE_PICKAXE, "Magma Strike Pickaxe")
        addItem(ItemInit.DRAGON_DESTROYER, "Dragon Destroyer")
        addItem(ItemInit.MJOLNIR, "Mjölnir")
        addItem(ItemInit.STORMBREAKER, "Stormbreaker")

        // Shields
        addItem(ItemInit.RUBY_SHIELD, "Ruby Shield")
        addItem(ItemInit.SAPPHIRE_SHIELD, "Sapphire Shield")
        addItem(ItemInit.GRAPHITE_SHIELD, "Graphite Shield")
        addItem(ItemInit.RAINBOW_SHIELD, "Rainbow Shield")
        addItem(ItemInit.AQUMARINE_SHIELD, "Aqumarine Shield")

        // Trident
        addItem(ItemInit.AQUMARINE_TRIDENT, "Aqumarine Trident")

        // Potions
        addPotion("worthy_potion", "worthy_effect", "Worthy Potion")

        // others
        add("creativetab.temporalsmith", "Armour and Item Mod")
        add("container.custom_armour_crafting_table", "Armour Crafting Table")
        add("container.custom_armour_crafting_table.description", "Craft your own custom armour!")
        add("container.custom_tool_crafting_table", "Tool Crafting Table")
        add("container.custom_tool_crafting_table.description", "Craft your own custom tools!")
        add("container.ingot_fusion_toll_enhancer", "Ingot Fusion Toll Enhancer")
        add("container.ingot_fusion_toll_enhancer.description", "Enhance your tools and armour!")

        // keybinds
        add(KeyBinding.KEY_CATEGORY_ARMOUR_AND_TOOLS_MOD, "Armour and Item Mod")
        add(KeyBinding.KEY_GET_MJOLNIR, "Get Mjölnir")
        add(KeyBinding.KEY_STRIKE_LIGHTNING, "Strike Lightning")

        // advancements
        addAdvancement(
            "root",
            "Download Armour and Tools Mod",
            "Thanks for downloading Armour and Tools Mod! Enjoy!")

        // Ruby

        addAdvancement(
            "ruby_ore", "That rare crimson ore", "Now smelt the ruby ore to get a ruby ingot!")
        addAdvancement(
            "ruby_ingot",
            "That crimson gem",
            "Now use the ruby ingot to craft ruby armour and tools!")
        addAdvancement(
            "ruby_block",
            "That crimson sparkling block",
            "Well that's a way to show off your wealth!")
        addAdvancement(
            "ruby_armour", "That crimson armour", "Well done! You are now increasing your defence!")
        addAdvancement(
            "ruby_tools", "That crimson tools", "Way to go! You are now increasing your attack!")

        // Sapphire
        addAdvancement(
            "sapphire_ore",
            "That rare blue ore",
            "Now smelt the sapphire ore to get a sapphire ingot!")
        addAdvancement(
            "sapphire_ingot",
            "That blue gem",
            "Now use the sapphire ingot to craft sapphire armour and tools!")
        addAdvancement(
            "sapphire_block",
            "That blue sparkling block",
            "Well that's a way to show off your wealth!")
        addAdvancement(
            "sapphire_armour",
            "That blue armour",
            "Well done! You are now increasing your defence!")
        addAdvancement(
            "sapphire_tools", "That blue tools", "Way to go! You are now increasing your attack!")

        // Graphite
        addAdvancement(
            "graphite_ore",
            "That carbon ore",
            "Now smelt the graphite ore to get a graphite ingot!")
        addAdvancement(
            "graphite_ingot",
            "That carbon gem",
            "Now use the graphite ingot to craft graphite armour and tools!")
        addAdvancement(
            "graphite_block",
            "That carbon sparkling block",
            "Well that's a way to show off your wealth!")
        addAdvancement(
            "graphite_armour",
            "That carbon armour",
            "Well done! You are now increasing your defence!")
        addAdvancement(
            "graphite_tools", "That carbon tools", "Way to go! You are now increasing your attack!")

        // Rainbow
        addAdvancement(
            "rainbow_ore",
            "That rare polychromatic ore",
            "Now smelt the rainbow ore to get a rainbow ingot!")
        addAdvancement(
            "rainbow_ingot",
            "That polychromatic gem",
            "Now use the rainbow ingot to craft rainbow armour and tools!")
        addAdvancement(
            "rainbow_block",
            "That polychromatic sparkling block",
            "Well that's a way to show off your wealth!")
        addAdvancement(
            "rainbow_armour",
            "That polychromatic armour",
            "Well done! You are now increasing your defence!")
        addAdvancement(
            "rainbow_tools",
            "That polychromatic tools",
            "Way to go! You are now increasing your attack!")

        // Aqumarine
        addAdvancement(
            "aqumarine_ore",
            "That rare aqua ore",
            "Now smelt the aqumarine ore to get a aqumarine ingot!")
        addAdvancement(
            "aqumarine_ingot",
            "That aqua gem",
            "Now use the aqumarine ingot to craft aqumarine armour and tools!")
        addAdvancement(
            "aqumarine_block",
            "That aqua sparkling block",
            "Well that's a way to show off your wealth!")
        addAdvancement(
            "aqumarine_armour",
            "That aqua armour",
            "Well done! You are now increasing your defence!")
        addAdvancement(
            "aqumarine_tools", "That aqua tools", "Way to go! You are now increasing your attack!")

        // Enderite
        addAdvancement(
            "enderite_ore",
            "That rare ender ore",
            "Now smelt the enderite ore to get a enderite ingot!")
        addAdvancement(
            "enderite_ingot",
            "That ender gem",
            "Now use the enderite ingot to craft enderite armour and tools!")
        addAdvancement(
            "enderite_block",
            "That ender sparkling block",
            "Well that's a way to show off your wealth!")
        addAdvancement(
            "enderite_armour",
            "That ender armour",
            "Well done! You are now increasing your defence!")
        addAdvancement(
            "enderite_tools", "That ender tools", "Way to go! You are now increasing your attack!")
    }

    override fun <T : Item> item(entry: RegistryObject<T>, name: String) {
        add(entry.get(), name)
    }

    override fun <T : Block> block(entry: RegistryObject<T>, name: String) {
        add(entry.get(), name)
    }

    override fun <T : Entity> entity(key: EntityType<*>, name: String) {
        add(key.descriptionId, name)
    }

    override fun add(translatableComponent: Component, lang: String) {
        super.add(translatableComponent.string, lang)
    }

    private fun addAdvancement(advancement: String, title: String, description: String) {
        add(Component.translatable("advancements.$MOD_ID.$advancement.title"), title)
        add(Component.translatable("advancements.$MOD_ID.$advancement.description"), description)
    }

    private fun addPotion(objectName: String, effectName: String, name: String) {
        add(Component.translatable("effect.$MOD_ID.$effectName"), name)
        add(Component.translatable("item.minecraft.potion.effect.$objectName"), name)
        add(Component.translatable("item.minecraft.splash_potion.effect.$objectName"), name)
        add(Component.translatable("item.minecraft.lingering_potion.effect.$objectName"), name)
        add(Component.translatable("item.minecraft.tipped_arrow.effect.$objectName"), name)
    }
}
