package models.pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by carolley on 29-Sep-17.
 */
public class Bag {

    private static ArrayList<Piece> piece_types;
    private static Map<Piece, Integer> pieces;
    //purple = pink
    private Color[] colors = {Color.red, Color.green, Color.blue, Color.orange, Color.yellow, new Color(160, 32, 240)};

    public Bag()
    {
        this.piece_types = new ArrayList<Piece>();
        this.pieces = new HashMap<Piece, Integer>();
        color_combos();
    }

    public static void remove(Piece piece){
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
                System.out.println(piece.toString());
                this.piece_types.add(piece);
                this.pieces.put(piece, piece.n_available());
            }
        }
        System.out.println(piece_types.size());
        return pieces;
    }

    public int size(){
        int size = 0;
        for(int i=0; i<piece_types.size(); i++){
            size = size + pieces.get(piece_types.get(i));
        }
        return size;
    }

    public static Piece random_draw(){
        int r = (int) (Math.random()*piece_types.size());
        Piece piece = piece_types.get(r);
        if(pieces.containsKey(piece_types.get(r))){
            remove(piece);
            System.out.println("I have added the following piece to your rack: "+ piece.toString());
            return piece;
        }
        else{
            return random_draw();
        }
    }
}
