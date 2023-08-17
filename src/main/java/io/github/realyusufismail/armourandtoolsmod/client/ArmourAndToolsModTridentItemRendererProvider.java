package io.github.realyusufismail.armourandtoolsmod.client;

import io.github.realyusufismail.armourandtoolsmod.client.renderer.trident.ister.AqumarineTridentItemRendererISTER;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ArmourAndToolsModTridentItemRendererProvider {
    private static AqumarineTridentItemRendererISTER aqumarineTridentItemRendererISTER;

    public static void init(final RegisterClientReloadListenersEvent event) {
        aqumarineTridentItemRendererISTER = new AqumarineTridentItemRendererISTER();

        event.registerReloadListener(aqumarineTridentItemRendererISTER);
    }

    public static IClientItemExtensions aqumarineTrident() {
        return new IClientItemExtensions() {
            @Override
            public AqumarineTridentItemRendererISTER getCustomRenderer() {
                return aqumarineTridentItemRendererISTER;
            }
        };
    }
}
