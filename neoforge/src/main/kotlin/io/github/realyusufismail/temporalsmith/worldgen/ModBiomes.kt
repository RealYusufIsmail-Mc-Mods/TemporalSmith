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
package io.github.realyusufismail.temporalsmith.worldgen

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.core.init.SoundInit
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.Music
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.level.biome.*
import net.minecraft.world.level.levelgen.GenerationStep

object ModBiomes {
    val ENDERITE_BIOME =
        ResourceKey.create(Registries.BIOME, ResourceLocation(MOD_ID, "enderite_biome"))

    fun boostrap(context: BootstapContext<Biome>) {
        context.register(ENDERITE_BIOME, enderiteBiome(context))
    }

    fun enderiteBiome(context: BootstapContext<Biome>): Biome {

        // Hostile Mobs:

        // Ender Guardians:
        //
        // Appearance: Ender Guardians have an ethereal and shimmering appearance, resembling
        // traditional guardians but with a deep purple glow. Their eyes emit a faint glow, and
        // their bodies have a translucent quality.
        // Abilities: Ender Guardians can teleport short distances, making them elusive targets.
        // When attacking, they release bursts of ender energy that can disorient players.

        // Shadow Wraiths:
        //
        // Appearance: Shadow Wraiths are ghostly figures with elongated, flowing dark robes. Their
        // faces are obscured by shadows, and they leave a trail of ephemeral wisps as they move.
        // Behavior: Shadow Wraiths are hostile entities that phase in and out of visibility. They
        // prefer to ambush players and quickly retreat into the shadows after attacking.

        // Ender Elementals:
        //
        // Appearance: Ender Elementals are humanoid creatures composed of shimmering ender energy.
        // Their bodies constantly shift and ripple with otherworldly hues.
        // Abilities: Ender Elementals have the ability to teleport instantly to evade attacks. When
        // attacked, they unleash bursts of ender energy that can pierce through armor.

        // Neutral Mobs:

        // Enderite Foxes:
        //
        // Appearance: Agile foxes with tails that trail ender energy. Their eyes have a mesmerizing
        // glow, and they move with a combination of grace and playfulness.
        // Behavior: Enderite Foxes roam the biome, occasionally picking up temporal items. Players
        // can interact with them to receive small temporal-themed gifts.

        // Mystical Birds:
        //
        // Appearance: Elegant, otherworldly birds with iridescent feathers. Their songs have a
        // calming effect on the environment.
        // Behavior: Mystical Birds perch on trees and fly gracefully through the biome. Listening
        // to their songs may provide temporary buffs to players.

        // Enderite Golem:
        //
        // Appearance: A towering golem made of enderite blocks and infused with pulsating ender
        // energy. It has a serene and protective presence, with eyes that emit a calming glow.
        // Behavior: The Enderite Golem serves as a guardian of the biome. It peacefully wanders the
        // area, and when players approach with hostile intent, it emits a protective aura,
        // discouraging aggressive actions.
        // Abilities: The Enderite Golem can harness ender energy to create protective barriers or
        // provide buffs to nearby players. It may also have a unique interaction, such as accepting
        // gifts or offerings from players in exchange for blessings.
        // Purpose: The Enderite Golem adds a protective and positive element to the biome. Players
        // can view it as a guardian entity that enhances the overall ambiance and serves as a focal
        // point for certain activities.

        // val spawnBuilder = MobSpawnSettings.Builder()

        val biomeBuilder =
            BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER))

        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder)
        biomeBuilder.addFeature(
            GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ENDERITE_ORE)

        return Biome.BiomeBuilder()
            .hasPrecipitation(true)
            .downfall(0.8f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .mobSpawnSettings(MobSpawnSettings.Builder().build())
            .specialEffects(
                (BiomeSpecialEffects.Builder())
                    .waterColor(0x134340)
                    .waterFogColor(0x0D3D52)
                    .skyColor(0x08324F)
                    .grassColorOverride(0x255C45)
                    .foliageColorOverride(0x1E614C)
                    .fogColor(0x08324F)
                    .ambientMoodSound(AmbientMoodSettings(SoundEvents.AMBIENT_CAVE, 6000, 8, 2.0))
                    .backgroundMusic(
                        Music(
                            SoundInit.ENDERITE_AMBIENT as Holder<SoundEvent>, 12000, 24000, false))
                    .build())
            .build()
    }
}
