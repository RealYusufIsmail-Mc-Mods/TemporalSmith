package io.github.realyusufismail.armourandtoolsmod.datagen.loot;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // blocks
        dropSelf(BlockInit.RUBY_BLOCK.get());
        dropSelf(BlockInit.RAINBOW_BLOCK.get());
        dropSelf(BlockInit.SAPPHIRE_BLOCK.get());
        dropSelf(BlockInit.GRAPHITE_BLOCK.get());
        dropSelf(BlockInit.AQUMARINE_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues()
            .stream()
            .filter(entry -> Optional.ofNullable(ForgeRegistries.BLOCKS.getKey(entry))
                .filter(key -> key.getNamespace().equals(ArmourAndToolsMod.MOD_ID))
                .isPresent())
            .collect(Collectors.toSet());
    }
}
