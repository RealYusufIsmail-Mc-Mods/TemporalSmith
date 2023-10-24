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
package io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots

import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerBlockEntity
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerMenu
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.SlotItemHandler

class InfusionFuelSlot(itemHandler: IItemHandler, private val menu: IngotFusionTollEnhancerMenu) :
    SlotItemHandler(itemHandler, IngotFusionTollEnhancerBlockEntity.FUEL_SLOT, 102, 65) {

    override fun mayPlace(stack: ItemStack): Boolean {
        return menu.isFuel(stack) || isBucket(stack)
    }

    override fun getMaxStackSize(pStack: ItemStack): Int {
        return if (isBucket(pStack)) 1 else super.getMaxStackSize(pStack)
    }

    private fun isBucket(pStack: ItemStack): Boolean {
        return pStack.`is`(Items.BUCKET)
    }
}
