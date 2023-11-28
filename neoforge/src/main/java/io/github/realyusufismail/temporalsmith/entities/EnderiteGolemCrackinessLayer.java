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
package io.github.realyusufismail.temporalsmith.entities;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.realyusufismail.temporalsmith.TemporalSmith;
import java.util.Map;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.IronGolem;

public class EnderiteGolemCrackinessLayer
    extends RenderLayer<EnderiteGolem, EnderiteGolemModel<EnderiteGolem>> {
  private static final Map<IronGolem.Crackiness, ResourceLocation> resourceLocations =
      ImmutableMap.of(
          IronGolem.Crackiness.LOW,
          TemporalSmith.getModIdAndName(
              "textures/entity/enderite_golem/enderite_golem_crackiness_low.png"),
          IronGolem.Crackiness.MEDIUM,
          TemporalSmith.getModIdAndName(
              "textures/entity/enderite_golem/enderite_golem_crackiness_medium.png"),
          IronGolem.Crackiness.HIGH,
          TemporalSmith.getModIdAndName(
              "textures/entity/enderite_golem/enderite_golem_crackiness_high.png"));

  public EnderiteGolemCrackinessLayer(
      RenderLayerParent<EnderiteGolem, EnderiteGolemModel<EnderiteGolem>> p_117135_) {
    super(p_117135_);
  }

  @Override
  public void render(
      PoseStack p_117148_,
      MultiBufferSource p_117149_,
      int p_117150_,
      EnderiteGolem p_117151_,
      float p_117152_,
      float p_117153_,
      float p_117154_,
      float p_117155_,
      float p_117156_,
      float p_117157_) {
    if (!p_117151_.isInvisible()) {
      EnderiteGolem.Crackiness irongolem$crackiness = p_117151_.getCrackiness();
      if (irongolem$crackiness != EnderiteGolem.Crackiness.NONE) {
        ResourceLocation resourcelocation = resourceLocations.get(irongolem$crackiness);
        renderColoredCutoutModel(
            this.getParentModel(),
            resourcelocation,
            p_117148_,
            p_117149_,
            p_117150_,
            p_117151_,
            1.0F,
            1.0F,
            1.0F);
      }
    }
  }
}
