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
package io.github.realyusufismail.armourandtoolsmod.datagen.tags

import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.init.TagsInit
import java.util.concurrent.CompletableFuture
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.common.data.ExistingFileHelper

class ModItemTagsProvider(
    generatorIn: DataGenerator,
    existingFileHelper: ExistingFileHelper,
    blockTagProvider: BlockTagsProvider,
    provider: CompletableFuture<HolderLookup.Provider>
) :
    ItemTagsProvider(
        generatorIn.packOutput, provider, blockTagProvider, MOD_ID, existingFileHelper) {
    override fun addTags(pProvider: HolderLookup.Provider) {
        // ores
        copy(TagsInit.BlockTagsInit.ORES_RUBY_ORES, TagsInit.ItemTagsInit.ORES_RUBY_ORES)
        copy(TagsInit.BlockTagsInit.ORES_RAINBOW_ORES, TagsInit.ItemTagsInit.ORES_RAINBOW_ORES)
        copy(TagsInit.BlockTagsInit.ORES_SAPPHIRE_ORES, TagsInit.ItemTagsInit.ORES_SAPPHIRE_ORES)
        copy(TagsInit.BlockTagsInit.ORES_GRAPHITE_ORES, TagsInit.ItemTagsInit.ORES_GRAPHITE_ORES)
        copy(TagsInit.BlockTagsInit.ORES_AQUMARINE_ORES, TagsInit.ItemTagsInit.ORES_AQUMARINE_ORES)
        // deepslate ores
        copy(
            TagsInit.BlockTagsInit.DEEPSLATE_ORES_RUBY_ORES,
            TagsInit.ItemTagsInit.DEEPSLATE_ORES_RUBY_ORES)
        copy(
            TagsInit.BlockTagsInit.DEEPSLATE_ORES_RAINBOW_ORES,
            TagsInit.ItemTagsInit.DEEPSLATE_ORES_RAINBOW_ORES)
        copy(
            TagsInit.BlockTagsInit.DEEPSLATE_ORES_SAPPHIRE_ORES,
            TagsInit.ItemTagsInit.DEEPSLATE_ORES_SAPPHIRE_ORES)
        copy(
            TagsInit.BlockTagsInit.DEEPSLATE_ORES_GRAPHITE_ORES,
            TagsInit.ItemTagsInit.DEEPSLATE_ORES_GRAPHITE_ORES)
        copy(
            TagsInit.BlockTagsInit.DEEPSLATE_ORES_AQUMARINE_ORES,
            TagsInit.ItemTagsInit.DEEPSLATE_ORES_AQUMARINE_ORES)
        // storage blocks
        copy(TagsInit.BlockTagsInit.STORAGE_RUBY, TagsInit.ItemTagsInit.STORAGE_RUBY)
        copy(TagsInit.BlockTagsInit.STORAGE_RAINBOW, TagsInit.ItemTagsInit.STORAGE_RAINBOW)
        copy(TagsInit.BlockTagsInit.STORAGE_SAPPHIRE, TagsInit.ItemTagsInit.STORAGE_SAPPHIRE)
        copy(TagsInit.BlockTagsInit.STORAGE_GRAPHITE, TagsInit.ItemTagsInit.STORAGE_GRAPHITE)
        copy(TagsInit.BlockTagsInit.STORAGE_AQUMARINE, TagsInit.ItemTagsInit.STORAGE_AQUMARINE)
        // ingots
        tag(TagsInit.ItemTagsInit.INGOTS_RUBY).add(ItemInit.RUBY.get())
        tag(TagsInit.ItemTagsInit.INGOTS_RAINBOW).add(ItemInit.RAINBOW.get())
        tag(TagsInit.ItemTagsInit.INGOTS_SAPPHIRE).add(ItemInit.SAPPHIRE.get())
        tag(TagsInit.ItemTagsInit.INGOTS_GRAPHITE).add(ItemInit.GRAPHITE.get())
        tag(TagsInit.ItemTagsInit.INGOTS_AQUMARINE).add(ItemInit.AQUMARINE.get())
        // raw ores
        tag(TagsInit.ItemTagsInit.RAW_RUBY).add(ItemInit.RAW_RUBY.get())
        tag(TagsInit.ItemTagsInit.RAW_RAINBOW).add(ItemInit.RAW_RAINBOW.get())
        tag(TagsInit.ItemTagsInit.RAW_SAPPHIRE).add(ItemInit.RAW_SAPPHIRE.get())
        tag(TagsInit.ItemTagsInit.RAW_GRAPHITE).add(ItemInit.RAW_GRAPHITE.get())
        tag(TagsInit.ItemTagsInit.RAW_AQUMARINE).add(ItemInit.RAW_AQUMARINE.get())
    }
}
