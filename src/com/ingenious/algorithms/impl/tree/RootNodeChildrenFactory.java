package com.ingenious.algorithms.impl.tree;

import com.ingenious.engine.Game;
import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.move.Move;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.rack.Rack;
import com.ingenious.models.tiles.Tile;

import java.util.ArrayList;

public class RootNodeChildrenFactory {

    private Board board;
    private ArrayList<Piece> rack;

    public RootNodeChildrenFactory(Game state) {
        this.board = state.getBoard().getClone();
        this.fillWorthlessNodes();
        this.rack = this.getNonDuplicateRackPieces(state.getCurrentPlayer().getRack());
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

    public ArrayList<Node> generate() {
        ArrayList<Node> nodes = new ArrayList<>();

        //TODO SPAWN THREADS
        for (BoardNode boardNode : this.board.getBoardNodes()) {
            if (boardNode.isEmpty()) {
                for (BoardNode neighbour : boardNode.getNeighbours()) {
                    if (neighbour.isEmpty()) {
                        for (Piece piece : this.rack) {
                            if (piece.hasEqualTiles()) {
                                nodes.add(new Node(new Move(boardNode, neighbour, piece, false)));
                            } else {
                                nodes.add(new Node(new Move(boardNode, neighbour, piece, false)));
                                nodes.add(new Node(new Move(boardNode, neighbour, piece, true)));
                            }
                        }
                    }
                }
            }
            boardNode.setTile(Tile.occupied);
        }


        return nodes;
    }
}
