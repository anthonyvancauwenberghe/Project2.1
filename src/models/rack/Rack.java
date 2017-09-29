package models.rack;



import models.pieces.Piece;


import java.util.ArrayList;

public class Rack {

    private ArrayList<Piece> rack;

    public Rack(){
        this.rack = new ArrayList<Piece>();
    }

    public ArrayList<Piece> getRack(){
        return this.rack;
    }
}
