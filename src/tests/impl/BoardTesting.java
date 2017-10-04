package tests.impl;

import com.ingenious.models.board.Node;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

public class BoardTesting {

    public void lightUpAllNodes() {
        for (Node node : GameServiceProvider.board().getNodes()) {
            System.out.println("Node id: " + GameServiceProvider.board().getNodes().indexOf(node));
            node.setTile(Tile.blue);
            GameServiceProvider.gui().repaintAll();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            node.removeTile();
        }
    }

}
