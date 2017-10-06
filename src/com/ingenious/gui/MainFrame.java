package com.ingenious.gui;

import com.ingenious.gui.components.BoardComponent;
import com.ingenious.gui.components.RackComponent;
import com.ingenious.gui.components.ScoreComponent;
import com.ingenious.models.board.Board;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel rootPanel;
    private JPanel boardPanel;
    private JPanel scorePanel;
    private JPanel rackPanel;

    public ScoreComponent score;
    public BoardComponent board;
    public RackComponent rack;

    public MainFrame() {
        setContentPane(rootPanel);

        initScoreComponent();
        initBoardComponent();
        initRackComponent();

        setSize(1280, 768);
        setResizable(false);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initScoreComponent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        Component scoreComponent = new ScoreComponent();
        this.scorePanel.add(scoreComponent, gbc);
    }

    private void initBoardComponent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        BoardComponent boardComponent = new BoardComponent();
        this.boardPanel.add(boardComponent, gbc);
        this.board = boardComponent;
    }

    private void initRackComponent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        Component rackComponent = new RackComponent();
        //rackPanel.setBackground(Color.WHITE);
        this.rackPanel.add(rackComponent, gbc);
    }

    public void repaintAll() {
        this.getBoardPanel().repaint();
        this.getRackPanel().repaint();
        this.getRootPanel().repaint();
        this.getScorePanel().repaint();
        this.repaint();
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public JPanel getScorePanel() {
        return scorePanel;
    }

    public JPanel getRackPanel() {
        return rackPanel;
    }
}


