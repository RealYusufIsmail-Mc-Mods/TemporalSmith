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
package io.github.realyusufismail.temporalsmith.blocks;

import com.mojang.serialization.MapCodec;
import io.github.realyusufismail.temporalsmith.blocks.infusion.IngotFusionTollEnhancerBlockEntity;
import io.github.realyusufismail.temporalsmith.core.init.BlockEntityTypeInit;
import java.util.List;
import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @see FurnaceBlock
 */
public class IngotFusionTollEnhancer extends BaseEntityBlock {
  public static final BooleanProperty LIT = BlockStateProperties.LIT;
  private static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

  public IngotFusionTollEnhancer(Properties properties) {
    super(properties);
    this.registerDefaultState(
        defaultBlockState().setValue(FACING, Direction.NORTH).setValue(LIT, false));
  }

  public IngotFusionTollEnhancer() {
    this(Properties.of().strength(5.0F, 6.0F).sound(SoundType.METAL).mapColor(MapColor.DIAMOND));
  }

  public static @NotNull Component getContainerTitle() {
    return Component.translatable("container.ingot_fusion_toll_enhancer");
  }

  public static Component getContainerDescription() {
    return Component.translatable("container.ingot_fusion_toll_enhancer.description");
  }

  @Override
  public @NotNull InteractionResult use(
      @NotNull BlockState blockState,
      @NotNull Level level,
      @NotNull BlockPos blockPos,
      @NotNull Player player,
      @NotNull InteractionHand interactionHand,
      @NotNull BlockHitResult blockHitResult) {
    if (!level.isClientSide) {
      BlockEntity blockEntity = level.getBlockEntity(blockPos);
      if (blockEntity instanceof IngotFusionTollEnhancerBlockEntity) {
        try {
          Objects.requireNonNull(player, "Player is null");
          Objects.requireNonNull(blockEntity, "BlockEntity is null");

          player.openMenu((IngotFusionTollEnhancerBlockEntity) blockEntity, blockPos);
        } catch (Exception e) {
          throw new RuntimeException("Failed to open screen." + e);
        }
      }
    }
    return InteractionResult.sidedSuccess(level.isClientSide);
  }

  @Override
  public void onRemove(
      BlockState oldState,
      Level level,
      BlockPos blockPos,
      BlockState newState,
      boolean movedByPiston) {
    if (!oldState.is(newState.getBlock())) {
      BlockEntity blockEntity = level.getBlockEntity(blockPos);
      if (blockEntity instanceof IngotFusionTollEnhancerBlockEntity) {
        if (level instanceof ServerLevel) {
          Containers.dropContents(level, blockPos, (Container) blockEntity);
          level.updateNeighbourForOutputSignal(blockPos, this);
        }
        level.updateNeighbourForOutputSignal(blockPos, this);
      }
      super.onRemove(oldState, level, blockPos, newState, movedByPiston);
    }
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new IngotFusionTollEnhancerBlockEntity(pPos, pState);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState()
        .setValue(FACING, context.getHorizontalDirection().getOpposite());
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING, LIT);
  }

  @Override
  public boolean hasDynamicShape() {
    return true;
  }

  /**
   * @deprecated call via {@link BlockStateBase#hasAnalogOutputSignal} whenever possible.
   *     Implementing/overriding is fine.
   */
  @Override
  public boolean hasAnalogOutputSignal(BlockState pState) {
    return true;
  }

  @Override
  protected MapCodec<? extends BaseEntityBlock> codec() {
    return simpleCodec(IngotFusionTollEnhancer::new);
  }

  /**
   * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED
   * for TESR-only, LIQUID for vanilla liquids, INVISIBLE to skip all rendering
   *
   * @deprecated call via {@link BlockStateBase#getRenderShape} whenever possible.
   *     Implementing/overriding is fine.
   */
  public @NotNull RenderShape getRenderShape(BlockState pState) {
    return RenderShape.MODEL;
  }

  /**
   * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable,
   * returns the passed blockstate.
   *
   * @deprecated call via {@link BlockStateBase#rotate} whenever possible. Implementing/overriding
   *     is fine.
   */
  @Override
  public BlockState rotate(BlockState pState, Rotation pRotation) {
    return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
  }

  /**
   * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns
   * the passed blockstate.
   *
   * @deprecated call via {@link BlockStateBase#mirror} whenever possible. Implementing/overriding
   *     is fine.
   */
  @Override
  public @NotNull BlockState mirror(BlockState pState, Mirror pMirror) {
    return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
  }

  @Override
  public void appendHoverText(
      ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
    pTooltip.add(getContainerDescription());
  }

  @Nullable
  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level level, BlockState state, BlockEntityType<T> type) {
    return level.isClientSide
        ? null
        : createTickerHelper(
            type,
            BlockEntityTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(),
            IngotFusionTollEnhancerBlockEntity::serverTick);
  }
}
