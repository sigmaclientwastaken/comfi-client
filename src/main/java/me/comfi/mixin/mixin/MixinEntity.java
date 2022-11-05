package me.comfi.mixin.mixin;

import me.comfi.main.MinecraftUtils;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(priority = 1111, value = Entity.class)
public class MixinEntity {

    @Inject(method = "getX", at = @At("HEAD"), cancellable = true)
    public void getX(CallbackInfoReturnable<Double> cir) {
        if(MinecraftUtils.REDIRECTING_POS_ROT_GROUND &&
                MinecraftUtils.isSelfPlayer((Entity) (Object) this)) {
            cir.setReturnValue(MinecraftUtils.POS_ROT_GROUND.x());
        }
    }

    @Inject(method = "getY", at = @At("HEAD"), cancellable = true)
    public void getY(CallbackInfoReturnable<Double> cir) {
        if(MinecraftUtils.REDIRECTING_POS_ROT_GROUND &&
                MinecraftUtils.isSelfPlayer((Entity) (Object) this)) {
            cir.setReturnValue(MinecraftUtils.POS_ROT_GROUND.y());
        }
    }

    @Inject(method = "getZ", at = @At("HEAD"), cancellable = true)
    public void getZ(CallbackInfoReturnable<Double> cir) {
        if(MinecraftUtils.REDIRECTING_POS_ROT_GROUND &&
                MinecraftUtils.isSelfPlayer((Entity) (Object) this)) {
            cir.setReturnValue(MinecraftUtils.POS_ROT_GROUND.z());
        }
    }

    @Inject(method = "getYaw()F", at = @At("HEAD"), cancellable = true)
    public void getYaw(CallbackInfoReturnable<Float> cir) {
        if(MinecraftUtils.REDIRECTING_POS_ROT_GROUND &&
                MinecraftUtils.isSelfPlayer((Entity) (Object) this)) {
            cir.setReturnValue(MinecraftUtils.POS_ROT_GROUND.yaw());
        }
    }

    @Inject(method = "getPitch()F", at = @At("HEAD"), cancellable = true)
    public void getPitch(CallbackInfoReturnable<Float> cir) {
        if(MinecraftUtils.REDIRECTING_POS_ROT_GROUND &&
                MinecraftUtils.isSelfPlayer((Entity) (Object) this)) {
            cir.setReturnValue(MinecraftUtils.POS_ROT_GROUND.pitch());
        }
    }

}
