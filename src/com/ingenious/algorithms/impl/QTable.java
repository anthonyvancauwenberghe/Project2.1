package com.ingenious.algorithms.impl;


import com.ingenious.models.board.BoardNode;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by carolley on 14-Nov-17.
 */
public class QTable{

    HashMap<BoardNode, Double[]> q_tables;
    ArrayList<BoardNode> boardNodes;

    public QTable(ArrayList<BoardNode> boardNodes){
        this.boardNodes = boardNodes;
        q_tables = createQtable();
    }

    public HashMap<BoardNode,Double []> createQtable(){
        HashMap<BoardNode,Double[]> q_tables = new HashMap<>();
        for(int i = 0; i< boardNodes.size(); i++){
            Double [] q_table = {0.0,0.0,0.0,0.0,0.0,0.0};
            q_tables.put(boardNodes.get(i), q_table);
        }
        return q_tables;
    }


    public void print(int n){
        for(int i=0; i<=n; i++){
            BoardNode boardNode = boardNodes.get(i);
            System.out.println("BoardNode coord: x = [" + boardNode.getX()+" , "+ boardNode.getY()+" ].");
            Double[] qtable = q_tables.get(boardNodes.get(i));

            System.out.print("Q TABLE VALUES: ");
            for(int j=0; j<6; j++){
                System.out.print(qtable[j] + "  ");
            }
            System.out.println();
        }
    }

}
