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
package io.github.realyusufismail.armourandtoolsmod.recipe.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.realyusufismail.armourandtoolsmod.blocks.armour.book.CustomArmourCraftingBookCategory;
import io.github.realyusufismail.armourandtoolsmod.recipe.armour.CustomArmourCraftingTableShapedRecipe;
import java.util.List;
import java.util.Map;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipeCodecs;
import net.minecraft.world.item.crafting.Ingredient;

public record CustomArmourCraftingTableRawShapedRecipe(
    String group,
    CustomArmourCraftingBookCategory category,
    Map<String, Ingredient> key,
    List<String> pattern,
    ItemStack result,
    boolean showNotification) {
  static final Codec<String> SINGLE_CHARACTER_STRING_CODEC =
      Codec.STRING.flatXmap(
          p_300861_ -> {
            if (p_300861_.length() != 1) {
              return DataResult.error(
                  () ->
                      "Invalid key entry: '"
                          + p_300861_
                          + "' is an invalid symbol (must be 1 character only).");
            } else {
              return " ".equals(p_300861_)
                  ? DataResult.error(() -> "Invalid key entry: ' ' is a reserved symbol.")
                  : DataResult.success(p_300861_);
            }
          },
          DataResult::success);

  static final Codec<List<String>> PATTERN_CODEC =
      Codec.STRING
          .listOf()
          .flatXmap(
              p_300940_ -> {
                if (p_300940_.size() > CustomArmourCraftingTableShapedRecipe.MAX_HEIGHT) {
                  return DataResult.error(
                      () ->
                          "Invalid pattern: too many rows, %s is maximum"
                              .formatted(CustomArmourCraftingTableShapedRecipe.MAX_HEIGHT));
                } else if (p_300940_.isEmpty()) {
                  return DataResult.error(() -> "Invalid pattern: empty pattern not allowed");
                } else {
                  int i = p_300940_.get(0).length();

                  for (String s : p_300940_) {
                    if (s.length() > CustomArmourCraftingTableShapedRecipe.MAX_WIDTH) {
                      return DataResult.error(
                          () ->
                              "Invalid pattern: too many columns, %s is maximum"
                                  .formatted(CustomArmourCraftingTableShapedRecipe.MAX_WIDTH));
                    }

                    if (i != s.length()) {
                      return DataResult.error(
                          () -> "Invalid pattern: each row must be the same width");
                    }
                  }

                  return DataResult.success(p_300940_);
                }
              },
              DataResult::success);

  public static final Codec<CustomArmourCraftingTableRawShapedRecipe> CODEC =
      RecordCodecBuilder.create(
          (p_44108_) ->
              p_44108_
                  .group(
                      ExtraCodecs.strictOptionalField(Codec.STRING, "group", "")
                          .forGetter(p_301109_ -> p_301109_.group),
                      CustomArmourCraftingBookCategory.CODEC
                          .fieldOf("category")
                          .orElse(CustomArmourCraftingBookCategory.MISC)
                          .forGetter(p_301108_ -> p_301108_.category),
                      ExtraCodecs.strictUnboundedMap(
                              SINGLE_CHARACTER_STRING_CODEC, Ingredient.CODEC_NONEMPTY)
                          .fieldOf("key")
                          .forGetter(p_301234_ -> p_301234_.key),
                      PATTERN_CODEC.fieldOf("pattern").forGetter(p_301164_ -> p_301164_.pattern),
                      CraftingRecipeCodecs.ITEMSTACK_OBJECT_CODEC
                          .fieldOf("result")
                          .forGetter(p_301076_ -> p_301076_.result),
                      ExtraCodecs.strictOptionalField(Codec.BOOL, "show_notification", true)
                          .forGetter(p_301293_ -> p_301293_.showNotification))
                  .apply(p_44108_, CustomArmourCraftingTableRawShapedRecipe::new));
}
