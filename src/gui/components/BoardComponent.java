package gui.components;

import models.board.Board;
import providers.GameServiceProvider;

import javax.swing.*;
import javax.xml.soap.Node;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by alexisguillot on 14/09/2017.
 */
public class BoardComponent extends JComponent{

    public BoardComponent() {
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {

        int size = 30;
        float width = size * 2;
        float height =  width * 3/4;

        int startingX = 350; // coordinates for node 0,0
        int startingY = 250;

        ArrayList<models.board.Node> nP = GameServiceProvider.getBoardProvider().getBoard().getNodes();
		/*nP.add(new Nodes(-2,-2));
		nP.add(new Nodes(-2,-1));
		nP.add(new Nodes(-2,0));
		nP.add(new Nodes(-2,1));
		nP.add(new Nodes(-2,2));
		nP.add(new Nodes(-1,-2));
		nP.add(new Nodes(-1,-1));
		nP.add(new Nodes(-1,0));
		nP.add(new Nodes(-1,1));
		nP.add(new Nodes(-1,2));
		nP.add(new Nodes(0,-2));
		nP.add(new Nodes(0,-1));
		nP.add(new Nodes(0,0));
		nP.add(new Nodes(0,1));
		nP.add(new Nodes(0,2));
		nP.add(new Nodes(1,-2));
		nP.add(new Nodes(1,-1));
		nP.add(new Nodes(1,0));
		nP.add(new Nodes(1,1));
		nP.add(new Nodes(1,2));
		nP.add(new Nodes(2,-2));
		nP.add(new Nodes(2,-1));
		nP.add(new Nodes(2,0));
		nP.add(new Nodes(2,1));
		nP.add(new Nodes(2,2));*/

        for(int i = 0; i < nP.size(); i++)
        {
            int[] xP = new int[6];
            int[] yP = new int[6];
            int nodeX;
            int nodeY;

            //adjust x and y of node to actual location
            nodeX = (int) (startingX + (nP.get(i).x * (0.75 * width)));
            nodeY =  (int) (startingY + (nP.get(i).y * height) + (nP.get(i).x * 0.5 * height));


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



            g.setColor(new Color(0,0,0));
            g.fillPolygon(xP, yP, 6);

            g.setColor(new Color(255,0,0));
            g.drawPolygon(xP, yP, 6);

            //g.drawString(nP.get(i).x + ", " + nP.get(i).y, nodeX, nodeY);
        }
    }
}
