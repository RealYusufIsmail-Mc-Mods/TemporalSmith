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
package io.github.realyusufismail.armourandtoolsmod.datagen.loot;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.MOD_ID;

public class ModLootTables extends LootTableProvider {
    public ModLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn.getPackOutput(), Set.of(), ImmutableList
            .of(new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    @Override
    protected void validate(final Map<ResourceLocation, LootTable> map,
            final ValidationContext validationContext) {
        final Set<ResourceLocation> modLootTableIds = BuiltInLootTables.all()
            .stream()
            .filter(lootTable -> lootTable.getNamespace().equals(MOD_ID))
            .collect(Collectors.toSet());

        for (final ResourceLocation id : Sets.difference(modLootTableIds, map.keySet())) {
            validationContext.reportProblem("Missing mod loot table: " + id);
        }

        map.forEach((id, lootTable) -> LootTables.validate(validationContext, id, lootTable));
    }
}
