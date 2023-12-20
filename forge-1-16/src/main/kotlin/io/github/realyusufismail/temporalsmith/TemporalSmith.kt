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
package io.github.realyusufismail.temporalsmith

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.datagen.DataGenerators
import java.util.*
import net.minecraft.item.ItemGroup
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.Mod
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import thedarkcolour.kotlinforforge.KotlinModLoadingContext
import thedarkcolour.kotlinforforge.forge.FORGE_BUS

@Mod(MOD_ID)
class TemporalSmith {
    init {
        val bus = KotlinModLoadingContext.get().getKEventBus()
        ItemInit.ITEMS.register(bus)

        // Listeners
        bus.addListener(DataGenerators::gatherData)

        FORGE_BUS.register(this)

        logger.info("Temporal Smith is loaded!")
    }

    companion object TemporalSmith {
        val logger: Logger = LoggerFactory.getLogger(TemporalSmith::class.java)

        fun getModIdAndName(name: String): ResourceLocation {
            return ResourceLocation(MOD_ID, name.lowercase(Locale.getDefault()))
        }

        const val MOD_ID = "temporalsmith"

        val temporalSmithItemGroup: ItemGroup =
            object : ItemGroup(TABS.size, "temporalsmith") {
                override fun makeIcon() = ItemInit.SAPPHIRE.get().defaultInstance
            }
    }
}
