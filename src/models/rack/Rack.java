package models.rack;



import models.pieces.Bag;
import models.pieces.Piece;


import java.util.ArrayList;

public class Rack {

    private ArrayList<Piece> rack;

    public Rack(){
        System.out.println("rack constructor called");
        this.rack = new ArrayList<Piece>();
        initRack();
    }

    public void initRack(){
        for(int i=0; i<6; i++){
            this.rack.add(Bag.random_draw());
        }
    }

    public ArrayList<Piece> getContents(){
        return this.rack;
    }
}