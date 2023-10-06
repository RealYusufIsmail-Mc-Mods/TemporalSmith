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
package io.github.realyusufismail.armourandtoolsmod.datagen.recipe.provider

import io.github.realyusufismail.armourandtoolsmod.blocks.infusion.book.IngotFusionTollEnhancerRecipeBookCategory
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.MainModRecipeProvider
import io.github.realyusufismail.armourandtoolsmod.datagen.recipe.builder.IngotFusionTollEnhancerRecipeBuilder
import java.util.function.Consumer
import net.minecraft.data.recipes.FinishedRecipe

class IngotFusionTollEnhancerRecipeProvider(
    private val mainModRecipeProvider: MainModRecipeProvider,
    private val pWriter: Consumer<FinishedRecipe>
) : MainModRecipeProvider(mainModRecipeProvider) {

    fun build() {
        IngotFusionTollEnhancerRecipeBuilder.builder(
                IngotFusionTollEnhancerRecipeBookCategory.TOOL,
                ItemInit.IMPERIUM.get(),
                ItemInit.IMPERIUM_PICKAXE.get(),
                ItemInit.IMPERIUM.get(),
                ItemInit.MAGMA_STRIKE_PICKAXE.get(),
                500,
                0.5f)
            .unlockedBy("has_imperium_ingot", has(ItemInit.IMPERIUM.get()))
            .save(pWriter, modId("magma_strike_pickaxe"))
    }
}
