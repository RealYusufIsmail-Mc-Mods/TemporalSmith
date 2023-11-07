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
package io.github.realyusufismail.armourandtoolsmod.datagen.recipe.builder

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.google.common.collect.Sets
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.github.realyusufismail.armourandtoolsmod.blocks.armour.book.CustomArmourCraftingBookCategory
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit
import io.github.realyusufismail.realyusufismailcore.recipe.util.EnchantmentsAndLevels
import java.util.*
import net.minecraft.advancements.*
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.level.ItemLike
import net.neoforged.neoforge.registries.ForgeRegistries

/** @see net.minecraft.data.recipes.ShapedRecipeBuilder */
object CustomArmourCraftingTableRecipeBuilder {
    private val rows: MutableList<String> = Lists.newArrayList()
    private val key: MutableMap<Char, Ingredient> = Maps.newLinkedHashMap()
    private val criteria: MutableMap<String, Criterion<*>> = Maps.newLinkedHashMap()
    private var group: String? = null
    private var bookCategory: CustomArmourCraftingBookCategory? = null

    private var recipeCategory: RecipeCategory? = null
    private var count: Int? = null
    private var result: Item? = null
    private var showNotification: Boolean = false
    private var enchantmentsAndLevels: EnchantmentsAndLevels = EnchantmentsAndLevels()
    private var hideFlags: Boolean = false

    fun shaped(
        bookCategory: CustomArmourCraftingBookCategory,
        recipeCategory: RecipeCategory,
        itemLike: ItemLike,
    ): CustomArmourCraftingTableRecipeBuilder {
        return shaped(bookCategory, recipeCategory, itemLike, 1)
    }

    fun shaped(
        bookCategory: CustomArmourCraftingBookCategory,
        recipeCategory: RecipeCategory,
        itemLike: ItemLike,
        count: Int,
    ): CustomArmourCraftingTableRecipeBuilder {
        this.recipeCategory = recipeCategory
        this.result = itemLike.asItem()
        this.count = count
        this.bookCategory = bookCategory
        return this
    }

    fun define(character: Char, itemTag: TagKey<Item>): CustomArmourCraftingTableRecipeBuilder {
        return this.define(character, Ingredient.of(itemTag))
    }

    fun define(character: Char, itemLike: ItemLike): CustomArmourCraftingTableRecipeBuilder {
        return this.define(character, Ingredient.of(itemLike))
    }

    private fun define(
        character: Char,
        ingredient: Ingredient,
    ): CustomArmourCraftingTableRecipeBuilder {
        if (key.containsKey(character)) {
            throw IllegalArgumentException("Symbol '$character' is already defined!")
        } else if (character == ' ') {
            throw IllegalArgumentException(
                "Symbol ' ' (whitespace) is reserved and cannot be defined")
        } else {
            key[character] = ingredient
            return this
        }
    }

    fun pattern(pattern: String): CustomArmourCraftingTableRecipeBuilder {
        if (rows.isNotEmpty() && pattern.length != rows[0].length) {
            throw IllegalArgumentException("Pattern must be the same width on every line!")
        } else {
            rows.add(pattern)
            return this
        }
    }

    fun unlockedBy(
        creterionId: String,
        criterion: Criterion<*>,
    ): CustomArmourCraftingTableRecipeBuilder {
        this.criteria.put(creterionId, criterion)
        return this
    }

    fun group(group: String): CustomArmourCraftingTableRecipeBuilder {
        this.group = group
        return this
    }

    fun addEnchantment(
        enchantment: Enchantment,
        level: Int
    ): CustomArmourCraftingTableRecipeBuilder {
        enchantmentsAndLevels.add(enchantment, level)
        return this
    }

    fun setHideFlags(hideFlags: Boolean): CustomArmourCraftingTableRecipeBuilder {
        this.hideFlags = hideFlags
        return this
    }

    fun showNotification(p_273326_: Boolean): CustomArmourCraftingTableRecipeBuilder {
        this.showNotification = p_273326_
        return this
    }

    fun getResult(): Item {
        return result ?: throw IllegalStateException("Result is not set")
    }

