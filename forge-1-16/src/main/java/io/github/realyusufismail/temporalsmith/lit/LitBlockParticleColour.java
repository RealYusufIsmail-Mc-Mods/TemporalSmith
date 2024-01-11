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
package io.github.realyusufismail.temporalsmith.lit;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

public enum LitBlockParticleColour {
  RAINBOW_PARTICLE_COLOR_PURPLE(Vector3d.fromRGB24(148000211)),
  RAINBOW_PARTICLE_COLOR_RED(Vector3d.fromRGB24(16711680)),
  RAINBOW_PARTICLE_COLOR_GREEN(Vector3d.fromRGB24(65280)),
  RAINBOW_PARTICLE_COLOR_BLUE(Vector3d.fromRGB24(255)),
  RUBY_PARTICLE_COLOR(Vector3d.fromRGB24(14684511));

  private final Vector3f colour;

  LitBlockParticleColour(Vector3d colour) {
    this.colour = new Vector3f((float) colour.x, (float) colour.y, (float) colour.z);
  }

  public IParticleData getParticleOption() {
    float[] rgb = new float[] {colour.x(), colour.y(), colour.z()};
    return new RedstoneParticleData(rgb[0], rgb[1], rgb[2], 1.0f);
  }
}
