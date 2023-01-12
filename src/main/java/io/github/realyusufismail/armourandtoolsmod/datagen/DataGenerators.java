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
package io.github.realyusufismail.armourandtoolsmod.datagen;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.datagen.lang.ModEnLangProvider;
import io.github.realyusufismail.armourandtoolsmod.datagen.loot.ModLootTables;
import io.github.realyusufismail.armourandtoolsmod.datagen.texture.ModBlockStateProvider;
import net.minecraftforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        ArmourAndToolsMod.logger.info("Gathering data...");

        final var gen = event.getGenerator();
        final var existingFileHelper = event.getExistingFileHelper();
        final var lookup = event.getLookupProvider();

        try {
            gen.addProvider(true, new ModLootTables(gen));
            gen.addProvider(true, new ModEnLangProvider(gen));
            gen.addProvider(true,
                    new ModBlockStateProvider(gen.getPackOutput(), existingFileHelper));
        } catch (RuntimeException e) {
            ArmourAndToolsMod.logger.error("Failed to gather data: " + e.getMessage());
        }
    }
}
