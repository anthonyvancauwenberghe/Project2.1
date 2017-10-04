package models.pieces;

import models.tiles.Tile;

public enum Pieces {

    REDBLUE(new Piece(Tile.red, Tile.purple)),
    REDGREEN(new Piece(Tile.red, Tile.green)),
    REDORANGE(new Piece(Tile.red, Tile.orange)),
    REDYELLOW(new Piece(Tile.red, Tile.yellow)),
    REDPURPLE(new Piece(Tile.red, Tile.purple)),
    REDRED(new Piece(Tile.red, Tile.red)),

    BLUEGREEN(new Piece(Tile.blue, Tile.green)),
    BLUEORANGE(new Piece(Tile.blue, Tile.orange)),
    BLUEYELLOW(new Piece(Tile.blue, Tile.yellow)),
    BLUEPURPLE(new Piece(Tile.blue, Tile.purple)),
    BLUEBLUE(new Piece(Tile.blue, Tile.blue)),

    GREENORANGE(new Piece(Tile.green, Tile.orange)),
    GREENYELLOW(new Piece(Tile.green, Tile.yellow)),
    GREENPURPLE(new Piece(Tile.green, Tile.purple)),
    GREENGREEN(new Piece(Tile.green, Tile.green)),

    ORANGEYELLOW(new Piece(Tile.orange, Tile.yellow)),
    ORANGEPURPLE(new Piece(Tile.orange, Tile.purple)),
    ORANGEORANGE(new Piece(Tile.orange, Tile.yellow)),

    YELLOWPURPLE(new Piece(Tile.yellow, Tile.purple)),
    YELLOWYELLOW(new Piece(Tile.yellow, Tile.yellow)),

    PURPLEPURPLE(new Piece(Tile.purple, Tile.purple));

    private Piece piece;

    Pieces(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
