package com.ingenious.algorithms.impl;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.Node;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by danig on 11/13/2017.
 */
public class QLearning
{
    private ArrayList<Node> nodes = GameServiceProvider.board().getNodes();
    private ArrayList<int[]> qTables = new ArrayList<int[]>();

    public void createQValueTable()
    {
        for(int i = 0; i < nodes.size(); i++)
        {
            int[] array = {0,0,0,0,0,0};
            qTables.add(array);

        }

    }
    public int[] getQTable(Node node)
    {
        int index = nodes.indexOf(node);
        return qTables.get(index);
    }



}
