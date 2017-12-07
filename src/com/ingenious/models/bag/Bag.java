package com.ingenious.models.bag;

import com.ingenious.models.pieces.Piece;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Bag {

    private ArrayList<Piece> pieces;

    public Bag() {
        pieces = new ArrayList<>();
        this.fillBag();
    }

    public Bag(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public Bag getClone() {
        ArrayList<Piece> pieces = new ArrayList<>();

        for (Piece piece : this.pieces) {
            pieces.add(piece.getClone());
        }

        return new Bag(pieces);
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(Piece piece) {
        Piece pieceToReturn = null;
        for (Piece aPiece : pieces) {
            if (aPiece.getUniqueCode() == piece.getUniqueCode()) {
                pieceToReturn = aPiece;
            }
        }
        if (pieceToReturn == null)
            System.out.println("couldn't get the piece in the bag. Piece is not in the bag");

        return pieceToReturn;
    }

    public Piece getAndRemovePiece(Piece piece) {
        Piece pieceToReturn = null;
        pieceToReturn = this.getPiece(piece);
        this.removePiece(piece);
        return pieceToReturn;
    }

    public Piece getAndRemoveRandomPiece() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, this.pieces.size());
        Piece piece = this.pieces.get(randomIndex);
        this.pieces.remove(randomIndex);
        return piece;
    }

    public void removePiece(Piece piece) {
        int indexOfPiece = -1;
        for (Piece aPiece : pieces) {
            if (aPiece.getUniqueCode() == piece.getUniqueCode()) {
                indexOfPiece = pieces.indexOf(aPiece);
                break;
            }
        }
        if (indexOfPiece == -1)
            System.out.println("couldn't remove the piece in the bag. Piece is not in the bag");
        else
            pieces.remove(indexOfPiece);
    }

    private void fillBag() {

        /* FILL THE BAG WITH 6 PIECES OF A DIFFERENT COLOR */
        for (int i = 0; i < 6; i++) {
            this.addPiece(Piece.RED_BLUE);
            this.addPiece(Piece.RED_GREEN);
            this.addPiece(Piece.RED_ORANGE);
            this.addPiece(Piece.RED_YELLOW);
            this.addPiece(Piece.RED_PURPLE);

            this.addPiece(Piece.BLUE_GREEN);
            this.addPiece(Piece.BLUE_ORANGE);
            this.addPiece(Piece.BLUE_YELLOW);
            this.addPiece(Piece.BLUE_PURPLE);

            this.addPiece(Piece.GREEN_ORANGE);
            this.addPiece(Piece.GREEN_YELLOW);
            this.addPiece(Piece.GREEN_PURPLE);

            this.addPiece(Piece.ORANGE_YELLOW);
            this.addPiece(Piece.ORANGE_PURPLE);

            this.addPiece(Piece.YELLOW_PURPLE);
        }

        /* FILL THE BAG WITH 5 PIECES OF THE SAME COLOR */
        for (int i = 0; i < 5; i++) {
            this.addPiece(Piece.RED_RED);
            this.addPiece(Piece.BLUE_BLUE);
            this.addPiece(Piece.GREEN_GREEN);
            this.addPiece(Piece.ORANGE_ORANGE);
            this.addPiece(Piece.YELLOW_YELLOW);
            this.addPiece(Piece.PURPLE_PURPLE);
        }
    }

    public void refillBag() {
        this.pieces.clear();
        this.fillBag();
    }

    public boolean isEmpty() {
        return this.pieces.isEmpty();
    }
}
