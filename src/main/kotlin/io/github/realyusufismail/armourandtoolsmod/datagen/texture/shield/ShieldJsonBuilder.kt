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
package io.github.realyusufismail.armourandtoolsmod.datagen.texture.shield

import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode
import io.github.realyusufismail.armourandtoolsmod.MOD_ID
import net.minecraft.client.renderer.block.model.BlockModel
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import java.io.File

class ShieldJsonBuilder(block: Block, item: Item) {
    private val objectNode: ObjectNode = JsonNodeFactory.instance.objectNode()

    fun setParent(parent: String): ShieldJsonBuilder {
        objectNode.put("parent", parent)
        return this
    }

    fun setGuiLight(guiLight: BlockModel.GuiLight): ShieldJsonBuilder {
        objectNode.put("gui_light", guiLight.serializedName)
        return this
    }

    fun setTexture(key: String, value: String): ShieldJsonBuilder {
        objectNode.put(key, value)
        return this
    }

    /**
     * Use [DisplayJsonBuilder] to build the display object
     */
    fun setDisplay(display : DisplayJsonBuilderData) : ShieldJsonBuilder {
        objectNode.set<ObjectNode>("display", display.json)
        return this
    }

    /**
     * Use [OverrideJsonBuilder] to build the overrides array
     */
    fun setOverrides(overrides : List<OverrideJsonBuilderData>) : ShieldJsonBuilder {
        val arrayNode = JsonNodeFactory.instance.arrayNode()
        for (override in overrides) {
            arrayNode.add(override.json)
        }
        objectNode.set<ObjectNode>("overrides", arrayNode)
        return this
    }

    fun toJson(): String {
        return objectNode.toString()
    }

    fun build(dataGenLocation : String) {
        val json = toJson()
        val path = File(dataGenLocation)
        if (!path.exists()) {
            path.mkdirs()
        }
        val file = File(path, "models/item/shield.json")
        file.writeText(json)
    }
}
