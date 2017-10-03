package gui.components;

import models.pieces.Piece;
import providers.GameServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

            coordinateX += 100;
        }
        coordinateX = 25;
        coordinateY = 60;

        for(int i = 0; i < 6; i++)
        {
            g.setColor(GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(i).getTail().getColor());

            Hexagon hexagon2 = new Hexagon(new Point(coordinateX,coordinateY), radius);

            g.fillPolygon(hexagon2.getHexagon());

            coordinateX += 100;
        }

        MouseSpy listener = new MouseSpy();
        addMouseListener(listener);

    }
    class MouseSpy implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            Piece clicked = null;
            float x = e.getX();
            //float y = e.getY();
            if(x<=100){
               clicked = GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(0);

            }if(x > 100 && x <= 200 ){
                clicked = GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(1);
            }if(x > 200 && x <= 300){
                clicked = GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(2);
            }if(x > 300 && x <= 400){
                clicked = GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(3);
            }if(x > 400 && x <= 500){
                clicked = GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(4);
            }if(x > 500 && x <= 600){
                clicked = GameServiceProvider.getPlayerProvider().getPlayer(1).getRack().getContents().get(5);
            }
            System.out.print(clicked.getHead().getColor() +" "+ clicked.getTail().getColor());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
