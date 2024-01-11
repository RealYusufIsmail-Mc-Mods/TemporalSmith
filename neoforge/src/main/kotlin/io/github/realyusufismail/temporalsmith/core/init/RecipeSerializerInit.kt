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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.recipe.armour.CustomArmourCraftingTableShapedRecipe
import io.github.realyusufismail.temporalsmith.recipe.infusion.IngotFusionTollEnhancerRecipe
import io.github.realyusufismail.temporalsmith.recipe.tool.CustomToolCraftingTableShapedRecipe
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.item.crafting.RecipeSerializer
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object RecipeSerializerInit {
    val SERIALIZERS: DeferredRegister<RecipeSerializer<*>> =
        DeferredRegister.create(Registries.RECIPE_SERIALIZER, MOD_ID)

    val CUSTOM_ARMOUR_CRAFTER:
        DeferredHolder<
            RecipeSerializer<*>, RecipeSerializer<CustomArmourCraftingTableShapedRecipe>> =
        register("custom_armour_crafter", CustomArmourCraftingTableShapedRecipe.Serializer())

    val CUSTOM_TOOL_CRAFTER:
        DeferredHolder<RecipeSerializer<*>, RecipeSerializer<CustomToolCraftingTableShapedRecipe>> =
        register("custom_tool_crafter", CustomToolCraftingTableShapedRecipe.Serializer())

    @JvmField
    val INGOT_FUSION_TOLL_ENHANCER_RECIPE:
        DeferredHolder<RecipeSerializer<*>, RecipeSerializer<IngotFusionTollEnhancerRecipe>> =
        register("ingot_fusion_toll_enhancer", IngotFusionTollEnhancerRecipe.Serializer())

    private fun <S : RecipeSerializer<T>, T : Recipe<*>> register(
        pKey: String,
        pRecipeSerializer: S,
    ): DeferredHolder<RecipeSerializer<*>, S> {
        return SERIALIZERS.register(pKey) { -> pRecipeSerializer }
    }
}
