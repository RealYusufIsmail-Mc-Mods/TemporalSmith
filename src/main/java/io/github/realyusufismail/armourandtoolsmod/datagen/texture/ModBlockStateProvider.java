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
package io.github.realyusufismail.armourandtoolsmod.datagen.texture;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.MOD_ID;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return "Armour and Tools Mod Blockstates";
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlock(BlockInit.RUBY_ORE.get());
        normalBlock(BlockInit.RAINBOW_ORE.get());
        normalBlock(BlockInit.SAPPHIRE_ORE.get());
        normalBlock(BlockInit.GRAPHITE_ORE.get());
        normalBlock(BlockInit.AQUMARINE_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_RUBY_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_RAINBOW_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_GRAPHITE_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_AQUMARINE_ORE.get());
        normalBlock(BlockInit.RUBY_BLOCK.get());
        normalBlock(BlockInit.RAINBOW_BLOCK.get());
        normalBlock(BlockInit.SAPPHIRE_BLOCK.get());
        normalBlock(BlockInit.GRAPHITE_BLOCK.get());
        normalBlock(BlockInit.AQUMARINE_BLOCK.get());
    }

    public void normalBlock(Block block) {
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);

        if (name == null) {
            ArmourAndToolsMod.logger.error("Could not find block key for " + block.getName());
            return;
        }

        String path = name.getPath();

        BlockModelBuilder builder = models().cubeAll(path, modLoc("block/" + path));
        getVariantBuilder(block)
            .forAllStates(state -> ConfiguredModel.builder().modelFile(builder).build());
    }
}
