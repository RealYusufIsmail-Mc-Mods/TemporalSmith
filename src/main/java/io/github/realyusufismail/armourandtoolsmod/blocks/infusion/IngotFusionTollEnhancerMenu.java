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
package io.github.realyusufismail.armourandtoolsmod.blocks.infusion;

import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots.InfusionFuelSlot;
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots.OutputSlotItemHandler;
import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeBookTypesInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit;
import io.github.realyusufismail.armourandtoolsmod.recipe.infusion.IngotFusionTollEnhancerRecipe;
import lombok.val;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

/**
 * @see net.minecraft.stats.RecipeBookSettings
 * @see FurnaceMenu
 */
public class IngotFusionTollEnhancerMenu extends RecipeBookMenu<Container> {
  private final RecipeType<IngotFusionTollEnhancerRecipe> recipeType;
  private final RecipeBookType recipeBook;
  private final Level level;
  private static final int NUMBER_OF_SLOTS = 5;
  private final ContainerData data;
  private final BaseContainerBlockEntity blockEntity;

  public IngotFusionTollEnhancerMenu(
      int pContainerId,
      BaseContainerBlockEntity blockEntity,
      ContainerData data,
      @NotNull Inventory pInventory) {
    super(MenuTypeInit.INGOT_FUSION_TOLL_ENHANCER_MENU.get(), pContainerId);
    this.recipeType = RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get();
    this.recipeBook = RecipeBookTypesInit.INGOT_FUSION;
    this.level = pInventory.player.level();
    this.data = data;
    this.blockEntity = blockEntity;

    checkContainerSize(blockEntity, NUMBER_OF_SLOTS);
    checkContainerDataCount(data, IngotFusionTollEnhancerBlockEntity.NUMBER_OF_DATA);

    addPlayerInventory(pInventory);
    addPlayerHotbar(pInventory);

    blockEntity
        .getCapability(ForgeCapabilities.ITEM_HANDLER)
        .ifPresent(
            it -> {
              // slots to place ingredients
              addSlot(new SlotItemHandler(it, 0, 16, 40));
              addSlot(new SlotItemHandler(it, 1, 43, 40));
              addSlot(new SlotItemHandler(it, 2, 70, 40));

              // slot to place fuel
              addSlot(new InfusionFuelSlot(it, this));

              // slot to place result
              addSlot(new OutputSlotItemHandler(it, pInventory.player));
            });
  }

  public IngotFusionTollEnhancerMenu(int pContainerId, Inventory inventory, FriendlyByteBuf data) {
    this(
        pContainerId,
        getBlockEntity(inventory, data),
        new SimpleContainerData(IngotFusionTollEnhancerBlockEntity.NUMBER_OF_DATA),
        inventory);
  }

  private void addPlayerInventory(Inventory playerInventory) {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 9; col++) {
        addSlot(
            new Slot(
                playerInventory, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10 + 13));
      }
    }
  }

  private void addPlayerHotbar(Inventory playerInventory) {
    for (int col = 0; col < 9; col++) {
      addSlot(new Slot(playerInventory, col, 8 + col * 18, 142 + 13));
    }
  }

  public static BaseContainerBlockEntity getBlockEntity(Inventory inventory, FriendlyByteBuf data) {
    BaseContainerBlockEntity blockEntity =
        (BaseContainerBlockEntity) inventory.player.level().getBlockEntity(data.readBlockPos());
    if (blockEntity != null) {
      return blockEntity;
    } else {
      throw new IllegalStateException("Block entity is not correct");
    }
  }

  @Override
  public boolean stillValid(Player pPlayer) {
    return this.blockEntity.stillValid(pPlayer);
  }

  public int getCreatingTime() {
    return this.data.get(0);
  }

  public int getMaxCreatingTime() {
    return this.data.get(1);
  }

  public int getCreatingProgress() {
    val creatingTime = getCreatingTime();
    val maxCreatingTime = getMaxCreatingTime();
    return maxCreatingTime != 0 && creatingTime != 0 ? creatingTime * 24 / maxCreatingTime : 0;
  }

  @Override
  public @NotNull ItemStack quickMoveStack(Player pPlayer, int slotId) {
    ItemStack itemstack = ItemStack.EMPTY;
    Slot slot = this.slots.get(slotId);
    if (slot != null && slot.hasItem()) {
      ItemStack itemstack1 = slot.getItem();
      itemstack = itemstack1.copy();
      if (slotId < NUMBER_OF_SLOTS
          && !moveItemStackTo(itemstack1, NUMBER_OF_SLOTS, this.slots.size(), true)) {
        return ItemStack.EMPTY;
      }

      if (!moveItemStackTo(itemstack1, 0, NUMBER_OF_SLOTS, false)) {
        return ItemStack.EMPTY;
      } else if (slotId < NUMBER_OF_SLOTS) {
        // TODO: check if this is correct
        slot.onQuickCraft(itemstack1, itemstack);
      }

      if (itemstack1.isEmpty()) {
        slot.set(ItemStack.EMPTY);
      } else {
        slot.setChanged();
      }
    }

    return itemstack;
  }

  @Override
  public void fillCraftSlotsStackedContents(StackedContents pItemHelper) {
    if (this.blockEntity instanceof StackedContentsCompatible) {
      ((StackedContentsCompatible) this.blockEntity).fillStackedContents(pItemHelper);
    }
  }

  @Override
  public void clearCraftingContent() {
    this.slots.get(NUMBER_OF_SLOTS).set(ItemStack.EMPTY);
  }

  @Override
  public boolean recipeMatches(Recipe<? super Container> pRecipe) {
    return pRecipe.matches(this.blockEntity, this.level);
  }

  @Override
  public int getResultSlotIndex() {
    return 4;
  }

  @Override
  public int getGridWidth() {
    return 1;
  }

  @Override
  public int getGridHeight() {
    return 1;
  }

  @Override
  public int getSize() {
    return NUMBER_OF_SLOTS;
  }

  public boolean isFuel(ItemStack pStack) {
    return IngotFusionTollEnhancerBlockEntity.getFuels().containsKey(pStack.getItem());
  }

  @Override
  public @NotNull RecipeBookType getRecipeBookType() {
    return RecipeBookTypesInit.INGOT_FUSION;
  }

  @Override
  public boolean shouldMoveToInventory(int pSlotIndex) {
    return pSlotIndex != this.getResultSlotIndex();
  }
}
