package io.github.realyusufismail.mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ArmourAndItemMod.MOD_ID)
public class ArmourAndItemMod {
    public static final Logger logger = LogManager.getLogger();
    public static final String MOD_ID = "armouranditemmod";

    public ArmourAndItemMod() {
        final var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ForgeReg::registerForgeReg);
        logger.info("Loaded Armour and Item Mod");
    }
}
