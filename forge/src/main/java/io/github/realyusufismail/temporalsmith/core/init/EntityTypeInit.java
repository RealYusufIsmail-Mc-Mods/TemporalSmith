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
package io.github.realyusufismail.temporalsmith.core.init;

import io.github.realyusufismail.temporalsmith.TemporalSmith;
import io.github.realyusufismail.temporalsmith.common.entity.AqumarineTridentEntity;
import io.github.realyusufismail.temporalsmith.common.entity.MjolnirEntity;
import io.github.realyusufismail.temporalsmith.common.entity.ModTridentEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypeInit {
  public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
      DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TemporalSmith.MOD_ID);

  public static final RegistryObject<EntityType<ModTridentEntity>> AQUMARINE_THROWN_TRIDENT =
      ENTITY_TYPES.register(
          "aqumarine_thrown_trident",
          () ->
              EntityType.Builder.<ModTridentEntity>of(AqumarineTridentEntity::new, MobCategory.MISC)
                  .sized(0.5F, 0.5F)
                  .fireImmune()
                  .clientTrackingRange(4)
                  .updateInterval(20)
                  .setCustomClientFactory(
                      (spawnEntity, world) ->
                          new AqumarineTridentEntity(
                              EntityTypeInit.AQUMARINE_THROWN_TRIDENT.get(), world))
                  .build(TemporalSmith.MOD_ID + ":aqumarine_thrown_trident"));

  public static final RegistryObject<EntityType<ModTridentEntity>> MJOLNIR =
      ENTITY_TYPES.register(
          "mjolnir",
          () ->
              EntityType.Builder.<ModTridentEntity>of(MjolnirEntity::new, MobCategory.MISC)
                  .sized(0.5F, 0.5F)
                  .fireImmune()
                  .clientTrackingRange(4)
                  .updateInterval(20)
                  .setCustomClientFactory(
                      (spawnEntity, world) ->
                          new MjolnirEntity(EntityTypeInit.MJOLNIR.get(), world))
                  .build(TemporalSmith.MOD_ID + ":mjolnir_thrown"));
}
