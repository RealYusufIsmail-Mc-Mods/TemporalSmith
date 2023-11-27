package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister




object SoundInit {
    val SOUND_EVENTS: DeferredRegister<SoundEvent> =
        DeferredRegister.create(Registries.SOUND_EVENT, MOD_ID)

    val ENDERITE_AMBIENT: DeferredHolder<SoundEvent, SoundEvent> = registerSoundEvents("enderite_ambient")

    private fun registerSoundEvents(name: String): DeferredHolder<SoundEvent, SoundEvent> {
        return SOUND_EVENTS.register(name) { ->
            SoundEvent.createVariableRangeEvent(
                ResourceLocation(MOD_ID, name)
            )
        }
    }
}