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
package io.github.realyusufismail.armourandtoolsmod.core.blocks.armour

import com.google.common.annotations.VisibleForTesting
import com.google.common.collect.Maps
import com.google.common.collect.Sets
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSyntaxException
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.GsonHelper
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.Level
import net.minecraftforge.common.ForgeHooks
import net.minecraftforge.common.crafting.CraftingHelper

/** @see io.github.realyusufismail.realyusufismailcore.recipe.YusufShapedRecipeBuilder */
class CustomArmourCraftingTableShapedRecipe(
    private val id: ResourceLocation,
    private val group: String,
    private val width: Int,
    private val height: Int,
    private val recipeItems: NonNullList<Ingredient>,
    private val result: ItemStack,
) : CustomArmourCraftingTableRecipe, Recipe<CustomArmourCraftingTableContainer> {
    /** Used to check if a recipe matches current crafting inventory */
    override fun matches(pInv: CustomArmourCraftingTableContainer, pLevel: Level): Boolean {
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
        pCraftingInventory: CustomArmourCraftingTableContainer,
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
        p_44001_: CustomArmourCraftingTableContainer,
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

    override fun getId(): ResourceLocation {
        return this.id
    }

    override fun getToastSymbol(): ItemStack {
        return ItemStack(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get())
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return RecipeSerializerInit.CUSTOM_ARMOUR_CRAFTER.get()
    }

    override fun isIncomplete(): Boolean {
        val nonnulllist: NonNullList<Ingredient> = this.ingredients
        return nonnulllist.isEmpty() ||
            nonnulllist
                .stream()
                .filter { ingredient: Ingredient -> !ingredient.isEmpty }
                .anyMatch { ingredient: Ingredient? -> ForgeHooks.hasNoElements(ingredient) }
    }

    companion object {
        private var MAX_WIDTH = 3
        private var MAX_HEIGHT = 3

        @VisibleForTesting
        fun shrink(vararg pToShrink: String?): Array<String?> {
            var i = Int.MAX_VALUE
            var j = 0
            var k = 0
            var l = 0
            for (i1 in pToShrink.indices) {
                val s = pToShrink[i1]
                i = i.coerceAtMost(firstNonSpace(s!!))
                val j1 = lastNonSpace(s)
                j = j.coerceAtLeast(j1)
                if (j1 < 0) {
                    if (k == i1) {
                        ++k
                    }
                    ++l
                } else {
                    l = 0
                }
            }
            return if (pToShrink.size == l) {
                arrayOfNulls(0)
            } else {
                val astring = arrayOfNulls<String>(pToShrink.size - l - k)
                for (k1 in astring.indices) {
                    astring[k1] = pToShrink[k1 + k]?.substring(i, j + 1)
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

        fun patternFromJson(pPatternArray: JsonArray): Array<String?> {
            val astring = arrayOfNulls<String>(pPatternArray.size())
            if (astring.size > MAX_HEIGHT) {
                throw JsonSyntaxException("Invalid pattern: too many rows, $MAX_HEIGHT is maximum")
            } else if (astring.isEmpty()) {
                throw JsonSyntaxException("Invalid pattern: empty pattern not allowed")
            } else {
                for (i in astring.indices) {
                    val s = GsonHelper.convertToString(pPatternArray.get(i), "pattern[$i]")
                    if (s.length > MAX_WIDTH) {
                        throw JsonSyntaxException(
                            "Invalid pattern: too many columns, $MAX_WIDTH is maximum")
                    }
                    if (i > 0 && astring[0]!!.length != s.length) {
                        throw JsonSyntaxException(
                            "Invalid pattern: each row must be the same width")
                    }
                    astring[i] = s
                }
                return astring
            }
        }

        /** Returns a key json object as a Java HashMap. */
        fun keyFromJson(pKeyEntry: JsonObject): MutableMap<String, Ingredient> {
            val map: MutableMap<String, Ingredient> = Maps.newHashMap()
            for (entry: Map.Entry<String, JsonElement> in pKeyEntry.entrySet()) {
                if (entry.key.length != 1) {
                    throw JsonSyntaxException(
                        "Invalid key entry: '" +
                            entry.key +
                            "' is an invalid symbol (must be 1 character only).")
                }
                if ((" " == entry.key)) {
                    throw JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.")
                }
                map[entry.key] = Ingredient.fromJson(entry.value)
            }
            map[" "] = Ingredient.EMPTY
            return map
        }

        fun itemStackFromJson(pStackObject: JsonObject): ItemStack {
            return CraftingHelper.getItemStack(pStackObject, true, true)
        }

        fun dissolvePattern(
            pPattern: Array<String?>,
            pKeys: Map<String, Ingredient>,
            pPatternWidth: Int,
            pPatternHeight: Int,
        ): NonNullList<Ingredient> {
            val nonnulllist = NonNullList.withSize(pPatternWidth * pPatternHeight, Ingredient.EMPTY)
            val set: MutableSet<String> = Sets.newHashSet(pKeys.keys)
            set.remove(" ")
            for (i in pPattern.indices) {
                for (j in 0 until (pPattern[i]?.length ?: 0)) {
                    val s = pPattern[i]?.substring(j, j + 1)
                    val ingredient =
                        pKeys[s]
                            ?: throw JsonSyntaxException(
                                ("Pattern references symbol '" +
                                    s +
                                    "' but it's not defined in the key"))
                    set.remove(s)
                    nonnulllist[j + pPatternWidth * i] = ingredient
                }
            }
            if (set.isNotEmpty()) {
                throw JsonSyntaxException("Key defines symbols that aren't used in pattern: $set")
            } else {
                return nonnulllist
            }
        }
    }

    class Serializer : RecipeSerializer<CustomArmourCraftingTableShapedRecipe> {
        override fun fromJson(
            pRecipeId: ResourceLocation,
            pJson: JsonObject,
        ): CustomArmourCraftingTableShapedRecipe {
            val s: String = GsonHelper.getAsString(pJson, "group", "")!!

            val map: Map<String, Ingredient> = keyFromJson(GsonHelper.getAsJsonObject(pJson, "key"))

            val astring: Array<String?> =
                shrink(*patternFromJson(GsonHelper.getAsJsonArray(pJson, "pattern")))

            val i = astring[0]?.length
            val j = astring.size
            val nonnulllist: NonNullList<Ingredient> = dissolvePattern(astring, map, i!!, j)

            val itemstack: ItemStack =
                itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"))

            return CustomArmourCraftingTableShapedRecipe(pRecipeId, s, i, j, nonnulllist, itemstack)
        }

        override fun fromNetwork(
            pRecipeId: ResourceLocation,
            pBuffer: FriendlyByteBuf,
        ): CustomArmourCraftingTableShapedRecipe {
            val i = pBuffer.readVarInt()
            val j = pBuffer.readVarInt()
            val s = pBuffer.readUtf()
            val nonnulllist = NonNullList.withSize(i * j, Ingredient.EMPTY)
            nonnulllist.replaceAll { Ingredient.fromNetwork(pBuffer) }
            val itemstack = pBuffer.readItem()
            return CustomArmourCraftingTableShapedRecipe(pRecipeId, s, i, j, nonnulllist, itemstack)
        }

        override fun toNetwork(
            pBuffer: FriendlyByteBuf,
            pRecipe: CustomArmourCraftingTableShapedRecipe,
        ) {
            pBuffer.writeVarInt(pRecipe.width)
            pBuffer.writeVarInt(pRecipe.height)
            pBuffer.writeUtf(pRecipe.group)
            for (ingredient: Ingredient in pRecipe.recipeItems) {
                ingredient.toNetwork(pBuffer)
            }
            pBuffer.writeItem(pRecipe.result)
        }
    }
}
