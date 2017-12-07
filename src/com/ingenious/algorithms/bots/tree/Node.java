package com.ingenious.algorithms.bots.tree;

import com.ingenious.models.move.Move;

import java.util.ArrayList;

public class Node {

    public ArrayList<Node> children;
    public ArrayList<Move> parentMoves;
    public Move move;

    public Node(Move move) {
        this.move = move;
        this.children = new ArrayList<>();
        this.parentMoves = new ArrayList<>();
    }


    public Node(Move move, ArrayList<Move> parentMoves) {
        this.move = move;
        this.children = new ArrayList<>();
        this.parentMoves = parentMoves;
    }

    public void addChildNode(Node node) {
        this.children.add(node);
    }

    public void setChildNodes(ArrayList<Node> nodes) {
        this.children = nodes;
    }


}
