/*
 * Copyright 2022 RealYusufIsmail.
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
package io.github.realyusufismail.armourandtoolsmod.core.itemgroup;

import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraft.resources.ResourceLocation;

import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.MOD_ID;

public class ArmourAndToolsGroup {

    public static void registerCreativeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "creativetab"),
                ArmourAndToolsGroup::createCreativeTabBuilder);
    }

    private static void createCreativeTabBuilder(CreativeModeTab.Builder builder) {
        builder.displayItems((f, o, b) -> {
            ItemInit.ITEMS.getEntries()
                .stream()
                .map(item -> item.get().asItem())
                .forEach(o::accept);

            BlockInit.BLOCKS.getEntries()
                .stream()
                .map(item -> item.get().asItem())
                .forEach(o::accept);
        });

        builder.icon(() -> ItemInit.AQUMARINE.get().getDefaultInstance());
        builder.title(Component.translatable("creativetab.armourandtoolsmod"));
        builder.withSearchBar();
    }
}
