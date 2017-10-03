package gui.components;

import providers.GameServiceProvider;

import javax.swing.*;
import java.awt.*;

public class RackComponent extends JComponent {

    public RackComponent() {
        this.setVisible(true);
    }

    int coordinateX;
    int coordinateY;
    int radius = 20;

    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        coordinateX = 25;
        coordinateY = 25;

        for(int i = 0; i < 6; i++)
        {
            g.setColor(GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(i).getHead().getColor());

            Hexagon hexagon = new Hexagon(new Point(coordinateX,coordinateY), radius);

            g.fillPolygon(hexagon.getHexagon());

            coordinateX += 150;
        }
        coordinateX = 25;
        coordinateY = 60;

        for(int i = 0; i < 6; i++)
        {
            g.setColor(GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(i).getTail().getColor());

            Hexagon hexagon2 = new Hexagon(new Point(coordinateX,coordinateY), radius);

            g.fillPolygon(hexagon2.getHexagon());

            coordinateX += 150;
        }



        //Hexagon hexagon2 = new Hexagon(new Point(40, 20), 10);


    }
}
