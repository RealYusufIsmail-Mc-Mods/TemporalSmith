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
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.TagsInit
import java.util.concurrent.CompletableFuture
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.common.data.ExistingFileHelper

class ModBlockTagsProvider(
    generatorIn: DataGenerator,
    existingFileHelper: ExistingFileHelper,
    provider: CompletableFuture<HolderLookup.Provider>
) : BlockTagsProvider(generatorIn.packOutput, provider, MOD_ID, existingFileHelper) {

    override fun addTags(pProvider: HolderLookup.Provider) {
        // ores
        tag(TagsInit.BlockTagsInit.ORES_RUBY_ORES).add(BlockInit.RUBY_ORE.get())
        tag(TagsInit.BlockTagsInit.ORES_RAINBOW_ORES).add(BlockInit.RAINBOW_ORE.get())
        tag(TagsInit.BlockTagsInit.ORES_SAPPHIRE_ORES).add(BlockInit.SAPPHIRE_ORE.get())
        tag(TagsInit.BlockTagsInit.ORES_GRAPHITE_ORES).add(BlockInit.GRAPHITE_ORE.get())
        tag(TagsInit.BlockTagsInit.ORES_AQUMARINE_ORES).add(BlockInit.AQUMARINE_ORE.get())
        // deepslate ores
        tag(TagsInit.BlockTagsInit.DEEPSLATE_ORES_RUBY_ORES).add(BlockInit.DEEPSLATE_RUBY_ORE.get())
        tag(TagsInit.BlockTagsInit.DEEPSLATE_ORES_RAINBOW_ORES)
            .add(BlockInit.DEEPSLATE_RAINBOW_ORE.get())
        tag(TagsInit.BlockTagsInit.DEEPSLATE_ORES_SAPPHIRE_ORES)
            .add(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get())
        tag(TagsInit.BlockTagsInit.DEEPSLATE_ORES_GRAPHITE_ORES)
            .add(BlockInit.DEEPSLATE_GRAPHITE_ORE.get())
        tag(TagsInit.BlockTagsInit.DEEPSLATE_ORES_AQUMARINE_ORES)
            .add(BlockInit.DEEPSLATE_AQUMARINE_ORE.get())
        // storage blocks
        tag(TagsInit.BlockTagsInit.STORAGE_RUBY).add(BlockInit.RUBY_BLOCK.get())
        tag(TagsInit.BlockTagsInit.STORAGE_RAINBOW).add(BlockInit.RAINBOW_BLOCK.get())
        tag(TagsInit.BlockTagsInit.STORAGE_SAPPHIRE).add(BlockInit.SAPPHIRE_BLOCK.get())
        tag(TagsInit.BlockTagsInit.STORAGE_GRAPHITE).add(BlockInit.GRAPHITE_BLOCK.get())
        tag(TagsInit.BlockTagsInit.STORAGE_AQUMARINE).add(BlockInit.AQUMARINE_BLOCK.get())
    }
}
