package com.ingenious.containers;

import com.ingenious.algorithms.impl.ExampleAlgorithm;
import com.ingenious.models.bag.Bag;
import com.ingenious.models.players.Player;
import com.ingenious.models.players.impl.Bot;
import com.ingenious.models.players.impl.Human;
import com.ingenious.models.rack.Rack;
import com.ingenious.models.score.Score;

import java.util.ArrayList;
import java.util.List;

public class PlayerContainer {

    private List<Player> players;
    private Bag bag;

    public PlayerContainer(Bag bag) {
        players = new ArrayList<>();
        this.bag = bag;
        this.initPlayers();
    }

    /* ADD PLAYERS OR BOTS HERE */
    protected void initPlayers() {
        this.addPlayer(new Human("random_player_name"));
        this.addPlayer(new Bot("test bot", new ExampleAlgorithm()));
    }

    private void addPlayer(Player player) {
        initRack(player);
        initScore(player);
        this.players.add(player);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void initScore(Player player) {
        player.score = new Score();
    }

    private void initRack(Player player) {
        player.rack = new Rack(bag);
    }
}
