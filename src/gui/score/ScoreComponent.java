package gui.score;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreComponent extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

       int circleSize = 13;
        int gapSize = 26;
        int startingX = 70;
        int startingY = 10;
        int currentX = startingX;
        int currentY = startingY;
        List<Color> colors = new ArrayList<Color>();
        colors.add(Color.red);
        colors.add(Color.green);
        colors.add(Color.blue);
        colors.add(Color.orange);
        colors.add(Color.yellow);
        colors.add(new Color(160, 32, 240));


        int[] myScore = {1, 5, 14, 16, 7, 2};
        int[] opponentScore = {6, 9, 11, 10, 3, 15};

        //score on score board
        for (int i = 0; i < 6; i++) {

            for (int j = 18; j >= 0; j--) {
                if (myScore[i] == j) {
                    g.setColor(colors.get(i));
                    g.fillOval(currentX, currentY, circleSize, circleSize);
                } else {
                    if (myScore[i] < j)
                        g.setColor(Color.black);
                    g.drawOval(currentX, currentY, circleSize, circleSize);
                }

                currentY += gapSize;

                //color indication at the bottom
                if (j == 0) {
                    g.setColor(colors.get(i));
                    g.fillOval(currentX, currentY, circleSize, circleSize);
                }
            }
            currentX += gapSize;
            currentY = startingY;
        }


        //score labels to the size
        currentX = startingX - gapSize;
        currentY = startingY + circleSize;

        for (int z = 18; z >= 0; z--) {
            g.setColor(Color.black);
            g.drawString(Integer.toString(z), currentX, currentY);
            currentY += gapSize;
        }

        //opponent's score
        currentX = (int) (startingX - (gapSize * 0.5));
        currentY += (int) gapSize * 0.5;

        g.setColor(Color.black);
        g.drawRect(currentX,
                currentY,
                (int) (6 * circleSize + 3.5 * gapSize),
                (int) (2 * (circleSize + (gapSize * 0.5))));

        currentX = startingX;
        currentY += (int) gapSize * 0.25;
        for (int i = 0; i < 6; i++) {
            g.setColor(colors.get(i));
            g.fillOval(currentX, currentY, circleSize, circleSize);
            g.setColor(Color.black);
            g.drawString(Integer.toString(opponentScore[i]), currentX, (int) (currentY + (1.5 * gapSize)));
            currentX += gapSize;
        }
    }

}
