package me.comfi.mixin.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(priority = 1111, value = MinecraftClient.class)
public class MixinMinecraftClient {



}
