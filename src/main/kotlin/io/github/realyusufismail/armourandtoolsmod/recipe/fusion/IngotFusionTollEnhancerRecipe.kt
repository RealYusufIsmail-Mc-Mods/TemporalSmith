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
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookCategory
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.GsonHelper
import net.minecraft.world.Container
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.*
import net.minecraft.world.level.Level

/** @see */
class IngotFusionTollEnhancerRecipe(
    private val input1: Ingredient,
    private val input2: Ingredient,
    private val input3: Ingredient,
    val result: ItemStack,
    val craftTime: Int,
    private val experience: Float,
    val recipeCategory: IngotFusionTollEnhancerRecipeBookCategory,
    private val recipeId: ResourceLocation,
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
        return RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get()
    }

    companion object {

        class Serializer : RecipeSerializer<IngotFusionTollEnhancerRecipe> {
            override fun fromJson(
                pRecipeId: ResourceLocation,
                json: JsonObject
            ): IngotFusionTollEnhancerRecipe {

                try {
                    val ingredientArray = json.get("ingredients").asJsonArray
                    val inputs = NonNullList.withSize(3, Ingredient.EMPTY)

                    for (i in 0..2) {
                        val ingredient = ingredientArray[i].asJsonObject
                        inputs[i] = Ingredient.fromJson(ingredient)
                    }

                    val craftTime = GsonHelper.getAsInt(json, "crafttime")
                    val experience = GsonHelper.getAsFloat(json, "experience")
                    val recipeCategory =
                        IngotFusionTollEnhancerRecipeBookCategory.CODEC.byName(
                            GsonHelper.getAsString(json, "category", null as String?),
                            IngotFusionTollEnhancerRecipeBookCategory.MISC)

                    val result =
                        ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"))

                    return IngotFusionTollEnhancerRecipe(
                        inputs[0],
                        inputs[1],
                        inputs[2],
                        result,
                        craftTime,
                        experience,
                        recipeCategory,
                        pRecipeId)
                } catch (e: IllegalStateException) {
                    throw IllegalStateException("Could not create recipe: $pRecipeId", e)
                }
            }

            override fun fromNetwork(
                pRecipeId: ResourceLocation,
                pBuffer: FriendlyByteBuf
            ): IngotFusionTollEnhancerRecipe {
                try {

                    val input = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY)

                    for (i in input.indices) {
                        input[i] = Ingredient.fromNetwork(pBuffer)
                    }

                    val result = pBuffer.readItem()
                    val craftTime = pBuffer.readInt()
                    val experience = pBuffer.readFloat()
                    val recipeCategory =
                        pBuffer.readEnum(IngotFusionTollEnhancerRecipeBookCategory::class.java)

                    return IngotFusionTollEnhancerRecipe(
                        input[0],
                        input[1],
                        input[2],
                        result,
                        craftTime,
                        experience,
                        recipeCategory,
                        pRecipeId)
                } catch (e: IllegalStateException) {
                    throw IllegalStateException("Could not read recipe: $pRecipeId", e)
                }
            }

            override fun toNetwork(
                pBuffer: FriendlyByteBuf,
                pRecipe: IngotFusionTollEnhancerRecipe
            ) {
                try {
                    pBuffer.writeInt(pRecipe.getIngredients().size)

                    for (ingredient in pRecipe.getIngredients()) {
                        ingredient.toNetwork(pBuffer)
                    }

                    pBuffer.writeItem(pRecipe.result)
                    pBuffer.writeInt(pRecipe.craftTime)
                    pBuffer.writeFloat(pRecipe.experience)
                    pBuffer.writeEnum(pRecipe.recipeCategory)
                } catch (e: IllegalStateException) {
                    throw IllegalStateException("Could not write recipe: ${pRecipe.id}", e)
                }
            }
        }
    }
}
