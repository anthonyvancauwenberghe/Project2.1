package com.ingenious.algorithms.impl.q_learning;

import com.ingenious.models.board.BoardNode;

/**
 * Created by carolley on 02-Dec-17.
 */
public class State {

    public static  final State OCCUPIED = new State(false);
    public static final State EMPTY = new State(true);

    private boolean x;

    public State(boolean x){
        this.x = x;
    }

    public State getState(BoardNode node){
        if(node.isOccupied()){
            return this.OCCUPIED;
        }
        else{
            return this.EMPTY;
        }
    }

}
