package com.ingenious.models.players;

import com.ingenious.events.impl.ScoreIsUpdatedEvent;
import com.ingenious.models.board.Node;
import com.ingenious.models.rack.Rack;

public abstract class Player implements Moveable {

    private String name;

    public int[] score;
    public Rack rack;

    public Player(String name) {
        this.name = name;
        score = new int[6];
    }

    public String getName() {
        return name;
    }

    public int[] getScore() {
        return this.score;
    }

    public void setScore(int index, int value) {
        this.score[index] = value;
        new ScoreIsUpdatedEvent();
    }

    public Rack getRack() {
        return rack;
    }

    public void executeMove(Node node) {
        //TODO IMPLEMENT MOVE LOGIC
    }
}
