package io.github.realyusufismail.temporalsmith.datagen.dimension

import io.github.realyusufismail.realyusufismailcore.data.dimension.builder.DimensionTypeBuilder
import io.github.realyusufismail.realyusufismailcore.data.dimension.builder.util.Effect
import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import net.minecraft.data.DataGenerator

class ModDimensionTypeProvider(generator: DataGenerator) : DimensionTypeProvider(generator, MOD_ID) {
    override fun run(): MutableList<DimensionTypeBuilder> {
        val dimensionTypeBuilders = mutableListOf<DimensionTypeBuilder>()

        dimensionTypeBuilders.add(
            DimensionTypeBuilder("ChronoRealm")
                .setEffects(Effect.END)
        )

        return dimensionTypeBuilders
    }

}