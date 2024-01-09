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

import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.core.util.bName
import io.github.realyusufismail.temporalsmith.core.util.name
import io.github.realyusufismail.temporalsmith.datagen.recipe.MainModRecipeProvider
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.world.item.crafting.Ingredient

class FurnaceRecipeProvider(
    private val mainModRecipeProvider: MainModRecipeProvider,
    private val consumer: RecipeOutput,
) : MainModRecipeProvider(mainModRecipeProvider) {
    private val hasItem = "has_item"

    fun build() {
        addRawOreRecipes()
    }

    private fun addRawOreRecipes() {
        ItemInit.SMELT_ABLE_ITEM.forEach { (i, io) ->
            SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(i.get()), RecipeCategory.MISC, io.get(), 0.6f, 300)
                .unlockedBy(hasItem, has(i.get()))
                .save(consumer, modId("smelting_" + i.get().name))

            SimpleCookingRecipeBuilder.blasting(
                    Ingredient.of(i.get()), RecipeCategory.MISC, io.get(), 0.6f, 300)
                .unlockedBy(hasItem, has(i.get()))
                .save(consumer, modId("blasting_" + i.get().name))
        }

        BlockInit.SMELT_ABLE_BLOCKS.forEach { (b, i) ->
            SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(b.get()), RecipeCategory.MISC, i.get(), 0.6f, 300)
                .unlockedBy(hasItem, has(b.get()))
                .save(consumer, modId("smelting_" + b.get().bName))

            SimpleCookingRecipeBuilder.blasting(
                    Ingredient.of(b.get()), RecipeCategory.MISC, i.get(), 0.6f, 300)
                .unlockedBy(hasItem, has(b.get()))
                .save(consumer, modId("blasting_" + b.get().bName))
        }
    }
}
