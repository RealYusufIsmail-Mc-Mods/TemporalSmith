/*
 * Copyright 2023 RealYusufIsmail.
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
package io.github.realyusufismail.armourandtoolsmod.common.entity

import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.Tag
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.syncher.EntityDataSerializers
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.AbstractArrow
import net.minecraft.world.entity.projectile.ThrownTrident
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraft.world.level.Level
import net.minecraft.world.phys.EntityHitResult
import net.minecraft.world.phys.Vec3
import net.minecraftforge.network.NetworkHooks

/** @see ThrownTrident */
abstract class ArmourToolsModTridentEntity : AbstractArrow {
    var tridentItem: ItemStack? = null
    private var dealtDamage = false
    private var returningTicks = 0

    constructor(type: EntityType<ArmourToolsModTridentEntity>, world: Level) : super(type, world)

    constructor(
        type: EntityType<ArmourToolsModTridentEntity>,
        level: Level,
        thrower: LivingEntity,
        stack: ItemStack
    ) : super(type, thrower, level) {
        tridentItem = stack.copy()
        entityData.set(ID_LOYALTY, EnchantmentHelper.getLoyalty(stack).toByte())
        entityData.set(ID_FOIL, stack.hasFoil())
    }

    override fun defineSynchedData() {
        super.defineSynchedData()
        entityData.define(ID_LOYALTY, 0.toByte())
        entityData.define(ID_FOIL, false)
    }

    /** Called to update the entity's position/logic. */
    override fun tick() {
        if (inGroundTime > 4) {
            dealtDamage = true
        }
        val entity = this.owner
        val i = entityData.get(ID_LOYALTY).toInt()
        if (i > 0 && (dealtDamage || this.isNoPhysics) && entity != null) {
            if (!isAcceptibleReturnOwner()) {
                if (!level().isClientSide && pickup == Pickup.ALLOWED) {
                    this.spawnAtLocation(this.pickupItem, 0.1f)
                }
                discard()
            } else {
                setNoPhysics(true)
                val vec3 = entity.eyePosition.subtract(position())
                setPosRaw(this.x, this.y + vec3.y * 0.015 * i.toDouble(), this.z)
                if (level().isClientSide) {
                    yOld = this.y
                }
                val d0 = 0.05 * i.toDouble()
                deltaMovement = deltaMovement.scale(0.95).add(vec3.normalize().scale(d0))
                if (returningTicks == 0) {
                    this.playSound(SoundEvents.TRIDENT_RETURN, 10.0f, 1.0f)
                }
                ++returningTicks
            }
        }
        super.tick()
    }

    private fun isAcceptibleReturnOwner(): Boolean {
        val shooter = this.owner
        return if (shooter != null && shooter.isAlive) {
            shooter !is ServerPlayer || !shooter.isSpectator()
        } else {
            false
        }
    }

    override fun getPickupItem(): ItemStack {
        return tridentItem!!.copy()
    }

    fun isFoil(): Boolean {
        return entityData.get(ID_FOIL)
    }

    /** Gets the EntityHitResult representing the entity hit */
    override fun findHitEntity(pStartVec: Vec3, pEndVec: Vec3): EntityHitResult? {
        return if (dealtDamage) null else super.findHitEntity(pStartVec, pEndVec)
    }

    abstract override fun getBaseDamage(): Double

    /** Called when the arrow hits an entity */
    override fun onHitEntity(pResult: EntityHitResult) {
        val entity: Entity = pResult.entity
        var damage = getBaseDamage().toFloat()
        if (entity is LivingEntity) {
            damage += EnchantmentHelper.getDamageBonus(tridentItem!!, entity.mobType)
        }

        val shooter = this.owner
        val damageSource: DamageSource =
            this.level().damageSources().trident(this, (shooter ?: this))
        dealtDamage = true
        var soundEvent = SoundEvents.TRIDENT_HIT
        if (entity.hurt(damageSource, damage)) {
            if (entity.type === EntityType.ENDERMAN) {
                return
            }
            if (entity is LivingEntity) {
                if (shooter is LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(entity, shooter)
                    EnchantmentHelper.doPostDamageEffects(shooter, entity)
                }
                doPostHurtEffects(entity)
            }
        }

        deltaMovement = deltaMovement.multiply(-0.01, -0.1, -0.01)
        var f1 = 1.0f
        if (level() is ServerLevel && level().isThundering && isChanneling()) {
            val blockpos = entity.blockPosition()
            if (level().canSeeSky(blockpos)) {
                val lightningbolt = EntityType.LIGHTNING_BOLT.create(level())
                if (lightningbolt != null) {
                    lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos))
                    lightningbolt.cause = if (shooter is ServerPlayer) shooter else null
                    level().addFreshEntity(lightningbolt)
                    soundEvent = SoundEvents.TRIDENT_THUNDER
                    f1 = 5.0f
                }
            }
        }

        this.playSound(soundEvent, f1, 1.0f)
    }

    fun isChanneling(): Boolean {
        return EnchantmentHelper.hasChanneling(tridentItem!!)
    }

    /** The sound made when an entity is hit by this projectile */
    override fun getDefaultHitGroundSoundEvent(): SoundEvent {
        // TODO: make custom sound
        return SoundEvents.TRIDENT_HIT_GROUND
    }

    /** Called by a player entity when they collide with an entity */
    override fun playerTouch(pEntity: Player) {
        if (ownedBy(pEntity) || this.owner == null) {
            super.playerTouch(pEntity)
        }
    }

    /** (abstract) Protected helper method to read subclass entity data from NBT. */
    override fun readAdditionalSaveData(pCompound: CompoundTag) {
        super.readAdditionalSaveData(pCompound)
        if (pCompound.contains("Trident", Tag.TAG_COMPOUND.toInt())) {
            tridentItem = ItemStack.of(pCompound.getCompound("Trident"))
        }
        dealtDamage = pCompound.getBoolean("DealtDamage")
        entityData.set(ID_LOYALTY, EnchantmentHelper.getLoyalty(tridentItem!!).toByte())
    }

    override fun addAdditionalSaveData(pCompound: CompoundTag) {
        super.addAdditionalSaveData(pCompound)
        pCompound.put("Trident", tridentItem!!.save(CompoundTag()))
        pCompound.putBoolean("DealtDamage", dealtDamage)
    }

    public override fun tickDespawn() {
        if (this.pickup != Pickup.ALLOWED || this.entityData.get(ID_LOYALTY) <= 0) {
            super.tickDespawn()
        }
    }

    override fun getWaterInertia(): Float {
        return 0.99f
    }

    override fun shouldRender(pX: Double, pY: Double, pZ: Double): Boolean {
        return true
    }

    override fun getAddEntityPacket(): Packet<ClientGamePacketListener> {
        return NetworkHooks.getEntitySpawningPacket(this)
    }

    fun hasGlint(): Boolean {
        return entityData.get(ID_FOIL)
    }

    companion object {
        protected val ID_LOYALTY =
            SynchedEntityData.defineId(
                ArmourToolsModTridentEntity::class.java, EntityDataSerializers.BYTE)
        protected val ID_FOIL =
            SynchedEntityData.defineId(
                ArmourToolsModTridentEntity::class.java, EntityDataSerializers.BOOLEAN)
    }
}
