package io.github.realyusufismail.armourandtoolsmod.core.blocks.lit;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

/**
 * A block that emits light when stepped on.
 *
 * @see net.minecraft.world.level.block.RedStoneOreBlock
 */
@SuppressWarnings("deprecation")
public class LITBlock extends Block {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public static Map<Class, List<LitBlockParticleColour>> particleColours = new HashMap<>();

    protected LITBlock(List<LitBlockParticleColour> particleColour, int lightLevel, Class blockClass) {
        super(Properties.of(Material.STONE)
                .requiresCorrectToolForDrops()
                .randomTicks()
                .lightLevel(litBlockEmission(lightLevel))
                .strength(3.0f, 3.0f));

        particleColours.put(blockClass, particleColour);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.FALSE));
    }

    private static void interact(BlockState pState, Level pLevel, BlockPos pPos) {
        spawnParticles(pLevel, pPos);
        if (!pState.getValue(LIT)) {
            pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.valueOf(true)), 3);
        }
    }

    protected static void spawnParticles(Level pLevel, BlockPos pPos) {
        RandomSource randomsource = pLevel.random;

        for (Direction direction : Direction.values()) {
            BlockPos blockpos = pPos.relative(direction);
            if (!pLevel.getBlockState(blockpos).isSolidRender(pLevel, blockpos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double) direction.getStepX() : (double) randomsource.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double) direction.getStepY() : (double) randomsource.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double) direction.getStepZ() : (double) randomsource.nextFloat();

                var block = pLevel.getBlockState(pPos).getBlock();
                var particleColours = LITBlock.particleColours.get(block.getClass());
                var colour = particleColours.get(randomsource.nextInt(particleColours.size()));
                ArmourAndToolsMod.ArmorAndToolsMod.getLogger().debug("Colour: " + colour + "for block: " + block.getClass().getName() + " at pos: " + pPos + " with particleColours: " + particleColours);
                pLevel.addParticle(colour.getParticleOption(), (double) pPos.getX() + d1, (double) pPos.getY() + d2, (double) pPos.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }

    public void attack(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        interact(pState, pLevel, pPos);
        super.attack(pState, pLevel, pPos, pPlayer);
    }

    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pEntity.isSteppingCarefully()) {
            interact(pState, pLevel, pPos);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            spawnParticles(pLevel, pPos);
        } else {
            interact(pState, pLevel, pPos);
        }

        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        return itemstack.getItem() instanceof BlockItem && (new BlockPlaceContext(pPlayer, pHand, itemstack, pHit)).canPlace() ? InteractionResult.PASS : InteractionResult.SUCCESS;
    }

    /**
     * @return whether this block needs random ticking.
     */
    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(LIT);
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.valueOf(false)), 3);
        }

    }

    /**
     * Perform side-effects from block dropping, such as creating silverfish
     */
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? 1 + randomSource.nextInt(5) : 0;
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
     */
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            spawnParticles(pLevel, pPos);
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }
}
