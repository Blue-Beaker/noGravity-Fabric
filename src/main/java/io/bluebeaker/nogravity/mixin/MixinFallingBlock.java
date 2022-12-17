package io.bluebeaker.nogravity.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

@Mixin(FallingBlock.class)
public abstract class MixinFallingBlock {
    //Remove blocks falling action
    @Inject(method = "scheduledTick", at = @At("HEAD"), cancellable = true)
    private void tick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci){
        ci.cancel();
    }
}
