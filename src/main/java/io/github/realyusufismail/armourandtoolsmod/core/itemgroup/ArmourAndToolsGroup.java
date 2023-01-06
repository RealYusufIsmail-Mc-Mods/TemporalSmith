package io.github.realyusufismail.armourandtoolsmod.core.itemgroup;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.BLOCKS;
import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ITEMS;

@Mod.EventBusSubscriber(modid = ArmourAndToolsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmourAndToolsGroup {
    @SubscribeEvent
    public static void registerCreativeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(ArmourAndToolsMod.MOD_ID, "creativetab"),
                ArmourAndToolsGroup::createCreativeTabBuilder);
    }

    private static void createCreativeTabBuilder(CreativeModeTab.Builder builder) {
        builder.displayItems((set, out, unknownMagicBoolean) -> {
            ITEMS.getEntries().stream().map(item -> item.get().asItem()).forEach(out::accept);

            BLOCKS.getEntries().stream().map(item -> item.get().asItem()).forEach(out::accept);
        });

        builder.icon(() -> new ItemStack(ItemInit.AMETHYST.get()));
        builder.title(Component.translatable("creativetab.armourandtoolsmod"));
        builder.withSearchBar();
    }
}
