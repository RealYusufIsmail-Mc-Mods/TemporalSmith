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
package io.github.realyusufismail.temporalsmith.entities.mjolnir;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TheSidePart {
  private final PartDefinition theSidePart;

  public TheSidePart(PartDefinition theSidePart) {
    this.theSidePart = theSidePart;
  }

  protected void createBodyLayer() {

    PartDefinition graypart2 =
        theSidePart.addOrReplaceChild(
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

    graypart2.addOrReplaceChild(
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

    graypart2.addOrReplaceChild(
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

    graypart2.addOrReplaceChild(
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

    graypart2.addOrReplaceChild(
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

    PartDefinition Pattern = new Pattern().creatBodyLayer(theSidePart);

    Pattern.addOrReplaceChild(
        "cube_r24",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.425F, 5.8F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.425F, 0.0F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.1F, -7.9F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r25",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, -0.425F, 5.8F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, -0.425F, 0.0F, 0.1F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.3F, -7.9F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r26",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.8F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.0F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.1F, -10.4F, 0.45F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r27",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, 5.8F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, 0.0F, 0.275F, 0.1F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.3F, -10.4F, 0.45F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r28",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, -0.4F, 5.8F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, -0.4F, -0.025F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.15F, -7.4F, -2.925F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r29",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, 5.8F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, -0.025F, 0.1F, 0.05F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.35F, -7.4F, -2.925F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r30",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, 5.8F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, -0.025F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.15F, -10.375F, -0.05F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r31",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, 5.8F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.025F, 0.35F, 0.1F, 0.075F, 0.05F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.35F, -10.375F, -0.05F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r32",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, -0.4F, 5.8F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, -0.4F, 0.0F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -5.225F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r33",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, 5.8F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, 0.0F, 0.1F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -5.225F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r34",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, 5.8F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, 0.0F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -10.4F, -2.225F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r35",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, 5.8F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, 0.0F, 0.35F, 0.1F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -10.4F, -2.225F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r36",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.225F, -5.05F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r37",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.425F, -5.05F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r38",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.225F, -10.4F, -2.4F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r39",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.425F, -10.4F, -2.4F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r40",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.35F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.35F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.225F, -7.25F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r41",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.35F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.35F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.425F, -7.25F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r42",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.225F, -10.4F, -0.2F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r43",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, -0.425F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.425F, -10.4F, -0.2F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r44",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -7.15F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r45",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -7.15F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r46",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -10.4F, -0.3F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r47",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -10.4F, -0.3F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r48",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -7.45F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r49",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -7.45F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r50",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -10.4F, 0.0F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r51",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -10.4F, 0.0F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r52",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -4.35F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r53",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -4.35F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r54",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -10.4F, -3.1F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r55",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -10.4F, -3.1F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r56",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -4.55F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r57",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -4.55F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r58",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -10.4F, -2.9F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r59",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -10.4F, -2.9F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r60",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -4.75F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r61",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -4.75F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r62",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -10.4F, -2.7F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r63",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -10.4F, -2.7F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r64",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -4.85F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r65",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.0F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -4.85F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r66",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -10.4F, -2.6F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r67",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -10.4F, -2.6F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r68",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.1F, -5.125F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r69",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 0.0F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.3F, -5.125F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r70",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.1F, -10.4F, -2.325F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r71",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.3F, -10.4F, -2.325F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r72",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, -0.375F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, -0.375F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.3F, -5.15F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r73",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.575F, -0.375F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.575F, -0.375F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.5F, -5.15F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r74",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, 5.8F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, 0.0F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.3F, -10.4F, -2.3F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r75",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.575F, 5.8F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.575F, 0.0F, 0.275F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.5F, -10.4F, -2.3F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r76",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, -0.4F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.4F, 0.0F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.275F, -5.35F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r77",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.55F, -0.4F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.55F, -0.4F, 0.0F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.475F, -5.35F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r78",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, 5.8F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, 0.0F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.275F, -10.4F, -2.1F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r79",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.55F, 5.8F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.55F, 0.0F, 0.275F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.475F, -10.4F, -2.1F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r80",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 0.0F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -5.325F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r81",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 0.0F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -5.325F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r82",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.0F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -10.4F, -2.125F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r83",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -10.4F, -2.125F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r84",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, -0.425F, 5.8F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.425F, 0.0F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -5.825F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r85",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, 5.8F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, 0.0F, 0.15F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -5.825F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r86",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, 5.8F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, 0.0F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -10.4F, -1.625F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r87",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, 5.8F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, 0.0F, 0.3F, 0.15F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -10.4F, -1.625F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r88",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, -0.4F, 5.8F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.4F, 0.0F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -6.825F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r89",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, -0.4F, 5.8F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, -0.4F, 0.0F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -6.825F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r90",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, 5.8F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, 0.0F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -10.4F, -0.625F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r91",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, 5.8F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, 0.0F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -10.4F, -0.625F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r92",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, -0.425F, 5.8F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, -0.425F, 0.0F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.2F, -6.975F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r93",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 5.8F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 0.0F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.4F, -6.975F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r94",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 5.8F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.0F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.2F, -10.4F, -0.475F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r95",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.4F, -10.4F, -0.475F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r96",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, -0.4F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, -0.4F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.1F, -7.7F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r97",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.0F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.3F, -7.7F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r98",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 5.8F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.0F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.1F, -10.4F, 0.25F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r99",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.3F, -10.4F, 0.25F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r100",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -8.425F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r101",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -8.425F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r102",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -10.5F, 0.975F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r103",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -10.5F, 0.975F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r104",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -4.35F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r105",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -4.35F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r106",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -10.5F, -3.1F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r107",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -10.5F, -3.1F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r108",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -4.575F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r109",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -4.575F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r110",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -10.5F, -2.875F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r111",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -10.5F, -2.875F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r112",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.325F, 5.8F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.325F, 0.2F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.525F, -7.025F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r113",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, 0.325F, 5.8F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, 0.325F, 0.2F, 0.15F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.725F, -7.025F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r114",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.525F, -10.5F, -0.425F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r115",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, 5.8F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, 0.2F, -0.4F, 0.15F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.725F, -10.5F, -0.425F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r116",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -7.25F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r117",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -7.25F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r118",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -10.5F, -0.2F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r119",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -10.5F, -0.2F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r120",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 0.2F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -4.85F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r121",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 5.8F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 0.2F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -4.85F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r122",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -10.5F, -2.6F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r123",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -10.5F, -2.6F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r124",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.375F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.375F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.525F, -5.05F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r125",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.375F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.375F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.725F, -5.05F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r126",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.525F, -10.5F, -2.4F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r127",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.725F, -10.5F, -2.4F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r128",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.375F, 5.8F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.375F, 0.2F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.45F, -5.35F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r129",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, -0.375F, 5.8F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.375F, 0.2F, 0.075F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.65F, -5.35F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r130",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.45F, -10.5F, -2.1F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r131",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, 5.8F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, 0.2F, 0.3F, 0.075F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.65F, -10.5F, -2.1F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r132",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -8.15F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r133",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -8.15F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r134",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -10.5F, 0.7F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r135",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.4F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -10.5F, 0.7F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r136",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 0.25F, 5.8F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.25F, 0.2F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -8.525F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r137",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.25F, 5.8F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.25F, 0.2F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -8.525F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r138",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.8F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.2F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -10.5F, 1.075F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r139",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.4F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -10.5F, 1.075F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r140",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -8.85F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r141",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -8.85F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r142",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.425F, -10.5F, 1.4F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r143",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.625F, -10.5F, 1.4F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r144",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.45F, -9.525F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r145",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.65F, -9.525F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r146",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.45F, -10.5F, 2.075F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r147",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.65F, -10.5F, 2.075F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r148",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.525F, -9.85F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r149",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.725F, -9.85F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r150",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.525F, -10.5F, 2.4F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r151",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.725F, -10.5F, 2.4F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r152",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.475F, -10.0F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r153",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 5.8F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.3F, 0.2F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.675F, -10.0F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r154",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.475F, -10.5F, 2.55F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r155",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.375F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.675F, -10.5F, 2.55F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r156",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, 0.275F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, 0.275F, 0.2F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -10.525F, -3.05F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r157",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 5.8F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 0.2F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -10.525F, -3.05F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r158",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, 5.8F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, 0.2F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.55F, -10.5F, 3.075F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r159",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.2F, -0.4F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.75F, -10.5F, 3.075F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r160",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.575F, 5.8F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.575F, 0.0F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -7.35F, -2.95F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r161",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.575F, 5.8F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.575F, 0.0F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -7.35F, -2.95F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r162",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.8F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.0F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.125F, -10.4F, -0.1F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r163",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.8F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.0F, 0.45F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.325F, -10.4F, -0.1F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r164",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, -0.4F, 5.825F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.4F, 0.375F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.875F, -6.25F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r165",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, -0.4F, 5.825F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, -0.4F, 0.375F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.075F, -6.25F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r166",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, 5.825F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, 0.375F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.875F, -10.6F, -1.2F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r167",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, 5.825F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, 0.375F, 0.3F, 0.15F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.075F, -10.6F, -1.2F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r168",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -4.35F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r169",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -4.35F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r170",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.6F, -3.1F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r171",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.6F, -3.1F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r172",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.425F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.425F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -4.55F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r173",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -4.55F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r174",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.6F, -2.9F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r175",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, 5.825F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, 0.375F, 0.3F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.6F, -2.9F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r176",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, -0.45F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, -0.45F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -4.775F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r177",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -4.775F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r178",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 5.825F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.375F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -10.6F, -2.675F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r179",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.325F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -10.6F, -2.675F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r180",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.5F, -0.45F, 5.825F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.5F, -0.45F, 0.375F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.775F, -4.875F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r181",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 5.825F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 0.375F, 0.025F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.975F, -4.875F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r182",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.5F, 5.825F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.5F, 0.375F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.775F, -10.6F, -2.575F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r183",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.325F, 0.025F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.975F, -10.6F, -2.575F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r184",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.85F, -7.425F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r185",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.05F, -7.425F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r186",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.85F, -10.6F, -0.025F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r187",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.05F, -10.6F, -0.025F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r188",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -7.6F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r189",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -7.6F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r190",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.6F, 0.15F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r191",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.6F, 0.15F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r192",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.85F, -7.125F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r193",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.05F, -7.125F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r194",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.85F, -10.6F, -0.325F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r195",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, -0.4F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.05F, -10.6F, -0.325F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r196",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.7F, -7.5F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r197",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 5.825F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.275F, 0.375F, 0.05F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.9F, -7.5F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r198",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.7F, -10.6F, 0.05F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r199",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, -0.4F, 0.05F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.9F, -10.6F, 0.05F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r200",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -4.975F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r201",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -4.975F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r202",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -10.6F, -2.475F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r203",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -10.6F, -2.475F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r204",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 5.825F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 0.375F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.775F, -5.075F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r205",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, -0.45F, 5.825F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, -0.45F, 0.375F, 0.1F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.975F, -5.075F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r206",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.775F, -10.6F, -2.375F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r207",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, 5.825F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, 0.375F, 0.325F, 0.1F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.975F, -10.6F, -2.375F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r208",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -5.275F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r209",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -5.275F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r210",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -10.6F, -2.175F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r211",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.325F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -10.6F, -2.175F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r212",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -5.35F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r213",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 5.825F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.45F, 0.375F, 0.075F, 0.15F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -5.35F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r214",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.55F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.55F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.6F, -2.1F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r215",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.3F, 0.075F, 0.1F, 0.15F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.6F, -2.1F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r216",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.375F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.375F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.725F, -5.55F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r217",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.375F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.375F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.925F, -5.55F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r218",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.825F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.375F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.725F, -10.6F, -1.9F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r219",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.3F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.925F, -10.6F, -1.9F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r220",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, -0.4F, 5.825F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, -0.4F, 0.375F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.875F, -5.775F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r221",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.55F, -0.4F, 5.825F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.55F, -0.4F, 0.375F, 0.075F, 0.175F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.075F, -5.775F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r222",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.625F, 5.825F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.625F, 0.375F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.875F, -10.6F, -1.675F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r223",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.55F, 5.825F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.55F, 0.375F, 0.225F, 0.075F, 0.1F, 0.175F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.075F, -10.6F, -1.675F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r224",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.825F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.375F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.75F, -6.25F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r225",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, 5.825F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, 0.375F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.95F, -6.25F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r226",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.825F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.375F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.75F, -10.6F, -1.2F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r227",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, 5.825F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, 0.375F, 0.3F, 0.075F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.95F, -10.6F, -1.2F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r228",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, -0.4F, 5.825F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, -0.4F, 0.375F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.75F, -6.45F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r229",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, 5.825F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.4F, 0.375F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.95F, -6.45F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r230",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, 5.825F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, 0.375F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.75F, -10.6F, -1.0F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r231",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, 5.825F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, 0.375F, 0.3F, 0.05F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.95F, -10.6F, -1.0F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r232",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.725F, -6.675F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r233",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.925F, -6.675F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r234",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.725F, -10.6F, -0.775F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r235",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.925F, -10.6F, -0.775F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r236",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -6.85F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r237",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -6.85F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r238",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.6F, -0.6F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r239",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.6F, -0.6F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r240",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 5.825F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 0.375F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.725F, -6.95F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r241",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 5.825F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 0.375F, 0.125F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.925F, -6.95F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r242",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.825F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.375F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.725F, -10.6F, -0.5F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r243",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.3F, 0.125F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.925F, -10.6F, -0.5F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r244",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.8F, -7.125F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r245",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.425F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.0F, -7.125F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r246",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.8F, -10.6F, -0.325F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r247",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.35F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.0F, -10.6F, -0.325F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r248",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.5F, -0.4F, 5.825F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.5F, -0.4F, 0.375F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.8F, -7.3F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r249",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.825F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.375F, 0.025F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.0F, -7.3F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r250",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.5F, 5.825F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.5F, 0.375F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.8F, -10.6F, -0.15F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r251",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.325F, 0.025F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.0F, -10.6F, -0.15F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r252",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, -0.4F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -7.375F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r253",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 5.825F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, -0.4F, 0.375F, 0.125F, 0.075F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -7.375F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r254",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.6F, 5.825F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6F, 0.375F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.6F, -0.075F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r255",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, 5.825F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.475F, 0.375F, 0.325F, 0.125F, 0.1F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.6F, -0.075F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r256",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -7.7F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r257",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, -0.425F, 5.825F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, -0.425F, 0.375F, 0.075F, 0.125F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -7.7F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r258",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.675F, -10.6F, 0.25F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r259",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, 5.825F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, 0.375F, 0.3F, 0.075F, 0.1F, 0.125F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.875F, -10.6F, 0.25F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r260",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, -0.375F, 5.825F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, -0.375F, 0.375F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.8F, -7.7F, -3.15F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r261",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, -0.375F, 5.825F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, -0.375F, 0.375F, 0.075F, 0.05F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.0F, -7.7F, -3.15F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r262",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.525F, 5.825F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.525F, 0.375F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.8F, -10.6F, 0.25F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r263",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, 5.825F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, 0.375F, 0.325F, 0.075F, 0.1F, 0.05F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.0F, -10.6F, 0.25F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r264",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, -0.425F, 5.775F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, -0.425F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -7.725F, -3.1F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r265",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.55F, -0.425F, 5.775F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.55F, -0.425F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -7.725F, -3.1F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r266",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, 5.775F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, 0.325F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.55F, 0.275F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r267",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.55F, 5.775F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.55F, 0.325F, 0.325F, 0.025F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.55F, 0.275F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r268",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, -0.425F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, -0.425F, 0.35F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -7.875F, -3.125F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r269",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, -0.425F, 5.8F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, -0.425F, 0.35F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -7.875F, -3.125F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r270",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.575F, 5.8F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.575F, 0.35F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.825F, -10.575F, 0.425F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r271",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.45F, 5.8F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.45F, 0.35F, 0.325F, 0.125F, 0.1F, 0.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-2.025F, -10.575F, 0.425F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r272",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, -0.425F, 5.8F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.425F, -0.025F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -7.625F, -2.925F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r273",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, 5.8F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, -0.425F, -0.025F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -7.625F, -2.925F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r274",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, 5.8F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.025F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.25F, -10.375F, 0.175F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r275",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.5F, 5.8F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.5F, -0.025F, 0.35F, 0.15F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -10.375F, 0.175F, 0.0F, -0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r276",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, -0.425F, 5.8F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.425F, -0.025F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.15F, -7.7F, -2.925F, 0.0F, 0.0F, 0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r277",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, -0.425F, 5.8F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.425F, -0.025F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.35F, -7.7F, -2.925F, 0.0F, 0.0F, -0.7854F));

    Pattern.addOrReplaceChild(
        "cube_r278",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.65F, 5.8F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.65F, -0.025F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(7.15F, -10.375F, 0.25F, 0.0F, 0.7854F, 0.0F));

    Pattern.addOrReplaceChild(
        "cube_r279",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.525F, 5.8F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(1.525F, -0.025F, 0.35F, 0.125F, 0.075F, 0.075F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.35F, -10.375F, 0.25F, 0.0F, -0.7854F, 0.0F));

    theSidePart.addOrReplaceChild(
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
        theSidePart.addOrReplaceChild(
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

    Impactpart.addOrReplaceChild(
        "cube_r280",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, 1.225F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, 1.225F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, -3.325F, -3.1F, -0.3927F, 0.0F, 0.0F));

    Impactpart.addOrReplaceChild(
        "cube_r281",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, -1.525F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, -1.525F, 5.35F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, -0.775F, -3.1F, 0.3927F, 0.0F, 0.0F));

    Impactpart.addOrReplaceChild(
        "cube_r282",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, 1.225F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, 1.225F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, -3.325F, 1.65F, 0.3927F, 0.0F, 0.0F));

    Impactpart.addOrReplaceChild(
        "cube_r283",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, -1.525F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, -1.525F, -5.75F, 0.1F, 0.3F, 0.4F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, -0.775F, 1.65F, -0.3927F, 0.0F, 0.0F));

    Impactpart.addOrReplaceChild(
        "cube_r284",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, 5.4F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, 5.4F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, -5.5F, 0.55F, 0.3927F, 0.0F, 0.0F));

    Impactpart.addOrReplaceChild(
        "cube_r285",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, -5.75F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, -5.75F, -1.525F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, 1.4F, 0.55F, -0.3927F, 0.0F, 0.0F));

    Impactpart.addOrReplaceChild(
        "cube_r286",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, 5.4F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, 5.4F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, -5.5F, -2.0F, -0.3927F, 0.0F, 0.0F));

    Impactpart.addOrReplaceChild(
        "cube_r287",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.6F, -5.75F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-9.5F, -5.75F, 1.225F, 0.1F, 0.35F, 0.3F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(4.3F, 1.4F, -2.0F, 0.3927F, 0.0F, 0.0F));
  }
}
