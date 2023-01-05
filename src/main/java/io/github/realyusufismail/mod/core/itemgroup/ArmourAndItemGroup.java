package io.github.realyusufismail.mod.core.itemgroup;

import io.github.realyusufismail.mod.ArmourAndItemMod;
import io.github.realyusufismail.mod.core.init.BlockInit;
import io.github.realyusufismail.mod.core.init.ItemInit;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static io.github.realyusufismail.mod.ForgeReg.BLOCKS;
import static io.github.realyusufismail.mod.ForgeReg.ITEMS;

@Mod.EventBusSubscriber(modid = ArmourAndItemMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmourAndItemGroup {
    @SubscribeEvent
    public static void registerCreativeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(ArmourAndItemMod.MOD_ID, "creativetab"),
                ArmourAndItemGroup::createCreativeTabBuilder);
    }

    private static void createCreativeTabBuilder(CreativeModeTab.Builder builder) {
        builder.displayItems((set, out, unknownMagicBoolean) -> {
            ITEMS.getEntries().stream().map(item -> item.get().asItem()).forEach(out::accept);

            BLOCKS.getEntries().stream().map(item -> item.get().asItem()).forEach(out::accept);
        });

        builder.icon(() -> new ItemStack(ItemInit.AMETHYST.get()));
        builder.title(Component.translatable("creativetab.armouranditemmod"));
        builder.withSearchBar();
    }
}
