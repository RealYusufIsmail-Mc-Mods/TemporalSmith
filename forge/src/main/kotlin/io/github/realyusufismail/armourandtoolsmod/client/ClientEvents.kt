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
package io.github.realyusufismail.armourandtoolsmod.client

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.blocks.armour.CustomArmourCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.IngotFusionTollEnhancerScreen
import io.github.realyusufismail.armourandtoolsmod.blocks.tool.CustomToolCraftingTableScreen
import io.github.realyusufismail.armourandtoolsmod.client.renderer.mjolnir.MjolnirItemRenderer
import io.github.realyusufismail.armourandtoolsmod.client.renderer.trident.aq.AqumarineTridentItemRenderer
import io.github.realyusufismail.armourandtoolsmod.core.init.*
import io.github.realyusufismail.armourandtoolsmod.models.MjolnirModel
import io.github.realyusufismail.armourandtoolsmod.util.KeyBinding
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.MenuScreens
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.phys.Vec3
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.client.event.RegisterKeyMappingsEvent
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

object ClientEvents {
    val MjolnirLayer = ModelLayerLocation(ArmourAndToolsMod.getModIdAndName("mjolnir"), "mjolnir")

    fun clientSetup(event: FMLClientSetupEvent) {
        event.enqueueWork { registerScreens() }

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
        event.registerEntityRenderer(
            EntityTypeInit.AQUMARINE_THROWN_TRIDENT.get(), ::AqumarineTridentItemRenderer)

        event.registerEntityRenderer(EntityTypeInit.MJOLNIR.get(), ::MjolnirItemRenderer)
    }

    fun registerLayerDefinition(event: EntityRenderersEvent.RegisterLayerDefinitions) {
        event.registerLayerDefinition(MjolnirLayer, MjolnirModel::createLayer)
    }

    fun onKeyRegister(event: RegisterKeyMappingsEvent) {
        event.register(KeyBinding.GET_MJOLNIR)
        event.register(KeyBinding.STRIKE_LIGHTNING)
    }

    fun onKeyInput(event: InputEvent.Key) {
        if (KeyBinding.GET_MJOLNIR.consumeClick()) {
            val player = Minecraft.getInstance().player
            if (player != null) {
                val effects = player.activeEffectsMap

                if (effects.contains(MobEffectsInit.WORTHY_EFFECT.get())) {
                    // if they alread have mjolnir, ignore
                    if (player.inventory.contains(ItemInit.MJOLNIR.get().defaultInstance)) {
                        return
                    } else {
                        player.inventory.add(ItemInit.MJOLNIR.get().defaultInstance)
                    }
                }
            }
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
}
