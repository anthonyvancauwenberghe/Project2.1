package models.pieces;

import models.tiles.Tile;

public class Piece {

    private Tile head;
    private Tile tail;

    public Piece(Tile head, Tile tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return head.toString() + tail.toString();
    }

    public int getUniqueCode() {
        return tail.getUniqueCode() + head.getUniqueCode();
    }

    public Tile getHead() {
        return head;
    }

    public Tile getTail() {
        return tail;
    }

    public boolean hasEqualTiles() {
        return head.equals(tail);
    }

    public boolean isSamePieceAs(Piece piece) {
        return this.getUniqueCode() == piece.getUniqueCode();
    }

    public void changeHeadTile(Tile Tile) {
        this.head = Tile;
    }
}
