package com.ingenious.algorithms.generators;

import com.ingenious.algorithms.validators.BoardMoveValidator;
import com.ingenious.algorithms.validators.ValidateAble;
import com.ingenious.engine.Game;
import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.move.Move;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.rack.Rack;
import com.ingenious.models.tiles.Tile;

import java.util.ArrayList;

public class AvailableMovesGenerator {

    private Board board;
    private ArrayList<Piece> rack;

    public AvailableMovesGenerator(Game state) {
        this.board = state.getBoard().getClone();
        this.rack = this.getNonDuplicateRackPieces(state.getCurrentPlayer().getRack());
    }

    public AvailableMovesGenerator(Game state, boolean applyHeuristics) {
        this.board = state.getBoard().getClone();
        if (applyHeuristics)
            this.applyHeuristics();
        this.rack = this.getNonDuplicateRackPieces(state.getCurrentPlayer().getRack());
    }

    public void applyHeuristics() {
        this.fillWorthlessNodes();
    }

    private void fillWorthlessNodes() {
        for (BoardNode node : this.board.getBoardNodes()) {
            for (BoardNode neighbour : board.getNeighboursOfNode(node)) {
                if (neighbour.isEmpty()) {
                    node.setTile(Tile.occupied);
                    break;
                }
            }
        }
    }

    private ArrayList<Piece> getNonDuplicateRackPieces(Rack rack) {
        ArrayList<Piece> pieces = new ArrayList<>();

        boolean pieceIsNonDuplicate;
        for (Piece piece : rack.getContents()) {
            pieceIsNonDuplicate = true;
            for (Piece aPiece : pieces) {
                if (piece.getUniqueCode() == aPiece.getUniqueCode()) {
                    pieceIsNonDuplicate = false;
                    break;
                }
            }
            if (pieceIsNonDuplicate) {
                pieces.add(piece);
            }
        }
        return pieces;
    }

    public ArrayList<Move> generate() {
        ArrayList<Move> moves = new ArrayList<>();

        //TODO SPAWN THREADS
        for (BoardNode boardNode : this.board.getBoardNodes()) {
            if (boardNode.isEmpty()) {
                for (BoardNode neighbour : boardNode.getNeighbours()) {
                    if (neighbour.isEmpty()) {
                        for (Piece piece : this.rack) {
                            Move move = new Move(boardNode, neighbour, piece, false);
                            if (BoardMoveValidator.validateMove(this.board, move)) {
                                moves.add(move);
                            }
                            if (!piece.hasEqualTiles()) {
                                Move aMove = new Move(boardNode, neighbour, piece, false);
                                if (BoardMoveValidator.validateMove(this.board, aMove)) {
                                    moves.add(aMove);
                                }
                            }
                        }
                    }
                }
            }
            boardNode.setTile(Tile.occupied);
        }

        return moves;
    }
}
