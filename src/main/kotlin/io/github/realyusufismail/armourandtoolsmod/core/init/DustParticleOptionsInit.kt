/*
 * Copyright 2022 RealYusufIsmail.
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
package io.github.realyusufismail.armourandtoolsmod.core.init

import net.minecraft.core.particles.DustParticleOptions
import net.minecraft.world.phys.Vec3
import org.joml.Vector3f

object DustParticleOptionsInit {
    // colours
    private val GENERAL_PARTICLE_COLOR: Vector3f = Vec3.fromRGB24(0x00FFFF).toVector3f()

    val GENERAL_PARTICLE_OPTIONS = DustParticleOptions(GENERAL_PARTICLE_COLOR, 1.0f)
}
