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

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.getModIdAndName
import io.github.realyusufismail.realyusufismailcore.data.support.oregen.ModOrePlacementsSupport
import net.minecraft.core.Holder
import net.minecraft.core.HolderGetter
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier

object ModOrePlacementsGen : ModOrePlacementsSupport() {

    val RUBY_ORE: ResourceKey<PlacedFeature> = createKey("ruby_ore")
    val SAPPHIRE_ORE: ResourceKey<PlacedFeature> = createKey("sapphire_ore")
    val GRAPHITE_ORE: ResourceKey<PlacedFeature> = createKey("graphite_ore")
    val AQUMARINE_ORE: ResourceKey<PlacedFeature> = createKey("aqumarine_ore")
    val RAINBOW_ORE: ResourceKey<PlacedFeature> = createKey("rainbow_ore")

    override fun bootstrap(context: BootstapContext<PlacedFeature>) {
        val holdergetter: HolderGetter<ConfiguredFeature<*, *>> =
            context.lookup(Registries.CONFIGURED_FEATURE)

        val holder: Holder<ConfiguredFeature<*, *>> =
            holdergetter.getOrThrow(ModOreFeaturesGen.RUBY_ORE)
        val holder2: Holder<ConfiguredFeature<*, *>> =
            holdergetter.getOrThrow(ModOreFeaturesGen.SAPPHIRE_ORE)
        val holder3: Holder<ConfiguredFeature<*, *>> =
            holdergetter.getOrThrow(ModOreFeaturesGen.GRAPHITE_ORE)
        val holder4: Holder<ConfiguredFeature<*, *>> =
            holdergetter.getOrThrow(ModOreFeaturesGen.AQUMARINE_ORE)
        val holder5: Holder<ConfiguredFeature<*, *>> =
            holdergetter.getOrThrow(ModOreFeaturesGen.RAINBOW_ORE)

        register(
            context,
            RUBY_ORE,
            holder,
            commonOrePlacement(
                10,
                HeightRangePlacement.triangle(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(20))))

        register(
            context,
            SAPPHIRE_ORE,
            holder2,
            commonOrePlacement(
                10,
                HeightRangePlacement.triangle(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(10))))

        register(
            context,
            GRAPHITE_ORE,
            holder3,
            commonOrePlacement(
                10,
                HeightRangePlacement.triangle(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(10))))

        register(
            context,
            AQUMARINE_ORE,
            holder4,
            commonOrePlacement(
                10,
                HeightRangePlacement.triangle(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-20))))

        register(
            context,
            RAINBOW_ORE,
            holder5,
            commonOrePlacement(
                10,
                HeightRangePlacement.triangle(
                    VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-20))))
    }

    private fun createKey(name: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create(Registries.PLACED_FEATURE, getModIdAndName(name))
    }

    private fun register(
        context: BootstapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        holder: Holder<ConfiguredFeature<*, *>>,
        placement: List<PlacementModifier>,
    ) {
        context.register(key, PlacedFeature(holder, placement))
    }
}
