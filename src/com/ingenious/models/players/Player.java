package com.ingenious.models.players;

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

    public Player(String name, Score score) {
        this.name = name;
        this.score = score;
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
        return new Player(this.name, this.score);
    }
}
