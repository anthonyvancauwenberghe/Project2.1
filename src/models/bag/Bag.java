package models.bag;

import models.pieces.Piece;
import models.pieces.Pieces;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Bag {

    private ArrayList<Piece> pieces;

    public Bag() {
        pieces = new ArrayList<>();
        this.fillBag();
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
            this.addPiece(Pieces.REDBLUE.getPiece());
            this.addPiece(Pieces.REDGREEN.getPiece());
            this.addPiece(Pieces.REDORANGE.getPiece());
            this.addPiece(Pieces.REDYELLOW.getPiece());
            this.addPiece(Pieces.REDPURPLE.getPiece());

            this.addPiece(Pieces.BLUEGREEN.getPiece());
            this.addPiece(Pieces.BLUEORANGE.getPiece());
            this.addPiece(Pieces.BLUEYELLOW.getPiece());
            this.addPiece(Pieces.BLUEPURPLE.getPiece());

            this.addPiece(Pieces.GREENORANGE.getPiece());
            this.addPiece(Pieces.GREENYELLOW.getPiece());
            this.addPiece(Pieces.GREENPURPLE.getPiece());

            this.addPiece(Pieces.ORANGEYELLOW.getPiece());
            this.addPiece(Pieces.ORANGEPURPLE.getPiece());

            this.addPiece(Pieces.YELLOWPURPLE.getPiece());
        }

        /* FILL THE BAG WITH 5 PIECES OF THE SAME COLOR */
        for (int i = 0; i < 5; i++) {
            this.addPiece(Pieces.REDRED.getPiece());
            this.addPiece(Pieces.BLUEBLUE.getPiece());
            this.addPiece(Pieces.GREENGREEN.getPiece());
            this.addPiece(Pieces.ORANGEORANGE.getPiece());
            this.addPiece(Pieces.YELLOWYELLOW.getPiece());
            this.addPiece(Pieces.PURPLEPURPLE.getPiece());
        }
    }

    public void refillBag(){
        this.pieces.clear();
        this.fillBag();
    }
}
