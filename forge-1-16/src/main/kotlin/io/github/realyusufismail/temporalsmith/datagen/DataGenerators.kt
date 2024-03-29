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

import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.datagen.lang.ModEnLangProvider
import io.github.realyusufismail.temporalsmith.datagen.texture.ModBlockStateProvider
import io.github.realyusufismail.temporalsmith.datagen.texture.ModItemStateProvider
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent

object DataGenerators {

    fun gatherData(event: GatherDataEvent) {
        val gen = event.generator
        val existingFileHelper = event.existingFileHelper

        try {
            gen.addProvider(ModItemStateProvider(gen, existingFileHelper))
            gen.addProvider(ModBlockStateProvider(gen, existingFileHelper))
            gen.addProvider(ModEnLangProvider(gen))
        } catch (e: Exception) {
            TemporalSmith.logger.error("Error generating data", e)
        }
    }
}
