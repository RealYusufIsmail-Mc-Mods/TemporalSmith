/*
 * Copyright 2024 RealYusufIsmail.
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
package io.github.realyusufismail.temporalsmith.datagen.recipe

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.datagen.recipe.provider.*
import java.util.concurrent.CompletableFuture
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.common.conditions.IConditionBuilder

open class MainModRecipeProvider(
    private val generatorIn: DataGenerator,
    private val lookup: CompletableFuture<HolderLookup.Provider>
) : RecipeProvider(generatorIn.packOutput, lookup), IConditionBuilder {

    constructor(`this`: MainModRecipeProvider) : this(`this`.generatorIn, `this`.lookup)

    override fun buildRecipes(recipeOutput: RecipeOutput) {
        ArmourCraftingTableRecipeProvider(this, recipeOutput).build()
        FurnaceRecipeProvider(this, recipeOutput).build()
        NormalCraftingTableRecipeProvider(this, recipeOutput).build()
        ToolCraftingTableRecipeProvider(this, recipeOutput).build()
        NewSmithingTableRecipeProvider(this, recipeOutput).build()
        IngotFusionTollEnhancerRecipeProvider(this, recipeOutput).build()
    }

    open fun modId(path: String): ResourceLocation {
        return ResourceLocation(MOD_ID, path)
    }
}
