package io.github.realyusufismail.temporalsmith.datagen

import io.github.realyusufismail.temporalsmith.datagen.texture.ModItemStateProvider
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent

object DataGenerators {

    fun gatherData(event: GatherDataEvent) {
        val gen = event.generator
        val existingFileHelper = event.existingFileHelper

        gen.addProvider(ModItemStateProvider(gen, existingFileHelper))
    }
}