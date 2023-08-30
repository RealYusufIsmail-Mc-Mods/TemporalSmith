package io.github.realyusufismail.armourandtoolsmod.datagen.world

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.worldgen.ModConfiguredFeatures
import io.github.realyusufismail.armourandtoolsmod.worldgen.ModPlacedFeatures
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import java.util.concurrent.CompletableFuture


class ModWorldGenProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>, val builder: RegistrySetBuilder = RegistrySetBuilder()
    .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
    .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap))
    : DatapackBuiltinEntriesProvider(output, registries, builder, mutableSetOf(MOD_ID))