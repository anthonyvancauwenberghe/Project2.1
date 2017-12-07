package com.ingenious.algorithms.impl.tree;

import com.ingenious.algorithms.impl.State;
import com.ingenious.models.move.Move;

import java.util.ArrayList;

public class Tree {
    private State root;
    private ArrayList<Node> nodes;

    public Tree(State root, ArrayList<Node> nodes)
    {
        this.root = root;
        this.nodes = nodes;
    }

    public State getNodeState(Node node) {
        State state = this.root.getClone();

        for (Move move : node.parentMoves) {
            state.board.doMove(move);
        }
        state.board.doMove(node.move);

        return state;
    }

    public State getParentState(Node node)
    {
        State state = this.root.getClone();

        for (Move move : node.parentMoves) {
            state.board.doMove(move);
        }

        return state;
    }

    public State getRootState() {
        return root;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }
}
