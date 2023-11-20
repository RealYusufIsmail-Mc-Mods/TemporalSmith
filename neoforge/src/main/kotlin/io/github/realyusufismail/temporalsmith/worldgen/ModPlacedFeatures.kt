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
package io.github.realyusufismail.temporalsmith.worldgen

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier

object ModPlacedFeatures {

    val RUBY_ORE: ResourceKey<PlacedFeature> = createKey("ruby_ore")
    val SAPPHIRE_ORE: ResourceKey<PlacedFeature> = createKey("sapphire_ore")
    val GRAPHITE_ORE: ResourceKey<PlacedFeature> = createKey("graphite_ore")
    val AQUMARINE_ORE: ResourceKey<PlacedFeature> = createKey("aqumarine_ore")
    val RAINBOW_ORE: ResourceKey<PlacedFeature> = createKey("rainbow_ore")
    val ENDERITE_ORE: ResourceKey<PlacedFeature> = createKey("enderite_ore")
    val IMPERIUM_ORE: ResourceKey<PlacedFeature> = createKey("imperium_ore")

    fun bootstrap(context: BootstapContext<PlacedFeature>) {
        val configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE)

        val holder: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE)
        val holder2: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SAPPHIRE_ORE)
        val holder3: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_GRAPHITE_ORE)
        val holder4: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_AQUMARINE_ORE)
        val holder5: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RAINBOW_ORE)
        val holder6: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ENDERITE_ORE)
        val holder7: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_IMPERIUM_ORE)

        register(
            context,
            RUBY_ORE,
            holder,
            ModOrePlacement.commonOrePlacement(
                3, // veins per chunk
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(20))))

        register(
            context,
            SAPPHIRE_ORE,
            holder2,
            ModOrePlacement.commonOrePlacement(
                4,
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(20))))

        register(
            context,
            GRAPHITE_ORE,
            holder3,
            ModOrePlacement.commonOrePlacement(
                4,
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))))

        register(
            context,
            AQUMARINE_ORE,
            holder4,
            ModOrePlacement.commonOrePlacement(
                4,
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(40))))

        register(
            context,
            RAINBOW_ORE,
            holder5,
            ModOrePlacement.commonOrePlacement(
                3,
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(40))))

        register(
            context,
            ENDERITE_ORE,
            holder6,
            ModOrePlacement.commonOrePlacement(
                4,
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(40))))

        register(
            context,
            IMPERIUM_ORE,
            holder7,
            ModOrePlacement.commonOrePlacement(
                4,
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(50))))
    }

    private fun createKey(name: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create<PlacedFeature>(
            Registries.PLACED_FEATURE, ResourceLocation(MOD_ID, name))
    }

    private fun register(
        context: BootstapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        configuration: Holder<ConfiguredFeature<*, *>>,
        modifiers: List<PlacementModifier>
    ) {
        context.register(key, PlacedFeature(configuration, java.util.List.copyOf(modifiers)))
    }

    private fun register(
        context: BootstapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        configuration: Holder<ConfiguredFeature<*, *>>,
        vararg modifiers: PlacementModifier
    ) {
        register(context, key, configuration, listOf(*modifiers))
    }
}
