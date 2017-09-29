package models.board;

import models.pieces.Piece;

import java.awt.*;


public class Node {
    public int x;
    public int y;

    private int id;
    private boolean fixed;
    private Piece piece;
    private Color color;

    public Node(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Node(int id, int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getCoord(){
        int [] coord = {x,y};
        return coord;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }
}
