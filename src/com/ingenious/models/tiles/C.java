package com.ingenious.models.tiles;

import java.awt.*;

public enum C
{
        EMPTY,
        RED,
        GREEN,
        BLUE,
        ORANGE,
        YELLOW,
        PURPLE,
        T_RED,
        T_GREEN,
        T_BLUE,
        T_ORANGE,
        T_YELLOW,
        T_PURPLE,
        LINE;

        private static int alpha = 20;

    public static Color getColor(C c)
    {
        Color rC;
        switch (c)
        {
            case EMPTY:
                rC = Color.white;
                break;
            case RED:
                rC = Color.red;
                break;
            case GREEN:
                rC = Color.green;
                break;
            case BLUE:
                rC = Color.blue;
                break;
            case ORANGE:
                rC = new Color(255, 140, 0);
                break;
            case YELLOW:
                rC = Color.yellow;
                break;
            case PURPLE:
                rC = new Color(160, 32, 240);
                break;
            case T_RED:
                rC = new Color(255,0,0, alpha);
                break;
            case T_GREEN:
                rC = new Color(0,255,0, alpha);
                break;
            case T_BLUE:
                rC = new Color(0,0,255, alpha);
                break;
            case T_ORANGE:
                rC = new Color(255, 140, 0, alpha);
                break;
            case T_YELLOW:
                rC = new Color(0,255,255, alpha);
                break;
            case T_PURPLE:
                rC = new Color(160, 32, 240, alpha);
                break;
                //case LINE is also default
            case LINE: default:
                rC = Color.black;
                break;
        }
        return rC;
    }
    public static Color[] getTileColors()
    {
        Color[] c =
                {
                        C.getColor(C.RED),
                        C.getColor(C.GREEN),
                        C.getColor(C.BLUE),
                        C.getColor(C.ORANGE),
                        C.getColor(C.YELLOW),
                        C.getColor(C.PURPLE)
                };
        return c;
    }

    public static Color getTransparantColor(C c)
    {
        Color rC = null;
        switch (c)
        {
            case RED:
                rC = C.getColor(C.T_RED);
                break;
            case GREEN:
                rC =  C.getColor(C.T_GREEN);
                break;
            case BLUE:
                rC =  C.getColor(C.T_BLUE);
                break;
            case ORANGE:
                rC =  C.getColor(C.T_ORANGE);
                break;
            case T_YELLOW:
                rC =  C.getColor(C.T_YELLOW);
                break;
            case PURPLE:
                rC =  C.getColor(C.T_PURPLE);
                break;
        }
        return rC;
    }

    public static Color makeTransparant(Color c)
    {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();

        return new Color(r,g,b, alpha);
    }
}