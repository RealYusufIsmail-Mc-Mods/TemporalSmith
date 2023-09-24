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
package io.github.realyusufismail.armourandtoolsmod.items.trident

import io.github.realyusufismail.armourandtoolsmod.client.ArmourAndToolsModTridentItemRendererProvider
import io.github.realyusufismail.armourandtoolsmod.common.entity.AqumarineTridentEntity
import io.github.realyusufismail.armourandtoolsmod.common.entity.ArmourToolsModTridentEntity
import java.util.function.Consumer
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraftforge.client.extensions.common.IClientItemExtensions

open class AqumarineTridentItem : ArmourToolsModTridentItem() {

    override fun getThrownEntity(
        world: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ): ArmourToolsModTridentEntity {
        return AqumarineTridentEntity(world, thrower, stack)
    }

    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(ArmourAndToolsModTridentItemRendererProvider.aqumarineTrident())
    }
}
