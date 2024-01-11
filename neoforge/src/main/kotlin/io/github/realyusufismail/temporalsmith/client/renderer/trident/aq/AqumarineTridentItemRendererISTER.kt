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
import io.github.realyusufismail.temporalsmith.client.renderer.trident.ModTridentRendererISTER
import net.minecraft.client.resources.model.ModelResourceLocation
import net.minecraft.resources.ResourceLocation

class AqumarineTridentItemRendererISTER : ModTridentRendererISTER() {
    override fun getTextureLocation(): ResourceLocation {
        return TemporalSmith.getModIdAndName("textures/entity/trident/aqumarine.png")
    }

    override fun getModelResourceLocation(): ModelResourceLocation {
        return ModelResourceLocation(
            TemporalSmith.getModIdAndName("aqumarine_trident"), "inventory")
    }
}
