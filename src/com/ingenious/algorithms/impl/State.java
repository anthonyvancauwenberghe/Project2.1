package com.ingenious.algorithms.impl;

import java.util.ArrayList;

import com.ingenious.containers.PlayerContainer;
import com.ingenious.engine.Game;
import com.ingenious.models.bag.Bag;
import com.ingenious.models.board.Board;
import com.ingenious.models.players.Player;


public class State {
    public Board board;
    public PlayerContainer players;
    public Bag bag;
    public Game game;

    public State(Board board, Game game, Bag bag, PlayerContainer players) {
        this.board = board;
        this.players = players;
        this.game = game;
        this.bag = bag;
    }

    public State getClone() {
        Board board = this.board.getClone();
        Bag bag = this.bag.getClone();
        PlayerContainer playerContainer = new PlayerContainer(bag);
        for (Player player : this.players.getPlayers()) {
            playerContainer.addPlayer(player.getClone());
        }
        Game game = new Game(board, playerContainer.getPlayers(), bag);
        return new State(board, game, bag, playerContainer);
    }
}
