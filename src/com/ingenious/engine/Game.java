package com.ingenious.engine;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.players.Player;
import com.ingenious.models.bag.Bag;
import com.ingenious.models.pieces.Piece;
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


    public Game(Board board, List<Player> players, Bag bag) {
        this.board = board;
        this.players = players;
        this.bag = bag;
        this.current_player_index = 0;
    }

    public void startGame() {
        for (Player player : players) {
            draw(player);
        }
    }

    public Player getCurrentPlayer() {
        return this.players.get(this.current_player_index);
    }

    public Player getOppenent(){
        if(current_player_index == 0){
            return this.players.get(1);
        }
        else{
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
            int newScore_1 = calculate_score(boardNode_1, boardNode_2);
            int newScore_2 = calculate_score(boardNode_2, boardNode_1);
            if (getCurrentPlayer().getRack().getContents().isEmpty()) {
                draw(getCurrentPlayer());
                turn();
            } else {
                if (bonus_play(newScore_1)){
                    bonus_play++;
                }
                if (bonus_play(newScore_2)) {
                    bonus_play++;
                }
                if (bonus_play == 0){
                    turn();
                }
            }
        }
    }


    public int calculate_score(BoardNode boardNode_1, BoardNode boardNode_2) {
        int x = boardNode_1.getX();
        int y = boardNode_1.getY();
        int l = 1;
        int score = 0;
        Tile tile = boardNode_1.getTile();

        while(this.board.getNode(x,y-l)!= null && GameServiceProvider.board().getNode(x,y-l) != boardNode_2 && tile.equals(GameServiceProvider.board().getNode(x,y-l).getTile())){
            score++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x,y+l)!= null && GameServiceProvider.board().getNode(x,y+l) != boardNode_2 && tile.equals(GameServiceProvider.board().getNode(x,y+l).getTile())){
            score++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y)!= null && GameServiceProvider.board().getNode(x + l,y) != boardNode_2 && tile.equals(GameServiceProvider.board().getNode(x + l,y).getTile())){
            score++;
           l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y)!= null && GameServiceProvider.board().getNode(x - l,y)  != boardNode_2 && tile.equals(GameServiceProvider.board().getNode(x - l,y).getTile())){
            score++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y-l)!= null && GameServiceProvider.board().getNode(x+l,y-l)  != boardNode_2 && tile.equals(GameServiceProvider.board().getNode(x+l,y-l).getTile())){
            score++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y+l)!= null && GameServiceProvider.board().getNode(x-l,y+l) != boardNode_2 &&  tile.equals(GameServiceProvider.board().getNode(x-l,y+l).getTile())){
            score++;
            l++;
        }
        int newScore = 0;
        if(tile.equals(Tile.green)){
            newScore = score+getCurrentPlayer().score().getGreenScore();
            if(newScore >18){
                newScore = 18;
            }
            getCurrentPlayer().score().setGreenScore(newScore);
        }
        else if (tile.equals(Tile.blue)){
            newScore = score+getCurrentPlayer().score().getBlueScore();
            if(newScore >18){
                newScore = 18;
            }
            getCurrentPlayer().score().setBlueScore(newScore);
        }
        else if(tile.equals(Tile.red)){
            newScore = score+getCurrentPlayer().score().getRedScore();
            if(newScore >18){
                newScore = 18;
            }
            getCurrentPlayer().score().setRedScore(newScore);
        }
        else if(tile.equals(Tile.yellow)){
            newScore = score+getCurrentPlayer().score().getYellowScore();
            if(newScore >18){
                newScore = 18;
            }
            getCurrentPlayer().score().setYellowScore(newScore);
        }
        else if(tile.equals(Tile.orange)){
            newScore = score+getCurrentPlayer().score().getOrangeScore();
            if(newScore >18){
                newScore = 18;
            }
            getCurrentPlayer().score().setOrangeScore(newScore);
        }
        else{
            newScore = score+getCurrentPlayer().score().getPurpleScore();
            if(newScore >18){
                newScore = 18;
            }
            getCurrentPlayer().score().setPurpleScore(newScore);
        }
        //repaint score
        return score;
    }

    public Score calculate_score(BoardNode boardNode_1, BoardNode boardNode_2, Board board, Score oldScore)
    {
        int x = boardNode_1.getX();
        int y = boardNode_1.getY();
        int l = 1;
        int addedScore = 0;
        Tile tile = boardNode_1.getTile();

        while(board.getNode(x,y-l)!= null && board.getNode(x,y-l) != boardNode_2 && tile.equals(board.getNode(x,y-l).getTile())){
            addedScore++;
            l++;
        }
        l = 1;
        while(board.getNode(x,y+l)!= null && board.getNode(x,y+l) != boardNode_2 && tile.equals(board.getNode(x,y+l).getTile())){
            addedScore++;
            l++;
        }
        l = 1;
        while(board.getNode(x+l,y)!= null && board.getNode(x + l,y) != boardNode_2 && tile.equals(board.getNode(x + l,y).getTile())){
            addedScore++;
            l++;
        }
        l = 1;
        while(board.getNode(x-l,y)!= null && board.getNode(x - l,y)  != boardNode_2 && tile.equals(board.getNode(x - l,y).getTile())){
            addedScore++;
            l++;
        }
        l = 1;
        while(board.getNode(x+l,y-l)!= null && board.getNode(x+l,y-l)  != boardNode_2 && tile.equals(board.getNode(x+l,y-l).getTile())){
            addedScore++;
            l++;
        }
        l = 1;
        while(board.getNode(x-l,y+l)!= null && board.getNode(x-l,y+l) != boardNode_2 &&  tile.equals(board.getNode(x-l,y+l).getTile())){
            addedScore++;
            l++;
        }
        int newScore = 0;
        if(tile.equals(Tile.green)){
            newScore = addedScore+oldScore.getGreenScore();
            if(newScore >18){
                newScore = 18;
            }
            oldScore.setGreenScore(newScore);
        }
        else if (tile.equals(Tile.blue)){
            newScore = addedScore+oldScore.getBlueScore();
            if(newScore >18){
                newScore = 18;
            }
            oldScore.setBlueScore(newScore);
        }
        else if(tile.equals(Tile.red)){
            newScore = addedScore+oldScore.getRedScore();
            if(newScore >18){
                newScore = 18;
            }
            oldScore.setRedScore(newScore);
        }
        else if(tile.equals(Tile.yellow)){
            newScore = addedScore+oldScore.getYellowScore();
            if(newScore >18){
                newScore = 18;
            }
            oldScore.setYellowScore(newScore);
        }
        else if(tile.equals(Tile.orange)){
            newScore = addedScore+oldScore.getOrangeScore();
            if(newScore >18){
                newScore = 18;
            }
            oldScore.setOrangeScore(newScore);
        }
        else{
            newScore = addedScore+oldScore.getPurpleScore();
            if(newScore >18){
                newScore = 18;
            }
            oldScore.setPurpleScore(newScore);
        }
        //repaint score
        return oldScore;
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
    }

    public void setNextPlayerAsCurrent() {
            if (this.current_player_index == 1) {
                this.current_player_index = 0;
            } else {
                this.current_player_index++;
        }
    }

    public boolean valid_placement(Piece piece, BoardNode boardNode_1, BoardNode boardNode_2) {
        if(boardNode_1.isOccupied() || boardNode_2.isOccupied()){
            return false;
        }
        ArrayList<BoardNode> neighbours_1 = board.getNeighboursOfNode(boardNode_1);
        ArrayList<BoardNode> neighbours_2 = board.getNeighboursOfNode(boardNode_2);
        if(!neighbours_1.contains(boardNode_2)){
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


