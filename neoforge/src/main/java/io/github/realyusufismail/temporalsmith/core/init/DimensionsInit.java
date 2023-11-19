package io.github.realyusufismail.temporalsmith.core.init;

import io.github.realyusufismail.temporalsmith.TemporalSmith;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionsInit {
    public static ResourceKey<Level> CHRONO_REALM = ResourceKey.create(Registries.DIMENSION, TemporalSmith.TemporalSmith.getModIdAndName("chrono_realm"));
    public static ResourceKey<DimensionType> CHRONO_REALM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, TemporalSmith.TemporalSmith.getModIdAndName("chrono_realm_type"));

    public static void registerDimensions() {
        TemporalSmith.TemporalSmith.getLogger().info("Registered dimensions");
    }
}
