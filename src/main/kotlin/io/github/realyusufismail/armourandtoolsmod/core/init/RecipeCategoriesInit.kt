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
package io.github.realyusufismail.armourandtoolsmod.core.init

import com.google.common.base.Supplier
import com.google.common.base.Suppliers
import io.github.realyusufismail.armourandtoolsmod.core.blocks.armour.CustomArmourCraftingTableRecipe
import io.github.realyusufismail.armourandtoolsmod.core.blocks.armour.CustomArmourCraftingTableShapedRecipe
import net.minecraft.client.RecipeBookCategories
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.item.crafting.RecipeType
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent

object RecipeCategoriesInit {
    private var ARMOUR_CRAFTING_RECIPE_TYPE: RecipeType<CustomArmourCraftingTableRecipe> =
        CustomArmourCraftingTableShapedRecipe.CustomArmourCraftingTableType()

    private val ARMOUR_CRAFTING: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING", ItemStack(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get()))
        }

    fun registerRecipeCategories(event: RegisterRecipeBookCategoriesEvent) {
        event.registerBookCategories(
            RecipeBookTypeInit.ARMOUR_CRAFTING, listOf(ARMOUR_CRAFTING.get()))
        event.registerRecipeCategoryFinder(
            ARMOUR_CRAFTING_RECIPE_TYPE, RecipeCategoriesInit::getForgingCategory)
    }

    private fun getForgingCategory(recipe: Recipe<*>): RecipeBookCategories? {
        val recipeType = recipe.type
        return if (recipeType == ARMOUR_CRAFTING_RECIPE_TYPE) {
            ARMOUR_CRAFTING.get()
        } else {
            RecipeBookCategories.UNKNOWN
        }
    }
}
