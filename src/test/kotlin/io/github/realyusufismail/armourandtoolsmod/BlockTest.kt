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
package io.github.realyusufismail.armourandtoolsmod

import io.github.realyusufismail.armourandtoolsmod.core.blocks.lit.LITBlock
import io.github.realyusufismail.armourandtoolsmod.core.blocks.lit.LitBlockParticleColour
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

class BlockTest {
    fun `attempt to create custom LitBlock Block`() {
        val customLitBlock =
            registerSpecialSmeltAbleBlock("custom_lit_block") {
                LITBlock(LitBlockParticleColour.RUBY_PARTICLE_COLOR)
            }

        assert(customLitBlock.get() is LITBlock) { "customLitBlock is not LITBlock" }
    }

    private fun registerSpecialSmeltAbleBlock(
        name: String,
        supplier: () -> Block
    ): ObjectHolderDelegate<Block> {

        val blockReg = BlockInit.BLOCKS.registerObject(name, supplier)
        ItemInit.ITEMS.registerObject(name) { BlockItem(blockReg.get(), Item.Properties()) }

        return blockReg
    }
}
