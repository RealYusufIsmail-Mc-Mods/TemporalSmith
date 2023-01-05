package io.github.realyusufismail.mod.core.armour;

import io.github.realyusufismail.mod.core.material.ArmourMaterialInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class AmethystArmour extends ArmorItem implements IForgeItem {
    public AmethystArmour(ArmorMaterial materialIn, EquipmentSlot slot, Item.Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
