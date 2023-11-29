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

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TheHandle {
  private PartDefinition handle;

  public TheHandle(PartDefinition handle) {
    this.handle = handle;
  }

  protected void createBodyLayer() {

    handle.addOrReplaceChild(
        "cube_r288",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.95F, 16.9F, -0.1F, 1.3F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.075F, -4.75F, -0.375F, 0.0F, -0.7854F, 0.0F));

    handle.addOrReplaceChild(
        "cube_r289",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.35F, 16.9F, -0.1F, 1.375F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.075F, -4.75F, -0.375F, 0.0F, 0.7854F, 0.0F));

    handle.addOrReplaceChild(
        "cube_r290",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.575F, 16.9F, -0.45F, 0.925F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.075F, -4.75F, -1.025F, 0.0F, 0.7854F, 0.0F));

    handle.addOrReplaceChild(
        "cube_r291",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.35F, 16.9F, -0.45F, 0.8F, 1.4F, 0.55F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.075F, -4.75F, -1.025F, 0.0F, -0.7854F, 0.0F));

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

    graypart3.addOrReplaceChild(
        "cube_r296",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.1F, 5.5F, 0.0F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.75F, -1.4F, 0.0F, 0.7854F, 0.0F));

    graypart3.addOrReplaceChild(
        "cube_r297",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(0.0F, 5.5F, 0.0F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.0F, -4.75F, -1.4F, 0.0F, -0.7854F, 0.0F));

    graypart3.addOrReplaceChild(
        "cube_r298",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(0.0F, 5.5F, -0.275F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(-1.0F, -4.75F, 0.0F, 0.0F, 0.7854F, 0.0F));

    graypart3.addOrReplaceChild(
        "cube_r299",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-0.1F, 5.5F, -0.275F, 0.1F, 11.4F, 0.275F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, -4.75F, 0.0F, 0.0F, -0.7854F, 0.0F));
  }
}
