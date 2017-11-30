package tests.impl;

import com.ingenious.algorithms.impl.mcts.MCTSAlgorithm;

public class MonteCarloTesting {

    public void run() {
        try {
            MCTSAlgorithm branches = new MCTSAlgorithm();
            branches.generateBaseMoves();
        } catch (Exception exception) {

        }

    }
}
