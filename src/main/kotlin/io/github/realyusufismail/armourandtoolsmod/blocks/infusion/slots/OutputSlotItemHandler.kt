package io.github.realyusufismail.armourandtoolsmod.blocks.infusion.slots

import net.minecraft.world.item.ItemStack
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.SlotItemHandler

class OutputSlotItemHandler(itemHandler: IItemHandler) : SlotItemHandler(itemHandler, 4, 138, 40) {

    override fun mayPlace(stack: ItemStack): Boolean {
        return false
    }
}