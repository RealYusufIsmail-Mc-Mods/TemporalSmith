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
package io.github.realyusufismail.armourandtoolsmod.blocks.infusion.book

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerBlockEntity
import net.minecraft.client.gui.components.WidgetSprites
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent
import net.minecraft.world.inventory.Slot
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeHolder

class IngotFusionTollEnhancerRecipeBookComponent : RecipeBookComponent() {
    private var fuels: Ingredient? = null
    private val fuelItems = IngotFusionTollEnhancerBlockEntity.getFuels().keys

    // TODO : Check how this works
    private val FILTER_SPRITES =
        WidgetSprites(
            ArmourAndToolsMod.getModIdAndName(
                "sprites/recipe_book/ingot_fusion_toll_enhancer_filter_enabled"),
            ArmourAndToolsMod.getModIdAndName(
                "sprites/recipe_book/ingot_fusion_toll_enhancer_filter_disabled"),
            ArmourAndToolsMod.getModIdAndName(
                "sprites/recipe_book/ingot_fusion_toll_enhancer_filter_enabled_highlighted"),
            ArmourAndToolsMod.getModIdAndName(
                "sprites/recipe_book/ingot_fusion_toll_enhancer_filter_disabled_highlighted"))

    override fun initFilterButtonTextures() {
        filterButton.initTextureValues(FILTER_SPRITES)
    }

    override fun slotClicked(pSlot: Slot?) {
        super.slotClicked(pSlot)
        if (pSlot != null && pSlot.index < menu.size) {
            ghostRecipe.clear()
        }
    }

    override fun setupGhostRecipe(recipeHolder: RecipeHolder<*>, pSlots: List<Slot>) {
        val itemstack = recipeHolder.value.getResultItem(minecraft.level!!.registryAccess())
        ghostRecipe.recipe = recipeHolder
        ghostRecipe.addIngredient(Ingredient.of(itemstack), pSlots[2].x, pSlots[2].y)
        val nonnulllist = recipeHolder.value.ingredients
        val slot = pSlots[1]
        if (slot.item.isEmpty) {
            if (fuels == null) {
                fuels =
                    Ingredient.of(
                        this.fuelItems
                            .stream()
                            .filter { it: Item ->
                                it.isEnabled(minecraft.level!!.enabledFeatures())
                            }
                            .map { pItem: Item -> ItemStack(pItem) })
            }
            ghostRecipe.addIngredient(fuels!!, slot.x, slot.y)
        }
        val iterator: Iterator<Ingredient> = nonnulllist.iterator()
        for (i in 0..1) {
            if (!iterator.hasNext()) {
                return
            }
            val ingredient = iterator.next()
            if (!ingredient.isEmpty) {
                val slot1 = pSlots[i]
                ghostRecipe.addIngredient(ingredient, slot1.x, slot1.y)
            }
        }
    }
}
