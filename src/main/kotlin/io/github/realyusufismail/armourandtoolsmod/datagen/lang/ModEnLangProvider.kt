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
package io.github.realyusufismail.armourandtoolsmod.datagen.lang

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.realyusufismailcore.data.support.lang.ModEnLangProviderSupport
import net.minecraft.data.DataGenerator
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.RegistryObject

class ModEnLangProvider(gen: DataGenerator) : ModEnLangProviderSupport(gen, MOD_ID, "en_us") {

    override fun addTranslations() {
        // ores
        addBlock(BlockInit.RUBY_ORE, "Ruby Ore")
        addBlock(BlockInit.SAPPHIRE_ORE, "Sapphire Ore")
        addBlock(BlockInit.GRAPHITE_ORE, "Graphite Ore")
        addBlock(BlockInit.RAINBOW_ORE, "Rainbow Ore")
        addBlock(BlockInit.AQUMARINE_ORE, "Aqumarine Ore")
        addBlock(BlockInit.ENDERITE_ORE, "Enderite Ore")

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

        // custom crafting tables
        addBlock(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE, "Custom Armour Crafting Table")
        addBlock(BlockInit.CUSTOM_TOOL_CRAFTING_TABLE, "Custom Tool Crafting Table")

        // ore ingot
        addItem(ItemInit.RUBY, "Ruby")
        addItem(ItemInit.SAPPHIRE, "Sapphire")
        addItem(ItemInit.GRAPHITE, "Graphite")
        addItem(ItemInit.RAINBOW, "Rainbow Ingot")
        addItem(ItemInit.AQUMARINE, "Aqumarine")
        addItem(ItemInit.ENDERITE, "Enderite")

        // raw ores
        addItem(ItemInit.RAW_RUBY, "Raw Ruby")
        addItem(ItemInit.RAW_SAPPHIRE, "Raw Sapphire")
        addItem(ItemInit.RAW_GRAPHITE, "Raw Graphite")
        addItem(ItemInit.RAW_RAINBOW, "Raw Rainbow")
        addItem(ItemInit.RAW_AQUMARINE, "Raw Aqumarine")
        addItem(ItemInit.RAW_ENDERITE, "Raw Enderite")

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

        // Shields
        addItem(ItemInit.RUBY_SHIELD, "Ruby Shield")
        addItem(ItemInit.SAPPHIRE_SHIELD, "Sapphire Shield")
        addItem(ItemInit.GRAPHITE_SHIELD, "Graphite Shield")
        addItem(ItemInit.RAINBOW_SHIELD, "Rainbow Shield")
        addItem(ItemInit.AQUMARINE_SHIELD, "Aqumarine Shield")

        // Trident
        addItem(ItemInit.AQUMARINE_TRIDENT, "Aqumarine Trident")

        // others
        add("creativetab.armourandtoolsmod", "Armour and Item Mod")
        add("container.custom_armour_crafting_table", "Armour Crafting Table")
        add("container.custom_armour_crafting_table.description", "Craft your own custom armour!")
        add("container.custom_tool_crafting_table", "Tool Crafting Table")
        add("container.custom_tool_crafting_table.description", "Craft your own custom tools!")
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
}
