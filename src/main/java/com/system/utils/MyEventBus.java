package com.system.utils;

import com.google.common.eventbus.EventBus;

public class MyEventBus {
    private final static EventBus eventBus = new EventBus();

    private MyEventBus() {

    }

    public static EventBus getDefault() {
        return eventBus;
    }
}
