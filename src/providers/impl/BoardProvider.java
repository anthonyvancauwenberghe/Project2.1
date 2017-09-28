package providers.impl;

import models.board.Board;
import providers.Provider;

public class BoardProvider extends Provider {
    private Board board;

    @Override
    protected void initialize() {
        this.board= new Board();
    }

    public Board getBoard() {
        return board;
    }
}
