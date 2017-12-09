package com.ingenious.models.players.impl;

import com.ingenious.algorithms.bots.GeneratesMove;
import com.ingenious.models.move.Move;
import com.ingenious.models.players.Player;

public class Bot extends Player implements GeneratesMove  {
    private GeneratesMove algorithm;

    public Bot(GeneratesMove algorithm) {
        super("BOT");
        this.algorithm = algorithm;
    }

    public Move generate() {
        return this.algorithm.generate();
    }

}
