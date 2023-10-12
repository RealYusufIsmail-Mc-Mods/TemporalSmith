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

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockEntityTypeInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit;
import io.github.realyusufismail.armourandtoolsmod.recipe.infusion.IngotFusionTollEnhancerRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @see net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity
 */
public class IngotFusionTollEnhancerBlockEntity extends BaseContainerBlockEntity
    implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {

  @Getter
  private final RecipeManager.CachedCheck<Container, IngotFusionTollEnhancerRecipe> quickCheck;

  // recipe
  private final RecipeType<IngotFusionTollEnhancerRecipe> type =
      RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get();

  private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

  // slots
  public static final int NUMBER_OF_SLOTS = 5;
  public static final int FUEL_SLOT = 3;
  public static final int RESULT_SLOT = 4;
  public static final int NUMBER_OF_DATA = 3;

  @Getter
  private NonNullList<ItemStack> items = NonNullList.withSize(NUMBER_OF_SLOTS, ItemStack.EMPTY);

  // ingredients
  private ItemStack ingredient1;
  private ItemStack ingredient2;
  private ItemStack ingredient3;

  // data
  @Getter @Setter int creatingTime = 0;
  @Getter @Setter int creatingTotalTime = 200;
  @Getter @Setter int fuel = 0;

  protected final ContainerData dataAccess =
      new ContainerData() {
        public int get(int p_58431_) {
          ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
              .info("Getting data: " + p_58431_ + " to " + p_58431_);
          return switch (p_58431_) {
            case 0 -> IngotFusionTollEnhancerBlockEntity.this.creatingTime;
            case 1 -> IngotFusionTollEnhancerBlockEntity.this.creatingTotalTime;
            case 2 -> IngotFusionTollEnhancerBlockEntity.this.fuel;
            default -> throw new IllegalArgumentException("Invalid index: " + p_58431_);
          };
        }

        public void set(int p_58433_, int p_58434_) {
          ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
              .info("Setting data: " + p_58433_ + " to " + p_58434_);
          switch (p_58433_) {
            case 0 -> IngotFusionTollEnhancerBlockEntity.this.creatingTime = p_58434_;
            case 1 -> IngotFusionTollEnhancerBlockEntity.this.creatingTotalTime = p_58434_;
            case 2 -> IngotFusionTollEnhancerBlockEntity.this.fuel = p_58434_;
          }
        }

        public int getCount() {
          return NUMBER_OF_DATA;
        }
      };

  public IngotFusionTollEnhancerBlockEntity(BlockPos blockPos, BlockState blockState) {
    super(BlockEntityTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), blockPos, blockState);

    this.quickCheck = RecipeManager.createCheck(RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get());
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    ContainerHelper.loadAllItems(pTag, this.items);
    this.creatingTime = pTag.getInt("CraftTime");
    this.creatingTotalTime = pTag.getInt("CraftTimeTotal");
    this.fuel = getFuels().getOrDefault(this.items.get(FUEL_SLOT).getItem(), 0);

    val compoundtag = pTag.getCompound("RecipesUsed");

    for (String s : compoundtag.getAllKeys()) {
      this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
    }
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    pTag.putInt("CraftTime", this.creatingTime);
    pTag.putInt("CraftTimeTotal", this.creatingTotalTime);
    pTag.putInt("Fuel", this.fuel);

    ContainerHelper.saveAllItems(pTag, this.items);
    val compoundtag = new CompoundTag();
    this.recipesUsed.forEach(
        (p_187449_, p_187450_) -> {
          compoundtag.putInt(p_187449_.toString(), p_187450_);
        });

    pTag.put("RecipesUsed", compoundtag);

    super.saveAdditional(pTag);
  }

  @Override
  protected @NotNull Component getDefaultName() {
    return IngotFusionTollEnhancer.getContainerTitle();
  }

  @Override
  protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
    ArmourAndToolsMod.ArmorAndToolsMod.getLogger().info("Creating menu");
    return new IngotFusionTollEnhancerMenu(pContainerId, this, this.dataAccess, pInventory);
  }

  @Override
  public int getContainerSize() {
    return this.items.size();
  }

  @Override
  public boolean isEmpty() {
    for (ItemStack itemstack : this.items) {
      if (!itemstack.isEmpty()) {
        return false;
      }
    }

    return true;
  }

  @Override
  public ItemStack getItem(int pSlot) {
    return pSlot >= 0 && pSlot < this.items.size() ? this.items.get(pSlot) : ItemStack.EMPTY;
  }

  @Override
  public ItemStack removeItem(int pSlot, int pAmount) {
    return ContainerHelper.removeItem(this.items, pSlot, pAmount);
  }

  @Override
  public ItemStack removeItemNoUpdate(int pSlot) {
    return ContainerHelper.takeItem(this.items, pSlot);
  }

  @Override
  public void setItem(int pSlot, ItemStack pStack) {
    if (pSlot >= 0 && pSlot < this.items.size()) {
      this.items.set(pSlot, pStack);
    }
  }

  @Override
  public boolean stillValid(Player pPlayer) {
    if (this.level.getBlockEntity(this.worldPosition) != this) {
      return false;
    } else {
      return pPlayer.distanceToSqr(
              (double) this.worldPosition.getX() + 0.5D,
              (double) this.worldPosition.getY() + 0.5D,
              (double) this.worldPosition.getZ() + 0.5D)
          <= 64.0D;
    }
  }

  @Override
  public void clearContent() {
    this.items.clear();
  }

  public static void serverTick(
      @NotNull Level level,
      @NotNull BlockPos pos,
      @NotNull BlockState state,
      @NotNull IngotFusionTollEnhancerBlockEntity blockEntity) {
    ItemStack itemstack = blockEntity.items.get(FUEL_SLOT);

    // Do i need blockEntity.fuel in this if statement?
    if (blockEntity.fuel <= 0 && getFuels().containsKey(itemstack.getItem())) {
      blockEntity.fuel = getFuels().get(itemstack.getItem());
      itemstack.shrink(1);
      blockEntity.setChanged();
    }

    boolean flag = blockEntity.isCreatable(level);
    boolean flag1 = blockEntity.creatingTime > 0;
    ItemStack ingredient1 = blockEntity.items.get(0);
    ItemStack ingredient2 = blockEntity.items.get(1);
    ItemStack ingredient3 = blockEntity.items.get(2);
    if (flag1) { // Says flag is false
      --blockEntity.creatingTime;
      boolean flag2 = blockEntity.creatingTime == 0;
      if (flag2 && flag) {
        blockEntity.createItem(level);
        blockEntity.setChanged();
      } else if (!flag) {
        blockEntity.creatingTime = 0;
        blockEntity.setChanged();
      } else if (blockEntity.ingredient1 != ingredient1
          || blockEntity.ingredient2 != ingredient2
          || blockEntity.ingredient3 != ingredient3) {
        blockEntity.creatingTime = 0;
        blockEntity.setChanged();
      }
    } else if (flag && blockEntity.fuel > 0) {
      --blockEntity.fuel;
      // TODO: Add ability to alter creating time.
      blockEntity.creatingTime = 200;
      blockEntity.ingredient1 = ingredient1;
      blockEntity.ingredient2 = ingredient2;
      blockEntity.ingredient3 = ingredient3;
      blockEntity.setChanged();
    }
  }

  private boolean isCreatable(Level level) {
    ItemStack ingredient1 = this.items.get(0);
    ItemStack ingredient2 = this.items.get(1);
    ItemStack ingredient3 = this.items.get(2);

    if (!ingredient1.isEmpty() && !ingredient2.isEmpty() && !ingredient3.isEmpty()) {

      // TODO: Need to check this for loop
      for (int i = 0; i < 3; ++i) {
        if (!this.items.get(i).isEmpty()) {
          if (!this.items.get(RESULT_SLOT).isEmpty()) {
            continue;
          }

          ItemStack ingredient = this.items.get(i);
          if (!ingredient.isEmpty() && hasRecipe(ingredient)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private void createItem(Level level) {
    var ingredient1 = this.items.get(0);
    var ingredient2 = this.items.get(1);
    var ingredient3 = this.items.get(2);

    var output = getOutput(level, ingredient1, ingredient2, ingredient3);
    this.items.set(RESULT_SLOT, output);

    val blockPos = this.getBlockPos();
    if (ingredient1.hasCraftingRemainingItem()) {
      val ingredient1Remaining = ingredient1.getCraftingRemainingItem();
      ingredient1.shrink(1);
      if (ingredient1.isEmpty()) {
        ingredient1 = ingredient1Remaining;
      } else if (!this.level.isClientSide) {
        Containers.dropItemStack(
            this.level,
            (double) blockPos.getX(),
            (double) blockPos.getY(),
            (double) blockPos.getZ(),
            ingredient1Remaining);
      }
    } else {
      ingredient1.shrink(1);
    }

    if (ingredient2.hasCraftingRemainingItem()) {
      val ingredient2Remaining = ingredient2.getCraftingRemainingItem();
      ingredient2.shrink(1);
      if (ingredient2.isEmpty()) {
        ingredient2 = ingredient2Remaining;
      } else if (!this.level.isClientSide) {
        Containers.dropItemStack(
            this.level,
            (double) blockPos.getX(),
            (double) blockPos.getY(),
            (double) blockPos.getZ(),
            ingredient2Remaining);
      }
    } else {
      ingredient2.shrink(1);
    }

    if (ingredient3.hasCraftingRemainingItem()) {
      val ingredient3Remaining = ingredient3.getCraftingRemainingItem();
      ingredient3.shrink(1);
      if (ingredient3.isEmpty()) {
        ingredient3 = ingredient3Remaining;
      } else if (!this.level.isClientSide) {
        Containers.dropItemStack(
            this.level,
            (double) blockPos.getX(),
            (double) blockPos.getY(),
            (double) blockPos.getZ(),
            ingredient3Remaining);
      }
    } else {
      ingredient3.shrink(1);
    }

    this.items.set(0, ingredient1);
    this.items.set(1, ingredient2);
    this.items.set(2, ingredient3);

    // level.levelEvent(1035, blockpos, 0);
    level.levelEvent(
        1035, blockPos, this.items.get(4).isEmpty() ? 0 : this.items.get(4).getCount());
  }

  private boolean hasRecipe(ItemStack ingredient) {
    return level.getRecipeManager().getAllRecipesFor(type).stream()
        .anyMatch(recipe -> recipe.isIngredient(ingredient));
  }

  private ItemStack getOutput(
      Level level, ItemStack ingredient1, ItemStack ingredient2, ItemStack ingredient3) {
    return level.getRecipeManager().getAllRecipesFor(type).stream()
        .map(recipe -> recipe.getResult(ingredient1, ingredient2, ingredient3))
        .filter(itemStack -> !itemStack.isEmpty())
        .findFirst()
        .orElse(ItemStack.EMPTY);
  }

  public static Map<Item, Integer> getFuels() {
    Map<Item, Integer> map = new LinkedHashMap<>(AbstractFurnaceBlockEntity.getFuel());
    addFuel(map, ItemInit.INSTANCE.getGRAPHITE().get(), 200);
    addFuel(map, BlockInit.INSTANCE.getGRAPHITE_BLOCK().get().asItem(), 2000);
    return map;
  }

  public static void addFuel(Map<Item, Integer> pMap, Item fuel, int pBurnTime) {
    if (!isNeverAIngotFusionTollEnhanceFuel(fuel)) {
      pMap.put(fuel, pBurnTime);
    } else {
      if (SharedConstants.IS_RUNNING_IN_IDE) {
        throw (Util.pauseInIde(
            new IllegalStateException(
                "A developer tried to explicitly make fire resistant item "
                    + fuel.getName(null).getString()
                    + " a IngotFusionTollEnhancer fuel. That will not work!")));
      }
    }
  }

  public static boolean isNeverAIngotFusionTollEnhanceFuel(Item pItem) {
    return pItem.builtInRegistryHolder().is(ItemTags.NON_FLAMMABLE_WOOD);
  }

  public static Set<ItemStack> getFuelAsItemStacks() {
    return getFuels().keySet().stream()
        .map(ItemStack::new)
        .collect(java.util.stream.Collectors.toSet());
  }

  @Override
  public int[] getSlotsForFace(Direction pSide) {
    return switch (pSide) {
      case DOWN -> new int[] {RESULT_SLOT};
      case UP -> new int[] {FUEL_SLOT};
      default -> new int[] {0, 1, 2, 3, 4};
    };
  }

  @Override
  public boolean canPlaceItemThroughFace(
      int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
    return this.canPlaceItem(pIndex, pItemStack);
  }

  @Override
  public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
    return pIndex != FUEL_SLOT || pStack.getItem() == Items.BUCKET;
  }

  @Override
  public void setRecipeUsed(@Nullable Recipe<?> pRecipe) {
    if (pRecipe != null) {
      ResourceLocation resourcelocation = pRecipe.getId();
      this.recipesUsed.addTo(resourcelocation, 1);
    }
  }

  @Nullable
  @Override
  public Recipe<?> getRecipeUsed() {
    return null;
  }

  @Override
  public void fillStackedContents(StackedContents pContents) {
    for (ItemStack itemstack : this.items) {
      pContents.accountStack(itemstack);
    }
  }
}
