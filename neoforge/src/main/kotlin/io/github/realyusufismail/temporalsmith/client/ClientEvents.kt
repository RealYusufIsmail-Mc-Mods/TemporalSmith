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
package io.github.realyusufismail.temporalsmith.client

import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.blocks.armour.CustomArmourCraftingTableScreen
import io.github.realyusufismail.temporalsmith.blocks.infusion.IngotFusionTollEnhancerScreen
import io.github.realyusufismail.temporalsmith.blocks.tool.CustomToolCraftingTableScreen
import io.github.realyusufismail.temporalsmith.client.renderer.mjolnir.MjolnirItemRenderer
import io.github.realyusufismail.temporalsmith.client.renderer.trident.aq.AqumarineTridentItemRenderer
import io.github.realyusufismail.temporalsmith.core.init.*
import io.github.realyusufismail.temporalsmith.entities.golum.EnderiteGolem
import io.github.realyusufismail.temporalsmith.entities.golum.EnderiteGolemModel
import io.github.realyusufismail.temporalsmith.entities.golum.EnderiteGolemRenderer
import io.github.realyusufismail.temporalsmith.entities.mjolnir.MjolnirModel
import io.github.realyusufismail.temporalsmith.items.egg.ModSpawnEggItem
import io.github.realyusufismail.temporalsmith.util.KeyBinding
import net.minecraft.client.gui.screens.MenuScreens
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.phys.Vec3
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.event.EntityRenderersEvent
import net.neoforged.neoforge.client.event.InputEvent
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent
import net.neoforged.neoforge.event.TickEvent
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent
import net.neoforged.neoforge.event.entity.living.LivingFallEvent
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent

object ClientEvents {
    val MjolnirLayer = ModelLayerLocation(TemporalSmith.getModIdAndName("mjolnir"), "mjolnir")
    val EnderiteGolemLayer =
        ModelLayerLocation(TemporalSmith.getModIdAndName("enderite_golem"), "enderite_golem")

    // booleans
    private var giveMjolnirToPlayer = false
    private var wasHoldingMjolnir = false
    private var ticksHoldingMjolnir = 0
    private val maxTicksToHold = 10

