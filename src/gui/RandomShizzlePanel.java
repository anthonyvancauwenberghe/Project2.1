package gui;

import javax.swing.*;
import java.awt.*;

public class RandomShizzlePanel extends JPanel {
    public RandomShizzlePanel() {
        JButton b1 = new JButton("Random shizzle 2");
        b1.setBounds(50, 100, 80, 30);
        b1.setBackground(Color.BLUE);
        this.add(b1);
        this.setBackground(Color.BLUE);
    }
}
