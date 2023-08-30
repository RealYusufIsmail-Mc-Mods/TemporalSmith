package io.github.realyusufismail.armourandtoolsmod.worldgen

import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.world.level.levelgen.placement.*

object ModOrePlacement {
    fun orePlacement(placementModifier: PlacementModifier, placementModifier1: PlacementModifier): List<PlacementModifier> {
        return listOf(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome())
    }

    fun commonOrePlacement(count: Int, placementModifier: PlacementModifier): List<PlacementModifier> {
        return orePlacement(CountPlacement.of(count), placementModifier)
    }

    fun rareOrePlacement(count: Int, placementModifier: PlacementModifier): List<PlacementModifier> {
        return orePlacement(RarityFilter.onAverageOnceEvery(count), placementModifier)
    }
}