package com.ingenious.algorithms.bots.algorithms.Random;

import com.ingenious.algorithms.bots.BotAlgorithm;
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
public class Random extends BotAlgorithm {

    private Board board;
    private Rack rack;

    public Board getBoard() {
        if (this.board == null)
            this.board = GameServiceProvider.board().getClone();
        return board;
    }

    public Rack getRack() {
        if (this.rack == null)
            this.rack = GameServiceProvider.players().getPlayer(1).getRack().getClone();
        return rack;
    }

    public Move generateMove() {
        System.out.println("generating random move");
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
        ArrayList<BoardNode> nodes = getBoard().getBoardNodes();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).isEmpty() && hasEmptyNeighbours(nodes.get(i))) {
                emptyNodes.add(getBoard().getBoardNodes().get(i));
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
        this.getRack().setPieceSelected((int) (Math.random() * getRack().getContents().size()));
        while (this.getRack().getPieceSelected().equals(null)) {
            getRandomPiece();
        }
        return this.getRack().getPieceSelected();
    }
}
