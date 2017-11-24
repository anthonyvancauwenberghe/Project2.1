package tests.impl;

import com.ingenious.algorithms.impl.mcts.MCTS;

public class MonteCarloTesting {

    public void run() {
        try {
            MCTS branches = new MCTS();
            branches.generateBaseMoves();
        } catch (Exception exception) {

        }

    }
}
