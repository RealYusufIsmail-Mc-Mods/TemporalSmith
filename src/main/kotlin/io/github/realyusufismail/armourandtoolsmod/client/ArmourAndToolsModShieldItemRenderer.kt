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
package io.github.realyusufismail.armourandtoolsmod.client

import com.mojang.blaze3d.vertex.PoseStack
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.shields.*
import net.minecraft.client.Minecraft
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

class ArmourAndToolsModShieldItemRenderer : ArmourAndToolsModBlockEntityWithoutLevelRenderer() {
    private val SHIELD_RUBY: Material =
        Material(InventoryMenu.BLOCK_ATLAS, ArmourAndToolsMod.getPath("entity/shield/ruby"))
    private val SHIELD_AQUMARINE: Material =
        Material(InventoryMenu.BLOCK_ATLAS, ArmourAndToolsMod.getPath("entity/shield/aqumarine"))
    private val SHIELD_RAINBOW: Material =
        Material(InventoryMenu.BLOCK_ATLAS, ArmourAndToolsMod.getPath("entity/shield/rainbow"))
    private val SHIELD_SAPPHIRE: Material =
        Material(InventoryMenu.BLOCK_ATLAS, ArmourAndToolsMod.getPath("entity/shield/sapphire"))
    private val SHIELD_GRAPHITE: Material =
        Material(InventoryMenu.BLOCK_ATLAS, ArmourAndToolsMod.getPath("entity/shield/graphite"))

    private var shieldModel: ShieldModel? = null

    override fun onResourceManagerReload(manager: ResourceManager) {
        shieldModel =
            ShieldModel(Minecraft.getInstance().entityModels.bakeLayer(ModelLayers.SHIELD))
    }

    override fun renderByItem(
        stack: ItemStack,
        type: ItemDisplayContext,
        poseStack: PoseStack,
        buffer: MultiBufferSource,
        combinedLight: Int,
        combinedOverlay: Int
    ) {
        if (stack.item is ArmourToolsModShieldItem) {
            val isRuby = stack.item == ItemInit.RUBY_SHIELD
            val isAqumarine = stack.item == ItemInit.AQUMARINE_SHIELD
            val isRainbow = stack.item == ItemInit.RAINBOW_SHIELD
            val isSapphire = stack.item == ItemInit.SAPPHIRE_SHIELD
            val isGraphite = stack.item == ItemInit.GRAPHITE_SHIELD

            poseStack.pushPose()
            poseStack.scale(1.0f, -1.0f, -1.0f)
            val material: Material =
                if (isRuby) SHIELD_RUBY
                else if (isAqumarine) SHIELD_AQUMARINE
                else if (isRainbow) SHIELD_RAINBOW
                else if (isSapphire) SHIELD_SAPPHIRE else SHIELD_GRAPHITE
            material.sprite().use { sprite ->
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
                        1.0F,
                        1.0F,
                        1.0F,
                        1.0F)
                this.shieldModel!!
                    .plate()
                    .render(
                        poseStack,
                        vertexConsumer,
                        combinedLight,
                        combinedOverlay,
                        1.0F,
                        1.0F,
                        1.0F,
                        1.0F)
            }
            poseStack.popPose()
        }
    }

    inline fun <T : TextureAtlasSprite?, R> T.use(block: (T) -> R): R {
        return block(this)
    }
}