    fun save(
        recipeOutput: RecipeOutput,
        resourceLocation: ResourceLocation,
    ) {
        ensureValid(resourceLocation)

        val advancementBuilder: Advancement.Builder? =
            recipeOutput
                .advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation))
                .rewards(AdvancementRewards.Builder.recipe(resourceLocation))
                .requirements(AdvancementRequirements.Strategy.OR)

        recipeOutput.accept(
            Result(
                bookCategory ?: throw IllegalStateException("Recipe category is not set"),
                resourceLocation,
                result ?: throw IllegalStateException("Result is not set"),
                count ?: throw IllegalStateException("Count is not set"),
                group ?: "",
                rows,
                key,
                advancementBuilder!!.build(
                    resourceLocation.withPrefix(
                        "recipes/" + this.recipeCategory!!.folderName + "/")),
                showNotification,
                enchantmentsAndLevels,
                hideFlags))
        clear()
    }

    private fun clear() {
        rows.clear()
        key.clear()
        group = null
        bookCategory = null
        recipeCategory = null
        count = null
        result = null
    }

    private fun ensureValid(resourceLocation: ResourceLocation) {
        if (rows.isEmpty()) {
            throw IllegalStateException(
                "No pattern is defined for shaped recipe $resourceLocation!")
        } else {
            val set: MutableSet<Char> = Sets.newHashSet(key.keys)
            set.remove(' ')
            for (s: String in rows) {
                for (element in s) {
                    val c0 = element
                    if (!key.containsKey(c0) && c0 != ' ') {
                        throw IllegalStateException(
                            "Pattern in recipe " +
                                resourceLocation +
                                " uses undefined symbol '" +
                                c0 +
                                "'")
                    }
                    set.remove(c0)
                }
            }
            if (!set.isEmpty()) {
                throw IllegalStateException(
                    ("Ingredients are defined but not used in pattern for recipe " +
                        resourceLocation))
            } else if (rows.size == 1 && rows[0].length == 1) {
                throw IllegalStateException(
                    ("Shaped recipe " +
                        resourceLocation +
                        " only takes in a single item - should it be a shapeless recipe instead?"))
            } else if (criteria.isEmpty() == true) {
                throw IllegalStateException("No way of obtaining recipe $resourceLocation")
            }
        }
    }

    class Result(
        private val category: CustomArmourCraftingBookCategory,
        id: ResourceLocation,
        result: Item,
        count: Int,
        group: String,
        pattern: List<String>,
        key: Map<Char, Ingredient>,
        advancement: AdvancementHolder,
        private val showNotification: Boolean,
        private val enchantmentsAndLevels: EnchantmentsAndLevels,
        private val hideFlags: Boolean,
    ) : FinishedRecipe {
        override fun serializeRecipeData(jsonObject: JsonObject) {
            if (group.isNotEmpty()) {
                jsonObject.addProperty("group", group)
            }

            jsonObject.addProperty("category", this.category.serializedName)
            val jsonarray = JsonArray()
            for (s: String in pattern) {
                jsonarray.add(s)
            }
            jsonObject.add("pattern", jsonarray)
            val jsonObject1 = JsonObject()
            for (entry: Map.Entry<Char, Ingredient> in key.entries) {
                jsonObject1.add(entry.key.toString(), entry.value.toJson(false))
            }
            jsonObject.add("key", jsonObject1)
            val jsonObject2 = JsonObject()
            jsonObject2.addProperty(
                "item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result)).toString())
            if (count > 1) {
                jsonObject2.addProperty("count", count)
            }

            // enchantment
            if (enchantmentsAndLevels.isNotEmpty()) {
                val jsonArray1 = JsonArray()
                val jsonObject3 = JsonObject()
                val jsonObject4 = JsonObject()
                for (entry: Map.Entry<Enchantment, Int> in enchantmentsAndLevels.entries) {
                    jsonObject4.addProperty(
                        "id",
                        Objects.requireNonNull(ForgeRegistries.ENCHANTMENTS.getKey(entry.key))
                            .toString())
                    jsonObject4.addProperty("lvl", entry.value)
                    jsonArray1.add(jsonObject4)
                }
                jsonObject3.add("Enchantments", jsonArray1)
                jsonObject3.addProperty("HideFlags", hideFlags)
                jsonObject2.add("nbt", jsonObject3)
            }

            jsonObject.addProperty("show_notification", showNotification)
            jsonObject.add("result", jsonObject2)
        }

        override fun id(): ResourceLocation {
            return advancement.id()
        }

        override fun type(): RecipeSerializer<*> {
            return RecipeSerializerInit.CUSTOM_ARMOUR_CRAFTER.get()
        }

        override fun advancement(): AdvancementHolder {
            return advancement
        }

        private val id: ResourceLocation
        private val result: Item
        private val count: Int
        private val group: String
        private val pattern: List<String>
        private val key: Map<Char, Ingredient>
        private val advancement: AdvancementHolder

        init {
            this.id = id
            this.result = result
            this.count = count
            this.group = group
            this.pattern = pattern
            this.key = key
            this.advancement = advancement
        }
    }
}
