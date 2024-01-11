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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.blocks.armour.CustomArmourCraftingTableMenu
import io.github.realyusufismail.temporalsmith.blocks.infusion.IngotFusionTollEnhancerMenu
import io.github.realyusufismail.temporalsmith.blocks.tool.CustomToolCraftingTableMenu
import net.minecraft.core.registries.Registries
import net.minecraft.world.flag.FeatureFlagSet
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.MenuType
import net.minecraft.world.inventory.MenuType.MenuSupplier
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object MenuTypeInit {
    val MENU: DeferredRegister<MenuType<*>> = DeferredRegister.create(Registries.MENU, MOD_ID)

    val CUSTOM_ARMOUR_CRAFTING_TABLE_MENU:
        DeferredHolder<MenuType<*>, MenuType<CustomArmourCraftingTableMenu>> =
        register("custom_armour_crafting_table", ::CustomArmourCraftingTableMenu)

    val CUSTOM_TOOL_CRAFTING_TABLE_MENU:
        DeferredHolder<MenuType<*>, MenuType<CustomToolCraftingTableMenu>> =
        register("custom_tool_crafting_table", ::CustomToolCraftingTableMenu)

    @JvmField
    val INGOT_FUSION_TOLL_ENHANCER_MENU:
        DeferredHolder<MenuType<*>, MenuType<IngotFusionTollEnhancerMenu>> =
        MENU.register("ingot_fusion_toll_enhancer") { ->
            IMenuTypeExtension.create { pContainerId, pInventory, pData ->
                IngotFusionTollEnhancerMenu(pContainerId, pInventory, pData)
            }
        }

    private fun <T : AbstractContainerMenu> register(
        name: String,
        pFactory: MenuSupplier<T>,
        featureFlagSet: FeatureFlagSet = FeatureFlags.REGISTRY.allFlags()
    ): DeferredHolder<MenuType<*>, MenuType<T>> {
        return MENU.register(name) { -> MenuType(pFactory, featureFlagSet) }
    }
}
