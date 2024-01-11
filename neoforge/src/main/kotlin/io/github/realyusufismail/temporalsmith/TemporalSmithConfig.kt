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
package io.github.realyusufismail.temporalsmith

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.core.init.BlockInit
import net.neoforged.neoforge.common.ModConfigSpec
import org.apache.commons.lang3.tuple.Pair

object TemporalSmithConfig {

    class Common(builder: ModConfigSpec.Builder) {

        init {
            returnPortalFrameBlockId =
                builder
                    .comment("The block id of the return portal frame")
                    .translation("$MOD_ID.config.return_portal_frame_block_id")
                    .define("Return Portal Frame Block ID", BlockInit.ENDERITE_BLOCK.id.toString())

            builder.build()
        }

        companion object {
            @JvmField var returnPortalFrameBlockId: ModConfigSpec.ConfigValue<String>? = null
        }
    }

    val specPair: Pair<Common, ModConfigSpec> = ModConfigSpec.Builder().configure(::Common)

    val COMMON_SPEC: ModConfigSpec = specPair.right
}
