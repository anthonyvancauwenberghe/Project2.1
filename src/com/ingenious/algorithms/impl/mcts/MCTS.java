package com.ingenious.algorithms.impl.mcts;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.Node;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.rack.Rack;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

public class MCTS {

    private Board board;
    private Rack rack;

    public MCTS() {
        this.initialize();
        System.out.println("initialized");

    }

    private void initialize() {
        this.board = GameServiceProvider.board().getClone();
        this.rack = GameServiceProvider.game().getCurrentPlayer().getRack().getClone();
    }

    public ArrayList<Move> generateBaseMoves() {
        long startTime = System.nanoTime();
        ArrayList<Move> moves = new ArrayList<>();

        for (Node node : this.board.getNodes()) {
            if (!node.isFixed()) {
                for (Node neighbour : node.getNeighbours()) {
                    if (!neighbour.isOccupied()) {
                        for (Piece piece : rack.getContents()) {
                            moves.add(new Move(node, neighbour, piece, false));
                            moves.add(new Move(node, neighbour, piece, true));
                        }
                    }

                }
            }
            node.setTile(Tile.occupied);
        }
        long endTime = System.nanoTime();
        System.out.println("Created " + moves.size() + " Moves");
        System.out.println("Creating moves took " + (endTime - startTime) / 1000000 + " ms");

        return moves;
    }
}
