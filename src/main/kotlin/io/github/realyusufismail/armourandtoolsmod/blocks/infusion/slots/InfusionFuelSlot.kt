package io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots

import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerMenu
import net.minecraft.world.inventory.FurnaceFuelSlot
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.SlotItemHandler

class InfusionFuelSlot(itemHandler: IItemHandler, private val menu : IngotFusionTollEnhancerMenu) : SlotItemHandler(itemHandler, 3, 110, 65) {

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