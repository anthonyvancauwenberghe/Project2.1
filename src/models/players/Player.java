package models.players;

import models.board.Node;
import models.rack.Rack;

import java.util.List;

public abstract class Player implements Moveable {

    private String name;

    public List<Integer> score;
    public Rack rack;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List getScore() {
        return this.score;
    }

    public Rack getRack() {
        return rack;
    }

    public void executeMove(Node node) {
        //TODO IMPLEMENT MOVE LOGIC
    }
}
