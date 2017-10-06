package tests.impl;

import com.ingenious.models.board.Node;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

public class BoardTesting {

    public void lightUpAllNodes() {
        for (Node node : GameServiceProvider.board().getNodes()) {
            if(node.hasEmptyTile()){
                node.setTile(Tile.blue);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                node.removeTile();
            }

        }
    }

    public void setTileOnCoordinate(int x, int y, Tile tile) {
        GameServiceProvider.board().getNode(x, y).setTile(tile);
    }

    public void colorNeighbouringNodes(Node node){
        ArrayList<Node> neighbours =  node.getNeighbours();
            for(Node neighbour : neighbours){
                neighbour.setTile(Tile.red);
            }
    }

}
