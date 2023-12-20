package io.github.realyusufismail.temporalsmith.core.init

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

class MainItemGroup(name : String) : ItemGroup(ItemGroup.TABS.size, name) {
    override fun makeIcon(): ItemStack = ItemInit.RUBY.get().defaultInstance
}