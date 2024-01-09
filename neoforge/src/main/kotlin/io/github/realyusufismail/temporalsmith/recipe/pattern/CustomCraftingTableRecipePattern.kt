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
package io.github.realyusufismail.temporalsmith.recipe.pattern

import com.google.common.annotations.VisibleForTesting
import com.mojang.serialization.Codec
import com.mojang.serialization.DataResult
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.github.realyusufismail.temporalsmith.blocks.common.CustomCraftingTableContainer
import it.unimi.dsi.fastutil.chars.CharArraySet
import it.unimi.dsi.fastutil.chars.CharSet
import java.util.*
import java.util.function.Function
import kotlin.math.max
import kotlin.math.min
import net.minecraft.Util
import net.minecraft.core.NonNullList
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.util.ExtraCodecs
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.ShapedRecipePattern

/** @see ShapedRecipePattern */
@JvmRecord
data class CustomCraftingTableRecipePattern(
    val width: Int,
    val height: Int,
    val ingredients: NonNullList<Ingredient>,
    val data: Optional<Data>
) {
    fun setCraftingSize(width: Int, height: Int) {
        if (maxWidth < width) maxWidth = width
        if (maxHeight < height) maxHeight = height
    }

    fun matches(container: CustomCraftingTableContainer): Boolean {
        for (i in 0 until container.width - width + 1) {
            for (j in 0 until container.height - height + 1) {
                if (matches(container, i, j, true) || matches(container, i, j, false)) {
                    return true
                }
            }
        }
        return false
    }

    private fun <T : CustomCraftingTableContainer> matches(
        container: T,
        offsetX: Int,
        offsetY: Int,
        reverse: Boolean
    ): Boolean {
        for (i in 0 until container.width) {
            for (j in 0 until container.height) {
                val k = i - offsetX
                val l = j - offsetY
                val ingredient: Ingredient =
                    if (k >= 0 && l >= 0 && k < width && l < height) {
                        if (reverse) {
                            ingredients[width - k - 1 + l * width]
                        } else {
                            ingredients[k + l * width]
                        }
                    } else {
                        Ingredient.EMPTY
                    }

                if (!ingredient.test(container.getItem(i + j * container.width))) {
                    return false
                }
            }
        }
        return true
    }

    fun toNetwork(buffer: FriendlyByteBuf) {
        buffer.writeVarInt(width)
        buffer.writeVarInt(height)

        for (ingredient in ingredients) {
            ingredient.toNetwork(buffer)
        }
    }

    companion object {
        var maxWidth: Int = 3
        var maxHeight: Int = 3

        val MAP_CODEC: MapCodec<CustomCraftingTableRecipePattern> =
            Data.MAP_CODEC.flatXmap(
                { shapedRecipePattern -> unpack(shapedRecipePattern) },
                { p_311830_ ->
                    p_311830_.data
                        .map { DataResult.success(it) }
                        .orElseGet { DataResult.error { "Cannot encode unpacked recipe" } }
                })

        fun of(
            p_312851_: Map<Char, Ingredient>,
            vararg p_312645_: String
        ): CustomCraftingTableRecipePattern {
            return of(p_312851_, listOf(*p_312645_))
        }

        fun of(
            p_312370_: Map<Char, Ingredient>,
            p_312701_: List<String>
        ): CustomCraftingTableRecipePattern {
            val `shapedrecipepattern$data` = Data(p_312370_, p_312701_)
            return Util.getOrThrow(unpack(`shapedrecipepattern$data`)) { s: String? ->
                IllegalArgumentException(s)
            }
        }

        private fun unpack(p_312037_: Data): DataResult<CustomCraftingTableRecipePattern> {
            val astring = shrink(p_312037_.pattern)
            val i = astring[0]!!.length
            val j = astring.size
            val nonnulllist = NonNullList.withSize(i * j, Ingredient.EMPTY)
            val charset: CharSet = CharArraySet(p_312037_.key.keys)

            for (k in astring.indices) {
                val s = astring[k]

                for (l in 0 until s!!.length) {
                    val c0 = s[l]
                    val ingredient = if (c0 == ' ') Ingredient.EMPTY else p_312037_.key[c0]
                    if (ingredient == null) {
                        return DataResult.error {
                            "Pattern references symbol '$c0' but it's not defined in the key"
                        }
                    }

                    charset.remove(c0)
                    nonnulllist[l + i * k] = ingredient
                }
            }

            return if (!charset.isEmpty())
                DataResult.error {
                    "Key defines symbols that aren't used in pattern: ${charset.joinToString()} "
                }
            else
                DataResult.success(
                    CustomCraftingTableRecipePattern(i, j, nonnulllist, Optional.of(p_312037_)))
                    as DataResult<CustomCraftingTableRecipePattern>
        }

        @VisibleForTesting
        fun shrink(p_311893_: List<String>): Array<String> {
            var i = Int.MAX_VALUE
            var j = 0
            var k = 0
            var l = 0

            for (i1 in p_311893_.indices) {
                val s = p_311893_[i1]
                i = min(i, firstNonSpace(s))
                val j1 = lastNonSpace(s)
                j = max(j, j1)
                if (j1 < 0) {
                    if (k == i1) {
                        k++
                    }
                    l++
                } else {
                    l = 0
                }
            }

            return if (p_311893_.size == l) {
                emptyArray()
            } else {
                val astring = Array(p_311893_.size - l - k) { "" }

                for (k1 in astring.indices) {
                    astring[k1] = p_311893_[k1 + k].substring(i, j + 1)
                }

                astring
            }
        }

        private fun firstNonSpace(p_312343_: String): Int {
            var i = 0

            while (i < p_312343_.length && p_312343_[i] == ' ') {
                ++i
            }

            return i
        }

        private fun lastNonSpace(p_311944_: String): Int {
            var i = p_311944_.length - 1

            while (i >= 0 && p_311944_[i] == ' ') {
                --i
            }

            return i
        }

        fun fromNetwork(buffer: FriendlyByteBuf): CustomCraftingTableRecipePattern {
            val width = buffer.readVarInt()
            val height = buffer.readVarInt()
            val ingredients = NonNullList.withSize(width * height, Ingredient.EMPTY)

            repeat(width * height) { ingredients.add(Ingredient.fromNetwork(buffer)) }

            return CustomCraftingTableRecipePattern(width, height, ingredients, Optional.empty())
        }

        @JvmRecord
        data class Data(public val key: Map<Char, Ingredient>, val pattern: List<String>) {
            init {
                Companion.key = key
                Companion.pattern = pattern
            }

            companion object {
                var key: Map<Char, Ingredient> = mapOf()
                var pattern: List<String> = listOf()

                private val PATTERN_CODEC: Codec<List<String>> =
                    Codec.STRING.listOf().comapFlatMap<List<String>>(
                        Function<List<String>, DataResult<out List<String>>> { strings: List<String>
                            ->
                            if (strings.size > maxHeight) {
                                DataResult.error {
                                    "Invalid pattern: too many rows, $maxHeight is maximum"
                                }
                            } else if (strings.isEmpty()) {
                                DataResult.error { "Invalid pattern: empty pattern not allowed" }
                            } else {
                                val i: Int = strings[0].length

                                for (s in strings) {
                                    if (s.length > maxWidth) {
                                        return@Function DataResult.error {
                                            "Invalid pattern: too many columns, $maxWidth is maximum"
                                        }
                                    }

                                    if (i != s.length) {
                                        return@Function DataResult.error {
                                            "Invalid pattern: each row must be the same width"
                                        }
                                    }
                                }

                                DataResult.success(strings)
                            }
                        }) { obj: List<String> ->
                            obj
                        }

                private val SYMBOL_CODEC: Codec<Char> =
                    Codec.STRING.comapFlatMap(
                        { s: String ->
                            if (s.length != 1) {
                                return@comapFlatMap DataResult.error {
                                    "Symbol '${s}' must be 1 character long."
                                }
                            } else {
                                return@comapFlatMap if (" " == s)
                                    DataResult.error {
                                        "Symbol ' ' (whitespace) is reserved and cannot be used"
                                    }
                                else DataResult.success<Char>(s[0])
                            }
                        },
                        { obj: Char -> obj.toString() })

                val MAP_CODEC: MapCodec<Data> =
                    RecordCodecBuilder.mapCodec { p_312573_ ->
                        p_312573_
                            .group(
                                ExtraCodecs.strictUnboundedMap(
                                        SYMBOL_CODEC, Ingredient.CODEC_NONEMPTY)
                                    .fieldOf("key")
                                    .forGetter(Data::key),
                                PATTERN_CODEC.fieldOf("pattern").forGetter(Data::pattern))
                            .apply(p_312573_) { key: Map<Char, Ingredient>, pattern: List<String> ->
                                Data(key, pattern)
                            }
                    }
            }
        }
    }
}
