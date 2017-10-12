package com.ingenious.models.players;

import com.ingenious.events.impl.ScoreIsUpdatedEvent;
import com.ingenious.models.board.Node;
import com.ingenious.models.rack.Rack;
import com.ingenious.models.score.Score;

public abstract class Player implements Moveable {

    private String name;

    public Score score;
    public Rack rack;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getScoreArray() {
        return this.score.toArray();
    }

    public Score score() {
        return score;
    }

    public Rack getRack() {
        return this.rack;
    }

    public void executeMove(Node node) {
        //TODO IMPLEMENT MOVE LOGIC
    }
}
