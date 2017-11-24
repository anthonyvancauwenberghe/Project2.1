package com.ingenious.models.tiles;

import java.awt.*;

public enum C
{
    EMPTY,
    GRAY,
    RED,
    GREEN,
    BLUE,
    ORANGE,
    YELLOW,
    PURPLE,
    LINE;

        private static int alpha = 40;

    public static Color getColor(C c)
    {
        Color rC;
        switch (c)
        {
            case EMPTY:
                rC = new Color(255,255,255);
                break;
            case GRAY:
                rC = new Color(128, 128, 128);
                break;
            case RED:
                rC = new Color(255,0,0);
                break;
            case GREEN:
                rC = new Color(0,255,0);
                break;
            case BLUE:
                rC = new Color(0,0,255);
                break;
            case ORANGE:
                rC = new Color(255, 140, 0);
                break;
            case YELLOW:
                rC = new Color(255,255,0);
                break;
            case PURPLE:
                rC = new Color(160, 32, 240);
                break;
                //case LINE is also default
            case LINE: default:
                rC = new Color(0,0,0);
                break;
        }
        return rC;
    }

    public static Color getColor(C c, boolean transparency)
    {
        Color rC;
        if(!transparency)
            rC = C.getColor(c);

        else
        {
            switch (c)
            {
                case GRAY:
                    rC = new Color(128, 128, 128, alpha);
                    break;
                case RED:
                    rC = new Color(255, 0, 0, alpha);
                    break;
                case GREEN:
                    rC = new Color(0, 255, 0, alpha);
                    break;
                case BLUE:
                    rC = new Color(0, 0, 255, alpha);
                    break;
                case ORANGE:
                    rC = new Color(255, 140, 0, alpha);
                    break;
                case YELLOW:
                    rC = new Color(255, 255, 0, alpha);
                    break;
                case PURPLE:
                    rC = new Color(160, 32, 240, alpha);
                    break;
                default:
                    rC = null;
                    break;
            }
        }
        return rC;
    }

    public static C[] getTileColors()
    {
        C[] c =
                {
                        C.RED,
                        C.GREEN,
                        C.BLUE,
                        C.ORANGE,
                        C.YELLOW,
                        C.PURPLE
                };
        return c;
    }
}