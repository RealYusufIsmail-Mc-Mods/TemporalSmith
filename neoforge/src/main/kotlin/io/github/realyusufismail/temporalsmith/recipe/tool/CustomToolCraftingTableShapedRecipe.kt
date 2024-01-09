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

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.github.realyusufismail.realyusufismailcore.recipe.util.EnchantmentsAndLevels
import io.github.realyusufismail.temporalsmith.blocks.tool.CustomToolCraftingTableContainer
import io.github.realyusufismail.temporalsmith.blocks.tool.book.CustomToolsCraftingBookCategory
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.RecipeSerializerInit
import io.github.realyusufismail.temporalsmith.recipe.common.CustomCraftingTableShapedRecipe
import io.github.realyusufismail.temporalsmith.recipe.pattern.CustomCraftingTableRecipePattern
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.util.ExtraCodecs
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.RecipeSerializer

class CustomToolCraftingTableShapedRecipe(
    gr: String,
    override val category: CustomToolsCraftingBookCategory,
    recipePattern: CustomCraftingTableRecipePattern,
    result: ItemStack,
    showN: Boolean,
    enchantmentsAndLevels: EnchantmentsAndLevels,
    hideFlags: Int,
) :
    CustomCraftingTableShapedRecipe<CustomToolCraftingTableContainer>(
        gr, category, recipePattern, result, showN, enchantmentsAndLevels, hideFlags),
    CustomToolCraftingTableRecipe {

    override fun getToastSymbol(): ItemStack {
        return ItemStack(BlockInit.CUSTOM_TOOL_CRAFTING_TABLE.get())
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return RecipeSerializerInit.CUSTOM_TOOL_CRAFTER.get()
    }

    class Serializer :
        CustomCraftingTableShapedRecipeSerializer<CustomToolCraftingTableShapedRecipe>() {
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
                                EnchantmentsAndLevels.getCodec()
                                    .fieldOf("enchantments")
                                    .forGetter(
                                        CustomToolCraftingTableShapedRecipe::enchantmentsAndLevels),
                                Codec.INT.fieldOf("hide_flags")
                                    .orElse(0)
                                    .forGetter(CustomToolCraftingTableShapedRecipe::hideFlags))
                            .apply(instance, ::CustomToolCraftingTableShapedRecipe)
                    }
                    .apply { stable() }
        }

        override fun codec(): Codec<CustomToolCraftingTableShapedRecipe> {
            return CODEC
        }

        override fun createRecipe(
            gr: String,
            recipePattern: CustomCraftingTableRecipePattern,
            result: ItemStack,
            showN: Boolean,
            enchantmentsAndLevels: EnchantmentsAndLevels,
            hideFlags: Int,
            buffer: FriendlyByteBuf
        ): CustomToolCraftingTableShapedRecipe {
            val craftingBookCategory = buffer.readEnum(CustomToolsCraftingBookCategory::class.java)
            return CustomToolCraftingTableShapedRecipe(
                gr,
                craftingBookCategory,
                recipePattern,
                result,
                showN,
                enchantmentsAndLevels,
                hideFlags)
        }
    }
}
