package gui.components;

import javax.swing.*;
import java.awt.*;

public class RackComponent extends JComponent {

    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.drawString("RACK COMES HERE",300,50);
    }
}
