package com.ingenious.models.board;

import com.ingenious.events.impl.BoardIsUpdatedEvent;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;


public class BoardNode {
    public int x;
    public int y;

    private boolean fixed = false;
    private Tile tile;

    public BoardNode(int x, int y, Tile tile) {
        this.x = x;
        this.y = y;
        this.tile = tile;
    }

    public BoardNode(int x, int y, Tile tile, boolean fixed) {
        this.x = x;
        this.y = y;
        this.tile = tile;
    }

    public BoardNode getClone() {
        return new BoardNode(this.x, this.y, this.tile, this.fixed);
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

    public boolean hasEmptyTile() {
        return this.tile.isAvailable();
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isOccupied() {
        return tile.isOccupied();
    }

    public boolean isEmpty() {
        return tile.isAvailable();
    }

    public Tile getTile() {
        return this.tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public void removeTile() {
        this.tile = Tile.empty;
    }

    public ArrayList<BoardNode> getNeighbours() {
        return GameServiceProvider.board().getNeighboursOfNode(this);
    }

}
