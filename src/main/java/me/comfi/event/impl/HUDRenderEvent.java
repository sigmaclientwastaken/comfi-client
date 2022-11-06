package me.comfi.event.impl;

import me.comfi.event.types.Event;
import me.x150.renderer.event.events.ScreenRenderEvent;

public class HUDRenderEvent extends Event {

    private final ScreenRenderEvent event;

    public HUDRenderEvent(ScreenRenderEvent event) {
        this.event = event;
    }

    public final ScreenRenderEvent getEvent() {
        return event;
    }

}
