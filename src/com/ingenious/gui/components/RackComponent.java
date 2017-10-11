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

    int X_start = 100;
    int X_position;
    int Y_line = 25;
    int X_gap = (int) (Hexagon.getWidth() + 40);

    private int MovingMode = -1;
    public Piece MovingPiece;
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

        X_position = X_start;
        for (int i = 0; i < 6; i++) {
            if(GameServiceProvider.game().getCurrentPlayer().getRack().getIndexSelected() != i) {
                g.setColor(GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(i).getHead());
                Hexagon hexagon;
                if (MovingMode == i)
                    hexagon = new Hexagon(new Point(MovingPieceX, MovingPieceY));
                else
                    hexagon = new Hexagon(new Point(X_position, Y_line));

                g.fillPolygon(hexagon.getHexagon());
                g.setColor(new Color(0, 0, 0));
                g.drawPolygon(hexagon.getHexagon());

                g.setColor(GameServiceProvider.game().getCurrentPlayer().getRack().getContents().get(i).getTail());
                Hexagon hexagon2;
                if (MovingMode == i)
                    hexagon2 = new Hexagon(new Point(MovingPieceX, (int) (MovingPieceY + Hexagon.getHeight())));
                else
                    hexagon2 = new Hexagon(new Point(X_position, (int) (Y_line + Hexagon.getHeight())));

                g.fillPolygon(hexagon2.getHexagon());
                g.setColor(new Color(0, 0, 0));
                g.drawPolygon(hexagon2.getHexagon());
            }

            X_position += X_gap;
        }

        MouseSpy listener = new MouseSpy();
        addMouseListener(listener);
        MouseWatcher watcher = new MouseWatcher();
        addMouseMotionListener(watcher);
    }

    class MouseWatcher implements MouseMotionListener {
        @Override
        public void mouseMoved(MouseEvent e) {
           /* if (MovingMode != -1) {
                MovingPieceX = e.getX();
                MovingPieceY = e.getY();
                repaint();

                //System.out.print("Mouse: " + e.getX() + ", " + e.getY());
                //System.out.println("Piece moved to: " + MovingPieceX + ", " + MovingPieceY);
            }*/
        }

        @Override
        public void mouseDragged(MouseEvent e) {}
    }

    class MouseSpy implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            float x = e.getX();
            if (x >= (X_start-(Hexagon.getWidth()*0.5)) && x <= (X_start+(Hexagon.getWidth()*0.5))) {

                GameServiceProvider.game().getCurrentPlayer().getRack().setPieceSelected(0);
                GameServiceProvider.gui().getRackPanel().repaint();
                GameServiceProvider.gui().getBoardPanel().repaint();
                changeMovingMode(0);
            }
            if (x >= ((X_start+X_gap)-(Hexagon.getWidth()*0.5)) && x <= ((X_start+X_gap)+(Hexagon.getWidth()*0.5))) {

                GameServiceProvider.game().getCurrentPlayer().getRack().setPieceSelected(1);
                GameServiceProvider.gui().getRackPanel().repaint();
                GameServiceProvider.gui().getBoardPanel().repaint();
                changeMovingMode(1);
            }
            if (x >= ((X_start+(X_gap*2))-(Hexagon.getWidth()*0.5)) && x <= ((X_start+(X_gap*2))+(Hexagon.getWidth()*0.5))) {

                GameServiceProvider.game().getCurrentPlayer().getRack().setPieceSelected(2);
                GameServiceProvider.gui().getRackPanel().repaint();
                GameServiceProvider.gui().getBoardPanel().repaint();
                changeMovingMode(2);
            }
            if (x >= ((X_start+(X_gap*3))-(Hexagon.getWidth()*0.5)) && x <= ((X_start+(X_gap*3))+(Hexagon.getWidth()*0.5))) {

                GameServiceProvider.game().getCurrentPlayer().getRack().setPieceSelected(3);
                GameServiceProvider.gui().getRackPanel().repaint();
                GameServiceProvider.gui().getBoardPanel().repaint();
                changeMovingMode(3);
            }
            if (x >= ((X_start+(X_gap*4))-(Hexagon.getWidth()*0.5)) && x <= ((X_start+(X_gap*4))+(Hexagon.getWidth()*0.5))) {

                GameServiceProvider.game().getCurrentPlayer().getRack().setPieceSelected(4);
                GameServiceProvider.gui().getRackPanel().repaint();
                GameServiceProvider.gui().getBoardPanel().repaint();
                changeMovingMode(4);
            }
            if (x >= ((X_start+(X_gap*5))-(Hexagon.getWidth()*0.5)) && x <= ((X_start+(X_gap*5))+(Hexagon.getWidth()*0.5))) {

                GameServiceProvider.game().getCurrentPlayer().getRack().setPieceSelected(5);
                GameServiceProvider.gui().getRackPanel().repaint();
                GameServiceProvider.gui().getBoardPanel().repaint();
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
