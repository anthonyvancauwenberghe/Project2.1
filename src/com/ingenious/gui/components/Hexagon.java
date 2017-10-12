package com.ingenious.gui.components;

import java.awt.*;
import com.ingenious.config.Configuration;

/**
 * Created by danig on 10/2/2017.
 */
public class Hexagon
{
    private final Point center;
    private final Polygon hexagon;

    private static int SIZE = Configuration.hexagonSize;
    private static float WIDTH = SIZE * 2;
    private static float HEIGHT = WIDTH * 3 / 4;

    public Hexagon(Point center)
    {
        this.center = center;
        this.hexagon = createHexagon();
    }

    public Polygon getHexagon() {
        return hexagon;
    }
    public static float getWidth() {
        return WIDTH;
    }
    public static float getHeight() {
        return HEIGHT;
    }
    public static double getHalfHeight() {
        return (HEIGHT * 0.5);
    }

    private Polygon createHexagon()
    {
        Polygon polygon = new Polygon();
        
        //clockwise, with starting point on the far left
        polygon.addPoint(
                (int) (center.x - (0.5 * WIDTH)),    // -1/2w, y
                center.y
        );
        polygon.addPoint(
                (int) (center.x - (0.25 * WIDTH)),    // -1/4w, -1/2h
                (int) (center.y - (0.5 * HEIGHT))
        );
        polygon.addPoint(
                (int) (center.x + (0.25 * WIDTH)),    // +1/4w, -1/2h
                (int) (center.y - (0.5 * HEIGHT))
        );
        polygon.addPoint(
                (int) (center.x + (0.5 * WIDTH)),    // +1/2w, y
                center.y
        );
        polygon.addPoint(
                (int) (center.x + (0.25 * WIDTH)),    // +1/4w, +1/2h
                (int) (center.y + (0.5 * HEIGHT))
        );
        polygon.addPoint(
                (int) (center.x - (0.25 * WIDTH)),    // -1/4w, +1/2h
                (int) (center.y + (0.5 * HEIGHT))
        );
        return polygon;
    }
}
