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
package io.github.realyusufismail.armourandtoolsmod;

import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit;
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit;
import io.github.realyusufismail.armourandtoolsmod.core.itemgroup.ArmourAndToolsGroup;
import io.github.realyusufismail.armourandtoolsmod.datagen.DataGenerators;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.MOD_ID;

@Mod(MOD_ID)
public class ArmourAndToolsMod {
    public static final Logger logger = LoggerFactory.getLogger(ArmourAndToolsMod.class);
    public static final String MOD_ID = "armourandtoolsmod";

    public ArmourAndToolsMod() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        // Register the item to a creative tab
        bus.addListener(ArmourAndToolsGroup::registerCreativeTab);
        // Register the data generators
        bus.addListener(DataGenerators::gatherData);

        // Register the mod to the event bus
        MinecraftForge.EVENT_BUS.register(this);
        logger.info("Hello from RealYusufismail's Armour and Tools Mod!");
    }
}
