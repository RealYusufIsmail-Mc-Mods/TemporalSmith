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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.alchemy.Potion
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

/** @see MobEffect */
object PotionsInit {
    val POTION: DeferredRegister<Potion> =
        DeferredRegister.create(ForgeRegistries.POTIONS, TemporalSmith.MOD_ID)

    // WORTHY_POTION has no effect, it just an indication that the potion is worthy to use mjolnir
    val WORTHY_POTION: ObjectHolderDelegate<Potion> =
        POTION.registerObject("worthy_potion") {
            Potion(MobEffectInstance(MobEffectsInit.WORTHY_EFFECT.get(), 9999, 0, false, false))
        }
}
