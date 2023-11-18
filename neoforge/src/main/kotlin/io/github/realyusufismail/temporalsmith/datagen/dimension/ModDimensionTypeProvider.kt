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

import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.DimensionTypeProvider
import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.builder.DimensionTypeBuilder
import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.builder.util.Effect
import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import net.minecraft.data.DataGenerator

class ModDimensionTypeProvider(generator: DataGenerator) :
    DimensionTypeProvider(generator.packOutput, MOD_ID) {
    override fun run() {
        addDimensionTypeBuilder(
            DimensionTypeBuilder("chrono_realm")
                .setHasCeiling(true)
                .setPiglinSafe(true)
                .setBedWorks(true)
                .setRespawnAnchorWorks(true)
                .setHasRaids(false)
                .setHasSkylight(true)
                .setAmbientLight(0.0)
                .setFixedTime(null)
                .setNatural(false)
                .setUltrawarm(false)
                .setEffects(Effect.END)
                .setMinY(-64.0)
                .setHeight(256.0)
                .setMonsterSpawnBlockLightLimit(0))
    }
}
