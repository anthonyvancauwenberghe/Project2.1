package com.ingenious.algorithms.impl.Random;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.move.Move;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.rack.Rack;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

/**
 * Created by carolley on 03-Dec-17.
 */
public class Random {


    private Board board;
    private Rack rack;

    public Random(){
        board = GameServiceProvider.board();
        rack = GameServiceProvider.players().getPlayer(0).getRack();
    }

    public Move randomPlay() {
        Piece piece = getRandomPiece();
        BoardNode[] place = getRandomPlace();
        return new Move(place[0], place[1], piece, false);
    }


    public BoardNode[] getRandomPlace() {
        ArrayList<BoardNode> possible_nodes = emptyNodes();
        int head_index = (int) Math.random() * possible_nodes.size();
        BoardNode head = possible_nodes.get(head_index);
        BoardNode tail = getRandomEmptyNeighbour(head);
        BoardNode[] random_place = {head, tail};
        return random_place;
    }

    public ArrayList<BoardNode> emptyNodes() {
        ArrayList<BoardNode> emptyNodes = new ArrayList<>();
        ArrayList<BoardNode> nodes = board.getBoardNodes();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).isEmpty() && hasEmptyNeighbours(nodes.get(i))) {
                emptyNodes.add(board.getBoardNodes().get(i));
            }
        }
        return emptyNodes;
    }

    public boolean hasEmptyNeighbours(BoardNode node) {
        ArrayList<BoardNode> neighbours = node.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public BoardNode getRandomEmptyNeighbour(BoardNode node) {
        int tail_index = (int) (Math.random() * node.getNeighbours().size());
        BoardNode tail = node.getNeighbours().get(tail_index);
        while (tail.isOccupied()) {
            getRandomEmptyNeighbour(node);
        }
        return tail;
    }

    public Piece getRandomPiece() {
        this.rack.setPieceSelected((int) (Math.random() * rack.getContents().size()));
        while (this.rack.getPieceSelected().equals(null)) {
            getRandomPiece();
        }
        return this.rack.getPieceSelected();
    }
}
