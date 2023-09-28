package io.github.realyusufismail.armourandtoolsmod.blocks.fusion;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @see net.minecraft.client.gui.screens.inventory.FurnaceScreen
 */
public class IngotFusionTollEnhancerScreen extends AbstractContainerScreen<IngotFusionTollEnhancerMenu> {
    public static final ResourceLocation SCREEN_ID = ArmourAndToolsMod.ArmorAndToolsMod.getModIdAndName("textures/gui/container/ingot_fusion_toll_enhancer.png");

    public IngotFusionTollEnhancerScreen(IngotFusionTollEnhancerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        try {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            Objects.requireNonNull(minecraft, "Minecraft Instance is null").getTextureManager().bindForSetup(SCREEN_ID);

            int i = this.leftPos;
            int j = this.topPos;
            pGuiGraphics.blit(SCREEN_ID, i, j, 0, 0, 176, 179);
            pGuiGraphics.blit(SCREEN_ID, i + 97, j + 38, 179, 25, menu.getLitProgress() + 1, 17);
        } catch (NullPointerException e) {
            throw new NullPointerException("Minecraft Instance is null");
        }
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        try {
            this.renderBackground(pGuiGraphics);
            this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
            super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        } catch (NullPointerException e) {
            throw new NullPointerException("Render method called before Minecraft Instance is set");
        }
    }

    @Override
    public void renderLabels(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        try {
            pGuiGraphics.drawString(this.font, this.playerInventoryTitle, 7, 81, 4210752, false);
            pGuiGraphics.drawString(this.font, IngotFusionTollEnhancer.getContainerTitle(), 5, 10, 4210752, false);
        } catch (NullPointerException e) {
            throw new NullPointerException("Unable to render labels");
        }
    }
}
