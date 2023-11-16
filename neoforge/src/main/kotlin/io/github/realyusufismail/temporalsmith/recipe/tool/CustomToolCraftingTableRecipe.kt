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
package io.github.realyusufismail.temporalsmith.recipe.tool

import io.github.realyusufismail.temporalsmith.blocks.tool.CustomToolCraftingTableContainer
import io.github.realyusufismail.temporalsmith.blocks.tool.book.CustomToolsCraftingBookCategory
import io.github.realyusufismail.temporalsmith.core.init.RecipeTypeInit
import net.minecraft.core.NonNullList
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.item.crafting.RecipeType

interface CustomToolCraftingTableRecipe : Recipe<CustomToolCraftingTableContainer> {
    override fun getType(): RecipeType<*> {
        return RecipeTypeInit.TOOL_CRAFTING.get()
    }

    fun category(): CustomToolsCraftingBookCategory

    override fun getIngredients(): NonNullList<Ingredient>

    val result: ItemStack
}
