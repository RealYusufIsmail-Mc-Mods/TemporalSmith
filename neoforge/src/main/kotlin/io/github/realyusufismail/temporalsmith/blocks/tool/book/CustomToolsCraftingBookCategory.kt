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
package io.github.realyusufismail.temporalsmith.blocks.tool.book

import net.minecraft.util.StringRepresentable

enum class CustomToolsCraftingBookCategory(private var bookName: String) : StringRepresentable {
    SWORD("sword"),
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    HOE("hoe"),
    SHIELD("shield"),
    TRIDENT("trident"),
    MISC("misc");

    companion object {
        @JvmField
        val CODEC: StringRepresentable.EnumCodec<CustomToolsCraftingBookCategory> =
            StringRepresentable.fromEnum { entries.toTypedArray() }
    }

    override fun getSerializedName(): String {
        return bookName
    }
}
