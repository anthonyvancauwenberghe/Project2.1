package com.ingenious.algorithms.impl.q_learning;

/**
 * Created by danig on 12/2/2017.
 */
public class Action
{

    public static final Action RED = new Action(0);
    public static final Action BLUE = new Action(1);
    public static final Action GREEN = new Action(2);
    public static final Action ORANGE = new Action(3);
    public static final Action YELLOW = new Action(4);
    public static final Action PURPLE = new Action(5);

    private int index;


    public Action(int index){
        this.index = index;
    }

    public int getAction()
    {
        return this.index;
    }
}
