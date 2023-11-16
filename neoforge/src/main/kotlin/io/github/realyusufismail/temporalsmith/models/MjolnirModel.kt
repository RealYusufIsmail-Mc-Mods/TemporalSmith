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
package io.github.realyusufismail.temporalsmith.models

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.blaze3d.vertex.VertexConsumer
import io.github.realyusufismail.temporalsmith.TemporalSmith
import net.minecraft.client.model.Model
import net.minecraft.client.model.TridentModel
import net.minecraft.client.model.geom.ModelPart
import net.minecraft.client.model.geom.PartPose
import net.minecraft.client.model.geom.builders.CubeListBuilder
import net.minecraft.client.model.geom.builders.LayerDefinition
import net.minecraft.client.model.geom.builders.MeshDefinition
import net.minecraft.client.model.geom.builders.PartDefinition
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation

/** @see TridentModel */
class MjolnirModel(val root: ModelPart) : Model(RenderType::entitySolid) {
    private val texture: ResourceLocation =
        TemporalSmith.getModIdAndName("textures/item/mjolnir/all.png")

    override fun renderToBuffer(
        pPoseStack: PoseStack,
        pBuffer: VertexConsumer,
        pPackedLight: Int,
        pPackedOverlay: Int,
        pRed: Float,
        pGreen: Float,
        pBlue: Float,
        pAlpha: Float
    ) {
        root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha)
    }

    companion object {
        fun createLayer(): LayerDefinition {
            val meshDefinition = MeshDefinition()
            val partDefinition = meshDefinition.root

            addTheMiddleParts(partDefinition)
            addTheSideParts(partDefinition)
            addTheHandle(partDefinition)

            return LayerDefinition.create(meshDefinition, 128, 128)
        }

        private fun addTheMiddleParts(partDefinition: PartDefinition): PartDefinition {
            return partDefinition
                .addOrReplaceChild(
                    "grayPart",
                    CubeListBuilder().texOffs(0, 0).addBox(5.7f, 7.9f, 4.2f, 6f, 0.4f, 0.3f),
                    PartPose.offsetAndRotation(0f, 4.5f, 0f, 0f, 0f, 0f))
                .addOrReplaceChild(
                    "darkPart",
                    CubeListBuilder().texOffs(0, 0).addBox(5.7f, 8.3f, 4.3f, 6f, 0.3f, 0.2f),
                    PartPose.offsetAndRotation(0f, 4.5f, 0f, 0f, 0f, 0f))
                .addOrReplaceChild(
                    "ring",
                    CubeListBuilder()
                        .texOffs(0, 0)
                        .addBox(7.9f, 12.975f, 5.025f, 0.7f, 0.2f, 1.675f),
                    PartPose.offsetAndRotation(7.5f, 12.375f, 8f, 0f, -22.5f, 0f))
        }

        private fun addTheSideParts(partDefinition: PartDefinition) {
            partDefinition
                .addOrReplaceChild(
                    "grayPart1",
                    CubeListBuilder().texOffs(0, 0).addBox(11.7f, 12.7f, 5.2f, 0.1f, 0.3f, 4.1f),
                    PartPose.offset(11f, 7.1f, 7.5f))
                .addOrReplaceChild(
                    "pattern",
                    CubeListBuilder().texOffs(0, 0).addBox(12f, 12.9f, 8.9f, 0.1f, 0.1f, 0.1f),
                    PartPose.offset(11.8f, 7.3f, 7.2f))
                .addOrReplaceChild(
                    "darkPart1",
                    CubeListBuilder().texOffs(0, 0).addBox(11.8f, 12.8f, 5.3f, 0.5f, 0.1f, 3.9f),
                    PartPose.offset(11.6f, 7.2f, 3.6f))
                .addOrReplaceChild(
                    "impactPart",
                    CubeListBuilder().texOffs(0, 0).addBox(13.1f, 7.6f, 5.2f, 0.1f, 4.9f, 4.15f),
                    PartPose.offset(15.755f, 6.975f, 0.025f))
        }

        private fun addTheHandle(partDefinition: PartDefinition) {
            partDefinition
                .addOrReplaceChild(
                    "handle",
                    CubeListBuilder().texOffs(0, 0).addBox(8f, -5.55f, 6.5f, 1f, 0.1f, 1.6f),
                    PartPose.offsetAndRotation(0f, 4.75f, 0f, 0f, 0f, 0f))
                .addOrReplaceChild(
                    "greypart2",
                    CubeListBuilder().texOffs(0, 0).addBox(8f, -4.15f, 7.725f, 0.1f, 11.4f, 0.275f),
                    PartPose.offsetAndRotation(8f, 12.75f, 8f, 0f, 45f, 0f))
        }
    }
}
