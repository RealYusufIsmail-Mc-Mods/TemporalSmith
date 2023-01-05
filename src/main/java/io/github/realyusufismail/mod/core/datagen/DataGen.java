package io.github.realyusufismail.mod.core.datagen;

import io.github.realyusufismail.mod.ArmourAndItemMod;
import io.github.realyusufismail.mod.core.datagen.lang.ModEnLangProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArmourAndItemMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var existingFileHelper = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        gen.addProvider(true, new ModEnLangProvider(gen));
    }
}
