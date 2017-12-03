package com.ingenious.algorithms.impl.Greedy;

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
        int heeeychanges = 5;
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
        int line_NorthSouth = 0;
        int line_nEastWest = 0;
        int line_nWestEast = 0;
        BoardNode NorthSouth1;
        BoardNode NorthSouth2;
        BoardNode EastWest1;
        BoardNode EastWest2;
        BoardNode WestEast1;
        BoardNode WestEast2;

        int[] line_size = {line_NorthSouth,line_nEastWest,line_nWestEast};

        int x = node.getX();
        int y = node.getY();
        int l = 1;

        while(this.board.getNode(x,y-l)!= null){
            if(board.getNode(x,y-l).getTile().equals(currentTile)){
                line_NorthSouth++;
            }
            else{
                if(board.getNode(x,y-l).isEmpty()){
                    isExpandable(board.getNode(x,y-l));
                    NorthSouth1 = board.getNode(x,y-l);
                }
            }
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x,y+l)!= null && currentTile.equals(GameServiceProvider.board().getNode(x,y+l).getTile())){
            line_NorthSouth++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y)!= null && currentTile.equals(GameServiceProvider.board().getNode(x + l,y).getTile())){
            line_nEastWest++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y)!= null && currentTile.equals(GameServiceProvider.board().getNode(x - l,y).getTile())){
            line_nEastWest++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y-l)!= null && currentTile.equals(GameServiceProvider.board().getNode(x+l,y-l).getTile())){
            line_nWestEast++;
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y+l)!= null &&  currentTile.equals(GameServiceProvider.board().getNode(x-l,y+l).getTile())){
            line_nWestEast++;
            l++;
        }
        int [] a = {0,0,0};
        return a;

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
