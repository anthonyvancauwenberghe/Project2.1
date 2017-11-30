package com.ingenious.algorithms.impl.tree;

import com.ingenious.models.move.Move;

import java.util.ArrayList;

public class Node {

    public ArrayList<Node> nodes;
    public ArrayList<Move> parentMoves;
    public Move move;

    public Node(Move move, ArrayList<Move> parentMoves) {
        this.move = move;
        this.nodes = new ArrayList<>();
        this.parentMoves = parentMoves;
    }

    public void addChildNodeFromMove(Move move) {
        ArrayList<Move> previousMoves = new ArrayList<>();

        previousMoves.addAll(this.parentMoves);
        previousMoves.add(move);

        Node node = new Node(move, previousMoves);
        this.nodes.add(node);
    }

    public void addChildNode(Node node) {
        this.nodes.add(node);
    }


}
