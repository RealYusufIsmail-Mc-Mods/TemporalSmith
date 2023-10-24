/*
 * Copyright 2023 RealYusufIsmail.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.realyusufismail.armourandtoolsmod.client;

import io.github.realyusufismail.armourandtoolsmod.client.renderer.mjolnir.MjolnirItemRendererISTER;
import io.github.realyusufismail.armourandtoolsmod.client.renderer.trident.aq.AqumarineTridentItemRendererISTER;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ArmourAndToolsModTridentItemRendererProvider {
  private static AqumarineTridentItemRendererISTER aqumarineTridentItemRendererISTER;
  private static MjolnirItemRendererISTER mjolnirItemRendererISTER;

  public static void init(final RegisterClientReloadListenersEvent event) {
    aqumarineTridentItemRendererISTER = new AqumarineTridentItemRendererISTER();
    mjolnirItemRendererISTER = new MjolnirItemRendererISTER();

    event.registerReloadListener(aqumarineTridentItemRendererISTER);
    event.registerReloadListener(mjolnirItemRendererISTER);
  }

  public static IClientItemExtensions aqumarineTrident() {
    return new IClientItemExtensions() {
      @Override
      public AqumarineTridentItemRendererISTER getCustomRenderer() {
        return aqumarineTridentItemRendererISTER;
      }
    };
  }

  public static IClientItemExtensions mjolnir() {
    return new IClientItemExtensions() {
      @Override
      public MjolnirItemRendererISTER getCustomRenderer() {
        return mjolnirItemRendererISTER;
      }
    };
  }
}
