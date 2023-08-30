package io.github.realyusufismail.armourandtoolsmod.worldgen

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.MOD_ID
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest


object ModConfiguredFeatures {

    val OVERWORLD_RUBY_ORE = registerKey("ruby_ore")
    val OVERWORLD_SAPPHIRE_ORE = registerKey("sapphire_ore")
    val OVERWORLD_GRAPHITE_ORE = registerKey("graphite_ore")
    val OVERWORLD_AQUMARINE_ORE = registerKey("aqumarine_ore")
    val OVERWORLD_RAINBOW_ORE = registerKey("rainbow_ore")
    val END_ENDERITE_ORE = registerKey("enderite_ore")


    fun bootstrap(context : BootstapContext<ConfiguredFeature<*, *>>) {
        val stoneReplaceables: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
        val deepslateReplaceables: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
        val netherrackReplaceables: RuleTest = BlockMatchTest(Blocks.NETHERRACK)
        val endstoneReplaceables: RuleTest = BlockMatchTest(Blocks.END_STONE)
    }

    private fun registerKey(name: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation(MOD_ID, name)
        )
    }

    private fun <FC : FeatureConfiguration, F : Feature<FC>> register(
        context: BootstapContext<ConfiguredFeature<*, *>>,
        key: ResourceKey<ConfiguredFeature<*, *>>, feature: F, configuration: FC
    ) {
        context.register(key, ConfiguredFeature(feature, configuration))
    }
}