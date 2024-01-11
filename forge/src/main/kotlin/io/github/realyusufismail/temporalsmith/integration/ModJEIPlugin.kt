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
package io.github.realyusufismail.temporalsmith.integration

import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.JEIRecipeTypes
import io.github.realyusufismail.temporalsmith.core.init.RecipeTypeInit
import io.github.realyusufismail.temporalsmith.integration.armour.CustomArmourCraftingTableJEIRecipeCategory
import io.github.realyusufismail.temporalsmith.integration.fusion.IngotFusionTollEnhancerJEIRecipeCategory
import io.github.realyusufismail.temporalsmith.integration.tool.CustomToolCraftingTableJEIRecipeCategory
import io.github.realyusufismail.temporalsmith.recipe.armour.CustomArmourCraftingTableRecipe
import io.github.realyusufismail.temporalsmith.recipe.infusion.IngotFusionTollEnhancerRecipe
import io.github.realyusufismail.temporalsmith.recipe.tool.CustomToolCraftingTableRecipe
import mezz.jei.api.IModPlugin
import mezz.jei.api.JeiPlugin
import mezz.jei.api.recipe.RecipeType
import mezz.jei.api.registration.*
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack

@JeiPlugin
class ModJEIPlugin : IModPlugin {
    private val pluginId: ResourceLocation = TemporalSmith.getModIdAndName("temporalsmith_plugin")

    override fun registerCategories(registration: IRecipeCategoryRegistration) {
        registration.addRecipeCategories(
            CustomToolCraftingTableJEIRecipeCategory(registration.jeiHelpers.guiHelper),
            CustomArmourCraftingTableJEIRecipeCategory(registration.jeiHelpers.guiHelper),
            IngotFusionTollEnhancerJEIRecipeCategory(registration.jeiHelpers.guiHelper))
    }

    override fun registerRecipes(registration: IRecipeRegistration) {
        val recipeManager = Minecraft.getInstance().level!!.recipeManager
        val recipesTool = recipeManager.getAllRecipesFor(RecipeTypeInit.TOOL_CRAFTING.get())
        val recipesArmour = recipeManager.getAllRecipesFor(RecipeTypeInit.ARMOUR_CRAFTING.get())
        val recipesIngotFusionTollEnhancer =
            recipeManager.getAllRecipesFor(RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get())
        registration.addRecipes(toolCraftingTableRecipeType, recipesTool)
        registration.addRecipes(armourCraftingTableRecipeType, recipesArmour)
        registration.addRecipes(ingotFusionTollEnhancerRecipeType, recipesIngotFusionTollEnhancer)
    }

    override fun registerRecipeCatalysts(registration: IRecipeCatalystRegistration) {
        registration.addRecipeCatalyst(
            ItemStack(BlockInit.CUSTOM_TOOL_CRAFTING_TABLE.get()), JEIRecipeTypes.toolCrafting)
        registration.addRecipeCatalyst(
            ItemStack(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get()), JEIRecipeTypes.armourCrafting)
        registration.addRecipeCatalyst(
            ItemStack(BlockInit.INGOT_FUSION_TOLL_ENHANCER.get()),
            JEIRecipeTypes.ingotFusionTollEnhancer)
    }

    override fun getPluginUid(): ResourceLocation {
        return pluginId
    }

    companion object {
        val armourCraftingTableRecipeType: RecipeType<CustomArmourCraftingTableRecipe> =
            RecipeType(
                CustomArmourCraftingTableJEIRecipeCategory.UID,
                CustomArmourCraftingTableRecipe::class.java)
        val toolCraftingTableRecipeType: RecipeType<CustomToolCraftingTableRecipe> =
            RecipeType(
                CustomToolCraftingTableJEIRecipeCategory.UID,
                CustomToolCraftingTableRecipe::class.java)
        val ingotFusionTollEnhancerRecipeType: RecipeType<IngotFusionTollEnhancerRecipe> =
            RecipeType(
                IngotFusionTollEnhancerJEIRecipeCategory.UID,
                IngotFusionTollEnhancerRecipe::class.java)
    }
}
