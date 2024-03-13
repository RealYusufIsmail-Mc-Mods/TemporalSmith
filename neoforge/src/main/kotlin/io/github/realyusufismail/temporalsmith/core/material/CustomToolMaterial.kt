/*
 * Copyright 2024 RealYusufIsmail.
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
package io.github.realyusufismail.temporalsmith.core.material

import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.core.init.TagsInit
import java.util.function.Supplier
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Items
import net.minecraft.world.item.Tier
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Block

enum class CustomToolMaterial(
    private val harvestLevel: Int,
    private val maxUses: Int,
    private val enchantability: Int,
    private val speed: Float,
    private val tag: TagKey<Block>,
    private val repairMaterial: Supplier<Ingredient>
) : Tier {
    RUBY_SWORD(
        3,
        2000,
        10,
        0.0f,
        TagsInit.BlockTagsInit.NEEDS_RUBY_TOOL,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_PICKAXE(
        3,
        2500,
        10,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_RUBY_TOOL,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_AXE(
        3,
        2500,
        10,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_RUBY_TOOL,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_SHOVEL(
        3,
        2500,
        10,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_RUBY_TOOL,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    RUBY_HOE(
        3,
        2500,
        10,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_RUBY_TOOL,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    ENDERITE_SWORD(
        4,
        3000,
        15,
        0.0f,
        TagsInit.BlockTagsInit.NEEDS_ENDERITE_TOOL,
        Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_PICKAXE(
        4,
        3000,
        15,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_ENDERITE_TOOL,
        Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_AXE(
        4,
        3000,
        15,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_ENDERITE_TOOL,
        Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_SHOVEL(
        4,
        3000,
        15,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_ENDERITE_TOOL,
        Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    ENDERITE_HOE(
        4,
        3000,
        15,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_ENDERITE_TOOL,
        Supplier { Ingredient.of(ItemInit.ENDERITE.get()) }),
    AMETHYST_SWORD(
        4,
        2500,
        12,
        0.0f,
        TagsInit.BlockTagsInit.NEEDS_AMETHYST_TOOL,
        Supplier { Ingredient.of(Items.AMETHYST_SHARD) }),
    AMETHYST_PICKAXE(
        4,
        2500,
        12,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_AMETHYST_TOOL,
        Supplier { Ingredient.of(Items.AMETHYST_SHARD) }),
    AMETHYST_AXE(
        4,
        2500,
        12,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_AMETHYST_TOOL,
        Supplier { Ingredient.of(Items.AMETHYST_SHARD) }),
    AMETHYST_SHOVEL(
        4,
        2500,
        12,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_AMETHYST_TOOL,
        Supplier { Ingredient.of(Items.AMETHYST_SHARD) }),
    SAPPHIRE_SWORD(
        5,
        3000,
        12,
        0.0f,
        TagsInit.BlockTagsInit.NEEDS_SAPPHIRE_TOOL,
        Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_PICKAXE(
        5,
        3000,
        12,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_SAPPHIRE_TOOL,
        Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_AXE(
        5,
        3000,
        12,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_SAPPHIRE_TOOL,
        Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_SHOVEL(
        5,
        3000,
        12,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_SAPPHIRE_TOOL,
        Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    SAPPHIRE_HOE(
        5,
        3000,
        12,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_SAPPHIRE_TOOL,
        Supplier { Ingredient.of(ItemInit.SAPPHIRE.get()) }),
    IMPERIUM_SWORD(
        6,
        4000,
        20,
        0.0f,
        TagsInit.BlockTagsInit.NEEDS_IMPERIUM_TOOL,
        Supplier { Ingredient.of(ItemInit.IMPERIUM.get()) }),
    IMPERIUM_PICKAXE(
        6,
        4000,
        20,
        4.0f,
        TagsInit.BlockTagsInit.NEEDS_IMPERIUM_TOOL,
        Supplier { Ingredient.of(ItemInit.IMPERIUM.get()) }),
    MAGMA_STRIKE_PICKAXE(
        6,
        8000,
        20,
        4.0f,
        BlockTags.NEEDS_DIAMOND_TOOL,
        Supplier { Ingredient.of(ItemInit.IMPERIUM.get()) }),
    DRAGON_DESTROYER(
        7,
        10000,
        25,
        4.0f,
        BlockTags.NEEDS_DIAMOND_TOOL,
        Supplier { Ingredient.of(ItemInit.RUBY.get()) }),
    MJOLNIR(
        10,
        50000,
        0,
        4.0f,
        BlockTags.NEEDS_DIAMOND_TOOL,
        Supplier { Ingredient.of(ItemInit.GRAPHITE.get()) }),
    STORMBREAKER(
        10,
        50000,
        0,
        4.0f,
        BlockTags.NEEDS_DIAMOND_TOOL,
        Supplier { Ingredient.of(ItemInit.GRAPHITE.get()) }),
    AQUMARINE_TRIDENT(
        7,
        30000,
        5,
        4.0f,
        BlockTags.NEEDS_DIAMOND_TOOL,
        Supplier { Ingredient.of(ItemInit.AQUMARINE.get()) });

    override fun getUses(): Int {
        return maxUses
    }

    override fun getSpeed(): Float {
        return speed
    }

    /** @return This is set to 0 as the main attack damage is set in the item class */
    override fun getAttackDamageBonus(): Float {
        return 0f
    }

    @Deprecated("Deprecated in Java", ReplaceWith("harvestLevel"))
    override fun getLevel(): Int {
        return harvestLevel
    }

    override fun getEnchantmentValue(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairMaterial.get()
    }

    override fun getTag(): TagKey<Block> {
        return tag
    }
}
