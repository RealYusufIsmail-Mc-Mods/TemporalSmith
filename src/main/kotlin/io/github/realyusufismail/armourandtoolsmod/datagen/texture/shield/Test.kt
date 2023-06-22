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
package io.github.realyusufismail.armourandtoolsmod.datagen.texture.shield

import net.minecraft.client.renderer.block.model.BlockModel
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

fun newShieldTest(block: Block, item: Item) {
    val shieldJsonBuilder = ShieldJsonBuilder(block, item)

    shieldJsonBuilder.setParent("builtin/entity")
    shieldJsonBuilder.setGuiLight(BlockModel.GuiLight.FRONT)

    val displayJsonBuilder = DisplayJsonBuilder()
    val rightHandTransformJsonBuilder = TransformJsonBuilder(RotationType.FIRST_PERSON_RIGHT_HAND)
    rightHandTransformJsonBuilder.setRotation(0F, 90F, 0F)
    rightHandTransformJsonBuilder.setTranslation(10F, 6F, -4F)
    rightHandTransformJsonBuilder.setScale(1F, 1F, 1F)
    displayJsonBuilder.transform(rightHandTransformJsonBuilder.build())


}
