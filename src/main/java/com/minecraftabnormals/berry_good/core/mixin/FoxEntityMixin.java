package com.minecraftabnormals.berry_good.core.mixin;

import com.minecraftabnormals.berry_good.core.BGConfig;
import com.minecraftabnormals.berry_good.core.registry.BGItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoxEntity.class)
public abstract class FoxEntityMixin extends LivingEntity {

	protected FoxEntityMixin(EntityType<? extends LivingEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Inject(method = "setEquipmentBasedOnDifficulty", at = @At("TAIL"))
	private void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty, CallbackInfo info) {
		if (BGConfig.COMMON.foxMusicDisc.get() && this.rand.nextFloat() < BGConfig.COMMON.foxMusicDiscChance.get()) {
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(BGItems.MUSIC_DISC_FOX.get()));
		}
	}
}
