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
package io.github.realyusufismail.temporalsmith.datagen.advancment

import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.core.init.TagsInit
import java.util.function.Consumer
import net.minecraft.advancements.Advancement
import net.minecraft.advancements.CriterionTriggerInstance
import net.minecraft.advancements.FrameType
import net.minecraft.advancements.RequirementsStrategy
import net.minecraft.advancements.critereon.*
import net.minecraft.core.HolderLookup
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.level.ItemLike
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.common.data.ForgeAdvancementProvider

class Advancements : ForgeAdvancementProvider.AdvancementGenerator {

    private fun id(path: String): String {
        return TemporalSmith.getModIdAndName(path).toString()
    }

    private fun getItem(vararg items: ItemLike): CriterionTriggerInstance {
        return InventoryChangeTrigger.TriggerInstance.hasItems(*items)
    }

    private fun getItem(tag: TagKey<Item>): CriterionTriggerInstance {
        return InventoryChangeTrigger.TriggerInstance.hasItems(
            ItemPredicate(
                tag,
                null,
                MinMaxBounds.Ints.ANY,
                MinMaxBounds.Ints.ANY,
                EnchantmentPredicate.NONE,
                EnchantmentPredicate.NONE,
                null,
                NbtPredicate.ANY))
    }

    private fun title(key: String): Component {
        return Component.translatable("advancements." + TemporalSmith.MOD_ID + ".$key.title")
    }

    private fun description(key: String): Component {
        return Component.translatable("advancements." + TemporalSmith.MOD_ID + ".$key.description")
    }

