package gui.components;

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
        //g.setColor(Color.white);
        //g.drawString("RACK COMES HERE",300,50);

        super.paintComponent(g);
        g.setColor(Color.RED);
        coordinateX = 25;
        coordinateY = 25;

        for(int i = 0; i < 6; i++)
        {
            Hexagon hexagon = new Hexagon(new Point(coordinateX,coordinateY), radius);

            g.fillPolygon(hexagon.getHexagon());

            coordinateX += 150;
        }
        coordinateX = 25;
        coordinateY = 60;

        for(int i = 0; i < 6; i++)
        {
            Hexagon hexagon2 = new Hexagon(new Point(coordinateX,coordinateY), radius);

            g.fillPolygon(hexagon2.getHexagon());

            coordinateX += 150;
        }



        //Hexagon hexagon2 = new Hexagon(new Point(40, 20), 10);


    }
}
