package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.particle.Particle;

@Mixin(Particle.class)
public abstract class MixinParticle {
    //Removes particle gravity
    @Shadow float gravityStrength;
    @Inject(method = "tick", at = @At("RETURN"))
    public void tick(CallbackInfo ci){
        this.gravityStrength=0.0F;
    }
}
