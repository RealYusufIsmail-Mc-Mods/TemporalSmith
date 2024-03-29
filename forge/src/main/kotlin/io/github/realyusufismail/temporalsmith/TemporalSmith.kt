/*
 * Copyright 2024 RealYusufIsmail.
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
package io.github.realyusufismail.temporalsmith

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.client.ClientEvents
import io.github.realyusufismail.temporalsmith.client.TemporalSmithShieldItemRendererProvider
import io.github.realyusufismail.temporalsmith.client.TemporalSmithTridentItemRendererProvider
import io.github.realyusufismail.temporalsmith.core.init.*
import io.github.realyusufismail.temporalsmith.datagen.DataGenerators
import java.util.*
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import thedarkcolour.kotlinforforge.KotlinModLoadingContext
import thedarkcolour.kotlinforforge.forge.FORGE_BUS

@Mod(MOD_ID)
class TemporalSmith {
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
        POIInit.POI.register(bus)
        DimensionsInit.register()

        // Register ourselves for server and other game events we are interested in
        // Register the data generators
        bus.addListener(DataGenerators::gatherData)
        // adds recipe category
        bus.addListener(RecipeCategoriesInit::registerRecipeBookCategories)
        // client setup listener
        bus.addListener(ClientEvents::clientSetup)
        // register shield renderer provider
        bus.addListener(TemporalSmithShieldItemRendererProvider::init)
        // register trident renderer provider
        bus.addListener(TemporalSmithTridentItemRendererProvider::init)
        // register entity renderers
        bus.addListener(ClientEvents::registerEntityRenders)
        // register key input event
        bus.addListener(ClientEvents::onKeyRegister)
        FORGE_BUS.addListener(ClientEvents::onKeyInput)
        // layer render
        bus.addListener(ClientEvents::registerLayerDefinition)
        // entity death event
        FORGE_BUS.addListener(ClientEvents::onEntityDeath)
        // entity attribute creation event
        //  bus.addListener(ClientEvents::onRegisterEntities)
        // player tick event
        FORGE_BUS.addListener(ClientEvents::onPlayerTickEvent)
        // falling living entity event
        FORGE_BUS.addListener(ClientEvents::onLivingFallEvent)
        // living hurt event
        FORGE_BUS.addListener(ClientEvents::onLivingHurtEvent)
        FORGE_BUS.addListener(ClientEvents::onLivingDamageEvent)
        // player pickup event
        FORGE_BUS.addListener(ClientEvents::onPlayerPickupEvent)

        FORGE_BUS.register(this)

        ModLoadingContext.get()
            .registerConfig(ModConfig.Type.COMMON, TemporalSmithConfig.COMMON_SPEC)

        logger.info("Temporal Smith is loaded!")
    }

    companion object TemporalSmith {
        @JvmStatic val logger: Logger = LoggerFactory.getLogger(TemporalSmith::class.java)

        @JvmStatic
        fun getModIdAndName(name: String): ResourceLocation {
            return ResourceLocation(MOD_ID, name.lowercase(Locale.getDefault()))
        }

        const val MOD_ID = "temporalsmith"
    }
}
