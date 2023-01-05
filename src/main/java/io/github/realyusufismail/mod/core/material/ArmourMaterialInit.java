package io.github.realyusufismail.mod.core.material;

import io.github.realyusufismail.mod.core.init.ItemInit;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ArmourMaterialInit implements ArmorMaterial {

    AMETHYST("amethyst", 11, new int[] {4, 7, 9, 4}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.2F,
            0.2F, () -> Ingredient.of(ItemInit.AMETHYST.get())),
    RUBY("ruby", 8, new int[] {2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F,
            () -> Ingredient.of(ItemInit.RUBY.get())),
    SAPPHIRE("sapphire", 9, new int[] {3, 6, 7, 3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.1F, 0.1F,
            () -> Ingredient.of(ItemInit.SAPPHIRE.get())),
    GRAPHITE("graphite", 10, new int[] {3, 6, 8, 3}, 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.1F,
            0.1F, () -> Ingredient.of(ItemInit.GRAPHITE.get())),
    AQUMARINE("aqumarine", 12, new int[] {4, 7, 9, 4}, 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.3F,
            0.3F, () -> Ingredient.of(ItemInit.AQUMARINE.get())),

    RAINBOW("rainbow", 100, new int[] {100, 100, 100, 100}, 100, SoundEvents.ARMOR_EQUIP_DIAMOND,
            100.0F, 100.0F, () -> Ingredient.of(ItemInit.RAINBOW.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorVal;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toghness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;


    ArmourMaterialInit(String name, int durabilityMultiplier, int[] armorVal, int enchantability,
            SoundEvent equipSound, float toghness, float knockbackResistance,
            Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorVal = armorVal;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toghness = toghness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient.get();
    }


    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.armorVal[slot.getIndex()];
    }

    public int getDurabilityMultiplier() {
        return this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.armorVal[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toghness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
