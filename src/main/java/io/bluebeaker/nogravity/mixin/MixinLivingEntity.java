package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {
    @Inject(method = "handleFallDamage",at = @At("HEAD"), cancellable = true)
    public void handleFallDamage(float fallDistance, float damageMultiplier,CallbackInfoReturnable<Boolean> cir){
        if(((LivingEntity)(Object)this).hasNoGravity()){
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}
