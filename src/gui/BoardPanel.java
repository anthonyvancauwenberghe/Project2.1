package gui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    public BoardPanel() {
        TextArea b2 = new TextArea("board comes here");
        b2.setBounds(100, 100, 80, 30);
        b2.setBackground(Color.green);
        this.add(b2);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(0,0, 100, 100);
    }



}
