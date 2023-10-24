/*
 * Copyright 2023 RealYusufIsmail.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.realyusufismail.armourandtoolsmod.datagen.loot

import com.google.common.collect.ImmutableList
import com.google.common.collect.Sets
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.MOD_ID
import java.util.stream.Collectors
import net.minecraft.data.DataGenerator
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.storage.loot.BuiltInLootTables
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.ValidationContext
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets

class ModLootTables(dataGeneratorIn: DataGenerator) :
    LootTableProvider(
        dataGeneratorIn.packOutput,
        setOf(),
        ImmutableList.of(SubProviderEntry({ ModBlockLootTables() }, LootContextParamSets.BLOCK))) {
    override fun validate(
        map: Map<ResourceLocation, LootTable>,
        validationContext: ValidationContext
    ) {
        val modLootTableIds =
            BuiltInLootTables.all()
                .stream()
                .filter { lootTable: ResourceLocation -> lootTable.namespace == MOD_ID }
                .collect(Collectors.toSet())

        for (id in Sets.difference(modLootTableIds, map.keys)) {
            validationContext.reportProblem("Missing mod loot table: $id")
        }

        map.forEach { (_: ResourceLocation, lootTable: LootTable) ->
            lootTable.validate(validationContext)
        }
    }
}
