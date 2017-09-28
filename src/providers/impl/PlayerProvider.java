package providers.impl;

import models.entities.Entity;
import models.entities.bots.impl.ExampleBot;
import models.entities.players.Player;
import providers.Provider;

import java.util.ArrayList;
import java.util.List;

public class PlayerProvider extends Provider {

    private List<Entity> players;

    protected void initialize() {
        players = new ArrayList<>();
        this.players.add(initFirstPlayer());
        this.players.add(initSecondPlayer());
    }

    public Entity getPlayer(int index) {
        return players.get(index);
    }

    public List<Entity> getPlayers() {
        return players;
    }

    private Entity initFirstPlayer() {
        return new Player("random_player_name");
    }

    private Entity initSecondPlayer() {
        return new ExampleBot();
    }
}
