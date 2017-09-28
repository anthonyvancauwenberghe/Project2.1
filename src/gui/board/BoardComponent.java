package gui.board;

import models.board.Board;
import providers.GameServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by alexisguillot on 14/09/2017.
 */
public class BoardComponent extends JComponent{

    public BoardComponent() {
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        int xOffset = 300;
        int yOffset = 120;
        for (int i = 0; i < GameServiceProvider.getBoardProvider().getBoard().getNodes().size(); i++) {
            int x = GameServiceProvider.getBoardProvider().getBoard().getNodes().get(i).x * 40 + xOffset;
            int y = GameServiceProvider.getBoardProvider().getBoard().getNodes().get(i).y * 40 +yOffset;
            int shift=100;
             g2.draw(new Ellipse2D.Double(x+shift,y+shift, 30, 30));
        }


    }
}
