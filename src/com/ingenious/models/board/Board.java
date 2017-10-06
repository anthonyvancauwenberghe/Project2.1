package com.ingenious.models.board; /**
 * Created by alexisguillot on 14/09/2017.
 */

import com.ingenious.config.Configuration;
import com.ingenious.models.tiles.Tile;

import java.util.ArrayList;

public class Board {

    private ArrayList<Node> nodes = new ArrayList<Node>(); //This is the list containing the nodes
    private int[][] nodeCoord;


    public Board() {
        initBoard();
    }

    public void initBoard() {
        int cnt = 0; //This counter keeps track of the number of nodes that were created
        int board_width = Configuration.boardWidth; // this is the radius of nodes from the center to the end of the com.ingenious.models.board (incl. center)
        int tmp_top = -(board_width - 1);//reference to keep track of the decrease in the number of hexes to be created
        for (int i = 0; i < board_width; i++) //loop as many times as there are columns on the sides of the central one (* 2)
        {
            for (int j = board_width - 1; j >= tmp_top; j--) {
                if (i == 0) {
                    nodes.add(new Node(i, -j, Tile.empty)); //Create nodes only once for the case when i is 0 because it is the center
                    ++cnt;
                } else {
                    nodes.add(new Node(i, -j, Tile.empty));
                    nodes.add(new Node(-i, j, Tile.empty)); // then creates 2 version of the node, its regular and mirrored version.
                    cnt += 2;
                }
            }
            ++tmp_top; //update the size of the colum to be generated and loop again
        }
        this.buildNodeCoordinatesArray();
        this.setInitialTiles();
    }

    public ArrayList<Node> getNodes() {

        return nodes;
    }

    private void buildNodeCoordinatesArray() {
        this.nodeCoord = new int[(Configuration.boardWidth - 1) * 2 + 2][(Configuration.boardWidth - 1) * 2 + 2];
        int offset = Configuration.boardWidth - 1;


        for (int i = 0; i < nodes.size(); i++) {
            int xOffset = nodes.get(i).getX() + offset;
            int yOffset = nodes.get(i).getY() + offset;
            System.out.println("x: " + xOffset + " y: " + yOffset + " for index " + i);
            nodeCoord[xOffset][yOffset] = i;
        }
    }

    /**
     * @param x
     * @param y
     * @return mixed
     * return node when it's found on the board else return null
     */
    public Node getNode(int x, int y) {
        //ADDING THE WIDTH OF THE BOARD TO MAKE SURE THERE ARE NO NEGATIVEN NUMBERS AS KEY IN THE ARRAY
        x = x + Configuration.boardWidth - 1;
        y = y + Configuration.boardWidth - 1;

        System.out.println(x + " " + y);

        int index = -1;
        try {
            //TODO CAN SOMEONE FIX THIS PLEASE NEEDS TO ADD IF STATEMENTS TO MAKE SURE IT DOES NOT GO OUT OF BOUNDS INSTEAD OF TRY CATCH
            index = this.nodeCoord[x][y];
            System.out.println("index: " + index + " for coordinate " + x + " " + y);

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        if (index != -1)
            return nodes.get(index);
        else
            return null;
    }


    public void setInitialTiles() {
        this.getNodes().get(0).setTile(Tile.red);
        this.getNodes().get(79).setTile(Tile.green);
        this.getNodes().get(89).setTile(Tile.blue);
        this.getNodes().get(10).setTile(Tile.orange);
        this.getNodes().get(80).setTile(Tile.yellow);
        this.getNodes().get(90).setTile(Tile.purple);
    }

    public ArrayList<Node> getNeighboursOfNode(Node node) {
        ArrayList<Node> neighbours = new ArrayList<Node>();
        int x = node.getX();
        int y = node.getY();

        Node northWest = this.getNode(x - 1, y);
        Node southWest = this.getNode(x - 1, y + 1);
        Node north = this.getNode(x, y - 1);
        Node south = this.getNode(x, y + 1);
        Node northEast = this.getNode(x + 1, y - 1);
        Node southEast = this.getNode(x + 1, y);

        if (northWest != null) {
            neighbours.add(northWest);
            System.out.println("northwest added " + northWest.getX() + " " + northWest.getY());
        }

        if (southWest != null) {
            neighbours.add(southWest);
            System.out.println("southWest added " + southWest.getX() + " " + southWest.getY());
        }

        if (north != null) {
            neighbours.add(north);
            System.out.println("north added " + north.getX() + " " + north.getY());
        }

        if (south != null) {
            neighbours.add(south);
            System.out.println("south added " + south.getX() + " " + south.getY());
        }

        if (northEast != null) {
            neighbours.add(northEast);
            System.out.println("northEast added " + northEast.getX() + " " + northEast.getY());
        }

        if (southEast != null) {
            neighbours.add(southEast);
            System.out.println("southEast added " + southEast.getX() + " " + southEast.getY());
        }


        return neighbours;
    }
    /*

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
    */

    public void addTile(Tile tile, Node node) {
        if (!node.getTile().isEmpty())
            node.setTile(tile);
    }

}
