package com.ingenious.models.board; /**
 * Created by alexisguillot on 14/09/2017.
 */

import com.ingenious.config.Configuration;
import com.ingenious.events.impl.BoardIsUpdatedEvent;
import com.ingenious.models.tiles.Tile;

import java.util.ArrayList;

public class Board {

    private ArrayList<Node> nodes = new ArrayList<Node>(); //This is the list containing the nodes
    private int[][] nodeCoord;



    public Board() {
        initBoard();
    }

    private Board(ArrayList<Node> ns, int[][] nc)
    {
        this.nodes = ns;
        this.nodeCoord = nc;
    }

    public void initBoard() {
        int cnt = 0; //This counter keeps track of the number of nodes that were created
        int board_width = Configuration.boardWidth; // this is the radius of nodes from the center to the end of the com.ingenious.models.board (incl. center)
        int tmp_top = -(board_width - 1);//reference to keep track of the decrease in the number of hexes to be created
        for (int i = 0; i < board_width; i++) //loop as many times as there are columns on the sides of the central one (* 2)
        {
            for (int j = board_width - 1; j >= tmp_top; j--) {
                if (i == 0) {
                    nodes.add(new Node(i, -j, Tile.empty));//Create nodes only once for the case when i is 0 because it is the center
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

    public boolean inBoard(int x, int y)
    {
        if(getNode(x,y) == null)
            return false;
        else
            return true;
    }

    private void buildNodeCoordinatesArray() {
        this.nodeCoord = new int[2 * (Configuration.boardWidth) - 1][2 * (Configuration.boardWidth) - 1];
        int offset = Configuration.boardWidth - 1;

        /*Loop through the array and set all initial values to -1 */
        for (int x = 0; x < nodeCoord.length; x++) {
            for (int y = 0; y < nodeCoord[x].length; y++) {
                nodeCoord[x][y] = -1;
            }
        }

        /* Set all coordinate values to the given index from the node arraylist */
        for (int i = 0; i < nodes.size(); i++) {
            int xOffset = nodes.get(i).getX() + offset;
            int yOffset = nodes.get(i).getY() + offset;
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
        //ADDING THE WIDTH OF THE BOARD TO MAKE SURE THERE ARE NO NEGATIVE NUMBERS AS KEY IN THE ARRAY
        x = x + Configuration.boardWidth - 1;
        y = y + Configuration.boardWidth - 1;

        if (x < 0 || x > 2 * (Configuration.boardWidth - 1) || y < 0 || y > 2 * (Configuration.boardWidth - 1))
            return null;

        if (this.nodeCoord[x][y] == -1)
            return null;

        return nodes.get(this.nodeCoord[x][y]);
    }

    public Node getNode(int x, int y, ArrayList<Node> nodesList) {
        //ADDING THE WIDTH OF THE BOARD TO MAKE SURE THERE ARE NO NEGATIVE NUMBERS AS KEY IN THE ARRAY
        x = x + Configuration.boardWidth - 1;
        y = y + Configuration.boardWidth - 1;

        if (x < 0 || x > 2 * (Configuration.boardWidth - 1) || y < 0 || y > 2 * (Configuration.boardWidth - 1))
            return null;

        if (this.nodeCoord[x][y] == -1)
            return null;

        return nodesList.get(this.nodeCoord[x][y]);
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
        }

        if (southWest != null) {
            neighbours.add(southWest);
        }

        if (north != null) {
            neighbours.add(north);
        }

        if (south != null) {
            neighbours.add(south);
        }

        if (northEast != null) {
            neighbours.add(northEast);
        }

        if (southEast != null) {
            neighbours.add(southEast);
        }
      
        return neighbours;
    }

    public boolean isNeighbour(Node node1, Node node2)
    {
        ArrayList<Node> neighbours = node1.getNeighbours();
        return neighbours.contains(node2);
    }

    public void addTile(Tile tile, Node node) {
        if (node.getTile().isEmpty()) {
            node.setTile(tile);
            new BoardIsUpdatedEvent();
        }
    }

    public void addTile(Tile tile, Node node, boolean update) {
        if (node.getTile().isEmpty()) {
            node.setTile(tile);
            if(update)
                new BoardIsUpdatedEvent();
        }
    }

    public Board getClone()
    {
        return new Board(this.nodes, this.nodeCoord);
    }

}
