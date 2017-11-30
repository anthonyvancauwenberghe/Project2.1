import com.ingenious.algorithms.impl.GenericTree;
import com.ingenious.algorithms.impl.State;
import com.ingenious.algorithms.impl.tree.Node;
import com.ingenious.algorithms.impl.tree.Tree;
import com.ingenious.algorithms.impl.tree.TreeFactory;
import com.ingenious.providers.impl.GameServiceProvider;
import tests.Tests;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
         /* BOOT THE GAMESERVICE PROVIDER */
        GameServiceProvider.boot();

        State state = GameServiceProvider.toState();
        ArrayList<Node> nodes = TreeFactory.generateNodes(1, GameServiceProvider.toState());

        Tree tree = new Tree(state, nodes);
        /* INITIATE THE TESTS ON ANOTHER THREAD */
        // Tests.getInstance().start();

        //GenericTree tree = new GenericTree();
    }
}
