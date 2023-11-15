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
package io.github.realyusufismail.armourandtoolsmod

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.ArmorAndToolsMod.MOD_ID
import io.github.realyusufismail.armourandtoolsmod.client.ArmourAndToolsModShieldItemRendererProvider
import io.github.realyusufismail.armourandtoolsmod.client.ArmourAndToolsModTridentItemRendererProvider
import io.github.realyusufismail.armourandtoolsmod.client.ClientEvents
import io.github.realyusufismail.armourandtoolsmod.core.init.*
import io.github.realyusufismail.armourandtoolsmod.datagen.DataGenerators
import java.util.*
import net.minecraft.resources.ResourceLocation
import net.neoforged.fml.common.Mod
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import thedarkcolour.kotlinforforge.neoforge.KotlinModLoadingContext
import thedarkcolour.kotlinforforge.neoforge.forge.FORGE_BUS

@Mod(MOD_ID)
class ArmourAndToolsMod {
    init {
        val bus = KotlinModLoadingContext.get().getKEventBus()
        ItemInit.ITEMS.register(bus)
        BlockInit.BLOCKS.register(bus)
        MenuTypeInit.MENU.register(bus)
        RecipeSerializerInit.SERIALIZERS.register(bus)
        RecipeTypeInit.RECIPE_TYPES.register(bus)
        EntityTypeInit.ENTITY_TYPES.register(bus)
        BlockEntityTypeInit.BLOCK_ENTITY_TYPES.register(bus)
        CreativeModeTabInit.CREATIVE_MODE_TAB.register(bus)
        PotionsInit.POTION.register(bus)
        MobEffectsInit.MOB_EFFECTS.register(bus)

        // Register ourselves for server and other game events we are interested in
        // Register the data generators
        bus.addListener(DataGenerators::gatherData)
        // adds recipe category
        bus.addListener(RecipeCategoriesInit::registerRecipeBookCategories)
        // client setup listener
        bus.addListener(ClientEvents::clientSetup)
        // register shield renderer provider
        bus.addListener(ArmourAndToolsModShieldItemRendererProvider::init)
        // register trident renderer provider
        bus.addListener(ArmourAndToolsModTridentItemRendererProvider::init)
        // register entity renderers
        bus.addListener(ClientEvents::registerEntityRenders)
        // register key input event
        bus.addListener(ClientEvents::onKeyRegister)
        FORGE_BUS.addListener(ClientEvents::onKeyInput)
        // layer render
        bus.addListener(ClientEvents::registerLayerDefinition)
        // entity death event
        FORGE_BUS.addListener(ClientEvents::onEntityDeath)

        logger.info("Loaded Armour and Item Mod")
    }

    companion object ArmorAndToolsMod {
        val logger: Logger = LoggerFactory.getLogger(ArmourAndToolsMod::class.java)

        fun getModIdAndName(name: String): ResourceLocation {
            return ResourceLocation(MOD_ID, name.lowercase(Locale.getDefault()))
        }

        const val MOD_ID = "armourandtoolsmod"
    }
}
