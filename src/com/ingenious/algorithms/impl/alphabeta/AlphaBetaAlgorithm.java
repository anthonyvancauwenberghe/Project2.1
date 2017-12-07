package com.ingenious.algorithms.impl.alphabeta;

import com.ingenious.algorithms.Algorithm;
import com.ingenious.algorithms.impl.TreeNode;
import com.ingenious.models.move.Move;

public class AlphaBetaAlgorithm extends Algorithm{

    @Override
    public Move generate() {
        return null;
    }

    public int run(TreeNode node, int depth, int alpha, int beta, Boolean maximizing) {
        if (depth == 0 || node.hasChildren()) {
            return node.getData();
        }
        if (maximizing) {
            int v = -100;
            for (TreeNode childNode : node.getChildren()) {
                v = Math.max(v, run(childNode, depth - 1, alpha, beta, false));
                alpha = Math.max(alpha, v);
                if (beta <= alpha)
                    break;
            }
            return v;
        } else {
            int v = 100;
            for (TreeNode childNode : node.getChildren()) {
                v = Math.min(v, run(childNode, depth - 1, alpha, beta, true));
                beta = Math.min(beta, v);
                if (beta <= alpha)
                    break;
            }
            return v;
        }
    }
}
