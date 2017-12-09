package com.ingenious.algorithms.bots.algorithms.Random;

import com.ingenious.algorithms.bots.BotAlgorithm;
import com.ingenious.algorithms.generators.AvailableMovesGenerator;
import com.ingenious.engine.Game;
import com.ingenious.models.move.Move;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAlgorithm extends BotAlgorithm {

    public RandomAlgorithm(Game game) {
        super(game);
    }

    @Override
    public Move generateMove() {
        AvailableMovesGenerator movesFactory = new AvailableMovesGenerator(this.getGame());
        ArrayList<Move> moves = movesFactory.generate();
            int i = ThreadLocalRandom.current().nextInt(0, moves.size());
            if (moves.size() == 0)
                System.out.println("NO VALID MOVES LEFT");
            return moves.get(i);
    }
}
