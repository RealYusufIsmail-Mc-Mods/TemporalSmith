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
package io.github.realyusufismail.temporalsmith.lit;

import io.github.realyusufismail.temporalsmith.TemporalSmith;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.ToIntFunction;
import lombok.val;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * A block that emits light when stepped on.
 *
 * @see net.minecraft.block.RedstoneOreBlock
 */
@SuppressWarnings("deprecation")
public class LITBlock extends Block {
  public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
  public static Map<Class, List<LitBlockParticleColour>> particleColours = new HashMap<>();

  protected LITBlock(
      List<LitBlockParticleColour> particleColour, int lightLevel, Class blockClass) {
    super(
        Properties.of(Material.METAL)
            .requiresCorrectToolForDrops()
            .randomTicks()
            .lightLevel(litBlockEmission(lightLevel))
            .strength(3.0f, 3.0f));

    particleColours.put(blockClass, particleColour);
    this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.FALSE));
  }

  private static void interact(BlockState pState, World pLevel, BlockPos pPos) {
    spawnParticles(pLevel, pPos);
    if (!pState.getValue(LIT)) {
      pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.valueOf(true)), 3);
    }
  }

  protected static void spawnParticles(World pLevel, BlockPos pPos) {
    Random randomsource = pLevel.random;

    for (Direction direction : Direction.values()) {
      BlockPos blockpos = pPos.relative(direction);
      if (!pLevel.getBlockState(blockpos).isSolidRender(pLevel, blockpos)) {
        Direction.Axis direction$axis = direction.getAxis();
        double d1 =
            direction$axis == Direction.Axis.X
                ? 0.5D + 0.5625D * (double) direction.getStepX()
                : (double) randomsource.nextFloat();
        double d2 =
            direction$axis == Direction.Axis.Y
                ? 0.5D + 0.5625D * (double) direction.getStepY()
                : (double) randomsource.nextFloat();
        double d3 =
            direction$axis == Direction.Axis.Z
                ? 0.5D + 0.5625D * (double) direction.getStepZ()
                : (double) randomsource.nextFloat();

        val block = pLevel.getBlockState(pPos).getBlock();
        val particleColours = LITBlock.particleColours.get(block.getClass());
        val colour = particleColours.get(randomsource.nextInt(particleColours.size()));
        TemporalSmith.TemporalSmith.getLogger()
            .debug(
                "Colour: "
                    + colour
                    + "for block: "
                    + block.getClass().getName()
                    + " at pos: "
                    + pPos
                    + " with particleColours: "
                    + particleColours);
        pLevel.addParticle(
            colour.getParticleOption(),
            (double) pPos.getX() + d1,
            (double) pPos.getY() + d2,
            (double) pPos.getZ() + d3,
            0.0D,
            0.0D,
            0.0D);
      }
    }
  }

  private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
    return (p_50763_) -> {
      return p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    };
  }

  public void attack(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer) {
    interact(pState, pLevel, pPos);
    super.attack(pState, pLevel, pPos, pPlayer);
  }

  public void stepOn(World pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
    if (!pEntity.isSteppingCarefully()) {
      interact(pState, pLevel, pPos);
    }

    super.stepOn(pLevel, pPos, pEntity);
  }

  public ActionResultType use(
      BlockState pState,
      World pLevel,
      BlockPos pPos,
      PlayerEntity pPlayer,
      Hand pHand,
      BlockRayTraceResult pHit) {
    if (pLevel.isClientSide) {
      spawnParticles(pLevel, pPos);
    } else {
      interact(pState, pLevel, pPos);
    }

    ItemStack itemstack = pPlayer.getItemInHand(pHand);
    return itemstack.getItem() instanceof BlockItem
            && (new BlockItemUseContext(pPlayer, pHand, itemstack, pHit)).canPlace()
        ? ActionResultType.PASS
        : ActionResultType.SUCCESS;
  }

  /**
   * @return whether this block needs random ticking.
   */
  public boolean isRandomlyTicking(BlockState pState) {
    return pState.getValue(LIT);
  }

  /** Performs a random tick on a block. */
  public void randomTick(BlockState pState, ServerWorld pLevel, BlockPos pPos, Random pRandom) {
    if (pState.getValue(LIT)) {
      pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.FALSE), 3);
    }
  }

  /** Perform side-effects from block dropping, such as creating silverfish */
  public void spawnAfterBreak(
      BlockState pState, ServerWorld pLevel, BlockPos pPos, ItemStack pStack) {
    super.spawnAfterBreak(pState, pLevel, pPos, pStack);
  }

  @Override
  public int getExpDrop(
      BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
    return silktouch == 0 ? 1 + this.RANDOM.nextInt(5) : 0;
  }

  /**
   * Called periodically clientside on blocks near the player to show effects (like furnace fire
   * particles).
   */
  public void animateTick(BlockState pState, World pLevel, BlockPos pPos, Random pRandom) {
    if (pState.getValue(LIT)) {
      spawnParticles(pLevel, pPos);
    }
  }

  protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
    pBuilder.add(LIT);
  }
}
