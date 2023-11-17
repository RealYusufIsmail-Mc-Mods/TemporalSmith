package io.github.realyusufismail.temporalsmith.datagen.dimension

import io.github.realyusufismail.realyusufismailcore.data.dimension.builder.DimensionTypeBuilder
import lombok.Setter
import net.minecraft.data.CachedOutput
import net.minecraft.data.DataGenerator
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import java.nio.file.Path
import java.util.concurrent.CompletableFuture


abstract class DimensionTypeProvider(private val generator: DataGenerator, private val modId: String) : DataProvider {
    protected abstract fun run(): List<DimensionTypeBuilder>

    override fun run(cachedOutput: CachedOutput): CompletableFuture<*> {
        val dataProvider = generator.packOutput
        for (dimensionTypeBuilder in run()) {
            val jsonObject = dimensionTypeBuilder.toJson()
            val path = resolvePath(
                dataProvider, "data/" + modId + "/dimension_type/" + dimensionTypeBuilder.name + ".json"
            )
            DataProvider.saveStable(cachedOutput, jsonObject, path)
        }
        return CompletableFuture.completedFuture<Any?>(null)
    }

    private fun resolvePath(path: PackOutput, pathOther: String): Path {
        return path.outputFolder.resolve(pathOther)
    }

    override fun getName(): String {
        return "Dimension Type Provider for $modId"
    }
}

