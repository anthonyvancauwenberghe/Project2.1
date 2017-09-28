package providers.impl;

import gui.MainFrame;
import models.board.Board;
import providers.Provider;

public class GuiProvider extends Provider {
    private MainFrame gui;

    @Override
    protected void initialize() {
        this.gui = new MainFrame();
    }

    public MainFrame getGui() {
        return gui;
    }
}
