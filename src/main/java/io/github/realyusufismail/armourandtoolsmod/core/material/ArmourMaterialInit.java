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
package io.github.realyusufismail.armourandtoolsmod.core.material;

import io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ArmourMaterialInit implements ArmorMaterial {
    AMETHYST("amethyst", 11, new int[] {4, 7, 9, 4}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.2f,
            0.2f, () -> Ingredient.of(Items.AMETHYST_SHARD)),

    RUBY("ruby", 8, new int[] {2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f,
            () -> Ingredient.of(ItemInit.RUBY.get())),

    SAPPHIRE("sapphire", 9, new int[] {3, 6, 7, 3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.1f, 0.1f,
            () -> Ingredient.of(ItemInit.SAPPHIRE.get())),

    GRAPHITE("graphite", 10, new int[] {3, 6, 8, 3}, 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.1f,
            0.1f, () -> Ingredient.of(ItemInit.GRAPHITE.get())),

    AQUMARINE("aqumarine", 12, new int[] {4, 7, 9, 4}, 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.3f,
            0.3f, () -> Ingredient.of(ItemInit.AQUMARINE.get())),

    RAINBOW("rainbow", 100, new int[] {100, 100, 100, 100}, 100, SoundEvents.ARMOR_EQUIP_DIAMOND,
            100.0f, 100.0f, () -> Ingredient.of(ItemInit.RAINBOW.get())),

    ;

    private final String oreName;
    private final int durability;
    private final int[] armorVal;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    ArmourMaterialInit(String oreName, int durability, int[] armorVal, int enchantability,
            SoundEvent equipSound, float toughness, float knockbackResistance,
            Supplier<Ingredient> repairMaterial) {
        this.oreName = oreName;
        this.durability = durability;
        this.armorVal = armorVal;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return this.durability * this.armorVal[pSlot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.armorVal[pSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.oreName;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
