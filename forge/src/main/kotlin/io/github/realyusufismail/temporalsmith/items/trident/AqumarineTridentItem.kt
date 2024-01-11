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
package io.github.realyusufismail.temporalsmith.items.trident

import io.github.realyusufismail.temporalsmith.client.TemporalSmithTridentItemRendererProvider
import io.github.realyusufismail.temporalsmith.common.entity.AqumarineTridentEntity
import io.github.realyusufismail.temporalsmith.common.entity.ModTridentEntity
import io.github.realyusufismail.temporalsmith.core.material.CustomToolMaterial
import java.util.function.Consumer
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraftforge.client.extensions.common.IClientItemExtensions

open class AqumarineTridentItem :
    ModTridentItem(CustomToolMaterial.AQUMARINE_TRIDENT, Properties().stacksTo(1), 10F, -2.5F) {

    override fun getThrownEntity(
        world: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ): ModTridentEntity {
        return AqumarineTridentEntity(world, thrower, stack)
    }

    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(TemporalSmithTridentItemRendererProvider.aqumarineTrident())
    }
}
