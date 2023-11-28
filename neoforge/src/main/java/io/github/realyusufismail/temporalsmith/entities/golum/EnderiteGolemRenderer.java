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
package io.github.realyusufismail.temporalsmith.entities.golum;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.realyusufismail.temporalsmith.TemporalSmith;
import io.github.realyusufismail.temporalsmith.client.ClientEvents;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class EnderiteGolemRenderer
    extends MobRenderer<EnderiteGolem, EnderiteGolemModel<EnderiteGolem>> {
  private static final ResourceLocation ENDERITE_GOLEM_LOCATION =
      TemporalSmith.getModIdAndName("textures/entity/enderite_golem/enderite_golem.png");

  public EnderiteGolemRenderer(EntityRendererProvider.Context p_174188_) {
    super(
        p_174188_,
        new EnderiteGolemModel<>(
            p_174188_.bakeLayer(ClientEvents.INSTANCE.getEnderiteGolemLayer())),
        0.7F);
    this.addLayer(new EnderiteGolemCrackinessLayer(this));
    this.addLayer(new EnderiteGolemFlowerLayer(this, p_174188_.getBlockRenderDispatcher()));
  }

  @Override
  public @NotNull ResourceLocation getTextureLocation(EnderiteGolem p_115012_) {
    return ENDERITE_GOLEM_LOCATION;
  }

  @Override
  protected void setupRotations(
      EnderiteGolem p_115014_,
      PoseStack p_115015_,
      float p_115016_,
      float p_115017_,
      float p_115018_) {
    super.setupRotations(p_115014_, p_115015_, p_115016_, p_115017_, p_115018_);
    if (!((double) p_115014_.walkAnimation.speed() < 0.01)) {
      float f = 13.0F;
      float f1 = p_115014_.walkAnimation.position(p_115018_) + 6.0F;
      float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
      p_115015_.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
    }
  }
}
