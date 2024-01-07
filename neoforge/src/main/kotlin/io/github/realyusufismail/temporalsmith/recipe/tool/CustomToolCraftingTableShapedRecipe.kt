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
package io.github.realyusufismail.temporalsmith.recipe.tool

import com.google.common.annotations.VisibleForTesting
import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.github.realyusufismail.realyusufismailcore.recipe.util.EnchantmentsAndLevels
import io.github.realyusufismail.temporalsmith.blocks.tool.CustomToolCraftingTableContainer
import io.github.realyusufismail.temporalsmith.blocks.tool.book.CustomToolsCraftingBookCategory
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.RecipeSerializerInit
import io.github.realyusufismail.temporalsmith.recipe.pattern.CustomCraftingTableRecipePattern
import io.github.realyusufismail.temporalsmith.recipe.tool.builder.CustomToolCraftingTableRecipeBuilder
import kotlin.math.max
import kotlin.math.min
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.util.ExtraCodecs
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.Level
import net.neoforged.neoforge.common.CommonHooks
import net.neoforged.neoforge.common.crafting.IShapedRecipe

class CustomToolCraftingTableShapedRecipe(
    val gr: String,
    val recipeCategory: CustomToolsCraftingBookCategory,
    val recipePattern: CustomCraftingTableRecipePattern,
    override val result: ItemStack,
    val showN: Boolean,
    enchantmentsAndLevels: EnchantmentsAndLevels,
    hideFlags: Int,
) : CustomToolCraftingTableRecipe, IShapedRecipe<CustomToolCraftingTableContainer> {

    override fun matches(p_44176_: CustomToolCraftingTableContainer, p_44177_: Level): Boolean {
        return this.recipePattern.matchesTool(p_44176_)
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
        return this.recipePattern.ingredients
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
        return showN
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
        return this.recipePattern.width
    }

    override fun getRecipeHeight(): Int {
        return this.recipePattern.height
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
        companion object {
            val CODEC: Codec<CustomToolCraftingTableShapedRecipe> =
                RecordCodecBuilder.create { instance ->
                    instance
                        .group(
                            ExtraCodecs.strictOptionalField(Codec.STRING, "group", "")
                                .forGetter(CustomToolCraftingTableShapedRecipe::getGroup),
                            CustomToolsCraftingBookCategory.CODEC.fieldOf("category")
                                .orElse(CustomToolsCraftingBookCategory.MISC)
                                .forGetter(CustomToolCraftingTableShapedRecipe::category),
                            CustomCraftingTableRecipePattern.MAP_CODEC.forGetter(
                                CustomToolCraftingTableShapedRecipe::recipePattern),
                            ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result")
                                .forGetter(CustomToolCraftingTableShapedRecipe::result),
                            ExtraCodecs.strictOptionalField(
                                Codec.BOOL, "show_notification", true)
                                .forGetter(
                                    CustomToolCraftingTableShapedRecipe::showNotification),
                        )
                        .apply(instance, ::CustomToolCraftingTableShapedRecipe
                        )
                }
                    .apply { stable() }
        }

        override fun codec(): Codec<CustomToolCraftingTableShapedRecipe> {
            return CODEC
        }

        override fun toNetwork(
            pBuffer: FriendlyByteBuf,
            pRecipe: CustomToolCraftingTableShapedRecipe,
        ) {
            pBuffer.writeVarInt(pRecipe.recipeWidth)
            pBuffer.writeVarInt(pRecipe.recipeHeight)
            pBuffer.writeUtf(pRecipe.gr)
            pRecipe.recipePattern.toNetwork(pBuffer)

            pBuffer.writeItem(pRecipe.result)
            pBuffer.writeBoolean(pRecipe.showN)
        }

        override fun fromNetwork(p_44240_: FriendlyByteBuf): CustomToolCraftingTableShapedRecipe {
            val s = p_44240_.readUtf()
            val craftingbookcategory =
                p_44240_.readEnum(CustomToolsCraftingBookCategory::class.java)
            val shapedrecipepattern = CustomCraftingTableRecipePattern.fromNetwork(p_44240_)
            val itemstack = p_44240_.readItem()
            val flag = p_44240_.readBoolean()
            return CustomToolCraftingTableShapedRecipe(
                s,
                craftingbookcategory,
                shapedrecipepattern,
                itemstack,
                flag,
                CustomToolCraftingTableRecipeBuilder.enchantmentsAndLevels,
                CustomToolCraftingTableRecipeBuilder.hideFlags
            )
        }
    }
}
