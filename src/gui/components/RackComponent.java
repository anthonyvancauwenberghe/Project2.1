package gui.components;

import models.pieces.Piece;
import providers.impl.GameServiceProvider;

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

    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        super.paintComponent(g);
        coordinateX = 100;
        coordinateY = 25;

        for (int i = 0; i < 6; i++) {
            g.setColor(GameServiceProvider.players().getPlayer(1).getRack().getContents().get(i).getHead());

            Hexagon hexagon = new Hexagon(new Point(coordinateX, coordinateY), radius);

            g.fillPolygon(hexagon.getHexagon());
            g.setColor(new Color(0, 0, 0));
            g.drawPolygon(hexagon.getHexagon());

            coordinateX += 100;
        }
        coordinateX = 100;
        coordinateY = 60;

        for (int i = 0; i < 6; i++) {
            g.setColor(GameServiceProvider.players().getPlayer(1).getRack().getContents().get(i).getTail());

            Hexagon hexagon2 = new Hexagon(new Point(coordinateX, coordinateY), radius);

            g.fillPolygon(hexagon2.getHexagon());
            g.setColor(new Color(0, 0, 0));
            g.drawPolygon(hexagon2.getHexagon());
            coordinateX += 100;
        }

        MouseSpy listener = new MouseSpy();
        addMouseListener(listener);

    }

    class MouseSpy implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Piece clicked = null;
            float x = e.getX();
            if (x <= 100) {
                clicked = GameServiceProvider.players().getPlayer(1).getRack().getContents().get(0);
            }
            if (x > 100 && x <= 200) {
                clicked = GameServiceProvider.players().getPlayer(1).getRack().getContents().get(1);
            }
            if (x > 200 && x <= 300) {
                clicked = GameServiceProvider.players().getPlayer(1).getRack().getContents().get(2);
            }
            if (x > 300 && x <= 400) {
                clicked = GameServiceProvider.players().getPlayer(1).getRack().getContents().get(3);
            }
            if (x > 400 && x <= 500) {
                clicked = GameServiceProvider.players().getPlayer(1).getRack().getContents().get(4);
            }
            if (x > 500 && x <= 600) {
                clicked = GameServiceProvider.players().getPlayer(1).getRack().getContents().get(5);
            }
            System.out.print(clicked.getHead().toString() + " " + clicked.getTail().toString());
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
