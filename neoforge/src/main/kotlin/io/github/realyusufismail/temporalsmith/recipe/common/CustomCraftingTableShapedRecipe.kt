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
package io.github.realyusufismail.temporalsmith.recipe.common

import io.github.realyusufismail.realyusufismailcore.recipe.util.EnchantmentsAndLevels
import io.github.realyusufismail.temporalsmith.blocks.common.CustomCraftingTableContainer
import io.github.realyusufismail.temporalsmith.recipe.pattern.CustomCraftingTableRecipePattern
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.util.StringRepresentable
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.Level
import net.neoforged.neoforge.common.CommonHooks
import net.neoforged.neoforge.common.crafting.IShapedRecipe

abstract class CustomCraftingTableShapedRecipe<T : CustomCraftingTableContainer>(
    open val gr: String,
    open val category: StringRepresentable,
    val recipePattern: CustomCraftingTableRecipePattern,
    open val result: ItemStack,
    open val showN: Boolean,
    open val enchantmentsAndLevels: EnchantmentsAndLevels,
    open val hideFlags: Int
) : IShapedRecipe<T> {
    val width: Int = recipePattern.width
    val height: Int = recipePattern.height

    override fun matches(p_44176_: T, p_44177_: Level): Boolean {
        return this.recipePattern.matches(p_44176_)
    }

    override fun assemble(
        p_44001_: T,
        p_267165_: RegistryAccess,
    ): ItemStack {
        return this.result.copy()
    }

    override fun canCraftInDimensions(pWidth: Int, pHeight: Int): Boolean {
        return true
    }

    /**
     * Get the result of this recipe, usually for display purposes (e.g. recipe book). If your
     * recipe has more than one possible result (e.g. it's dynamic and depends on its inputs), then
     * return an empty stack.
     */
    override fun getResultItem(p_267052_: RegistryAccess): ItemStack {
        return this.result
    }

    /** Recipes with equal group are combined into one button in the recipe book */
    override fun getGroup(): String {
        return this.gr
    }

    override fun getIngredients(): NonNullList<Ingredient> {
        return this.recipePattern.ingredients
    }

    override fun showNotification(): Boolean {
        return showN
    }

    override fun getRecipeWidth(): Int {
        return this.width
    }

    override fun getRecipeHeight(): Int {
        return this.height
    }

    override fun isIncomplete(): Boolean {
        val nonNullList: NonNullList<Ingredient> = this.ingredients
        return nonNullList.isEmpty() ||
            nonNullList
                .stream()
                .filter { ingredient: Ingredient -> !ingredient.isEmpty }
                .anyMatch { ingredient: Ingredient? -> CommonHooks.hasNoElements(ingredient) }
    }

    fun category(): StringRepresentable {
        return category
    }

    abstract override fun getSerializer(): RecipeSerializer<*>

    abstract override fun getToastSymbol(): ItemStack

    abstract class CustomCraftingTableShapedRecipeSerializer<
        T : CustomCraftingTableShapedRecipe<*>> : RecipeSerializer<T> {
        override fun toNetwork(
            pBuffer: FriendlyByteBuf,
            pRecipe: T,
        ) {
            pBuffer.writeVarInt(pRecipe.width)
            pBuffer.writeVarInt(pRecipe.height)
            pBuffer.writeUtf(pRecipe.gr)
            pRecipe.recipePattern.toNetwork(pBuffer)
            pRecipe.enchantmentsAndLevels.toNetwork(pBuffer)
            pBuffer.writeItem(pRecipe.result)
            pBuffer.writeBoolean(pRecipe.showN)
        }

        override fun fromNetwork(buffer: FriendlyByteBuf): T {
            val s = buffer.readUtf()
            val recipePattern = CustomCraftingTableRecipePattern.fromNetwork(buffer)
            val itemStack = buffer.readItem()
            val flag = buffer.readBoolean()
            val enchantmentsAndLevels = buffer.readJsonWithCodec(EnchantmentsAndLevels.getCodec())
            val hideFlags = buffer.readInt()

            return createRecipe(
                s, recipePattern, itemStack, flag, enchantmentsAndLevels, hideFlags, buffer)
        }

        abstract fun createRecipe(
            gr: String,
            recipePattern: CustomCraftingTableRecipePattern,
            result: ItemStack,
            showN: Boolean,
            enchantmentsAndLevels: EnchantmentsAndLevels,
            hideFlags: Int,
            buffer: FriendlyByteBuf
        ): T
    }

    companion object {
        @JvmField var MAX_WIDTH = 3
        @JvmField var MAX_HEIGHT = 3
    }
}
