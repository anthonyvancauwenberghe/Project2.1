package com.ingenious.algorithms.generators;

import com.ingenious.algorithms.validators.BoardMoveValidator;
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
        this.applyHeuristics();
    }

    public AvailableMovesGenerator(Game state, boolean applyHeuristics) {
        this.board = state.getBoard().getClone();
        if (applyHeuristics)
            this.applyHeuristics();
        this.rack = this.getNonDuplicateRackPieces(state.getCurrentPlayer().getRack());
    }

    public void applyHeuristics() {
        long startTime = System.nanoTime();
        this.fillLonelyNodes();
        long endTime = System.nanoTime();
        double timeDifference = ((double) endTime - (double) startTime) / 1000000;
        System.out.println("Applying heuristics to movegenerator Took " + timeDifference + " ms");
    }

    private void fillLonelyNodes() {
        for (BoardNode node : this.board.getBoardNodes()) {
            if (node.isAvailable()) {
                for (BoardNode neighbour : this.board.getNeighboursOfNode(node)) {
                    node.setTile(Tile.occupied);
                    if (!neighbour.isAvailable()) {
                        node.setTile(Tile.empty);
                        break;
                    }
                }
            }
        }

        ArrayList<BoardNode> emptyNodes = new ArrayList<>();

        for (BoardNode node : this.board.getBoardNodes()) {
            if (node.isReallyEmpty()) {
                emptyNodes.add(node);
            }
        }

        for (BoardNode node : emptyNodes) {
            for (BoardNode neighbour : this.board.getNeighboursOfNode(node)) {
                if (neighbour.isAvailable())
                    neighbour.setTile(Tile.empty);
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
        long startTime = System.nanoTime();
        ArrayList<Move> moves = new ArrayList<>();

        for (BoardNode boardNode : this.board.getBoardNodes()) {
            if (boardNode.isReallyEmpty()) {
                for (BoardNode neighbour : boardNode.getNeighbours()) {
                    if (neighbour.isEmpty() && !boardNode.isOccupied()) {
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
        }
        long endTime = System.nanoTime();
        double timeDifference = ((double) endTime - (double) startTime) / 1000000;
        System.out.println("Generating " + moves.size() + " moves took " + timeDifference + " ms");
        return moves;
    }
}
