package models.rack;


import models.bag.Bag;
import models.pieces.Piece;


import java.util.ArrayList;

public class Rack {

    private ArrayList<Piece> pieces;
    private Bag bag;

    public Rack(Bag bag) {
        this.pieces = new ArrayList<Piece>();
        this.bag = bag;
        initRack();
    }

    public void initRack() {
        for (int i = 0; i < 6; i++) {
            this.pieces.add(bag.getAndRemoveRandomPiece());
        }
    }

    public ArrayList<Piece> getContents() {
        return this.pieces;
    }
}