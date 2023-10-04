package io.github.realyusufismail.armourandtoolsmod.blocks.infusion;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer;
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookComponent;
import java.util.Objects;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.NotNull;

/**
 * @see net.minecraft.client.gui.screens.inventory.FurnaceScreen
 */
public class IngotFusionTollEnhancerScreen
    extends AbstractContainerScreen<IngotFusionTollEnhancerMenu> implements RecipeUpdateListener {
  public static final ResourceLocation SCREEN_ID =
      ArmourAndToolsMod.ArmorAndToolsMod.getModIdAndName(
          "textures/gui/container/ingot_fusion_toll_enhancer.png");
  public final IngotFusionTollEnhancerRecipeBookComponent recipeBookComponent =
      new IngotFusionTollEnhancerRecipeBookComponent();
  private static final ResourceLocation RECIPE_BUTTON_LOCATION =
      new ResourceLocation("textures/gui/recipe_button.png");
  private boolean widthTooNarrow;

  public IngotFusionTollEnhancerScreen(
      IngotFusionTollEnhancerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
    super(pMenu, pPlayerInventory, pTitle);
  }

  protected void init() {
    super.init();
    this.widthTooNarrow = this.width < 379;
    this.recipeBookComponent.init(
        this.width,
        this.height,
        Objects.requireNonNull(this.minecraft, "Minecraft is null in table screen"),
        this.widthTooNarrow,
        this.menu);
    this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
    this.addRenderableWidget(
        new ImageButton(
            this.leftPos + 5,
            this.height / 2 - 49,
            20,
            18,
            0,
            0,
            19,
            RECIPE_BUTTON_LOCATION,
            (p_98484_) -> {
              this.recipeBookComponent.toggleVisibility();
              this.leftPos =
                  this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
              p_98484_.setPosition(this.leftPos + 5, this.height / 2 - 49);
            }));
    this.addWidget(this.recipeBookComponent);
    this.setInitialFocus(this.recipeBookComponent);
    this.titleLabelX = 29;
  }

  public void containerTick() {
    super.containerTick();
    this.recipeBookComponent.tick();
  }

  @Override
  protected void renderBg(
      @NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
    try {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      Objects.requireNonNull(minecraft, "Minecraft Instance is null")
          .getTextureManager()
          .bindForSetup(SCREEN_ID);

      int i = this.leftPos;
      int j = this.topPos;
      pGuiGraphics.blit(SCREEN_ID, i, j, 0, 0, 176, 179);
      pGuiGraphics.blit(SCREEN_ID, i + 97, j + 38, 179, 25, menu.getLitProgress() + 1, 17);
    } catch (NullPointerException e) {
      throw new NullPointerException("Minecraft Instance is null");
    }
  }

  @Override
  public void render(
      @NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
    try {
      this.renderBackground(pGuiGraphics);

      if (this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
        this.renderBg(pGuiGraphics, pPartialTick, pMouseX, pMouseY);
        this.recipeBookComponent.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
      } else {
        this.recipeBookComponent.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.recipeBookComponent.renderGhostRecipe(
            pGuiGraphics, this.leftPos, this.topPos, true, pPartialTick);
      }

      this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
      this.recipeBookComponent.renderTooltip(
          pGuiGraphics, this.leftPos, this.topPos, pMouseX, pMouseY);
      // super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    } catch (NullPointerException e) {
      throw new NullPointerException("Render method called before Minecraft Instance is set");
    }
  }

  @Override
  public void renderLabels(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
    try {
      pGuiGraphics.drawString(this.font, this.playerInventoryTitle, 7, 81, 4210752, false);
      pGuiGraphics.drawString(
          this.font, IngotFusionTollEnhancer.getContainerTitle(), 5, 10, 4210752, false);
    } catch (NullPointerException e) {
      throw new NullPointerException("Unable to render labels");
    }
  }

  protected boolean isHovering(
      int pX, int pY, int pWidth, int pHeight, double pMouseX, double pMouseY) {
    return (!this.widthTooNarrow || !this.recipeBookComponent.isVisible())
        && super.isHovering(pX, pY, pWidth, pHeight, pMouseX, pMouseY);
  }

  public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
    if (this.recipeBookComponent.mouseClicked(pMouseX, pMouseY, pButton)) {
      this.setFocused(this.recipeBookComponent);
      return true;
    } else {
      return this.widthTooNarrow && this.recipeBookComponent.isVisible()
          || super.mouseClicked(pMouseX, pMouseY, pButton);
    }
  }

  protected boolean hasClickedOutside(
      double pMouseX, double pMouseY, int pGuiLeft, int pGuiTop, int pMouseButton) {
    boolean flag =
        pMouseX < (double) pGuiLeft
            || pMouseY < (double) pGuiTop
            || pMouseX >= (double) (pGuiLeft + this.imageWidth)
            || pMouseY >= (double) (pGuiTop + this.imageHeight);
    return this.recipeBookComponent.hasClickedOutside(
            pMouseX,
            pMouseY,
            this.leftPos,
            this.topPos,
            this.imageWidth,
            this.imageHeight,
            pMouseButton)
        && flag;
  }

  /** Called when the mouse is clicked over a slot or outside the gui. */
  protected void slotClicked(
      @NotNull Slot pSlot, int pSlotId, int pMouseButton, @NotNull ClickType pType) {
    super.slotClicked(pSlot, pSlotId, pMouseButton, pType);
    this.recipeBookComponent.slotClicked(pSlot);
  }

  /**
   * Called when a keyboard key is pressed within the GUI element.
   *
   * <p>
   *
   * @return {@code true} if the event is consumed, {@code false} otherwise.
   * @param pKeyCode the key code of the pressed key.
   * @param pScanCode the scan code of the pressed key.
   * @param pModifiers the keyboard modifiers.
   */
  public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
    return !this.recipeBookComponent.keyPressed(pKeyCode, pScanCode, pModifiers)
        && super.keyPressed(pKeyCode, pScanCode, pModifiers);
  }

  /**
   * Called when a character is typed within the GUI element.
   *
   * <p>
   *
   * @return {@code true} if the event is consumed, {@code false} otherwise.
   * @param pCodePoint the code point of the typed character.
   * @param pModifiers the keyboard modifiers.
   */
  public boolean charTyped(char pCodePoint, int pModifiers) {
    return this.recipeBookComponent.charTyped(pCodePoint, pModifiers)
        || super.charTyped(pCodePoint, pModifiers);
  }

  public void recipesUpdated() {
    this.recipeBookComponent.recipesUpdated();
  }

  public void removed() {
    super.removed();
  }

  @Override
  public @NotNull RecipeBookComponent getRecipeBookComponent() {
    return recipeBookComponent;
  }
}
