package me.comfi.main;

import me.x150.renderer.event.Events;
import net.fabricmc.api.ModInitializer;

public class FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        Events.registerEventHandlerClass(new EventHandler());
        Comfi.getInstance().init();
    }
}
