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
package io.github.realyusufismail.temporalsmith.blocks.lit;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public enum LitBlockParticleColour {
  RAINBOW_PARTICLE_COLOR_PURPLE(Vec3.fromRGB24(148000211).toVector3f()),
  RAINBOW_PARTICLE_COLOR_RED(Vec3.fromRGB24(16711680).toVector3f()),
  RAINBOW_PARTICLE_COLOR_GREEN(Vec3.fromRGB24(65280).toVector3f()),
  RAINBOW_PARTICLE_COLOR_BLUE(Vec3.fromRGB24(255).toVector3f()),
  RUBY_PARTICLE_COLOR(Vec3.fromRGB24(14684511).toVector3f());

  private final Vector3f colour;

  LitBlockParticleColour(Vector3f colour) {
    this.colour = colour;
  }

  public DustParticleOptions getParticleOption() {
    return new DustParticleOptions(colour, 1.0f);
  }
}
