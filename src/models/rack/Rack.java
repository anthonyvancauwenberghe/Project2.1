package models.rack;



import models.pieces.Piece;


import java.util.ArrayList;

public class Rack {

    private ArrayList<Piece> rack;

    public Rack(){
        this.rack = new ArrayList<Piece>();
        initRack();
    }

    public void initRack(){
        for(int i=0; i<6; i++){
            this.rack.add(null);
        }
    }

    public ArrayList<Piece> getContents(){
        return this.rack;
    }
}
