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
import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockEntityTypeInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit;
import io.github.realyusufismail.armourandtoolsmod.recipe.fusion.IngotFusionTollEnhancerRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
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
  @Getter @Setter int litTime;
  @Getter @Setter int litDuration;
  @Getter @Setter int creatingTime;
  @Getter @Setter int creatingTotalTime;

  public IngotFusionTollEnhancerBlockEntity(BlockPos blockPos, BlockState blockState) {
    super(BlockEntityTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), blockPos, blockState);

    this.quickCheck = RecipeManager.createCheck(RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get());
  }

  protected final ContainerData dataAccess =
      new ContainerData() {
        public int get(int p_58431_) {
          return switch (p_58431_) {
            case 0 -> litTime;
            case 1 -> litDuration;
            case 2 -> creatingTime;
            case 3 -> creatingTotalTime;
            default -> 0;
          };
        }

        public void set(int p_58433_, int p_58434_) {
          switch (p_58433_) {
            case 0 -> litTime = p_58434_;
            case 1 -> litDuration = p_58434_;
            case 2 -> creatingTime = p_58434_;
            case 3 -> creatingTotalTime = p_58434_;
          }
        }

        public int getCount() {
          return 4;
        }
      };

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    ContainerHelper.loadAllItems(pTag, this.items);
    this.litTime = pTag.getInt("BurnTime");
    this.creatingTime = pTag.getInt("CraftTime");
    this.creatingTotalTime = pTag.getInt("CraftTimeTotal");
    this.litDuration = this.getTotalCraftTime(this.items.get(1));
    CompoundTag compoundtag = pTag.getCompound("RecipesUsed");

    for (String s : compoundtag.getAllKeys()) {
      this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
    }
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    super.saveAdditional(pTag);
    pTag.putInt("BurnTime", this.litTime);
    pTag.putInt("CraftTime", this.creatingTime);
    pTag.putInt("CraftTimeTotal", this.creatingTotalTime);
    ContainerHelper.saveAllItems(pTag, this.items);
    CompoundTag compoundtag = new CompoundTag();
    this.recipesUsed.forEach(
        (p_187449_, p_187450_) -> {
          compoundtag.putInt(p_187449_.toString(), p_187450_);
        });
    pTag.put("RecipesUsed", compoundtag);
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

  private boolean isLit() {
    return this.litTime > 0;
  }

  public static void serverTick(
      Level level, BlockPos pPos, BlockState pState, IngotFusionTollEnhancerBlockEntity pEntity) {
    val flag = pEntity.isLit();
    var flag1 = false;

    if (pEntity.isLit()) {
      pEntity.setLitTime(pEntity.getLitTime() - 1);
    }

    val itemstack = pEntity.getItems().get(1);
    val flag2 = !pEntity.getItems().get(0).isEmpty();
    val flag3 = !itemstack.isEmpty();

    if (pEntity.isLit() || (flag3 && flag2)) {
      Recipe<?> recipe =
          flag2 ? pEntity.getQuickCheck().getRecipeFor(pEntity, level).orElse(null) : null;
      int i = pEntity.getMaxStackSize();

      if (!pEntity.isLit()
          && pEntity.canCreate(level.registryAccess(), recipe, pEntity.getItems(), i)) {
        pEntity.setLitTime(pEntity.getTotalCraftTime(itemstack));
        pEntity.setLitDuration(pEntity.getLitTime());

        if (pEntity.isLit()) {
          flag1 = true;

          if (itemstack.hasCraftingRemainingItem()) {
            pEntity.getItems().set(1, itemstack.getCraftingRemainingItem());
          } else if (flag3) {
            Item item = itemstack.getItem();
            itemstack.shrink(1);

            if (itemstack.isEmpty()) {
              pEntity.getItems().set(1, itemstack.getCraftingRemainingItem());
            }
          }
        }
      }

      if (pEntity.isLit()
          && pEntity.canCreate(level.registryAccess(), recipe, pEntity.getItems(), i)) {
        pEntity.setCreatingTime(pEntity.getCreatingTime() + 1);

        if (pEntity.getCreatingTime() == pEntity.getCreatingTotalTime()) {
          pEntity.setCreatingTime(0);
          pEntity.setCreatingTotalTime(getTotalCraftTime(level, pEntity));

          if (pEntity.craft(level.registryAccess(), recipe, pEntity.getItems(), i)) {
            pEntity.setRecipeUsed(recipe);
          }
          flag1 = true;
        }
      } else {
        pEntity.setCreatingTime(0);
      }
    } else if (!pEntity.isLit() && pEntity.getCreatingTime() > 0) {
      pEntity.setCreatingTime(Math.max(pEntity.getCreatingTime() - 2, 0));
    }

    BlockState state = pState;

    if (flag != pEntity.isLit()) {
      flag1 = true;
      state = pState.setValue(IngotFusionTollEnhancer.LIT, pEntity.isLit());
      level.setBlock(pPos, state, 3);
    }

    if (flag1) {
      setChanged(level, pPos, state);
    }
  }

  private boolean canCreate(
      RegistryAccess pRegistryAccess,
      @Nullable Recipe<?> pRecipe,
      NonNullList<ItemStack> pItems,
      int pMaxStackSize) {
    if (!pItems.get(0).isEmpty() && pRecipe != null) {
      val itemstack = ((Recipe<WorldlyContainer>) pRecipe).assemble(this, pRegistryAccess);
      if (itemstack.isEmpty()) {
        return false;
      } else {
        // TODO: Check this
        val itemstack1 = pItems.get(4);
        if (itemstack1.isEmpty()) {
          return true;
        } else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
          return false;
        } else if (itemstack1.getCount() + itemstack.getCount() <= pMaxStackSize
            && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
          return true;
        } else {
          return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
        }
      }
    } else {
      return false;
    }
  }

  private boolean craft(
      RegistryAccess registryAccess,
      Recipe<?> recipe,
      NonNullList<ItemStack> inventroy,
      Integer maxStackSize) {
    if (recipe != null && canCreate(registryAccess, recipe, inventroy, maxStackSize)) {
      val itemstack = inventroy.get(0);
      val itemstack1 = ((Recipe<WorldlyContainer>) recipe).assemble(this, registryAccess);
      val itemstack2 = inventroy.get(4);
      if (itemstack2.isEmpty()) {
        inventroy.set(4, itemstack1.copy());
      } else {
        itemstack2.is(itemstack1.getItem());
      }

      if (itemstack.is(Blocks.WET_SPONGE.asItem())
          && !inventroy.get(1).isEmpty()
          && inventroy.get(1).is(Items.BUCKET)) {
        inventroy.set(1, new ItemStack(Items.WATER_BUCKET));
      }

      itemstack.shrink(1);
      return true;
    } else {
      return false;
    }
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
