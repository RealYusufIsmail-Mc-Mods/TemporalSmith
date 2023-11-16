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
package io.github.realyusufismail.temporalsmith.util

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.neoforged.neoforge.client.settings.KeyConflictContext
import org.lwjgl.glfw.GLFW

object KeyBinding {
    const val KEY_CATEGORY_ARMOUR_AND_TOOLS_MOD = "key.categories.temporalsmith"
    const val KEY_GET_MJOLNIR = "key.get_mjolnir"
    const val KEY_STRIKE_LIGHTNING = "key.strike_lightning"

    val GET_MJOLNIR =
        KeyMapping(
            KEY_GET_MJOLNIR,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_M,
            KEY_CATEGORY_ARMOUR_AND_TOOLS_MOD)

    val STRIKE_LIGHTNING =
        KeyMapping(
            KEY_STRIKE_LIGHTNING,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_Z,
            KEY_CATEGORY_ARMOUR_AND_TOOLS_MOD)
}
