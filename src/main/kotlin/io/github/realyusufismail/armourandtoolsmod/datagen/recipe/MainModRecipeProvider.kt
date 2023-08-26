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
package io.github.realyusufismail.armourandtoolsmod.datagen.recipe

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.provider.ArmourCraftingTableRecipeProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.provider.FurnaceRecipeProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.provider.NormalCraftingTableRecipeProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.provider.ToolCraftingTableRecipeProvider
import java.util.function.Consumer
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.common.crafting.conditions.IConditionBuilder

open class MainModRecipeProvider(private val generatorIn: DataGenerator) :
    RecipeProvider(generatorIn.packOutput), IConditionBuilder {

    constructor(`this`: MainModRecipeProvider) : this(`this`.generatorIn)

    override fun buildRecipes(pWriter: Consumer<FinishedRecipe>) {
        ArmourCraftingTableRecipeProvider(this, pWriter).build()
        FurnaceRecipeProvider(this, pWriter).build()
        NormalCraftingTableRecipeProvider(this, pWriter).build()
        ToolCraftingTableRecipeProvider(this, pWriter).build()
    }

    open fun modId(path: String): ResourceLocation {
        return ResourceLocation(MOD_ID, path)
    }
}
