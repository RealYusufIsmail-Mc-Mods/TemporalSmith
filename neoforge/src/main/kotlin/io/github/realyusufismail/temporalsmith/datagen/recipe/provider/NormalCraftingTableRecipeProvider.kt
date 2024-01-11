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
package io.github.realyusufismail.temporalsmith.datagen.recipe.provider

import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.util.name
import io.github.realyusufismail.temporalsmith.datagen.recipe.MainModRecipeProvider
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks

class NormalCraftingTableRecipeProvider(
    private val mainModRecipeProvider: MainModRecipeProvider,
    private val pWriter: RecipeOutput
) : MainModRecipeProvider(mainModRecipeProvider) {

    fun build() {
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockInit.CUSTOM_ARMOUR_CRAFTING_TABLE.get())
            .define('A', Blocks.IRON_BLOCK)
            .define('B', Blocks.CRAFTING_TABLE)
            .define('C', Items.IRON_CHESTPLATE)
            .pattern("ACA")
            .pattern(" B ")
            .unlockedBy("has_item", has(Items.IRON_CHESTPLATE))
            .save(pWriter, modId("custom_armour_crafting_table_recipe"))

        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockInit.CUSTOM_TOOL_CRAFTING_TABLE.get())
            .define('A', Blocks.IRON_BLOCK)
            .define('B', Blocks.CRAFTING_TABLE)
            .define('C', Items.IRON_PICKAXE)
            .pattern("ACA")
            .pattern(" B ")
            .unlockedBy("has_item", has(Items.IRON_PICKAXE))
            .save(pWriter, modId("custom_tool_crafting_table_recipe"))

        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockInit.INGOT_FUSION_TOLL_ENHANCER.get())
            .define('A', Blocks.IRON_BLOCK)
            .define('B', Items.IRON_INGOT)
            .define('C', ItemTags.create(BlockTags.BASE_STONE_OVERWORLD.location))
            .pattern("ABA")
            .pattern("CBC")
            .pattern("CBC")
            .unlockedBy("has_item", has(Items.IRON_INGOT))
            .save(pWriter, modId("ingot_fusion_toll_enhancer_recipe"))

        addOreBlockRecipes()
    }

    private fun addOreBlockRecipes() {
        // scan BlockInit for Blocks that return OreBlockObjectHolderDelegate
        BlockInit.ORE_BLOCKS.forEach { oreBlock ->
            // create a shapeless recipe for the ore block
            ShapelessRecipeBuilder.shapeless(
                    RecipeCategory.BUILDING_BLOCKS, oreBlock.value.get(), 9)
                .requires(oreBlock.key.get())
                .unlockedBy("has_item", has(oreBlock.value.get()))
                .save(pWriter, modId(oreBlock.value.get().name + "_block_recipe"))
        }
    }
}
