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
import io.github.realyusufismail.temporalsmith.recipe.armour.CustomArmourCraftingTableRecipe
import io.github.realyusufismail.temporalsmith.recipe.infusion.IngotFusionTollEnhancerRecipe
import io.github.realyusufismail.temporalsmith.recipe.tool.CustomToolCraftingTableRecipe
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.crafting.RecipeType
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

/** @see net.minecraft.stats.RecipeBookSettings */
object RecipeTypeInit {
    val RECIPE_TYPES: DeferredRegister<RecipeType<*>> =
        DeferredRegister.create(Registries.RECIPE_TYPE, MOD_ID)

    val ARMOUR_CRAFTING:
        DeferredHolder<RecipeType<*>, RecipeType<CustomArmourCraftingTableRecipe>> =
        RECIPE_TYPES.register("armour_crafting") { ->
            RecipeType.simple(ResourceLocation(MOD_ID, "armour_crafting"))
        }

    val TOOL_CRAFTING: DeferredHolder<RecipeType<*>, RecipeType<CustomToolCraftingTableRecipe>> =
        RECIPE_TYPES.register("tool_crafting") { ->
            RecipeType.simple(ResourceLocation(MOD_ID, "tool_crafting"))
        }

    @JvmField
    val INGOT_FUSION_TOLL_ENHANCER:
        DeferredHolder<RecipeType<*>, RecipeType<IngotFusionTollEnhancerRecipe>> =
        RECIPE_TYPES.register("ingot_fusion_toll_enhancer") { ->
            RecipeType.simple(ResourceLocation(MOD_ID, "ingot_fusion_toll_enhancer"))
        }
}
