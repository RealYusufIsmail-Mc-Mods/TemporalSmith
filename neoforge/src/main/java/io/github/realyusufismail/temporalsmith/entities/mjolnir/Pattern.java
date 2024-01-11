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

import io.github.realyusufismail.temporalsmith.entities.mjolnir.cube.*;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Pattern {

  protected PartDefinition creatBodyLayer(PartDefinition theSidePart) {
    CubeListBuilder cubeListBuilder = CubeListBuilder.create();

    cubeListBuilder = new PatternCubeOne(cubeListBuilder).build();
    cubeListBuilder = new PatternCubeTwo(cubeListBuilder).build();
    cubeListBuilder = new PatternCubeThree(cubeListBuilder).build();
    cubeListBuilder = new PatternCubeFour(cubeListBuilder).build();
    cubeListBuilder = new PatternCubeFive(cubeListBuilder).build();
    cubeListBuilder = new PatternCubeSix(cubeListBuilder).build();

    return theSidePart.addOrReplaceChild(
        "Pattern", cubeListBuilder, PartPose.offset(-3.6F, 5.4F, -0.75F));
  }
}
