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
package io.github.realyusufismail.armourandtoolsmod.integration.fusion

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerBlockEntity
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.integration.ArmourAndToolsModJEIPlugin
import io.github.realyusufismail.armourandtoolsmod.recipe.fusion.IngotFusionTollEnhancerRecipe
import mezz.jei.api.constants.VanillaTypes
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder
import mezz.jei.api.gui.drawable.IDrawable
import mezz.jei.api.helpers.IGuiHelper
import mezz.jei.api.recipe.IFocusGroup
import mezz.jei.api.recipe.RecipeIngredientRole
import mezz.jei.api.recipe.RecipeType
import mezz.jei.api.recipe.category.IRecipeCategory
import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack

class IngotFusionTollEnhancerJEIRecipeCategory(guiHelper: IGuiHelper) :
    IRecipeCategory<IngotFusionTollEnhancerRecipe> {
    private val fusionJEIGuiLocation =
        ArmourAndToolsMod.getModIdAndName(
            "textures/gui/container/ingot_fusion_toll_enhancer_jei.png")
    private val bg: IDrawable
    private val ic: IDrawable
    private val w = 175
    private val h = 87

    init {
        // X cordinate is the distance from the left side of the screen to the right side of the gui
        // width
        // Y cordinate is the distance from the top of the screen to the top of the gui height
        bg = guiHelper.createDrawable(fusionJEIGuiLocation, 0, 0, w, h)
        ic =
            guiHelper.createDrawableIngredient(
                VanillaTypes.ITEM_STACK, ItemStack(BlockInit.INGOT_FUSION_TOLL_ENHANCER.get()))
    }

    /**
     * @return the type of recipe that this category handles.
     * @since 9.5.0
     */
    override fun getRecipeType(): RecipeType<IngotFusionTollEnhancerRecipe> {
        return ArmourAndToolsModJEIPlugin.ingotFusionTollEnhancerRecipeType
    }

    /**
     * Returns a text component representing the name of this recipe type. Drawn at the top of the
     * recipe GUI pages for this category.
     *
     * @since 7.6.4
     */
    override fun getTitle(): Component {
        return IngotFusionTollEnhancer.getContainerTitle()
    }

    /** Returns the drawable background for a single recipe in this category. */
    override fun getBackground(): IDrawable {
        return bg
    }

    /**
     * Icon for the category tab. You can use [IGuiHelper.createDrawableIngredient] to create a
     * drawable from an ingredient.
     *
     * @return icon to draw on the category tab, max size is 16x16 pixels.
     */
    override fun getIcon(): IDrawable {
        return ic
    }

    override fun getWidth(): Int {
        return w
    }

    override fun getHeight(): Int {
        return h
    }

    /**
     * Sets all the recipe's ingredients by filling out an instance of [IRecipeLayoutBuilder]. This
     * is used by JEI for lookups, to figure out what ingredients are inputs and outputs for a
     * recipe.
     *
     * @since 9.4.0
     */
    override fun setRecipe(
        builder: IRecipeLayoutBuilder,
        recipe: IngotFusionTollEnhancerRecipe,
        focuses: IFocusGroup
    ) {
        builder.addSlot(RecipeIngredientRole.INPUT, 16, 40).addIngredients(recipe.ingredients[0])
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 40).addIngredients(recipe.ingredients[1])
        builder.addSlot(RecipeIngredientRole.INPUT, 70, 40).addIngredients(recipe.ingredients[2])

        builder
            .addSlot(RecipeIngredientRole.INPUT, 110, 65)
            .addItemStacks(IngotFusionTollEnhancerBlockEntity.getFuelAsItemStacks().toList())

        builder.addSlot(RecipeIngredientRole.OUTPUT, 138, 40).addItemStack(recipe.result)
    }

    companion object {
        val UID = ArmourAndToolsMod.getModIdAndName("ingot_fusion_toll_enhancer_jei")
    }
}
