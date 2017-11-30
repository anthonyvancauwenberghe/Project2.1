package com.ingenious.models.board; /**
 * Created by alexisguillot on 14/09/2017.
 */

import com.ingenious.models.move.Move;
import com.ingenious.config.Configuration;
import com.ingenious.events.impl.BoardIsUpdatedEvent;
import com.ingenious.models.tiles.Tile;

import java.util.ArrayList;

public class Board {

    private ArrayList<BoardNode> boardNodes = new ArrayList<BoardNode>(); //This is the list containing the boardNodes
    private int[][] nodeCoord;


    public Board() {
        initBoard();
    }

    private Board(ArrayList<BoardNode> ns, int[][] nc) {
        this.boardNodes = ns;
        this.nodeCoord = nc;
    }

    public void initBoard() {
        int cnt = 0; //This counter keeps track of the number of boardNodes that were created
        int board_width = Configuration.boardWidth; // this is the radius of boardNodes from the center to the end of the com.ingenious.models.board (incl. center)
        int tmp_top = -(board_width - 1);//reference to keep track of the decrease in the number of hexes to be created
        for (int i = 0; i < board_width; i++) //loop as many times as there are columns on the sides of the central one (* 2)
        {
            for (int j = board_width - 1; j >= tmp_top; j--) {
                if (i == 0) {
                    boardNodes.add(new BoardNode(i, -j, Tile.empty));//Create boardNodes only once for the case when i is 0 because it is the center
                } else {
                    boardNodes.add(new BoardNode(i, -j, Tile.empty));
                    boardNodes.add(new BoardNode(-i, j, Tile.empty)); // then creates 2 version of the node, its regular and mirrored version.
                    cnt += 2;
                }
            }
            ++tmp_top; //update the size of the colum to be generated and loop again
        }
        this.buildNodeCoordinatesArray();
        this.setInitialTiles();
    }

    public ArrayList<BoardNode> getBoardNodes() {
        return boardNodes;
    }

    public boolean inBoard(int x, int y) {
        if (getNode(x, y) == null)
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
        for (int i = 0; i < boardNodes.size(); i++) {
            int xOffset = boardNodes.get(i).getX() + offset;
            int yOffset = boardNodes.get(i).getY() + offset;
            nodeCoord[xOffset][yOffset] = i;
        }
    }

    /**
     * @param x
     * @param y
     * @return mixed
     * return node when it's found on the board else return null
     */
    public BoardNode getNode(int x, int y) {
        //ADDING THE WIDTH OF THE BOARD TO MAKE SURE THERE ARE NO NEGATIVE NUMBERS AS KEY IN THE ARRAY
        x = x + Configuration.boardWidth - 1;
        y = y + Configuration.boardWidth - 1;

        if (x < 0 || x > 2 * (Configuration.boardWidth - 1) || y < 0 || y > 2 * (Configuration.boardWidth - 1))
            return null;

        if (this.nodeCoord[x][y] == -1)
            return null;

        return boardNodes.get(this.nodeCoord[x][y]);
    }

    public BoardNode getNode(int x, int y, ArrayList<BoardNode> nodesList) {
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
        this.getBoardNodes().get(0).setTile(Tile.red);
        this.getBoardNodes().get(79).setTile(Tile.green);
        this.getBoardNodes().get(89).setTile(Tile.blue);
        this.getBoardNodes().get(10).setTile(Tile.orange);
        this.getBoardNodes().get(80).setTile(Tile.yellow);
        this.getBoardNodes().get(90).setTile(Tile.purple);
    }

    public ArrayList<BoardNode> getNeighboursOfNode(BoardNode boardNode) {
        ArrayList<BoardNode> neighbours = new ArrayList<BoardNode>();
        int x = boardNode.getX();
        int y = boardNode.getY();

        BoardNode northWest = this.getNode(x - 1, y);
        BoardNode southWest = this.getNode(x - 1, y + 1);
        BoardNode north = this.getNode(x, y - 1);
        BoardNode south = this.getNode(x, y + 1);
        BoardNode northEast = this.getNode(x + 1, y - 1);
        BoardNode southEast = this.getNode(x + 1, y);

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

    public boolean isNeighbour(BoardNode boardNode1, BoardNode boardNode2) {
        if (boardNode1 == null || boardNode2 == null)
            return false;

        ArrayList<BoardNode> neighbours = boardNode1.getNeighbours();
        return neighbours.contains(boardNode2);
    }

    public void addTile(Tile tile, BoardNode boardNode) {
        if (boardNode.getTile().isEmpty()) {
            boardNode.setTile(tile);
            //System.out.println("BoardNode was set correctly");
            new BoardIsUpdatedEvent();
        }
    }

    public void addTile(Tile tile, BoardNode boardNode, boolean update) {
        if (boardNode.getTile().isEmpty()) {
            boardNode.setTile(tile);
            if (update)
                new BoardIsUpdatedEvent();
        }
    }

    public Board getClone() {
        ArrayList<BoardNode> boardNodes = new ArrayList<>();

        for (BoardNode boardNode : this.boardNodes) {
            boardNodes.add(boardNode.getClone());
        }
        return new Board(boardNodes, this.nodeCoord.clone());
    }

    public void doMove(Move move) {

        if(!move.isInverted()){
            this.getNode(move.getBoardNode().getX(),move.getBoardNode().getY()).setTile(move.getPiece().getHead());
            this.getNode(move.getBoardNode2().getX(),move.getBoardNode2().getY()).setTile(move.getPiece().getTail());
        }
        else{
            this.getNode(move.getBoardNode().getX(),move.getBoardNode().getY()).setTile(move.getPiece().getTail());
            this.getNode(move.getBoardNode2().getX(),move.getBoardNode2().getY()).setTile(move.getPiece().getHead());
        }

    }


}
