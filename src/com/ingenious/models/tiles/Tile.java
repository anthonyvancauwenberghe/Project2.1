package com.ingenious.models.tiles;

import java.awt.*;

public class Tile extends Color {

    public final static Tile empty = new Tile(255, 255, 255);

    public final static Tile red = new Tile(255, 0, 0);
    public final static Tile blue = new Tile(0, 0, 255);
    public final static Tile green = new Tile(0, 255, 0);
    public final static Tile orange = new Tile(255, 200, 0);
    public final static Tile yellow = new Tile(255, 255, 0);
    public final static Tile purple = new Tile(160, 32, 240);


    public Tile(int r, int g, int b) {
        super(r, g, b);
    }

    public int getUniqueCode() {
        int redCode = 5 * this.getRed();
        int blueCode = 10 * this.getBlue();
        int greenCode = 20 * this.getRed();

        return redCode + blueCode + greenCode;
    }

    public boolean isEmpty() {
        return this.equals(Tile.empty);
    }
}
