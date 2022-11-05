package me.comfi.main;

import net.fabricmc.api.ModInitializer;

public class FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        Comfi.getInstance().init();
    }
}
