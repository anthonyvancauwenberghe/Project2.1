package com.ingenious.containers;

import com.ingenious.models.bag.Bag;
import com.ingenious.models.players.Player;
import com.ingenious.models.rack.Rack;

import java.util.ArrayList;
import java.util.List;

public class PlayerContainer
{

    private List<Player> players;
    private Bag bag;

    public PlayerContainer(Bag bag) {
        players = new ArrayList<>();
        this.bag = bag;
    }

    public void addPlayer(Player player) {
        initRack(player);
        this.players.add(player);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void initRack(Player player) {
        player.rack = new Rack(bag);
    }
}
