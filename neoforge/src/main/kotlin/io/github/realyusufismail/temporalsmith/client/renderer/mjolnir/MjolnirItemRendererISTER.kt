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
package io.github.realyusufismail.temporalsmith.client.renderer.mjolnir

import com.mojang.blaze3d.vertex.PoseStack
import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.client.ClientEvents
import io.github.realyusufismail.temporalsmith.client.ModBlockEntityWithoutLevelRenderer
import io.github.realyusufismail.temporalsmith.common.entity.MjolnirEntity
import io.github.realyusufismail.temporalsmith.entities.hammer.MjolnirModel
import io.github.realyusufismail.temporalsmith.items.hammer.Mjolnir
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.entity.ItemRenderer
import net.minecraft.client.resources.model.ModelResourceLocation
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.packs.resources.ResourceManager
import net.minecraft.world.item.ItemDisplayContext
import net.minecraft.world.item.ItemStack

class MjolnirItemRendererISTER : ModBlockEntityWithoutLevelRenderer() {
    private val location: ResourceLocation =
        TemporalSmith.getModIdAndName("textures/entity/item/mjolnir/all.png")
    private var mjolnirModel: MjolnirModel<MjolnirEntity>? = null

    override fun onResourceManagerReload(manager: ResourceManager) {
        mjolnirModel = MjolnirModel(this.entityModelSet.bakeLayer(ClientEvents.MjolnirLayer))
    }

    override fun renderByItem(
        stack: ItemStack,
        transformType: ItemDisplayContext,
        matrixStack: PoseStack,
        buffer: MultiBufferSource,
        combinedLight: Int,
        combinedOverlay: Int
    ) {
        if (stack.item is Mjolnir) {
            val mc = Minecraft.getInstance()
            val itemRenderer = mc.itemRenderer
            val render2d =
                transformType == ItemDisplayContext.GUI ||
                    transformType == ItemDisplayContext.GROUND ||
                    transformType == ItemDisplayContext.FIXED
            if (render2d) {
                val bakedModel = mc.modelManager.getModel(getModelResourceLocation())
                matrixStack.pushPose()
                itemRenderer.render(
                    stack,
                    transformType,
                    true,
                    matrixStack,
                    buffer,
                    combinedLight,
                    combinedOverlay,
                    bakedModel)
                matrixStack.popPose()
            } else {
                matrixStack.pushPose()
                matrixStack.scale(1.0f, -1.0f, -1.0f)
                val ivertexbuilder1 =
                    ItemRenderer.getFoilBufferDirect(
                        buffer,
                        mjolnirModel!!.renderType(getTextureLocation()),
                        false,
                        stack.hasFoil())
                mjolnirModel!!.renderToBuffer(
                    matrixStack,
                    ivertexbuilder1,
                    combinedLight,
                    combinedOverlay,
                    1.0f,
                    1.0f,
                    1.0f,
                    1.0f)
                matrixStack.popPose()
            }
        }
    }

    private fun getModelResourceLocation(): ModelResourceLocation {
        return ModelResourceLocation(TemporalSmith.getModIdAndName("mjolnir"), "inventory")
    }

    private fun getTextureLocation(): ResourceLocation {
        return location
    }
}
