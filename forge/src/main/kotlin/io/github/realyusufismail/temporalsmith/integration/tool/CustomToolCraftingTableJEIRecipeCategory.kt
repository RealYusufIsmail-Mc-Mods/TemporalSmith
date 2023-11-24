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
package io.github.realyusufismail.temporalsmith.integration.tool

import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.blocks.CustomToolCraftingTable
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.integration.ModJEIPlugin
import io.github.realyusufismail.temporalsmith.integration.generic.GenericCraftingTableJEIRecipeCategory
import io.github.realyusufismail.temporalsmith.recipe.tool.CustomToolCraftingTableRecipe
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder
import mezz.jei.api.gui.drawable.IDrawable
import mezz.jei.api.helpers.IGuiHelper
import mezz.jei.api.recipe.IFocusGroup
import mezz.jei.api.recipe.RecipeIngredientRole
import mezz.jei.api.recipe.RecipeType
import net.minecraft.network.chat.Component

class CustomToolCraftingTableJEIRecipeCategory(private val guiHelper: IGuiHelper) :
    GenericCraftingTableJEIRecipeCategory<CustomToolCraftingTableRecipe>(
        guiHelper, BlockInit.CUSTOM_TOOL_CRAFTING_TABLE.get()) {

    override fun getRecipeType(): RecipeType<CustomToolCraftingTableRecipe> {
        return ModJEIPlugin.toolCraftingTableRecipeType
    }

    override fun getTitle(): Component {
        return CustomToolCraftingTable.containerTitle
    }

    override fun getBackground(): IDrawable {
        return this.bg
    }

    override fun getIcon(): IDrawable {
        return this.ic
    }

    /**
     * Y is up and down X is left and right
     *
     * Increase Y to down and decrease Y to up Increase X to right and decrease X to left
     */
    override fun setRecipe(
        builder: IRecipeLayoutBuilder,
        recipe: CustomToolCraftingTableRecipe,
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
        val UID = TemporalSmith.getModIdAndName("custom_tool_crafting_table")
    }
}
