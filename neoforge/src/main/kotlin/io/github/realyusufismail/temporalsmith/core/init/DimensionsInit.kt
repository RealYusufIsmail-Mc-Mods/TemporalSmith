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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.RandomSource
import net.minecraft.util.valueproviders.IntProvider
import net.minecraft.util.valueproviders.IntProviderType
import net.minecraft.world.level.Level
import net.minecraft.world.level.dimension.DimensionType
import net.neoforged.neoforge.registries.ForgeRegistries
import java.util.*

object DimensionsInit {
    val CHRON_REAL: ResourceKey<Level> =
        ResourceKey.create(Registries.DIMENSION, TemporalSmith.getModIdAndName("chrono_realm"))
    val CHRON_REAL_TYPE: ResourceKey<DimensionType> =
        ResourceKey.create(Registries.DIMENSION_TYPE, TemporalSmith.getModIdAndName("chrono_realm"))

    fun register() {
        TemporalSmith.logger.info("Registering dimensions for ${TemporalSmith.MOD_ID}")
    }
}