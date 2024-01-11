/*
 * Copyright 2024 RealYusufIsmail.
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
package io.github.realyusufismail.temporalsmith.datagen

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.logger
import io.github.realyusufismail.temporalsmith.datagen.advancment.ModAdvancementProvider
import io.github.realyusufismail.temporalsmith.datagen.lang.ModEnLangProvider
import io.github.realyusufismail.temporalsmith.datagen.loot.ModLootTables
import io.github.realyusufismail.temporalsmith.datagen.recipe.MainModRecipeProvider
import io.github.realyusufismail.temporalsmith.datagen.spirit.ModSpriteSourceProvider
import io.github.realyusufismail.temporalsmith.datagen.tags.ModBlockTagsProvider
import io.github.realyusufismail.temporalsmith.datagen.tags.ModItemTagsProvider
import io.github.realyusufismail.temporalsmith.datagen.texture.ModBlockStateProvider
import io.github.realyusufismail.temporalsmith.datagen.texture.ModItemStateProvider
import io.github.realyusufismail.temporalsmith.datagen.world.ModWorldGenProvider
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors
import net.minecraft.DetectedVersion
import net.minecraft.data.metadata.PackMetadataGenerator
import net.minecraft.network.chat.Component
import net.minecraft.server.packs.PackType
import net.minecraft.server.packs.metadata.pack.PackMetadataSection
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
            gen.addProvider(true, ModWorldGenProvider(gen.packOutput, lookup))
            gen.addProvider(true, ModSpriteSourceProvider(gen.packOutput, existingFileHelper))
            gen.addProvider(
                true, ModAdvancementProvider(gen.packOutput, lookup, existingFileHelper))
            gen.addProvider(true, PackMetadataGenerator(gen.packOutput))
                .add(
                    PackMetadataSection.TYPE,
                    PackMetadataSection(
                        Component.literal(
                            """
                            Descend into the boundless realms of TemporalSmith, where time intertwines with the craft of the Aetheric Arsenal. 
                            Unleash the power of enchanted swords and tools forged beyond the constraints of time. Explore mystical dimensions, each brimming with unique challenges and treasures. 
                            Elevate your Minecraft experience with a fusion of temporal mastery, otherworldly landscapes, and an expansive array of armaments. 
                            The journey awaits; delve into the time-woven secrets of TemporalSmith. (A lot of stuff to be added)
                        """
                                .trimIndent()),
                        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
                        Arrays.stream(PackType.entries.toTypedArray())
                            .collect(
                                Collectors.toMap(
                                    Function.identity(),
                                    DetectedVersion.BUILT_IN::getPackVersion))))
        } catch (e: RuntimeException) {
            logger.error("Failed to gather data!", e)
        }
    }
}
