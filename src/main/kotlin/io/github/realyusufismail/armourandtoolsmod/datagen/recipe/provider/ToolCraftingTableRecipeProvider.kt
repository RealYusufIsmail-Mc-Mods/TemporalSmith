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
package io.github.realyusufismail.armourandtoolsmod.datagen.recipe.provider

import io.github.realyusufismail.armourandtoolsmod.blocks.tool.book.CustomToolsCraftingBookCategory
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.init.TagsInit
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.MainModRecipeProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.builder.CustomToolCraftingTableRecipeBuilder
import java.util.function.Consumer
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.world.item.Items

class ToolCraftingTableRecipeProvider(
    private val mainModRecipeProvider: MainModRecipeProvider,
    private val consumer: Consumer<FinishedRecipe>,
) : MainModRecipeProvider(mainModRecipeProvider) {
    private val hasItem = "has_item"

    fun build() {

        // RUBY TOOLS
        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SWORD,
                RecipeCategory.TOOLS,
                ItemInit.RUBY_SWORD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_sword"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.PICKAXE,
                RecipeCategory.TOOLS,
                ItemInit.RUBY_PICKAXE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .define('S', Items.STICK)
            .pattern("AAA")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_pickaxe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.AXE, RecipeCategory.TOOLS, ItemInit.RUBY_AXE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .define('S', Items.STICK)
            .pattern(" AA")
            .pattern(" SA")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_axe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHOVEL,
                RecipeCategory.TOOLS,
                ItemInit.RUBY_SHOVEL.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_shovel"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.HOE, RecipeCategory.TOOLS, ItemInit.RUBY_HOE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .define('S', Items.STICK)
            .pattern("AA ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_hoe"))

        // SAPPHIRE TOOLS

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SWORD,
                RecipeCategory.TOOLS,
                ItemInit.SAPPHIRE_SWORD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_sword"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.PICKAXE,
                RecipeCategory.TOOLS,
                ItemInit.SAPPHIRE_PICKAXE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .define('S', Items.STICK)
            .pattern("AAA")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_pickaxe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.AXE,
                RecipeCategory.TOOLS,
                ItemInit.SAPPHIRE_AXE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .define('S', Items.STICK)
            .pattern(" AA")
            .pattern(" SA")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_axe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHOVEL,
                RecipeCategory.TOOLS,
                ItemInit.SAPPHIRE_SHOVEL.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_shovel"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.HOE,
                RecipeCategory.TOOLS,
                ItemInit.SAPPHIRE_HOE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .define('S', Items.STICK)
            .pattern("AA ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_hoe"))

        // ENDERITE TOOLS
        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SWORD,
                RecipeCategory.TOOLS,
                ItemInit.ENDERITE_SWORD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_sword"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.PICKAXE,
                RecipeCategory.TOOLS,
                ItemInit.ENDERITE_PICKAXE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .define('S', Items.STICK)
            .pattern("AAA")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_pickaxe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.AXE,
                RecipeCategory.TOOLS,
                ItemInit.ENDERITE_AXE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .define('S', Items.STICK)
            .pattern(" AA")
            .pattern(" SA")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_axe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHOVEL,
                RecipeCategory.TOOLS,
                ItemInit.ENDERITE_SHOVEL.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_shovel"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.HOE,
                RecipeCategory.TOOLS,
                ItemInit.ENDERITE_HOE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .define('S', Items.STICK)
            .pattern("AA ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_hoe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SWORD,
                RecipeCategory.TOOLS,
                ItemInit.AMETHYST_SWORD.get())
            .define('A', Items.AMETHYST_SHARD)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_sword"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.PICKAXE,
                RecipeCategory.TOOLS,
                ItemInit.AMETHYST_PICKAXE.get())
            .define('A', Items.AMETHYST_SHARD)
            .define('S', Items.STICK)
            .pattern("AAA")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_pickaxe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.AXE,
                RecipeCategory.TOOLS,
                ItemInit.AMETHYST_AXE.get())
            .define('A', Items.AMETHYST_SHARD)
            .define('S', Items.STICK)
            .pattern(" AA")
            .pattern(" SA")
            .pattern(" S ")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_axe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHOVEL,
                RecipeCategory.TOOLS,
                ItemInit.AMETHYST_SHOVEL.get())
            .define('A', Items.AMETHYST_SHARD)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_shovel"))

        // Imperium Tools

        // TODO: Add support for enchantments
        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SWORD,
                RecipeCategory.TOOLS,
                ItemInit.IMPERIUM_SWORD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_IMPERIUM)
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_IMPERIUM))
            .save(consumer, modId("imperium_sword"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.PICKAXE,
                RecipeCategory.TOOLS,
                ItemInit.IMPERIUM_PICKAXE.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_IMPERIUM)
            .define('S', Items.STICK)
            .pattern("AAA")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_IMPERIUM))
            .save(consumer, modId("imperium_pickaxe"))

        // TRIEDENTs

        // TODO : For the trident later make it a drop from a custom mob rather than crafting
        // SHIELDS
        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.RUBY_SHIELD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.SAPPHIRE_SHIELD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.GRAPHITE_SHIELD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_GRAPHITE)
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_GRAPHITE))
            .save(consumer, modId("graphite_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.AQUMARINE_SHIELD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("aqumarine_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.RAINBOW_SHIELD.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_RAINBOW)
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RAINBOW))
            .save(consumer, modId("rainbow_shield"))

        // TODO: In the future make it drop of a future custom mob
        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.TRIDENT,
                RecipeCategory.TOOLS,
                ItemInit.AQUMARINE_TRIDENT.get())
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .define('S', Items.STICK)
            .pattern(" AA")
            .pattern(" SA")
            .pattern(" S ")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("aqumarine_trident"))
    }
}
