package entities;

import java.util.ArrayList;

public abstract class Entity implements Moveable {

    protected String Name;
    protected ArrayList score;

    public Entity(String name) {
        Name = name;
        this.score = new ArrayList();
    }

}
