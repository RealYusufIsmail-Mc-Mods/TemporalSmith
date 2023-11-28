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
package io.github.realyusufismail.temporalsmith.entities.hammer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.realyusufismail.temporalsmith.client.ClientEvents;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class MjolnirModel<T extends Entity> extends EntityModel<T> {
  public static final ModelLayerLocation LAYER_LOCATION = ClientEvents.INSTANCE.getMjolnirLayer();
  private final ModelPart Themiddlepart;
  private final ModelPart Sidepart;
  private final ModelPart handle;

  public MjolnirModel(ModelPart root) {
    this.Themiddlepart = root.getChild("Themiddlepart");
    this.Sidepart = root.getChild("Sidepart");
    this.handle = root.getChild("handle");
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition Themiddlepart =
        partdefinition.addOrReplaceChild(
            "Themiddlepart", CubeListBuilder.create(), PartPose.offset(-8.0F, 16.0F, 8.0F));

    PartDefinition Graypart =
        Themiddlepart.addOrReplaceChild(
            "Graypart",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.7F, -5.2F, -4.95F, 6.0F, 0.4F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -5.6F, -4.95F, 1.9F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.4F, -5.6F, -4.95F, 1.9F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.8F, -5.6F, -4.95F, 2.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -5.4F, -4.95F, 1.2F, 0.2F, 6.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -9.1F, -4.95F, 6.0F, 3.5F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -9.1F, 1.05F, 6.0F, 3.5F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -5.2F, 0.85F, 6.0F, 0.4F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -5.4F, 1.05F, 1.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.4F, -5.6F, 1.05F, 1.9F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -5.6F, 1.05F, 1.9F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.8F, -5.6F, 1.05F, 2.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -4.0F, -4.05F, 6.0F, 0.1F, 4.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -10.0F, -4.05F, 6.0F, 0.1F, 4.3F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 4.9F, 1.15F));

    PartDefinition cube_r1 =
        Graypart.addOrReplaceChild(
            "cube_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.7F, 0.275F, -0.25F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.7854F, 0.0F, 0.0F));

    PartDefinition cube_r2 =
        Graypart.addOrReplaceChild(
            "cube_r2",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.7F, -0.6F, -0.25F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -9.4F, 0.0F, -0.7854F, 0.0F, 0.0F));

    PartDefinition cube_r3 =
        Graypart.addOrReplaceChild(
            "cube_r3",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.7F, 0.275F, -1.025F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, -3.8F, -0.7854F, 0.0F, 0.0F));

    PartDefinition cube_r4 =
        Graypart.addOrReplaceChild(
            "cube_r4",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.7F, -0.6F, -1.025F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -9.4F, -3.8F, 0.7854F, 0.0F, 0.0F));

    PartDefinition cube_r5 =
        Graypart.addOrReplaceChild(
            "cube_r5",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(3.05F, 3.85F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -10.125F, -1.15F, 0.0F, 0.0F, 0.3927F));

    PartDefinition cube_r6 =
        Graypart.addOrReplaceChild(
            "cube_r6",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.6F, 3.85F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.05F, -10.125F, -1.15F, 0.0F, 0.0F, -0.3927F));

    PartDefinition cube_r7 =
        Graypart.addOrReplaceChild(
            "cube_r7",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(3.15F, 3.8F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -10.5F, -1.15F, 0.0F, 0.0F, 0.3927F));

    PartDefinition cube_r8 =
        Graypart.addOrReplaceChild(
            "cube_r8",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.7F, 3.8F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.05F, -10.5F, -1.15F, 0.0F, 0.0F, -0.3927F));

    PartDefinition Darkpart =
        Themiddlepart.addOrReplaceChild(
            "Darkpart",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.7F, -0.6F, -3.7F, 6.0F, 0.3F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -0.6F, 2.0F, 6.0F, 0.3F, 0.2F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.0F));

    PartDefinition Ring =
        Themiddlepart.addOrReplaceChild(
            "Ring",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.7F, -5.3F, -1.1F, 3.7F, 0.2F, 0.7F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.8F, -5.3F, -2.6F, 0.7F, 0.2F, 3.7F, new CubeDeformation(0.0F)),
            PartPose.offset(-1.8F, 0.125F, 0.0F));

    PartDefinition cube_r9 =
        Ring.addOrReplaceChild(
            "cube_r9",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(0.4F, -0.8F, -2.975F, 0.7F, 0.2F, 1.675F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, -0.3927F, 0.0F));

    PartDefinition cube_r10 =
        Ring.addOrReplaceChild(
            "cube_r10",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.125F, -0.8F, -3.175F, 0.825F, 0.2F, 1.75F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r11 =
        Ring.addOrReplaceChild(
            "cube_r11",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.8F, -0.575F, 1.725F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, 0.3927F, 0.0F));

    PartDefinition cube_r12 =
        Ring.addOrReplaceChild(
            "cube_r12",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.55F, -0.8F, -0.125F, 1.65F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, -1.5F, 0.0F, -0.3927F, 0.0F));

    PartDefinition cube_r13 =
        Ring.addOrReplaceChild(
            "cube_r13",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.125F, -0.8F, 1.625F, 0.825F, 0.2F, 1.55F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, -1.5F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r14 =
        Ring.addOrReplaceChild(
            "cube_r14",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(0.4F, -0.8F, 1.225F, 0.7F, 0.2F, 1.75F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.5F, -1.5F, 0.0F, 0.3927F, 0.0F));

    PartDefinition cube_r15 =
        Ring.addOrReplaceChild(
            "cube_r15",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.1F, -0.8F, 1.225F, 0.7F, 0.2F, 1.75F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.3F, -4.5F, -1.5F, 0.0F, -0.3927F, 0.0F));

    PartDefinition cube_r16 =
        Ring.addOrReplaceChild(
            "cube_r16",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.7F, -0.8F, 1.625F, 0.825F, 0.2F, 1.55F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.3F, -4.5F, -1.5F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r17 =
        Ring.addOrReplaceChild(
            "cube_r17",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.2F, -0.8F, -0.125F, 1.65F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.3F, -4.5F, -1.5F, 0.0F, 0.3927F, 0.0F));

    PartDefinition cube_r18 =
        Ring.addOrReplaceChild(
            "cube_r18",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.2F, -0.8F, -0.575F, 1.725F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.3F, -4.5F, 0.0F, 0.0F, -0.3927F, 0.0F));

    PartDefinition cube_r19 =
        Ring.addOrReplaceChild(
            "cube_r19",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.1F, -0.8F, -2.975F, 0.7F, 0.2F, 1.675F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.3F, -4.5F, 0.0F, 0.0F, 0.3927F, 0.0F));

    PartDefinition Sidepart =
        partdefinition.addOrReplaceChild(
            "Sidepart", CubeListBuilder.create(), PartPose.offset(-8.0F, 16.0F, 8.0F));

    PartDefinition Graypart2 =
        Sidepart.addOrReplaceChild(
            "Graypart2",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.4F, -9.9F, -0.15F, 0.1F, 0.3F, 4.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.7F, -9.9F, -0.15F, 0.1F, 0.3F, 4.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.4F, -9.0F, 4.55F, 0.1F, 4.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.7F, -9.0F, 4.55F, 0.1F, 4.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.4F, -9.0F, -1.05F, 0.1F, 4.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.7F, -9.0F, -1.05F, 0.1F, 4.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.4F, -4.3F, -0.15F, 0.1F, 0.3F, 4.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.7F, -4.3F, -0.15F, 0.1F, 0.3F, 4.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -9.9F, 3.85F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -9.9F, 3.85F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -5.0F, 4.55F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -5.0F, 4.55F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -5.0F, -1.05F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -5.0F, -1.05F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -4.3F, 3.85F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -4.3F, 3.85F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -9.9F, -0.15F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -9.9F, -0.15F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -9.0F, 4.55F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -9.0F, 4.55F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -9.0F, -1.05F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -9.0F, -1.05F, 0.5F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-2.9F, -4.3F, -0.15F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.8F, -4.3F, -0.15F, 0.5F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -9.825F, 3.85F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -9.825F, 3.85F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -5.0F, 4.475F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -5.0F, 4.475F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -5.0F, -0.975F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -5.0F, -0.975F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -4.375F, 3.85F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -4.375F, 3.85F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -9.825F, -0.15F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -9.825F, -0.15F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -9.0F, 4.475F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -9.0F, 4.475F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -9.0F, -0.975F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -9.0F, -0.975F, 0.3F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.2F, -4.375F, -0.15F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.3F, -4.375F, -0.15F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -9.75F, 3.85F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -9.75F, 3.85F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -5.0F, 4.375F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -5.0F, 4.375F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -5.0F, -0.9F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -5.0F, -0.9F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -4.475F, 3.85F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -4.475F, 3.85F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -9.75F, -0.15F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -9.75F, -0.15F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -9.0F, 4.375F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -9.0F, 4.375F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -9.0F, -0.9F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -9.0F, -0.9F, 0.4F, 0.1F, 0.325F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.6F, -4.475F, -0.15F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(4.6F, -4.475F, -0.15F, 0.4F, 0.325F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -9.75F, -0.15F, 0.1F, 0.35F, 4.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(5.0F, -9.75F, -0.15F, 0.1F, 0.35F, 4.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -9.0F, 4.35F, 0.1F, 4.1F, 0.35F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(5.0F, -9.0F, 4.35F, 0.1F, 4.1F, 0.35F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -9.0F, -0.9F, 0.1F, 4.1F, 0.35F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(5.0F, -9.0F, -0.9F, 0.1F, 4.1F, 0.35F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.7F, -4.5F, -0.15F, 0.1F, 0.35F, 4.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(5.0F, -4.5F, -0.15F, 0.1F, 0.35F, 4.1F, new CubeDeformation(0.0F)),
            PartPose.offset(-1.4F, 4.9F, -2.65F));

    PartDefinition cube_r20 =
        Graypart2.addOrReplaceChild(
            "cube_r20",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(2.3F, 0.325F, -0.25F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.3F, 0.325F, -0.25F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.9F, 0.275F, -0.175F, 0.3F, 0.125F, 1.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.6F, 0.275F, -0.175F, 0.3F, 0.125F, 1.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.2F, -0.05F, -0.125F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-5.1F, -0.05F, -0.125F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(1.4F, -4.5F, 3.8F, 0.7854F, 0.0F, 0.0F));

    PartDefinition cube_r21 =
        Graypart2.addOrReplaceChild(
            "cube_r21",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(2.3F, -0.45F, -0.25F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.3F, -0.45F, -0.25F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.9F, -0.4F, -0.175F, 0.3F, 0.125F, 1.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.6F, -0.4F, -0.175F, 0.3F, 0.125F, 1.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.2F, -0.35F, -0.125F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-5.1F, -0.35F, -0.125F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(1.4F, -9.4F, 3.8F, -0.7854F, 0.0F, 0.0F));

    PartDefinition cube_r22 =
        Graypart2.addOrReplaceChild(
            "cube_r22",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(3.2F, -0.05F, -0.9F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-5.1F, -0.05F, -0.9F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.9F, 0.275F, -0.975F, 0.3F, 0.125F, 1.175F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.6F, 0.275F, -0.975F, 0.3F, 0.125F, 1.175F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.3F, 0.325F, -1.025F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.3F, 0.325F, -1.025F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(1.4F, -4.5F, 0.0F, -0.7854F, 0.0F, 0.0F));

    PartDefinition cube_r23 =
        Graypart2.addOrReplaceChild(
            "cube_r23",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(3.2F, -0.35F, -0.9F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-5.1F, -0.35F, -0.9F, 0.5F, 0.4F, 1.025F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.9F, -0.4F, -0.975F, 0.3F, 0.125F, 1.175F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.6F, -0.4F, -0.975F, 0.3F, 0.125F, 1.175F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.3F, -0.45F, -1.025F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-4.3F, -0.45F, -1.025F, 0.6F, 0.125F, 1.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(1.4F, -9.4F, 0.0F, 0.7854F, 0.0F, 0.0F));

    PartDefinition Pattern =
        Sidepart.addOrReplaceChild(
            "Pattern",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -9.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -9.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -9.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -9.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -9.1F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -9.1F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -9.1F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -9.1F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -9.3F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -9.3F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -9.3F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -9.3F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -8.8F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -8.8F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -8.8F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -8.8F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -9.0F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -9.0F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -9.0F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -9.0F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 1.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 1.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -9.0F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -9.0F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 1.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 1.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -9.0F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -9.0F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 1.25F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -10.3F, 1.25F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.8F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -8.8F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 1.25F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -4.675F, 1.25F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.8F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -8.8F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 1.05F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -10.3F, 1.05F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.6F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -8.6F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 1.05F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -4.675F, 1.05F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.6F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -8.6F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -10.3F, 0.95F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 0.95F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -8.5F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.5F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -4.675F, 0.95F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 0.95F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -8.5F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.5F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 0.75F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 0.75F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.3F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.3F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 0.75F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 0.75F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.3F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.3F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 0.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 0.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.1F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.1F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 0.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 0.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -8.1F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.1F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 0.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -10.3F, 0.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.9F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -7.9F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 0.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -4.675F, 0.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.9F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -7.9F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 0.25F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 0.25F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.8F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -7.8F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 0.25F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 0.25F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.8F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -7.8F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 0.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -10.3F, 0.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.6F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -7.6F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 0.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -4.675F, 0.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.6F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -7.6F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -10.3F, -0.15F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -0.15F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -7.5F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -7.5F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -4.675F, -0.15F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -0.15F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -7.5F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -7.5F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -10.3F, -0.25F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -10.3F, -0.25F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -7.4F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -7.4F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -4.675F, -0.25F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -4.675F, -0.25F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -7.4F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -7.4F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -0.35F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -10.3F, -0.35F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.2F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -7.2F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -0.35F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -4.675F, -0.35F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.2F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -7.2F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -0.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -0.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.1F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -7.1F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -0.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -0.45F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -7.1F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -7.1F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -0.65F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -0.65F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.9F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.9F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -0.65F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -0.65F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.9F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.9F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -0.85F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -0.85F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.7F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.7F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -0.85F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -0.85F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.7F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.7F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -10.3F, -1.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -1.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -6.5F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.5F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -4.675F, -1.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -1.05F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -6.5F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.5F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -10.3F, -1.25F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -1.25F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -6.3F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.3F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -4.675F, -1.25F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -1.25F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -6.3F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.3F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -1.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -10.3F, -1.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.2F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -6.2F, -2.85F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -1.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -4.675F, -1.35F, 0.2F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.2F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -6.2F, 2.775F, 0.2F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -1.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -1.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.0F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.0F, -2.85F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -1.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -1.55F, 0.3F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.0F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.0F, 2.775F, 0.3F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -10.3F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -5.9F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -5.9F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -4.675F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -5.9F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -5.9F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -10.3F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -5.9F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -5.9F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -4.675F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -1.75F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -5.9F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -5.9F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -10.3F, -1.85F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -10.3F, -1.85F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -5.7F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -5.7F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -4.675F, -1.85F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -4.675F, -1.85F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -5.7F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -5.7F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, -1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -10.3F, -1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.4F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -6.4F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, -1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -4.675F, -1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -6.4F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -6.4F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -10.3F, -0.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, -0.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -6.8F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.8F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -4.675F, -0.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, -0.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -6.8F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -6.8F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -10.3F, 0.65F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 0.65F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -8.2F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.2F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -4.675F, 0.65F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 0.65F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -8.2F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.2F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -10.3F, 1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -8.7F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.7F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -4.675F, 1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 1.15F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -8.7F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -8.7F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -10.3F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -10.3F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -9.2F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -9.2F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -4.675F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -4.675F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, -9.2F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.5F, -9.2F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -10.3F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -10.3F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -9.2F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -9.2F, -2.85F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -4.675F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -4.675F, 1.55F, 0.1F, 0.075F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, -9.2F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.7F, -9.2F, 2.775F, 0.1F, 0.2F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -9.0F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -9.0F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, 1.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -9.0F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -9.0F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.8F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.8F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.8F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.8F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, 1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, 1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -8.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -8.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, 1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, 1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -8.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -8.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, 1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, 1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -8.5F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -8.5F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -8.5F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -8.5F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, 0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, 0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -8.4F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -8.4F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, 0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, 0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -8.4F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -8.4F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.3F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.3F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.3F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.3F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, 0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.1F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.1F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, 0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -8.1F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -8.1F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, 0.35F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 0.35F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -7.9F, -2.775F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -7.9F, -2.775F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, 0.35F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 0.35F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -7.9F, 2.675F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -7.9F, 2.675F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, 0.45F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, 0.45F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -8.0F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -8.0F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, 0.45F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, 0.45F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -8.0F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -8.0F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, 0.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, 0.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -7.8F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.8F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, 0.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, 0.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -7.8F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.8F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -7.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -7.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -7.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -7.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -7.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -7.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -7.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -7.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, 0.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -7.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -7.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -0.15F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, -0.15F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -7.5F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -7.5F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -0.15F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, -0.15F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -7.5F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -7.5F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, -0.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, -0.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -7.3F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -7.3F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, -0.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, -0.35F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -7.3F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -7.3F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -0.45F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, -0.45F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -7.1F, -2.775F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.1F, -2.775F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -0.45F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, -0.45F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -7.1F, 2.675F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.1F, 2.675F, 0.2F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, -0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, -0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -7.0F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.0F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, -0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, -0.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -7.0F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -7.0F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, -0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.9F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.9F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, -0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.9F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.9F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, -0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, -0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -6.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -6.6F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, -0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, -0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -6.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -6.6F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -6.5F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -6.5F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -6.5F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -6.5F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, -1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.4F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.4F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, -1.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.4F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.4F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -6.3F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -6.3F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -6.3F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -6.3F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.2F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.2F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -6.2F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -6.2F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -5.9F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -5.9F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -5.9F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -5.9F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -5.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -5.7F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -5.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -5.7F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -5.8F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -5.8F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -5.8F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -5.8F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -10.225F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -10.225F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -6.1F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -6.1F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -4.775F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -4.775F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.1F, -6.1F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.8F, -6.1F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, -1.55F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, -1.55F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -6.3F, -2.775F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -6.3F, -2.775F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, -1.55F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, -1.55F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -6.3F, 2.675F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -6.3F, 2.675F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, -0.75F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, -0.75F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -6.9F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -6.9F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, -0.75F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, -0.75F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -6.9F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -6.9F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, 0.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, 0.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -8.2F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -8.2F, -2.775F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, 0.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, 0.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -8.2F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -8.2F, 2.675F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -9.0F, -2.775F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -9.0F, -2.775F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -9.0F, 2.675F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -9.0F, 2.675F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -9.1F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -9.1F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 1.55F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -9.1F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -9.1F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -10.225F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -10.225F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -9.3F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -9.3F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -4.775F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -4.775F, 1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, -9.3F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.9F, -9.3F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -10.225F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -10.225F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -9.2F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -9.2F, -2.775F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -4.775F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -4.775F, 1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, -9.2F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(7.0F, -9.2F, 2.675F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -10.3F, 1.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -10.3F, 1.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -9.3F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -9.3F, -2.85F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -4.675F, 1.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -4.675F, 1.75F, 0.1F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, -9.3F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.6F, -9.3F, 2.775F, 0.1F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -8.5F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -8.5F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, 0.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -8.5F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -8.5F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -8.3F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -8.3F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, 0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -8.3F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -8.3F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, 0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, 0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -8.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -8.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, 0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, 0.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -8.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -8.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -7.7F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -7.7F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -7.7F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -7.7F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, -0.25F, 0.2F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, -0.25F, 0.2F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -7.4F, -2.95F, 0.2F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -7.4F, -2.95F, 0.2F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, -0.25F, 0.2F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, -0.25F, 0.2F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -7.4F, 2.85F, 0.2F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -7.4F, 2.85F, 0.2F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -7.7F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -7.7F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, 0.05F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -7.7F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -7.7F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, -0.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, -0.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -7.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -7.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, -0.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, -0.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -7.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -7.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, -0.95F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, -0.95F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -7.1F, -2.95F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -7.1F, -2.95F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, -0.95F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, -0.95F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -7.1F, 2.85F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -7.1F, 2.85F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -6.7F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -6.7F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, -0.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -6.7F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -6.7F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -6.5F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -6.5F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, -1.05F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -6.5F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -6.5F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -6.3F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -6.3F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, -1.25F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -6.3F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -6.3F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -6.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -6.2F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, -1.35F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -6.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -6.2F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -5.9F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -5.9F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, -1.65F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -5.9F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -5.9F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -5.7F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -5.7F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, -1.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -5.7F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -5.7F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -5.8F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -5.8F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, -1.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -5.8F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -5.8F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -6.1F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -6.1F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -6.1F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -6.1F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -6.1F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -6.1F, -2.95F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, -1.55F, 0.1F, 0.1F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -6.1F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -6.1F, 2.85F, 0.1F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, -0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, -0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -6.8F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -6.8F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, -0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, -0.75F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -6.8F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -6.8F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, -1.15F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, -1.15F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -6.6F, -2.95F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -6.6F, -2.95F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, -1.15F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, -1.15F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -6.6F, 2.85F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -6.6F, 2.85F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -10.4F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -10.4F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -7.7F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -7.7F, -2.95F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -4.6F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -4.6F, 0.15F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.6F, -7.7F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.3F, -7.7F, 2.85F, 0.1F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, 0.35F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, 0.35F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -8.4F, -2.95F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -8.4F, -2.95F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, 0.35F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, 0.35F, 0.1F, 0.1F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -8.4F, 2.85F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -8.4F, 2.85F, 0.1F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -10.4F, 0.85F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -10.4F, 0.85F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -8.6F, -2.95F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -8.6F, -2.95F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -4.6F, 0.85F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -4.6F, 0.85F, 0.1F, 0.1F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.7F, -8.6F, 2.85F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.4F, -8.6F, 2.85F, 0.1F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -10.4F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -10.4F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -9.0F, -2.95F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -9.0F, -2.95F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -4.6F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -4.6F, 1.15F, 0.1F, 0.1F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.5F, -9.0F, 2.85F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(6.2F, -9.0F, 2.85F, 0.1F, 0.4F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offset(-3.6F, 5.4F, -0.75F));

    PartDefinition cube_r24 =
        Pattern.addOrReplaceChild(
            "cube_r24",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.425F, 5.8F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.425F, 0.0F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.1F, -7.9F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r25 =
        Pattern.addOrReplaceChild(
            "cube_r25",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, -0.425F, 5.8F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, -0.425F, 0.0F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.3F, -7.9F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r26 =
        Pattern.addOrReplaceChild(
            "cube_r26",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.8F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.0F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.1F, -10.4F, 0.45F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r27 =
        Pattern.addOrReplaceChild(
            "cube_r27",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, 5.8F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, 0.0F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.3F, -10.4F, 0.45F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r28 =
        Pattern.addOrReplaceChild(
            "cube_r28",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, -0.4F, 5.8F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, -0.4F, -0.025F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.15F, -7.4F, -2.925F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r29 =
        Pattern.addOrReplaceChild(
            "cube_r29",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, 5.8F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, -0.025F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.35F, -7.4F, -2.925F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r30 =
        Pattern.addOrReplaceChild(
            "cube_r30",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, 5.8F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, -0.025F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.15F, -10.375F, -0.05F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r31 =
        Pattern.addOrReplaceChild(
            "cube_r31",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, 5.8F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, -0.025F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.35F, -10.375F, -0.05F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r32 =
        Pattern.addOrReplaceChild(
            "cube_r32",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, -0.4F, 5.8F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, -0.4F, 0.0F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -5.225F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r33 =
        Pattern.addOrReplaceChild(
            "cube_r33",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, 5.8F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, 0.0F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -5.225F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r34 =
        Pattern.addOrReplaceChild(
            "cube_r34",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, 5.8F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, 0.0F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -10.4F, -2.225F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r35 =
        Pattern.addOrReplaceChild(
            "cube_r35",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, 5.8F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, 0.0F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -10.4F, -2.225F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r36 =
        Pattern.addOrReplaceChild(
            "cube_r36",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.225F, -5.05F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r37 =
        Pattern.addOrReplaceChild(
            "cube_r37",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.425F, -5.05F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r38 =
        Pattern.addOrReplaceChild(
            "cube_r38",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.225F, -10.4F, -2.4F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r39 =
        Pattern.addOrReplaceChild(
            "cube_r39",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.425F, -10.4F, -2.4F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r40 =
        Pattern.addOrReplaceChild(
            "cube_r40",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.35F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.35F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.225F, -7.25F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r41 =
        Pattern.addOrReplaceChild(
            "cube_r41",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.35F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.35F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.425F, -7.25F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r42 =
        Pattern.addOrReplaceChild(
            "cube_r42",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.225F, -10.4F, -0.2F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r43 =
        Pattern.addOrReplaceChild(
            "cube_r43",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.425F, -10.4F, -0.2F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r44 =
        Pattern.addOrReplaceChild(
            "cube_r44",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -7.15F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r45 =
        Pattern.addOrReplaceChild(
            "cube_r45",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -7.15F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r46 =
        Pattern.addOrReplaceChild(
            "cube_r46",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -10.4F, -0.3F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r47 =
        Pattern.addOrReplaceChild(
            "cube_r47",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -10.4F, -0.3F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r48 =
        Pattern.addOrReplaceChild(
            "cube_r48",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -7.45F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r49 =
        Pattern.addOrReplaceChild(
            "cube_r49",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -7.45F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r50 =
        Pattern.addOrReplaceChild(
            "cube_r50",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -10.4F, 0.0F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r51 =
        Pattern.addOrReplaceChild(
            "cube_r51",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -10.4F, 0.0F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r52 =
        Pattern.addOrReplaceChild(
            "cube_r52",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -4.35F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r53 =
        Pattern.addOrReplaceChild(
            "cube_r53",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -4.35F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r54 =
        Pattern.addOrReplaceChild(
            "cube_r54",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -10.4F, -3.1F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r55 =
        Pattern.addOrReplaceChild(
            "cube_r55",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -10.4F, -3.1F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r56 =
        Pattern.addOrReplaceChild(
            "cube_r56",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -4.55F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r57 =
        Pattern.addOrReplaceChild(
            "cube_r57",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -4.55F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r58 =
        Pattern.addOrReplaceChild(
            "cube_r58",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -10.4F, -2.9F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r59 =
        Pattern.addOrReplaceChild(
            "cube_r59",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -10.4F, -2.9F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r60 =
        Pattern.addOrReplaceChild(
            "cube_r60",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -4.75F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r61 =
        Pattern.addOrReplaceChild(
            "cube_r61",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -4.75F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r62 =
        Pattern.addOrReplaceChild(
            "cube_r62",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -10.4F, -2.7F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r63 =
        Pattern.addOrReplaceChild(
            "cube_r63",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -10.4F, -2.7F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r64 =
        Pattern.addOrReplaceChild(
            "cube_r64",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -4.85F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r65 =
        Pattern.addOrReplaceChild(
            "cube_r65",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -4.85F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r66 =
        Pattern.addOrReplaceChild(
            "cube_r66",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -10.4F, -2.6F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r67 =
        Pattern.addOrReplaceChild(
            "cube_r67",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -10.4F, -2.6F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r68 =
        Pattern.addOrReplaceChild(
            "cube_r68",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.1F, -5.125F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r69 =
        Pattern.addOrReplaceChild(
            "cube_r69",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.3F, -5.125F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r70 =
        Pattern.addOrReplaceChild(
            "cube_r70",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.1F, -10.4F, -2.325F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r71 =
        Pattern.addOrReplaceChild(
            "cube_r71",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.3F, -10.4F, -2.325F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r72 =
        Pattern.addOrReplaceChild(
            "cube_r72",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, -0.375F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, -0.375F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.3F, -5.15F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r73 =
        Pattern.addOrReplaceChild(
            "cube_r73",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.575F, -0.375F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.575F, -0.375F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.5F, -5.15F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r74 =
        Pattern.addOrReplaceChild(
            "cube_r74",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, 5.8F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, 0.0F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.3F, -10.4F, -2.3F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r75 =
        Pattern.addOrReplaceChild(
            "cube_r75",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.575F, 5.8F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.575F, 0.0F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.5F, -10.4F, -2.3F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r76 =
        Pattern.addOrReplaceChild(
            "cube_r76",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, -0.4F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, -0.4F, 0.0F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.275F, -5.35F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r77 =
        Pattern.addOrReplaceChild(
            "cube_r77",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.55F, -0.4F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.55F, -0.4F, 0.0F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.475F, -5.35F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r78 =
        Pattern.addOrReplaceChild(
            "cube_r78",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, 5.8F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, 0.0F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.275F, -10.4F, -2.1F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r79 =
        Pattern.addOrReplaceChild(
            "cube_r79",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.55F, 5.8F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.55F, 0.0F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.475F, -10.4F, -2.1F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r80 =
        Pattern.addOrReplaceChild(
            "cube_r80",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 0.0F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -5.325F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r81 =
        Pattern.addOrReplaceChild(
            "cube_r81",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 0.0F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -5.325F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r82 =
        Pattern.addOrReplaceChild(
            "cube_r82",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -10.4F, -2.125F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r83 =
        Pattern.addOrReplaceChild(
            "cube_r83",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -10.4F, -2.125F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r84 =
        Pattern.addOrReplaceChild(
            "cube_r84",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, -0.425F, 5.8F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, -0.425F, 0.0F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -5.825F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r85 =
        Pattern.addOrReplaceChild(
            "cube_r85",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, 5.8F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, 0.0F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -5.825F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r86 =
        Pattern.addOrReplaceChild(
            "cube_r86",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, 5.8F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, 0.0F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -10.4F, -1.625F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r87 =
        Pattern.addOrReplaceChild(
            "cube_r87",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, 5.8F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, 0.0F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -10.4F, -1.625F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r88 =
        Pattern.addOrReplaceChild(
            "cube_r88",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, -0.4F, 5.8F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, -0.4F, 0.0F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -6.825F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r89 =
        Pattern.addOrReplaceChild(
            "cube_r89",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, -0.4F, 5.8F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, -0.4F, 0.0F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -6.825F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r90 =
        Pattern.addOrReplaceChild(
            "cube_r90",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, 5.8F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, 0.0F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -10.4F, -0.625F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r91 =
        Pattern.addOrReplaceChild(
            "cube_r91",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, 5.8F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, 0.0F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -10.4F, -0.625F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r92 =
        Pattern.addOrReplaceChild(
            "cube_r92",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, -0.425F, 5.8F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, -0.425F, 0.0F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.2F, -6.975F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r93 =
        Pattern.addOrReplaceChild(
            "cube_r93",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 5.8F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 0.0F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.4F, -6.975F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r94 =
        Pattern.addOrReplaceChild(
            "cube_r94",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 5.8F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.0F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.2F, -10.4F, -0.475F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r95 =
        Pattern.addOrReplaceChild(
            "cube_r95",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.4F, -10.4F, -0.475F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r96 =
        Pattern.addOrReplaceChild(
            "cube_r96",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, -0.4F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, -0.4F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.1F, -7.7F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r97 =
        Pattern.addOrReplaceChild(
            "cube_r97",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.3F, -7.7F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r98 =
        Pattern.addOrReplaceChild(
            "cube_r98",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 5.8F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.0F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.1F, -10.4F, 0.25F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r99 =
        Pattern.addOrReplaceChild(
            "cube_r99",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.3F, -10.4F, 0.25F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r100 =
        Pattern.addOrReplaceChild(
            "cube_r100",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -8.425F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r101 =
        Pattern.addOrReplaceChild(
            "cube_r101",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -8.425F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r102 =
        Pattern.addOrReplaceChild(
            "cube_r102",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -10.5F, 0.975F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r103 =
        Pattern.addOrReplaceChild(
            "cube_r103",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -10.5F, 0.975F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r104 =
        Pattern.addOrReplaceChild(
            "cube_r104",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -4.35F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r105 =
        Pattern.addOrReplaceChild(
            "cube_r105",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -4.35F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r106 =
        Pattern.addOrReplaceChild(
            "cube_r106",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -10.5F, -3.1F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r107 =
        Pattern.addOrReplaceChild(
            "cube_r107",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -10.5F, -3.1F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r108 =
        Pattern.addOrReplaceChild(
            "cube_r108",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -4.575F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r109 =
        Pattern.addOrReplaceChild(
            "cube_r109",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -4.575F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r110 =
        Pattern.addOrReplaceChild(
            "cube_r110",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -10.5F, -2.875F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r111 =
        Pattern.addOrReplaceChild(
            "cube_r111",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -10.5F, -2.875F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r112 =
        Pattern.addOrReplaceChild(
            "cube_r112",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.325F, 5.8F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.325F, 0.2F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.525F, -7.025F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r113 =
        Pattern.addOrReplaceChild(
            "cube_r113",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, 0.325F, 5.8F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, 0.325F, 0.2F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.725F, -7.025F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r114 =
        Pattern.addOrReplaceChild(
            "cube_r114",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.525F, -10.5F, -0.425F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r115 =
        Pattern.addOrReplaceChild(
            "cube_r115",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, 5.8F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, 0.2F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.725F, -10.5F, -0.425F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r116 =
        Pattern.addOrReplaceChild(
            "cube_r116",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -7.25F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r117 =
        Pattern.addOrReplaceChild(
            "cube_r117",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -7.25F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r118 =
        Pattern.addOrReplaceChild(
            "cube_r118",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -10.5F, -0.2F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r119 =
        Pattern.addOrReplaceChild(
            "cube_r119",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -10.5F, -0.2F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r120 =
        Pattern.addOrReplaceChild(
            "cube_r120",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 0.2F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -4.85F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r121 =
        Pattern.addOrReplaceChild(
            "cube_r121",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 0.2F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -4.85F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r122 =
        Pattern.addOrReplaceChild(
            "cube_r122",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -10.5F, -2.6F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r123 =
        Pattern.addOrReplaceChild(
            "cube_r123",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -10.5F, -2.6F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r124 =
        Pattern.addOrReplaceChild(
            "cube_r124",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.375F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.375F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.525F, -5.05F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r125 =
        Pattern.addOrReplaceChild(
            "cube_r125",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.375F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.375F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.725F, -5.05F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r126 =
        Pattern.addOrReplaceChild(
            "cube_r126",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.525F, -10.5F, -2.4F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r127 =
        Pattern.addOrReplaceChild(
            "cube_r127",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.725F, -10.5F, -2.4F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r128 =
        Pattern.addOrReplaceChild(
            "cube_r128",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.375F, 5.8F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.375F, 0.2F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.45F, -5.35F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r129 =
        Pattern.addOrReplaceChild(
            "cube_r129",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, -0.375F, 5.8F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, -0.375F, 0.2F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.65F, -5.35F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r130 =
        Pattern.addOrReplaceChild(
            "cube_r130",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.45F, -10.5F, -2.1F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r131 =
        Pattern.addOrReplaceChild(
            "cube_r131",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, 5.8F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, 0.2F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.65F, -10.5F, -2.1F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r132 =
        Pattern.addOrReplaceChild(
            "cube_r132",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -8.15F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r133 =
        Pattern.addOrReplaceChild(
            "cube_r133",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -8.15F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r134 =
        Pattern.addOrReplaceChild(
            "cube_r134",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -10.5F, 0.7F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r135 =
        Pattern.addOrReplaceChild(
            "cube_r135",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -10.5F, 0.7F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r136 =
        Pattern.addOrReplaceChild(
            "cube_r136",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 0.25F, 5.8F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.25F, 0.2F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -8.525F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r137 =
        Pattern.addOrReplaceChild(
            "cube_r137",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.25F, 5.8F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.25F, 0.2F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -8.525F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r138 =
        Pattern.addOrReplaceChild(
            "cube_r138",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.8F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.2F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -10.5F, 1.075F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r139 =
        Pattern.addOrReplaceChild(
            "cube_r139",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -10.5F, 1.075F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r140 =
        Pattern.addOrReplaceChild(
            "cube_r140",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -8.85F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r141 =
        Pattern.addOrReplaceChild(
            "cube_r141",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -8.85F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r142 =
        Pattern.addOrReplaceChild(
            "cube_r142",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.425F, -10.5F, 1.4F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r143 =
        Pattern.addOrReplaceChild(
            "cube_r143",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.625F, -10.5F, 1.4F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r144 =
        Pattern.addOrReplaceChild(
            "cube_r144",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.45F, -9.525F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r145 =
        Pattern.addOrReplaceChild(
            "cube_r145",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.65F, -9.525F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r146 =
        Pattern.addOrReplaceChild(
            "cube_r146",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.45F, -10.5F, 2.075F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r147 =
        Pattern.addOrReplaceChild(
            "cube_r147",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.65F, -10.5F, 2.075F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r148 =
        Pattern.addOrReplaceChild(
            "cube_r148",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.525F, -9.85F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r149 =
        Pattern.addOrReplaceChild(
            "cube_r149",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.725F, -9.85F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r150 =
        Pattern.addOrReplaceChild(
            "cube_r150",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.525F, -10.5F, 2.4F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r151 =
        Pattern.addOrReplaceChild(
            "cube_r151",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.725F, -10.5F, 2.4F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r152 =
        Pattern.addOrReplaceChild(
            "cube_r152",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.475F, -10.0F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r153 =
        Pattern.addOrReplaceChild(
            "cube_r153",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.675F, -10.0F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r154 =
        Pattern.addOrReplaceChild(
            "cube_r154",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.475F, -10.5F, 2.55F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r155 =
        Pattern.addOrReplaceChild(
            "cube_r155",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.675F, -10.5F, 2.55F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r156 =
        Pattern.addOrReplaceChild(
            "cube_r156",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, 0.275F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, 0.275F, 0.2F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -10.525F, -3.05F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r157 =
        Pattern.addOrReplaceChild(
            "cube_r157",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 0.2F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -10.525F, -3.05F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r158 =
        Pattern.addOrReplaceChild(
            "cube_r158",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, 5.8F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, 0.2F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.55F, -10.5F, 3.075F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r159 =
        Pattern.addOrReplaceChild(
            "cube_r159",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.2F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.75F, -10.5F, 3.075F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r160 =
        Pattern.addOrReplaceChild(
            "cube_r160",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.575F, 5.8F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.575F, 0.0F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -7.35F, -2.95F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r161 =
        Pattern.addOrReplaceChild(
            "cube_r161",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.575F, 5.8F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.575F, 0.0F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -7.35F, -2.95F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r162 =
        Pattern.addOrReplaceChild(
            "cube_r162",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.8F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.0F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.125F, -10.4F, -0.1F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r163 =
        Pattern.addOrReplaceChild(
            "cube_r163",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.8F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.0F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.325F, -10.4F, -0.1F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r164 =
        Pattern.addOrReplaceChild(
            "cube_r164",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, -0.4F, 5.825F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, -0.4F, 0.375F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.875F, -6.25F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r165 =
        Pattern.addOrReplaceChild(
            "cube_r165",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, -0.4F, 5.825F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, -0.4F, 0.375F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.075F, -6.25F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r166 =
        Pattern.addOrReplaceChild(
            "cube_r166",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, 5.825F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, 0.375F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.875F, -10.6F, -1.2F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r167 =
        Pattern.addOrReplaceChild(
            "cube_r167",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, 5.825F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, 0.375F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.075F, -10.6F, -1.2F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r168 =
        Pattern.addOrReplaceChild(
            "cube_r168",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -4.35F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r169 =
        Pattern.addOrReplaceChild(
            "cube_r169",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -4.35F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r170 =
        Pattern.addOrReplaceChild(
            "cube_r170",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.6F, -3.1F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r171 =
        Pattern.addOrReplaceChild(
            "cube_r171",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.6F, -3.1F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r172 =
        Pattern.addOrReplaceChild(
            "cube_r172",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.425F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.425F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -4.55F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r173 =
        Pattern.addOrReplaceChild(
            "cube_r173",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -4.55F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r174 =
        Pattern.addOrReplaceChild(
            "cube_r174",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.6F, -2.9F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r175 =
        Pattern.addOrReplaceChild(
            "cube_r175",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, 5.825F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, 0.375F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.6F, -2.9F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r176 =
        Pattern.addOrReplaceChild(
            "cube_r176",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, -0.45F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, -0.45F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -4.775F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r177 =
        Pattern.addOrReplaceChild(
            "cube_r177",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -4.775F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r178 =
        Pattern.addOrReplaceChild(
            "cube_r178",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 5.825F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.375F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -10.6F, -2.675F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r179 =
        Pattern.addOrReplaceChild(
            "cube_r179",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -10.6F, -2.675F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r180 =
        Pattern.addOrReplaceChild(
            "cube_r180",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.5F, -0.45F, 5.825F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.5F, -0.45F, 0.375F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.775F, -4.875F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r181 =
        Pattern.addOrReplaceChild(
            "cube_r181",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 5.825F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 0.375F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.975F, -4.875F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r182 =
        Pattern.addOrReplaceChild(
            "cube_r182",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.5F, 5.825F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.5F, 0.375F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.775F, -10.6F, -2.575F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r183 =
        Pattern.addOrReplaceChild(
            "cube_r183",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.975F, -10.6F, -2.575F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r184 =
        Pattern.addOrReplaceChild(
            "cube_r184",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.85F, -7.425F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r185 =
        Pattern.addOrReplaceChild(
            "cube_r185",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.05F, -7.425F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r186 =
        Pattern.addOrReplaceChild(
            "cube_r186",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.85F, -10.6F, -0.025F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r187 =
        Pattern.addOrReplaceChild(
            "cube_r187",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.05F, -10.6F, -0.025F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r188 =
        Pattern.addOrReplaceChild(
            "cube_r188",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -7.6F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r189 =
        Pattern.addOrReplaceChild(
            "cube_r189",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -7.6F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r190 =
        Pattern.addOrReplaceChild(
            "cube_r190",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.6F, 0.15F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r191 =
        Pattern.addOrReplaceChild(
            "cube_r191",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.6F, 0.15F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r192 =
        Pattern.addOrReplaceChild(
            "cube_r192",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.85F, -7.125F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r193 =
        Pattern.addOrReplaceChild(
            "cube_r193",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.05F, -7.125F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r194 =
        Pattern.addOrReplaceChild(
            "cube_r194",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.85F, -10.6F, -0.325F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r195 =
        Pattern.addOrReplaceChild(
            "cube_r195",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.05F, -10.6F, -0.325F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r196 =
        Pattern.addOrReplaceChild(
            "cube_r196",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.7F, -7.5F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r197 =
        Pattern.addOrReplaceChild(
            "cube_r197",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.9F, -7.5F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r198 =
        Pattern.addOrReplaceChild(
            "cube_r198",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.7F, -10.6F, 0.05F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r199 =
        Pattern.addOrReplaceChild(
            "cube_r199",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.9F, -10.6F, 0.05F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r200 =
        Pattern.addOrReplaceChild(
            "cube_r200",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -4.975F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r201 =
        Pattern.addOrReplaceChild(
            "cube_r201",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -4.975F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r202 =
        Pattern.addOrReplaceChild(
            "cube_r202",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -10.6F, -2.475F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r203 =
        Pattern.addOrReplaceChild(
            "cube_r203",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -10.6F, -2.475F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r204 =
        Pattern.addOrReplaceChild(
            "cube_r204",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 5.825F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 0.375F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.775F, -5.075F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r205 =
        Pattern.addOrReplaceChild(
            "cube_r205",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, -0.45F, 5.825F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, -0.45F, 0.375F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.975F, -5.075F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r206 =
        Pattern.addOrReplaceChild(
            "cube_r206",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.775F, -10.6F, -2.375F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r207 =
        Pattern.addOrReplaceChild(
            "cube_r207",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, 5.825F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, 0.375F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.975F, -10.6F, -2.375F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r208 =
        Pattern.addOrReplaceChild(
            "cube_r208",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -5.275F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r209 =
        Pattern.addOrReplaceChild(
            "cube_r209",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -5.275F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r210 =
        Pattern.addOrReplaceChild(
            "cube_r210",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -10.6F, -2.175F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r211 =
        Pattern.addOrReplaceChild(
            "cube_r211",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -10.6F, -2.175F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r212 =
        Pattern.addOrReplaceChild(
            "cube_r212",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -5.35F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r213 =
        Pattern.addOrReplaceChild(
            "cube_r213",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -5.35F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r214 =
        Pattern.addOrReplaceChild(
            "cube_r214",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.55F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.55F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.6F, -2.1F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r215 =
        Pattern.addOrReplaceChild(
            "cube_r215",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.6F, -2.1F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r216 =
        Pattern.addOrReplaceChild(
            "cube_r216",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.375F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.375F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.725F, -5.55F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r217 =
        Pattern.addOrReplaceChild(
            "cube_r217",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.375F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.375F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.925F, -5.55F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r218 =
        Pattern.addOrReplaceChild(
            "cube_r218",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.825F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.375F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.725F, -10.6F, -1.9F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r219 =
        Pattern.addOrReplaceChild(
            "cube_r219",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.925F, -10.6F, -1.9F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r220 =
        Pattern.addOrReplaceChild(
            "cube_r220",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, -0.4F, 5.825F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, -0.4F, 0.375F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.875F, -5.775F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r221 =
        Pattern.addOrReplaceChild(
            "cube_r221",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.55F, -0.4F, 5.825F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.55F, -0.4F, 0.375F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.075F, -5.775F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r222 =
        Pattern.addOrReplaceChild(
            "cube_r222",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.625F, 5.825F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.625F, 0.375F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.875F, -10.6F, -1.675F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r223 =
        Pattern.addOrReplaceChild(
            "cube_r223",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.55F, 5.825F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.55F, 0.375F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.075F, -10.6F, -1.675F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r224 =
        Pattern.addOrReplaceChild(
            "cube_r224",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.825F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.375F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.75F, -6.25F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r225 =
        Pattern.addOrReplaceChild(
            "cube_r225",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, 5.825F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, 0.375F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.95F, -6.25F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r226 =
        Pattern.addOrReplaceChild(
            "cube_r226",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.825F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.375F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.75F, -10.6F, -1.2F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r227 =
        Pattern.addOrReplaceChild(
            "cube_r227",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, 5.825F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, 0.375F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.95F, -10.6F, -1.2F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r228 =
        Pattern.addOrReplaceChild(
            "cube_r228",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, -0.4F, 5.825F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, -0.4F, 0.375F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.75F, -6.45F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r229 =
        Pattern.addOrReplaceChild(
            "cube_r229",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, 5.825F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, -0.4F, 0.375F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.95F, -6.45F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r230 =
        Pattern.addOrReplaceChild(
            "cube_r230",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, 5.825F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, 0.375F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.75F, -10.6F, -1.0F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r231 =
        Pattern.addOrReplaceChild(
            "cube_r231",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, 5.825F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, 0.375F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.95F, -10.6F, -1.0F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r232 =
        Pattern.addOrReplaceChild(
            "cube_r232",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.725F, -6.675F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r233 =
        Pattern.addOrReplaceChild(
            "cube_r233",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.925F, -6.675F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r234 =
        Pattern.addOrReplaceChild(
            "cube_r234",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.725F, -10.6F, -0.775F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r235 =
        Pattern.addOrReplaceChild(
            "cube_r235",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.925F, -10.6F, -0.775F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r236 =
        Pattern.addOrReplaceChild(
            "cube_r236",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -6.85F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r237 =
        Pattern.addOrReplaceChild(
            "cube_r237",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -6.85F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r238 =
        Pattern.addOrReplaceChild(
            "cube_r238",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.6F, -0.6F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r239 =
        Pattern.addOrReplaceChild(
            "cube_r239",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.6F, -0.6F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r240 =
        Pattern.addOrReplaceChild(
            "cube_r240",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 5.825F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 0.375F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.725F, -6.95F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r241 =
        Pattern.addOrReplaceChild(
            "cube_r241",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 5.825F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 0.375F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.925F, -6.95F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r242 =
        Pattern.addOrReplaceChild(
            "cube_r242",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.825F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.375F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.725F, -10.6F, -0.5F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r243 =
        Pattern.addOrReplaceChild(
            "cube_r243",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.925F, -10.6F, -0.5F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r244 =
        Pattern.addOrReplaceChild(
            "cube_r244",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.8F, -7.125F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r245 =
        Pattern.addOrReplaceChild(
            "cube_r245",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.0F, -7.125F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r246 =
        Pattern.addOrReplaceChild(
            "cube_r246",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.8F, -10.6F, -0.325F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r247 =
        Pattern.addOrReplaceChild(
            "cube_r247",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.0F, -10.6F, -0.325F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r248 =
        Pattern.addOrReplaceChild(
            "cube_r248",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.5F, -0.4F, 5.825F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.5F, -0.4F, 0.375F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.8F, -7.3F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r249 =
        Pattern.addOrReplaceChild(
            "cube_r249",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.825F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.375F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.0F, -7.3F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r250 =
        Pattern.addOrReplaceChild(
            "cube_r250",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.5F, 5.825F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.5F, 0.375F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.8F, -10.6F, -0.15F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r251 =
        Pattern.addOrReplaceChild(
            "cube_r251",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.0F, -10.6F, -0.15F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r252 =
        Pattern.addOrReplaceChild(
            "cube_r252",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, -0.4F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -7.375F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r253 =
        Pattern.addOrReplaceChild(
            "cube_r253",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, -0.4F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -7.375F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r254 =
        Pattern.addOrReplaceChild(
            "cube_r254",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.6F, 5.825F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.6F, 0.375F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.6F, -0.075F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r255 =
        Pattern.addOrReplaceChild(
            "cube_r255",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.475F, 5.825F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.475F, 0.375F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.6F, -0.075F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r256 =
        Pattern.addOrReplaceChild(
            "cube_r256",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -7.7F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r257 =
        Pattern.addOrReplaceChild(
            "cube_r257",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -7.7F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r258 =
        Pattern.addOrReplaceChild(
            "cube_r258",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.675F, -10.6F, 0.25F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r259 =
        Pattern.addOrReplaceChild(
            "cube_r259",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.875F, -10.6F, 0.25F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r260 =
        Pattern.addOrReplaceChild(
            "cube_r260",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, -0.375F, 5.825F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, -0.375F, 0.375F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.8F, -7.7F, -3.15F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r261 =
        Pattern.addOrReplaceChild(
            "cube_r261",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, -0.375F, 5.825F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, -0.375F, 0.375F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.0F, -7.7F, -3.15F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r262 =
        Pattern.addOrReplaceChild(
            "cube_r262",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.525F, 5.825F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.525F, 0.375F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.8F, -10.6F, 0.25F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r263 =
        Pattern.addOrReplaceChild(
            "cube_r263",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, 5.825F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, 0.375F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.0F, -10.6F, 0.25F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r264 =
        Pattern.addOrReplaceChild(
            "cube_r264",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, -0.425F, 5.775F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, -0.425F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -7.725F, -3.1F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r265 =
        Pattern.addOrReplaceChild(
            "cube_r265",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.55F, -0.425F, 5.775F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.55F, -0.425F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -7.725F, -3.1F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r266 =
        Pattern.addOrReplaceChild(
            "cube_r266",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, 5.775F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, 0.325F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.55F, 0.275F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r267 =
        Pattern.addOrReplaceChild(
            "cube_r267",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.55F, 5.775F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.55F, 0.325F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.55F, 0.275F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r268 =
        Pattern.addOrReplaceChild(
            "cube_r268",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, -0.425F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, -0.425F, 0.35F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -7.875F, -3.125F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r269 =
        Pattern.addOrReplaceChild(
            "cube_r269",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, -0.425F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, -0.425F, 0.35F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -7.875F, -3.125F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r270 =
        Pattern.addOrReplaceChild(
            "cube_r270",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.575F, 5.8F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.575F, 0.35F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.825F, -10.575F, 0.425F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r271 =
        Pattern.addOrReplaceChild(
            "cube_r271",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.45F, 5.8F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.45F, 0.35F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.025F, -10.575F, 0.425F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r272 =
        Pattern.addOrReplaceChild(
            "cube_r272",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, -0.425F, 5.8F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, -0.425F, -0.025F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -7.625F, -2.925F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r273 =
        Pattern.addOrReplaceChild(
            "cube_r273",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, 5.8F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, -0.425F, -0.025F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -7.625F, -2.925F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r274 =
        Pattern.addOrReplaceChild(
            "cube_r274",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, 5.8F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, -0.025F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.25F, -10.375F, 0.175F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r275 =
        Pattern.addOrReplaceChild(
            "cube_r275",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.5F, 5.8F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.5F, -0.025F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, -10.375F, 0.175F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r276 =
        Pattern.addOrReplaceChild(
            "cube_r276",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, -0.425F, 5.8F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(
                    -1.65F, -0.425F, -0.025F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.15F, -7.7F, -2.925F, 0.0F, 0.0F, 0.7854F));

    PartDefinition cube_r277 =
        Pattern.addOrReplaceChild(
            "cube_r277",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, -0.425F, 5.8F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(
                    1.525F, -0.425F, -0.025F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.35F, -7.7F, -2.925F, 0.0F, 0.0F, -0.7854F));

    PartDefinition cube_r278 =
        Pattern.addOrReplaceChild(
            "cube_r278",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.65F, 5.8F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.65F, -0.025F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.15F, -10.375F, 0.25F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r279 =
        Pattern.addOrReplaceChild(
            "cube_r279",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(1.525F, 5.8F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.525F, -0.025F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.35F, -10.375F, 0.25F, 0.0F, -0.7854F, 0.0F));

    PartDefinition Darkpart2 =
        Sidepart.addOrReplaceChild(
            "Darkpart2",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(2.375F, -10.375F, 2.2F, 0.5F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.075F, -10.375F, 2.2F, 0.5F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.375F, -9.475F, 6.9F, 0.5F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.075F, -9.475F, 6.9F, 0.5F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.375F, -9.475F, 1.3F, 0.5F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.075F, -9.475F, 1.3F, 0.5F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.375F, -4.775F, 2.2F, 0.5F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.075F, -4.775F, 2.2F, 0.5F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.075F, -10.3F, 2.2F, 0.3F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.575F, -10.3F, 2.2F, 0.3F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.075F, -9.475F, 6.825F, 0.3F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.575F, -9.475F, 6.825F, 0.3F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.075F, -9.475F, 1.375F, 0.3F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.575F, -9.475F, 1.375F, 0.3F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(2.075F, -4.85F, 2.2F, 0.3F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.575F, -4.85F, 2.2F, 0.3F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.675F, -10.2F, 2.2F, 0.4F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.875F, -10.2F, 2.2F, 0.4F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.675F, -9.475F, 6.725F, 0.4F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.875F, -9.475F, 6.725F, 0.4F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.675F, -9.475F, 1.475F, 0.4F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.875F, -9.475F, 1.475F, 0.4F, 3.9F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(1.675F, -4.95F, 2.2F, 0.4F, 0.1F, 3.9F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(9.875F, -4.95F, 2.2F, 0.4F, 0.1F, 3.9F, new CubeDeformation(0.0F)),
            PartPose.offset(-6.675F, 5.475F, -4.9F));

    PartDefinition Impactpart =
        Sidepart.addOrReplaceChild(
            "Impactpart",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-5.2F, -4.5F, -2.8F, 0.1F, 4.9F, 4.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.55F, -4.5F, -2.8F, 0.1F, 4.9F, 4.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.7F, -4.5F, -2.8F, 0.1F, 4.9F, 4.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-5.2F, -4.1F, -3.2F, 0.1F, 4.1F, 4.95F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.55F, -4.1F, -3.2F, 0.1F, 4.1F, 4.95F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(3.7F, -4.6F, -3.7F, 0.1F, 5.1F, 5.95F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.0F));

    PartDefinition cube_r280 =
        Impactpart.addOrReplaceChild(
            "cube_r280",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, 1.225F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, 1.225F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, -3.325F, -3.1F, -0.3927F, 0.0F, 0.0F));

    PartDefinition cube_r281 =
        Impactpart.addOrReplaceChild(
            "cube_r281",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, -1.525F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, -1.525F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, -0.775F, -3.1F, 0.3927F, 0.0F, 0.0F));

    PartDefinition cube_r282 =
        Impactpart.addOrReplaceChild(
            "cube_r282",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, 1.225F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, 1.225F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, -3.325F, 1.65F, 0.3927F, 0.0F, 0.0F));

    PartDefinition cube_r283 =
        Impactpart.addOrReplaceChild(
            "cube_r283",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, -1.525F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, -1.525F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, -0.775F, 1.65F, -0.3927F, 0.0F, 0.0F));

    PartDefinition cube_r284 =
        Impactpart.addOrReplaceChild(
            "cube_r284",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, 5.4F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, 5.4F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, -5.5F, 0.55F, 0.3927F, 0.0F, 0.0F));

    PartDefinition cube_r285 =
        Impactpart.addOrReplaceChild(
            "cube_r285",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, -5.75F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, -5.75F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, 1.4F, 0.55F, -0.3927F, 0.0F, 0.0F));

    PartDefinition cube_r286 =
        Impactpart.addOrReplaceChild(
            "cube_r286",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, 5.4F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, 5.4F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, -5.5F, -2.0F, -0.3927F, 0.0F, 0.0F));

    PartDefinition cube_r287 =
        Impactpart.addOrReplaceChild(
            "cube_r287",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.6F, -5.75F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-9.5F, -5.75F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, 1.4F, -2.0F, 0.3927F, 0.0F, 0.0F));

    PartDefinition handle =
        partdefinition.addOrReplaceChild(
            "handle",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.3F, 0.75F, -1.2F, 0.1F, 0.7F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 0.75F, -1.5F, 1.0F, 1.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 0.75F, -1.2F, 0.1F, 0.7F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 0.75F, 0.0F, 1.0F, 1.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 1.95F, -1.5F, 0.8F, 0.1F, 1.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 2.05F, -1.5F, 0.6F, 0.1F, 1.6F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 1.75F, -1.2F, 0.1F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 2.25F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 2.25F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 2.35F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 2.35F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 2.45F, 0.0F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 1.65F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 2.25F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 2.35F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 2.45F, -1.5F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 2.35F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 2.25F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 3.55F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 3.65F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 3.75F, 0.0F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 3.55F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 3.65F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 2.95F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 3.55F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 3.65F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 3.55F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 3.65F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 3.75F, -1.5F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 2.95F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 4.85F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 4.95F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 5.05F, 0.0F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 4.85F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 4.95F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 4.25F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 4.85F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 4.95F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 4.85F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 4.95F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 5.05F, -1.5F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 4.25F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 6.15F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 6.25F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 6.35F, 0.0F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 6.15F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 6.25F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 5.55F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 6.15F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 6.25F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 6.15F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 6.25F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 6.35F, -1.5F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 5.55F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 7.45F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 7.55F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 7.65F, 0.0F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 7.45F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 7.55F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 6.85F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 7.45F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 7.55F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 7.45F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 7.55F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 7.65F, -1.5F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 6.85F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 8.75F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 8.85F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 8.95F, 0.0F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 8.75F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 8.85F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 8.15F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 8.75F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 8.85F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 8.75F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 8.85F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 8.95F, -1.5F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 8.15F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 10.05F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 10.15F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 10.25F, 0.0F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 10.05F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 10.15F, 0.0F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 9.45F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 10.05F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 10.15F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 10.05F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 10.15F, -1.5F, 0.1F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 10.25F, -1.5F, 0.6F, 1.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 9.45F, -1.2F, 0.1F, 1.1F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 11.35F, 0.0F, 0.1F, 0.8F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 11.45F, 0.0F, 0.1F, 0.7F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 11.55F, 0.0F, 0.6F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 11.35F, 0.0F, 0.1F, 0.8F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 11.45F, 0.0F, 0.1F, 0.7F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.3F, 10.75F, -1.2F, 0.1F, 1.4F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 11.35F, -1.5F, 0.1F, 0.8F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.9F, 11.45F, -1.5F, 0.1F, 0.7F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.1F, 11.35F, -1.5F, 0.1F, 0.8F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.2F, 11.45F, -1.5F, 0.1F, 0.7F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.8F, 11.55F, -1.5F, 0.6F, 0.6F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.2F, 10.75F, -1.2F, 0.1F, 1.4F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 12.15F, 0.1F, 1.0F, 1.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 12.15F, -1.6F, 1.0F, 1.4F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, 12.15F, -1.2F, 1.6F, 1.4F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.4F, 12.15F, -1.2F, 0.175F, 1.4F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.0F, 13.45F, -1.5F, 1.0F, 0.1F, 1.6F, new CubeDeformation(0.0F)),
            PartPose.offset(-8.0F, 16.0F, 8.0F));

    PartDefinition cube_r288 =
        handle.addOrReplaceChild(
            "cube_r288",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.95F, 16.9F, -0.1F, 1.3F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.075F, -4.75F, -0.375F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r289 =
        handle.addOrReplaceChild(
            "cube_r289",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.35F, 16.9F, -0.1F, 1.375F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.075F, -4.75F, -0.375F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r290 =
        handle.addOrReplaceChild(
            "cube_r290",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.575F, 16.9F, -0.45F, 0.925F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.075F, -4.75F, -1.025F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r291 =
        handle.addOrReplaceChild(
            "cube_r291",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.35F, 16.9F, -0.45F, 0.8F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.075F, -4.75F, -1.025F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r292 =
        handle.addOrReplaceChild(
            "cube_r292",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.075F, 7.0F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.7F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 3.1F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.5F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 4.4F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.8F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -0.8F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.6F, -0.075F, 0.225F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.1F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 6.8F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.5F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 2.9F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.3F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 4.2F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.6F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -1.0F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.6F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.3F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 6.6F, 0.125F, 0.1F, 1.4F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.3F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 2.7F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.1F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 4.0F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.4F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -1.2F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.8F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.5F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 6.5F, 0.275F, 0.1F, 1.4F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.2F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 2.6F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.0F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 3.9F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.3F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -1.3F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.9F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.6F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.0F, 4.35F, -1.4F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r293 =
        handle.addOrReplaceChild(
            "cube_r293",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.15F, 7.0F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 5.7F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 3.1F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 0.5F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 4.4F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 1.8F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -0.8F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -3.6F, -0.075F, 0.225F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -2.1F, -0.075F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 6.8F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 5.5F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 2.9F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 0.3F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 4.2F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 1.6F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -1.0F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -3.6F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -2.3F, 0.0F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 6.6F, 0.125F, 0.1F, 1.4F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 5.3F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 2.7F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 0.1F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 4.0F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 1.4F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -1.2F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -3.8F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -2.5F, 0.125F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 6.5F, 0.275F, 0.1F, 1.4F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 5.2F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 2.6F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 0.0F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 3.9F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 1.3F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -1.3F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -3.9F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -2.6F, 0.275F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 4.35F, -1.4F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r294 =
        handle.addOrReplaceChild(
            "cube_r294",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.075F, 7.0F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.7F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 3.1F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.5F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 4.4F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.8F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -0.8F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.6F, 0.0F, 0.225F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.1F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 6.8F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.5F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 2.9F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.3F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 4.2F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.6F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -1.0F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.6F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.3F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 6.6F, -0.275F, 0.1F, 1.4F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.3F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 2.7F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.1F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 4.0F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.4F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -1.2F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.8F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.5F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 6.5F, -0.35F, 0.1F, 1.4F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 5.2F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 2.6F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 0.0F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 3.9F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, 1.3F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -1.3F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -3.9F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.075F, -2.6F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.0F, 4.35F, 0.0F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r295 =
        handle.addOrReplaceChild(
            "cube_r295",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.15F, 7.0F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 5.7F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 3.1F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 0.5F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 4.4F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 1.8F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -0.8F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -3.6F, 0.0F, 0.225F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -2.1F, 0.0F, 0.225F, 0.8F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 6.8F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 5.5F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 2.9F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 0.3F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 4.2F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, 1.6F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -1.0F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -3.6F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.15F, -2.3F, -0.125F, 0.225F, 1.0F, 0.125F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 6.6F, -0.275F, 0.1F, 1.4F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 5.3F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 2.7F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 0.1F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 4.0F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 1.4F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -1.2F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -3.8F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -2.5F, -0.275F, 0.1F, 1.0F, 0.15F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 6.5F, -0.35F, 0.1F, 1.4F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 5.2F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 2.6F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 0.0F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 3.9F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, 1.3F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -1.3F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -3.9F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.025F, -2.6F, -0.35F, 0.1F, 1.0F, 0.075F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 4.35F, 0.0F, 0.0F, -0.7854F, 0.0F));

    PartDefinition graypart3 =
        handle.addOrReplaceChild(
            "graypart3",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-1.0F, 0.75F, -1.4F, 1.0F, 11.4F, 1.4F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.2F, 0.75F, -1.2F, 0.1F, 11.4F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.1F, 0.75F, -1.2F, 0.1F, 11.4F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.0F));

    PartDefinition cube_r296 =
        graypart3.addOrReplaceChild(
            "cube_r296",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.1F, 5.5F, 0.0F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.75F, -1.4F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r297 =
        graypart3.addOrReplaceChild(
            "cube_r297",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(0.0F, 5.5F, 0.0F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.0F, -4.75F, -1.4F, 0.0F, -0.7854F, 0.0F));

    PartDefinition cube_r298 =
        graypart3.addOrReplaceChild(
            "cube_r298",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(0.0F, 5.5F, -0.275F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.0F, -4.75F, 0.0F, 0.0F, 0.7854F, 0.0F));

    PartDefinition cube_r299 =
        graypart3.addOrReplaceChild(
            "cube_r299",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-0.1F, 5.5F, -0.275F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.75F, 0.0F, 0.0F, -0.7854F, 0.0F));

    return LayerDefinition.create(meshdefinition, 128, 128);
  }

  @Override
  public void setupAnim(
          @NotNull T entity,
          float limbSwing,
          float limbSwingAmount,
          float ageInTicks,
          float netHeadYaw,
          float headPitch) {}

  @Override
  public void renderToBuffer(
          @NotNull PoseStack poseStack,
          @NotNull VertexConsumer vertexConsumer,
          int packedLight,
          int packedOverlay,
          float red,
          float green,
          float blue,
          float alpha) {
    Themiddlepart.render(
        poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    Sidepart.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    handle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
  }
}
