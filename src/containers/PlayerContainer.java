package containers;

import models.bag.Bag;
import models.players.Player;
import models.players.impl.bots.impl.ExampleBot;
import models.players.impl.human.Human;
import models.rack.Rack;

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
        this.addPlayer(new ExampleBot());
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
        for (int i = 0; i < 6; i++) {
            player.score[i]=0;
        }
    }

    private void initRack(Player player) {
        player.rack = new Rack(bag);
    }
}
