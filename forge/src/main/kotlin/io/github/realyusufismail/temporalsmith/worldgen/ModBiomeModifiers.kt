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
package io.github.realyusufismail.temporalsmith.worldgen

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraftforge.common.world.BiomeModifier
import net.minecraftforge.common.world.ForgeBiomeModifiers
import net.minecraftforge.registries.ForgeRegistries

object ModBiomeModifiers {
    val ADD_RUBY_ORE: ResourceKey<BiomeModifier> = registerKey("add_ruby_ore")
    val ADD_SAPPHIRE_ORE: ResourceKey<BiomeModifier> = registerKey("add_sapphire_ore")
    val ADD_GRAPHITE_ORE: ResourceKey<BiomeModifier> = registerKey("add_graphite_ore")
    val ADD_AQUMARINE_ORE: ResourceKey<BiomeModifier> = registerKey("add_aqumarine_ore")
    val ADD_RAINBOW_ORE: ResourceKey<BiomeModifier> = registerKey("add_rainbow_ore")
    val ADD_IMPERIUM_ORE: ResourceKey<BiomeModifier> = registerKey("add_imperium_ore")
    val ADD_ENDERITE_ORE: ResourceKey<BiomeModifier> = registerKey("add_enderite_ore")

    fun bootStrap(context: BootstapContext<BiomeModifier>) {
        val placedFeatures = context.lookup(Registries.PLACED_FEATURE)
        val biomes = context.lookup(Registries.BIOME)

        context.register(
            ADD_RUBY_ORE,
            ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBY_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES))

        context.register(
            ADD_SAPPHIRE_ORE,
            ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SAPPHIRE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES))

        context.register(
            ADD_GRAPHITE_ORE,
            ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GRAPHITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES))

        context.register(
            ADD_AQUMARINE_ORE,
            ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.AQUMARINE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES))

        context.register(
            ADD_RAINBOW_ORE,
            ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RAINBOW_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES))

        context.register(
            ADD_IMPERIUM_ORE,
            ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.IMPERIUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES))

        context.register(
            ADD_ENDERITE_ORE,
            ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ENDERITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES))
    }

    private fun registerKey(name: String): ResourceKey<BiomeModifier> {
        return ResourceKey.create(
            ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation(MOD_ID, name))
    }
}
