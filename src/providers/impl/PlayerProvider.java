package providers.impl;

import models.pieces.Bag;
import models.players.Player;
import models.players.bots.impl.ExampleBot;
import models.players.players.Human;
import models.rack.Rack;

import java.util.ArrayList;
import java.util.List;

public class PlayerProvider {

    private List<Player> players;
    private Bag bag;

    public PlayerProvider(Bag bag) {
        this.bag = bag;
        this.initialize();
    }

    protected void initialize() {
        players = new ArrayList<>();
        this.initPlayers();
        this.initScores();
        this.initRacks();
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Player> getPlayers() {
        return players;
    }


    public void initPlayers() {
        this.players.add(new Human("random_player_name"));
        this.players.add(new ExampleBot());
    }

    private void initScores() {
        for (Player player : players) {
            player.score = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                player.score.add(0);
            }
        }
    }

    private void initRacks() {
        for (Player player : players) {
            player.rack = new Rack(bag);
        }

    }
}
