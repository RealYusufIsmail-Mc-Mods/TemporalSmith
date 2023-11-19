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
package io.github.realyusufismail.temporalsmith.datagen.dimension

import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.builder.DimensionBuilder
import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.builder.GeneratorBuilder
import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.builder.generator.builder.BiomeSourceBuilder
import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.builder.generator.builder.Reference
import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.util.GeneratorType
import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import net.minecraft.data.PackOutput
import net.minecraft.world.level.biome.Biomes

class ModDimensionProvider(output: PackOutput) : DimensionProvider(output, MOD_ID) {
    override fun run() {
        addDimensionBuilder(
            DimensionBuilder(
                "chrono_realm",
                GeneratorBuilder(GeneratorType.DEFAULT).apply {
                    setReferenceNoiseBuilder(
                        referenceNoise(Reference.END, BiomeSourceBuilder().fixed(Biomes.DESERT)))
                }))
    }
}
