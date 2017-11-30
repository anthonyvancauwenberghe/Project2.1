package com.ingenious.models.move;

import com.ingenious.models.board.BoardNode;
import com.ingenious.models.pieces.Piece;

public class Move {

    private Piece piece;

    private BoardNode boardNode;
    private BoardNode boardNode2;

    private boolean inverted;

    public Move(BoardNode boardNode, BoardNode boardNode2, Piece piece, boolean inverted) {
        this.piece = piece;
        this.boardNode = boardNode;
        this.boardNode2 = boardNode2;
        this.inverted = inverted;
    }

    public Piece getPiece() {
        return piece;
    }

    public BoardNode getBoardNode() {
        return boardNode;
    }

    public BoardNode getBoardNode2() { return boardNode2;}

    public boolean isInverted() {
        return inverted;
    }
}
