package io.github.realyusufismail.armourandtoolsmod.datagen.texture.shield

import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode

class PredicateJsonBuilder {
    private val predicateObjectNode: ObjectNode = JsonNodeFactory.instance.objectNode()

    fun setBlocking(blocking: Int): PredicateJsonBuilder {
        predicateObjectNode.put("blocking", blocking)
        return this
    }

    fun build(): PredicateJsonBuilderData {
        return PredicateJsonBuilderData(predicateObjectNode)
    }
}

data class PredicateJsonBuilderData(val json: ObjectNode)