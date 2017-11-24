package com.ingenious.algorithms.impl.mcts;

import com.ingenious.models.board.Node;
import com.ingenious.models.pieces.Piece;

public class Move {

    private Piece piece;

    private Node node;
    private Node node2;

    private boolean inverted;

    public Move(Node node, Node node2, Piece piece, boolean inverted) {
        this.piece = piece;
        this.node = node;
        this.node2 = node2;
        this.inverted = inverted;
    }

    public Piece getPiece() {
        return piece;
    }

    public Node getNode() {
        return node;
    }

    public Node getNode2() { return node2;}

    public boolean isInverted() {
        return inverted;
    }
}
