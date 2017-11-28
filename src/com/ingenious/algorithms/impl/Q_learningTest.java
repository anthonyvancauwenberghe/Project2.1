package com.ingenious.algorithms.impl;

import com.ingenious.models.board.Node;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

/**
 * Created by carolley on 14-Nov-17.
 */
public class Q_learningTest {

    public static void main(String[] args) {
        GameServiceProvider.boot();
        ArrayList<Node> nodes = GameServiceProvider.board().getNodes();
        QTable qtables = new QTable(nodes);
        qtables.print(1);
        Double [] r = {1.1,0.0,0.0,0.0,0.0,3.1};
        qtables.replace_Qtable(GameServiceProvider.board().getNodes().get(0), r);
        System.out.println("NEEWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        qtables.print(1);
    }
}
