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

class TransformJsonBuilder(private val rotationType: RotationType) {
    private val objectNode: ObjectNode = JsonNodeFactory.instance.objectNode()

    fun setRotation(x: Float, y: Float, z: Float): TransformJsonBuilder {
        objectNode.putArray("rotation").add(x).add(y).add(z)
        return this
    }

    fun setTranslation(x: Float, y: Float, z: Float): TransformJsonBuilder {
        objectNode.putArray("translation").add(x).add(y).add(z)
        return this
    }

    fun setScale(x: Float, y: Float, z: Float): TransformJsonBuilder {
        objectNode.putArray("scale").add(x).add(y).add(z)
        return this
    }

    fun build(): TransformJsonBuilderData {
        return TransformJsonBuilderData(rotationType, objectNode)
    }
}

data class TransformJsonBuilderData(val rotationType: RotationType, val json: ObjectNode)

enum class RotationType(val rotationType: String) {
    NONE("NONE"),
    THIRD_PERSON_LEFT_HAND("thirdperson_righthand"),
    THIRD_PERSON_RIGHT_HAND("thirdperson_lefthand"),
    FIRST_PERSON_LEFT_HAND("firstperson_righthand"),
    FIRST_PERSON_RIGHT_HAND("firstperson_lefthand"),
    HEAD("head"),
    GUI("gui"),
    GROUND("ground"),
    FIXED("fixed")
}
