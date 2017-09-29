package models.pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by carolley on 29-Sep-17.
 */
public class Bag {

    private ArrayList<Piece> piece_types;
    private Map<Piece, Integer> pieces;
    //purple = pink
    private Color[] colors = {Color.red, Color.green, Color.blue, Color.orange, Color.yellow, Color.pink};

    public Bag(){
        this.piece_types = new ArrayList<Piece>();
        this.pieces = new HashMap<Piece, Integer>();
        color_combos();
    }

    public void remove(Piece piece){
        int oldValue = pieces.get(piece);
        if(oldValue == 1){
            pieces.remove(piece);
        }
        else{
            pieces.replace(piece, oldValue, oldValue-1);
        }
    }

    public void add(Piece piece){
        int oldValue = pieces.get(piece);
        if(oldValue == piece.n_available()){
            //give error
        }
        else{
            pieces.replace(piece, oldValue, oldValue+1);
        }
    }

    public boolean isEmpy(){
        return pieces.isEmpty();
    }

    public ArrayList<Piece> color_combos(){
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        for(int i=0; i<colors.length; i++){
            for(int j=i; j<colors.length; j++){
                Piece piece = new Piece(new Tile(colors[i]), new Tile(colors[j]));
                this.piece_types.add(piece);
                this.pieces.put(piece, piece.n_available());
            }
        }
        return pieces;
    }

    public int size(){
        int size = 0;
        for(int i=0; i<piece_types.size(); i++){
            size = size + pieces.get(piece_types.get(i));
        }
        return size;
    }

    public Piece random_draw(){
        int r = (int) (Math.random()*21);
        Piece piece = piece_types.get(r);
        if(pieces.containsKey(piece_types.get(r))){
            remove(piece);
            return piece;
        }
        else{
            return random_draw();
        }
    }
}
