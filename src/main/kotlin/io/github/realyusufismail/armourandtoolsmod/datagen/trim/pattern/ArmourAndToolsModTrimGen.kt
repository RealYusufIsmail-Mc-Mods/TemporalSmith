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
package io.github.realyusufismail.armourandtoolsmod.datagen.trim.pattern

import com.mojang.serialization.JsonOps
import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import net.minecraft.data.PackOutput
import net.minecraft.server.packs.PackType
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.common.data.JsonCodecProvider

class ArmourAndToolsModTrimGen(val output : PackOutput,val fileHelper : ExistingFileHelper)
    : JsonCodecProvider<TrimGen>(output, fileHelper, ArmourAndToolsMod.MOD_ID, JsonOps.INSTANCE, PackType.CLIENT_RESOURCES,
        "trim_pattern", TrimGen.CODEC, mapOf()) {

}
