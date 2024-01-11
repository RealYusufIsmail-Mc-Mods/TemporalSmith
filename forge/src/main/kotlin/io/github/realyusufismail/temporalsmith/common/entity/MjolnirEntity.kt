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
package io.github.realyusufismail.temporalsmith.common.entity

import io.github.realyusufismail.temporalsmith.core.init.EntityTypeInit
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

open class MjolnirEntity : ModTridentEntity {

    constructor(type: EntityType<ModTridentEntity>, world: Level) : super(type, world) {
        this.tridentItem = ItemStack(ItemInit.MJOLNIR.get())
        this.entityData.set(ID_LOYALTY, 1.toByte())
        this.allowToTriggerThunderWithoutEnchantment = true
    }

    constructor(
        level: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ) : super(EntityTypeInit.MJOLNIR.get(), level, thrower, stack) {
        this.entityData.set(ID_LOYALTY, 1.toByte())
        this.allowToTriggerThunderWithoutEnchantment = true
    }

    override fun getBaseDamage(): Double {
        return 15.0
    }
}
