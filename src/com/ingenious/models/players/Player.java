package com.ingenious.models.players;

import com.ingenious.algorithms.GeneratesMove;
import com.ingenious.models.rack.Rack;
import com.ingenious.models.score.Score;

public class Player {

    private String name;

    public Score score;
    public Rack rack;

    public Player(String name) {
        this.name = name;
        this.score = new Score();
    }

    public Player(String name, Score score, Rack rack) {
        this.name = name;
        this.score = score;
        this.rack = rack;
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

    public Player getClone() {
        return new Player(this.name, this.score.getClone(), this.rack.getClone());
    }

    public boolean isBot() {
        return this.name.equals("BOT");
    }

    public boolean isHuman() {
        return !isBot();
    }
}
