package models.board; /**
 * Created by alexisguillot on 14/09/2017.
 */

import models.pieces.Tile;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    private ArrayList<Node> nodes = new ArrayList<Node>(); //This is the list containing the nodes


    public Board() {
        initBoard();
    }

    public void initBoard() {
        int cnt = 0; //This counter keeps track of the number of nodes that were created
        int board_width = 6; // this is the radius of nodes from the center to the end of the models.board (incl. center)
        int tmp_top = -(board_width - 1);//reference to keep track of the decrease in the number of hexes to be created
        for (int i = 0; i < board_width; i++) //loop as many times as there are columns on the sides of the central one (* 2)
        {
            for (int j = board_width - 1; j >= tmp_top; j--) {
                if (i == 0) {
                    nodes.add(new Node(i, -j, Color.black)); //Create nodes only once for the case when i is 0 because it is the center
                    ++cnt;
                } else {
                    nodes.add(new Node(i, -j, Color.black));
                    nodes.add(new Node(-i, j, Color.black)); // then creates 2 version of the node, its regular and mirrored version.
                    cnt += 2;
                }
            }
            ++tmp_top; //update the size of the colum to be generated and loop again
        }
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Node> neighbours(Node node){
        ArrayList<Node> neighbours = new ArrayList<Node>();
        int [] coordN = node.getCoord();
        for(int i=0; i<neighbours.size(); i++){
            int [] coord = neighbours.get(i).getCoord();
            if((coord[0] == coordN[0] && coord[1]== coordN[1]-1) || (coord[0] == coordN[0]+1 && coord[1]== coordN[1]-1)
                    ||(coord[0] == coordN[0] && coord[1]== coordN[1]+1) || (coord[0] == coordN[0]-1 && coord[1]== coordN[1]+1) ||
                    (coord[0] == coordN[0]-1 && coord[1]== coordN[1]) || (coord[0] == coordN[0]+1 && coord[1]== coordN[1])){
                neighbours.add(neighbours.get(i));
            }
        }
        return neighbours;
    }

    public boolean occupied(Node node){
        if(node.getColor() == Color.black){
            return false;
        }
        return true;
    }

    public Color getColor(Node node){
        return node.getColor();
    }

    public void addTile(Tile tile, Node node){
        node.setColor(tile.getColor());
    }

}
