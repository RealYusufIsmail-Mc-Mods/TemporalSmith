package io.github.realyusufismail.armourandtoolsmod.datagen;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.datagen.lang.ModEnLangProvider;
import io.github.realyusufismail.armourandtoolsmod.datagen.loot.ModLootTables;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArmourAndToolsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var existingFileHelper = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        gen.addProvider(true, new ModLootTables(gen));
        gen.addProvider(true, new ModEnLangProvider(gen));
    }
}
