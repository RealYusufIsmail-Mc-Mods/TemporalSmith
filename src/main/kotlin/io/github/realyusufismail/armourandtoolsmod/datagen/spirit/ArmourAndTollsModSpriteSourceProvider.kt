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
package io.github.realyusufismail.armourandtoolsmod.datagen.spirit

import com.google.common.collect.ImmutableMap
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.MOD_ID
import java.util.*
import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.common.data.SpriteSourceProvider

/** Makes sure that the textures are loaded from the correct location. */
class ArmourAndTollsModSpriteSourceProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    SpriteSourceProvider(output, exFileHelper, MOD_ID) {
    override fun addSources() {
        val blockAtlas = atlas(BLOCKS_ATLAS)
        val armorTrimsAtlas = atlas(ResourceLocation("armor_trims"))

        blockAtlas.addSource(
            SingleFile(ArmourAndToolsMod.getModIdAndName("entity/shield/ruby"), Optional.empty()))

        blockAtlas.addSource(
            SingleFile(
                ArmourAndToolsMod.getModIdAndName("entity/shield/aqumarine"), Optional.empty()))

        blockAtlas.addSource(
            SingleFile(
                ArmourAndToolsMod.getModIdAndName("entity/shield/rainbow"), Optional.empty()))

        blockAtlas.addSource(
            SingleFile(
                ArmourAndToolsMod.getModIdAndName("entity/shield/sapphire"), Optional.empty()))

        blockAtlas.addSource(
            SingleFile(
                ArmourAndToolsMod.getModIdAndName("entity/shield/graphite"), Optional.empty()))

        //  Add the armor trims to ruby armor
        armorTrimsAtlas.addSource(
            PalettedPermutations(
                listOf(
                    ArmourAndToolsMod.getModIdAndName("trims/items/ruby_head_trim"),
                    ArmourAndToolsMod.getModIdAndName("trims/items/ruby_chest_trim"),
                    ArmourAndToolsMod.getModIdAndName("trims/items/ruby_legs_trim"),
                    ArmourAndToolsMod.getModIdAndName("trims/items/ruby_feet_trim")),
                ResourceLocation("trims/color_palettes/trim_palette"),
                ImmutableMap.builder<String, ResourceLocation>()
                    .put("ruby_emerald", ResourceLocation("trims/color_palettes/emerald"))
                    .put("ruby_lapis", ResourceLocation("trims/color_palettes/lapis"))
                    .put("ruby_diamond", ResourceLocation("trims/color_palettes/diamond"))
                    .put("ruby_gold", ResourceLocation("trims/color_palettes/gold"))
                    .put("ruby_iron", ResourceLocation("trims/color_palettes/iron"))
                    .put("ruby_redstone", ResourceLocation("trims/color_palettes/redstone"))
                    .put("ruby_coal", ResourceLocation("trims/color_palettes/coal"))
                    .put("ruby_copper", ResourceLocation("trims/color_palettes/copper"))
                    .put("ruby_quartz", ResourceLocation("trims/color_palettes/quartz"))
                    .put("ruby_amethyst", ResourceLocation("trims/color_palettes/amethyst"))
                    .build()))
    }
}
