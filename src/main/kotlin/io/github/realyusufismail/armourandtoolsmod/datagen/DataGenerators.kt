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
package io.github.realyusufismail.armourandtoolsmod.datagen

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.logger
import io.github.realyusufismail.armourandtoolsmod.datagen.lang.ModEnLangProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.loot.ModLootTables
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.MainModRecipeProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.tags.ModBlockTagsProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.tags.ModItemTagsProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.texture.ModBlockStateProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.texture.ModItemStateProvider
import net.minecraftforge.data.event.GatherDataEvent

object DataGenerators {

    /**
     * Triggered when data generators are run.
     *
     * @param event The event.
     */
    fun gatherData(event: GatherDataEvent) {
        logger.info("Gathering data...")

        val gen = event.generator
        val existingFileHelper = event.existingFileHelper
        val lookup = event.lookupProvider

        try {
            gen.addProvider(true, ModLootTables(gen))
            gen.addProvider(true, ModEnLangProvider(gen))
            gen.addProvider(true, ModBlockStateProvider(gen.packOutput, existingFileHelper))
            gen.addProvider(true, ModItemStateProvider(gen.packOutput, existingFileHelper))
            val blockTag = ModBlockTagsProvider(gen, existingFileHelper, lookup)
            gen.addProvider(true, blockTag)
            gen.addProvider(true, ModItemTagsProvider(gen, existingFileHelper, blockTag, lookup))
            gen.addProvider(true, MainModRecipeProvider(gen))
        } catch (e: RuntimeException) {
            logger.error("Failed to gather data!", e)
        }
    }
}
