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
package io.github.realyusufismail.armourandtoolsmod.client

import io.github.realyusufismail.armourandtoolsmod.blocks.armour.CustomArmourCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.blocks.tool.CustomToolCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.client.renderer.trident.AqumarineTridentItemRenderer
import io.github.realyusufismail.armourandtoolsmod.core.init.EntityTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit
import net.minecraft.client.gui.screens.MenuScreens
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

object ClientSetup {

    fun clientSetup(event: FMLClientSetupEvent) {
        event.enqueueWork { registerScreens() }

        event.enqueueWork {
            ItemProperties.register(ItemInit.RUBY_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(
                ItemInit.AQUMARINE_SHIELD.get(), ResourceLocation("blocking")) {
                    stack: ItemStack,
                    _: ClientLevel?,
                    entity: LivingEntity?,
                    _: Int ->
                    if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
                }

            ItemProperties.register(ItemInit.RAINBOW_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(ItemInit.SAPPHIRE_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(ItemInit.GRAPHITE_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(
                ItemInit.AQUMARINE_TRIDENT.get(), ResourceLocation("throwing")) {
                    stack: ItemStack,
                    _: ClientLevel?,
                    entity: LivingEntity?,
                    _: Int ->
                    if (entity != null && entity.isUsingItem && entity.useItem == stack) {
                        1.0f
                    } else 0.0f
                }
        }
    }

    private fun registerScreens() {
        MenuScreens.register(
            MenuTypeInit.CUSTOM_ARMOUR_CRAFTING_TABLE_MENU.get(), ::CustomArmourCraftingTableScreen)

        MenuScreens.register(
            MenuTypeInit.CUSTOM_TOOL_CRAFTING_TABLE_MENU.get(), ::CustomToolCraftingTableScreen)
    }

    fun registerEntityRenders(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerEntityRenderer(
            EntityTypeInit.AQUMARINE_THROWN_TRIDENT.get(), ::AqumarineTridentItemRenderer)
    }
}
