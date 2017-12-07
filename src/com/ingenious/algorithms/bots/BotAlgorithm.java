package com.ingenious.algorithms.bots;

import com.ingenious.models.move.Move;

/**
 * @author Anthony
 */
abstract public class BotAlgorithm implements GeneratesMove {

    @Override
    public Move generate() {
        System.out.println("Executing Algorithm: " + this.getClass().getSimpleName());
        long startTime = System.nanoTime();
        Move move = generateMove();
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) / 1000000 + " ms to execute algorithm");
        return move;
    }

    protected abstract Move generateMove();
}
