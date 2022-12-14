package me.comfi.main;

import me.comfi.util.data.PosRotGroundRecord;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;

public class MinecraftUtils {

    public static boolean REDIRECTING_POS_ROT_GROUND = false;
    public static Supplier<PosRotGroundRecord> POS_ROT_GROUND = null;

    public static boolean isSelfPlayer(Entity entity) {
        return MinecraftClient.getInstance().player == entity;
    }

}
