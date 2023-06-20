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
package io.github.realyusufismail.armourandtoolsmod.datagen.texture

import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.util.bName
import io.github.realyusufismail.armourandtoolsmod.core.util.name
import net.minecraft.client.renderer.block.model.BlockModel
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemDisplayContext
import net.minecraft.world.level.block.Block
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile
import net.minecraftforge.common.data.ExistingFileHelper

class ModItemStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    ItemModelProvider(output, MOD_ID, exFileHelper) {

    override fun registerModels() {
        item(ItemInit.RUBY.get())
        item(ItemInit.SAPPHIRE.get())
        item(ItemInit.GRAPHITE.get())
        item(ItemInit.AQUMARINE.get())
        item(ItemInit.RAINBOW.get())

        // raw ores
        item(ItemInit.RAW_RUBY.get())
        item(ItemInit.RAW_SAPPHIRE.get())
        item(ItemInit.RAW_GRAPHITE.get())
        item(ItemInit.RAW_AQUMARINE.get())
        item(ItemInit.RAW_RAINBOW.get())

        // armour
        item(ItemInit.AMETHYST_HELMET.get())
        item(ItemInit.AMETHYST_CHESTPLATE.get())
        item(ItemInit.AMETHYST_LEGGINGS.get())
        item(ItemInit.AMETHYST_BOOTS.get())

        item(ItemInit.RUBY_HELMET.get())
        item(ItemInit.RUBY_CHESTPLATE.get())
        item(ItemInit.RUBY_LEGGINGS.get())
        item(ItemInit.RUBY_BOOTS.get())

        item(ItemInit.SAPPHIRE_HELMET.get())
        item(ItemInit.SAPPHIRE_CHESTPLATE.get())
        item(ItemInit.SAPPHIRE_LEGGINGS.get())
        item(ItemInit.SAPPHIRE_BOOTS.get())

        item(ItemInit.GRAPHITE_HELMET.get())
        item(ItemInit.GRAPHITE_CHESTPLATE.get())
        item(ItemInit.GRAPHITE_LEGGINGS.get())
        item(ItemInit.GRAPHITE_BOOTS.get())

        item(ItemInit.AQUMARINE_HELMET.get())
        item(ItemInit.AQUMARINE_CHESTPLATE.get())
        item(ItemInit.AQUMARINE_LEGGINGS.get())
        item(ItemInit.AQUMARINE_BOOTS.get())

        item(ItemInit.RAINBOW_HELMET.get())
        item(ItemInit.RAINBOW_CHESTPLATE.get())
        item(ItemInit.RAINBOW_LEGGINGS.get())
        item(ItemInit.RAINBOW_BOOTS.get())

        tool(ItemInit.RUBY_SWORD.get())
        tool(ItemInit.RUBY_PICKAXE.get())
        tool(ItemInit.RUBY_AXE.get())
        tool(ItemInit.RUBY_SHOVEL.get())
        tool(ItemInit.RUBY_HOE.get())
    }

    private fun tool(item: Item) {
        val name = item.name
        getBuilder(name)
            .parent(getExistingFile(mcLoc("item/handheld")))
            .texture("layer0", "item/$name")
    }

    private fun item(item: Item) {
        val name = item.name
        getBuilder(name)
            .parent(getExistingFile(mcLoc("item/generated")))
            .texture("layer0", "item/$name")
    }

    private fun shield(block: Block, item: Item) {
        val name = item.name
        getBuilder(name)
            .parent(ModelFile.UncheckedModelFile(ResourceLocation("builtin/entity")))
            .guiLight(BlockModel.GuiLight.FRONT)
            .texture("particle", "block/${block.bName}")
            .transforms()
            .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
            .rotation(0f, 90f, 0f)
            .translation(10f, 6f, -4f)
            .scale(1f, 1f, 1f)
            .end()
            .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
            .rotation(0f, 90f, 0f)
            .translation(10f, 6f, 12f)
            .scale(1f, 1f, 1f)
            .end()
            .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
            .rotation(0f, 180f, 5f)
            .translation(-10F, 2F, -10F)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
            .rotation(0f, 180f, 5f)
            .translation(-10F, 0F, -10F)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.GUI)
            .rotation(15F, -25F, -5F)
            .translation(2F, 3F, 0F)
            .scale(0.65f, 0.65f, 0.65f)
            .end()
            .transform(ItemDisplayContext.FIXED)
            .rotation(0F, 180F, 0F)
            .translation(-4.5F, 4.5F, -5F)
            .scale(0.55F, 0.55F, 0.55F)
            .end()
            .transform(ItemDisplayContext.GROUND)
            .rotation(0F, 0F, 0F)
            .translation(2F, 4F, 2F)
            .scale(0.25F, 0.25F, 0.25F)
            .end()
            .end()
            .override()
            .predicate(mcLoc("blocking"), 1f)
            .model(getExistingFile(mcLoc("item/$name")))
            .end()

        shieldBlock(block, item)
    }

    private fun shieldBlock(block: Block, item: Item) {
        val name = item.name + "_blocking"
        getBuilder(name)
            .parent(ModelFile.UncheckedModelFile(ResourceLocation("builtin/entity")))
            .guiLight(BlockModel.GuiLight.FRONT)
            .texture("particle", "block/${block.bName}")
            .transforms()
            .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
            .rotation(45F, 135F, 0F)
            .translation(3.51F, 11F, -2F)
            .scale(1F, 1F, 1F)
            .end()
            .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
            .rotation(45F, 135F, 0F)
            .translation(13.51F, 3F, 5F)
            .scale(1F, 1F, 1F)
            .end()
            .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
            .rotation(0F, 180F, -5F)
            .translation(-15F, 5F, -11F)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
            .rotation(0F, 180F, -5F)
            .translation(-15F, 5F, -11F)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.GUI)
            .rotation(15F, -25F, -5F)
            .translation(2F, 3F, 0F)
            .scale(0.65f, 0.65f, 0.65f)
            .end()
            .end()
    }
}
