package models.pieces;

import java.awt.*;

public class Piece {

    private Color head;
    private Color tail;

    public Piece(Color head, Color tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return head.toString() + tail.toString();
    }

    public int getUniqueCode() {
        int redCode = 2 * head.getRed() + 5 * tail.getRed();
        int blueCode = 10 * head.getBlue() + 20 * tail.getBlue();
        int greenCode = 25 * head.getRed() + 50 * tail.getRed();

        return redCode + blueCode + greenCode;
    }

    public Color getHead() {
        return head;
    }

    public Color getTail() {
        return tail;
    }

    public boolean hasEqualColors() {
        return head.equals(tail);
    }

    public boolean isSamePieceAs(Piece piece) {
        return this.getUniqueCode() == piece.getUniqueCode();
    }
}
