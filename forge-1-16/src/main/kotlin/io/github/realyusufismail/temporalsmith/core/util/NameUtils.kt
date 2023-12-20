package io.github.realyusufismail.temporalsmith.core.util

import net.minecraft.item.Item

val Item.name: String
    get() = this.toString()