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
package io.github.realyusufismail.temporalsmith.integration.armour

import io.github.realyusufismail.temporalsmith.temporalsmith
import io.github.realyusufismail.temporalsmith.blocks.CustomArmourCraftingTable
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.integration.temporalsmithJEIPlugin
import io.github.realyusufismail.temporalsmith.integration.generic.GenericCraftingTableJEIRecipeCategory
import io.github.realyusufismail.temporalsmith.recipe.armour.CustomArmourCraftingTableRecipe
import java.util.*
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder
import mezz.jei.api.gui.drawable.IDrawable
import mezz.jei.api.helpers.IGuiHelper
import mezz.jei.api.recipe.IFocusGroup
import mezz.jei.api.recipe.RecipeIngredientRole
import mezz.jei.api.recipe.RecipeType
import net.minecraft.network.chat.Component

class CustomArmourCraftingTableJEIRecipeCategory(guiHelper: IGuiHelper) :
    GenericCraftingTableJEIRecipeCategory<CustomArmourCraftingTableRecipe>(
        guiHelper, BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get()) {

    override fun getRecipeType(): RecipeType<CustomArmourCraftingTableRecipe> {
        return temporalsmithJEIPlugin.armourCraftingTableRecipeType
    }

    override fun getTitle(): Component {
        return CustomArmourCraftingTable.containerTitle
    }

    override fun getBackground(): IDrawable {
        return this.bg
    }

    override fun getIcon(): IDrawable {
        return this.ic
    }

    override fun setRecipe(
        builder: IRecipeLayoutBuilder,
        recipe: CustomArmourCraftingTableRecipe,
        focuses: IFocusGroup
    ) {
        val ingredients = recipe.ingredients

        // Define variables for each slot and add ingredients if they are not empty
        val slots =
            arrayOf(
                Pair(30, 16),
                Pair(48, 16),
                Pair(66, 16),
                Pair(30, 34),
                Pair(48, 34),
                Pair(66, 34),
                Pair(30, 52),
                Pair(48, 52),
                Pair(66, 52))

        for (i in 0 until minOf(ingredients.size, slots.size)) {
            val (x, y) = slots[i]
            if (!ingredients[i].isEmpty) {
                val slot = builder.addSlot(RecipeIngredientRole.INPUT, x, y)
                slot.addIngredients(ingredients[i])
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 34).addItemStack(recipe.result)
    }

    companion object {
        val UID = temporalsmith.getModIdAndName("custom_armour_crafting_table")
    }
}
