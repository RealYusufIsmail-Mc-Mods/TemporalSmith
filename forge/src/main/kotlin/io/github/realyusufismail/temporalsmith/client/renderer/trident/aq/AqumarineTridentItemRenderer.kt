/*
 * Copyright 2024 RealYusufIsmail.
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
package io.github.realyusufismail.temporalsmith.client.renderer.trident.aq

import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.client.renderer.trident.ArmourToolsModTridentItemRenderer
import io.github.realyusufismail.temporalsmith.common.entity.ModTridentEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation

class AqumarineTridentItemRenderer(context: EntityRendererProvider.Context) :
    ArmourToolsModTridentItemRenderer(context) {
    private val location: ResourceLocation =
        TemporalSmith.getModIdAndName("textures/entity/trident/aqumarine.png")

    override fun getTextureLocation(pEntity: ModTridentEntity): ResourceLocation {
        return location
    }
}
