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
package io.github.realyusufismail.temporalsmith.entities.golum;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class EnderiteGolemFlowerLayer
    extends RenderLayer<EnderiteGolem, EnderiteGolemModel<EnderiteGolem>> {
  private final BlockRenderDispatcher blockRenderer;

  public EnderiteGolemFlowerLayer(
      RenderLayerParent<EnderiteGolem, EnderiteGolemModel<EnderiteGolem>> p_117346_,
      BlockRenderDispatcher p_234843_) {
    super(p_117346_);
    this.blockRenderer = p_234843_;
  }

  @Override
  public void render(
      @NotNull PoseStack poseStack,
      @NotNull MultiBufferSource multiBufferSource,
      int p_117351_,
      EnderiteGolem golem,
      float p_117353_,
      float p_117354_,
      float p_117355_,
      float p_117356_,
      float p_117357_,
      float p_117358_) {
    if (golem.getOfferFlowerTick() != 0) {
      poseStack.pushPose();
      ModelPart modelpart = this.getParentModel().getFlowerHoldingArm();
      modelpart.translateAndRotate(poseStack);
      poseStack.translate(-1.1875F, 1.0625F, -0.9375F);
      poseStack.translate(0.5F, 0.5F, 0.5F);
      float f = 0.5F;
      poseStack.scale(0.5F, 0.5F, 0.5F);
      poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
      poseStack.translate(-0.5F, -0.5F, -0.5F);
      this.blockRenderer.renderSingleBlock(
          Blocks.POPPY.defaultBlockState(),
          poseStack,
          multiBufferSource,
          p_117351_,
          OverlayTexture.NO_OVERLAY);
      poseStack.popPose();
    }
  }
}
