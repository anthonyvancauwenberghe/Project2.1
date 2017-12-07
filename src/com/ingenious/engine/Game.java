package com.ingenious.engine;

import com.ingenious.algorithms.impl.scorecalculator.ScoreCalculator;
import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.move.Move;
import com.ingenious.models.players.Player;
import com.ingenious.models.bag.Bag;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.players.impl.Bot;
import com.ingenious.models.score.Score;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolley on 29-Sep-17.
 */
public class Game {

    private Board board;
    private Bag bag;
    private List<Player> players;
    private int current_player_index;

    public int bonus_play = 0;

    public Board getBoard() {
        return board;
    }

    public Bag getBag() {
        return bag;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Game getClone() {
        ArrayList<Player> players = new ArrayList<>();
        for (Player player : this.players) {
            players.add(player.getClone());
        }
        return new Game(this.board, players, this.bag);
    }

    public Game(Board board, List<Player> players, Bag bag) {
        this.board = board;
        this.players = players;
        this.bag = bag;
        this.current_player_index = 0;
    }


    public Player getCurrentPlayer() {
        return this.players.get(this.current_player_index);
    }

    public Player getOppenent() {
        if (current_player_index == 0) {
            return this.players.get(1);
        } else {
            return this.players.get(0);
        }
    }

    public void draw(Player player) {
        for (int i = 0; i < 6; i++) {
            Piece piece = bag.getAndRemoveRandomPiece();
            player.getRack().getContents().set(i, piece);
        }
    }

    public void swap() {
        for (int i = 0; i < 6; i++) {
            bag.addPiece(getCurrentPlayer().getRack().getContents().get(i));
        }
        draw(getCurrentPlayer());
    }


    //at the end of each turn make sure you have 6 tiles
    public void refresh() {
        getCurrentPlayer().getRack().getContents().add(bag.getAndRemoveRandomPiece());
    }


    public void place_piece(Piece piece, BoardNode boardNode_1, BoardNode boardNode_2) {
        if (valid_placement(piece, boardNode_1, boardNode_2)) {
            getCurrentPlayer().getRack().setPieceSelected(-1);
            if (bonus_play != 0) {
                bonus_play--;
            }
            getCurrentPlayer().getRack().getContents().remove(piece);
            board.addTile(piece.getHead(), boardNode_1);
            board.addTile(piece.getTail(), boardNode_2);
            this.calculate_score(boardNode_1, boardNode_2);
            if (getCurrentPlayer().getRack().getContents().isEmpty()) {
                draw(getCurrentPlayer());
                turn();
            } else {
                if (bonus_play(ScoreCalculator.getScoreStreak(this.board, boardNode_1, boardNode_2))) {
                    bonus_play++;
                }
                if (bonus_play(ScoreCalculator.getScoreStreak(this.board, boardNode_2, boardNode_1))) {
                    bonus_play++;
                }
                if (bonus_play == 0) {
                    turn();
                }
            }
        }
    }

    public boolean doMove(Move move) {
        Piece piece = move.getPiece();
        BoardNode boardNode_1 = move.getBoardNode();
        BoardNode boardNode_2 = move.getBoardNode2();
        System.out.println(boardNode_1.getX()+" "+boardNode_1.getY()+" "+boardNode_2.getX()+" "+boardNode_2.getY());
        if (valid_placement(piece, boardNode_1, boardNode_2)) {
            getCurrentPlayer().getRack().setPieceSelected(-1);
            if (bonus_play != 0) {
                bonus_play--;
            }
            getCurrentPlayer().getRack().getContents().remove(piece);
            board.addTile(piece.getHead(), boardNode_1);
            board.addTile(piece.getTail(), boardNode_2);
            this.calculate_score(boardNode_1, boardNode_2);
            if (getCurrentPlayer().getRack().getContents().isEmpty()) {
                draw(getCurrentPlayer());
                turn();
            } else {
                if (bonus_play(ScoreCalculator.getScoreStreak(this.board, boardNode_1, boardNode_2))) {
                    bonus_play++;
                }
                if (bonus_play(ScoreCalculator.getScoreStreak(this.board, boardNode_2, boardNode_1))) {
                    bonus_play++;
                }
                if (bonus_play == 0) {
                    turn();
                }
            }
            return true;
        }
        return false;
    }


    public Score calculate_score(BoardNode boardNode_1, BoardNode boardNode_2) {
        return ScoreCalculator.calculate(boardNode_1, boardNode_2, this.board, this.getCurrentPlayer().score);
    }

    public boolean bonus_play(int newScore) {
        if (newScore >= 18) {
            return true;
        }
        return false;
    }

    public boolean won() {
        for (int i = 0; i < 6; i++) {
            if (getCurrentPlayer().getScoreArray()[i] >= 18) {
                return true;
            }
        }
        return false;
    }

    public void turn() {
        while (getCurrentPlayer().getRack().getContents().size() < 6) {
            refresh();
        }

        if (won()) {
            System.out.println(getCurrentPlayer().getName() + " has won the game");
        }

        setNextPlayerAsCurrent();
        bonus_play = 0;

        System.out.println("switching to next player");

        System.out.println(this.getCurrentPlayer().getName());
        if (this.getCurrentPlayer().isBot()) {
            System.out.println("is bot!");
            Bot bot = (Bot) this.getCurrentPlayer();
            bot.executeMove();
        }
    }

    public void setNextPlayerAsCurrent() {
        if (this.current_player_index == 1) {
            this.current_player_index = 0;
        } else {
            this.current_player_index++;
        }
    }

    public boolean valid_placement(Piece piece, BoardNode boardNode_1, BoardNode boardNode_2) {
        if (boardNode_1.isOccupied() || boardNode_2.isOccupied()) {
            return false;
        }
        ArrayList<BoardNode> neighbours_1 = board.getNeighboursOfNode(boardNode_1);
        ArrayList<BoardNode> neighbours_2 = board.getNeighboursOfNode(boardNode_2);
        if (!neighbours_1.contains(boardNode_2)) {
            return false;
        }/*
            for (int i = 0; i < neighbours_1.size(); i++) {
                if (neighbours_1.get(i).getTile().equals(piece.getHead())){
                        return true;
                }
            }
            for(int i=0; i<neighbours_2.size(); i++){
                if(neighbours_2.get(i).getTile().equals(piece.getTail())){
                    return true;
                }
            }*/

        return true;
    }

}


