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
package io.github.realyusufismail.temporalsmith.lit;

import java.util.Arrays;
import java.util.Collections;

public class RainbowLitBlock extends LITBlock {
  public RainbowLitBlock() {
    super(
        Collections.unmodifiableList(
            Arrays.asList(
                LitBlockParticleColour.RAINBOW_PARTICLE_COLOR_RED,
                LitBlockParticleColour.RAINBOW_PARTICLE_COLOR_GREEN,
                LitBlockParticleColour.RAINBOW_PARTICLE_COLOR_BLUE,
                LitBlockParticleColour.RAINBOW_PARTICLE_COLOR_PURPLE)),
        11,
        RainbowLitBlock.class);
  }
}
