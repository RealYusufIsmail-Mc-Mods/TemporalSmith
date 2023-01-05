package io.github.realyusufismail.mod.core.datagen.lang;

import io.github.realyusufismail.mod.ArmourAndItemMod;
import io.github.realyusufismail.mod.core.init.BlockInit;
import io.github.realyusufismail.mod.core.init.ItemInit;
import io.github.realyusufismail.realyusufismailcore.data.support.lang.ModEnLangProviderSupport;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModEnLangProvider extends ModEnLangProviderSupport {

    public ModEnLangProvider(DataGenerator gen) {
        super(gen, ArmourAndItemMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // ores
        addBlock(BlockInit.RUBY_ORE, "Ruby Ore");
        addBlock(BlockInit.SAPPHIRE_ORE, "Sapphire Ore");
        addBlock(BlockInit.GRAPHITE_ORE, "Graphite Ore");
        addBlock(BlockInit.RAINBOW_ORE, "Rainbow Ore");
        addBlock(BlockInit.AQUMARINE_ORE, "Aqumarine Ore");

        // blocks
        addBlock(BlockInit.RUBY_BLOCK, "Ruby Block");
        addBlock(BlockInit.SAPPHIRE_BLOCK, "Sapphire Block");
        addBlock(BlockInit.GRAPHITE_BLOCK, "Graphite Block");
        addBlock(BlockInit.RAINBOW_BLOCK, "Rainbow Block");
        addBlock(BlockInit.AQUMARINE_BLOCK, "Aqumarine Block");

        // deepslate ores
        addBlock(BlockInit.DEEPSLATE_RUBY_ORE, "Deepslate Ruby Ore");
        addBlock(BlockInit.DEEPSLATE_SAPPHIRE_ORE, "Deepslate Sapphire Ore");
        addBlock(BlockInit.DEEPSLATE_GRAPHITE_ORE, "Deepslate Graphite Ore");
        addBlock(BlockInit.DEEPSLATE_RAINBOW_ORE, "Deepslate Rainbow Ore");
        addBlock(BlockInit.DEEPSLATE_AQUMARINE_ORE, "Deepslate Aqumarine Ore");

        // ore ingot
        addItem(ItemInit.RUBY, "Ruby");
        addItem(ItemInit.SAPPHIRE, "Sapphire");
        addItem(ItemInit.GRAPHITE, "Graphite");
        addItem(ItemInit.RAINBOW, "Rainbow Ingot");
        addItem(ItemInit.AQUMARINE, "Aqumarine");

        // armor
        addItem(ItemInit.RUBY_HELMET, "Ruby Helmet");
        addItem(ItemInit.RUBY_CHESTPLATE, "Ruby Chestplate");
        addItem(ItemInit.RUBY_LEGGINGS, "Ruby Leggings");
        addItem(ItemInit.RUBY_BOOTS, "Ruby Boots");

        addItem(ItemInit.SAPPHIRE_HELMET, "Sapphire Helmet");
        addItem(ItemInit.SAPPHIRE_CHESTPLATE, "Sapphire Chestplate");
        addItem(ItemInit.SAPPHIRE_LEGGINGS, "Sapphire Leggings");
        addItem(ItemInit.SAPPHIRE_BOOTS, "Sapphire Boots");

        addItem(ItemInit.GRAPHITE_HELMET, "Graphite Helmet");
        addItem(ItemInit.GRAPHITE_CHESTPLATE, "Graphite Chestplate");
        addItem(ItemInit.GRAPHITE_LEGGINGS, "Graphite Leggings");
        addItem(ItemInit.GRAPHITE_BOOTS, "Graphite Boots");

        addItem(ItemInit.RAINBOW_HELMET, "Rainbow Helmet");
        addItem(ItemInit.RAINBOW_CHESTPLATE, "Rainbow Chestplate");
        addItem(ItemInit.RAINBOW_LEGGINGS, "Rainbow Leggings");
        addItem(ItemInit.RAINBOW_BOOTS, "Rainbow Boots");

        addItem(ItemInit.AQUMARINE_HELMET, "Aqumarine Helmet");
        addItem(ItemInit.AQUMARINE_CHESTPLATE, "Aqumarine Chestplate");
        addItem(ItemInit.AQUMARINE_LEGGINGS, "Aqumarine Leggings");
        addItem(ItemInit.AQUMARINE_BOOTS, "Aqumarine Boots");

        addItem(ItemInit.AMETHYST_HELMET, "Amethyst Helmet");
        addItem(ItemInit.AMETHYST_CHESTPLATE, "Amethyst Chestplate");
        addItem(ItemInit.AMETHYST_LEGGINGS, "Amethyst Leggings");
        addItem(ItemInit.AMETHYST_BOOTS, "Amethyst Boots");

        // others
        add("creativetab.armouranditemmod", "Armour and Item Mod");
    }

    @Override
    protected <T extends Item> void item(RegistryObject<T> entry, String name) {
        add(entry.get(), name);
    }

    @Override
    protected <T extends Block> void block(RegistryObject<T> entry, String name) {
        add(entry.get(), name);
    }

    @Override
    protected <T extends Entity> void entity(EntityType<?> key, String name) {
        add(key.getDescriptionId(), name);
    }

    @Override
    protected void add(Component translatableComponent, String lang) {
        super.add(translatableComponent.getString(), lang);
    }
}
