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
import io.github.realyusufismail.armourandtoolsmod.core.blocks.tool.CustomToolCraftingTableRecipe
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

    private val ARMOUR_CRAFTING_HELMET: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("ARMOUR_CRAFTING_HELMET", ItemStack(Items.DIAMOND_HELMET))
        }

    private val ARMOUR_CRAFTING_CHESTPLATE: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_CHESTPLATE", ItemStack(Items.DIAMOND_CHESTPLATE))
        }

    private val ARMOUR_CRAFTING_LEGGINGS: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create(
                "ARMOUR_CRAFTING_LEGGINGS", ItemStack(Items.DIAMOND_LEGGINGS))
        }

    private val ARMOUR_CRAFTING_BOOTS: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("ARMOUR_CRAFTING_BOOTS", ItemStack(Items.DIAMOND_BOOTS))
        }

    private val ARMOUR_CRAFTING_MISC: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("ARMOUR_CRAFTING_MISC", ItemStack(Items.SHIELD))
        }

    private val ARMOUR_CRAFTING_ALL: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("ARMOUR_CRAFTING_ALL", ItemStack(Items.DIAMOND_CHESTPLATE))
        }

    // Tool
    private val TOOL_CRAFTING_TOOL: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_TOOL", ItemStack(ItemInit.RUBY_SWORD.get()))
        }

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

    private val TOOL_CRAFTING_MISC: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_MISC", ItemStack(Items.DIAMOND_SHOVEL))
        }

    private val TOOL_CRAFTING_ALL: Supplier<RecipeBookCategories> =
        Suppliers.memoize {
            RecipeBookCategories.create("TOOL_CRAFTING_ALL", ItemStack(Items.DIAMOND_SHOVEL))
        }

    fun registerRecipeBookCategories(event: RegisterRecipeBookCategoriesEvent) {
        event.registerBookCategories(
            RecipeBookTypesInit.ARMOUR_CRAFTING,
            ImmutableList.of(
                ARMOUR_CRAFTING_ARMOUR.get(),
                ARMOUR_CRAFTING_SEARCH.get(),
                ARMOUR_CRAFTING_HELMET.get(),
                ARMOUR_CRAFTING_CHESTPLATE.get(),
                ARMOUR_CRAFTING_LEGGINGS.get(),
                ARMOUR_CRAFTING_BOOTS.get(),
                ARMOUR_CRAFTING_MISC.get(),
                ARMOUR_CRAFTING_ALL.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_SEARCH.get(),
            ImmutableList.of(
                ARMOUR_CRAFTING_ARMOUR.get(),
                ARMOUR_CRAFTING_HELMET.get(),
                ARMOUR_CRAFTING_CHESTPLATE.get(),
                ARMOUR_CRAFTING_LEGGINGS.get(),
                ARMOUR_CRAFTING_BOOTS.get(),
                ARMOUR_CRAFTING_MISC.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_ALL.get(),
            ImmutableList.of(
                ARMOUR_CRAFTING_ARMOUR.get(),
                ARMOUR_CRAFTING_HELMET.get(),
                ARMOUR_CRAFTING_CHESTPLATE.get(),
                ARMOUR_CRAFTING_LEGGINGS.get(),
                ARMOUR_CRAFTING_BOOTS.get(),
                ARMOUR_CRAFTING_MISC.get()))

        event.registerAggregateCategory(
            ARMOUR_CRAFTING_ARMOUR.get(),
            ImmutableList.of(
                ARMOUR_CRAFTING_HELMET.get(),
                ARMOUR_CRAFTING_CHESTPLATE.get(),
                ARMOUR_CRAFTING_LEGGINGS.get(),
                ARMOUR_CRAFTING_BOOTS.get()))

        // TODO: Have a look later
        event.registerRecipeCategoryFinder(RecipeTypeInit.ARMOUR_CRAFTING.get()) { it ->
            if (it is CustomToolCraftingTableRecipe) {
                return@registerRecipeCategoryFinder ARMOUR_CRAFTING_ARMOUR.get()
            } else {
                return@registerRecipeCategoryFinder ARMOUR_CRAFTING_MISC.get()
            }
        }

        event.registerBookCategories(
            RecipeBookTypesInit.TOOL_CRAFTING,
            ImmutableList.of(
                TOOL_CRAFTING_TOOL.get(),
                TOOL_CRAFTING_SEARCH.get(),
                TOOL_CRAFTING_SWORD.get(),
                TOOL_CRAFTING_PICKAXE.get(),
                TOOL_CRAFTING_AXE.get(),
                TOOL_CRAFTING_SHOVEL.get(),
                TOOL_CRAFTING_HOE.get(),
                TOOL_CRAFTING_MISC.get(),
                TOOL_CRAFTING_ALL.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_SEARCH.get(),
            ImmutableList.of(
                TOOL_CRAFTING_TOOL.get(),
                TOOL_CRAFTING_SWORD.get(),
                TOOL_CRAFTING_PICKAXE.get(),
                TOOL_CRAFTING_AXE.get(),
                TOOL_CRAFTING_SHOVEL.get(),
                TOOL_CRAFTING_HOE.get(),
                TOOL_CRAFTING_MISC.get(),
                TOOL_CRAFTING_ALL.get()))

        event.registerAggregateCategory(
            TOOL_CRAFTING_ALL.get(),
            ImmutableList.of(
                TOOL_CRAFTING_TOOL.get(),
                TOOL_CRAFTING_SWORD.get(),
                TOOL_CRAFTING_PICKAXE.get(),
                TOOL_CRAFTING_AXE.get(),
                TOOL_CRAFTING_SHOVEL.get(),
                TOOL_CRAFTING_HOE.get(),
                TOOL_CRAFTING_MISC.get()))

        event.registerRecipeCategoryFinder(RecipeTypeInit.TOOL_CRAFTING.get()) {
            if (it is CustomToolCraftingTableRecipe) {
                return@registerRecipeCategoryFinder TOOL_CRAFTING_TOOL.get()
            } else {
                return@registerRecipeCategoryFinder TOOL_CRAFTING_MISC.get()
            }
        }
    }
}
