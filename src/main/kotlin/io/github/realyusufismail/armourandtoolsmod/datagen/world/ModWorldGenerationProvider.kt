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
package io.github.realyusufismail.armourandtoolsmod.datagen.world

import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import java.util.concurrent.CompletableFuture
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.registries.VanillaRegistries
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider

/** @see VanillaRegistries */
class ModWorldGenerationProvider(
    output: PackOutput,
    registries: CompletableFuture<HolderLookup.Provider>,
) :
    DatapackBuiltinEntriesProvider(
        output,
        registries,
        RegistrySetBuilder()
            .add<ConfiguredFeature<*, *>>(
                Registries.CONFIGURED_FEATURE, ModOreFeaturesGen::bootstrap)
            .add<PlacedFeature>(Registries.PLACED_FEATURE, ModOrePlacementsGen::bootstrap),
        mutableSetOf(MOD_ID))
