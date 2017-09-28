package gui;

import gui.board.BoardComponent;
import gui.rack.RackComponent;
import gui.score.ScoreComponent;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel rootPanel;
    private JPanel boardPanel;
    private JPanel scorePanel;
    private JPanel rackPanel;

    public MainFrame() {
        setContentPane(rootPanel);

        initScoreComponent();
        initBoardComponent();
        initRackComponent();

        setSize(1920, 800);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void initScoreComponent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        Component scoreComponent = new ScoreComponent();
        this.scorePanel.add(scoreComponent, gbc);
    }

    public void initBoardComponent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        Component boardComponent = new BoardComponent();
        this.boardPanel.add(boardComponent, gbc);
    }

    public void initRackComponent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        Component rackComponent = new RackComponent();
        rackPanel.setBackground(Color.DARK_GRAY);
        this.rackPanel.add(rackComponent,gbc);
    }


    public static void main(String[] args) {
        new MainFrame();
    }
}

