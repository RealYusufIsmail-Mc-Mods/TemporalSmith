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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.effect.WorthyEffect
import net.minecraft.core.registries.Registries
import net.minecraft.world.effect.MobEffect
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object MobEffectsInit {
    val MOB_EFFECTS: DeferredRegister<MobEffect> =
        DeferredRegister.create(Registries.MOB_EFFECT, MOD_ID)

    // WORTHY_EFFECT has no effect, it just an indication that the potion is worthy to use mjolnir
    val WORTHY_EFFECT: DeferredHolder<MobEffect, WorthyEffect> =
        MOB_EFFECTS.register("worthy_effect") { -> WorthyEffect() }
}
