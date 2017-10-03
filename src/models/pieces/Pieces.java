package models.pieces;

import java.awt.*;

public enum Pieces {

    REDBLUE(new Piece(Color.red, Color.BLUE)),
    REDGREEN(new Piece(Color.red, Color.green)),
    REDORANGE(new Piece(Color.red, Color.orange)),
    REDYELLOW(new Piece(Color.red, Color.yellow)),
    REDPURPLE(new Piece(Color.red, new Color(160, 32, 240))),
    REDRED(new Piece(Color.red, Color.red)),

    BLUEGREEN(new Piece(Color.blue, Color.green)),
    BLUEORANGE(new Piece(Color.blue, Color.orange)),
    BLUEYELLOW(new Piece(Color.blue, Color.yellow)),
    BLUEPURPLE(new Piece(Color.blue, new Color(160, 32, 240))),
    BLUEBLUE(new Piece(Color.blue, Color.blue)),

    GREENORANGE(new Piece(Color.green, Color.orange)),
    GREENYELLOW(new Piece(Color.green, Color.yellow)),
    GREENPURPLE(new Piece(Color.green, new Color(160, 32, 240))),
    GREENGREEN(new Piece(Color.green, Color.green)),

    ORANGEYELLOW(new Piece(Color.orange, Color.yellow)),
    ORANGEPURPLE(new Piece(Color.orange, new Color(160, 32, 240))),
    ORANGEORANGE(new Piece(Color.orange, Color.yellow)),

    YELLOWPURPLE(new Piece(Color.yellow, new Color(160, 32, 240))),
    YELLOWYELLOW(new Piece(Color.yellow, Color.yellow)),

    PURPLEPURPLE(new Piece(new Color(160, 32, 240), new Color(160, 32, 240)));

    private Piece piece;

    Pieces(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
