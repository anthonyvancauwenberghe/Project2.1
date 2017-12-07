package com.ingenious.algorithms.impl.tree;

import com.ingenious.algorithms.impl.State;
import com.ingenious.algorithms.impl.movegenerator.BaseMoveGenerator;
import com.ingenious.models.move.Move;

import java.util.ArrayList;

public class TreeFactory {

    public static ArrayList<Node> generateNodes(int layerLimit, State currentState)
    {
        ArrayList<Move> moves = (new BaseMoveGenerator(currentState.board, currentState.game.getCurrentPlayer().rack)).generate();
        ArrayList<Node> nodes = new ArrayList<>();

        int counter;
        for (Move move : moves) {
            counter = 0;
            Node node = new Node(move, new ArrayList<Move>());
            while (counter < layerLimit) {
                State state = currentState.getClone();
                state.board.doMove(move);
                counter++;
                ArrayList<Node> generateNodes = generateNodes(counter, state);
                for (Node aGeneratedNode : generateNodes) {
                    node.addChildNode(aGeneratedNode);
                    //System.out.println("added childnode");
                }

            }
            nodes.add(node);
        }
        System.out.println("Generated " + nodes.size() + " nodes");
        return nodes;
    }
}
