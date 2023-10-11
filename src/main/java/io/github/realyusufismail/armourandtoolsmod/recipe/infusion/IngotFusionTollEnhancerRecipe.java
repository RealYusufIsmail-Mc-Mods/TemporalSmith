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
package io.github.realyusufismail.armourandtoolsmod.recipe.infusion;

import com.google.gson.JsonObject;
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookCategory;
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit;
import java.util.Arrays;
import lombok.Getter;
import lombok.val;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IngotFusionTollEnhancerRecipe implements Recipe<Container> {

  protected final RecipeType<?> type;
  protected final ResourceLocation id;
  @Getter protected final Ingredient ingredient1;
  @Getter protected final Ingredient ingredient2;
  @Getter protected final Ingredient ingredient3;
  @Getter @NotNull public final ItemStack result;
  @Getter @NotNull public final IngotFusionTollEnhancerRecipeBookCategory category;

  public IngotFusionTollEnhancerRecipe(
      RecipeType<?> type,
      ResourceLocation id,
      Ingredient ingredient1,
      Ingredient ingredient2,
      Ingredient ingredient3,
      ItemStack result,
      IngotFusionTollEnhancerRecipeBookCategory category) {
    this.type = type;
    this.id = id;
    this.ingredient1 = ingredient1;
    this.ingredient2 = ingredient2;
    this.ingredient3 = ingredient3;
    this.result = result;
    this.category = category;
  }

  @Override
  public boolean matches(Container pContainer, Level pLevel) {
    return this.ingredient1.test(pContainer.getItem(0))
        && this.ingredient2.test(pContainer.getItem(1))
        && this.ingredient3.test(pContainer.getItem(2));
  }

  @Override
  public @NotNull ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
    return this.result.copy();
  }

  @Override
  public boolean canCraftInDimensions(int pWidth, int pHeight) {
    return true;
  }

  @Override
  public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
    return this.result;
  }

  @Override
  public ResourceLocation getId() {
    return this.id;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return RecipeSerializerInit.INGOT_FUSION_TOLL_ENHANCER_RECIPE.get();
  }

  @Override
  public RecipeType<?> getType() {
    return this.type;
  }

  public boolean isInputValid(ItemStack ingredient1, ItemStack ingredient2, ItemStack ingredient3) {
    //TODO: see if input is needed to be added back
    return Arrays.stream(this.ingredient1.getItems())
            .anyMatch(
                itemStack -> {
                  if (!ItemStack.isSameItem(ingredient1, itemStack)) {
                    return false;
                  } else if (!ItemStack.isSameItem(ingredient2, itemStack)) {
                    return false;
                  } else return ItemStack.isSameItem(ingredient3, itemStack);
                })
        || Arrays.stream(this.ingredient2.getItems())
            .anyMatch(
                itemStack -> {
                  if (!ItemStack.isSameItem(ingredient1, itemStack)) {
                    return false;
                  } else if (!ItemStack.isSameItem(ingredient2, itemStack)) {
                    return false;
                  } else return ItemStack.isSameItem(ingredient3, itemStack);
                })
        || Arrays.stream(this.ingredient3.getItems())
            .anyMatch(
                itemStack -> {
                  if (!ItemStack.isSameItem(ingredient1, itemStack)) {
                    return false;
                  } else if (!ItemStack.isSameItem(ingredient2, itemStack)) {
                    return false;
                  } else return ItemStack.isSameItem(ingredient3, itemStack);
                });
  }

  public boolean isIngredient(ItemStack ingredient) {
    return Arrays.stream(this.ingredient1.getItems())
            .anyMatch(
                itemStack -> {
                  return ItemStack.isSameItem(ingredient, itemStack);
                })
        || Arrays.stream(this.ingredient2.getItems())
            .anyMatch(
                itemStack -> {
                  return ItemStack.isSameItem(ingredient, itemStack);
                })
        || Arrays.stream(this.ingredient3.getItems())
            .anyMatch(
                itemStack -> {
                  return ItemStack.isSameItem(ingredient, itemStack);
                });
  }

  public ItemStack getResult(
      ItemStack input, ItemStack ingredient1, ItemStack ingredient2, ItemStack ingredient3) {
    return isInputValid(ingredient1, ingredient2, ingredient3) && isIngredient(input)
        ? this.result
        : ItemStack.EMPTY;
  }

  public static class Serializer implements RecipeSerializer<IngotFusionTollEnhancerRecipe> {

    @Override
    public IngotFusionTollEnhancerRecipe fromJson(ResourceLocation pRecipeId, JsonObject json) {
      val category =
          IngotFusionTollEnhancerRecipeBookCategory.CODEC.byName(
              GsonHelper.getAsString(json, "category", null),
              IngotFusionTollEnhancerRecipeBookCategory.MISC);
      val ingredient1 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient1"));
      val ingredient2 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient2"));
      val ingredient3 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient3"));
      val result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
      return new IngotFusionTollEnhancerRecipe(
          RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(),
          pRecipeId,
          ingredient1,
          ingredient2,
          ingredient3,
          result,
          category);
    }

    @Override
    public @Nullable IngotFusionTollEnhancerRecipe fromNetwork(
        ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
      val category = pBuffer.readEnum(IngotFusionTollEnhancerRecipeBookCategory.class);
      val ingredient1 = Ingredient.fromNetwork(pBuffer);
      val ingredient2 = Ingredient.fromNetwork(pBuffer);
      val ingredient3 = Ingredient.fromNetwork(pBuffer);
      val result = pBuffer.readItem();
      return new IngotFusionTollEnhancerRecipe(
          RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(),
          pRecipeId,
          ingredient1,
          ingredient2,
          ingredient3,
          result,
          category);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, IngotFusionTollEnhancerRecipe pRecipe) {
      pBuffer.writeEnum(pRecipe.category);
      pRecipe.ingredient1.toNetwork(pBuffer);
      pRecipe.ingredient2.toNetwork(pBuffer);
      pRecipe.ingredient3.toNetwork(pBuffer);
      pBuffer.writeItem(pRecipe.result);
    }
  }
}
