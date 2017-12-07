package com.ingenious.algorithms.impl.tree;

import com.ingenious.algorithms.impl.State;
import com.ingenious.engine.Game;
import com.ingenious.models.move.Move;

import java.util.ArrayList;

public class Tree {
    private Game root;
    private ArrayList<Node> nodes;

    public Tree(Game root, ArrayList<Node> nodes) {
        this.root = root;
        this.nodes = nodes;
    }

    public Game getNodeState(Node node) {
        Game state = this.root.getClone();

        for (Move move : node.parentMoves) {
            state.getBoard().doMove(move);
        }
        state.getBoard().doMove(node.move);

        return state;
    }

    public Game getParentState(Node node) {
        Game state = this.root.getClone();

        for (Move move : node.parentMoves) {
            state.getBoard().doMove(move);
        }

        return state;
    }

    public Game getRootState() {
        return root;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }
}
