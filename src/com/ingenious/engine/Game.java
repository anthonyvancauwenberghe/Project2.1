package com.ingenious.engine;

import com.ingenious.algorithms.bots.GeneratesMove;
import com.ingenious.algorithms.calculators.ScoreCalculator;
import com.ingenious.algorithms.validators.BoardMoveValidator;
import com.ingenious.algorithms.validators.ValidateAble;
import com.ingenious.engine.logic.impl.GameOverLogic;
import com.ingenious.events.impl.BoardIsUpdatedEvent;
import com.ingenious.models.bag.Bag;
import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.move.Move;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.players.Player;
import com.ingenious.models.players.impl.Bot;
import com.ingenious.models.score.Score;
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

    public void drawRandomPieceFromBag(Player player) {
        for (int i = 0; i < 6; i++) {
            Piece piece = bag.getAndRemoveRandomPiece();
            player.getRack().getContents().set(i, piece);
        }
    }

    public void swap() {
        for (int i = 0; i < 6; i++) {
            bag.addPiece(getCurrentPlayer().getRack().getContents().get(i));
        }
        drawRandomPieceFromBag(getCurrentPlayer());
    }


    //at the end of each turn make sure you have 6 tiles
    public void refresh() {
        getCurrentPlayer().getRack().getContents().add(bag.getAndRemoveRandomPiece());
    }

    public boolean doSimulationMove(Move move) {

        if (!this.validMove(move))
            System.out.println("ERROR BOT INVALID MOVE!!!!");

        Piece piece = move.getPiece();
        BoardNode boardNode_1, boardNode_2;
        if (!move.isInverted()) {
            boardNode_1 = this.board.getNode(move.getBoardNode().x, move.getBoardNode().y);
            boardNode_2 = this.board.getNode(move.getBoardNode2().x, move.getBoardNode2().y);
        } else {
            boardNode_2 = this.board.getNode(move.getBoardNode().x, move.getBoardNode().y);
            boardNode_1 = this.board.getNode(move.getBoardNode2().x, move.getBoardNode2().y);
        }

        if (bonus_play != 0) {
            bonus_play--;
        }
        getCurrentPlayer().getRack().removePiece(piece);
        board.addTile(piece.getHead(), boardNode_1);
        board.addTile(piece.getTail(), boardNode_2);


        this.calculate_score(boardNode_1, boardNode_2);
        
        if (getCurrentPlayer().getRack().isEmpty()) {
            drawRandomPieceFromBag(getCurrentPlayer());
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

    public boolean doBotMove(Move move) {

        if (!this.validMove(move))
            System.out.println("ERROR BOT INVALID MOVE!!!!");

        Piece piece = move.getPiece();
        BoardNode boardNode_1, boardNode_2;
        if (!move.isInverted()) {
            boardNode_1 = this.board.getNode(move.getBoardNode().x, move.getBoardNode().y);
            boardNode_2 = this.board.getNode(move.getBoardNode2().x, move.getBoardNode2().y);
        } else {
            boardNode_2 = this.board.getNode(move.getBoardNode().x, move.getBoardNode().y);
            boardNode_1 = this.board.getNode(move.getBoardNode2().x, move.getBoardNode2().y);
        }

        if (bonus_play != 0) {
            bonus_play--;
        }
        getCurrentPlayer().getRack().removePiece(piece);
        board.addTile(piece.getHead(), boardNode_1);
        board.addTile(piece.getTail(), boardNode_2);
        new BoardIsUpdatedEvent();


        this.calculate_score(boardNode_1, boardNode_2);
        this.calculate_score(boardNode_2,boardNode_1);
        if (getCurrentPlayer().getRack().isEmpty()) {
            drawRandomPieceFromBag(getCurrentPlayer());
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


    public boolean place_piece(Piece piece, BoardNode boardNode_1, BoardNode boardNode_2) {
        if (validPlacement(piece, boardNode_1, boardNode_2)) {
            getCurrentPlayer().getRack().setPieceSelected(-1);
            if (bonus_play != 0) {
                bonus_play--;
            }
            getCurrentPlayer().getRack().getContents().remove(piece);
            board.addTile(piece.getHead(), boardNode_1);
            board.addTile(piece.getTail(), boardNode_2);
            this.calculate_score(boardNode_1, boardNode_2);
            this.calculate_score(boardNode_2, boardNode_1);
            if (getCurrentPlayer().getRack().getContents().isEmpty()) {
                drawRandomPieceFromBag(getCurrentPlayer());
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
        } else {
            System.out.println("INVALID MOVE");
        }
        return false;
    }

    public boolean doMove(Move move) {
        Piece piece = move.getPiece();
        BoardNode boardNode_1, boardNode_2;
        if (!move.isInverted()) {
            boardNode_1 = move.getBoardNode();
            boardNode_2 = move.getBoardNode2();
        } else {
            boardNode_2 = move.getBoardNode();
            boardNode_1 = move.getBoardNode2();
        }

        return this.place_piece(piece, boardNode_1, boardNode_2);
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


    public boolean isOver() {
        GameOverLogic logic = new GameOverLogic(this);
        return logic.calculate();
    }

    public boolean won() {
        for (int i = 0; i < 6; i++) {
            if (getCurrentPlayer().getScoreArray()[i] >= 18) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinner(Player player) {
        return isOver() && this.getCurrentPlayer().getName().equals(player.getName());
    }

    public void turn() {
        if (!this.isOver()) {
            while (getCurrentPlayer().getRack().getContents().size() < 6) {
                refresh();
            }

            if (won()) {
                System.out.println(getCurrentPlayer().getName() + " has won the game");
            }

            setNextPlayerAsCurrent();
            bonus_play = 0;

            if (this.getCurrentPlayer() instanceof GeneratesMove) {
                Bot bot = (Bot) this.getCurrentPlayer();
                this.doBotMove(bot.generate());
            }
        } else {
            System.out.println("game is over");
            System.out.println(getCurrentPlayer().getName() + " has won the game");
        }
    }

    public void setNextPlayerAsCurrent() {
        if (this.current_player_index == 1) {
            this.current_player_index = 0;
        } else {
            this.current_player_index++;
        }
    }

    public boolean validPlacement(Piece piece, BoardNode boardNode_1, BoardNode boardNode_2) {
        if (boardNode_1.isOccupied() || boardNode_2.isOccupied()) {
            return false;
        }
        ArrayList<BoardNode> neighbours_1 = board.getNeighboursOfNode(boardNode_1);
        ArrayList<BoardNode> neighbours_2 = board.getNeighboursOfNode(boardNode_2);
        if (!neighbours_1.contains(boardNode_2)) {
            return false;
        }

        return true;
    }

    public boolean validMove(Move move) {
        ValidateAble moveValidator = new BoardMoveValidator(this.board, move);
        return moveValidator.validate();
    }

    public void setBoard(Board board) {
        this.board = board;
        GameServiceProvider.getInstance().board = board;
        new BoardIsUpdatedEvent();
    }

}


