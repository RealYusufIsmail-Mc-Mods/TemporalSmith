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
package io.github.realyusufismail.armourandtoolsmod.items.shield

import io.github.realyusufismail.armourandtoolsmod.client.ArmourAndToolsModShieldItemRendererProvider
import java.util.function.Consumer
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.ShieldItem
import net.minecraft.world.item.Tier
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions

class ArmourToolsModShieldItem(durability: Int, private val tier: Tier) :
    ShieldItem(Properties().stacksTo(1).durability(durability)) {
    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(ArmourAndToolsModShieldItemRendererProvider.shield())
    }

    override fun isValidRepairItem(toRepair: ItemStack, repair: ItemStack): Boolean {
        return this.tier.repairIngredient.test(repair)
    }
}
