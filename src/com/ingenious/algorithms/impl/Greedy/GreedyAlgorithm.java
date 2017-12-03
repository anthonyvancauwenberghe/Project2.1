package com.ingenious.algorithms.impl.Greedy;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

/**
 * Created by danig on 12/3/2017.
 */
public class GreedyAlgorithm
{

    public Board board;
    private BoardNode[] placements = {null, null, null, null, null,null};
    private int [] lengths = {0,0,0,0,0,0};

    public GreedyAlgorithm(Board board)
    {
        this.board = board.getClone();
    }

    public void calcLongestLines()
    {
        for(int i = 0; i < board.getBoardNodes().size(); i++)
        {
            if(board.getBoardNodes().get(i).isOccupied())
            {
            }
        }
    }

    public int calcLine(BoardNode node)
    {
        Tile currentTile = node.getTile();
        int scoreNorth = 0;
        int scoreEast = 0;
        int scoreWest = 0;
        BoardNode north1;

        int[] scoresArray = {scoreNorth,scoreEast,scoreWest};

        int x = node.getX();
        int y = node.getY();
        int l = 1;

        while(this.board.getNode(x,y-l)!= null){
            if(board.getNode(x,y-l).getTile().equals(currentTile)){
                scoreNorth++;
            }
            else{
                if(board.getNode(x,y-l).isEmpty()){
                    isExpandable(board.getNode(x,y-l));
                    north1 = board.getNode(x,y-l);
                }
            }
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x,y+l)!= null && currentTile.equals(GameServiceProvider.board().getNode(x,y+l).getTile())){
            scoreNorth++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y)!= null && currentTile.equals(GameServiceProvider.board().getNode(x + l,y).getTile())){
            scoreEast++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y)!= null && currentTile.equals(GameServiceProvider.board().getNode(x - l,y).getTile())){
            scoreEast++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y-l)!= null && currentTile.equals(GameServiceProvider.board().getNode(x+l,y-l).getTile())){
            scoreWest++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y+l)!= null &&  currentTile.equals(GameServiceProvider.board().getNode(x-l,y+l).getTile())){
            scoreWest++;
            l++;
        }

        return getLargestLine(scoresArray);

    }

    public int getLargestLine(int[] array)
    {
        int maxLine = 0;
        for(int i = 1; i < array.length; i++)
        {
            if(array[maxLine] < array[i])
            {
                maxLine = i;
            }
        }
        return maxLine;
    }

    public boolean isExpandable(BoardNode node)
    {
        for(int i = 0; i < node.getNeighbours().size(); i ++)
        {
            if(node.getNeighbours().get(i).isEmpty() )
            {
                return true;
            }
        }
        return false;
    }
}
