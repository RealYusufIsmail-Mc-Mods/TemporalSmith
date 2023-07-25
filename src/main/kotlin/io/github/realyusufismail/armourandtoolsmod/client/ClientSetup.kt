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
package io.github.realyusufismail.armourandtoolsmod.client

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.core.blocks.armour.CustomArmourCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.core.blocks.tool.CustomToolCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit
import net.minecraft.client.gui.screens.MenuScreens
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent
import net.minecraftforge.client.extensions.common.IClientItemExtensions
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

object ClientSetup {
    private var shieldItemRenderer: ArmourAndToolsModShieldItemRenderer? = null

    fun shieldInit(event: RegisterClientReloadListenersEvent) {
        shieldItemRenderer = ArmourAndToolsModShieldItemRenderer()

        shieldItemRenderer?.let { event.registerReloadListener(it) }
            ?: run { ArmourAndToolsMod.logger.error("Failed to register shield renderer") }
    }

    fun clientSetup(event: FMLClientSetupEvent) {
        event.enqueueWork { registerScreens() }

        ItemProperties.register(ItemInit.RUBY_SHIELD.get(), ResourceLocation("blocking")) {
            stack: ItemStack,
            _: ClientLevel?,
            entity: LivingEntity?,
            _: Int ->
            if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
        }

        ItemProperties.register(ItemInit.AQUMARINE_SHIELD.get(), ResourceLocation("blocking")) {
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
    }

    private fun registerScreens() {
        MenuScreens.register(
            MenuTypeInit.CUSTOM_ARMOUR_CRAFTING_TABLE_MENU.get(), ::CustomArmourCraftingTableScreen)

        MenuScreens.register(
            MenuTypeInit.CUSTOM_TOOL_CRAFTING_TABLE_MENU.get(), ::CustomToolCraftingTableScreen)
    }

    fun shield(): IClientItemExtensions {
        return object : IClientItemExtensions {
            override fun getCustomRenderer(): ArmourAndToolsModShieldItemRenderer? {
                return shieldItemRenderer
            }
        }
    }
}
