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
package io.github.realyusufismail.armourandtoolsmod.client.renderer.mjolnir

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.math.Axis
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.client.ClientEvents
import io.github.realyusufismail.armourandtoolsmod.common.entity.ArmourToolsModTridentEntity
import io.github.realyusufismail.armourandtoolsmod.models.MjolnirModel
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.entity.EntityRenderer
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.ItemRenderer
import net.minecraft.client.renderer.texture.OverlayTexture
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.Mth

class MjolnirItemRenderer(context: EntityRendererProvider.Context) :
    EntityRenderer<ArmourToolsModTridentEntity>(context) {
    private val location: ResourceLocation =
        ArmourAndToolsMod.getModIdAndName("textures/entity/item/mjolnir/all.png")
    private var mjolnirModel: MjolnirModel? = null

    init {
        mjolnirModel = MjolnirModel(context.bakeLayer(ClientEvents.MjolnirLayer))
    }

    override fun render(
        pEntity: ArmourToolsModTridentEntity,
        entityYaw: Float,
        partialTicks: Float,
        matrixStackIn: PoseStack,
        bufferIn: MultiBufferSource,
        packedLightIn: Int
    ) {
        matrixStackIn.pushPose()
        matrixStackIn.mulPose(
            Axis.YP.rotationDegrees(Mth.lerp(partialTicks, pEntity.yRotO, pEntity.yRot) - 90.0f))
        matrixStackIn.mulPose(
            Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, pEntity.xRotO, pEntity.xRot) + 90.0f))
        val ivertexbuilder =
            ItemRenderer.getFoilBufferDirect(
                bufferIn,
                mjolnirModel!!.renderType(getTextureLocation(pEntity)),
                false,
                pEntity.hasGlint())
        mjolnirModel!!.renderToBuffer(
            matrixStackIn,
            ivertexbuilder,
            packedLightIn,
            OverlayTexture.NO_OVERLAY,
            1.0f,
            1.0f,
            1.0f,
            1.0f)
        matrixStackIn.popPose()
        super.render(pEntity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn)
    }

    override fun getTextureLocation(pEntity: ArmourToolsModTridentEntity): ResourceLocation {
        return location
    }
}
