package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith
import net.minecraft.world.entity.ai.village.poi.PoiType
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.neoforge.forge.registerObject

object POIInit {
    val POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, TemporalSmith.MOD_ID)

    @JvmField
    val ENDERITE_BLOCK = POI.registerObject("enderite_block") {
        PoiType(setOf(BlockInit.ENDERITE_BLOCK.get().defaultBlockState()), 0, 1)
    }
}