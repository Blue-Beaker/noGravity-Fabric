package io.bluebeaker.nogravity.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity {
    // Modify mining speed to negate 'not on ground' penalty
    @Redirect(method = "getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;onGround:Z", opcode = Opcodes.GETFIELD))
    private boolean removeBreakingSpeedPenalty(PlayerEntity playerEntity) {
        if(((PlayerEntity)(Object)this).hasNoGravity())
        return true;
        else
        return ((PlayerEntity)(Object)this).isOnGround();
    }
}
