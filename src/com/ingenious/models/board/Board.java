package com.ingenious.models.board; /**
 * Created by alexisguillot on 14/09/2017.
 */

import com.ingenious.models.tiles.Tile;

import java.util.ArrayList;

public class Board {

    private ArrayList<Node> nodes = new ArrayList<Node>(); //This is the list containing the nodes
    private int[][] nodeCoord = new int[11][11];


    public Board() {
        initBoard();
    }

    public void initBoard() {
        int index = 0;
        int cnt = 0; //This counter keeps track of the number of nodes that were created
        int board_width = 6; // this is the radius of nodes from the center to the end of the com.ingenious.models.board (incl. center)
        int tmp_top = -(board_width - 1);//reference to keep track of the decrease in the number of hexes to be created
        for (int i = 0; i < board_width; i++) //loop as many times as there are columns on the sides of the central one (* 2)
        {
            for (int j = board_width - 1; j >= tmp_top; j--) {
                if (i == 0) {
                    nodes.add(new Node(i, -j, Tile.empty));//Create nodes only once for the case when i is 0 because it is the center
                    insertIndex(i,-j, index);
                    index++;
                    ++cnt;
                } else {
                    nodes.add(new Node(i, -j, Tile.empty));
                    insertIndex(i,-j,index);
                    index++;
                    nodes.add(new Node(-i, j, Tile.empty)); // then creates 2 version of the node, its regular and mirrored version.
                    insertIndex(-i,j,index);
                    index++;
                    cnt += 2;
                }
            }
            ++tmp_top; //update the size of the colum to be generated and loop again
        }
        this.initInitialTiles();
    }

    public ArrayList<Node> getNodes() {

        return nodes;
    }

    public void initInitialTiles(){
        this.getNodes().get(0).setTile(Tile.red);
        this.getNodes().get(79).setTile(Tile.green);
        this.getNodes().get(89).setTile(Tile.blue);
        this.getNodes().get(10).setTile(Tile.orange);
        this.getNodes().get(80).setTile(Tile.yellow);
        this.getNodes().get(90).setTile(Tile.purple);
    }

    public ArrayList<Node> neighbours(Node node) {
        ArrayList<Node> neighbours = new ArrayList<Node>();
        int[] coordN = node.getCoord();
        for (int i = 0; i < neighbours.size(); i++) {
            int[] coord = neighbours.get(i).getCoord();
            if ((coord[0] == coordN[0] && coord[1] == coordN[1] - 1) || (coord[0] == coordN[0] + 1 && coord[1] == coordN[1] - 1)
                    || (coord[0] == coordN[0] && coord[1] == coordN[1] + 1) || (coord[0] == coordN[0] - 1 && coord[1] == coordN[1] + 1) ||
                    (coord[0] == coordN[0] - 1 && coord[1] == coordN[1]) || (coord[0] == coordN[0] + 1 && coord[1] == coordN[1])) {
                neighbours.add(neighbours.get(i));
            }
        }
        return neighbours;
    }

    public void addTile(Tile tile, Node node) {
        if (!node.getTile().isEmpty())
            node.setTile(tile);
    }

    public void insertIndex(int x, int y, int index){
       // System.out.println("x = [" + x + "], y = [" + y + "], index = [" + index + "]");
        if(x<0){
            x = 5 - x;
        }
        if(y<0){
            y = 5 - y;
        }
       // System.out.println("x = [" + x + "], y = [" + y + "], index = [" + index + "]");
        this.nodeCoord[x][y] = index;
    }

    public Node getNode(int x, int y){
        int index;
        if(x<0){
            x = 5 -x;
        }
        if(y<0){
            y = 5 - y;
        }
      //  System.out.println("x = [" + x + "], y = [" + y + "]");
        index = nodeCoord[x][y];
        return nodes.get(index);
    }

}
