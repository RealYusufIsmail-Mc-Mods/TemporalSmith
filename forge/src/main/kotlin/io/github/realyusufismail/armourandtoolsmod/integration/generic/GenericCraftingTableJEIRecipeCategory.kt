/*
 * Copyright 2023 RealYusufIsmail.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.realyusufismail.armourandtoolsmod.integration.generic

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import mezz.jei.api.constants.VanillaTypes
import mezz.jei.api.gui.drawable.IDrawable
import mezz.jei.api.helpers.IGuiHelper
import mezz.jei.api.recipe.category.IRecipeCategory
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block

abstract class GenericCraftingTableJEIRecipeCategory<T>(guiHelper: IGuiHelper, val block: Block) :
    IRecipeCategory<T> {
    protected val bg: IDrawable
    protected val ic: IDrawable
    private val craftingTableGuiLocation =
        ArmourAndToolsMod.getModIdAndName("textures/gui/container/custom_crafting_table_Jei.png")
    private val w = 173
    private val h = 69

    init {
        // X cordinate is the distance from the left side of the screen to the right side of the gui
        // width
        // Y cordinate is the distance from the top of the screen to the top of the gui height
        bg = guiHelper.createDrawable(craftingTableGuiLocation, 0, 0, w, h)
        ic = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, ItemStack(block))
    }

    override fun getWidth(): Int {
        return w
    }

    override fun getHeight(): Int {
        return h
    }
}
