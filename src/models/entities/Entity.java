package models.entities;

import models.board.Board;
import models.board.Node;
import models.rack.Rack;
import providers.GameServiceProvider;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Moveable {

    private String name;
    private List<Integer> score;
    private Rack rack;

    public Entity(String name) {
        this.name = name;
        this.rack = new Rack();
        this.initScore();
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

    private void initScore() {
        this.score = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            this.score.add(0);
        }
    }

    public void move(Node node){
       //TODO IMPLEMENT MOVE LOGIC
    }
}
