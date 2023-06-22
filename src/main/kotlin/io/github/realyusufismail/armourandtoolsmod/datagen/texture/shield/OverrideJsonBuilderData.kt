package io.github.realyusufismail.armourandtoolsmod.datagen.texture.shield

import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode

class OverrideJsonBuilder {
    private val overrideObjectNode: ObjectNode = JsonNodeFactory.instance.objectNode()

    fun predicate(builder: PredicateJsonBuilderData): OverrideJsonBuilder {
        val json = builder.json
        overrideObjectNode.set<ObjectNode>("predicate", json)
        return this
    }

    fun model(name : String) : OverrideJsonBuilder {
        overrideObjectNode.put("model", name)
        return this
    }
}

data class OverrideJsonBuilderData(val json: ObjectNode)