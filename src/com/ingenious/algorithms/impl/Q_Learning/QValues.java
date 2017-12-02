package com.ingenious.algorithms.impl.Q_Learning;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

/**
 * Created by danig on 12/2/2017.
 */
public class QValues
{
    Board board = GameServiceProvider.board();
    QTable[][] qValues;

    public QValues(){
        create_QValues(board);

    }

    /**
     * Creates all the q_values for each node.
     * There are two states: Occupied or Empty. Namely Grey or not Grey
     * @param board
     */
    public void create_QValues(Board board){
        ArrayList<BoardNode> nodes = board.getBoardNodes();
        QTable[][] qValues = new QTable[11][11];
        for(int i=0; i<nodes.size(); i++){
            BoardNode node = nodes.get(i);
            int x = node.getX();
            int y = node.getY();
            if(x<0){
                x = x+5;
            }

            if(y<0){
                y = y+5;
            }
            QTable qTable = new QTable();
            if(node.isOccupied()){
                int min = Integer.MIN_VALUE;
                double [] n = {min,min,min,min,min,min};
                qTable.editQ_table(n);
            }
            qValues[x][y] =  qTable;
        }

        this.qValues = qValues;
    }

    public QTable get_QTable(BoardNode node){
        int x = node.getX();
        int y = node.getY();
        if(x<0){
            x = x+5;
        }
        if(y<0){
            y = y +5;
        }
        return this.qValues[x][y];
    }
}
