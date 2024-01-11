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
import io.github.realyusufismail.temporalsmith.blocks.infusion.IngotFusionTollEnhancerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypeInit {

  public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TemporalSmith.MOD_ID);

  public static RegistryObject<BlockEntityType<IngotFusionTollEnhancerBlockEntity>>
      INGOT_FUSION_TOLL_ENHANCER =
          BLOCK_ENTITY_TYPES.register(
              "ingot_fusion_toll_enhancer",
              () ->
                  BlockEntityType.Builder.of(
                          IngotFusionTollEnhancerBlockEntity::new,
                          BlockInit.INGOT_FUSION_TOLL_ENHANCER.get())
                      .build(null));
}
