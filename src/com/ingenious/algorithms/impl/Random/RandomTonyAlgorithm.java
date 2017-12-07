package com.ingenious.algorithms.impl.Random;

import com.ingenious.algorithms.Algorithm;
import com.ingenious.algorithms.impl.tree.AvailableMovesFactory;
import com.ingenious.engine.Game;
import com.ingenious.models.move.Move;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTonyAlgorithm extends Algorithm {
    private Game game;

    public Game getGame() {
        if (this.game == null)
            this.game = GameServiceProvider.game().getClone();
        return this.game;
    }

    @Override
    public Move generate() {
        System.out.println("executing tony random algorithm");
        AvailableMovesFactory movesFactory = new AvailableMovesFactory(this.getGame());
        ArrayList<Move> moves = movesFactory.generate();
        int i = ThreadLocalRandom.current().nextInt(0, moves.size());
        Move move = moves.get(i);

        System.out.println("doing move" + move.toString());
        return moves.get(i);
    }
}
