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
package io.github.realyusufismail.temporalsmith.core.init;

import io.github.realyusufismail.temporalsmith.TemporalSmith;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionsInit {
  public static ResourceKey<Level> CHRONO_REALM =
      ResourceKey.create(
          Registries.DIMENSION, TemporalSmith.TemporalSmith.getModIdAndName("chrono_realm"));
  public static ResourceKey<DimensionType> CHRONO_REALM_TYPE =
      ResourceKey.create(
          Registries.DIMENSION_TYPE,
          TemporalSmith.TemporalSmith.getModIdAndName("chrono_realm_type"));

  public static void registerDimensions() {
    TemporalSmith.TemporalSmith.getLogger().info("Registered dimensions");
  }
}
