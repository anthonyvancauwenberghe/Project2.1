package models.players.bots.impl;

import algorithms.Algorithm;
import algorithms.impl.ExampleAlgorithm;
import models.players.bots.Bot;

public class ExampleBot extends Bot {

    public ExampleBot() {
        super("example bot");
    }

    @Override
    protected Algorithm setAlgorithm() {
        return new ExampleAlgorithm();
    }
}
