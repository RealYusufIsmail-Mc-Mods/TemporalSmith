package io.github.realyusufismail.armourandtoolsmod.core.init;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.blocks.fusion.IngotFusionTollEnhancerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypeInit {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArmourAndToolsMod.MOD_ID);

    public static RegistryObject<BlockEntityType<IngotFusionTollEnhancerBlockEntity>> INGOT_FUSION_TOLL_ENHANCER =
            BLOCK_ENTITY_TYPES.register("ingot_fusion_toll_enhancer",
                    () -> BlockEntityType.Builder.of(IngotFusionTollEnhancerBlockEntity::new,
                            BlockInit.INGOT_FUSION_TOLL_ENHANCER.get()).build(null));
}
