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
package io.github.realyusufismail.armourandtoolsmod.blocks.infusion

import com.google.common.collect.Maps
import io.github.realyusufismail.armourandtoolsmod.blocks.IngotFusionTollEnhancer
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockEntityTypeInit
import io.github.realyusufismail.armourandtoolsmod.core.init.BlockInit
import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeTypeInit
import io.github.realyusufismail.armourandtoolsmod.recipe.fusion.IngotFusionTollEnhancerRecipe
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap
import kotlin.properties.Delegates
import net.minecraft.SharedConstants
import net.minecraft.Util
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.util.Mth
import net.minecraft.world.Container
import net.minecraft.world.ContainerHelper
import net.minecraft.world.WorldlyContainer
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.player.StackedContents
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.ContainerData
import net.minecraft.world.inventory.RecipeHolder
import net.minecraft.world.inventory.StackedContentsCompatible
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.item.crafting.RecipeManager
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.common.ForgeHooks

/** @see net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity */
class IngotFusionTollEnhancerBlockEntity(pPos: BlockPos, pBlockState: BlockState) :
    BaseContainerBlockEntity(
        BlockEntityTypeInit.INGOT_FUSION_TOLL_ENHANCER.get(), pPos, pBlockState),
    WorldlyContainer,
    RecipeHolder,
    StackedContentsCompatible {
    private var items = NonNullList.withSize(NUMBER_OF_SLOTS, ItemStack.EMPTY)
    // TODO: Check these and fix them
    private var quickCheck:
        RecipeManager.CachedCheck<Container, out IngotFusionTollEnhancerRecipe>? =
        null
    private val recipesUsed = Object2IntOpenHashMap<ResourceLocation>()
    private val SLOTS_FOR_UP = intArrayOf(0)
    private val SLOTS_FOR_DOWN = intArrayOf(2, 1)
    private val SLOTS_FOR_SIDES = intArrayOf(1)
    var litTime by Delegates.notNull<Int>()
    var litDuration by Delegates.notNull<Int>()
    var creatingTime by Delegates.notNull<Int>()
    var creatingTotalTime by Delegates.notNull<Int>()

    private val dataAccess: ContainerData =
        object : ContainerData {
            override fun get(pIndex: Int): Int {
                return when (pIndex) {
                    0 -> litTime
                    1 -> litDuration
                    2 -> creatingTime
                    3 -> creatingTotalTime
                    else ->
                        throw ArrayIndexOutOfBoundsException("ContainerData index out of bounds")
                }
            }

            override fun set(pIndex: Int, pValue: Int) {
                when (pIndex) {
                    0 -> litTime = pValue
                    1 -> litDuration = pValue
                    2 -> creatingTime = pValue
                    3 -> creatingTotalTime = pValue
                    else ->
                        throw ArrayIndexOutOfBoundsException("ContainerData index out of bounds")
                }
            }

            override fun getCount(): Int {
                return 4
            }
        }

    private fun isLit(): Boolean {
        return litTime > 0
    }

    override fun load(pTag: CompoundTag) {
        super.load(pTag)
        items = NonNullList.withSize(this.containerSize, ItemStack.EMPTY)
        ContainerHelper.loadAllItems(pTag, items)
        this.litTime = pTag.getInt("LitTime")
        this.creatingTime = pTag.getInt("CreatingTime")
        this.creatingTotalTime = pTag.getInt("CreatingTotalTime")

        val compoundtag = pTag.getCompound("RecipesUsed")

        for (s in compoundtag.allKeys) {
            recipesUsed.put(ResourceLocation(s), compoundtag.getInt(s))
        }
    }

    override fun saveAdditional(pTag: CompoundTag) {
        super.saveAdditional(pTag)
        pTag.putInt("BurnTime", litTime)
        pTag.putInt("CreatingTime", this.creatingTime)
        pTag.putInt("CreatingTotalTime", this.creatingTotalTime)
        ContainerHelper.saveAllItems(pTag, items)
        val compoundtag = CompoundTag()
        recipesUsed.forEach { (p_187449_: ResourceLocation, p_187450_: Int?) ->
            compoundtag.putInt(p_187449_.toString(), p_187450_!!)
        }
        pTag.put("RecipesUsed", compoundtag)
    }

    /** Returns the number of slots in the inventory. */
    override fun getContainerSize(): Int {
        return items.size
    }

    override fun clearContent() {
        items.clear()
    }

    override fun isEmpty(): Boolean {
        for (itemstack in items) {
            if (!itemstack.isEmpty) {
                return false
            }
        }

        return true
    }

    /** Returns the stack in the given slot. */
    override fun getItem(pSlot: Int): ItemStack {
        return items[pSlot]
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new
     * stack.
     */
    override fun removeItem(pSlot: Int, pAmount: Int): ItemStack {
        return ContainerHelper.removeItem(items, pSlot, pAmount)
    }

    /** Removes a stack from the given slot and returns it. */
    override fun removeItemNoUpdate(pSlot: Int): ItemStack {
        return ContainerHelper.takeItem(items, pSlot)
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor
     * sections).
     */
    override fun setItem(pSlot: Int, pStack: ItemStack) {
        val itemstack = items[pSlot]
        val flag = !pStack.isEmpty && ItemStack.isSameItemSameTags(itemstack, pStack)
        items[pSlot] = pStack
        if (pStack.count > this.maxStackSize) {
            pStack.count = this.maxStackSize
        }

        if (pSlot == 0 && !flag) {
            this.creatingTotalTime = getTotalCraftTime(level!!, this)
            this.creatingTime = this.creatingTotalTime
            this.setChanged()
        }
    }

    /** Don't rename this method to canInteractWith due to conflicts with Container */
    override fun stillValid(pPlayer: Player): Boolean {
        return Container.stillValidBlockEntity(this, pPlayer)
    }

    override fun getSlotsForFace(pSide: Direction): IntArray {
        return if (pSide == Direction.DOWN) {
            SLOTS_FOR_DOWN
        } else {
            if (pSide == Direction.UP) SLOTS_FOR_UP else SLOTS_FOR_SIDES
        }
    }

    /**
     * Returns `true` if automation can insert the given item in the given slot from the given side.
     */
    override fun canPlaceItemThroughFace(
        pIndex: Int,
        pItemStack: ItemStack,
        pDirection: Direction?
    ): Boolean {
        return this.canPlaceItem(pIndex, pItemStack)
    }

    /**
     * Returns `true` if automation can extract the given item in the given slot from the given
     * side.
     */
    override fun canTakeItemThroughFace(
        pIndex: Int,
        pStack: ItemStack,
        pDirection: Direction
    ): Boolean {
        return if (pDirection == Direction.DOWN && pIndex == 1) {
            pStack.`is`(Items.WATER_BUCKET) || pStack.`is`(Items.BUCKET)
        } else {
            true
        }
    }

    override fun createMenu(pContainerId: Int, pInventory: Inventory): AbstractContainerMenu {
        return IngotFusionTollEnhancerMenu(pContainerId, this, dataAccess, pInventory)
    }

    override fun getDefaultName(): Component {
        return IngotFusionTollEnhancer.getContainerTitle()
    }

    override fun setRecipeUsed(pRecipe: Recipe<*>?) {
        if (pRecipe != null) {
            val resourcelocation = pRecipe.id
            this.recipesUsed.addTo(resourcelocation, 1)
        }
    }

    override fun getRecipeUsed(): Recipe<*>? {
        return null
    }

    override fun fillStackedContents(pContents: StackedContents) {
        for (itemstack in items) {
            pContents.accountStack(itemstack)
        }
    }

    companion object {
        const val NUMBER_OF_SLOTS = 5

        fun serverTick(
            level: Level,
            pPos: BlockPos,
            pState: BlockState,
            pEntity: IngotFusionTollEnhancerBlockEntity
        ) {
            val flag: Boolean = pEntity.isLit()
            var flag1 = false
            if (pEntity.isLit()) {
                --pEntity.litTime
            }

            val itemstack: ItemStack = pEntity.items[1]
            val flag2: Boolean = !pEntity.items[0].isEmpty
            val flag3 = !itemstack.isEmpty
            if (pEntity.isLit() || flag3 && flag2) {
                val recipe: Recipe<*>? =
                    if (flag2) {
                        pEntity.quickCheck?.getRecipeFor(pEntity, level)?.orElse(null)
                    } else {
                        null
                    }

                val i: Int = pEntity.maxStackSize
                if (!pEntity.isLit() &&
                    pEntity.canCreate(level.registryAccess(), recipe, pEntity.items, i)) {
                    pEntity.litTime = pEntity.getTotalCraftTime(itemstack)
                    pEntity.litDuration = pEntity.litTime
                    if (pEntity.isLit()) {
                        flag1 = true
                        if (itemstack.hasCraftingRemainingItem())
                            pEntity.items[1] = itemstack.craftingRemainingItem
                        else if (flag3) {
                            val item = itemstack.item
                            itemstack.shrink(1)
                            if (itemstack.isEmpty) {
                                pEntity.items[1] = itemstack.craftingRemainingItem
                            }
                        }
                    }
                }
                if (pEntity.isLit() &&
                    pEntity.canCreate(level.registryAccess(), recipe, pEntity.items, i)) {
                    ++pEntity.creatingTime
                    if (pEntity.creatingTime == pEntity.creatingTotalTime) {
                        pEntity.creatingTime = 0
                        pEntity.creatingTotalTime = getTotalCraftTime(level, pEntity)
                        if (pEntity.craft(level.registryAccess(), recipe, pEntity.items, i)) {
                            pEntity.recipeUsed = recipe
                        }
                        flag1 = true
                    }
                } else {
                    pEntity.creatingTime = 0
                }
            } else if (!pEntity.isLit() && pEntity.creatingTime > 0) {
                pEntity.creatingTime = Mth.clamp(pEntity.creatingTime - 2, 0, pEntity.creatingTime)
            }

            var state = pState
            if (flag != pEntity.isLit()) {
                flag1 = true
                state =
                    pState.setValue<Boolean, Boolean>(IngotFusionTollEnhancer.LIT, pEntity.isLit())
                level.setBlock(pPos, state, 3)
            }

            if (flag1) {
                setChanged(level, pPos, state)
            }
        }

        private fun getTotalCraftTime(
            pLevel: Level,
            pBlockEntity: IngotFusionTollEnhancerBlockEntity
        ): Int {
            return pBlockEntity.quickCheck!!
                .getRecipeFor(pBlockEntity, pLevel)
                .map { it::craftTime.get() }
                .orElse(200)
        }

        fun getFuels(): MutableMap<Item, Int> {
            val map: MutableMap<Item, Int> = Maps.newLinkedHashMap()
            map.putAll(AbstractFurnaceBlockEntity.getFuel())
            addFuel(map, ItemInit.GRAPHITE.get(), 200)
            addFuel(map, BlockInit.GRAPHITE_BLOCK.get().asItem(), 2000)
            return map
        }

        private fun addFuel(pMap: MutableMap<Item, Int>, fuel: Item, pBurnTime: Int) {
            if (isNeverAIngotFusionTollEnhanceFuel(fuel)) {
                if (SharedConstants.IS_RUNNING_IN_IDE) {
                    throw (Util.pauseInIde<IllegalStateException>(
                        IllegalStateException(
                            "A developer tried to explicitly make fire resistant item " +
                                fuel.getName(null as ItemStack?).string +
                                " a IngotFusionTollEnhancer fuel. That will not work!"))
                        as IllegalStateException)
                }
            } else {
                pMap[fuel] = pBurnTime
            }
        }

        private fun isNeverAIngotFusionTollEnhanceFuel(pItem: Item): Boolean {
            return pItem.builtInRegistryHolder().`is`(ItemTags.NON_FLAMMABLE_WOOD)
        }
    }

    private fun canCreate(
        pRegistryAccess: RegistryAccess,
        pRecipe: Recipe<*>?,
        pInventory: NonNullList<ItemStack>,
        pMaxStackSize: Int
    ): Boolean {
        return if (!pInventory[0].isEmpty && pRecipe != null) {
            val itemstack = (pRecipe as Recipe<WorldlyContainer>).assemble(this, pRegistryAccess)
            if (itemstack.isEmpty) {
                false
            } else {
                // TODO: Check this
                val itemstack1 = pInventory[2]

                if (itemstack1.isEmpty) {
                    true
                } else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
                    false
                } else if (itemstack1.count + itemstack.count <= pMaxStackSize &&
                    itemstack1.count + itemstack.count <= itemstack1.maxStackSize) {
                    true
                } else {
                    itemstack1.count + itemstack.count <= itemstack.maxStackSize
                }
            }
        } else {
            false
        }
    }

    private fun craft(
        pRegistryAccess: RegistryAccess,
        pRecipe: Recipe<*>?,
        pInventory: NonNullList<ItemStack>,
        pMaxStackSize: Int
    ): Boolean {
        return if (pRecipe != null &&
            this.canCreate(pRegistryAccess, pRecipe, pInventory, pMaxStackSize)) {
            val itemstack = pInventory[0]
            val itemstack1 = (pRecipe as Recipe<WorldlyContainer?>).assemble(this, pRegistryAccess)
            val itemstack2 = pInventory[2]
            if (itemstack2.isEmpty) {
                pInventory[2] = itemstack1.copy()
            } else if (itemstack2.`is`(itemstack1.item)) {
                itemstack2.grow(itemstack1.count)
            }
            if (itemstack.`is`(Blocks.WET_SPONGE.asItem()) &&
                !pInventory[1].isEmpty &&
                pInventory[1].`is`(Items.BUCKET)) {
                pInventory[1] = ItemStack(Items.WATER_BUCKET)
            }
            itemstack.shrink(1)
            true
        } else {
            false
        }
    }

    private fun getTotalCraftTime(pItemStack: ItemStack): Int {
        return if (pItemStack.isEmpty) {
            0
        } else {
            ForgeHooks.getBurnTime(pItemStack, RecipeTypeInit.INGOT_FUSION_TOLL_ENHANCER.get())
        }
    }
}
