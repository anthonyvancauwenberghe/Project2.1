package com.ingenious.models.tiles;

import java.awt.*;

public class Tile extends Color {

    public final static Tile empty = new Tile(C.EMPTY);

    public final static Tile red = new Tile(C.RED);
    public final static Tile blue = new Tile(C.BLUE);
    public final static Tile green = new Tile(C.GREEN);
    public final static Tile orange = new Tile(C.ORANGE);
    public final static Tile yellow = new Tile(C.YELLOW);
    public final static Tile purple = new Tile(C.PURPLE);

    public final C color;

    public Tile(C c)
    {
        super(C.getColor(c).getRGB());
        color = c;
    }

    public C getColorName()
    {
        return color;
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
