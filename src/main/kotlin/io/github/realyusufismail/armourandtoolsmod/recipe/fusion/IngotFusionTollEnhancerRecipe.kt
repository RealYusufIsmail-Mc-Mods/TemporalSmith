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
package io.github.realyusufismail.armourandtoolsmod.recipe.fusion

import com.google.gson.JsonObject
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.Container
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.*
import net.minecraft.world.level.Level
import net.minecraftforge.registries.ForgeRegistries

class IngotFusionTollEnhancerRecipe(
    private val input1: Ingredient,
    private val input2: Ingredient,
    private val input3: Ingredient,
    val result: ItemStack,
    private val recipeId: ResourceLocation
) : Recipe<Container> {

    /** Used to check if a recipe matches current crafting inventory */
    override fun matches(pContainer: Container, pLevel: Level): Boolean {
        return input1.test(pContainer.getItem(0)) &&
            input2.test(pContainer.getItem(1)) &&
            input3.test(pContainer.getItem(2))
    }

    override fun assemble(pContainer: Container, pRegistryAccess: RegistryAccess): ItemStack {
        return result.copy()
    }

    /** Used to determine if this recipe can fit in a grid of the given width/height */
    override fun canCraftInDimensions(pWidth: Int, pHeight: Int): Boolean {
        return true
    }

    override fun getResultItem(pRegistryAccess: RegistryAccess): ItemStack {
        return result
    }

    override fun getId(): ResourceLocation {
        return recipeId
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return RecipeSerializerInit.INGOT_FUSION_TOLL_ENHANCER_RECIPE.registryObject.orElseThrow {
            IllegalStateException("No serializer for recipe type INGOT_FUSION_TOLL_ENHANCER_RECIPE")
        }
    }

    override fun getIngredients(): NonNullList<Ingredient> {
        val ingredients = NonNullList.create<Ingredient>()
        ingredients.add(input1)
        ingredients.add(input2)
        ingredients.add(input3)
        return ingredients
    }

    override fun getType(): RecipeType<*> {
        return RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get()
    }

    companion object {

        class Serializer : RecipeSerializer<IngotFusionTollEnhancerRecipe> {
            override fun fromJson(
                pRecipeId: ResourceLocation,
                json: JsonObject
            ): IngotFusionTollEnhancerRecipe {
                val input1 = Ingredient.fromJson(json.get("input1"))
                val input2 = Ingredient.fromJson(json.get("input2"))
                val input3 = Ingredient.fromJson(json.get("input3"))

                val result: ItemStack =
                    if (json["result"].isJsonObject)
                        ItemStack(ShapedRecipe.itemFromJson(json["result"].getAsJsonObject()))
                    else
                        ItemStack(
                            ForgeRegistries.ITEMS.getValue(
                                ResourceLocation(json["result"].asString))
                                ?: throw IllegalStateException(
                                    "Item: " + json["result"].asString + " does not exist"))

                return IngotFusionTollEnhancerRecipe(input1, input2, input3, result, pRecipeId)
            }

            override fun fromNetwork(
                pRecipeId: ResourceLocation,
                pBuffer: FriendlyByteBuf
            ): IngotFusionTollEnhancerRecipe {
                val input1 = Ingredient.fromNetwork(pBuffer)
                val input2 = Ingredient.fromNetwork(pBuffer)
                val input3 = Ingredient.fromNetwork(pBuffer)
                val result = pBuffer.readItem()
                return IngotFusionTollEnhancerRecipe(input1, input2, input3, result, pRecipeId)
            }

            override fun toNetwork(
                pBuffer: FriendlyByteBuf,
                pRecipe: IngotFusionTollEnhancerRecipe
            ) {
                pRecipe.input1.toNetwork(pBuffer)
                pRecipe.input2.toNetwork(pBuffer)
                pRecipe.input3.toNetwork(pBuffer)
                pBuffer.writeItem(pRecipe.result)
            }
        }
    }
}
