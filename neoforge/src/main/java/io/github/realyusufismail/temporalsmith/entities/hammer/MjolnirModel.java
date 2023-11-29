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

  public static @NotNull LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition theMiddlePart =
        partdefinition.addOrReplaceChild(
            "Themiddlepart", CubeListBuilder.create(), PartPose.offset(-8.0F, 16.0F, 8.0F));

    new TheMiddlePart(theMiddlePart).createBodyLayer();

    PartDefinition Sidepart =
        partdefinition.addOrReplaceChild(
            "Sidepart", CubeListBuilder.create(), PartPose.offset(-8.0F, 16.0F, 8.0F));

    new TheSidePart(Sidepart).createBodyLayer();

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

    new TheHandle(handle).createBodyLayer();

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
