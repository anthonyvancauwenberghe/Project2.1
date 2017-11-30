package com.ingenious.algorithms.impl;

import com.ingenious.models.board.BoardNode;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by danig on 11/13/2017.
 */
public class QLearning
{
    private ArrayList<BoardNode> boardNodes = GameServiceProvider.board().getBoardNodes();
    private ArrayList<double[]> qTables = new ArrayList<double[]>();
    private int EPSILON = 50;

    public void createQValueTable()
    {
        for(int i = 0; i < boardNodes.size(); i++)
        {
            double[] array = {0.0,0.0,0.0,0.0,0.0,0.0};
            qTables.add(array);

        }

    }
    public double[] getQTable(BoardNode boardNode)
    {
        int index = boardNodes.indexOf(boardNode);
        return qTables.get(index);
    }


    public void chooseAction(int e){
        Random random = new Random();
        int value = random.nextInt(100);
        if(value<=e){
          randomAction();
        }
        else{
            BoardNode head = argmaxQ();

        }

    }

    public void play(BoardNode a, BoardNode b){
        //place head at a, place tail at b
    }

    public void q_Action(){

    }

    public void randomAction(){
        Random random = new Random();
        int index_head = random.nextInt(boardNodes.size());
        BoardNode boardNode_head = boardNodes.get(index_head);
        if(boardNode_head.isOccupied()){
            randomAction();
        }
        else{
            ArrayList<BoardNode> free_neighbours = free_neighbour_nodes(boardNode_head);
            if(free_neighbours.isEmpty()){
                randomAction();
            }
            else{
                int index_tail = random.nextInt(free_neighbours.size());
                BoardNode boardNode_tail = free_neighbours.get(index_tail);
                play(boardNode_head, boardNode_tail);
            }
        }
    }

    public ArrayList<BoardNode> free_neighbour_nodes(BoardNode chosen_Board_node){
        ArrayList<BoardNode> free_neighbours = new ArrayList<>();
        for(int i = 0; i< chosen_Board_node.getNeighbours().size(); i++){
            if(!chosen_Board_node.getNeighbours().get(i).isOccupied()){
                free_neighbours.add(chosen_Board_node.getNeighbours().get(i));
            }
        }
        return free_neighbours;
    }

    public double highest_q(BoardNode boardNode){
        double[] q_table = getQTable(boardNode);
        double high = q_table[0];
        for(int i=1; i<6; i++){
            if(high<q_table[i]){
                high = q_table[i];
            }
        }
        return high;
    }

    public BoardNode argmaxQ(){
        BoardNode boardNode = boardNodes.get(0);
        for(int i = 1; i< boardNodes.size(); i++){
            if(highest_q(boardNode)< highest_q(boardNodes.get(i)) && !free_neighbour_nodes(boardNodes.get(i)).isEmpty()){
                boardNode = boardNodes.get(i);
            }
        }
        return boardNode;
    }

}
