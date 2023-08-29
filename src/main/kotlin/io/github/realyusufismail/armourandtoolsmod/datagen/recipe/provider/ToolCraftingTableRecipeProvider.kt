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
            .define('A', ItemInit.RUBY.get())
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(ItemInit.RUBY.get()))
            .save(consumer, modId("ruby_sword"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.PICKAXE,
                RecipeCategory.TOOLS,
                ItemInit.RUBY_PICKAXE.get())
            .define('A', ItemInit.RUBY.get())
            .define('S', Items.STICK)
            .pattern("AAA")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(ItemInit.RUBY.get()))
            .save(consumer, modId("ruby_pickaxe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.AXE, RecipeCategory.TOOLS, ItemInit.RUBY_AXE.get())
            .define('A', ItemInit.RUBY.get())
            .define('S', Items.STICK)
            .pattern(" AA")
            .pattern(" SA")
            .pattern(" S ")
            .unlockedBy(hasItem, has(ItemInit.RUBY.get()))
            .save(consumer, modId("ruby_axe"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHOVEL,
                RecipeCategory.TOOLS,
                ItemInit.RUBY_SHOVEL.get())
            .define('A', ItemInit.RUBY.get())
            .define('S', Items.STICK)
            .pattern(" A ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(ItemInit.RUBY.get()))
            .save(consumer, modId("ruby_shovel"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.HOE, RecipeCategory.TOOLS, ItemInit.RUBY_HOE.get())
            .define('A', ItemInit.RUBY.get())
            .define('S', Items.STICK)
            .pattern("AA ")
            .pattern(" S ")
            .pattern(" S ")
            .unlockedBy(hasItem, has(ItemInit.RUBY.get()))
            .save(consumer, modId("ruby_hoe"))

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

        // AMETHYST TOOLS
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

        // TRIDENTS
        // TODO : For the trident later make it a drop from a custom mob rather than crafting
        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.TRIDENT,
                RecipeCategory.TOOLS,
                ItemInit.AQUMARINE_TRIDENT.get())
            .define('A', ItemInit.AQUMARINE.get())
            .define('S', Items.STICK)
            .pattern(" AA")
            .pattern(" SA")
            .pattern(" S ")
            .unlockedBy(hasItem, has(ItemInit.AQUMARINE.get()))
            .save(consumer, modId("aqumarine_trident"))

        // SHIELDS
        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.RUBY_SHIELD.get())
            .define('A', ItemInit.RUBY.get())
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(ItemInit.RUBY.get()))
            .save(consumer, modId("ruby_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.SAPPHIRE_SHIELD.get())
            .define('A', ItemInit.SAPPHIRE.get())
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(ItemInit.SAPPHIRE.get()))
            .save(consumer, modId("sapphire_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.GRAPHITE_SHIELD.get())
            .define('A', ItemInit.GRAPHITE.get())
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(ItemInit.GRAPHITE.get()))
            .save(consumer, modId("graphite_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.AQUMARINE_SHIELD.get())
            .define('A', ItemInit.AQUMARINE.get())
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(ItemInit.AQUMARINE.get()))
            .save(consumer, modId("aqumarine_shield"))

        CustomToolCraftingTableRecipeBuilder.shaped(
                CustomToolsCraftingBookCategory.SHIELD,
                RecipeCategory.TOOLS,
                ItemInit.RAINBOW_SHIELD.get())
            .define('A', ItemInit.RAINBOW.get())
            .define('I', Items.IRON_INGOT)
            .define('S', Items.SHIELD)
            .pattern(" A ")
            .pattern("SIS")
            .pattern("SSS")
            .unlockedBy(hasItem, has(ItemInit.RAINBOW.get()))
            .save(consumer, modId("rainbow_shield"))
    }
}
