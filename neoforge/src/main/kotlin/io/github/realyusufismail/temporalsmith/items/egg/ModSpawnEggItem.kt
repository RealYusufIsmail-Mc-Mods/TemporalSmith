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
package io.github.realyusufismail.temporalsmith.items.egg

import java.util.function.Supplier
import net.minecraft.core.Direction
import net.minecraft.core.dispenser.BlockSource
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobSpawnType
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.SpawnEggItem
import net.minecraft.world.level.block.DispenserBlock
import net.neoforged.neoforge.common.DeferredSpawnEggItem

class ModSpawnEggItem(
    entityTypeSupplier: Supplier<out EntityType<*>>,
    primaryColour: Int,
    secondaryColour: Int,
    properties: Item.Properties,
) : DeferredSpawnEggItem(null, primaryColour, secondaryColour, properties) {
    private val entityTypeSupplier: Lazy<EntityType<*>>

    init {
        this.entityTypeSupplier = lazy(entityTypeSupplier::get)
        unaidedEggs.add(this)
    }

    override fun getType(p_43229_: CompoundTag?): EntityType<*> {
        return entityTypeSupplier.value
    }

    companion object {
        private val unaidedEggs: MutableList<ModSpawnEggItem> = mutableListOf()

        fun spawnEggs() {
            val dispenseBehaviour: DefaultDispenseItemBehavior =
                object : DefaultDispenseItemBehavior() {
                    override fun execute(source: BlockSource, stack: ItemStack): ItemStack {
                        val direction: Direction = source.state().getValue(DispenserBlock.FACING)
                        val type = (stack.item as SpawnEggItem).getType(stack.tag)
                        type.spawn(
                            source.level(),
                            stack,
                            null,
                            source.pos().relative(direction),
                            MobSpawnType.DISPENSER,
                            direction !== Direction.UP,
                            false)
                        stack.shrink(1)
                        return stack
                    }
                }

            for (spawnEgg in unaidedEggs) {
                DispenserBlock.registerBehavior(spawnEgg, dispenseBehaviour)
            }

            unaidedEggs.clear()
        }
    }
}
