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
package io.github.realyusufismail.armourandtoolsmod.core.blocks

import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.realyusufismailcore.core.init.GeneralBlock
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.particles.DustParticleOptions
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.RedstoneTorchBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.level.material.Material
import net.minecraft.world.phys.BlockHitResult

/**
 * A block that emits light when stepped on.
 *
 * @see net.minecraft.world.level.block.RedStoneOreBlock
 */
class LITBlock :
    GeneralBlock(
        Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .randomTicks()
            .lightLevel(BlockInit.litBlockEmission(11))
            .strength(3.0f, 3.0f)) {
    private val lit: BooleanProperty = RedstoneTorchBlock.LIT

    init {
        try {
            registerDefaultState(
                defaultBlockState().setValue(lit, java.lang.Boolean.valueOf(false)))
        } catch (e: Exception) {
           throw IllegalStateException("Failed to register default state for LITBlock", e)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun attack(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player) {
        interact(pState, pLevel, pPos)
        super.attack(pState, pLevel, pPos, pPlayer)
    }

    override fun stepOn(pLevel: Level, pPos: BlockPos, pState: BlockState, pEntity: Entity) {
        if (!pEntity.isSteppingCarefully) {
            interact(pState, pLevel, pPos)
        }
        super.stepOn(pLevel, pPos, pState, pEntity)
    }

    @Deprecated("Deprecated in Java")
    override fun use(
        pState: BlockState,
        pLevel: Level,
        pPos: BlockPos,
        pPlayer: Player,
        pHand: InteractionHand,
        pHit: BlockHitResult
    ): InteractionResult {
        if (pLevel.isClientSide) {
            spawnParticles(pLevel, pPos)
        } else {
            interact(pState, pLevel, pPos)
        }
        val itemstack = pPlayer.getItemInHand(pHand)
        return if (itemstack.item is BlockItem &&
            BlockPlaceContext(pPlayer, pHand, itemstack, pHit).canPlace())
            InteractionResult.PASS
        else InteractionResult.SUCCESS
    }

    private fun interact(pState: BlockState, pLevel: Level, pPos: BlockPos) {
        spawnParticles(pLevel, pPos)
        if (!pState.getValue(lit)) {
            pLevel.setBlock(pPos, pState.setValue(lit, java.lang.Boolean.valueOf(true)), 3)
        }
    }

    /** @return whether this block needs random ticking. */
    override fun isRandomlyTicking(pState: BlockState): Boolean {
        return pState.getValue(lit)
    }

    /** Performs a random tick on a block. */
    @Deprecated("Deprecated in Java")
    override fun randomTick(
        pState: BlockState,
        pLevel: ServerLevel,
        pPos: BlockPos,
        pRandom: RandomSource
    ) {
        if (pState.getValue(lit)) {
            pLevel.setBlock(pPos, pState.setValue(lit, java.lang.Boolean.valueOf(false)), 3)
        }
    }

    /** Perform side-effects from block dropping, such as creating silverfish */
    @Deprecated(
        "Deprecated in Java",
        ReplaceWith(
            "super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience)",
            "net.minecraft.world.level.block.Block"))
    override fun spawnAfterBreak(
        pState: BlockState,
        pLevel: ServerLevel,
        pPos: BlockPos,
        pStack: ItemStack,
        pDropExperience: Boolean
    ) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience)
    }

    override fun getExpDrop(
        state: BlockState,
        world: LevelReader,
        randomSource: RandomSource,
        pos: BlockPos?,
        fortune: Int,
        silktouch: Int,
    ): Int {
        return if (silktouch == 0) 1 + randomSource.nextInt(5) else 0
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire
     * particles).
     */
    override fun animateTick(
        pState: BlockState,
        pLevel: Level,
        pPos: BlockPos,
        pRandom: RandomSource
    ) {
        if (pState.getValue(lit)) {
            spawnParticles(pLevel, pPos)
        }
    }

    private fun spawnParticles(pLevel: Level, pPos: BlockPos) {
        val d0 = 0.5625
        val randomsource = pLevel.random
        for (direction in Direction.values()) {
            val blockpos = pPos.relative(direction)
            if (!pLevel.getBlockState(blockpos).isSolidRender(pLevel, blockpos)) {
                val `direction$axis` = direction.axis
                val d1 =
                    if (`direction$axis` === Direction.Axis.X)
                        0.5 + 0.5625 * direction.stepX.toDouble()
                    else randomsource.nextFloat().toDouble()
                val d2 =
                    if (`direction$axis` === Direction.Axis.Y)
                        0.5 + 0.5625 * direction.stepY.toDouble()
                    else randomsource.nextFloat().toDouble()
                val d3 =
                    if (`direction$axis` === Direction.Axis.Z)
                        0.5 + 0.5625 * direction.stepZ.toDouble()
                    else randomsource.nextFloat().toDouble()
                pLevel.addParticle(
                    DustParticleOptions.REDSTONE,
                    pPos.x.toDouble() + d1,
                    pPos.y.toDouble() + d2,
                    pPos.z.toDouble() + d3,
                    0.0,
                    0.0,
                    0.0)
            }
        }
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        if (lit == null) {
            this.registerDefaultState(
                this.defaultBlockState().setValue(lit, java.lang.Boolean.valueOf(false)))

            createBlockStateDefinition(pBuilder)
        } else {
            pBuilder.add(lit)
        }
    }
}
