/*
 * Copyright 2022 RealYusufIsmail.
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
package io.github.realyusufismail.armourandtoolsmod.datagen.advancment

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.init.TagsInit
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
    private fun simpleGetItem(
        consumer: Consumer<Advancement>,
        item: ItemLike,
        parent: Advancement
    ): Advancement {
        return simpleGetItem(consumer, item, parent, item.asItem().toString())
    }

    private fun simpleGetItem(
        consumer: Consumer<Advancement>,
        item: ItemLike,
        parent: Advancement,
        key: String
    ): Advancement {
        return simpleGetItem(consumer, item, ItemStack(item), parent, key)
    }

    private fun simpleGetItem(
        consumer: Consumer<Advancement>,
        item: ItemLike,
        icon: ItemStack,
        parent: Advancement,
        key: String
    ): Advancement {
        return Advancement.Builder.advancement()
            .parent(parent)
            .display(icon, title(key), description(key), null, FrameType.TASK, true, true, false)
            .addCriterion("get_item", getItem(item))
            .save(consumer, id(key))
    }

    private fun id(path: String): String {
        return ArmourAndToolsMod.getModIdAndName(path).toString()
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
        return Component.translatable("advancements." + ArmourAndToolsMod.MOD_ID + ".$key.title")
    }

    private fun description(key: String): Component {
        return Component.translatable(
            "advancements." + ArmourAndToolsMod.MOD_ID + ".$key.description")
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
    }
}
