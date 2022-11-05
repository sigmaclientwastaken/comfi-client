package me.comfi.main;

import me.comfi.event.bus.bus.impl.EventBus;
import me.comfi.event.types.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Comfi {

    private static final Comfi INSTANCE = new Comfi();

    private final String clientName = "Comfi";
    private final String clientVersion = "b1";
    private final String clientAuthor = "sigmaclientwastaken";

    private final Logger logger = LogManager.getLogger("comfi");
    private final EventBus<Event> eventBus = new EventBus<>();

    public void init() {

        logger.info("[{}] Loading {} {} by {}...", clientName, clientName, clientVersion, clientAuthor);



        logger.info("[{}] Loaded {}.", clientName, clientName);

    }

    public final String getClientName() {
        return clientName;
    }

    public final String getClientVersion() {
        return clientVersion;
    }

    public final String getClientAuthor() {
        return clientAuthor;
    }

    public final Logger getLogger() {
        return logger;
    }

    public final EventBus<Event> getEventBus() {
        return eventBus;
    }

    public static Comfi getInstance() {
        return INSTANCE;
    }

}
