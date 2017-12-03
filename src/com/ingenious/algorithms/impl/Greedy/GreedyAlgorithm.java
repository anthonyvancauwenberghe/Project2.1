package com.ingenious.algorithms.impl.greedy;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by danig on 12/3/2017.
 */
public class GreedyAlgorithm
{

    public Board board;

    public GreedyAlgorithm(Board board)
    {
        this.board = board.getClone();
    }


    public void greedyPlay(){

    }

    /**
     *
     * @return an array of where to expand for greater score on each color
     */
    public BoardNode[] expandOn(){

        ArrayList<BoardNode> nodes = board.getBoardNodes();
        BoardNode [] placements = new BoardNode[6];
        int [] lengths = {0,0,0,0,0,0};

        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).isOccupied()){
                int color_index = indexColor( nodes.get(i).getTile());
                int[] l = calcLine(nodes.get(i));
                if(lengths[color_index]< l[0]){
                    lengths[color_index] = l[0];
                    placements[color_index] = board.getNode(l[1],l[2]);
                }

            }
        }
            return placements;
    }


    public int[] calcLine(BoardNode node)
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

    public int getLargestLine(int a, int b, int c)
    {
        int max = Math.max(a,b);
        max = Math.max(max,c);
        return max;
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

    public int indexColor(Tile tile){
        if(tile.equals(Color.RED)){
            return 0;
        }
        if(tile.equals(Color.BLUE)){
            return 1;
        }
        if(tile.equals(Color.green)){
            return 2;
        }
        if(tile.equals(Color.yellow)){
            return 3;
        }
        if(tile.equals(Color.orange)){
            return 4;
        }
        else{
            return 5;
        }
    }
}
