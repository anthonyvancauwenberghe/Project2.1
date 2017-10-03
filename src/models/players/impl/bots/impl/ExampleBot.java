package models.players.impl.bots.impl;

import algorithms.impl.ExampleAlgorithm;
import models.players.impl.bots.Bot;

public class ExampleBot extends Bot {

    /* SET IN THE CONSTRUCTOR THE NAME OF THE BOT AND THE ALGORITHM TO USE */
    public ExampleBot() {
        super("example bot", new ExampleAlgorithm());
    }

}
