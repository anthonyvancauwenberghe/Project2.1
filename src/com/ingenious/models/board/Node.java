package com.ingenious.models.board;

import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;


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

    public ArrayList<Node> getNeighbours() {
        return GameServiceProvider.board().getNeighboursOfNode(this);
    }
}
