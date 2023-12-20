package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith.TemporalSmith.MOD_ID
import io.github.realyusufismail.temporalsmith.core.armour.*
import io.github.realyusufismail.temporalsmith.core.items.CustomSwordItem
import io.github.realyusufismail.temporalsmith.core.material.ArmourMaterialInit
import io.github.realyusufismail.temporalsmith.core.material.CustomToolMaterial
import net.minecraft.inventory.EquipmentSlotType
import net.minecraft.item.*
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.IForgeRegistryEntry
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import java.util.function.Supplier
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object ItemInit {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID)
    val SMELT_ABLE_ITEM: MutableMap<ObjectHolderDelegate<Item>, ObjectHolderDelegate<Item>> =
        mutableMapOf()

    val RUBY: ObjectHolderDelegate<Item> = ITEMS.registerObject("ruby") { Item(Item.Properties()) }
    val SAPPHIRE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("sapphire") { Item(Item.Properties()) }
    val GRAPHITE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("graphite") { Item(Item.Properties()) }
    val AQUMARINE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("aqumarine") { Item(Item.Properties()) }
    val RAINBOW: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("rainbow") { Item(Item.Properties()) }
    val ENDERITE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("enderite") { Item(Item.Properties()) }
    val IMPERIUM: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("imperium") { Item(Item.Properties()) }

    // raw ores
    val RAW_RUBY: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_ruby", RUBY) { Item(Item.Properties()) }
    val RAW_SAPPHIRE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_sapphire", SAPPHIRE) { Item(Item.Properties()) }
    val RAW_GRAPHITE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_graphite", GRAPHITE) { Item(Item.Properties()) }
    val RAW_AQUMARINE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_aqumarine", AQUMARINE) { Item(Item.Properties()) }
    val RAW_RAINBOW: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_rainbow", RAINBOW) { Item(Item.Properties()) }
    val RAW_ENDERITE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_enderite", ENDERITE) { Item(Item.Properties()) }
    val RAW_IMPERIUM: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("raw_imperium", IMPERIUM) { Item(Item.Properties()) }

    // armour
    val RUBY_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_helmet", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlotType.HEAD, Item.Properties())
        }

    val RUBY_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_chestplate", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlotType.CHEST, Item.Properties())
        }

    val RUBY_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_leggings", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlotType.LEGS, Item.Properties())
        }

    val RUBY_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_boots", RUBY) {
            RubyArmour(ArmourMaterialInit.RUBY, EquipmentSlotType.FEET, Item.Properties())
        }

    val SAPPHIRE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_helmet", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlotType.HEAD, Item.Properties())
        }

    val SAPPHIRE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_chestplate", SAPPHIRE) {
            SapphireArmour(
                ArmourMaterialInit.SAPPHIRE, EquipmentSlotType.CHEST, Item.Properties())
        }

    val SAPPHIRE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_leggings", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlotType.LEGS, Item.Properties())
        }

    val SAPPHIRE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_boots", SAPPHIRE) {
            SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlotType.FEET, Item.Properties())
        }

    val GRAPHITE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_helmet", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlotType.HEAD, Item.Properties())
        }

    val GRAPHITE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_chestplate", GRAPHITE) {
            GraphiteArmour(
                ArmourMaterialInit.GRAPHITE, EquipmentSlotType.CHEST, Item.Properties())
        }

    val GRAPHITE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_leggings", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlotType.LEGS, Item.Properties())
        }

    val GRAPHITE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("graphite_boots", GRAPHITE) {
            GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlotType.FEET, Item.Properties())
        }

    val AQUMARINE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_helmet", AQUMARINE) {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlotType.HEAD, Item.Properties())
        }

    val AQUMARINE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_chestplate", AQUMARINE) {
            AqumarineArmour(
                ArmourMaterialInit.AQUMARINE, EquipmentSlotType.CHEST, Item.Properties())
        }

    val AQUMARINE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_leggings", AQUMARINE) {
            AqumarineArmour(
                ArmourMaterialInit.AQUMARINE, EquipmentSlotType.LEGS, Item.Properties())
        }

    val AQUMARINE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("aqumarine_boots", AQUMARINE) {
            AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlotType.FEET, Item.Properties())
        }

    val RAINBOW_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_helmet", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlotType.HEAD, Item.Properties())
        }

    val RAINBOW_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_chestplate", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlotType.CHEST, Item.Properties())
        }

    val RAINBOW_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_leggings", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlotType.LEGS, Item.Properties())
        }

    val RAINBOW_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("rainbow_boots", RAINBOW) {
            RainbowArmour(ArmourMaterialInit.RAINBOW, EquipmentSlotType.FEET, Item.Properties())
        }

    val ENDERITE_HELMET: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_helmet", ENDERITE) {
            EnderiteArmour(ArmourMaterialInit.ENDERITE, EquipmentSlotType.HEAD, Item.Properties())
        }

    val ENDERITE_CHESTPLATE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_chestplate", ENDERITE) {
            EnderiteArmour(
                ArmourMaterialInit.ENDERITE, EquipmentSlotType.CHEST, Item.Properties())
        }

    val ENDERITE_LEGGINGS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_leggings", ENDERITE) {
            EnderiteArmour(ArmourMaterialInit.ENDERITE, EquipmentSlotType.LEGS, Item.Properties())
        }

    val ENDERITE_BOOTS: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_boots", ENDERITE) {
            EnderiteArmour(ArmourMaterialInit.ENDERITE, EquipmentSlotType.FEET, Item.Properties())
        }

    // Swords
    val RUBY_SWORD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_sword", RUBY) {
            CustomSwordItem(CustomToolMaterial.RUBY_SWORD, 8, -2.6f, Item.Properties().stacksTo(1))
        }

    //val ENDERITE_SWORD: ObjectHolderDelegate<Item> =
     //   ITEMS.registerSmeltableObject("enderite_sword", ENDERITE, ::EnderiteSword)

    val SAPPHIRE_SWORD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_sword", SAPPHIRE) {
            CustomSwordItem(
                CustomToolMaterial.SAPPHIRE_SWORD, 9, -2.6f, Item.Properties().stacksTo(1))
        }

    val IMPERIUM_SWORD: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("imperium_sword", IMPERIUM) {
            CustomSwordItem(
                CustomToolMaterial.IMPERIUM_SWORD, 10, -2.7f, Item.Properties().stacksTo(1))
        }

    // Pickaxes
    val RUBY_PICKAXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_pickaxe", RUBY) {
            PickaxeItem(CustomToolMaterial.RUBY_PICKAXE, 5, -2.8f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_PICKAXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_pickaxe", ENDERITE) {
            PickaxeItem(
                CustomToolMaterial.ENDERITE_PICKAXE, 6, -2.7f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_PICKAXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_pickaxe", SAPPHIRE) {
            PickaxeItem(
                CustomToolMaterial.SAPPHIRE_PICKAXE, 6, -2.8f, Item.Properties().stacksTo(1))
        }

    val IMPERIUM_PICKAXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("imperium_pickaxe", IMPERIUM) {
            PickaxeItem(
                CustomToolMaterial.IMPERIUM_PICKAXE, 7, -2.9f, Item.Properties().stacksTo(1))
        }

    val MAGMA_STRIKE_PICKAXE: ObjectHolderDelegate<Item> =
        ITEMS.registerObject("magma_strike_pickaxe") {
            PickaxeItem(
                CustomToolMaterial.MAGMA_STRIKE_PICKAXE, 9, -3.0f, Item.Properties().stacksTo(1))
        }

    // Axes
    val RUBY_AXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_axe", RUBY) {
            AxeItem(CustomToolMaterial.RUBY_AXE, 8F, -2.6f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_AXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_axe", ENDERITE) {
            AxeItem(CustomToolMaterial.ENDERITE_AXE, 9F, -2.5f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_AXE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_axe", SAPPHIRE) {
            AxeItem(CustomToolMaterial.SAPPHIRE_AXE, 8.5F, -2.6f, Item.Properties().stacksTo(1))
        }

    // Shovels
    val RUBY_SHOVEL: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_shovel", RUBY) {
            ShovelItem(CustomToolMaterial.RUBY_SHOVEL, 3.5F, -3.0f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_SHOVEL: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_shovel", ENDERITE) {
            ShovelItem(
                CustomToolMaterial.ENDERITE_SHOVEL, 4.5F, -3.0f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_SHOVEL: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_shovel", SAPPHIRE) {
            ShovelItem(
                CustomToolMaterial.SAPPHIRE_SHOVEL, 4.5F, -3.5f, Item.Properties().stacksTo(1))
        }

    // Hoes
    val RUBY_HOE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("ruby_hoe", RUBY) {
            HoeItem(CustomToolMaterial.RUBY_HOE, 1, -3.1f, Item.Properties().stacksTo(1))
        }

    val ENDERITE_HOE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("enderite_hoe", ENDERITE) {
            HoeItem(CustomToolMaterial.ENDERITE_HOE, 2, -3.0f, Item.Properties().stacksTo(1))
        }

    val SAPPHIRE_HOE: ObjectHolderDelegate<Item> =
        ITEMS.registerSmeltableObject("sapphire_hoe", SAPPHIRE) {
            HoeItem(CustomToolMaterial.SAPPHIRE_HOE, 2, -3.1f, Item.Properties().stacksTo(1))
        }

    private fun DeferredRegister<Item>.registerSmeltableObject(
        name: String,
        associatedOreIngot: ObjectHolderDelegate<Item>,
        supplier: () -> Item
    ): ObjectHolderDelegate<Item> {
        val registryObject: RegistryObject<Item> = this.register(name, supplier)

        val o = ObjectHolderDelegate(registryObject)

        SMELT_ABLE_ITEM[o] = associatedOreIngot
        // note that this anonymous class inherits three types
        return o
    }

    class ObjectHolderDelegate<V : IForgeRegistryEntry<in V>>(val registryObject: RegistryObject<V>) : ReadOnlyProperty<Any?, V>,
        Supplier<V>, () -> V {
        override fun getValue(thisRef: Any?, property: KProperty<*>): V = registryObject.get()
        override fun invoke(): V = registryObject.get()
        override fun get(): V = registryObject.get()
    }


    private fun <V : IForgeRegistryEntry<V>, T : V> DeferredRegister<V>.registerObject(
        name: String,
        supplier: () -> T,
    ): ObjectHolderDelegate<T>
    {
        val registryObject = this.register(name, supplier)

        // note that this anonymous class inherits three types
        return ObjectHolderDelegate(registryObject)
    }
}
