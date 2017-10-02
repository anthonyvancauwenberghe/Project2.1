package models.entities.bots;

import algorithms.Algorithm;
import algorithms.Executable;
import models.board.Node;
import models.entities.Entity;

public abstract class Bot extends Entity {
    private Algorithm algorithm;

    public Bot(String name) {
        super(name);
        this.algorithm = setAlgorithm();
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

    public void move() {
        this.algorithm.execute();
    }

    protected abstract Algorithm setAlgorithm();
}
