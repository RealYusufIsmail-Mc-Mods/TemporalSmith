package io.github.realyusufismail.armourandtoolsmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ArmourAndToolsMod.MOD_ID)
public class ArmourAndToolsMod {
    public static final Logger logger = LogManager.getLogger();
    public static final String MOD_ID = "armourandtoolsmod";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArmourAndToolsMod.MOD_ID);

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArmourAndToolsMod.MOD_ID);

    public ArmourAndToolsMod() {
        final var bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(bus);
        BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        logger.info("Loaded Armour and Item Mod");
    }
}
