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

import com.google.common.collect.Lists;
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockEntityTypeInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit;
import io.github.realyusufismail.armourandtoolsmod.recipe.fusion.IngotFusionTollEnhancerRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
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
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @see net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity
 */
public class IngotFusionTollEnhancerBlockEntity extends BaseContainerBlockEntity
    implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {

  @Getter
  private final RecipeManager.CachedCheck<Container, IngotFusionTollEnhancerRecipe> quickCheck;

  @Getter
  private NonNullList<ItemStack> items = NonNullList.withSize(NUMBER_OF_SLOTS, ItemStack.EMPTY);

  private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
  private final RecipeType<IngotFusionTollEnhancerRecipe> type =
      RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get();
  protected static final int SLOT_INPUT_1 = 0;
  protected static final int SLOT_INPUT_2 = 1;
  protected static final int SLOT_INPUT_3 = 2;
  protected static final int SLOT_FUEL = 3;
  protected static final int SLOT_RESULT = 4;
  public static final int NUMBER_OF_SLOTS = 5;
  private static final int[] SLOTS_FOR_UP = new int[] {0};
  private static final int[] SLOTS_FOR_DOWN = new int[] {4, 3};
  private static final int[] SLOTS_FOR_SIDES = new int[] {1, 2};
  @Getter @Setter int creatingTime = 0;
  @Getter @Setter int creatingTotalTime = 200;

  public IngotFusionTollEnhancerBlockEntity(BlockPos blockPos, BlockState blockState) {
    super(BlockEntityTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), blockPos, blockState);

    this.quickCheck = RecipeManager.createCheck(RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get());
  }

  private final ItemStackHandler itemHandler =
      new ItemStackHandler(NUMBER_OF_SLOTS) {
        @Override
        protected void onContentsChanged(int slot) {
          setChanged();
        }
      };

  protected final ContainerData dataAccess =
      new ContainerData() {
        public int get(int p_58431_) {
          return switch (p_58431_) {
            case 0 -> IngotFusionTollEnhancerBlockEntity.this.creatingTime;
            case 1 -> IngotFusionTollEnhancerBlockEntity.this.creatingTotalTime;
            default -> throw new IllegalArgumentException("Invalid index: " + p_58431_);
          };
        }

        public void set(int p_58433_, int p_58434_) {
          switch (p_58433_) {
            case 0 -> IngotFusionTollEnhancerBlockEntity.this.creatingTime = p_58434_;
            case 1 -> IngotFusionTollEnhancerBlockEntity.this.creatingTotalTime = p_58434_;
          }
        }

        public int getCount() {
          return 2;
        }
      };

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    ContainerHelper.loadAllItems(pTag, this.items);

    this.creatingTime = pTag.getInt("CraftTime");
    this.creatingTotalTime = pTag.getInt("CraftTimeTotal");

    CompoundTag compoundtag = pTag.getCompound("RecipesUsed");

    for (String s : compoundtag.getAllKeys()) {
      this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
    }
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {

    pTag.putInt("CraftTime", this.creatingTime);
    pTag.putInt("CraftTimeTotal", this.creatingTotalTime);

    ContainerHelper.saveAllItems(pTag, this.items);
    CompoundTag compoundtag = new CompoundTag();
    this.recipesUsed.forEach(
        (p_187449_, p_187450_) -> {
          compoundtag.putInt(p_187449_.toString(), p_187450_);
        });

    pTag.put("RecipesUsed", compoundtag);

    super.saveAdditional(pTag);
  }

  @Override
  public int @NotNull [] getSlotsForFace(Direction pSide) {
    if (pSide == Direction.DOWN) {
      return SLOTS_FOR_DOWN;
    } else {
      return pSide == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
    }
  }

  @Override
  public boolean canPlaceItemThroughFace(
      int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
    return this.canPlaceItem(pIndex, pItemStack);
  }

  @Override
  public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
    if (pDirection == Direction.DOWN && pIndex == 1) {
      return pStack.is(Items.WATER_BUCKET) || pStack.is(Items.BUCKET);
    } else {
      return true;
    }
  }

  @Override
  protected @NotNull Component getDefaultName() {
    return IngotFusionTollEnhancer.getContainerTitle();
  }

  @Override
  protected @NotNull AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
    return new IngotFusionTollEnhancerMenu(pContainerId, this, dataAccess, pInventory);
  }

  @Override
  public int getContainerSize() {
    return items.size();
  }

  @Override
  public boolean isEmpty() {
    for (ItemStack itemStack : items) {
      if (!itemStack.isEmpty()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public @NotNull ItemStack getItem(int pSlot) {
    return items.get(pSlot);
  }

  @Override
  public @NotNull ItemStack removeItem(int pSlot, int pAmount) {
    return ContainerHelper.removeItem(items, pSlot, pAmount);
  }

  @Override
  public ItemStack removeItemNoUpdate(int pSlot) {
    return ContainerHelper.takeItem(items, pSlot);
  }

  @Override
  public void setItem(int pSlot, ItemStack pStack) {
    val itemstack = this.items.get(pSlot);
    val flag = !pStack.isEmpty() && ItemStack.isSameItemSameTags(itemstack, pStack);
    this.items.set(pSlot, pStack);
    if (pStack.getCount() > this.getMaxStackSize()) {
      pStack.setCount(this.getMaxStackSize());
    }

    if (pSlot == 0 && !flag) {
      this.creatingTotalTime = getTotalCraftTime(this.level, this);
      this.creatingTime = 0;
      this.setChanged();
    }
  }

  @Override
  public boolean stillValid(Player pPlayer) {
    return Container.stillValidBlockEntity(this, pPlayer);
  }

  @Override
  public void clearContent() {
    items.clear();
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
  public void awardUsedRecipes(Player pPlayer, List<ItemStack> pItems) {}

  public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
    List<Recipe<?>> list =
        this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position());
    pPlayer.awardRecipes(list);

    for (Recipe<?> recipe : list) {
      if (recipe != null) {
        pPlayer.triggerRecipeCrafted(recipe, this.items);
      }
    }

    this.recipesUsed.clear();
  }

  public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
    List<Recipe<?>> list = Lists.newArrayList();

    for (Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
      pLevel
          .getRecipeManager()
          .byKey(entry.getKey())
          .ifPresent(
              (p_155023_) -> {
                list.add(p_155023_);
                createExperience(
                    pLevel,
                    pPopVec,
                    entry.getIntValue(),
                    ((AbstractCookingRecipe) p_155023_).getExperience());
              });
    }

    return list;
  }

  private static void createExperience(
      ServerLevel pLevel, Vec3 pPopVec, int pRecipeIndex, float pExperience) {
    int i = Mth.floor((float) pRecipeIndex * pExperience);
    float f = Mth.frac((float) pRecipeIndex * pExperience);
    if (f != 0.0F && Math.random() < (double) f) {
      ++i;
    }

    ExperienceOrb.award(pLevel, pPopVec, i);
  }

  @Override
  public void fillStackedContents(StackedContents pContents) {
    for (ItemStack itemstack : this.items) {
      pContents.accountStack(itemstack);
    }
  }

  net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[]
      handlers =
          net.minecraftforge.items.wrapper.SidedInvWrapper.create(
              this, Direction.UP, Direction.DOWN, Direction.NORTH);

  @Override
  public <T> net.minecraftforge.common.util.@NotNull LazyOptional<T> getCapability(
      net.minecraftforge.common.capabilities.Capability<T> capability,
      @javax.annotation.Nullable Direction facing) {
    if (!this.remove
        && facing != null
        && capability == net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER) {
      if (facing == Direction.UP) return handlers[0].cast();
      else if (facing == Direction.DOWN) return handlers[1].cast();
      else return handlers[2].cast();
    }
    return super.getCapability(capability, facing);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    for (net.minecraftforge.common.util.LazyOptional<
            ? extends net.minecraftforge.items.IItemHandler>
        handler : handlers) handler.invalidate();
  }

  @Override
  public void reviveCaps() {
    super.reviveCaps();
    this.handlers =
        net.minecraftforge.items.wrapper.SidedInvWrapper.create(
            this, Direction.UP, Direction.DOWN, Direction.NORTH);
  }

  public static void serverTick(
      Level level, BlockPos pPos, BlockState pState, IngotFusionTollEnhancerBlockEntity pEntity) {
    if (level.isClientSide()) {
      ArmourAndToolsMod.ArmorAndToolsMod.getLogger().info("Client");
      return;
    }

    if (hasRecipe(pEntity)) {
      // craftItem(pEntity);

      pEntity.creatingTime++;
      setChanged(level, pPos, pState);

      if (pEntity.creatingTime >= pEntity.creatingTotalTime) {
        craftItem(pEntity);
      }
    } else {
      ArmourAndToolsMod.ArmorAndToolsMod.getLogger().info("No Recipe");
      pEntity.resetProgress();
      setChanged(level, pPos, pState);
    }
  }

  private static void craftItem(IngotFusionTollEnhancerBlockEntity pEntity) {
    Level level = pEntity.level;
    SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
    for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
      inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
    }

    Optional<IngotFusionTollEnhancerRecipe> recipe =
        level
            .getRecipeManager()
            .getRecipeFor(RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), inventory, level);

    if (hasRecipe(pEntity)) {
      if (recipe.isPresent()) {
        ItemStack result = recipe.get().getResult();
        if (pEntity.itemHandler.getStackInSlot(4).isEmpty()) {
          pEntity.itemHandler.setStackInSlot(4, result.copy());
        } else if (pEntity.itemHandler.getStackInSlot(4).getItem() == result.getItem()) {
          pEntity.itemHandler.getStackInSlot(4).grow(result.getCount());
        }

        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
          pEntity.itemHandler.getStackInSlot(i).shrink(1);
        }

        pEntity.resetProgress();
      }
    }
  }

  private void resetProgress() {
    this.creatingTime = 0;
  }

  private static boolean hasRecipe(IngotFusionTollEnhancerBlockEntity entity) {
    Level level = entity.level;
    //TODO: Issue here where it returns air instead of the item
    SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
    for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
      inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
    }

    ArmourAndToolsMod.ArmorAndToolsMod.getLogger().info("Checking Recipe for: " + inventory);
    ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
        .info("Checking Recipe for: " + inventory.getItem(0));
    ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
        .info("Checking Recipe for: " + inventory.getItem(1));
    ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
        .info("Checking Recipe for: " + inventory.getItem(2));
    ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
        .info("Checking Recipe for: " + inventory.getItem(3));

    level
        .getRecipeManager()
        .getRecipeFor(RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), inventory, level)
        .ifPresentOrElse(
            (recipe) -> {
              ArmourAndToolsMod.ArmorAndToolsMod.getLogger().info("Recipe: " + recipe);
              ArmourAndToolsMod.ArmorAndToolsMod.getLogger().info("Recipe: " + recipe.getResult());
            },
            () -> {
              ArmourAndToolsMod.ArmorAndToolsMod.getLogger().info("No Recipe");
            });

    Optional<IngotFusionTollEnhancerRecipe> recipe =
        level
            .getRecipeManager()
            .getRecipeFor(RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), inventory, level);

    return recipe.isPresent()
        && canInsertAmountIntoOutputSlot(inventory)
        && canInsertItemIntoOutputSlot(inventory, recipe.get().getResult());
  }

  private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
    ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
        .info("canInsertItemIntoOutputSlot: " + inventory.getItem(4).getItem() + " " + stack);
    return inventory.getItem(4).isEmpty() || inventory.getItem(4).getItem() == stack.getItem();
  }

  private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
    ArmourAndToolsMod.ArmorAndToolsMod.getLogger()
        .info(
            "canInsertAmountIntoOutputSlot: "
                + inventory.getItem(4).getCount()
                + " "
                + inventory.getItem(4).getMaxStackSize());
    return inventory.getItem(4).getCount() + 1 <= inventory.getItem(4).getMaxStackSize();
  }

  private Integer getTotalCraftTime(ItemStack itemStack) {
    if (itemStack.isEmpty()) {
      return 0;
    } else {
      return ForgeHooks.getBurnTime(itemStack, RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get());
    }
  }

  private static int getTotalCraftTime(
      Level pLevel, IngotFusionTollEnhancerBlockEntity pBlockEntity) {
    return pBlockEntity
        .getQuickCheck()
        .getRecipeFor(pBlockEntity, pLevel)
        .map(IngotFusionTollEnhancerRecipe::getCraftTime)
        .orElse(200);
  }

  public static Map<Item, Integer> getFuels() {
    Map<Item, Integer> map = new LinkedHashMap<>(AbstractFurnaceBlockEntity.getFuel());
    addFuel(map, ItemInit.INSTANCE.getGRAPHITE().get(), 200);
    addFuel(map, BlockInit.INSTANCE.getGRAPHITE_BLOCK().get().asItem(), 2000);
    return map;
  }

  public static Set<ItemStack> getFuelAsItemStacks() {
    return getFuels().keySet().stream()
        .map(ItemStack::new)
        .collect(java.util.stream.Collectors.toSet());
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
}
