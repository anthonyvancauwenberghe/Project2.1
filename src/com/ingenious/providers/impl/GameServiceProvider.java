package com.ingenious.providers.impl;

import com.ingenious.containers.PlayerContainer;
import com.ingenious.engine.Game;
import com.ingenious.gui.MainFrame;
import com.ingenious.models.board.Board;
import com.ingenious.models.bag.Bag;
import com.ingenious.providers.Provider;
import tests.Tests;

public class GameServiceProvider extends Provider {

    private Board board;
    private PlayerContainer players;
    private Bag bag;
    private Game game;
    private MainFrame gui;

    protected void initialize() {
        this.board = new Board();
        this.bag = new Bag();
        this.players = new PlayerContainer(bag);
        this.game = new Game(board, players.getPlayers(), bag);
        this.gui = new MainFrame();
    }

    public static MainFrame gui() {
        return getInstance().gui;
    }

    public static Board board() {
        return getInstance().board;
    }

    public static PlayerContainer players() {
        return getInstance().players;
    }

    public static Bag bag() {
        return getInstance().bag;
    }

    public static Game game() {
        return getInstance().game;
    }

    public static void restart() {
        gui().dispose();
        reboot();
    }

}
