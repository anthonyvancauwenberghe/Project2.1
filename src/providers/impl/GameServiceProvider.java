package providers.impl;

import containers.PlayerContainer;
import engine.Game;
import gui.MainFrame;
import models.board.Board;
import models.bag.Bag;
import providers.Provider;

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
        verifyInitialization();
        return instance.gui;
    }

    public static Board board() {
        verifyInitialization();
        return instance.board;
    }

    public static PlayerContainer players() {
        verifyInitialization();
        return instance.players;
    }

    public static Bag bag() {
        verifyInitialization();
        return instance.bag;
    }

    public static Game game() {
        return instance.game;
    }

    public static void restart() {
        GameServiceProvider.gui().dispose();
        instance = new GameServiceProvider();
    }

}
