package io.github.realyusufismail.armourandtoolsmod.core.init;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.realyusufismailcore.core.init.GeneralBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static io.github.realyusufismail.armourandtoolsmod.core.init.ItemInit.ITEMS;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArmourAndToolsMod.MOD_ID);

    // ores
    public static final RegistryObject<GeneralBlock> RUBY_ORE =
            register("ruby_ore", Blocks.IRON_ORE);
    public static final RegistryObject<GeneralBlock> RAINBOW_ORE =
            register("rainbow_ore", Blocks.DIAMOND_ORE);
    public static final RegistryObject<GeneralBlock> SAPPHIRE_ORE =
            register("sapphire_ore", Blocks.GOLD_ORE);
    public static final RegistryObject<GeneralBlock> GRAPHITE_ORE =
            register("graphite_ore", Blocks.DIAMOND_ORE);
    public static final RegistryObject<GeneralBlock> AQUMARINE_ORE =
            register("aqumarine_ore", Blocks.DIAMOND_ORE);

    // deepslate ores
    public static final RegistryObject<GeneralBlock> DEEPSLATE_RUBY_ORE =
            register("deepslate_ruby_ore", Blocks.DEEPSLATE_IRON_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_RAINBOW_ORE =
            register("deepslate_rainbow_ore", Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_SAPPHIRE_ORE =
            register("deepslate_sapphire_ore", Blocks.DEEPSLATE_GOLD_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_GRAPHITE_ORE =
            register("deepslate_graphite_ore", Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final RegistryObject<GeneralBlock> DEEPSLATE_AQUMARINE_ORE =
            register("deepslate_aqumarine_ore", Blocks.DEEPSLATE_DIAMOND_ORE);

    // blocks
    public static final RegistryObject<GeneralBlock> RUBY_BLOCK =
            register("ruby_block", Blocks.IRON_BLOCK);
    public static final RegistryObject<GeneralBlock> RAINBOW_BLOCK =
            register("rainbow_block", Blocks.DIAMOND_BLOCK);
    public static final RegistryObject<GeneralBlock> SAPPHIRE_BLOCK =
            register("sapphire_block", Blocks.GOLD_BLOCK);
    public static final RegistryObject<GeneralBlock> GRAPHITE_BLOCK =
            register("graphite_block", Blocks.DIAMOND_BLOCK);
    public static final RegistryObject<GeneralBlock> AQUMARINE_BLOCK =
            register("aqumarine_block", Blocks.DIAMOND_BLOCK);


    // helper methods for register both block and BlockItem at the same time.
    // Instead of put them in main class
    private static <T extends Block> RegistryObject<T> registerSpecial(String name,
            Supplier<T> supplier) {
        RegistryObject<T> blockReg = BLOCKS.register(name, supplier);
        ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }

    private static RegistryObject<GeneralBlock> register(String name,
            Supplier<GeneralBlock> supplier) {
        RegistryObject<GeneralBlock> blockReg = BLOCKS.register(name, supplier);
        ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }

    private static RegistryObject<GeneralBlock> register(String name, Block existingBlock) {
        return register(name,
                () -> new GeneralBlock(BlockBehaviour.Properties.copy(existingBlock)));
    }
}
