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
package io.github.realyusufismail.armourandtoolsmod.core.itemgroup

import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.flag.FeatureFlagSet
import net.minecraft.world.item.*
import net.minecraft.world.level.block.Block
import net.minecraftforge.event.CreativeModeTabEvent
import net.minecraftforge.registries.RegistryObject

object ArmourAndToolsGroup {
    /**
     * Registers the creative tab.
     *
     * @param event The event.
     */
    fun registerCreativeTab(event: CreativeModeTabEvent.Register) {
        event.registerCreativeModeTab(ResourceLocation(MOD_ID, "creativetab")) {
            obj: CreativeModeTab.Builder ->
            createCreativeTabBuilder(obj)
        }
    }

    private fun createCreativeTabBuilder(builder: CreativeModeTab.Builder) {

        builder.displayItems { _: FeatureFlagSet, out: CreativeModeTab.Output, _: Boolean ->
            ItemInit.ITEMS.entries
                .stream()
                .map { item: RegistryObject<Item> -> item.get().asItem() }
                .forEach { pItem: Item -> out.accept(pItem) }

            BlockInit.BLOCKS.entries
                .stream()
                .map { item: RegistryObject<Block> -> item.get().asItem() }
                .forEach { pItem: Item -> out.accept(pItem) }
        }
        builder.icon { ItemStack(ItemInit.AQUMARINE.get()) }
        builder.title(Component.translatable("creativetab.armourandtoolsmod"))
        builder.withSearchBar()
    }
}
