package com.ingenious.algorithms.validators;

import com.ingenious.models.board.Board;
import com.ingenious.models.move.Move;

public class BoardMoveValidator implements ValidateAble {
    private Board board;
    private Move move;

    public BoardMoveValidator(Board board, Move move) {
        this.board = board;
        this.move = move;
    }


    public boolean validate() {
        if(this.board.getNode(this.move.getBoardNode().x, this.move.getBoardNode().y).isEmpty() && this.board.getNode(this.move.getBoardNode().x, this.move.getBoardNode().y).isEmpty()
                && this.move.getBoardNode().getNeighbours().contains(this.move.getBoardNode2())){
            return true;
        }
        return false;
    }

    public static boolean validateMove(Board board, Move move) {
        return (new BoardMoveValidator(board, move)).validate();
    }
}
