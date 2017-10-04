package models.board;

import models.tiles.Tile;


public class Node {
    public int x;
    public int y;

    private boolean fixed;
    private Tile tile;

    public Node(int x, int y, Tile tile) {
        this.x = x;
        this.y = y;
        this.tile = tile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getCoord() {
        int[] coord = {x, y};
        return coord;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isOccupied() {
        return !tile.isEmpty();
    }

    public Tile getTile() {
        return this.tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void removeTile() {
        this.tile = Tile.empty;
    }
}
