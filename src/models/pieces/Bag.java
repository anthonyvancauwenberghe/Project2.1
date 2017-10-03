package models.pieces;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Bag {

    public ArrayList<Piece> pieces;

    public Bag() {
        pieces = new ArrayList<>();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
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
}
