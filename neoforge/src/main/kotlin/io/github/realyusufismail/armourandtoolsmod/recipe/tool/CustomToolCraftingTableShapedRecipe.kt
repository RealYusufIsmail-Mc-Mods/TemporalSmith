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
package io.github.realyusufismail.armourandtoolsmod.recipe.tool

import com.google.common.annotations.VisibleForTesting
import com.google.common.collect.Sets
import com.mojang.serialization.Codec
import com.mojang.serialization.DataResult
import io.github.realyusufismail.armourandtoolsmod.blocks.tool.CustomToolCraftingTableContainer
import io.github.realyusufismail.armourandtoolsmod.blocks.tool.book.CustomToolsCraftingBookCategory
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit
import io.github.realyusufismail.armourandtoolsmod.recipe.codec.CustomToolCraftingTableRawShapedRecipe
import kotlin.math.max
import kotlin.math.min
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.Level
import net.neoforged.neoforge.common.CommonHooks
import net.neoforged.neoforge.common.crafting.IShapedRecipe
import org.apache.commons.lang3.NotImplementedException

class CustomToolCraftingTableShapedRecipe(
    private val group: String,
    private val recipeCategory: CustomToolsCraftingBookCategory,
    private val width: Int,
    private val height: Int,
    private val recipeItems: NonNullList<Ingredient>,
    override val result: ItemStack,
    private val showNotification: Boolean,
) : CustomToolCraftingTableRecipe, IShapedRecipe<CustomToolCraftingTableContainer> {

    /** Used to check if a recipe matches current crafting inventory */
    override fun matches(pInv: CustomToolCraftingTableContainer, pLevel: Level): Boolean {
        for (i in 0..(pInv.getWidth() - this.width)) {
            for (j in 0..(pInv.getHeight() - this.height)) {
                if (this.matches(pInv, i, j, true)) {
                    return true
                }
                if (this.matches(pInv, i, j, false)) {
                    return true
                }
            }
        }
        return false
    }

    /** Checks if the region of a crafting inventory is match for the recipe. */
    private fun matches(
        pCraftingInventory: CustomToolCraftingTableContainer,
        pWidth: Int,
        pHeight: Int,
        pMirrored: Boolean,
    ): Boolean {
        for (i in 0 until pCraftingInventory.getWidth()) {
            for (j in 0 until pCraftingInventory.getHeight()) {
                val k = i - pWidth
                val l = j - pHeight
                var ingredient = Ingredient.EMPTY
                if ((k >= 0) && (l >= 0) && (k < this.width) && (l < this.height)) {
                    ingredient =
                        if (pMirrored) {
                            this.recipeItems[this.width - k - 1 + l * this.width]
                        } else {
                            this.recipeItems[k + l * this.width]
                        }
                }
                if (!ingredient.test(
                    pCraftingInventory.getItem(i + j * pCraftingInventory.getWidth()))) {
                    return false
                }
            }
        }
        return true
    }

    override fun assemble(
        p_44001_: CustomToolCraftingTableContainer,
        p_267165_: RegistryAccess
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
        return this.group
    }

    override fun getIngredients(): NonNullList<Ingredient> {
        return this.recipeItems
    }

    override fun category(): CustomToolsCraftingBookCategory {
        return recipeCategory
    }

    override fun getToastSymbol(): ItemStack {
        return ItemStack(BlockInit.CUSTOM_TOOL_CRAFTING_TABLE.get())
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return RecipeSerializerInit.CUSTOM_TOOL_CRAFTER.get()
    }

    override fun showNotification(): Boolean {
        return showNotification
    }

    override fun isIncomplete(): Boolean {
        val nonnulllist: NonNullList<Ingredient> = this.ingredients
        return nonnulllist.isEmpty() ||
            nonnulllist
                .stream()
                .filter { ingredient: Ingredient -> !ingredient.isEmpty }
                .anyMatch { ingredient: Ingredient? -> CommonHooks.hasNoElements(ingredient) }
    }

    override fun getRecipeWidth(): Int {
        return this.width
    }

    override fun getRecipeHeight(): Int {
        return this.height
    }

    companion object {

        @JvmField var MAX_WIDTH = 3

        @JvmField var MAX_HEIGHT = 3

        @VisibleForTesting
        @JvmStatic
        fun shrink(p_301102_: List<String>): Array<String?> {
            var i = Int.MAX_VALUE
            var j = 0
            var k = 0
            var l = 0
            for (i1 in p_301102_.indices) {
                val s = p_301102_[i1]
                i = min(i.toDouble(), firstNonSpace(s).toDouble()).toInt()
                val j1 = lastNonSpace(s)
                j = max(j.toDouble(), j1.toDouble()).toInt()
                if (j1 < 0) {
                    if (k == i1) {
                        ++k
                    }
                    ++l
                } else {
                    l = 0
                }
            }
            return if (p_301102_.size == l) {
                arrayOfNulls(0)
            } else {
                val astring = arrayOfNulls<String>(p_301102_.size - l - k)
                for (k1 in astring.indices) {
                    astring[k1] = p_301102_[k1 + k].substring(i, j + 1)
                }
                astring
            }
        }

        private fun firstNonSpace(pEntry: String): Int {
            var i = 0
            while (i < pEntry.length && pEntry[i] == ' ') {
                ++i
            }
            return i
        }

        private fun lastNonSpace(pEntry: String): Int {
            var i: Int = pEntry.length - 1
            while (i >= 0 && pEntry[i] == ' ') {
                --i
            }
            return i
        }
    }

    class Serializer : RecipeSerializer<CustomToolCraftingTableShapedRecipe> {
        private val CODEC =
            CustomToolCraftingTableRawShapedRecipe.CODEC.flatXmap({
                p_301248_: CustomToolCraftingTableRawShapedRecipe ->
                val astring = shrink(p_301248_.pattern)
                val i = astring[0]!!.length
                val j = astring.size
                val nonnulllist = NonNullList.withSize(i * j, Ingredient.EMPTY)
                val set: MutableSet<String> = Sets.newHashSet(p_301248_.key.keys)
                for (k in astring.indices) {
                    val s = astring[k]
                    for (l in 0 until s!!.length) {
                        val s1 = s.substring(l, l + 1)
                        val ingredient =
                            (if (s1 == " ") Ingredient.EMPTY else p_301248_.key[s1])
                                ?: return@flatXmap DataResult.error<
                                    CustomToolCraftingTableShapedRecipe> {
                                    "Pattern references symbol '$s1' but it's not defined in the key"
                                }
                        set.remove(s1)
                        nonnulllist[l + i * k] = ingredient
                    }
                }
                if (set.isNotEmpty()) {
                    return@flatXmap DataResult.error<CustomToolCraftingTableShapedRecipe> {
                        "Key defines symbols that aren't used in pattern: $set"
                    }
                } else {
                    val shapedrecipe =
                        CustomToolCraftingTableShapedRecipe(
                            p_301248_.group,
                            p_301248_.category,
                            i,
                            j,
                            nonnulllist,
                            p_301248_.result,
                            p_301248_.showNotification)
                    return@flatXmap DataResult.success<CustomToolCraftingTableShapedRecipe>(
                        shapedrecipe)
                }
            }) { _: CustomToolCraftingTableShapedRecipe ->
                throw NotImplementedException("Serializing ShapedRecipe is not implemented yet.")
            }

        override fun toNetwork(
            pBuffer: FriendlyByteBuf,
            pRecipe: CustomToolCraftingTableShapedRecipe,
        ) {
            pBuffer.writeVarInt(pRecipe.width)
            pBuffer.writeVarInt(pRecipe.height)
            pBuffer.writeUtf(pRecipe.group)

            for (ingredient: Ingredient in pRecipe.recipeItems) {
                ingredient.toNetwork(pBuffer)
            }

            pBuffer.writeItem(pRecipe.result)
            pBuffer.writeBoolean(pRecipe.showNotification)
        }

        override fun codec(): Codec<CustomToolCraftingTableShapedRecipe> {
            return CODEC
        }

        override fun fromNetwork(p_44106_: FriendlyByteBuf): CustomToolCraftingTableShapedRecipe? {
            val i = p_44106_.readVarInt()
            val j = p_44106_.readVarInt()
            val s = p_44106_.readUtf()
            val nonnulllist = NonNullList.withSize(i * j, Ingredient.EMPTY)
            nonnulllist.replaceAll { Ingredient.fromNetwork(p_44106_) }
            val itemstack = p_44106_.readItem()
            val craftingbookcategory =
                p_44106_.readEnum(CustomToolsCraftingBookCategory::class.java)
            val flag = p_44106_.readBoolean()

            return CustomToolCraftingTableShapedRecipe(
                s, craftingbookcategory, i, j, nonnulllist, itemstack, flag)
        }
    }
}
