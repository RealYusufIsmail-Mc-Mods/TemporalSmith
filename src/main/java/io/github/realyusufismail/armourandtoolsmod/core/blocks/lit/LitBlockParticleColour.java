package io.github.realyusufismail.armourandtoolsmod.core.blocks.lit;

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
