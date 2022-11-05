package me.comfi.mixin.mixin;

import me.comfi.event.impl.KeyEvent;
import me.comfi.main.Comfi;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(priority = 1111, value = Keyboard.class)
public class MixinKeyboard {

    @Shadow @Final
    private MinecraftClient client;

    @Inject(method = "onKey", at = @At("HEAD"))
    public void onKeyPressed(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if (window == this.client.getWindow().getHandle()) {
            if(this.client.currentScreen == null || this.client.currentScreen.passEvents) {
                if(action == 1) {
                    Comfi.getInstance().getEventBus().post(new KeyEvent(key));
                }
            }
        }
    }

}
