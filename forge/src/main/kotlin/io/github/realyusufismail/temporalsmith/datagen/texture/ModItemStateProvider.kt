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
package io.github.realyusufismail.temporalsmith.datagen.texture

import io.github.realyusufismail.temporalsmith.TemporalSmith.ArmorAndToolsMod.MOD_ID
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.core.util.name
import net.minecraft.client.renderer.block.model.BlockModel.GuiLight
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemDisplayContext
import net.minecraftforge.client.model.generators.ItemModelBuilder
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.client.model.generators.loaders.SeparateTransformsModelBuilder
import net.minecraftforge.common.data.ExistingFileHelper

class ModItemStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    ItemModelProvider(output, MOD_ID, exFileHelper) {

    override fun registerModels() {
        item(ItemInit.RUBY.get())
        item(ItemInit.SAPPHIRE.get())
        item(ItemInit.GRAPHITE.get())
        item(ItemInit.AQUMARINE.get())
        item(ItemInit.RAINBOW.get())
        item(ItemInit.ENDERITE.get())
        item(ItemInit.IMPERIUM.get())

        // raw ores
        item(ItemInit.RAW_RUBY.get())
        item(ItemInit.RAW_SAPPHIRE.get())
        item(ItemInit.RAW_GRAPHITE.get())
        item(ItemInit.RAW_AQUMARINE.get())
        item(ItemInit.RAW_RAINBOW.get())
        item(ItemInit.RAW_ENDERITE.get())
        item(ItemInit.RAW_IMPERIUM.get())

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

        item(ItemInit.ENDERITE_HELMET.get())
        item(ItemInit.ENDERITE_CHESTPLATE.get())
        item(ItemInit.ENDERITE_LEGGINGS.get())
        item(ItemInit.ENDERITE_BOOTS.get())

        // tools

        tool(ItemInit.RUBY_SWORD.get())
        tool(ItemInit.RUBY_PICKAXE.get())
        tool(ItemInit.RUBY_AXE.get())
        tool(ItemInit.RUBY_SHOVEL.get())
        tool(ItemInit.RUBY_HOE.get())

        tool(ItemInit.ENDERITE_SWORD.get())
        tool(ItemInit.ENDERITE_PICKAXE.get())
        tool(ItemInit.ENDERITE_AXE.get())
        tool(ItemInit.ENDERITE_SHOVEL.get())
        tool(ItemInit.ENDERITE_HOE.get())

        tool(ItemInit.AMETHYST_SWORD.get())
        tool(ItemInit.AMETHYST_PICKAXE.get())
        tool(ItemInit.AMETHYST_AXE.get())
        tool(ItemInit.AMETHYST_SHOVEL.get())

        tool(ItemInit.SAPPHIRE_SWORD.get())
        tool(ItemInit.SAPPHIRE_PICKAXE.get())
        tool(ItemInit.SAPPHIRE_AXE.get())
        tool(ItemInit.SAPPHIRE_SHOVEL.get())
        tool(ItemInit.SAPPHIRE_HOE.get())

        tool(ItemInit.IMPERIUM_SWORD.get())
        tool(ItemInit.IMPERIUM_PICKAXE.get())
        tool(ItemInit.MAGMA_STRIKE_PICKAXE.get())

        // Trident
        trident(ItemInit.AQUMARINE_TRIDENT.get())

        val builtInEntityModel: ModelFile = UncheckedModelFile("builtin/entity")

        val rubyShieldBlocking =
            shieldBlockingModel("ruby_shield_blocking", builtInEntityModel, "ruby_block")
        shieldModel("ruby_shield", builtInEntityModel, "ruby_block", rubyShieldBlocking)

        val aqumarineShieldBlocking =
            shieldBlockingModel("aqumarine_shield_blocking", builtInEntityModel, "aqumarine_block")
        shieldModel(
            "aqumarine_shield", builtInEntityModel, "aqumarine_block", aqumarineShieldBlocking)

        val rainbowShieldBlocking =
            shieldBlockingModel("rainbow_shield_blocking", builtInEntityModel, "rainbow_block")
        shieldModel("rainbow_shield", builtInEntityModel, "rainbow_block", rainbowShieldBlocking)

        val sapphireShieldBlocking =
            shieldBlockingModel("sapphire_shield_blocking", builtInEntityModel, "sapphire_block")
        shieldModel("sapphire_shield", builtInEntityModel, "sapphire_block", sapphireShieldBlocking)

        val graphiteShieldBlocking =
            shieldBlockingModel("graphite_shield_blocking", builtInEntityModel, "graphite_block")
        shieldModel("graphite_shield", builtInEntityModel, "graphite_block", graphiteShieldBlocking)
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

    private fun trident(item: Item) {
        val name = item.name
        val itemLoc = modLoc("$folder/$name")
        val guiModel =
            nested()
                .parent(
                    withExistingParent(name + "_gui", "item/generated").texture("layer0", itemLoc))
        val throwModel = tridentThrowModel(name, itemLoc, guiModel)
        tridentInHandBuilder(name, itemLoc, throwModel, guiModel)
    }

    private fun tridentThrowModel(
        name: String,
        itemLoc: ResourceLocation,
        guiModel: ItemModelBuilder
    ): ItemModelBuilder {
        return getBuilder(name + "_throwing")
            .guiLight(GuiLight.FRONT)
            .texture("particle", itemLoc)
            .customLoader<SeparateTransformsModelBuilder<ItemModelBuilder>> {
                parent: ItemModelBuilder?,
                existingFileHelper: ExistingFileHelper? ->
                SeparateTransformsModelBuilder.begin(parent, existingFileHelper)
            } // Throwing model is "base" so that we can have our transforms
            .base(
                nested()
                    .parent(getExistingFile(mcLoc("trident_throwing")))
                    .texture(
                        "particle",
                        itemLoc)) // Gui, ground, and fixed all use the normal "item model"
            .perspective(ItemDisplayContext.GUI, guiModel)
            .perspective(ItemDisplayContext.GROUND, guiModel)
            .perspective(ItemDisplayContext.FIXED, guiModel)
            .end()
    }

    private fun tridentInHandBuilder(
        name: String,
        itemLoc: ResourceLocation,
        throwingModel: ItemModelBuilder,
        guiModel: ItemModelBuilder
    ): SeparateTransformsModelBuilder<ItemModelBuilder>? {
        return getBuilder(name)
            .guiLight(GuiLight.FRONT)
            .texture(
                "particle",
                itemLoc) // Override when throwing to the throwing model to ensure we have the
            // correct transforms
            .override()
            .predicate(modLoc("throwing"), 1f)
            .model(throwingModel)
            .end()
            .customLoader<SeparateTransformsModelBuilder<ItemModelBuilder>> {
                parent: ItemModelBuilder?,
                existingFileHelper: ExistingFileHelper? ->
                SeparateTransformsModelBuilder.begin(parent, existingFileHelper)
            } // In hand model is base
            .base(
                nested()
                    .parent(getExistingFile(mcLoc("trident_in_hand")))
                    .texture("particle", itemLoc) // Add head transformation
                    .transforms()
                    .transform(ItemDisplayContext.HEAD)
                    .rotation(0f, 180f, 120f)
                    .translation(8f, 10f, -11f)
                    .scale(1.5f)
                    .end()
                    .end()) // Gui, ground, and fixed all use the normal "item model"
            .perspective(ItemDisplayContext.GUI, guiModel)
            .perspective(ItemDisplayContext.GROUND, guiModel)
            .perspective(ItemDisplayContext.FIXED, guiModel)
    }

    private fun shieldBlockingModel(
        path: String,
        parent: ModelFile,
        particleTexture: String
    ): ModelFile {
        return getBuilder(path)
            .parent(parent)
            .guiLight(GuiLight.FRONT)
            .texture("particle", modLoc("$BLOCK_FOLDER/$particleTexture"))
            .transforms()
            .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
            .rotation(45f, 135f, 0f)
            .translation(3.51f, 11f, -2f)
            .scale(1f, 1f, 1f)
            .end()
            .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
            .rotation(45f, 135f, 0f)
            .translation(13.51f, 3f, 5f)
            .scale(1f, 1f, 1f)
            .end()
            .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
            .rotation(0f, 180f, -5f)
            .translation(-15f, 5f, -11f)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
            .rotation(0f, 180f, -5f)
            .translation(5f, 5f, -11f)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.GUI)
            .rotation(15f, -25f, -5f)
            .translation(2f, 3f, 0f)
            .scale(0.65f, 0.65f, 0.65f)
            .end()
            .end()
    }

