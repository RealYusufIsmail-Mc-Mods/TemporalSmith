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
package io.github.realyusufismail.temporalsmith.recipe.infusion;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.realyusufismail.temporalsmith.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookCategory;
import io.github.realyusufismail.temporalsmith.core.init.RecipeSerializerInit;
import io.github.realyusufismail.temporalsmith.core.init.RecipeTypeInit;
import java.util.Arrays;
import lombok.Getter;
import lombok.val;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IngotFusionTollEnhancerRecipe implements Recipe<Container> {

  @Getter public final Ingredient ingredient1;
  @Getter public final Ingredient ingredient2;
  @Getter public final Ingredient ingredient3;
  @Getter @NotNull public final ItemStack result;
  @Getter @NotNull public final IngotFusionTollEnhancerRecipeBookCategory category;

  public IngotFusionTollEnhancerRecipe(
      IngotFusionTollEnhancerRecipeBookCategory category,
      Ingredient ingredient1,
      Ingredient ingredient2,
      Ingredient ingredient3,
      ItemStack result) {
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
  public RecipeSerializer<?> getSerializer() {
    return RecipeSerializerInit.INGOT_FUSION_TOLL_ENHANCER_RECIPE.get();
  }

  @Override
  public @NotNull RecipeType<?> getType() {
    return RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get();
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

  public ItemStack getResult(ItemStack ingredient1, ItemStack ingredient2, ItemStack ingredient3) {
    return isIngredient(ingredient1) && isIngredient(ingredient2) && isIngredient(ingredient3)
        ? this.result
        : ItemStack.EMPTY;
  }

  public static class Serializer implements RecipeSerializer<IngotFusionTollEnhancerRecipe> {

    private static final Codec<IngotFusionTollEnhancerRecipe> CODEC =
        RecordCodecBuilder.create(
            (p_44108_) ->
                p_44108_
                    .group(
                        IngotFusionTollEnhancerRecipeBookCategory.CODEC
                            .fieldOf("category")
                            .orElse(IngotFusionTollEnhancerRecipeBookCategory.MISC)
                            .forGetter(p_301108_ -> p_301108_.category),
                        Ingredient.CODEC
                            .fieldOf("ingredient1")
                            .forGetter((p_44105_) -> p_44105_.ingredient1),
                        Ingredient.CODEC
                            .fieldOf("ingredient2")
                            .forGetter((p_44104_) -> p_44104_.ingredient2),
                        Ingredient.CODEC
                            .fieldOf("ingredient3")
                            .forGetter((p_44106_) -> p_44106_.ingredient3),
                        CraftingRecipeCodecs.ITEMSTACK_OBJECT_CODEC
                            .fieldOf("result")
                            .forGetter((p_44103_) -> p_44103_.result))
                    .apply(p_44108_, IngotFusionTollEnhancerRecipe::new));

    @Override
    public @NotNull Codec<IngotFusionTollEnhancerRecipe> codec() {
      return CODEC;
    }

    @Override
    public @Nullable IngotFusionTollEnhancerRecipe fromNetwork(FriendlyByteBuf friendlyByteBuf) {
      val category = friendlyByteBuf.readEnum(IngotFusionTollEnhancerRecipeBookCategory.class);
      val ingredient1 = Ingredient.fromNetwork(friendlyByteBuf);
      val ingredient2 = Ingredient.fromNetwork(friendlyByteBuf);
      val ingredient3 = Ingredient.fromNetwork(friendlyByteBuf);
      val result = friendlyByteBuf.readItem();
      return new IngotFusionTollEnhancerRecipe(
          category, ingredient1, ingredient2, ingredient3, result);
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
