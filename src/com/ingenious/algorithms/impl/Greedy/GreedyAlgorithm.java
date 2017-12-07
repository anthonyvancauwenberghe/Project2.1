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

    /*public GreedyAlgorithm(Board board)
    {
        this.board = board.getClone();
    }*/

    /**
     *
     * @return an array of where to expand for greater score on each color
     */

    public void place()
    {
        //when score is 17
        //lowest score
        //longest path

        //double colour
        //single colour

    }
    public BoardNode[] longestLines(){

        ArrayList<BoardNode> nodes = board.getBoardNodes();
        BoardNode [] placements = new BoardNode[6];
        int [] lengths = {0,0,0,0,0,0};

        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).isOccupied()){
                int color_index = indexColor( nodes.get(i).getTile());
                int[] l = calculate_line(nodes.get(i));
                if(lengths[color_index]< l[0]){
                    lengths[color_index] = l[0];
                    placements[color_index] = board.getNode(l[1],l[2]);
                }

            }
        }
            return placements;
    }


    public int[] calculate_line(BoardNode node)
    {
        Tile currentTile = node.getTile();
        int line_NorthSouth = 0;
        int line_nEastWest = 0;
        int line_nWestEast = 0;
        int[] lines = {line_NorthSouth, line_nEastWest, line_nWestEast};
        BoardNode [] placement = new BoardNode[6];
        int[] a = new int[3];
        int[] line_size = {line_NorthSouth,line_nEastWest,line_nWestEast};

        int x = node.getX();
        int y = node.getY();
        int l = 1;

        while(this.board.getNode(x,y-l)!= null){
            if(board.getNode(x,y-l).getTile().equals(currentTile)){
                line_NorthSouth++;
            }
            else{
                if(board.getNode(x,y-l).isEmpty() && isExpandable(board.getNode(x,y-l))){

                    BoardNode NorthSouth1 = board.getNode(x,y-l);
                    placement[0] = NorthSouth1;
                    break;
                }
            }
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x,y+l)!= null){
            if(board.getNode(x,y+l).getTile().equals(currentTile)){
                line_NorthSouth++;
            }
            else{
                if(board.getNode(x,y+l).isEmpty() && isExpandable(board.getNode(x,y+l))){

                   BoardNode NorthSouth2 = board.getNode(x,y+l);
                   placement[1] = NorthSouth2;
                   break;
                }
            }
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y)!= null){
            if(board.getNode(x+l,y).getTile().equals(currentTile)){
                line_nEastWest++;
            }
            else{
                if(board.getNode(x+l,y).isEmpty() && isExpandable(board.getNode(x+l,y))){

                    BoardNode EastWest1 = board.getNode(x+l,y);
                    placement[2] = EastWest1;
                    break;
                }
            }
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y)!= null){
            if(board.getNode(x-l,y).getTile().equals(currentTile)){
                line_nEastWest++;
            }
            else{
                if(board.getNode(x-l,y).isEmpty() && isExpandable(board.getNode(x-l,y))){

                    BoardNode EastWest2 = board.getNode(x-l,y);
                    placement[3] = EastWest2;
                    break;
                }
            }
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x+l,y-l)!= null){
            if(board.getNode(x+l,y-l).getTile().equals(currentTile)){
                line_nWestEast++;
            }
            else{
                if(board.getNode(x+l,y-l).isEmpty() && isExpandable(board.getNode(x+l,y-l))){

                    BoardNode WestEast1 = board.getNode(x+l,y-l);
                    placement[4] = WestEast1;
                    break;
                }
            }
            l++;
        }
        l = 1;
        while(GameServiceProvider.board().getNode(x-l,y+l)!= null){
            if(board.getNode(x-l,y+l).getTile().equals(currentTile)){
                line_nWestEast++;
            }
            else{
                if(board.getNode(x+l,y-l).isEmpty() && isExpandable(board.getNode(x-l,y+l))){

                    BoardNode WestEast2 = board.getNode(x-l,y+l);
                    placement[5] = WestEast2;
                    break;
                }
            }
            l++;
        }
        int[] sortedIndex = returnLongestLine(lines);
        for(int i=0; i<sortedIndex.length; i++)
        {
            for(int j=0; j<2; j++)
            {
                if(!placement[sortedIndex[i+j]].equals(null))
                {
                    a[0] = lines[sortedIndex[i]];
                    a[1] = placement[sortedIndex[i+j]].getX();
                    a[2] = placement[sortedIndex[i+j]].getY();
                    return a;
                }
            }
        }
            a[0] = -1;
            return a;
    }

    public int[] returnLongestLine(int[] lines)
    {
        int [] indexes = new int[3];
        int max = lines[0];
        int maxIndex = 0;
        for(int i=0; i<lines.length; i++){
            if(max<lines[i]){
                maxIndex = i;
                max = lines[i];
            }
        }
        max = lines[0];
        int secondIndex = 0;
        for(int i=0; i<lines.length; i++){
            if(max<lines[i] && i!=maxIndex){
                secondIndex = i;
                max = lines[i];
            }
        }
        int thirdIndex = 0;
        for(int i=0; i<indexes.length; i++){
            if(i!= maxIndex && i!= secondIndex){
                thirdIndex = i;
            }
        }
        indexes[0] = maxIndex;
        indexes[1] = secondIndex;
        indexes[2] = thirdIndex;
        return indexes;
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