    override fun generate(
        registries: HolderLookup.Provider,
        consumer: Consumer<Advancement>,
        existingFileHelper: ExistingFileHelper
    ) {
        val rootIcon = ItemStack(ItemInit.AMETHYST_SWORD.get())
        val root =
            Advancement.Builder.advancement()
                .display(
                    rootIcon,
                    title("root"),
                    description("root"),
                    ResourceLocation("minecraft:textures/block/light_blue_wool.png"),
                    FrameType.TASK,
                    true,
                    false,
                    false)
                .addCriterion("get_item", getItem(Items.CRAFTING_TABLE))
                .save(consumer, id("root"))

        // Ruby

        val rubyOre =
            Advancement.Builder.advancement()
                .parent(root)
                .display(
                    BlockInit.RUBY_ORE.get(),
                    title("ruby_ore"),
                    description("ruby_ore"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_ore", getItem(TagsInit.ItemTagsInit.ORES_RUBY))
                .save(consumer, id("ruby_ore"))

        val rubyIngot =
            Advancement.Builder.advancement()
                .parent(rubyOre)
                .display(
                    ItemInit.RUBY.get(),
                    title("ruby_ingot"),
                    description("ruby_ingot"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_scrap", getItem(TagsInit.ItemTagsInit.INGOTS_RUBY))
                .save(consumer, id("ruby_ingot"))

        Advancement.Builder.advancement()
            .parent(rubyIngot)
            .display(
                BlockInit.RUBY_BLOCK.get(),
                title("ruby_block"),
                description("ruby_block"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("get_block", getItem(TagsInit.ItemTagsInit.STORAGE_RUBY))
            .save(consumer, id("ruby_block"))

        Advancement.Builder.advancement()
            .parent(rubyIngot)
            .display(
                ItemInit.RUBY_HELMET.get(),
                title("ruby_armour"),
                description("ruby_armour"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("ruby_helmet", getItem(ItemInit.RUBY_HELMET.get()))
            .addCriterion("ruby_chestplate", getItem(ItemInit.RUBY_CHESTPLATE.get()))
            .addCriterion("ruby_leggings", getItem(ItemInit.RUBY_LEGGINGS.get()))
            .addCriterion("ruby_boots", getItem(ItemInit.RUBY_BOOTS.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("ruby_armour"))

        Advancement.Builder.advancement()
            .parent(rubyIngot)
            .display(
                ItemInit.RUBY_SWORD.get(),
                title("ruby_tools"),
                description("ruby_tools"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("ruby_sword", getItem(ItemInit.RUBY_SWORD.get()))
            .addCriterion("ruby_pickaxe", getItem(ItemInit.RUBY_PICKAXE.get()))
            .addCriterion("ruby_axe", getItem(ItemInit.RUBY_AXE.get()))
            .addCriterion("ruby_shovel", getItem(ItemInit.RUBY_SHOVEL.get()))
            .addCriterion("ruby_hoe", getItem(ItemInit.RUBY_HOE.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("ruby_tools"))

        // Sapphire

        val sapphireOre =
            Advancement.Builder.advancement()
                .parent(root)
                .display(
                    BlockInit.SAPPHIRE_ORE.get(),
                    title("sapphire_ore"),
                    description("sapphire_ore"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_ore", getItem(TagsInit.ItemTagsInit.ORES_SAPPHIRE))
                .save(consumer, id("sapphire_ore"))

        val sapphireIngot =
            Advancement.Builder.advancement()
                .parent(sapphireOre)
                .display(
                    ItemInit.SAPPHIRE.get(),
                    title("sapphire_ingot"),
                    description("sapphire_ingot"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_scrap", getItem(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE))
                .save(consumer, id("sapphire_ingot"))

        Advancement.Builder.advancement()
            .parent(sapphireIngot)
            .display(
                BlockInit.SAPPHIRE_BLOCK.get(),
                title("sapphire_block"),
                description("sapphire_block"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("get_block", getItem(TagsInit.ItemTagsInit.STORAGE_SAPPHIRE))
            .save(consumer, id("sapphire_block"))

        Advancement.Builder.advancement()
            .parent(sapphireIngot)
            .display(
                ItemInit.SAPPHIRE_HELMET.get(),
                title("sapphire_armour"),
                description("sapphire_armour"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("sapphire_helmet", getItem(ItemInit.SAPPHIRE_HELMET.get()))
            .addCriterion("sapphire_chestplate", getItem(ItemInit.SAPPHIRE_CHESTPLATE.get()))
            .addCriterion("sapphire_leggings", getItem(ItemInit.SAPPHIRE_LEGGINGS.get()))
            .addCriterion("sapphire_boots", getItem(ItemInit.SAPPHIRE_BOOTS.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("sapphire_armour"))

        Advancement.Builder.advancement()
            .parent(sapphireIngot)
            .display(
                ItemInit.SAPPHIRE_SWORD.get(),
                title("sapphire_tools"),
                description("sapphire_tools"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("sapphire_sword", getItem(ItemInit.SAPPHIRE_SWORD.get()))
            .addCriterion("sapphire_pickaxe", getItem(ItemInit.SAPPHIRE_PICKAXE.get()))
            .addCriterion("sapphire_axe", getItem(ItemInit.SAPPHIRE_AXE.get()))
            .addCriterion("sapphire_shovel", getItem(ItemInit.SAPPHIRE_SHOVEL.get()))
            .addCriterion("sapphire_hoe", getItem(ItemInit.SAPPHIRE_HOE.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("sapphire_tools"))

        // Graphite

        val graphiteOre =
            Advancement.Builder.advancement()
                .parent(root)
                .display(
                    BlockInit.GRAPHITE_ORE.get(),
                    title("graphite_ore"),
                    description("graphite_ore"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_ore", getItem(TagsInit.ItemTagsInit.ORES_GRAPHITE))
                .save(consumer, id("graphite_ore"))

        val graphiteIngot =
            Advancement.Builder.advancement()
                .parent(graphiteOre)
                .display(
                    ItemInit.GRAPHITE.get(),
                    title("graphite_ingot"),
                    description("graphite_ingot"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_scrap", getItem(TagsInit.ItemTagsInit.INGOTS_GRAPHITE))
                .save(consumer, id("graphite_ingot"))

        Advancement.Builder.advancement()
            .parent(graphiteIngot)
            .display(
                BlockInit.GRAPHITE_BLOCK.get(),
                title("graphite_block"),
                description("graphite_block"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("get_block", getItem(TagsInit.ItemTagsInit.STORAGE_GRAPHITE))
            .save(consumer, id("graphite_block"))

        Advancement.Builder.advancement()
            .parent(graphiteIngot)
            .display(
                ItemInit.GRAPHITE_HELMET.get(),
                title("graphite_armour"),
                description("graphite_armour"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("graphite_helmet", getItem(ItemInit.GRAPHITE_HELMET.get()))
            .addCriterion("graphite_chestplate", getItem(ItemInit.GRAPHITE_CHESTPLATE.get()))
            .addCriterion("graphite_leggings", getItem(ItemInit.GRAPHITE_LEGGINGS.get()))
            .addCriterion("graphite_boots", getItem(ItemInit.GRAPHITE_BOOTS.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("graphite_armour"))

        // Aqumarine

        val aqumarineOre =
            Advancement.Builder.advancement()
                .parent(root)
                .display(
                    BlockInit.AQUMARINE_ORE.get(),
                    title("aqumarine_ore"),
                    description("aqumarine_ore"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_ore", getItem(TagsInit.ItemTagsInit.ORES_AQUMARINE))
                .save(consumer, id("aqumarine_ore"))

        val aqumarineIngot =
            Advancement.Builder.advancement()
                .parent(aqumarineOre)
                .display(
                    ItemInit.AQUMARINE.get(),
                    title("aqumarine_ingot"),
                    description("aqumarine_ingot"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_scrap", getItem(TagsInit.ItemTagsInit.INGOTS_AQUMARINE))
                .save(consumer, id("aqumarine_ingot"))

        Advancement.Builder.advancement()
            .parent(aqumarineIngot)
            .display(
                BlockInit.AQUMARINE_BLOCK.get(),
                title("aqumarine_block"),
                description("aqumarine_block"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("get_block", getItem(TagsInit.ItemTagsInit.STORAGE_AQUMARINE))
            .save(consumer, id("aqumarine_block"))

        Advancement.Builder.advancement()
            .parent(aqumarineIngot)
            .display(
                ItemInit.AQUMARINE_HELMET.get(),
                title("aqumarine_armour"),
                description("aqumarine_armour"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("aqumarine_helmet", getItem(ItemInit.AQUMARINE_HELMET.get()))
            .addCriterion("aqumarine_chestplate", getItem(ItemInit.AQUMARINE_CHESTPLATE.get()))
            .addCriterion("aqumarine_leggings", getItem(ItemInit.AQUMARINE_LEGGINGS.get()))
            .addCriterion("aqumarine_boots", getItem(ItemInit.AQUMARINE_BOOTS.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("aqumarine_armour"))

        // Rainbow

        val rainbowOre =
            Advancement.Builder.advancement()
                .parent(root)
                .display(
                    BlockInit.RAINBOW_ORE.get(),
                    title("rainbow_ore"),
                    description("rainbow_ore"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_ore", getItem(TagsInit.ItemTagsInit.ORES_RAINBOW))
                .save(consumer, id("rainbow_ore"))

        val rainbowIngot =
            Advancement.Builder.advancement()
                .parent(rainbowOre)
                .display(
                    ItemInit.RAINBOW.get(),
                    title("rainbow_ingot"),
                    description("rainbow_ingot"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_scrap", getItem(TagsInit.ItemTagsInit.INGOTS_RAINBOW))
                .save(consumer, id("rainbow_ingot"))

        Advancement.Builder.advancement()
            .parent(rainbowIngot)
            .display(
                BlockInit.RAINBOW_BLOCK.get(),
                title("rainbow_block"),
                description("rainbow_block"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("get_block", getItem(TagsInit.ItemTagsInit.STORAGE_RAINBOW))
            .save(consumer, id("rainbow_block"))

        Advancement.Builder.advancement()
            .parent(rainbowIngot)
            .display(
                ItemInit.RAINBOW_HELMET.get(),
                title("rainbow_armour"),
                description("rainbow_armour"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("rainbow_helmet", getItem(ItemInit.RAINBOW_HELMET.get()))
            .addCriterion("rainbow_chestplate", getItem(ItemInit.RAINBOW_CHESTPLATE.get()))
            .addCriterion("rainbow_leggings", getItem(ItemInit.RAINBOW_LEGGINGS.get()))
            .addCriterion("rainbow_boots", getItem(ItemInit.RAINBOW_BOOTS.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("rainbow_armour"))

        // Enderite

        val enderiteOre =
            Advancement.Builder.advancement()
                .parent(root)
                .display(
                    BlockInit.ENDERITE_ORE.get(),
                    title("enderite_ore"),
                    description("enderite_ore"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_ore", getItem(TagsInit.ItemTagsInit.ORES_ENDERITE))
                .save(consumer, id("enderite_ore"))

        val enderiteIngot =
            Advancement.Builder.advancement()
                .parent(enderiteOre)
                .display(
                    ItemInit.ENDERITE.get(),
                    title("enderite_ingot"),
                    description("enderite_ingot"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_scrap", getItem(TagsInit.ItemTagsInit.INGOTS_ENDERITE))
                .save(consumer, id("enderite_ingot"))

        Advancement.Builder.advancement()
            .parent(enderiteIngot)
            .display(
                BlockInit.ENDERITE_BLOCK.get(),
                title("enderite_block"),
                description("enderite_block"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("get_block", getItem(TagsInit.ItemTagsInit.STORAGE_ENDERITE))
            .save(consumer, id("enderite_block"))

        Advancement.Builder.advancement()
            .parent(enderiteIngot)
            .display(
                ItemInit.ENDERITE_HELMET.get(),
                title("enderite_armour"),
                description("enderite_armour"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("enderite_helmet", getItem(ItemInit.ENDERITE_HELMET.get()))
            .addCriterion("enderite_chestplate", getItem(ItemInit.ENDERITE_CHESTPLATE.get()))
            .addCriterion("enderite_leggings", getItem(ItemInit.ENDERITE_LEGGINGS.get()))
            .addCriterion("enderite_boots", getItem(ItemInit.ENDERITE_BOOTS.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("enderite_armour"))

        Advancement.Builder.advancement()
            .parent(enderiteIngot)
            .display(
                ItemInit.ENDERITE_SWORD.get(),
                title("enderite_tools"),
                description("enderite_tools"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("enderite_sword", getItem(ItemInit.ENDERITE_SWORD.get()))
            .addCriterion("enderite_pickaxe", getItem(ItemInit.ENDERITE_PICKAXE.get()))
            .addCriterion("enderite_axe", getItem(ItemInit.ENDERITE_AXE.get()))
            .addCriterion("enderite_shovel", getItem(ItemInit.ENDERITE_SHOVEL.get()))
            .addCriterion("enderite_hoe", getItem(ItemInit.ENDERITE_HOE.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("enderite_tools"))

        // Imperium

        val imperiumOre =
            Advancement.Builder.advancement()
                .parent(root)
                .display(
                    BlockInit.IMPERIUM_ORE.get(),
                    title("imperium_ore"),
                    description("imperium_ore"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_ore", getItem(TagsInit.ItemTagsInit.ORES_IMPERIUM))
                .save(consumer, id("imperium_ore"))

        val imperiumIngot =
            Advancement.Builder.advancement()
                .parent(imperiumOre)
                .display(
                    ItemInit.IMPERIUM.get(),
                    title("imperium_ingot"),
                    description("imperium_ingot"),
                    null,
                    FrameType.GOAL,
                    true,
                    true,
                    false)
                .addCriterion("get_scrap", getItem(TagsInit.ItemTagsInit.INGOTS_IMPERIUM))
                .save(consumer, id("imperium_ingot"))

        Advancement.Builder.advancement()
            .parent(imperiumIngot)
            .display(
                ItemInit.IMPERIUM_SWORD.get(),
                title("imperium_tools"),
                description("imperium_tools"),
                null,
                FrameType.GOAL,
                true,
                true,
                false)
            .addCriterion("imperium_sword", getItem(ItemInit.IMPERIUM_SWORD.get()))
            .addCriterion("imperium_pickaxe", getItem(ItemInit.IMPERIUM_PICKAXE.get()))
            // .addCriterion("imperium_axe", getItem(ItemInit.IMPERIUM_AXE.get()))
            .requirements(RequirementsStrategy.OR)
            .save(consumer, id("imperium_tools"))
    }
}
