import com.ingenious.algorithms.impl.GenericTree;
import com.ingenious.algorithms.impl.State;
import com.ingenious.algorithms.impl.tree.Node;
import com.ingenious.algorithms.impl.tree.Tree;
import com.ingenious.algorithms.impl.tree.TreeFactory;
import com.ingenious.engine.Game;
import com.ingenious.providers.impl.GameServiceProvider;
import tests.Tests;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /* BOOT THE GAMESERVICE PROVIDER */
        GameServiceProvider.boot();
        //  GameServiceProvider.toState();


        Game state = GameServiceProvider.toState();

        TreeFactory treeFactory = new TreeFactory(state, 0);
        treeFactory.run();

        //ArrayList<Node> children = TreeFactory.generateNodes(1, GameServiceProvider.toState());
        //Tree tree = new Tree(state, children);


        /* INITIATE THE TESTS ON ANOTHER THREAD */
        // Tests.getInstance().start();

        //GenericTree tree = new GenericTree();
    }
}
