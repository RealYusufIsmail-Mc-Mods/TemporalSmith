package io.github.realyusufismail.armourandtoolsmod.client;

import io.github.realyusufismail.armourandtoolsmod.client.renderer.shield.ArmourAndToolsModShieldItemRenderer;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ArmourAndToolsModShieldItemRendererProvider {
    private static ArmourAndToolsModShieldItemRenderer shieldItemRenderer;

    public static void init(final RegisterClientReloadListenersEvent event) {
        shieldItemRenderer = new ArmourAndToolsModShieldItemRenderer();

        event.registerReloadListener(shieldItemRenderer);
    }

    public static IClientItemExtensions shield() {
        return new IClientItemExtensions() {
            @Override
            public ArmourAndToolsModShieldItemRenderer getCustomRenderer() {
                return shieldItemRenderer;
            }
        };
    }
}
