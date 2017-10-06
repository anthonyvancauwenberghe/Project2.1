package com.ingenious.events;

abstract public class Event {
    public Event() {
        handle();
    }
    protected abstract void handle();
}
