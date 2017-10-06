package tests;

import com.ingenious.models.board.Board;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;
import tests.impl.BoardTesting;

public class Tests {
    private static Tests instance = null;

    protected Tests() {

    }

    public static Tests getInstance() {
        if (instance == null) {
            instance = new Tests();
        }
        return instance;
    }

    /* ALL TESTS YOU WANT TO EXECUTE GO IN HERE */
    public void execute() {
        BoardTesting board = new BoardTesting();
        board.colorNeighbouringNodes(GameServiceProvider.board().getNode(0,0));


    }


}
