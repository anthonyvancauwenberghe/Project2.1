package providers.impl;

import containers.PlayerContainer;
import engine.Game;
import gui.MainFrame;
import models.board.Board;
import models.bag.Bag;
import providers.Provider;
import tests.Tests;

public class GameServiceProvider extends Provider {

    private Board board;
    private PlayerContainer players;
    private Bag bag;
    private Game game;
    private Tests tests;
    private MainFrame gui;

    protected void initialize() {
        this.board = new Board();
        this.bag = new Bag();
        this.players = new PlayerContainer(bag);
        this.game = new Game(board, players.getPlayers(), bag);
        this.gui = new MainFrame();
        this.tests = new Tests();
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

    public static Tests test() {
        return getInstance().tests;
    }

    public static void restart() {
        gui().dispose();
        reboot();
    }

}
