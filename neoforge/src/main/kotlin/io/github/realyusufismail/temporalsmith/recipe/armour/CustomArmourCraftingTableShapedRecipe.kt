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
package io.github.realyusufismail.temporalsmith.recipe.armour

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.github.realyusufismail.realyusufismailcore.recipe.util.EnchantmentsAndLevels
import io.github.realyusufismail.temporalsmith.blocks.armour.CustomArmourCraftingTableContainer
import io.github.realyusufismail.temporalsmith.blocks.armour.book.CustomArmourCraftingBookCategory
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.RecipeSerializerInit
import io.github.realyusufismail.temporalsmith.recipe.common.CustomCraftingTableShapedRecipe
import io.github.realyusufismail.temporalsmith.recipe.pattern.CustomCraftingTableRecipePattern
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.util.ExtraCodecs
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.*

class CustomArmourCraftingTableShapedRecipe(
    gr: String,
    override val category: CustomArmourCraftingBookCategory,
    recipePattern: CustomCraftingTableRecipePattern,
    result: ItemStack,
    showN: Boolean,
    enchantmentsAndLevels: EnchantmentsAndLevels,
    hideFlags: Int,
) :
    CustomCraftingTableShapedRecipe<CustomArmourCraftingTableContainer>(
        gr, category, recipePattern, result, showN, enchantmentsAndLevels, hideFlags),
    CustomArmourCraftingTableRecipe {

    override fun getCategory(): CustomArmourCraftingBookCategory {
        return category
    }

    override fun getToastSymbol(): ItemStack {
        return ItemStack(BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get())
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return RecipeSerializerInit.CUSTOM_ARMOUR_CRAFTER.get()
    }

    class Serializer :
        CustomCraftingTableShapedRecipeSerializer<CustomArmourCraftingTableShapedRecipe>() {
        companion object {
            val CODEC: Codec<CustomArmourCraftingTableShapedRecipe> =
                RecordCodecBuilder.create { instance ->
                        instance
                            .group(
                                ExtraCodecs.strictOptionalField(Codec.STRING, "group", "")
                                    .forGetter(CustomArmourCraftingTableShapedRecipe::getGroup),
                                CustomArmourCraftingBookCategory.CODEC.fieldOf("category")
                                    .orElse(CustomArmourCraftingBookCategory.MISC)
                                    .forGetter(CustomArmourCraftingTableShapedRecipe::category),
                                CustomCraftingTableRecipePattern.MAP_CODEC.forGetter(
                                    CustomArmourCraftingTableShapedRecipe::recipePattern),
                                ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result")
                                    .forGetter(CustomArmourCraftingTableShapedRecipe::result),
                                ExtraCodecs.strictOptionalField(
                                        Codec.BOOL, "show_notification", true)
                                    .forGetter(
                                        CustomArmourCraftingTableShapedRecipe::showNotification),
                                EnchantmentsAndLevels.getCodec()
                                    .fieldOf("enchantments")
                                    .forGetter(
                                        CustomArmourCraftingTableShapedRecipe::
                                            enchantmentsAndLevels),
                                Codec.INT.fieldOf("hide_flags")
                                    .orElse(0)
                                    .forGetter(CustomArmourCraftingTableShapedRecipe::hideFlags))
                            .apply(instance, ::CustomArmourCraftingTableShapedRecipe)
                    }
                    .apply { stable() }
        }

        override fun codec(): Codec<CustomArmourCraftingTableShapedRecipe> {
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
        ): CustomArmourCraftingTableShapedRecipe {
            val craftingBookCategory = buffer.readEnum(CustomArmourCraftingBookCategory::class.java)
            return CustomArmourCraftingTableShapedRecipe(
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
