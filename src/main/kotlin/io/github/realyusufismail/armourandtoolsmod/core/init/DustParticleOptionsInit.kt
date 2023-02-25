package io.github.realyusufismail.armourandtoolsmod.core.init

import net.minecraft.core.particles.DustParticleOptions
import net.minecraft.world.phys.Vec3
import org.joml.Vector3f

object DustParticleOptionsInit {
    //colours
    private val GENERAL_PARTICLE_COLOR : Vector3f = Vec3.fromRGB24(0x00FFFF).toVector3f()

    val GENERAL_PARTICLE_OPTIONS = DustParticleOptions(GENERAL_PARTICLE_COLOR, 1.0f)
}