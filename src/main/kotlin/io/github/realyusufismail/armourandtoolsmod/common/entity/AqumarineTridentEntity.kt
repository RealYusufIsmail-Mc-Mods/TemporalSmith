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
package io.github.realyusufismail.armourandtoolsmod.common.entity

import io.github.realyusufismail.armourandtoolsmod.core.init.EntityTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class AqumarineTridentEntity : ArmourToolsModTridentEntity {

    constructor(type: EntityType<ArmourToolsModTridentEntity>, world: Level) : super(type, world) {
        this.tridentItem = ItemStack(ItemInit.AQUMARINE_TRIDENT.get())
    }

    constructor(
        level: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ) : super(EntityTypeInit.AQUMARINE_THROWN_TRIDENT.get(), level, thrower, stack)

    override fun getBaseDamage(): Double {
        return 8.0
    }
}
