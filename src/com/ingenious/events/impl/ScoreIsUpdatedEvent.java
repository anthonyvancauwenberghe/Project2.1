package com.ingenious.events.impl;

import com.ingenious.events.Event;
import com.ingenious.providers.impl.GameServiceProvider;

public class ScoreIsUpdatedEvent extends Event {

    @Override
    protected void handle() {
        this.repaintScore();
    }

    /**
     * ALL LISTENERS FOR THE EVENT COME HERE
     */
    private void repaintScore() {
        if (GameServiceProvider.isBooted() && GameServiceProvider.gui() != null && GameServiceProvider.gui().getScorePanel() != null)
            GameServiceProvider.gui().getScorePanel().repaint();
    }

}
