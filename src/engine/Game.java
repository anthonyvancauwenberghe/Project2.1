package engine;

import models.board.Board;
import models.board.Node;
import models.entities.players.Player;
import models.pieces.Bag;
import models.pieces.Piece;

import java.util.ArrayList;

/**
 * Created by carolley on 29-Sep-17.
 */
public class Game {

    public Board board;
    public Bag bag;
    public Player current_player;
    public Player player_1;
    public Player player_2;
    public int bonus_play = 0;


    public Game(){
        this.board = new Board();
        this.bag = new Bag();
        this.player_1 = new Player("A",1);
        draw(player_1);
        this.player_2 = new Player("B",2);
        draw(player_2);
        this.current_player = player_1;
    }

    public void draw(Player player){
        for(int i=0; i<6; i++){
            Piece piece = bag.random_draw();
            player.getRack().getContents().set(i, piece);
        }
    }

    public void refresh(){
        current_player.getRack().getContents().add(bag.random_draw());
    }


    public void place_piece(Piece piece, Node node_1, Node node_2){
        if(valid_placement(piece, node_1)){
            if(bonus_play !=0){
                bonus_play--;
            }
            current_player.getRack().getContents().remove(piece);
            board.addTile(piece.getHead(), node_1);
            board.addTile(piece.getTail(), node_2);
        }
        int newScore_1 = calculate_score(node_1, node_2);
        int newScore_2 = calculate_score(node_2, node_1);
        if(current_player.getRack().getContents().isEmpty()){
            draw(current_player);
            turn();
        }
        else{
            if(bonus_play(newScore_1)){
                bonus_play++;
            }
            if(bonus_play(newScore_2)){
                bonus_play++;
            }
            if(bonus_play==0){
                turn();
            }
        }
    }

    public int calculate_score(Node node_1, Node node_2){
        return 0;
    }

    public boolean bonus_play(int newScore){
        if(newScore>18){
            return true;
        }
        return false;
    }

    public void swap(){
        for(int i=0; i<6; i++){
            bag.add(current_player.getRack().getContents().get(i));
        }
        draw(current_player);
    }

    public boolean won(){
        for(int i=0; i<6; i++){
            if(!current_player.getScore().get(i).equals(18)){
                return false;
            }
        }
        return true;
    }


    public void turn(){
        if(won()){
            //endgame
        }
        if(current_player.equals(player_1)){
            current_player = player_2;
            bonus_play =0;
        }
        else{
            current_player = player_1;
            bonus_play = 0;
        }
    }

    public boolean valid_placement(Piece piece, Node node){
        ArrayList<Node> neighbours = board.neighbours(node);
        if(piece.getHead().getColor() == piece.getTail().getColor()){
            int cnt = 0;
            for(int i=0; i<neighbours.size(); i++){
                if(neighbours.get(i).getColor()== piece.getHead().getColor()){
                    cnt++;
                    if(cnt==2){
                        return true;
                    }
                }
            }

        }
        else{
            for(int i=0; i<neighbours.size(); i++){
                if(neighbours.get(i).getColor()== piece.getHead().getColor()){
                    return true;
                }
            }
        }

        return false;
    }
}
