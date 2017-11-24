import com.ingenious.algorithms.impl.GenericTree;
import com.ingenious.providers.impl.GameServiceProvider;
import tests.Tests;

public class Main {
    public static void main(String[] args) throws InterruptedException {
         /* BOOT THE GAMESERVICE PROVIDER */
        GameServiceProvider.boot();


        /* INITIATE THE TESTS ON ANOTHER THREAD */
         Tests.getInstance().start();

        //GenericTree tree = new GenericTree();
    }
}
