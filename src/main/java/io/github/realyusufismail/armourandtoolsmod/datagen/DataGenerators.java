package io.github.realyusufismail.armourandtoolsmod.datagen;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.datagen.lang.ModEnLangProvider;
import io.github.realyusufismail.armourandtoolsmod.datagen.loot.ModLootTables;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class DataGenerators {

    private DataGenerators() {}

    public static void gatherData(GatherDataEvent event) {
        ArmourAndToolsMod.logger.info("Gathering data...");

        var gen = event.getGenerator();
        var existingFileHelper = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        try {
            gen.addProvider(true, new ModLootTables(gen));
            gen.addProvider(true, new ModEnLangProvider(gen));
        } catch (RuntimeException e) {
            ArmourAndToolsMod.logger.error("Failed to gather data!", e);
        }
    }
}
