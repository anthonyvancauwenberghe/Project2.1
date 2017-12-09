package com.ingenious.algorithms.bots;

import com.ingenious.algorithms.generators.AvailableMovesGenerator;
import com.ingenious.engine.Game;
import com.ingenious.models.move.Move;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

/**
 * @author Anthony
 */
abstract public class BotAlgorithm implements GeneratesMove {

    private Game game;

    protected Game getGame() {
        return this.game;
    }

    public BotAlgorithm(Game game) {
        this.game = game;
    }

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

    public ArrayList<Move> generateBaseMoves(boolean heuristics) {
        AvailableMovesGenerator generator = new AvailableMovesGenerator(this.getGame(), heuristics);
        return generator.generate();
    }

    protected abstract Move generateMove();
}
