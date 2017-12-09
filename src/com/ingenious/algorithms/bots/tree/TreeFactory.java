package com.ingenious.algorithms.bots.tree;

import com.ingenious.algorithms.generators.AvailableMovesGenerator;
import com.ingenious.engine.Game;
import com.ingenious.models.move.Move;

import java.util.ArrayList;

public class TreeFactory {

    private Game state;
    private int layerLimit;

    public TreeFactory(Game state) {
        this.state = state;
        this.layerLimit = 0;
    }

    public TreeFactory(Game game, int layerLimit) {
        this.state = game;
        this.layerLimit = layerLimit;
    }

    public ArrayList<Move> generateRootNodes(Game state) {
        AvailableMovesGenerator factory = new AvailableMovesGenerator(state);
        return factory.generate();
    }




    /*

    public ArrayList<Node> generateNodeChildren(Node node, Game state) {
        state.getBoard().getClone().doMove(node.move);
        ArrayList<Node> childrenNodes = generateRootNodes(state);
        node.setChildNodes(childrenNodes);
        return node.children;
    }

    public ArrayList<Node> generateAllNodesChildren(ArrayList<Node> baseNodes, int layer) {
        ArrayList<Node> children = new ArrayList<>();

        long startTime = System.nanoTime();

        for (Node node : baseNodes) {
            children = this.generateNodeChildren(node, this.state);
        }

        long endTime = System.nanoTime();
        System.out.println("Creating basenodes took " + (endTime - startTime) / 1000000 + " ms");

        while (layer < layerLimit) {
            long startTime2 = System.nanoTime();
            for (Node childNode : children) {
                Game state = this.state.getClone();
                state.getBoard().doMove(childNode.move);
                this.generateNodeChildren(childNode, state);
            }
            long endTime2 = System.nanoTime();
            System.out.println("Creating basenodes at layer " + layer + " took " + (endTime2 - startTime2) / 1000000 + " ms");
            layer++;
        }
        return baseNodes;
    }

    public void run() {

        ArrayList<Node> baseNodes = generateRootNodes(this.state);
        ArrayList<Node> nodes = generateAllNodesChildren(baseNodes,0);

    }

    public Tree generate() {
        ArrayList<Node> baseNodes = generateRootNodes(this.state);

        return new Tree(this.state, baseNodes);
    }
    */
}
