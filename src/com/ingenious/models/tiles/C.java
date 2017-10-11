package com.ingenious.models.tiles;

import java.awt.*;

public enum C
{
        EMPTY,
        RED,
        BLUE,
        GREEN,
        ORANGE,
        YELLOW,
        PURPLE,
        LINE;

    public static Color getColor(C c) {
        Color rC;
        switch (c) {
            case EMPTY:
                rC = Color.white;
                break;
            case RED:
                rC = Color.red;
                break;
            case BLUE:
                rC = Color.blue;
                break;
            case GREEN:
                rC = Color.green;
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
                //case LINE is also default
            case LINE: default:
                rC = Color.black;
                break;
        }
        return rC;
    }
}