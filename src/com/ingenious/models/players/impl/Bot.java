package com.ingenious.models.players.impl;

import com.ingenious.algorithms.Algorithm;
import com.ingenious.models.players.Player;

public class Bot extends Player {
    protected Algorithm algorithm;

    public Bot(String name, Algorithm algorithm) {
        super(name);
        this.algorithm = algorithm;
    }

    public void executeMove() {
        this.algorithm.execute();
    }

}
