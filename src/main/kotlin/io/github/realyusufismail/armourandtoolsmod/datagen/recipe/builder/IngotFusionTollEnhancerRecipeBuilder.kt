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
package io.github.realyusufismail.armourandtoolsmod.datagen.recipe.builder

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookCategory
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit
import java.util.*
import java.util.function.Consumer
import net.minecraft.advancements.Advancement
import net.minecraft.advancements.AdvancementRewards
import net.minecraft.advancements.RequirementsStrategy
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraftforge.registries.ForgeRegistries

class IngotFusionTollEnhancerRecipeBuilder(
    private val recipeCategory: IngotFusionTollEnhancerRecipeBookCategory,
    private val input1: Ingredient,
    private val input2: Ingredient,
    private val input3: Ingredient,
    private val result: Item,
    private val craftTime: Int = 200,
    private val experience: Float = 0.2f
) {
    private val advancementBuilder = Advancement.Builder.advancement()

    fun unlockedBy(
        criterionId: String,
        criterion: InventoryChangeTrigger.TriggerInstance
    ): IngotFusionTollEnhancerRecipeBuilder {
        advancementBuilder.addCriterion(criterionId, criterion)
        return this
    }

    fun save(consumer: Consumer<FinishedRecipe>, rl: ResourceLocation) {
        try {
            ensureValid(rl)
            if (advancementBuilder.criteria.isNotEmpty())
                advancementBuilder
                    .parent(ResourceLocation("recipes/root"))
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(rl))
                    .rewards(AdvancementRewards.Builder.recipe(rl))
                    .requirements(RequirementsStrategy.OR)
            consumer.accept(
                Result(
                    recipeCategory,
                    input1,
                    input2,
                    input3,
                    result,
                    craftTime,
                    experience,
                    advancementBuilder,
                    ResourceLocation(rl.namespace, "recipes/root").also { advancementId ->
                        advancementBuilder.parent(advancementId)
                    },
                    rl))
        } catch (e: IllegalStateException) {
            throw IllegalStateException("Could not create recipe: $rl", e)
        }
    }

    private fun ensureValid(rl: ResourceLocation) {
        check(advancementBuilder.criteria.isNotEmpty()) { "Can not obtain recipe: $rl" }
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
        val input1: Ingredient,
        val input2: Ingredient,
        val input3: Ingredient,
        val result: Item,
        val craftTime: Int,
        val experience: Float,
        val advancementBuilder: Advancement.Builder,
        val advancementId: ResourceLocation,
        val id: ResourceLocation
    ) : FinishedRecipe {
        override fun serializeRecipeData(json: JsonObject) {
            val jsonArray = JsonArray()
            val ingredients = arrayOf(input1, input2, input3)

            for (ingredient in ingredients) {
                jsonArray.add(ingredient.toJson())
            }

            json.add("ingredients", jsonArray)

            json.addProperty("crafttime", craftTime)
            json.addProperty("experience", experience)
            json.addProperty("category", recipeCategory.serializedName)

            val jsonObject = JsonObject()
            jsonObject.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString())
            json.add("result", jsonObject)
        }

        override fun getId(): ResourceLocation {
            return id
        }

        override fun getType(): RecipeSerializer<*> {
            return RecipeSerializerInit.INGOT_FUSION_TOLL_ENHANCER_RECIPE.get()
        }

        override fun serializeAdvancement(): JsonObject {
            return advancementBuilder.serializeToJson()
        }

        override fun getAdvancementId(): ResourceLocation {
            return advancementId
        }
    }

    companion object {
        fun builder(
            recipeCategory: IngotFusionTollEnhancerRecipeBookCategory,
            input1: Item,
            input2: Item,
            input3: Item,
            result: Item,
            craftTime: Int? = null,
            experience: Float? = null
        ): IngotFusionTollEnhancerRecipeBuilder {
            return IngotFusionTollEnhancerRecipeBuilder(
                recipeCategory,
                ingredient(input1),
                ingredient(input2),
                ingredient(input3),
                result,
                craftTime ?: 200,
                experience ?: 0.2f)
        }

        private fun ingredient(entry: Item): Ingredient {
            return Ingredient.of(entry)
        }
    }
}
