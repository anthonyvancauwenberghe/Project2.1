package com.ingenious.models.rack;


import com.ingenious.models.bag.Bag;
import com.ingenious.models.pieces.Piece;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rack implements Cloneable {

    private ArrayList<Piece> pieces;
    private Bag bag;
    private int indexSelected;

    public Rack(Bag bag) {
        this.pieces = new ArrayList<Piece>();
        this.bag = bag;
        initRack();
        this.indexSelected = -1;
    }

    public Rack(ArrayList<Piece> pieces, Bag bag, int indexSelected) {
        this.pieces = pieces;
        this.bag = bag;
        this.indexSelected = indexSelected;
    }

    public Rack getClone() {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Piece piece : this.pieces) {
            pieces.add(piece.getClone());
        }
        return new Rack(pieces, this.bag.getClone(), this.indexSelected);
    }

    public void initRack() {
        for (int i = 0; i < 6; i++) {
            this.pieces.add(bag.getAndRemoveRandomPiece());
        }
    }

    public void setPieceSelected(int i) {
        this.indexSelected = i;
    }

    public int getIndexSelected() {
        return this.indexSelected;
    }

    public Piece getPieceSelected() {
        if (selected()) {
            return this.pieces.get((indexSelected));
        } else
            return null;
    }

    public boolean selected() {
        if (this.indexSelected == -1) {
            return false;
        } else
            return true;
    }

    public ArrayList<Piece> getContents() {
        return this.pieces;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}