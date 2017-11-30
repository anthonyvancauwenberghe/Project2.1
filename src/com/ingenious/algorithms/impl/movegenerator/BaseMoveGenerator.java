package com.ingenious.algorithms.impl.movegenerator;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.move.Move;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.rack.Rack;
import com.ingenious.models.tiles.Tile;

import java.util.ArrayList;

public class BaseMoveGenerator {

    private Board board;
    private ArrayList<Piece> rack;

    public BaseMoveGenerator(Board board, Rack rack) {
        this.board = board;
        this.rack = this.getNonDuplicateRackPieces(rack);
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
        long startTime = System.nanoTime();
        ArrayList<Move> moves = new ArrayList<>();
        Board board = this.board.getClone();
        //TODO SPAWN THREADS
        for (BoardNode boardNode : board.getBoardNodes()) {
            if (boardNode.isEmpty()) {
                for (BoardNode neighbour : boardNode.getNeighbours()) {
                    if (neighbour.isEmpty()) {
                        for (Piece piece : this.rack) {
                            if (piece.hasEqualTiles()) {
                                moves.add(new Move(boardNode, neighbour, piece, false));
                            } else {
                                moves.add(new Move(boardNode, neighbour, piece, false));
                                moves.add(new Move(boardNode, neighbour, piece, true));
                            }
                        }
                    }
                }
            }
            boardNode.setTile(Tile.occupied);
        }
        long endTime = System.nanoTime();
        System.out.println("Created " + moves.size() + " Moves");
        System.out.println("Creating moves took " + (endTime - startTime) / 1000000 + " ms");

        return moves;
    }


}
