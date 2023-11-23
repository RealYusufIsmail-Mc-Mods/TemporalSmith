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
package io.github.realyusufismail.armourandtoolsmod.core.init

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.Level
import net.minecraft.world.level.dimension.DimensionType

object DimensionsInit {
    val CHRON_REAL: ResourceKey<Level> =
        ResourceKey.create(Registries.DIMENSION, ArmourAndToolsMod.getModIdAndName("chrono_realm"))
    val CHRON_REAL_TYPE: ResourceKey<DimensionType> =
        ResourceKey.create(Registries.DIMENSION_TYPE, CHRON_REAL.location())

    fun register() {
        ArmourAndToolsMod.logger.info("Registering dimensions for ${ArmourAndToolsMod.MOD_ID}")
    }
}
