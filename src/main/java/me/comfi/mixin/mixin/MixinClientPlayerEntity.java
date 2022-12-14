package me.comfi.mixin.mixin;

import com.mojang.authlib.GameProfile;
import me.comfi.event.impl.UpdateEvent;
import me.comfi.main.Comfi;
import me.comfi.main.MinecraftUtils;
import me.comfi.util.data.PosRotGroundRecord;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.network.encryption.PlayerPublicKey;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(priority = 1111, value = ClientPlayerEntity.class)
public abstract class MixinClientPlayerEntity extends AbstractClientPlayerEntity {

    private boolean cachedGround = false;

    public MixinClientPlayerEntity(ClientWorld world, GameProfile profile, @Nullable PlayerPublicKey publicKey) {
        super(world, profile, publicKey);
    }

    @Shadow protected abstract boolean isCamera();

    @Inject(method = "sendMovementPackets", at = @At("HEAD"))
    public void sendMovementPacketsHead(CallbackInfo ci) {
        if(this.isCamera()) {
            MinecraftUtils.REDIRECTING_POS_ROT_GROUND = true;
            cachedGround = this.onGround;

            UpdateEvent event = new UpdateEvent.Pre(PosRotGroundRecord.getFromEntity(this));
            Comfi.getInstance().getEventBus().post(event);

            MinecraftUtils.POS_ROT_GROUND = event::getAsRecord;
        }
    }

    @Inject(method = "sendMovementPackets", at = @At("RETURN"))
    public void sendMovementPacketsReturn(CallbackInfo ci) {
        if(this.isCamera()) {
            UpdateEvent event = new UpdateEvent.Post(MinecraftUtils.POS_ROT_GROUND.get());
            Comfi.getInstance().getEventBus().post(event);

            MinecraftUtils.REDIRECTING_POS_ROT_GROUND = false;
            MinecraftUtils.POS_ROT_GROUND = null;
            this.onGround = cachedGround;
        }
    }

}
