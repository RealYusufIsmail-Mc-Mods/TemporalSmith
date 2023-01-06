package io.github.realyusufismail.armourandtoolsmod.datagen.loot;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
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
            .filter(lootTable -> lootTable.getNamespace().equals(ArmourAndToolsMod.MOD_ID))
            .collect(Collectors.toSet());

        for (final ResourceLocation id : Sets.difference(modLootTableIds, map.keySet())) {
            validationContext.reportProblem("Missing mod loot table: " + id);
        }

        map.forEach((id, lootTable) -> LootTables.validate(validationContext, id, lootTable));
    }
}
