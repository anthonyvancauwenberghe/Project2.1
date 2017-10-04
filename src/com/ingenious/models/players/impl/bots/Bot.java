package com.ingenious.models.players.impl.bots;

import com.ingenious.algorithms.Algorithm;
import com.ingenious.models.players.Player;

public abstract class Bot extends Player {
    protected Algorithm algorithm;

    public Bot(String name, Algorithm algorithm) {
        super(name);
        this.algorithm = algorithm;
        initialize();
    }

    private void initialize() {
        try {
            if (algorithm == null) {
                throw new IllegalStateException();
            }
        } catch (Exception e) {
            System.out.println("Critical error bot has to implement an algorithm!");
            System.exit(1);
        }
    }

    public void executeMove() {
        this.algorithm.execute();
    }

}
