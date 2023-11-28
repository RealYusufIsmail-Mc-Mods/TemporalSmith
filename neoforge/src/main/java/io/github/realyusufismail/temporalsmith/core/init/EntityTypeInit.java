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

import static io.github.realyusufismail.temporalsmith.TemporalSmith.MOD_ID;

import io.github.realyusufismail.temporalsmith.common.entity.AqumarineTridentEntity;
import io.github.realyusufismail.temporalsmith.common.entity.MjolnirEntity;
import io.github.realyusufismail.temporalsmith.common.entity.ModTridentEntity;
import io.github.realyusufismail.temporalsmith.entities.golum.EnderiteGolem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityTypeInit {
  public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
      DeferredRegister.create(Registries.ENTITY_TYPE, MOD_ID);

  public static final DeferredHolder<EntityType<?>, EntityType<ModTridentEntity>>
      AQUMARINE_THROWN_TRIDENT =
          ENTITY_TYPES.register(
              "aqumarine_thrown_trident",
              () ->
                  EntityType.Builder.<ModTridentEntity>of(
                          AqumarineTridentEntity::new, MobCategory.MISC)
                      .sized(0.5F, 0.5F)
                      .fireImmune()
                      .clientTrackingRange(4)
                      .updateInterval(20)
                      .setCustomClientFactory(
                          (spawnEntity, world) ->
                              new AqumarineTridentEntity(
                                  EntityTypeInit.AQUMARINE_THROWN_TRIDENT.get(), world))
                      .build(MOD_ID + ":aqumarine_thrown_trident"));

  public static final DeferredHolder<EntityType<?>, EntityType<ModTridentEntity>> MJOLNIR =
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
                  .build(MOD_ID + ":mjolnir_thrown"));

  public static final DeferredHolder<EntityType<?>, EntityType<EnderiteGolem>> ENDERITE_GOLEM =
      ENTITY_TYPES.register(
          "enderite_golem",
          () ->
              createStandardEntityType(
                  "enderite_golem", EnderiteGolem::new, MobCategory.MISC, 1.4F, 2.7F, 10));

  private static final Item.Properties spawn_egg_props = new Item.Properties();

  public static final DeferredItem<Item> ENDERITE_GOLEM_SPAWN_EGG =
      ItemInit.ITEMS.register(
          "enderite_golem_spawn_egg",
          () -> new DeferredSpawnEggItem(ENDERITE_GOLEM, 0xC4AA79, 0x7A5F22, spawn_egg_props));

  private static <T extends Entity> EntityType<T> createStandardEntityType(
      String entity_name,
      EntityType.EntityFactory<T> factory,
      MobCategory classification,
      float width,
      float height,
      int tracking_range) {
    return EntityType.Builder.of(factory, classification)
        .sized(width, height)
        .clientTrackingRange(tracking_range)
        .build(MOD_ID + ":" + entity_name);
  }
}
