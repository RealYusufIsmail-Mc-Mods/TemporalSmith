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
package io.github.realyusufismail.temporalsmith.recipe.tool.builder

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import io.github.realyusufismail.realyusufismailcore.recipe.util.EnchantmentsAndLevels
import io.github.realyusufismail.temporalsmith.blocks.tool.book.CustomToolsCraftingBookCategory
import io.github.realyusufismail.temporalsmith.recipe.pattern.CustomCraftingTableRecipePattern
import io.github.realyusufismail.temporalsmith.recipe.tool.CustomToolCraftingTableShapedRecipe
import net.minecraft.advancements.*
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger
import net.minecraft.data.recipes.RecipeBuilder
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.level.ItemLike

/** @see net.minecraft.data.recipes.ShapedRecipeBuilder */
object CustomToolCraftingTableRecipeBuilder : RecipeBuilder {
    private val rows: MutableList<String> = Lists.newArrayList()
    private val key: MutableMap<Char, Ingredient> = Maps.newLinkedHashMap()
    private val criteria: MutableMap<String, Criterion<*>> = Maps.newLinkedHashMap()
    private var group: String? = null
    private var bookCategory: CustomToolsCraftingBookCategory? = null

    private var recipeCategory: RecipeCategory? = null
    private var count: Int? = null
    private var result: Item? = null
    private var showNotification: Boolean = false
    private var enchantmentsAndLevels: EnchantmentsAndLevels = EnchantmentsAndLevels()
    private var hideFlags: Int = 0


    fun shaped(
        bookCategory: CustomToolsCraftingBookCategory,
        recipeCategory: RecipeCategory,
        itemLike: ItemLike,
    ): CustomToolCraftingTableRecipeBuilder {
        return shaped(bookCategory, recipeCategory, itemLike, 1)
    }

    private fun shaped(
        bookCategory: CustomToolsCraftingBookCategory,
        recipeCategory: RecipeCategory,
        itemLike: ItemLike,
        count: Int,
    ): CustomToolCraftingTableRecipeBuilder {
        CustomToolCraftingTableRecipeBuilder.recipeCategory = recipeCategory
        result = itemLike.asItem()
        CustomToolCraftingTableRecipeBuilder.count = count
        CustomToolCraftingTableRecipeBuilder.bookCategory = bookCategory
        return this
    }

    fun define(character: Char, itemTag: TagKey<Item>): CustomToolCraftingTableRecipeBuilder {
        return define(character, Ingredient.of(itemTag))
    }

    fun define(character: Char, itemLike: ItemLike): CustomToolCraftingTableRecipeBuilder {
        return define(character, Ingredient.of(itemLike))
    }

    private fun define(
        character: Char,
        ingredient: Ingredient,
    ): CustomToolCraftingTableRecipeBuilder {
        if (key.containsKey(character)) {
            throw IllegalArgumentException("Symbol '$character' is already defined!")
        } else if (character == ' ') {
            throw IllegalArgumentException(
                "Symbol ' ' (whitespace) is reserved and cannot be defined")
        } else {
            key[character] = ingredient
            return this
        }
    }

    fun pattern(pattern: String): CustomToolCraftingTableRecipeBuilder {
        if (rows.isNotEmpty() && pattern.length != rows[0].length) {
            throw IllegalArgumentException("Pattern must be the same width on every line!")
        } else {
            rows.add(pattern)
            return this
        }
    }

    override fun unlockedBy(
        creterionId: String,
        criterion: Criterion<*>,
    ): CustomToolCraftingTableRecipeBuilder {
        criteria[creterionId] = criterion
        return this
    }

    override fun group(pGroupName: String?): RecipeBuilder {
        group = pGroupName
        return this
    }

    fun addEnchantment(enchantment: Enchantment, level: Int): CustomToolCraftingTableRecipeBuilder {
        enchantmentsAndLevels.add(enchantment, level)
        return this
    }

    fun hideFlags(hideFlags: Int): CustomToolCraftingTableRecipeBuilder {
        this.hideFlags = hideFlags
        return this
    }

    fun showNotification(p_273326_: Boolean): CustomToolCraftingTableRecipeBuilder {
        showNotification = p_273326_
        return this
    }

    override fun getResult(): Item {
        return result ?: throw IllegalStateException("Result is not set")
    }

    override fun save(
        recipeOutput: RecipeOutput,
        resourceLocation: ResourceLocation,
    ) {
        val recipePattern = ensureValid(resourceLocation)

        val advancementBuilder: Advancement.Builder =
            recipeOutput
                .advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation))
                .rewards(AdvancementRewards.Builder.recipe(resourceLocation))
                .requirements(AdvancementRequirements.Strategy.OR)

        this.criteria.forEach(advancementBuilder::addCriterion)

        val customToolCraftingTableShapedRecipe =
            CustomToolCraftingTableShapedRecipe(
                group ?: "",
                bookCategory ?: throw IllegalStateException("Recipe category is not set"),
                recipePattern,
                ItemStack(
                    result ?: throw IllegalStateException("Result is not set"), count
                        ?: 1),
                showNotification,
                enchantmentsAndLevels,
                hideFlags
            )

        recipeOutput.accept(resourceLocation, customToolCraftingTableShapedRecipe, advancementBuilder.build(resourceLocation.withPrefix("recipes/" + this.recipeCategory!!.folderName + "/")));

        clear()
    }

    private fun ensureValid(p_126144_: ResourceLocation): CustomCraftingTableRecipePattern {
        check(criteria.isNotEmpty()) { "No way of obtaining recipe $p_126144_" }
        return CustomCraftingTableRecipePattern.of(
            key,
            rows
        )
    }

    private fun clear() {
        rows.clear()
        key.clear()
        group = null
        bookCategory = null
        recipeCategory = null
        count = null
        result = null
    }

}
