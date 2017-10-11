package com.ingenious.gui.components;

import java.awt.*;
import com.ingenious.config.Configuration;

/**
 * Created by danig on 10/2/2017.
 */
public class Hexagon
{
    //private final int radius;
    private final Point center;
    private final Polygon hexagon;

    private static int SIZE = Configuration.hexagonSize;
    private static float WIDTH = SIZE * 2;
    private static float HEIGHT = WIDTH * 3 / 4;

    public Hexagon(Point center)
    {
        this.center = center;
        //this.radius = radius;
        this.hexagon = createHexagon();
    }

    /*private Polygon createHexagon() {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 6; i++) {
            int xval = (int) (center.x + radius
                    * Math.cos(i * 2 * Math.PI / 6D));
            int yval = (int) (center.y + radius
                    * Math.sin(i * 2 * Math.PI / 6D));
            polygon.addPoint(xval, yval);
        }

        return polygon;
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }
    */
    public Polygon getHexagon() {
        return hexagon;
    }
    public static float getWidth() {
        return WIDTH;
    }
    public static float getHeight() {
        return HEIGHT;
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
