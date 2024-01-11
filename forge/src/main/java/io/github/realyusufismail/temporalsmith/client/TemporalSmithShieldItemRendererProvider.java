/*
 * Copyright 2023 RealYusufIsmail.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package io.github.realyusufismail.temporalsmith.client;

import io.github.realyusufismail.temporalsmith.client.renderer.shield.ModShieldItemRenderer;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class TemporalSmithShieldItemRendererProvider {
  private static ModShieldItemRenderer shieldItemRenderer;

  public static void init(final RegisterClientReloadListenersEvent event) {
    shieldItemRenderer = new ModShieldItemRenderer();

    event.registerReloadListener(shieldItemRenderer);
  }

  public static IClientItemExtensions shield() {
    return new IClientItemExtensions() {
      @Override
      public ModShieldItemRenderer getCustomRenderer() {
        return shieldItemRenderer;
      }
    };
  }
}
