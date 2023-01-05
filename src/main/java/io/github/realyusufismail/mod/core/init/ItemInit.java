package io.github.realyusufismail.mod.core.init;

import io.github.realyusufismail.mod.core.armour.AmethystArmour;
import io.github.realyusufismail.mod.core.material.ArmourMaterialInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static io.github.realyusufismail.mod.ForgeReg.ITEMS;

public class ItemInit {

    //ore ingots
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));


    //armour
    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () -> new AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.HEAD, new Item.Properties()));
}
