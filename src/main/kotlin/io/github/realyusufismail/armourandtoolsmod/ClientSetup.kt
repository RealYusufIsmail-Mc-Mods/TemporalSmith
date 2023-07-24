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
package io.github.realyusufismail.armourandtoolsmod

import io.github.realyusufismail.armourandtoolsmod.core.blocks.armour.CustomArmourCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.core.blocks.tool.CustomToolCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.core.init.MenuTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.shields.*
import net.minecraft.client.gui.screens.MenuScreens
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegisterEvent

object ClientSetup {

    fun init(event: FMLClientSetupEvent) {
        event.enqueueWork { registerScreens() }
    }
    private fun registerScreens() {
        MenuScreens.register(
            MenuTypeInit.CUSTOM_ARMOUR_CRAFTING_TABLE_MENU.get(), ::CustomArmourCraftingTableScreen)

        MenuScreens.register(
            MenuTypeInit.CUSTOM_TOOL_CRAFTING_TABLE_MENU.get(), ::CustomToolCraftingTableScreen)
    }

    public fun registerShields(event: RegisterEvent) {
        event.register(ForgeRegistries.Keys.ITEMS) {
            it.register(ResourceLocation(MOD_ID, "ruby_shield"), RubyShield())
            it.register(ResourceLocation(MOD_ID, "aqumarine_shield"), AqumarineShield())
            it.register(ResourceLocation(MOD_ID, "graphite_shield"), GraphiteShield())
            it.register(ResourceLocation(MOD_ID, "rainbow_shield"), RainbowShield())
            it.register(ResourceLocation(MOD_ID, "saphire_shield"), SaphireShield())
        }
    }
}
