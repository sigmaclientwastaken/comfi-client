package me.comfi.util.misc;

import java.util.HashMap;
import java.util.Map;

public abstract class Manager<T> {

    protected final Map<Class<? extends T>, T> instances = new HashMap<>();

    protected abstract void register();

    protected void add(T instance) {
        instances.put((Class<? extends T>) instance.getClass(), instance);
    }

    public final T getByClass(Class<T> tClass) {
        return instances.get(tClass);
    }

}
