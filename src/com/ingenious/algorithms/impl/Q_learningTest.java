package com.ingenious.algorithms.impl;

import java.util.Random;

/**
 * Created by carolley on 14-Nov-17.
 */
public class Q_learningTest {

    public static void main(String[] args) {
        /*GameServiceProvider.boot();
        ArrayList<BoardNode> boardNodes = GameServiceProvider.board().getBoardNodes();
        QTable qtables = new QTable(boardNodes);
        qtables.print(1);
        Double [] r = {1.1,0.0,0.0,0.0,0.0,3.1};
        qtables.replace_Qtable(GameServiceProvider.board().getBoardNodes().get(0), r);
        System.out.println("NEEWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        qtables.print(1);*/

        Random x = new Random();
        int v = x.nextInt(100);
        System.out.println(v);
    }
}
