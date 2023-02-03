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
package io.github.realyusufismail.armourandtoolsmod.core.blocks.armour

import com.mojang.blaze3d.systems.RenderSystem
import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.components.Button
import net.minecraft.client.gui.components.ImageButton
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener
import net.minecraft.client.renderer.GameRenderer
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.ClickType
import net.minecraft.world.inventory.Slot
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

/** @see net.minecraft.client.gui.screens.inventory.CraftingScreen */
@OnlyIn(Dist.CLIENT)
class CustomArmourCraftingTableScreen(
    menu: CustomArmourCraftingTableMenu,
    inv: Inventory,
    title: Component,
) : AbstractContainerScreen<CustomArmourCraftingTableMenu>(menu, inv, title), RecipeUpdateListener {
    private val CRAFTING_TABLE_LOCATION =
        ResourceLocation("textures/gui/container/crafting_table.png")
    private val RECIPE_BUTTON_LOCATION = ResourceLocation("textures/gui/recipe_button.png")
    private val recipeBookComponent = CustomArmourRecipeBookComponent()
    private var widthTooNarrow = false

    override fun init() {
        super.init()
        widthTooNarrow = width < 379
        recipeBookComponent.init(width, height, minecraft, widthTooNarrow, menu)
        leftPos = recipeBookComponent.updateScreenPosition(width, imageWidth)
        addRenderableWidget(
            ImageButton(
                leftPos + 5,
                height / 2 - 49,
                20,
                18,
                0,
                0,
                19,
                RECIPE_BUTTON_LOCATION,
            ) { button: Button ->
                recipeBookComponent.toggleVisibility()
                leftPos = recipeBookComponent.updateScreenPosition(width, imageWidth)
                (button as ImageButton).setPosition(leftPos + 5, height / 2 - 49)
            })
        addWidget(recipeBookComponent)
        setInitialFocus(recipeBookComponent)
        titleLabelX = 29
    }

    override fun containerTick() {
        super.containerTick()
        recipeBookComponent.tick()
    }

    override fun render(pPoseStack: PoseStack, pMouseX: Int, pMouseY: Int, pPartialTick: Float) {
        this.renderBackground(pPoseStack)
        if (recipeBookComponent.isVisible && widthTooNarrow) {
            renderBg(pPoseStack, pPartialTick, pMouseX, pMouseY)
            recipeBookComponent.render(pPoseStack, pMouseX, pMouseY, pPartialTick)
        } else {
            recipeBookComponent.render(pPoseStack, pMouseX, pMouseY, pPartialTick)
            super.render(pPoseStack, pMouseX, pMouseY, pPartialTick)
            recipeBookComponent.renderGhostRecipe(pPoseStack, leftPos, topPos, true, pPartialTick)
        }
        this.renderTooltip(pPoseStack, pMouseX, pMouseY)
        recipeBookComponent.renderTooltip(pPoseStack, leftPos, topPos, pMouseX, pMouseY)
    }

    override fun renderBg(pPoseStack: PoseStack, pPartialTick: Float, pX: Int, pY: Int) {
        RenderSystem.setShader { GameRenderer.getPositionTexShader() }
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)
        RenderSystem.setShaderTexture(0, CRAFTING_TABLE_LOCATION)
        val i = leftPos
        val j = (height - imageHeight) / 2
        this.blit(pPoseStack, i, j, 0, 0, imageWidth, imageHeight)
    }

    override fun isHovering(
        pX: Int,
        pY: Int,
        pWidth: Int,
        pHeight: Int,
        pMouseX: Double,
        pMouseY: Double,
    ): Boolean {
        return (!widthTooNarrow || !recipeBookComponent.isVisible) &&
            super.isHovering(pX, pY, pWidth, pHeight, pMouseX, pMouseY)
    }

    override fun mouseClicked(pMouseX: Double, pMouseY: Double, pButton: Int): Boolean {
        return if (recipeBookComponent.mouseClicked(pMouseX, pMouseY, pButton)) {
            focused = recipeBookComponent
            true
        } else {
            if (widthTooNarrow && recipeBookComponent.isVisible) true
            else super.mouseClicked(pMouseX, pMouseY, pButton)
        }
    }

    override fun hasClickedOutside(
        pMouseX: Double,
        pMouseY: Double,
        pGuiLeft: Int,
        pGuiTop: Int,
        pMouseButton: Int,
    ): Boolean {
        val flag =
            pMouseX < pGuiLeft.toDouble() ||
                pMouseY < pGuiTop.toDouble() ||
                pMouseX >= (pGuiLeft + imageWidth).toDouble() ||
                pMouseY >= (pGuiTop + imageHeight).toDouble()
        return recipeBookComponent.hasClickedOutside(
            pMouseX, pMouseY, leftPos, topPos, imageWidth, imageHeight, pMouseButton) && flag
    }

    // TODO : pSlot is nullable, but it's not in the super method
    /** Called when the mouse is clicked over a slot or outside the gui. */
    override fun slotClicked(pSlot: Slot, pSlotId: Int, pMouseButton: Int, pType: ClickType) {
        if (pSlot == null) throw IllegalStateException("Slot is null in slotClicked")
        super.slotClicked(pSlot, pSlotId, pMouseButton, pType)
        recipeBookComponent.slotClicked(pSlot)
    }

    override fun recipesUpdated() {
        recipeBookComponent.recipesUpdated()
    }

    override fun getRecipeBookComponent(): RecipeBookComponent {
        return recipeBookComponent
    }
}
