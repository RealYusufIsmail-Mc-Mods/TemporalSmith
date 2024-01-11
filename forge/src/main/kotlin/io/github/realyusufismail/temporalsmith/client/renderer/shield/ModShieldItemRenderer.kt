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
package io.github.realyusufismail.temporalsmith.client.renderer.shield

import com.mojang.blaze3d.vertex.PoseStack
import io.github.realyusufismail.temporalsmith.TemporalSmith
import io.github.realyusufismail.temporalsmith.client.ModBlockEntityWithoutLevelRenderer
import io.github.realyusufismail.temporalsmith.core.init.ItemInit
import io.github.realyusufismail.temporalsmith.items.shield.ModShieldItem
import net.minecraft.client.model.ShieldModel
import net.minecraft.client.model.geom.ModelLayers
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.entity.ItemRenderer
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.client.resources.model.Material
import net.minecraft.server.packs.resources.ResourceManager
import net.minecraft.world.inventory.InventoryMenu
import net.minecraft.world.item.ItemDisplayContext
import net.minecraft.world.item.ItemStack

class ModShieldItemRenderer : ModBlockEntityWithoutLevelRenderer() {
    private val SHIELD_RUBY: Material =
        Material(InventoryMenu.BLOCK_ATLAS, TemporalSmith.getModIdAndName("entity/shield/ruby"))
    private val SHIELD_AQUMARINE: Material =
        Material(
            InventoryMenu.BLOCK_ATLAS, TemporalSmith.getModIdAndName("entity/shield/aqumarine"))
    private val SHIELD_RAINBOW: Material =
        Material(InventoryMenu.BLOCK_ATLAS, TemporalSmith.getModIdAndName("entity/shield/rainbow"))
    private val SHIELD_SAPPHIRE: Material =
        Material(InventoryMenu.BLOCK_ATLAS, TemporalSmith.getModIdAndName("entity/shield/sapphire"))
    private val SHIELD_GRAPHITE: Material =
        Material(InventoryMenu.BLOCK_ATLAS, TemporalSmith.getModIdAndName("entity/shield/graphite"))

    private var shieldModel: ShieldModel? = null

    override fun onResourceManagerReload(manager: ResourceManager) {
        try {
            shieldModel = ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD))
        } catch (e: Exception) {
            TemporalSmith.logger.error("Failed to reload shield model", e)
        }
    }

    override fun renderByItem(
        stack: ItemStack,
        type: ItemDisplayContext,
        poseStack: PoseStack,
        buffer: MultiBufferSource,
        combinedLight: Int,
        combinedOverlay: Int
    ) {
        try {
            if (stack.item is ModShieldItem) {
                val isRuby = stack.`is`(ItemInit.RUBY_SHIELD.get())
                val isAqumarine = stack.`is`(ItemInit.AQUMARINE_SHIELD.get())
                val isRainbow = stack.`is`(ItemInit.RAINBOW_SHIELD.get())
                val isSapphire = stack.`is`(ItemInit.SAPPHIRE_SHIELD.get())
                val isGraphite = stack.`is`(ItemInit.GRAPHITE_SHIELD.get())

                poseStack.pushPose()
                poseStack.scale(1.0f, -1.0f, -1.0f)
                val material: Material =
                    if (isRuby) SHIELD_RUBY
                    else if (isAqumarine) SHIELD_AQUMARINE
                    else if (isRainbow) SHIELD_RAINBOW
                    else if (isSapphire) SHIELD_SAPPHIRE
                    else if (isGraphite) SHIELD_GRAPHITE else SHIELD_RUBY

                if (this.shieldModel == null) {
                    throw NullPointerException("Shield model is null")
                }

                val sprite = material.sprite()
                val vertexConsumer =
                    sprite.wrap(
                        ItemRenderer.getFoilBufferDirect(
                            buffer,
                            this.shieldModel!!.renderType(material.atlasLocation()),
                            true,
                            stack.hasFoil()))

                this.shieldModel!!
                    .handle()
                    .render(
                        poseStack,
                        vertexConsumer,
                        combinedLight,
                        combinedOverlay,
                        1.0f,
                        1.0f,
                        1.0f,
                        1.0f)
                this.shieldModel!!
                    .plate()
                    .render(
                        poseStack,
                        vertexConsumer,
                        combinedLight,
                        combinedOverlay,
                        1.0f,
                        1.0f,
                        1.0f,
                        1.0f)

                poseStack.popPose()
            }
        } catch (e: Exception) {
            TemporalSmith.logger.error("Failed to render shield", e)
        }
    }

    inline fun <T : TextureAtlasSprite?, R> T.use(block: (T) -> R): R {
        return block(this)
    }
}
