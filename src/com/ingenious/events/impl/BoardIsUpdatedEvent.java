package com.ingenious.events.impl;

import com.ingenious.events.Event;
import com.ingenious.providers.impl.GameServiceProvider;

public class BoardIsUpdatedEvent extends Event {

    @Override
    public void handle() {
        this.repaintBoard();
    }

    /**
     * ALL LISTENERS FOR THE EVENT COME HERE
     */
    private void repaintBoard() {
        if (GameServiceProvider.isBooted() && GameServiceProvider.gui() != null)
            GameServiceProvider.gui().getBoardPanel().repaint();
    }

}
