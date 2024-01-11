/*
 * Copyright 2024 RealYusufIsmail.
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

public class TheMiddlePart {
  private final PartDefinition Themiddlepart;

  public TheMiddlePart(PartDefinition partDefinition) {
    this.Themiddlepart = partDefinition;
  }

  protected void createBodyLayer() {

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

    Graypart.addOrReplaceChild(
        "cube_r1",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.7F, 0.275F, -0.25F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.7854F, 0.0F, 0.0F));

    Graypart.addOrReplaceChild(
        "cube_r2",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.7F, -0.6F, -0.25F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -9.4F, 0.0F, -0.7854F, 0.0F, 0.0F));

    Graypart.addOrReplaceChild(
        "cube_r3",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.7F, 0.275F, -1.025F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, -3.8F, -0.7854F, 0.0F, 0.0F));

    Graypart.addOrReplaceChild(
        "cube_r4",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.7F, -0.6F, -1.025F, 6.0F, 0.325F, 1.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -9.4F, -3.8F, 0.7854F, 0.0F, 0.0F));

    Graypart.addOrReplaceChild(
        "cube_r5",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(3.05F, 3.85F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -10.125F, -1.15F, 0.0F, 0.0F, 0.3927F));

    Graypart.addOrReplaceChild(
        "cube_r6",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.6F, 3.85F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.05F, -10.125F, -1.15F, 0.0F, 0.0F, -0.3927F));

    Graypart.addOrReplaceChild(
        "cube_r7",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(3.15F, 3.8F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.45F, -10.5F, -1.15F, 0.0F, 0.0F, 0.3927F));

    Graypart.addOrReplaceChild(
        "cube_r8",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.7F, 3.8F, -3.8F, 0.55F, 0.3F, 6.1F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.05F, -10.5F, -1.15F, 0.0F, 0.0F, -0.3927F));

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

    Ring.addOrReplaceChild(
        "cube_r9",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(0.4F, -0.8F, -2.975F, 0.7F, 0.2F, 1.675F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, -0.3927F, 0.0F));

    Ring.addOrReplaceChild(
        "cube_r10",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.125F, -0.8F, -3.175F, 0.825F, 0.2F, 1.75F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

    Ring.addOrReplaceChild(
        "cube_r11",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.475F, -0.8F, -0.575F, 1.725F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, 0.3927F, 0.0F));

    Ring.addOrReplaceChild(
        "cube_r12",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(1.55F, -0.8F, -0.125F, 1.65F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, -1.5F, 0.0F, -0.3927F, 0.0F));

    Ring.addOrReplaceChild(
        "cube_r13",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.125F, -0.8F, 1.625F, 0.825F, 0.2F, 1.55F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, -1.5F, 0.0F, 0.7854F, 0.0F));

    Ring.addOrReplaceChild(
        "cube_r14",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(0.4F, -0.8F, 1.225F, 0.7F, 0.2F, 1.75F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.5F, -1.5F, 0.0F, 0.3927F, 0.0F));

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

    Ring.addOrReplaceChild(
        "cube_r17",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.2F, -0.8F, -0.125F, 1.65F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(2.3F, -4.5F, -1.5F, 0.0F, 0.3927F, 0.0F));

    Ring.addOrReplaceChild(
        "cube_r18",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-3.2F, -0.8F, -0.575F, 1.725F, 0.2F, 0.7F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(2.3F, -4.5F, 0.0F, 0.0F, -0.3927F, 0.0F));

    Ring.addOrReplaceChild(
        "cube_r19",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.1F, -0.8F, -2.975F, 0.7F, 0.2F, 1.675F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(2.3F, -4.5F, 0.0F, 0.0F, 0.3927F, 0.0F));
  }
}
