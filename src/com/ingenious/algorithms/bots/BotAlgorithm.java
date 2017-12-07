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
        double timeDifference = ((double) endTime - (double) startTime) / 1000000;
        System.out.println("Took " + timeDifference + " ms to execute algorithm");
        System.out.println();
        return move;
    }

    protected abstract Move generateMove();
}
