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
package io.github.realyusufismail.armourandtoolsmod.core.init

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.stats.StatFormatter
import net.minecraft.stats.Stats
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

object StatsInit {
    val STATS =
        DeferredRegister.create<ResourceLocation>(Registries.CUSTOM_STAT, ArmourAndToolsMod.MOD_ID)
    private val STAT_SETUP: MutableList<Runnable> = mutableListOf()

    private fun makeCustomStat(key: String): RegistryObject<ResourceLocation> {
        val resourceLocation: ResourceLocation = ArmourAndToolsMod.getModIdAndName(key)
        STAT_SETUP.add(Runnable { Stats.CUSTOM.get(resourceLocation, StatFormatter.DEFAULT) })
        return STATS.register(key) { resourceLocation }
    }

    @JvmField
    val INTERACT_WITH_FUSION_TOLL_ENHANCER: RegistryObject<ResourceLocation> =
        makeCustomStat("interact_with_fusion_toll_enhancer")

    fun init() {
        STAT_SETUP.forEach(Runnable::run)
    }
}
