package io.github.realyusufismail.mod.core.armour;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class GraphiteArmour extends ArmorItem implements IForgeItem {
    public GraphiteArmour(ArmorMaterial materialIn, EquipmentSlot slot, Item.Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}