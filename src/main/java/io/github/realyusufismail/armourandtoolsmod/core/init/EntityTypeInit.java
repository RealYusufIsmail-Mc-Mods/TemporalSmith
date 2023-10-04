package io.github.realyusufismail.armourandtoolsmod.core.init;

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod;
import io.github.realyusufismail.armourandtoolsmod.common.entity.AqumarineTridentEntity;
import io.github.realyusufismail.armourandtoolsmod.common.entity.ArmourToolsModTridentEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypeInit {
  public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
      DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ArmourAndToolsMod.MOD_ID);

  public static final RegistryObject<EntityType<ArmourToolsModTridentEntity>>
      AQUMARINE_THROWN_TRIDENT =
          ENTITY_TYPES.register(
              "aqumarine_thrown_trident",
              () ->
                  EntityType.Builder.<ArmourToolsModTridentEntity>of(
                          AqumarineTridentEntity::new, MobCategory.MISC)
                      .sized(0.5F, 0.5F)
                      .fireImmune()
                      .clientTrackingRange(4)
                      .updateInterval(20)
                      .setCustomClientFactory(
                          (spawnEntity, world) ->
                              new AqumarineTridentEntity(
                                  EntityTypeInit.AQUMARINE_THROWN_TRIDENT.get(), world))
                      .build(ArmourAndToolsMod.MOD_ID + ":aqumarine_thrown_trident"));
}
