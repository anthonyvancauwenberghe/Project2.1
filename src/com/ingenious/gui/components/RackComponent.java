package com.ingenious.gui.components;

import com.ingenious.models.pieces.Piece;
import com.ingenious.providers.impl.GameServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RackComponent extends JComponent {

    public RackComponent() {
        this.setVisible(true);
    }

    int coordinateX;
    int coordinateY;
    int radius = 20;
    private int MovingMode = -1;
    private Piece MovingPiece;
    private int MovingPieceX, MovingPieceY;

    private void changeMovingMode(int i)
    {
        if(0 <= i && i < 6) //make sure i is within bounds of rack
        {
            if (MovingMode == -1) //pick up a piece
                MovingMode = i;
            else if (MovingMode == i) //put down a piece
                MovingMode = -1;
            else //exchange a piece
                MovingMode = i;
        }
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        super.paintComponent(g);

        coordinateX = 100;

        for (int i = 0; i < 6; i++)
        {
            coordinateY = 25;

            g.setColor(GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(i).getHead());

            Hexagon hexagon;
            if(MovingMode == i)
                hexagon = new Hexagon(new Point(MovingPieceX, MovingPieceY), radius);
            else
                hexagon = new Hexagon(new Point(coordinateX, coordinateY), radius);

                g.fillPolygon(hexagon.getHexagon());
                g.setColor(new Color(0, 0, 0));
                g.drawPolygon(hexagon.getHexagon());

                coordinateY = 60;

                g.setColor(GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(i).getTail());

            Hexagon hexagon2;
            if(MovingMode == i)
                hexagon2 = new Hexagon(new Point(MovingPieceX, MovingPieceY + 35), radius);
            else
                hexagon2 = new Hexagon(new Point(coordinateX, coordinateY), radius);

                g.fillPolygon(hexagon2.getHexagon());
                g.setColor(new Color(0, 0, 0));
                g.drawPolygon(hexagon2.getHexagon());

                coordinateX += 100;

        }

        MouseSpy listener = new MouseSpy();
        addMouseListener(listener);
        MouseWatcher watcher = new MouseWatcher();
        addMouseMotionListener(watcher);
    }

    class MouseWatcher implements MouseMotionListener {
        @Override
        public void mouseMoved(MouseEvent e) {
            if (MovingMode != -1) {
                MovingPieceX = e.getX();
                MovingPieceY = e.getY();
                repaint();

                //System.out.print("Mouse: " + e.getX() + ", " + e.getY());
                System.out.println("Piece moved to: " + MovingPieceX + ", " + MovingPieceY);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {}
    }

    class MouseSpy implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Piece clicked = null;
            float x = e.getX();
            if (x >= 60 && x <= 130) {
                clicked = GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(0);
                //System.out.println("Hex is clicked");
                changeMovingMode(0);
            }
            if (x >= 170 && x <= 230) {
                clicked = GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(1);
                changeMovingMode(1);
            }
            if (x >= 270 && x <= 330) {
                clicked = GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(2);
                changeMovingMode(2);
            }
            if (x >= 370 && x <= 430) {
                clicked = GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(3);
                changeMovingMode(3);
            }
            if (x >= 470 && x <= 530) {
                clicked = GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(4);
                changeMovingMode(4);
            }
            if (x >= 570 && x <= 630) {
                clicked = GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(5);
                changeMovingMode(5);
            }
            //System.out.print(clicked.getHead().toString() + " " + clicked.getTail().toString());
            if(MovingMode != -1)
                MovingPiece = GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(MovingMode);
            else
                MovingPiece = null;

            repaint();
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
