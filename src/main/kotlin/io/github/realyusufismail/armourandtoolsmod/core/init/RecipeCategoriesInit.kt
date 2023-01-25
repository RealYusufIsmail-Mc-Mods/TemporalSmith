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
package io.github.realyusufismail.armourandtoolsmod.core.init

import com.google.common.base.Supplier
import com.google.common.base.Suppliers
import com.google.common.collect.ImmutableList
import io.github.realyusufismail.armourandtoolsmod.core.blocks.armour.CustomArmourCraftingTableRecipe
import net.minecraft.client.RecipeBookCategories
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent

object RecipeCategoriesInit {

    private val ARMOUR_CRAFTING_ARMOUR: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_ARMOUR", ItemStack(ItemInit.AQUMARINE_CHESTPLATE.get()))
        }

    private val ARMOUR_CRAFTING_SEARCH: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("ARMOUR_CRAFTING_SEARCH", ItemStack(Items.COMPASS))
        }

    private val ARMOUR_CRAFTING_MISC: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("ARMOUR_CRAFTING_MISC", ItemStack(Items.DIAMOND_SHOVEL))
        }

    fun registerRecipeBookCategories(event: RegisterRecipeBookCategoriesEvent) {
        event.registerBookCategories(
            RecipeBookTypesInit.ARMOUR_CRAFTING,
            ImmutableList.of(
                ARMOUR_CRAFTING_ARMOUR.get(),
                ARMOUR_CRAFTING_SEARCH.get(),
                ARMOUR_CRAFTING_MISC.get()))
        event.registerAggregateCategory(
            ARMOUR_CRAFTING_SEARCH.get(),
            ImmutableList.of(ARMOUR_CRAFTING_ARMOUR.get(), ARMOUR_CRAFTING_MISC.get()))
        event.registerRecipeCategoryFinder(RecipeTypeInit.ARMOUR_CRAFTING.get()) {
            if (it is CustomArmourCraftingTableRecipe) {
                return@registerRecipeCategoryFinder ARMOUR_CRAFTING_ARMOUR.get()
            } else {
                return@registerRecipeCategoryFinder ARMOUR_CRAFTING_MISC.get()
            }
        }
    }
}
