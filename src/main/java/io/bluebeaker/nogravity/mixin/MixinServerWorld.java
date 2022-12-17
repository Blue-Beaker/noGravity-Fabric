package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

@Mixin(ServerWorld.class)
public abstract class MixinServerWorld {
    // Apply NoGravity on entity spawn
    @Inject(method = "loadEntityUnchecked(Lnet/minecraft/entity/Entity;)V",at = @At("RETURN"))
    private void loadEntityUnchecked(Entity entity,CallbackInfo ci){
        entity.setNoGravity(true);
    }
    // Apply NoGravity on entity spawn
    @Inject(method = "addPlayer(Lnet/minecraft/server/network/ServerPlayerEntity;)V",at = @At("RETURN"))
    private void addPlayer(ServerPlayerEntity entity,CallbackInfo ci){
        entity.setNoGravity(true);
    }
}
