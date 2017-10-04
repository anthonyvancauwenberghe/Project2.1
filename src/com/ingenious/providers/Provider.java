package com.ingenious.providers;

import com.ingenious.providers.impl.GameServiceProvider;

abstract public class Provider {
    protected static GameServiceProvider instance;

    public Provider() {
        this.initialize();
    }

    public static void boot() {
        try {
            if (instance == null)
                instance = new GameServiceProvider();
            else
                throw new IllegalStateException();
        } catch (IllegalStateException exception) {
            System.out.println("Error application is already booted.");
        }
    }

    protected static void reboot(){
        instance = new GameServiceProvider();
    }

    protected static void verifyInitialization() {
        try {
            if (instance == null)
                throw new IllegalStateException();
        } catch (IllegalStateException exception) {
            exception.printStackTrace();
            System.out.println("Critical error component has not been booted yet. You probably need to pass things by reference at the GameServiceProvider initialization method");
            System.exit(1);
        }
    }

    protected static GameServiceProvider getInstance(){
        verifyInitialization();
        return instance;
    }

    protected abstract void initialize();
}