    fun clientSetup(event: FMLClientSetupEvent) {
        event.enqueueWork { registerScreens() }

        event.enqueueWork {
            ItemBlockRenderTypes.setRenderLayer(
                BlockInit.ENDERITE_PORTAL_FRAME.get(), RenderType.translucent())
        }

        event.enqueueWork {
            ItemProperties.register(ItemInit.RUBY_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(
                ItemInit.AQUMARINE_SHIELD.get(), ResourceLocation("blocking")) {
                    stack: ItemStack,
                    _: ClientLevel?,
                    entity: LivingEntity?,
                    _: Int ->
                    if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
                }

            ItemProperties.register(ItemInit.RAINBOW_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(ItemInit.SAPPHIRE_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(ItemInit.GRAPHITE_SHIELD.get(), ResourceLocation("blocking")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1F else 0F
            }

            ItemProperties.register(
                ItemInit.AQUMARINE_TRIDENT.get(), ResourceLocation("throwing")) {
                    stack: ItemStack,
                    _: ClientLevel?,
                    entity: LivingEntity?,
                    _: Int ->
                    if (entity != null && entity.isUsingItem && entity.useItem == stack) {
                        1.0f
                    } else 0.0f
                }

            ItemProperties.register(ItemInit.MJOLNIR.get(), ResourceLocation("throwing")) {
                stack: ItemStack,
                _: ClientLevel?,
                entity: LivingEntity?,
                _: Int ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) {
                    1.0f
                } else 0.0f
            }
        }
    }

    private fun registerScreens() {
        MenuScreens.register(
            MenuTypeInit.CUSTOM_ARMOUR_CRAFTING_TABLE_MENU.get(), ::CustomArmourCraftingTableScreen)

        MenuScreens.register(
            MenuTypeInit.CUSTOM_TOOL_CRAFTING_TABLE_MENU.get(), ::CustomToolCraftingTableScreen)

        MenuScreens.register(
            MenuTypeInit.INGOT_FUSION_TOLL_ENHANCER_MENU.get(), ::IngotFusionTollEnhancerScreen)
    }

    fun registerEntityRenders(event: EntityRenderersEvent.RegisterRenderers) {

        // Tridents
        event.registerEntityRenderer(
            EntityTypeInit.AQUMARINE_THROWN_TRIDENT.get(), ::AqumarineTridentItemRenderer)

        // Hammers
        event.registerEntityRenderer(EntityTypeInit.MJOLNIR.get(), ::MjolnirItemRenderer)

        // Mobs
        event.registerEntityRenderer(EntityTypeInit.ENDERITE_GOLEM.get(), ::EnderiteGolemRenderer)
    }

    fun registerLayerDefinition(event: EntityRenderersEvent.RegisterLayerDefinitions) {
        event.registerLayerDefinition(MjolnirLayer) { MjolnirModel.createBodyLayer() }
        event.registerLayerDefinition(EnderiteGolemLayer) { EnderiteGolemModel.createBodyLayer() }
    }

    fun onKeyRegister(event: RegisterKeyMappingsEvent) {
        event.register(KeyBinding.GET_MJOLNIR)
        event.register(KeyBinding.STRIKE_LIGHTNING)
    }

    fun onRegisterEntities(event: EntityAttributeCreationEvent) {
        ModSpawnEggItem.spawnEggs()
        event.put(EntityTypeInit.ENDERITE_GOLEM.get(), EnderiteGolem.createAttributes().build())
    }

    fun onKeyInput(event: InputEvent.Key) {
        if (KeyBinding.GET_MJOLNIR.consumeClick()) {
            giveMjolnirToPlayer = true
        }
    }

    fun onEntityDeath(event: LivingDeathEvent) {
        val entity = event.entity
        val type = entity.type

        if (type is EntityType<*> && type == EntityType.ENDER_DRAGON) {
            val killer = entity.lastHurtByMob
            if (killer is ServerPlayer) {
                val effects = killer.activeEffectsMap

                if (!effects.contains(MobEffectsInit.WORTHY_EFFECT.get())) {
                    // give the worthy effect
                    killer.addEffect(MobEffectInstance(MobEffectsInit.WORTHY_EFFECT.get()))
                    killer.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f)
                    val pos = entity.blockPosition()
                    val vec = Vec3.atCenterOf(pos)
                    val lightning = EntityType.LIGHTNING_BOLT.create(killer.level())
                    lightning?.setPos(vec.x, vec.y, vec.z)
                    killer.level().addFreshEntity(lightning as Entity)
                }
            }
        }
    }

    fun onPlayerTickEvent(event: TickEvent.PlayerTickEvent) {
        if (event.player is Player) {

            val player = event.player as Player

            val inventory = player.inventory
            val effects = player.activeEffectsMap

            if (giveMjolnirToPlayer) {

                if (effects.contains(MobEffectsInit.WORTHY_EFFECT.get()) &&
                    !inventory.contains(ItemInit.MJOLNIR.get().defaultInstance)) {
                    inventory.add(ItemInit.MJOLNIR.get().defaultInstance)
                } else if (!effects.contains(MobEffectsInit.WORTHY_EFFECT.get())) {
                    player.sendSystemMessage(
                        Component.literal("You are not worthy to wield thors hammer"))
                }

                giveMjolnirToPlayer = false
            }

            // Check if the player is holding the specified item in the main hand
            val holdingMjolnir = player.mainHandItem.item == ItemInit.MJOLNIR.get()

            // Check if the player just stopped holding Mjolnir in this tick
            if (!holdingMjolnir && wasHoldingMjolnir) {
                // Start the tick counter when the item is no longer held
                ticksHoldingMjolnir = 0
            }

            if (holdingMjolnir) {
                if (!player.isCreative && !player.abilities.mayfly) {
                    player.abilities.mayfly = true
                    player.abilities.flyingSpeed = 0.1f
                    player.abilities.invulnerable = true
                }
            }

            // Check if the player is holding Mjolnir
            if (holdingMjolnir) {
                // Reset the ticks counter if the player is holding Mjolnir
                ticksHoldingMjolnir = 0
            } else {
                // Increment the ticks counter if the player is not holding Mjolnir
                ticksHoldingMjolnir++

                // Check if the player has not held Mjolnir for the required number of ticks
                if (ticksHoldingMjolnir >= maxTicksToHold) {
                    // Perform actions when the item has not been held for the specified number of
                    // ticks
                    if (!player.isCreative) {
                        player.abilities.mayfly = false
                        player.abilities.flyingSpeed = 0.05f
                        player.abilities.invulnerable = false
                    }
                    // Reset the ticks counter
                    ticksHoldingMjolnir = 0
                }
            }

            // Update the boolean variable for the next tick
            wasHoldingMjolnir = holdingMjolnir
        }
    }

    fun onLivingFallEvent(event: LivingFallEvent) {
        if (event.entity is Player) {
            val player = event.entity as Player

            if (player.activeEffectsMap.contains(MobEffectsInit.WORTHY_EFFECT.get())) {
                event.distance = 0.0f
            }
        }
    }

    fun onLivingHurtEvent(event: LivingHurtEvent) {
        if (event.entity is Player) {
            val player = event.entity as Player

            if (player.activeEffectsMap.contains(MobEffectsInit.WORTHY_EFFECT.get())) {
                event.amount = 0.0f
            }
        }
    }

    fun onLivingDamageEvent(event: LivingHurtEvent) {
        if (event.entity is Player) {
            val player = event.entity as Player

            if (player.activeEffectsMap.contains(MobEffectsInit.WORTHY_EFFECT.get())) {
                event.amount = 0.0f
            }
        }
    }
}
