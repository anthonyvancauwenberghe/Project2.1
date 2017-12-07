package com.ingenious.models.players.impl;

import com.ingenious.algorithms.Algorithm;
import com.ingenious.algorithms.GeneratesMove;
import com.ingenious.models.move.Move;
import com.ingenious.models.players.Player;
import com.ingenious.providers.impl.GameServiceProvider;

public class Bot extends Player {
    private GeneratesMove algorithm;

    public Bot(GeneratesMove algorithm) {
        super("BOT");
        this.algorithm = algorithm;
    }

    public Move getMove() {
        return this.algorithm.generate();
    }

}
