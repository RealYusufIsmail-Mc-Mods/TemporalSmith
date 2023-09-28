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
package io.github.realyusufismail.armourandtoolsmod.core.init

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.recipe.armour.CustomArmourCraftingTableRecipe
import io.github.realyusufismail.armourandtoolsmod.recipe.fusion.IngotFusionTollEnhancerRecipe
import io.github.realyusufismail.armourandtoolsmod.recipe.tool.CustomToolCraftingTableRecipe
import mezz.jei.api.recipe.RecipeType

object JEIRecipeTypes {
    val toolCrafting =
        RecipeType.create(
            ArmourAndToolsMod.MOD_ID,
            "custom_tool_crafting_table",
            CustomToolCraftingTableRecipe::class.java)

    val armourCrafting =
        RecipeType.create(
            ArmourAndToolsMod.MOD_ID,
            "custom_armour_crafting_table",
            CustomArmourCraftingTableRecipe::class.java)

    val ingotFusionTollEnhancer =
        RecipeType.create(
            ArmourAndToolsMod.MOD_ID,
            "ingot_fusion_toll_enhancer",
            IngotFusionTollEnhancerRecipe::class.java)
}
