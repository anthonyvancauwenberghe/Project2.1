package com.ingenious.algorithms.impl;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.Node;
import com.ingenious.providers.impl.GameServiceProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Created by danig on 11/13/2017.
 */
public class QLearning
{
    private ArrayList<Node> nodes = GameServiceProvider.board().getNodes();
    private ArrayList<double[]> qTables = new ArrayList<double[]>();
    private int EPSILON = 50;

    public void createQValueTable()
    {
        for(int i = 0; i < nodes.size(); i++)
        {
            double[] array = {0.0,0.0,0.0,0.0,0.0,0.0};
            qTables.add(array);

        }

    }
    public double[] getQTable(Node node)
    {
        int index = nodes.indexOf(node);
        return qTables.get(index);
    }


    public void chooseAction(int e){
        Random random = new Random();
        int value = random.nextInt(100);
        if(value<=e){
          randomAction();
        }
        else{
            Node head = argmaxQ();

        }

    }

    public void play(Node a, Node b){
        //place head at a, place tail at b
    }

    public void q_Action(){

    }

    public void randomAction(){
        Random random = new Random();
        int index_head = random.nextInt(nodes.size());
        Node node_head = nodes.get(index_head);
        if(node_head.isOccupied()){
            randomAction();
        }
        else{
            ArrayList<Node> free_neighbours = free_neighbour_nodes(node_head);
            if(free_neighbours.isEmpty()){
                randomAction();
            }
            else{
                int index_tail = random.nextInt(free_neighbours.size());
                Node node_tail = free_neighbours.get(index_tail);
                play(node_head,node_tail);
            }
        }
    }

    public ArrayList<Node> free_neighbour_nodes(Node chosen_node){
        ArrayList<Node> free_neighbours = new ArrayList<>();
        for(int i=0; i<chosen_node.getNeighbours().size(); i++){
            if(!chosen_node.getNeighbours().get(i).isOccupied()){
                free_neighbours.add(chosen_node.getNeighbours().get(i));
            }
        }
        return free_neighbours;
    }

    public double highest_q(Node node){
        double[] q_table = getQTable(node);
        double high = q_table[0];
        for(int i=1; i<6; i++){
            if(high<q_table[i]){
                high = q_table[i];
            }
        }
        return high;
    }

    public Node argmaxQ(){
        Node node = nodes.get(0);
        for(int i =1; i<nodes.size(); i++){
            if(highest_q(node)< highest_q(nodes.get(i)) && !free_neighbour_nodes(nodes.get(i)).isEmpty()){
                node = nodes.get(i);
            }
        }
        return node;
    }

}
