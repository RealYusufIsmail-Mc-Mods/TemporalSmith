package io.github.realyusufismail.temporalsmith.datagen.dimension

import com.google.gson.JsonElement
import io.github.realyusufismail.realyusufismailcore.data.gen.dimension.builder.DimensionBuilder
import net.minecraft.data.CachedOutput
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import org.jetbrains.annotations.Contract
import java.nio.file.Path
import java.util.concurrent.CompletableFuture


abstract class DimensionProvider(private val output: PackOutput, private val modId: String) : DataProvider {
    private val dimensionBuilders: MutableList<DimensionBuilder> = ArrayList()
    abstract fun run()
    override fun run(cachedOutput: CachedOutput): CompletableFuture<*> {
        run()
        if (dimensionBuilders.isNotEmpty()) {
            for (dimensionBuilder in dimensionBuilders) {
                return save(
                    cachedOutput,
                    output
                        .getOutputFolder(PackOutput.Target.DATA_PACK)
                        .resolve(modId)
                        .resolve("dimension")
                        .resolve(dimensionBuilder.name + ".json"),
                    dimensionBuilder.toJson()
                )
            }
        }
        return CompletableFuture.allOf()
    }

    private fun resolvePath(path: PackOutput, pathOther: String): Path {
        return path.outputFolder.resolve(pathOther)
    }

    override fun getName(): String {
        return "Dimension Provider for $modId"
    }

    @Contract("_, _, _ -> new")
    private fun save(cache: CachedOutput, target: Path, json: JsonElement): CompletableFuture<*> {
        return DataProvider.saveStable(cache, json, target)
    }

    fun addDimensionBuilder(dimensionBuilder: DimensionBuilder) {
        dimensionBuilders.add(dimensionBuilder)
    }

    fun addDimensionBuilders(vararg dimensionBuilders: DimensionBuilder) {
        this.dimensionBuilders.addAll(listOf(*dimensionBuilders))
    }

    fun addDimensionBuilders(dimensionBuilders: List<DimensionBuilder>?) {
        this.dimensionBuilders.addAll(dimensionBuilders!!)
    }
}

