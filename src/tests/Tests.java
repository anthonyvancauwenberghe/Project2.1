package tests;

import com.ingenious.providers.impl.GameServiceProvider;
import tests.impl.BoardTesting;
import tests.impl.MonteCarloTesting;
import tests.impl.ScoreTesting;

public class Tests extends Thread {
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
    public void run() {
        MonteCarloTesting monteCarloTesting = new MonteCarloTesting();
        monteCarloTesting.run();
    }


}