    private fun shieldModel(
        path: String,
        parent: ModelFile,
        particleTexture: String,
        blockingModel: ModelFile
    ) {
        getBuilder(path)
            .parent(parent)
            .guiLight(GuiLight.FRONT)
            .texture("particle", modLoc("$BLOCK_FOLDER/$particleTexture"))
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
            .translation(-10f, 2f, -10f)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
            .rotation(0f, 180f, 5f)
            .translation(10f, 0f, -10f)
            .scale(1.25f, 1.25f, 1.25f)
            .end()
            .transform(ItemDisplayContext.GUI)
            .rotation(15f, -25f, -5f)
            .translation(2f, 3f, 0f)
            .scale(0.65f, 0.65f, 0.65f)
            .end()
            .transform(ItemDisplayContext.FIXED)
            .rotation(0f, 180f, 0f)
            .translation(-2f, 4f, -5f)
            .scale(0.5f, 0.5f, 0.5f)
            .end()
            .transform(ItemDisplayContext.GROUND)
            .rotation(0f, 0f, 0f)
            .translation(4f, 4f, 2f)
            .scale(0.25f, 0.25f, 0.25f)
            .end()
            .end()
            .override()
            .predicate(mcLoc("blocking"), 1f)
            .model(blockingModel)
            .end()
    }
}
