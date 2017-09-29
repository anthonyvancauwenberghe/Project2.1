package models.entities.bots.impl;

import algorithms.Algorithm;
import algorithms.impl.ExampleAlgorithm;
import models.entities.bots.Bot;

public class ExampleBot extends Bot {

    public ExampleBot() {
        super("example bot",2);
    }

    @Override
    protected Algorithm setAlgorithm() {
        return new ExampleAlgorithm();
    }
}
