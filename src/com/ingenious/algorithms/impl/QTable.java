package com.ingenious.algorithms.impl;


import com.ingenious.models.board.Node;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by carolley on 14-Nov-17.
 */
public class QTable{

    HashMap<Node, Double[]> q_tables;
    ArrayList<Node> nodes;

    public QTable(ArrayList<Node> nodes){
        this.nodes = nodes;
        q_tables = createQtable();
    }

    public HashMap<Node,Double []> createQtable(){
        HashMap<Node,Double[]> q_tables = new HashMap<>();
        for(int i=0; i<nodes.size(); i++){
            Double [] q_table = {0.0,0.0,0.0,0.0,0.0,0.0};
            q_tables.put(nodes.get(i), q_table);
        }
        return q_tables;
    }


    public void print(int n){
        for(int i=0; i<=n; i++){
            Node node = nodes.get(i);
            System.out.println("Node coord: x = [" + node.getX()+" , "+ node.getY()+" ].");
            Double[] qtable = q_tables.get(nodes.get(i));

            System.out.print("Q TABLE VALUES: ");
            for(int j=0; j<6; j++){
                System.out.print(qtable[j] + "  ");
            }
            System.out.println();
        }
    }

}
