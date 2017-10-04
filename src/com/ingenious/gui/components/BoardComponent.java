package com.ingenious.gui.components;

import com.ingenious.providers.impl.GameServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alexisguillot on 14/09/2017.
 */
public class BoardComponent extends JComponent{

    public BoardComponent() {
        this.setVisible(true);
    }

    int size = 30;
    float width = size * 2;
    float height =  width * 3/4;

        int startingX = 350; // coordinates for node 0,0
        int startingY = 253;

    int[] testnodecoord = {-1,2};

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        ArrayList<com.ingenious.models.board.Node> nP = GameServiceProvider.board().getNodes();

        for(int i = 0; i < nP.size(); i++)
        {
            int[] xP = new int[6];
            int[] yP = new int[6];
            int nodeX;
            int nodeY;

            //adjust x and y of node to actual location
            nodeX = (int) (startingX + (nP.get(i).x * (0.75 * width)));
            nodeY =  (int) (startingY + (nP.get(i).y * height) + (nP.get(i).x * 0.5 * height));

            if(nP.get(i).x == testnodecoord[0] && nP.get(i).y == testnodecoord[1])
            {
                testnodecoord[0] = nodeX;
                testnodecoord[1] = nodeY;
            }

            //starting point is on the far left, clockwise
            xP[0] = (int) (nodeX - (0.5 * width));	// -1/2w, y
            yP[0] = nodeY;
            xP[1] = (int) (nodeX - (0.25 * width));	// -1/4w, -1/2h
            yP[1] = (int) (nodeY - (0.5 * height));
            xP[2] = (int) (nodeX + (0.25 * width));	// +1/4w, -1/2h
            yP[2] = (int) (nodeY - (0.5 * height));
            xP[3] = (int) (nodeX + (0.5 * width));	// +1/2w, y
            yP[3] = nodeY;
            xP[4] = (int) (nodeX + (0.25 * width));	// +1/4w, +1/2h
            yP[4] = (int) (nodeY + (0.5 * height));
            xP[5] = (int) (nodeX - (0.25 * width));	// -1/4w, +1/2h
            yP[5] = (int) (nodeY + (0.5 * height));


            g.setColor(nP.get(i).getTile());
            //g.setColor(nP.get(i).getColor());

            g.fillPolygon(xP, yP, 6);

            g.setColor(new Color(0,0,0));
            g.drawPolygon(xP, yP, 6);

            //g.drawString(nP.get(i).x + ", " + nP.get(i).y, nodeX, nodeY);
        }

        int[] hex = point_to_hex( testnodecoord[0], testnodecoord[1]);
        System.out.println("Center point: " + testnodecoord[0] + ", " + testnodecoord[1]);
        System.out.println(hex[0] + ", " + hex[1]);
    }

    /*public int[] pixel_to_hex(int x, int y)
    {
        int q = x * 2/3 / size;
        int r = (int) Math.round((-x / 3 + Math.sqrt(3) / 3 * y) / size);
        int[] n = {q,r};
        return n;
    }*/

    public int[] point_to_hex(int x, int y)
    {
        int q = (int) Math.round((x - startingX) / (0.75 * width));
        int r = (int) Math.round((y - startingY - (q * 0.5 * height)) / height);

        int[] n = {q,r};
        return n;
    }
}
