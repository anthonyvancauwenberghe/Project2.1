package tests.impl;

import com.ingenious.models.board.BoardNode;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

public class BoardTesting {

    public void lightUpAllNodes() {
        for (BoardNode boardNode : GameServiceProvider.board().getBoardNodes()) {
            if(boardNode.hasEmptyTile()){
                boardNode.setTile(Tile.blue);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boardNode.removeTile();
            }
        }
    }

    public void setTileOnCoordinate(int x, int y, Tile tile) {
        GameServiceProvider.board().getNode(x, y).setTile(tile);
    }

    public void colorNeighbouringNodes(BoardNode boardNode){
        ArrayList<BoardNode> neighbours =  boardNode.getNeighbours();
            for(BoardNode neighbour : neighbours){
                neighbour.setTile(Tile.red);
            }
    }

}
