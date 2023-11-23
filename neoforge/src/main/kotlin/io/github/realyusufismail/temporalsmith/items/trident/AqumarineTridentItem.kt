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
package io.github.realyusufismail.temporalsmith.items.trident

import io.github.realyusufismail.temporalsmith.blocks.EnderitePortalBlock
import io.github.realyusufismail.temporalsmith.client.TemporalSmithTridentItemRendererProvider
import io.github.realyusufismail.temporalsmith.common.entity.AqumarineTridentEntity
import io.github.realyusufismail.temporalsmith.common.entity.ModTridentEntity
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import io.github.realyusufismail.temporalsmith.core.init.DimensionsInit
import io.github.realyusufismail.temporalsmith.core.material.CustomToolMaterial
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions
import java.util.function.Consumer


open class AqumarineTridentItem :
    ArmourToolsModTridentItem(
        CustomToolMaterial.AQUMARINE_TRIDENT, Properties().stacksTo(1), 10F, -2.5F) {

    override fun getThrownEntity(
        world: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ): ModTridentEntity {
        return AqumarineTridentEntity(world, thrower, stack)
    }

    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(TemporalSmithTridentItemRendererProvider.aqumarineTrident())
    }

    override fun useOn(context: UseOnContext): InteractionResult {
        if (context.player != null) {
            if (context.player!!.level().dimension() === DimensionsInit.CHRONO_REALM || context.player!!
                    .level().dimension() === Level.OVERWORLD
            ) {
                for (direction in Direction.Plane.VERTICAL) {
                    val framePos: BlockPos = context.getClickedPos().relative(direction)
                    return if ((BlockInit.ENDERITE_PORTAL_BLOCK.get() as EnderitePortalBlock).trySpawnPortal(
                            context.level,
                            framePos
                        )
                    ) {
                        context.getLevel().playSound(
                            context.getPlayer(),
                            framePos,
                            SoundEvents.END_PORTAL_FRAME_FILL,
                            SoundSource.BLOCKS,
                            1.0f,
                            1.0f
                        )
                        InteractionResult.CONSUME
                    } else InteractionResult.FAIL
                }
            }
        }
        return InteractionResult.FAIL
    }
}
