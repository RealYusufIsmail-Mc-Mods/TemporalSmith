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
package io.github.realyusufismail.temporalsmith.recipe.ingot.builder

import com.google.common.collect.Maps
import io.github.realyusufismail.temporalsmith.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookCategory
import io.github.realyusufismail.temporalsmith.recipe.infusion.IngotFusionTollEnhancerRecipe
import java.util.*
import net.minecraft.advancements.*
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient

class IngotFusionTollEnhancerRecipeBuilder(
    private val recipeCategory: IngotFusionTollEnhancerRecipeBookCategory,
    private val ingredient1: Ingredient,
    private val ingredient2: Ingredient,
    private val ingredient3: Ingredient,
    private val result: ItemStack,
) {
    private val criteria: MutableMap<String, Criterion<*>> = Maps.newLinkedHashMap()

    fun unlockedBy(
        creterionId: String,
        criterion: Criterion<*>,
    ): IngotFusionTollEnhancerRecipeBuilder {
        this.criteria[creterionId] = criterion
        return this
    }

    fun save(recipeOutput: RecipeOutput, rl: ResourceLocation) {
        try {
            ensureValid(rl)

            if (criteria.isNotEmpty()) {
                val advancementBuilder: Advancement.Builder =
                    recipeOutput
                        .advancement()
                        .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(rl))
                        .rewards(AdvancementRewards.Builder.recipe(rl))
                        .requirements(AdvancementRequirements.Strategy.OR)

                val recipe =
                    IngotFusionTollEnhancerRecipe(
                        recipeCategory, ingredient1, ingredient2, ingredient3, result)

                recipeOutput.accept(
                    rl,
                    recipe,
                    advancementBuilder.build(
                        rl.withPrefix("recipes/" + this.recipeCategory.serializedName + "/")))
            }
        } catch (e: IllegalStateException) {
            throw IllegalStateException("Could not create recipe: $rl", e)
        }
    }

    private fun ensureValid(rl: ResourceLocation) {
        check(criteria.isNotEmpty()) { "Can not obtain recipe: $rl" }
    }

    companion object {
        fun builder(
            recipeCategory: IngotFusionTollEnhancerRecipeBookCategory,
            input1: Item,
            input2: Item,
            input3: Item,
            result: ItemStack,
        ): IngotFusionTollEnhancerRecipeBuilder {
            return IngotFusionTollEnhancerRecipeBuilder(
                recipeCategory, ingredient(input1), ingredient(input2), ingredient(input3), result)
        }

        private fun ingredient(entry: Item): Ingredient {
            return Ingredient.of(entry)
        }
    }
}
