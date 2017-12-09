package com.ingenious.algorithms.bots.algorithms.mcts;

import com.ingenious.algorithms.bots.BotAlgorithm;
import com.ingenious.algorithms.bots.GeneratesMove;
import com.ingenious.algorithms.bots.algorithms.Random.RandomAlgorithm;
import com.ingenious.engine.Game;
import com.ingenious.models.move.Move;

import java.util.ArrayList;

public class MCTSAlgorithm extends BotAlgorithm {

    /* Amount of simulations per basemove */
    private int simulations;

    public MCTSAlgorithm(Game game,int simulations) {
        super(game);
        this.simulations = simulations;
    }

    public MCTSAlgorithm(Game game) {
        super(game);
        this.simulations = 10;
    }

    @Override
    public Move generateMove() {

        ArrayList<Move> baseMoves = this.generateBaseMoves(true);

        int[] totalWins = new int[baseMoves.size()];

        int wins;
        int index = 0;
        for (Move baseMove : baseMoves) {
            wins = 0;

            Game baseGame = this.getGame().getClone();
            baseGame.doBotMove(baseMove);

            int simulationRound = 0;

            while (simulationRound < this.simulations) {

                Game game = baseGame.getClone();

                while (!game.isOver()) {
                    GeneratesMove randomAlgorithm = new RandomAlgorithm(game);
                    Move randomMove = randomAlgorithm.generate();
                    System.out.println("doing simulation move");
                    game.doBotMove(randomMove);
                }

                if (game.isWinner(game.getPlayers().get(1))) {
                    wins++;
                }

                simulationRound++;

            }
            totalWins[index] = wins;
            index++;
        }

        int maxValueIndex = 0;
        for (int i = 0; i < totalWins.length; i++) {
            if (totalWins[i] > totalWins[maxValueIndex]) ;
            maxValueIndex = i;
        }


        return baseMoves.get(maxValueIndex);
    }


}
