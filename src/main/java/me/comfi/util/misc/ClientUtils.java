package me.comfi.util.misc;

import me.comfi.module.Module;

import java.util.function.Supplier;

public class ClientUtils {

    public static Supplier<Boolean> moduleEnabledSupplier(Module module) {
        return module::isEnabled;
    }

}
