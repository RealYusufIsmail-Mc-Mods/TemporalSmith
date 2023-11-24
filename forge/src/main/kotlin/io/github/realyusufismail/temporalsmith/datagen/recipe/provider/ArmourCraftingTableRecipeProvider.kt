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
package io.github.realyusufismail.temporalsmith.datagen.recipe.provider

import io.github.realyusufismail.temporalsmith.blocks.armour.book.CustomArmourCraftingBookCategory
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.core.init.TagsInit
import io.github.realyusufismail.temporalsmith.datagen.recipe.MainModRecipeProvider
import io.github.realyusufismail.temporalsmith.datagen.recipe.builder.CustomArmourCraftingTableRecipeBuilder
import java.util.function.Consumer
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.world.item.Items

class ArmourCraftingTableRecipeProvider(
    private val mainModRecipeProvider: MainModRecipeProvider,
    private val consumer: Consumer<FinishedRecipe>,
) : MainModRecipeProvider(mainModRecipeProvider) {
    private val hasItem = "has_item"

    fun build() {
        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_HEAD,
                RecipeCategory.COMBAT,
                ItemInit.AMETHYST_HELMET)
            .define('A', Items.AMETHYST_SHARD)
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_helmet"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_CHEST,
                RecipeCategory.COMBAT,
                ItemInit.AMETHYST_CHESTPLATE)
            .define('A', Items.AMETHYST_SHARD)
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_chestplate"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_LEGS,
                RecipeCategory.COMBAT,
                ItemInit.AMETHYST_LEGGINGS)
            .define('A', Items.AMETHYST_SHARD)
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_leggings"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_FEET,
                RecipeCategory.COMBAT,
                ItemInit.AMETHYST_BOOTS)
            .define('A', Items.AMETHYST_SHARD)
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(Items.AMETHYST_SHARD))
            .save(consumer, modId("amethyst_boots"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_HEAD,
                RecipeCategory.COMBAT,
                ItemInit.RUBY_HELMET)
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_helmet"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_CHEST,
                RecipeCategory.COMBAT,
                ItemInit.RUBY_CHESTPLATE)
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_chestplate"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_LEGS,
                RecipeCategory.COMBAT,
                ItemInit.RUBY_LEGGINGS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_leggings"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_FEET,
                RecipeCategory.COMBAT,
                ItemInit.RUBY_BOOTS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_RUBY)
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_RUBY))
            .save(consumer, modId("ruby_boots"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_HEAD,
                RecipeCategory.COMBAT,
                ItemInit.SAPPHIRE_HELMET)
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_helmet"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_CHEST,
                RecipeCategory.COMBAT,
                ItemInit.SAPPHIRE_CHESTPLATE)
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_chestplate"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_LEGS,
                RecipeCategory.COMBAT,
                ItemInit.SAPPHIRE_LEGGINGS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_leggings"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_FEET,
                RecipeCategory.COMBAT,
                ItemInit.SAPPHIRE_BOOTS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_SAPPHIRE)
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
            .save(consumer, modId("sapphire_boots"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_HEAD,
                RecipeCategory.COMBAT,
                ItemInit.GRAPHITE_HELMET)
            .define('A', TagsInit.ItemTagsInit.INGOTS_GRAPHITE)
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_GRAPHITE))
            .save(consumer, modId("graphite_helmet"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_CHEST,
                RecipeCategory.COMBAT,
                ItemInit.GRAPHITE_CHESTPLATE)
            .define('A', TagsInit.ItemTagsInit.INGOTS_GRAPHITE)
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_GRAPHITE))
            .save(consumer, modId("graphite_chestplate"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_LEGS,
                RecipeCategory.COMBAT,
                ItemInit.GRAPHITE_LEGGINGS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_GRAPHITE)
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_GRAPHITE))
            .save(consumer, modId("graphite_leggings"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_FEET,
                RecipeCategory.COMBAT,
                ItemInit.GRAPHITE_BOOTS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_GRAPHITE)
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_GRAPHITE))
            .save(consumer, modId("graphite_boots"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_HEAD,
                RecipeCategory.COMBAT,
                ItemInit.RAINBOW_HELMET)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("rainbow_helmet"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_CHEST,
                RecipeCategory.COMBAT,
                ItemInit.RAINBOW_CHESTPLATE)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("rainbow_chestplate"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_LEGS,
                RecipeCategory.COMBAT,
                ItemInit.RAINBOW_LEGGINGS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("rainbow_leggings"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_FEET,
                RecipeCategory.COMBAT,
                ItemInit.RAINBOW_BOOTS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("rainbow_boots"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_HEAD,
                RecipeCategory.COMBAT,
                ItemInit.AQUMARINE_HELMET)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("aqumarine_helmet"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_CHEST,
                RecipeCategory.COMBAT,
                ItemInit.AQUMARINE_CHESTPLATE)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("aqumarine_chestplate"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_LEGS,
                RecipeCategory.COMBAT,
                ItemInit.AQUMARINE_LEGGINGS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("aqumarine_leggings"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_FEET,
                RecipeCategory.COMBAT,
                ItemInit.AQUMARINE_BOOTS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_AQUMARINE)
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
            .save(consumer, modId("aqumarine_boots"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_HEAD,
                RecipeCategory.COMBAT,
                ItemInit.ENDERITE_HELMET)
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_helmet"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_CHEST,
                RecipeCategory.COMBAT,
                ItemInit.ENDERITE_CHESTPLATE)
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_chestplate"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_LEGS,
                RecipeCategory.COMBAT,
                ItemInit.ENDERITE_LEGGINGS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_leggings"))

        CustomArmourCraftingTableRecipeBuilder.shaped(
                CustomArmourCraftingBookCategory.ARMOUR_FEET,
                RecipeCategory.COMBAT,
                ItemInit.ENDERITE_BOOTS)
            .define('A', TagsInit.ItemTagsInit.INGOTS_ENDERITE)
            .pattern("A A")
            .pattern("A A")
            .unlockedBy(hasItem, has(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
            .save(consumer, modId("enderite_boots"))
    }
}
