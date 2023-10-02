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
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.GsonHelper
import net.minecraft.world.Container
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.*
import net.minecraft.world.level.Level

class IngotFusionTollEnhancerRecipe(
    private val input1: Ingredient,
    private val input2: Ingredient,
    private val input3: Ingredient,
    val result: ItemStack,
    private val recipeId: ResourceLocation
) : Recipe<Container> {

    /** Used to check if a recipe matches current crafting inventory */
    override fun matches(pContainer: Container, pLevel: Level): Boolean {
        return if (pLevel.isClientSide) false
        else if (pContainer.containerSize < 3) false
        else
            input1.test(pContainer.getItem(0)) &&
                input2.test(pContainer.getItem(1)) &&
                input3.test(pContainer.getItem(2))
    }

    override fun assemble(pContainer: Container, pRegistryAccess: RegistryAccess): ItemStack {
        return result
    }

    /** Used to determine if this recipe can fit in a grid of the given width/height */
    override fun canCraftInDimensions(pWidth: Int, pHeight: Int): Boolean {
        return true
    }

    override fun getResultItem(pRegistryAccess: RegistryAccess): ItemStack {
        return result.copy()
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
        return Type.INSTANCE
    }

    class Type : RecipeType<IngotFusionTollEnhancerRecipe> {
        override fun toString(): String {
            return "ingot_fusion_toll_enhancer"
        }

        companion object {
            val INSTANCE = Type()
        }
    }

    companion object {

        class Serializer : RecipeSerializer<IngotFusionTollEnhancerRecipe> {
            override fun fromJson(
                pRecipeId: ResourceLocation,
                json: JsonObject
            ): IngotFusionTollEnhancerRecipe {

                try {
                    // there is an array called Ingredients, and it contains 3 objects, each object
                    // is an ingredient
                    //  "ingredients": [
                    //    {
                    //      "item": "armourandtoolsmod:imperium"
                    //    },
                    //    {
                    //      "item": "armourandtoolsmod:imperium_pickaxe"
                    //    },
                    //    {
                    //      "item": "armourandtoolsmod:imperium"
                    //    }
                    //  ],
                    val ingredientArray = json.get("ingredients").asJsonArray
                    val input1 = Ingredient.fromJson(ingredientArray[0])
                    val input2 = Ingredient.fromJson(ingredientArray[1])
                    val input3 = Ingredient.fromJson(ingredientArray[2])

                    // TODO: Error caused by lack of recipe book category
                    // [13:57:18] [Render thread/WARN] [minecraft/ClientRecipeBook]: Unknown recipe
                    // category:
                    // [!!!com.mojang.logging.LogUtils$1ToString@6987a0f3=>java.lang.NullPointerException:Cannot invoke "Object.toString()" because the return value of "java.util.function.Supplier.get()" is null!!!]/armourandtoolsmod:magma_strike_pickaxe

                    val result =
                        ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"))

                    return IngotFusionTollEnhancerRecipe(input1, input2, input3, result, pRecipeId)
                } catch (e: IllegalStateException) {
                    throw IllegalStateException("Could not create recipe: $pRecipeId", e)
                }
            }

            override fun fromNetwork(
                pRecipeId: ResourceLocation,
                pBuffer: FriendlyByteBuf
            ): IngotFusionTollEnhancerRecipe {
                try {
                    val input1 = Ingredient.fromNetwork(pBuffer)
                    val input2 = Ingredient.fromNetwork(pBuffer)
                    val input3 = Ingredient.fromNetwork(pBuffer)
                    val result = pBuffer.readItem()
                    return IngotFusionTollEnhancerRecipe(input1, input2, input3, result, pRecipeId)
                } catch (e: IllegalStateException) {
                    throw IllegalStateException("Could not read recipe: $pRecipeId", e)
                }
            }

            override fun toNetwork(
                pBuffer: FriendlyByteBuf,
                pRecipe: IngotFusionTollEnhancerRecipe
            ) {
                try {
                    pRecipe.input1.toNetwork(pBuffer)
                    pRecipe.input2.toNetwork(pBuffer)
                    pRecipe.input3.toNetwork(pBuffer)
                    pBuffer.writeItem(pRecipe.result)
                } catch (e: IllegalStateException) {
                    throw IllegalStateException("Could not write recipe: ${pRecipe.id}", e)
                }
            }
        }
    }
}
