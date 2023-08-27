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

import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.MainModRecipeProvider
import java.util.function.Consumer
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.SmithingTrimRecipeBuilder
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient

class NewSmithingTableRecipeProvider(
    private val mainModRecipeProvider: MainModRecipeProvider,
    private val pWriter: Consumer<FinishedRecipe>
) : MainModRecipeProvider(mainModRecipeProvider) {

    fun build() {
        SmithingTrimRecipeBuilder.smithingTrim(
                Ingredient.of(Items.DIAMOND),
                Ingredient.of(ItemInit.RUBY_HELMET.get().asItem()),
                Ingredient.of(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE),
                RecipeCategory.MISC)
            .unlocks("has_diamond", has(Items.DIAMOND))
            .save(pWriter, "armourandtoolsmod:ruby_helmet_smithing")
    }
}
