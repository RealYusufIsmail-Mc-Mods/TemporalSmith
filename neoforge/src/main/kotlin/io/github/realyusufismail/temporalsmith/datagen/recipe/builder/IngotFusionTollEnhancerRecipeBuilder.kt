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
package io.github.realyusufismail.temporalsmith.datagen.recipe.builder

import com.google.common.collect.Maps
import com.google.gson.JsonObject
import io.github.realyusufismail.temporalsmith.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookCategory
import io.github.realyusufismail.temporalsmith.core.init.RecipeSerializerInit
import java.util.*
import net.minecraft.advancements.*
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer

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

                recipeOutput.accept(
                    Result(
                        recipeCategory,
                        ingredient1,
                        ingredient2,
                        ingredient3,
                        result,
                        advancementBuilder.build(
                            rl.withPrefix("recipes/" + this.recipeCategory.serializedName + "/"))))
            }
        } catch (e: IllegalStateException) {
            throw IllegalStateException("Could not create recipe: $rl", e)
        }
    }

    private fun ensureValid(rl: ResourceLocation) {
        check(criteria.isNotEmpty()) { "Can not obtain recipe: $rl" }
    }

    /**
     * Protip: The error has a string, seaching for that string will give more context
     *
     * @param input1 The first input item
     * @param input2 The second input item
     * @param input3 The third input item
     * @param output The output item
     * @param category The recipe category
     * @param advancementId The advancement id
     * @param id The recipe id
     */
    @JvmRecord
    private data class Result(
        val recipeCategory: IngotFusionTollEnhancerRecipeBookCategory,
        val ingredient1: Ingredient,
        val ingredient2: Ingredient,
        val ingredient3: Ingredient,
        val result: ItemStack,
        val advancementHolder: AdvancementHolder
    ) : FinishedRecipe {
        override fun serializeRecipeData(json: JsonObject) {
            json.addProperty("category", recipeCategory.serializedName)
            json.add("result", serializeResult(result))
            json.add("ingredient1", ingredient1.toJson(false))
            json.add("ingredient2", ingredient2.toJson(false))
            json.add("ingredient3", ingredient3.toJson(false))
        }

        override fun id(): ResourceLocation {
            return advancementHolder.id
        }

        private fun serializeResult(stack: ItemStack): JsonObject {
            val json = JsonObject()
            json.addProperty("item", BuiltInRegistries.ITEM.getKey(stack.item).toString())
            json.addProperty("count", stack.count)
            if (stack.hasTag()) {
                json.addProperty("nbt", stack.tag.toString())
            }
            return json
        }

        override fun type(): RecipeSerializer<*> {
            return RecipeSerializerInit.INGOT_FUSION_TOLL_ENHANCER_RECIPE.get()
        }

        override fun advancement(): AdvancementHolder {
            return advancementHolder
        }
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
