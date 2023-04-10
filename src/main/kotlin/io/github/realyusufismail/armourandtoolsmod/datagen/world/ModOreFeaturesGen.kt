/*
 * Copyright 2022 RealYusufIsmail.
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
package io.github.realyusufismail.armourandtoolsmod.datagen.world

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.getModIdAndName
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.realyusufismailcore.data.support.oregen.ModOreFeaturesSupport
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest

object ModOreFeaturesGen : ModOreFeaturesSupport() {

    val RUBY_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("ruby_ore")
    val SAPPHIRE_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("sapphire_ore")
    val GRAPHITE_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("graphite_ore")
    val AQUMARINE_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("aqumarine_ore")
    val RAINBOW_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("rainbow_ore")

    override fun bootstrap(context: BootstapContext<ConfiguredFeature<*, *>>) {
        val ruby =
            listOf<OreConfiguration.TargetBlockState>(
                OreConfiguration.target(ruleTest1, BlockInit.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(
                    ruleTest2, BlockInit.SAPPHIRE_ORE.get().defaultBlockState()))

        val sapphire =
            listOf<OreConfiguration.TargetBlockState>(
                OreConfiguration.target(
                    ruleTest1, BlockInit.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruleTest2, BlockInit.RUBY_ORE.get().defaultBlockState()))

        val graphite =
            listOf<OreConfiguration.TargetBlockState>(
                OreConfiguration.target(
                    ruleTest1, BlockInit.GRAPHITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(
                    ruleTest2, BlockInit.AQUMARINE_ORE.get().defaultBlockState()))

        val aqumarine =
            listOf<OreConfiguration.TargetBlockState>(
                OreConfiguration.target(
                    ruleTest1, BlockInit.AQUMARINE_ORE.get().defaultBlockState()),
                OreConfiguration.target(
                    ruleTest2, BlockInit.GRAPHITE_ORE.get().defaultBlockState()))

        val rainbow =
            listOf<OreConfiguration.TargetBlockState>(
                OreConfiguration.target(ruleTest1, BlockInit.RAINBOW_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruleTest2, BlockInit.RAINBOW_ORE.get().defaultBlockState()))

        registerOre(context, RUBY_ORE, ruby, 6)
        registerOre(context, SAPPHIRE_ORE, sapphire, 3)
        registerOre(context, GRAPHITE_ORE, graphite, 6)
        registerOre(context, AQUMARINE_ORE, aqumarine, 2)
        registerOre(context, RAINBOW_ORE, rainbow, 2)
    }

    private fun createKey(name: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, getModIdAndName(name))
    }

    private fun registerOre(
        context: BootstapContext<ConfiguredFeature<*, *>>,
        ore: ResourceKey<ConfiguredFeature<*, *>>,
        targetBlockStates: kotlin.collections.List<OreConfiguration.TargetBlockState>,
        size: Int,
    ) {
        context.register(
            ore,
            ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
                Feature.ORE, OreConfiguration(targetBlockStates, size)))
    }

    private fun registerOre(
        context: BootstapContext<ConfiguredFeature<*, *>>,
        ore: ResourceKey<ConfiguredFeature<*, *>>,
        ruleTest: RuleTest,
        blockState: BlockState,
        size: Int,
    ) {
        context.register(
            ore,
            ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
                Feature.ORE, OreConfiguration(ruleTest, blockState, size)))
    }
}
