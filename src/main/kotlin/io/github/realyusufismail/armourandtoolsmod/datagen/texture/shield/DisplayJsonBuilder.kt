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

class DisplayJsonBuilder {
    private val displayObjectNode: ObjectNode = JsonNodeFactory.instance.objectNode()

    /** Use [TransformJsonBuilder] to create the json for this */
    fun transform(builder: TransformJsonBuilderData): DisplayJsonBuilder {
        val rotationType = builder.rotationType
        val json = builder.json
        displayObjectNode.set<ObjectNode>(rotationType.rotationType, json)
        return this
    }

    fun build(): DisplayJsonBuilderData {
        return DisplayJsonBuilderData(displayObjectNode)
    }
}

data class DisplayJsonBuilderData(val json: ObjectNode)
