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
package io.github.realyusufismail.armourandtoolsmod.core.init

import com.google.common.base.Supplier
import com.google.common.base.Suppliers
import com.google.common.collect.ImmutableList
import io.github.realyusufismail.armourandtoolsmod.blocks.armour.book.CustomArmourCraftingBookCategory
import io.github.realyusufismail.armourandtoolsmod.blocks.tool.book.CustomToolsCraftingBookCategory
import io.github.realyusufismail.armourandtoolsmod.recipe.armour.CustomArmourCraftingTableRecipe
import io.github.realyusufismail.armourandtoolsmod.recipe.tool.CustomToolCraftingTableRecipe
import net.minecraft.client.RecipeBookCategories
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent

object RecipeCategoriesInit {

    private val ARMOUR_CRAFTING_SEARCH: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("ARMOUR_CRAFTING", ItemStack(Items.COMPASS))
        }

    private val ARMOUR_CRAFTING_HELMET: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_HELMET", ItemStack(ItemInit.AQUMARINE_HELMET.get()))
        }

    private val ARMOUR_CRAFTING_CHESTPLATE: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_CHESTPLATE", ItemStack(ItemInit.AQUMARINE_CHESTPLATE.get()))
        }

    private val ARMOUR_CRAFTING_LEGGINGS: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_LEGGINGS", ItemStack(ItemInit.AQUMARINE_LEGGINGS.get()))
        }

    private val ARMOUR_CRAFTING_BOOTS: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_BOOTS", ItemStack(ItemInit.AQUMARINE_BOOTS.get()))
        }

    private val ARMOUR_CRAFTING_MISC: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_MISC", ItemStack(ItemInit.AQUMARINE_HELMET.get()))
        }

    // Tool
    private val TOOL_CRAFTING_SEARCH: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_SEARCH", ItemStack(Items.COMPASS))
        }

    private val TOOL_CRAFTING_SWORD: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_SWORD", ItemStack(Items.DIAMOND_SWORD))
        }

    private val TOOL_CRAFTING_PICKAXE: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_PICKAXE", ItemStack(Items.DIAMOND_PICKAXE))
        }

    private val TOOL_CRAFTING_AXE: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_AXE", ItemStack(Items.DIAMOND_AXE))
        }

    private val TOOL_CRAFTING_SHOVEL: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_SHOVEL", ItemStack(Items.DIAMOND_SHOVEL))
        }

    private val TOOL_CRAFTING_HOE: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_HOE", ItemStack(Items.DIAMOND_HOE))
        }

    private val TOOL_CRAFTING_SHIELD: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_SHIELD", ItemStack(Items.SHIELD))
        }

    private val TOOL_CRAFTING_TRIDENT: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_TRIDENT", ItemStack(Items.TRIDENT))
        }

    private val TOOL_CRAFTING_MISC: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_MISC", ItemStack(Items.DIAMOND_SHOVEL))
        }

    fun registerRecipeBookCategories(event: RegisterRecipeBookCategoriesEvent) {
        event.registerBookCategories(
            RecipeBookTypesInit.ARMOUR_CRAFTING,
            ImmutableList.of(
                ARMOUR_CRAFTING_SEARCH.get(),
                ARMOUR_CRAFTING_HELMET.get(),
                ARMOUR_CRAFTING_CHESTPLATE.get(),
                ARMOUR_CRAFTING_LEGGINGS.get(),
                ARMOUR_CRAFTING_BOOTS.get(),
                ARMOUR_CRAFTING_MISC.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_SEARCH.get(),
            ImmutableList.of(
                ARMOUR_CRAFTING_HELMET.get(),
                ARMOUR_CRAFTING_CHESTPLATE.get(),
                ARMOUR_CRAFTING_LEGGINGS.get(),
                ARMOUR_CRAFTING_BOOTS.get(),
                ARMOUR_CRAFTING_MISC.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_HELMET.get(), listOf(ARMOUR_CRAFTING_HELMET.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_CHESTPLATE.get(), listOf(ARMOUR_CRAFTING_CHESTPLATE.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_LEGGINGS.get(), listOf(ARMOUR_CRAFTING_LEGGINGS.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_BOOTS.get(), listOf(ARMOUR_CRAFTING_BOOTS.get()))

        event.registerRecipeCategoryFinder(RecipeTypeInit.ARMOUR_CRAFTING.get()) {
            if (it is CustomArmourCraftingTableRecipe) {
                when (it.category()) {
                    CustomArmourCraftingBookCategory.ARMOUR_HEAD -> ARMOUR_CRAFTING_HELMET.get()
                    CustomArmourCraftingBookCategory.ARMOUR_CHEST ->
                        ARMOUR_CRAFTING_CHESTPLATE.get()
                    CustomArmourCraftingBookCategory.ARMOUR_LEGS -> ARMOUR_CRAFTING_LEGGINGS.get()
                    CustomArmourCraftingBookCategory.ARMOUR_FEET -> ARMOUR_CRAFTING_BOOTS.get()
                    else -> {
                        ARMOUR_CRAFTING_MISC.get()
                    }
                }
            } else {
                ARMOUR_CRAFTING_MISC.get()
            }
        }

        event.registerBookCategories(
            RecipeBookTypesInit.TOOL_CRAFTING,
            ImmutableList.of(
                TOOL_CRAFTING_SEARCH.get(),
                TOOL_CRAFTING_SWORD.get(),
                TOOL_CRAFTING_PICKAXE.get(),
                TOOL_CRAFTING_AXE.get(),
                TOOL_CRAFTING_SHOVEL.get(),
                TOOL_CRAFTING_HOE.get(),
                TOOL_CRAFTING_SHIELD.get(),
                TOOL_CRAFTING_TRIDENT.get(),
                TOOL_CRAFTING_MISC.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_SEARCH.get(),
            ImmutableList.of(
                TOOL_CRAFTING_SWORD.get(),
                TOOL_CRAFTING_PICKAXE.get(),
                TOOL_CRAFTING_AXE.get(),
                TOOL_CRAFTING_SHOVEL.get(),
                TOOL_CRAFTING_HOE.get(),
                TOOL_CRAFTING_SHIELD.get(),
                TOOL_CRAFTING_TRIDENT.get(),
                TOOL_CRAFTING_MISC.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_SWORD.get(), listOf(TOOL_CRAFTING_SWORD.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_PICKAXE.get(), listOf(TOOL_CRAFTING_PICKAXE.get()))

        event.registerAggregateCategory(TOOL_CRAFTING_AXE.get(), listOf(TOOL_CRAFTING_AXE.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_SHOVEL.get(), listOf(TOOL_CRAFTING_SHOVEL.get()))

        event.registerAggregateCategory(TOOL_CRAFTING_HOE.get(), listOf(TOOL_CRAFTING_HOE.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_SHIELD.get(), listOf(TOOL_CRAFTING_SHIELD.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_TRIDENT.get(), listOf(TOOL_CRAFTING_TRIDENT.get()))

        event.registerAggregateCategory(TOOL_CRAFTING_MISC.get(), listOf(TOOL_CRAFTING_MISC.get()))

        event.registerRecipeCategoryFinder(RecipeTypeInit.TOOL_CRAFTING.get()) {
            if (it is CustomToolCraftingTableRecipe) {
                when (it.category()) {
                    CustomToolsCraftingBookCategory.SWORD -> TOOL_CRAFTING_SWORD.get()
                    CustomToolsCraftingBookCategory.PICKAXE -> TOOL_CRAFTING_PICKAXE.get()
                    CustomToolsCraftingBookCategory.AXE -> TOOL_CRAFTING_AXE.get()
                    CustomToolsCraftingBookCategory.SHOVEL -> TOOL_CRAFTING_SHOVEL.get()
                    CustomToolsCraftingBookCategory.HOE -> TOOL_CRAFTING_HOE.get()
                    CustomToolsCraftingBookCategory.MISC -> TOOL_CRAFTING_MISC.get()
                    CustomToolsCraftingBookCategory.SHIELD -> TOOL_CRAFTING_SHIELD.get()
                    CustomToolsCraftingBookCategory.TRIDENT -> TOOL_CRAFTING_TRIDENT.get()
                }
            } else {
                TOOL_CRAFTING_MISC.get()
            }
        }
    }
}
