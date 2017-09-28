package entities.bots;

import board.Node;
import entities.Entity;

public abstract class Bot extends Entity {
    public Bot(String name) {
        super(name);
    }

    public abstract Node calculateMove();
}
